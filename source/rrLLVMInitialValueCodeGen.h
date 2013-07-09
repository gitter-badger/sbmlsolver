/*
 * rrLLVMInitialValueCodeGen.h
 *
 *  Created on: Jun 29, 2013
 *      Author: andy
 */

#ifndef LLVMInitialValueCodeGenH
#define LLVMInitialValueCodeGenH

#include "rrLLVMModelGeneratorContext.h"
#include "rrLLVMCodeGenBase.h"
#include "rrLLVMSymbolForest.h"
#include "rrLLVMASTNodeFactory.h"
#include <sbml/Model.h>
#include <sbml/SBMLVisitor.h>

namespace rr
{
using libsbml::Model;
using libsbml::Compartment;
using libsbml::SBMLVisitor;
using libsbml::Species;
using libsbml::Parameter;


/**
 * Generates a function called 'modeldata_initialvalues_set', which evaluates
 * all of the initial conditions specified in the sbml model (initial values,
 * initial assigments, etc...) and stores these values in the appropriate
 * fields in the ModelData structure.
 *
 * generated function signature:
 * void modeldata_initialvalues_set(ModelData *);
 */
class LLVMInitialValueCodeGen: private SBMLVisitor, private LLVMCodeGenBase
{
    using SBMLVisitor::visit;

public:
    LLVMInitialValueCodeGen(const LLVMModelGeneratorContext &mgc);
    ~LLVMInitialValueCodeGen();

    llvm::Value *codeGen();

private:

    virtual bool visit(const Compartment &x);
    virtual bool visit(const Species &x);
    virtual bool visit(const Parameter &x);
    virtual bool visit (const libsbml::AssignmentRule  &x);
    virtual bool visit (const libsbml::InitialAssignment        &x);


    llvm::Function *initialValuesFunc;
    LLVMSymbolForest symbolForest;
    LLVMASTNodeFactory nodes;
};

} /* namespace rr */
#endif /* LLVMInitialValueCodeGenH */