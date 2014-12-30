/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.4
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.sbml.libsbml;

/** 
 *  An interface to an XML input stream.
 <p>
 * <p style='color: #777; font-style: italic'>
This class of objects is defined by libSBML only and has no direct
equivalent in terms of SBML components.  This class is not prescribed by
the SBML specifications, although it is used to implement features
defined in SBML.
</p>

 <p>
 * SBML content is serialized using XML; the resulting data can be stored and
 * read to/from a file or data stream.  Low-level XML parsers such as Xerces
 * provide facilities to read XML data.  To permit the use of different XML
 * parsers (Xerces, Expat or libxml2), libSBML implements an abstraction
 * layer.  {@link XMLInputStream} and {@link XMLOutputStream} are two parts of that
 * abstraction layer.
 <p>
 * {@link XMLInputStream} is an interface to a file or text string containing XML.
 * It wraps the content to be read, as well as the low-level XML parser to be
 * used and an {@link XMLErrorLog} to record errors and other issues (if any arise).
 * Internally, the content will be in the form of either a pointer to a file
 * name or a character string; {@link XMLInputStream} knows the form of the content
 * and acts appropriately.  Other libSBML object classes use {@link XMLInputStream}
 * as their interface for all read operations on the XML data.
 * {@link XMLInputStream} provides the functionality to extract data in the form of
 * {@link XMLToken} objects.  It logs any errors encountered while reading.  It also
 * keeps track of whether a read operation has failed irrecoverably or
 * determines whether it is safe to continue reading.
 <p>
 * {@link SBMLNamespaces} objects can be associated with an {@link XMLInputStream}; this
 * facilitates logging errors related to reading XML attributes and elements
 * that may only be relevant to particular Level and Version combinations of
 * SBML.
 <p>
 * @note The convenience of the {@link XMLInputStream} and {@link XMLOutputStream}
 * abstraction may be useful for developers interested in creating parsers
 * for other XML formats besides SBML.  It can provide developers with a
 * layer above more basic XML parsers, as well as some useful programmatic
 * elements such as {@link XMLToken}, {@link XMLError}, etc.
 <p>
 * @see XMLOutputStream
 */

public class XMLInputStream {
   private long swigCPtr;
   protected boolean swigCMemOwn;

   protected XMLInputStream(long cPtr, boolean cMemoryOwn)
   {
     swigCMemOwn = cMemoryOwn;
     swigCPtr    = cPtr;
   }

   protected static long getCPtr(XMLInputStream obj)
   {
     return (obj == null) ? 0 : obj.swigCPtr;
   }

   protected static long getCPtrAndDisown (XMLInputStream obj)
   {
     long ptr = 0;

     if (obj != null)
     {
       ptr             = obj.swigCPtr;
       obj.swigCMemOwn = false;
     }

     return ptr;
   }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        libsbmlJNI.delete_XMLInputStream(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  
/**
   * Creates a new {@link XMLInputStream}.
   <p>
   * @param content the source of the stream.
   <p>
   * @param isFile a boolean flag to indicate whether <code>content</code> is a file
   * name.  If <code>true</code>, <code>content</code> is assumed to be the file from which the
   * XML content is to be read.  If <code>false</code>, <code>content</code> is taken to be a
   * string that <em>is</em> the content to be read.
   <p>
   * @param library the name of the parser library to use.
   <p>
   * @param errorLog the {@link XMLErrorLog} object to use.
   <p>
   * 
</dl><dl class="docnote"><dt><b>Documentation note:</b></dt><dd>
The native C++ implementation of this method defines a default argument
value. In the documentation generated for different libSBML language
bindings, you may or may not see corresponding arguments in the method
declarations. For example, in Java and C#, a default argument is handled by
declaring two separate methods, with one of them having the argument and
the other one lacking the argument. However, the libSBML documentation will
be <em>identical</em> for both methods. Consequently, if you are reading
this and do not see an argument even though one is described, please look
for descriptions of other variants of this method near where this one
appears in the documentation.
</dd></dl>
 
   */ public
 XMLInputStream(String content, boolean isFile, String library, XMLErrorLog errorLog) {
    this(libsbmlJNI.new_XMLInputStream__SWIG_0(content, isFile, library, XMLErrorLog.getCPtr(errorLog), errorLog), true);
  }

  
/**
   * Creates a new {@link XMLInputStream}.
   <p>
   * @param content the source of the stream.
   <p>
   * @param isFile a boolean flag to indicate whether <code>content</code> is a file
   * name.  If <code>true</code>, <code>content</code> is assumed to be the file from which the
   * XML content is to be read.  If <code>false</code>, <code>content</code> is taken to be a
   * string that <em>is</em> the content to be read.
   <p>
   * @param library the name of the parser library to use.
   <p>
   * @param errorLog the {@link XMLErrorLog} object to use.
   <p>
   * 
</dl><dl class="docnote"><dt><b>Documentation note:</b></dt><dd>
The native C++ implementation of this method defines a default argument
value. In the documentation generated for different libSBML language
bindings, you may or may not see corresponding arguments in the method
declarations. For example, in Java and C#, a default argument is handled by
declaring two separate methods, with one of them having the argument and
the other one lacking the argument. However, the libSBML documentation will
be <em>identical</em> for both methods. Consequently, if you are reading
this and do not see an argument even though one is described, please look
for descriptions of other variants of this method near where this one
appears in the documentation.
</dd></dl>
 
   */ public
 XMLInputStream(String content, boolean isFile, String library) {
    this(libsbmlJNI.new_XMLInputStream__SWIG_1(content, isFile, library), true);
  }

  
/**
   * Creates a new {@link XMLInputStream}.
   <p>
   * @param content the source of the stream.
   <p>
   * @param isFile a boolean flag to indicate whether <code>content</code> is a file
   * name.  If <code>true</code>, <code>content</code> is assumed to be the file from which the
   * XML content is to be read.  If <code>false</code>, <code>content</code> is taken to be a
   * string that <em>is</em> the content to be read.
   <p>
   * @param library the name of the parser library to use.
   <p>
   * @param errorLog the {@link XMLErrorLog} object to use.
   <p>
   * 
</dl><dl class="docnote"><dt><b>Documentation note:</b></dt><dd>
The native C++ implementation of this method defines a default argument
value. In the documentation generated for different libSBML language
bindings, you may or may not see corresponding arguments in the method
declarations. For example, in Java and C#, a default argument is handled by
declaring two separate methods, with one of them having the argument and
the other one lacking the argument. However, the libSBML documentation will
be <em>identical</em> for both methods. Consequently, if you are reading
this and do not see an argument even though one is described, please look
for descriptions of other variants of this method near where this one
appears in the documentation.
</dd></dl>
 
   */ public
 XMLInputStream(String content, boolean isFile) {
    this(libsbmlJNI.new_XMLInputStream__SWIG_2(content, isFile), true);
  }

  
/**
   * Creates a new {@link XMLInputStream}.
   <p>
   * @param content the source of the stream.
   <p>
   * @param isFile a boolean flag to indicate whether <code>content</code> is a file
   * name.  If <code>true</code>, <code>content</code> is assumed to be the file from which the
   * XML content is to be read.  If <code>false</code>, <code>content</code> is taken to be a
   * string that <em>is</em> the content to be read.
   <p>
   * @param library the name of the parser library to use.
   <p>
   * @param errorLog the {@link XMLErrorLog} object to use.
   <p>
   * 
</dl><dl class="docnote"><dt><b>Documentation note:</b></dt><dd>
The native C++ implementation of this method defines a default argument
value. In the documentation generated for different libSBML language
bindings, you may or may not see corresponding arguments in the method
declarations. For example, in Java and C#, a default argument is handled by
declaring two separate methods, with one of them having the argument and
the other one lacking the argument. However, the libSBML documentation will
be <em>identical</em> for both methods. Consequently, if you are reading
this and do not see an argument even though one is described, please look
for descriptions of other variants of this method near where this one
appears in the documentation.
</dd></dl>
 
   */ public
 XMLInputStream(String content) {
    this(libsbmlJNI.new_XMLInputStream__SWIG_3(content), true);
  }

  
/**
   * Returns the encoding of the XML stream.
   <p>
   * <p>
 The <em>encoding</em> is indicated by the <code>xml</code> declaration at the
 * beginning of an XML document or data stream.  The form of this declaration
 * is
 * <pre class='fragment'>
&lt;?xml version='1.0' encoding='UTF-8'?&gt;
</pre>
 * Note that the SBML specifications require the use of UTF-8 encoding, so
 * for SBML documents, the value returned by this method will always be
 * the string <code>'UTF-8'</code>. 
   <p>
   * @return the encoding of the XML stream.
   <p>
   * @see #getVersion()
   */ public
 String getEncoding() {
    return libsbmlJNI.XMLInputStream_getEncoding(swigCPtr, this);
  }

  
/**
   * Returns the version of the XML stream.
   <p>
   * <p>
 The <em>version</em> is indicated by the <code>xml</code> declaration at the
 * beginning of an XML document or data stream.  The form of this declaration
 * is
 * <pre class='fragment'>
 &lt;?xml version='1.0' encoding='UTF-8'?&gt;
</pre>
 * Note that the SBML specifications require the use of version 1.0, so
 * for SBML documents, the value returned by this method will always be
 * the string <code>'1.0'</code>. 
   <p>
   * @return the version of the XML stream.
   <p>
   * @see #getEncoding()
   */ public
 String getVersion() {
    return libsbmlJNI.XMLInputStream_getVersion(swigCPtr, this);
  }

  
/**
   * Returns the {@link XMLErrorLog} used to log parsing problems.
   <p>
   * @return the {@link XMLErrorLog} used to log XML parse errors and other
   * validation errors (and messages).
   */ public
 XMLErrorLog getErrorLog() {
    long cPtr = libsbmlJNI.XMLInputStream_getErrorLog(swigCPtr, this);
    return (cPtr == 0) ? null : new XMLErrorLog(cPtr, false);
  }

  
/**
   * Returns <code>true</code> if end of file (stream) has been reached.
   <p>
   * @return <code>true</code> if end of file (stream) has been reached, <code>false</code>
   * otherwise.
   */ public
 boolean isEOF() {
    return libsbmlJNI.XMLInputStream_isEOF(swigCPtr, this);
  }

  
/**
   * Returns <code>true</code> if a fatal error occurred while reading from this
   * stream.
   <p>
   * @return <code>true</code> if a fatal error occurred while reading from this
   * stream.
   */ public
 boolean isError() {
    return libsbmlJNI.XMLInputStream_isError(swigCPtr, this);
  }

  
/**
   * Returns <code>true</code> if the stream is in a good state.
   <p>
   * The definition of 'good state' is that isEOF() and isError() both return
   * <code>false.</code>
   <p>
   * @return <code>true</code> if the stream is in a good state, <code>false</code> otherwise.
   */ public
 boolean isGood() {
    return libsbmlJNI.XMLInputStream_isGood(swigCPtr, this);
  }

  
/**
   * Returns the next token on this XML input stream.
   <p>
   * The token is consumed in the process.
   <p>
   * @return the next {@link XMLToken}, or an EOF token (i.e.,
   * <code>XMLToken.isEOF() == true</code>).
   <p>
   * @see #peek()
   */ public
 XMLToken next() {
    return new XMLToken(libsbmlJNI.XMLInputStream_next(swigCPtr, this), true);
  }

  
/**
   * Returns the next token <em>without</em> consuming it.
   <p>
   * A subsequent call to either peek() or next() will return the same token.
   <p>
   * @return the next {@link XMLToken} or EOF (XMLToken.isEOF() == true).
   <p>
   * @see #next()
   */ public
 XMLToken peek() {
    return new XMLToken(libsbmlJNI.XMLInputStream_peek(swigCPtr, this), false);
  }

  
/**
   * Consume zero or more tokens up to and including the corresponding end
   * element or EOF.
   <p>
   * @param element the element whose end will be sought in the input stream.
   */ public
 void skipPastEnd(XMLToken element) {
    libsbmlJNI.XMLInputStream_skipPastEnd(swigCPtr, this, XMLToken.getCPtr(element), element);
  }

  
/**
   * Consume zero or more tokens up to but not including the next XML element
   * or EOF.
   */ public
 void skipText() {
    libsbmlJNI.XMLInputStream_skipText(swigCPtr, this);
  }

  
/**
   * Sets the {@link XMLErrorLog} this stream will use to log errors.
   <p>
   * <p>
 * @return integer value indicating success/failure of the
 * function.   The possible values
 * returned by this function are:
   * <ul>
   * <li> {@link libsbmlConstants#LIBSBML_OPERATION_SUCCESS LIBSBML_OPERATION_SUCCESS}
   * <li> {@link libsbmlConstants#LIBSBML_OPERATION_FAILED LIBSBML_OPERATION_FAILED}
   * </ul>
   */ public
 int setErrorLog(XMLErrorLog log) {
    return libsbmlJNI.XMLInputStream_setErrorLog(swigCPtr, this, XMLErrorLog.getCPtr(log), log);
  }

  
/**
   * Prints a string representation of the underlying token stream.
   <p>
   * @return a string representing the underlying XML token stream.
   <p>
   * @note This method is intended for debugging purposes.
   */ public
 String toString() {
    return libsbmlJNI.XMLInputStream_toString(swigCPtr, this);
  }

  
/**
   * Returns the {@link SBMLNamespaces} object attached to this {@link XMLInputStream}.
   <p>
   * @return the {@link SBMLNamespaces} object or <code>null</code> if none has been set.
   */ public
 SBMLNamespaces getSBMLNamespaces() {
  return libsbml.DowncastSBMLNamespaces(libsbmlJNI.XMLInputStream_getSBMLNamespaces(swigCPtr, this), false);
}

  
/**
   * Sets the SBML namespaces associated with this XML input stream.
   <p>
   * This allows this stream to reference the available SBML namespaces being
   * read.
   <p>
   * @param sbmlns the list of namespaces to use.
   */ public
 void setSBMLNamespaces(SBMLNamespaces sbmlns) {
    libsbmlJNI.XMLInputStream_setSBMLNamespaces(swigCPtr, this, SBMLNamespaces.getCPtr(sbmlns), sbmlns);
  }

  
/**
   * Returns the number of child tokens of the given element in this stream.
   <p>
   * This method allows information from the input stream to be determined
   * without the need to actually read and consume the tokens in the stream.
   * It returns the number of child elements of the element represented by
   * the <code>elementName</code>, i.e., the number of child elements encountered
   * before the closing tag for the <code>elementName</code> supplied.
   <p>
   * If no <code>elementName</code> is supplied or it is an empty string, then as a
   * special case, this method assumes the element is a MathML
   * <code>apply</code> element followed by a function name.
   <p>
   * @param elementName a string representing the name of the element for
   * which the number of children are to be determined.
   <p>
   * @return a long integer giving the number of children of the 
   * <code>elementName</code> specified.
   <p>
   * @note This method assumes the stream has been read up to and including
   * the element <code>elementName</code>.
   <p>
   * 
</dl><dl class="docnote"><dt><b>Documentation note:</b></dt><dd>
The native C++ implementation of this method defines a default argument
value. In the documentation generated for different libSBML language
bindings, you may or may not see corresponding arguments in the method
declarations. For example, in Java and C#, a default argument is handled by
declaring two separate methods, with one of them having the argument and
the other one lacking the argument. However, the libSBML documentation will
be <em>identical</em> for both methods. Consequently, if you are reading
this and do not see an argument even though one is described, please look
for descriptions of other variants of this method near where this one
appears in the documentation.
</dd></dl>
 
   */ public
 long determineNumberChildren(String elementName) {
    return libsbmlJNI.XMLInputStream_determineNumberChildren__SWIG_0(swigCPtr, this, elementName);
  }

  
/**
   * Returns the number of child tokens of the given element in this stream.
   <p>
   * This method allows information from the input stream to be determined
   * without the need to actually read and consume the tokens in the stream.
   * It returns the number of child elements of the element represented by
   * the <code>elementName</code>, i.e., the number of child elements encountered
   * before the closing tag for the <code>elementName</code> supplied.
   <p>
   * If no <code>elementName</code> is supplied or it is an empty string, then as a
   * special case, this method assumes the element is a MathML
   * <code>apply</code> element followed by a function name.
   <p>
   * @param elementName a string representing the name of the element for
   * which the number of children are to be determined.
   <p>
   * @return a long integer giving the number of children of the 
   * <code>elementName</code> specified.
   <p>
   * @note This method assumes the stream has been read up to and including
   * the element <code>elementName</code>.
   <p>
   * 
</dl><dl class="docnote"><dt><b>Documentation note:</b></dt><dd>
The native C++ implementation of this method defines a default argument
value. In the documentation generated for different libSBML language
bindings, you may or may not see corresponding arguments in the method
declarations. For example, in Java and C#, a default argument is handled by
declaring two separate methods, with one of them having the argument and
the other one lacking the argument. However, the libSBML documentation will
be <em>identical</em> for both methods. Consequently, if you are reading
this and do not see an argument even though one is described, please look
for descriptions of other variants of this method near where this one
appears in the documentation.
</dd></dl>
 
   */ public
 long determineNumberChildren() {
    return libsbmlJNI.XMLInputStream_determineNumberChildren__SWIG_1(swigCPtr, this);
  }

  
/**
   * Returns the number of child tokens of the specified type within a
   * given container element.
   <p>
   * This method allows information from the input stream to be determined
   * without the need to actually read and consume the tokens in the stream.
   * It returns the number of child elements of the <code>childName</code> element
   * within the element specified by <code>container</code>.  In other words, it counts
   * the number of <code>childName</code> elements encountered before the closing tag
   * for the <code>container</code> supplied.
   <p>
   * @param childName a string representing the name of the child
   * element whose number is to be determined.
   <p>
   * @param container a string representing the name of the element
   * for which the number of children are to be determined.
   <p>
   * @return a long integer giving the number of children of type 
   * <code>childName</code> within the <code>container</code> element.
   <p>
   * @note This method assumes the stream has been read up to and including
   * the element <code>container</code>.
   */ public
 long determineNumSpecificChildren(String childName, String container) {
    return libsbmlJNI.XMLInputStream_determineNumSpecificChildren(swigCPtr, this, childName, container);
  }

}