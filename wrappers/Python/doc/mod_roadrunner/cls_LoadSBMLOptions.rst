SBML Compile Options
_______________________________

.. class:: LoadSBMLOptions()
   :module: roadrunner

   The LoadSBMLOptions object allows tuning a variety of SBML loading and compilations options.
   
   This object can be passed in as the second, optional argument of the :meth:`RoadRunner.__init__()`
   constructor, or  the :meth:`RoadRunner.load()` method.


.. attribute:: LoadSBMLOptions.conservedMoieties
   :module: roadrunner
   :annotation: bool

   perform conservation analysis.
      
   This causes a re-ordering of the species, so results generated
   with this flag enabled can not be compared index wise to results
   generated otherwise.

   Moiety conservation is only compatable with simple models which do NOT have any events or rules
   which define or alter any floating species, and which have simple constant stiochiometries. 
  

.. attribute:: LoadSBMLOptions.mutableInitialConditions
   :module: roadrunner
   :annotation: bool

   Generate accessor functions to allow changing of initial
   conditions.


.. attribute:: LoadSBMLOptions.noDefaultSelections
   :module: roadrunner
   :annotation: bool

   Do not create a default selection list when the model is loaded.

.. attribute:: LoadSBMLOptions.readOnly
   :module: roadrunner
   :annotation: bool

   Should the model be recompiled?
   The LLVM ModelGenerator maintins a hash table of currently running
   models. If this flag is NOT set, then the generator will look to see
   if there is already a running instance of the given model and
   use the generated code from that one.
  
   If only a single instance of a model is run, there is no
   need to cache the models, and this can safetly be enabled,
   realizing some performance gains.


.. attribute:: LoadSBMLOptions.recompile
   :module: roadrunner
   :annotation: bool

   If this is set, then a read-only model is generated. A read-only
   model can be simulated, but no code is generated to set model
   values, i.e. parameters, amounts, values, etc...
  
   It takes a finite amount of time to generate the model value setting
   functions, and if they are not needed, one may see some performance
   gains, especially in very large models.

