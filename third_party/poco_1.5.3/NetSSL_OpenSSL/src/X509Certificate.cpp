//
// X509Certificate.cpp
//
// $Id: //poco/1.4/NetSSL_OpenSSL/src/X509Certificate.cpp#3 $
//
// Library: NetSSL_OpenSSL
// Package: SSLCore
// Module:  X509Certificate
//
// Copyright (c) 2006-2009, Applied Informatics Software Engineering GmbH.
// and Contributors.
//
// Permission is hereby granted, free of charge, to any person or organization
// obtaining a copy of the software and accompanying documentation covered by
// this license (the "Software") to use, reproduce, display, distribute,
// execute, and transmit the Software, and to prepare derivative works of the
// Software, and to permit third-parties to whom the Software is furnished to
// do so, all subject to the following:
// 
// The copyright notices in the Software and this entire statement, including
// the above license grant, this restriction and the following disclaimer,
// must be included in all copies of the Software, in whole or in part, and
// all derivative works of the Software, unless such copies or derivative
// works are solely in the form of machine-executable object code generated by
// a source language processor.
// 
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE, TITLE AND NON-INFRINGEMENT. IN NO EVENT
// SHALL THE COPYRIGHT HOLDERS OR ANYONE DISTRIBUTING THE SOFTWARE BE LIABLE
// FOR ANY DAMAGES OR OTHER LIABILITY, WHETHER IN CONTRACT, TORT OR OTHERWISE,
// ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
// DEALINGS IN THE SOFTWARE.
//


#include "Poco/Net/X509Certificate.h"
#include "Poco/Net/SSLException.h"
#include "Poco/Net/SSLManager.h"
#include "Poco/Net/DNS.h"
#include "Poco/TemporaryFile.h"
#include "Poco/FileStream.h"
#include "Poco/StreamCopier.h"
#include "Poco/String.h"
#include "Poco/RegularExpression.h"
#include "Poco/DateTimeParser.h"
#include <openssl/pem.h>
#include <openssl/x509v3.h>
#include <openssl/err.h>


namespace Poco {
namespace Net {


X509Certificate::X509Certificate(std::istream& istr):
	Poco::Crypto::X509Certificate(istr)
{	
}


X509Certificate::X509Certificate(const std::string& path):
	Poco::Crypto::X509Certificate(path)
{
}


X509Certificate::X509Certificate(X509* pCert):
	Poco::Crypto::X509Certificate(pCert)
{
}


X509Certificate::X509Certificate(X509* pCert, bool shared):
	Poco::Crypto::X509Certificate(pCert, shared)
{
}


X509Certificate::X509Certificate(const Poco::Crypto::X509Certificate& cert):
	Poco::Crypto::X509Certificate(cert)
{
}


X509Certificate& X509Certificate::operator = (const Poco::Crypto::X509Certificate& cert)
{
	X509Certificate tmp(cert);
	swap(tmp);
	return *this;
}


X509Certificate::~X509Certificate()
{
}


bool X509Certificate::verify(const std::string& hostName) const
{
	return verify(*this, hostName);
}


bool X509Certificate::verify(const Poco::Crypto::X509Certificate& certificate, const std::string& hostName)
{		
	std::string commonName;
	std::set<std::string> dnsNames;
	certificate.extractNames(commonName, dnsNames);
	if (!commonName.empty()) dnsNames.insert(commonName);
	bool ok = (dnsNames.find(hostName) != dnsNames.end());
	if (!ok)
	{
		for (std::set<std::string>::const_iterator it = dnsNames.begin(); !ok && it != dnsNames.end(); ++it)
		{
			try
			{
				// two cases: strData contains wildcards or not
				if (containsWildcards(*it))
				{
					// a compare by IPAddress is not possible with wildcards
					// only allow compare by name
					ok = matchByAlias(*it, hostName);
				}
				else
				{
					// it depends on hostName if we compare by IP or by alias
					IPAddress ip;
					if (IPAddress::tryParse(hostName, ip))
					{
						// compare by IP
						const HostEntry& heData = DNS::resolve(*it);
						const HostEntry::AddressList& addr = heData.addresses();
						HostEntry::AddressList::const_iterator it = addr.begin();
						HostEntry::AddressList::const_iterator itEnd = addr.end();
						for (; it != itEnd && !ok; ++it)
						{
							ok = (*it == ip);
						}
					}
					else
					{
						// compare by name
						ok = matchByAlias(*it, hostName);
					}
				}
			}
			catch (HostNotFoundException&)
			{
			}
		}
	}
	return ok;
}


bool X509Certificate::containsWildcards(const std::string& commonName)
{
	return (commonName.find('*') != std::string::npos || commonName.find('?') != std::string::npos);
}


bool X509Certificate::matchByAlias(const std::string& alias, const std::string& hostName)
{
	const HostEntry& heData = DNS::resolve(hostName);
	// fix wildcards
	std::string aliasRep = Poco::replace(alias, ".", "\\.");
	Poco::replaceInPlace(aliasRep, "*", ".*");
	Poco::replaceInPlace(aliasRep, "..*", ".*");
	Poco::replaceInPlace(aliasRep, "?", ".?");
	Poco::replaceInPlace(aliasRep, "..?", ".?");
	// compare by name
	Poco::RegularExpression expr(aliasRep);
	bool found = false;
	const HostEntry::AliasList& aliases = heData.aliases();
	HostEntry::AliasList::const_iterator it = aliases.begin();
	HostEntry::AliasList::const_iterator itEnd = aliases.end();
	for (; it != itEnd && !found; ++it)
	{
		found = expr.match(*it);
	}
	// Handle the case where the list of aliases is empty.
	if (!found)
	{
		// Compare the resolved host name against the wildcard host name in the certificate.
		found = expr.match(heData.name());
	}
	if (!found)
	{
		// Compare the original host name against the wildcard host name in the certificate.
		found = expr.match(hostName);
	}
	return found;
}


} } // namespace Poco::Net
