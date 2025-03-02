package Utilities;

import java.util.ArrayList;

import fr.lip6.meta.ComplexChangeDetection.Change;
import fr.lip6.meta.ComplexChangeDetection.AtomicChanges.AddClass;
import fr.lip6.meta.ComplexChangeDetection.AtomicChanges.AddProperty;
import fr.lip6.meta.ComplexChangeDetection.AtomicChanges.AddSuperType;
import fr.lip6.meta.ComplexChangeDetection.AtomicChanges.ChangeLowerBound;
import fr.lip6.meta.ComplexChangeDetection.AtomicChanges.ChangeUpperBound;
import fr.lip6.meta.ComplexChangeDetection.AtomicChanges.DeleteClass;
import fr.lip6.meta.ComplexChangeDetection.AtomicChanges.DeleteProperty;
import fr.lip6.meta.ComplexChangeDetection.AtomicChanges.DeleteSuperType;
import fr.lip6.meta.ComplexChangeDetection.AtomicChanges.RenameClass;
import fr.lip6.meta.ComplexChangeDetection.AtomicChanges.RenameProperty;
import fr.lip6.meta.ComplexChangeDetection.AtomicChanges.SetProperty;
import fr.lip6.meta.ComplexChangeDetection.ComplexChanges.ComplexChange;
import fr.lip6.meta.ComplexChangeDetection.ComplexChanges.ExtractClass;
import fr.lip6.meta.ComplexChangeDetection.ComplexChanges.ExtractSuperClass;
import fr.lip6.meta.ComplexChangeDetection.ComplexChanges.MoveProperty;
import fr.lip6.meta.ComplexChangeDetection.ComplexChanges.PullProperty;
import fr.lip6.meta.ComplexChangeDetection.ComplexChanges.PushProperty;

public class ChangeDetection {
	public static ArrayList<Change> initializeChangements()
	{
		ArrayList<Change> changes = new ArrayList<Change>();
		/* Papyrus begin */
	/*	ArrayList<String> subclasses = new ArrayList<String>();				
		subclasses.add("ViewTypeConfiguration");		
				
		PushProperty pup1 = new PushProperty("specializedDiagramTypeID", "ExtendedElementTypeConfiguration", subclasses);		
		changes.add(pup1);		
				
		ArrayList<String> subclasses0 = new ArrayList<String>();		
		subclasses0.add("ActionConfiguration");		
				
		ArrayList<String> subclasses1 = new ArrayList<String>();		
		subclasses1.add("ExtendedElementTypeConfiguration");		
				
		PullProperty pp1 = new PullProperty("label", "ConfigurationElement", subclasses0); //before its rename below		
		PullProperty pp2 = new PullProperty("name", "ConfigurationElement", subclasses1);		
		PullProperty pp3 = new PullProperty("iconEntry", "ConfigurationElement", subclasses1);		
				
				
		changes.add(pp1);		
		changes.add(pp2);		
		changes.add(pp3);		
		RenameProperty rp1 = new RenameProperty("id", "identifier", "ConfigurationElement"); //after its extract to super class from 3 subclasses 		
		RenameProperty rp2 = new RenameProperty("label", "description", "ConfigurationElement"); //after its pull from ActionConfiguration		
				
		changes.add(rp1);		
		changes.add(rp2);	
				
		ArrayList<ComplexChange> pulls = new ArrayList<ComplexChange>();		
				
		ArrayList<String> subclasses2 = new ArrayList<String>();		
		subclasses2.add("ExtendedElementTypeSet");		
		subclasses2.add("ActionConfiguration");		
		subclasses2.add("ExtendedElementTypeConfiguration");		
				
		PullProperty pp4 = new PullProperty("id", "ConfigurationElement", subclasses2); //before its rename below		
				
		pulls.add(pp4);		
				
		ExtractSuperClass esc = new ExtractSuperClass("", "ConfigurationElement", subclasses2, null, pulls);		
		changes.add(esc);		
				
				
		RenameClass rc1 = new RenameClass("ExtendedElementTypeConfiguration", "ElementTypeConfiguration", "");		
		RenameClass rc2 = new RenameClass("PreActionConfiguration", "ViewActionConfiguration", "");		
		RenameClass rc3 = new RenameClass("PostActionConfiguration", "SemanticActionConfiguration", "");		
				
		changes.add(rc1);		
		changes.add(rc2);		
		changes.add(rc3);		
				
		
				
				
		DeleteProperty dp1 = new DeleteProperty("postAction", "ExtendedElementTypeConfiguration"); //after the class rename 		
		DeleteProperty dp2 = new DeleteProperty("preAction", "ExtendedElementTypeConfiguration");		
		DeleteProperty dp3 = new DeleteProperty("preValidation", "ExtendedElementTypeConfiguration");		
				
		changes.add(dp1);		
		changes.add(dp2);		
		changes.add(dp3);		
				
				*/
				/* Papyrus end */
		/* Pivot starts */
	/*	ArrayList<String> subclasses1 = new ArrayList<String>();
		subclasses1.add("NamedElement");
		
		PullProperty pp1 = new PullProperty("ownedAnnotation", "Element", subclasses1);
		changes.add(pp1);
		
		ArrayList<String> subclasses2 = new ArrayList<String>();
		subclasses2.add("Namespace");

		PushProperty pup1 = new PushProperty("ownedRule", "NamedElement", subclasses2); 
		
		changes.add(pup1);
		
		ArrayList<String> subclasses3 = new ArrayList<String>();
		subclasses3.add("Library");
		
		PushProperty pup2 = new PushProperty("ownedPrecedence", "Package", subclasses3);
		
		changes.add(pup2);
		
		RenameClass rc1 = new RenameClass("ClassifierType", "Metaclass", "");
		
		changes.add(rc1);
		

		RenameProperty rp1 = new RenameProperty("valueExpression", "expressionInOCL", "OpaqueExpression");		
		RenameProperty rp2 = new RenameProperty("resolveSelfType", "specializeIn", "Type"); //has an added param (selfType expr)
		RenameProperty rp3 = new RenameProperty("resolveSelfType", "specializeIn", "SelfType"); //has an added param (selfType expr)
		RenameProperty rp4 = new RenameProperty("association", "associationClass", "Property");
		
		RenameProperty rp5 = new RenameProperty("CompatibleInitialiser", "CompatibleDefaultExpression", "Porperty");//this is in the metamodel, btu weirdly, in the code they changed it manually, see change below in case you need it rather than this one
		//RenameProperty rp5 = new RenameProperty("validateCompatibleInitialiser", "validateCompatibleDefaultExpression", "Porperty"); //CompatibleInitialiser (validateCompatibleInitialiser in code) to CompatibleDefaultExpression (validateCompatibleDefaultExpression in code)
		
		changes.add(rp1);
		changes.add(rp2);
		changes.add(rp3);
		changes.add(rp4);
		changes.add(rp5);
		
		//here if the infos in the two changes are not sufficient, we can improve the change and add missing infos, i put them in comments below
		SetProperty sp1 = new SetProperty("stereotype","Type","Stereotype", false); //stereotype : from Type to Stereotype (passing by Class), in ElementExtension 
		SetProperty sp2 = new SetProperty("specification","ValueSpecification", "OpaqueExpression", false); //specification : from ValueSpecification to OpaqueExpression, in Constraint 
		
		SetProperty sp3 = new SetProperty("context", "NamedElement","Namespace", false); // context : from NamedElement to Namespace, in Constraint
		SetProperty sp4 = new SetProperty("ownedAnnotation", "Annotations","Element", false); // ownedAnnotation : from Annotations to Element, in Element pulled from NamedElement 
		
		changes.add(sp1);
		changes.add(sp2);
		changes.add(sp3);
		changes.add(sp4);
		
		
		ChangeLowerBound clb1 = new ChangeLowerBound("specification", "Constraint", "1", "0");
		ChangeLowerBound clb2 = new ChangeLowerBound("ownedParameter", "TemplateSignature", "0", "1");
		
		DeleteProperty dp1 = new DeleteProperty("upper", "MultiplicityElement"); 
		DeleteProperty dp2 = new DeleteProperty("lower", "MultiplicityElement");
		DeleteProperty dp3 = new DeleteProperty("isUnique", "MultiplicityElement");
		DeleteProperty dp4 = new DeleteProperty("isOrdered", "MultiplicityElement");
		DeleteProperty dp5 = new DeleteProperty("includesMultiplicity", "MultiplicityElement");
		DeleteProperty dp6 = new DeleteProperty("includesCardinality", "MultiplicityElement");
		DeleteProperty dp7 = new DeleteProperty("isMultivalued", "MultiplicityElement");
		DeleteProperty dp8 = new DeleteProperty("upperBound", "MultiplicityElement");
		DeleteProperty dp9 = new DeleteProperty("lowerBound", "MultiplicityElement");
		
		DeleteProperty dp10 = new DeleteProperty("not_own_self", "Element");
		DeleteProperty dp11 = new DeleteProperty("stereotype", "Constraint");
		DeleteProperty dp12 = new DeleteProperty("messageExpression", "ExpressionInOCL");
		DeleteProperty dp13 = new DeleteProperty("message", "OpaqueExpression");
		DeleteProperty dp14 = new DeleteProperty("parameter", "TemplateSignature");
		
		changes.add(dp1);
		changes.add(dp2);
		changes.add(dp3);
		changes.add(dp4);
		changes.add(dp5);
		changes.add(dp6);
		changes.add(dp7);
		changes.add(dp8);
		changes.add(dp9);
		changes.add(dp10);
		changes.add(dp11);
		changes.add(dp12);
		changes.add(dp13);
		changes.add(dp14);
		
		DeleteClass dc1 = new DeleteClass("MultiplicityElement");		
		DeleteClass dc2 = new DeleteClass("Model");
		DeleteClass dc3 = new DeleteClass("Int");
		
		changes.add(dc1);
		changes.add(dc2);
		changes.add(dc3);
			
		*/
		
		
			/* Pivot ends */
		//RenameClass renameClass3 = new RenameClass("Person","Contact","???"); 
		//RenameClass renameClass1 = new RenameClass("Loc","Address","???"); 
		//RenameProperty renameProperty1 = new RenameProperty("lower","lowertoto","CollectionType"); 
		//RenameProperty renameProperty2 = new RenameProperty("value","valuetata","ShadowExp"); 
	
		// RenameProperty renameProperty4 = new RenameProperty("validateHasNoInitializer","validateHasNoInitializertoto","ParameterVariable"); 
		 //RenameProperty renameProperty5 = new RenameProperty("validateTypeIsNotInvalid","validateTypeIsNotInvalidtiti","CollectionLiteralPart"); 
		 //RenameProperty renameProperty6 = new RenameProperty("validateCompatibleInitializerType","validateCompatibleInitializerTypetata","Variable"); 

		//RenameProperty renameProperty = new RenameProperty("getList","getSortedList","???");
		// RenameProperty renameProperty1 = new RenameProperty("Num","Number","???");
		// RenameProperty renameProperty1 = new RenameProperty("isImplicit","isImplicittoto","Property"); 
		//	RenameClass renameClass = new RenameClass("BagType","BagTypetoto","org.eclipse.ocl.pivot"); 
		//RenameClass renameClass = new RenameClass("SelfType","SelfTypetoto","org.eclipse.ocl.pivot"); 
		//RenameClass renameClass2= new RenameClass("Annotation","Annotationtoto","org.eclipse.ocl.pivot"); 
		//DeleteProperty deleteProperty = new DeleteProperty("test","UseBookAddress");
		
	//	MoveProperty moveProperty = new MoveProperty("isInvalidating","Operation","LanguageExpression");
		//moveProperty.setThroughReference("bodyExpression");
		//DeleteClass deleteClass =  new DeleteClass("Address");
	//	DeleteClass deleteClass1 =  new DeleteClass("SelfType");
		//MoveProperty moveProperty = new MoveProperty("URI","Package","ProfileApplication");
		//moveProperty.setThroughReference("ownedProfileApplications");
		//moveProperty.setImportPath("org.eclipse.ocl.pivot.ProfileApplication");

		//moveProperty.setUpperBound(-1);
	//	DeleteClass deleteClass1 =  new DeleteClass("SelfType");
		//DeleteClass deleteClass2 =  new DeleteClass("VoidType");
		
		/*DeleteProperty deleteProperty = new DeleteProperty("validateSafeSourceCanBeNull","CallExp");
		DeleteProperty deleteProperty1 = new DeleteProperty("instanceClassName","Class");
		DeleteProperty deleteProperty2= new DeleteProperty("OwnedLiterals","Enumeration");

		DeleteProperty deleteProperty3 = new DeleteProperty("isSafe","CallExp");
		DeleteProperty deleteProperty4 = new DeleteProperty("externalURI","Model");
*/
		/*RenameClass renameClass1 = new RenameClass("SelfType","SelfTypetoto","org.eclipse.ocl.pivot"); 

		 RenameProperty renameProperty1 = new RenameProperty("validateHasNoInitializer","validateHasNoInitializertoto","ParameterVariable"); 
		 RenameProperty renameProperty2 = new RenameProperty("validateTypeIsNotInvalid","validateTypeIsNotInvalidtiti","CollectionLiteralPart"); 
		 RenameProperty renameProperty3 = new RenameProperty("validateCompatibleInitializerType","validateCompatibleInitializerTypetata","Variable"); 

		 MoveProperty moveProperty1 = new MoveProperty("isInvalidating","Operation","LanguageExpression");
		 moveProperty1.setThroughReference("bodyExpression");
		 */
	/*	DeleteClass deleteClass1 =  new DeleteClass("ReferenceCS");
		RenameClass renameClass1 = new RenameClass("FeatureCS","FeatureCSTOTO","org.eclipse.ocl.BaseCS"); 

		
		DeleteProperty deleteProperty1 = new DeleteProperty("getDescription","ElementCS");


		MoveProperty moveProperty1 = new MoveProperty("name","LambdaTypeCS","TypeRefCS");
		moveProperty1.setThroughReference("ownedParameterTypes");
		moveProperty1.setImportPath("org.eclipse.ocl.xtext.basecs.TypedRefCS");
		moveProperty1.setUpperBound(-1);
		*/
		
	//	ArrayList<String> subClassesNames = new ArrayList<String>();
		//subClassesNames.add("BagType");
		//subClassesNames.add("OrderedSetType");
		//subClassesNames.add("SequenceType");
		//subClassesNames.add("SetType");
	/*	ArrayList<String> subClass = new ArrayList<String>();
	    subClass.add("SetType");
	    subClass.add("OrderedSetType");
	    subClass.add("SequenceType");
	    subClass.add("BagType");
		PushProperty pushproperty = new PushProperty("upper","CollectionType",subClass);
		subClass = new ArrayList<String>();
	    subClass.add("FinalState");
		
		PushProperty pushproperty2 = new PushProperty("isComposite","State",subClass);
		*/	
		//ChangeUpperBound changeUpperBound = new ChangeUpperBound("generalization","AssociationClass","1","-1");
		//ChangeUpperBound changeUpperBound1 = new ChangeUpperBound("generalization1","EnumerationLiteral","1","-1");
		//ChangeUpperBound changeUpperBound2 = new ChangeUpperBound("generalization2","Stereotype","1","-1");
		//SetProperty setProperty1 = new SetProperty("setProperty1", "Type", "BagType", false);
		//SetProperty setProperty2 = new SetProperty("setProperty1", "Variable", "Enumeration", false);
		
		
	/*	changes.add(deleteProperty);
		changes.add(deleteProperty1);
		//changes.add(renameProperty3);
		changes.add(deleteProperty2);
		changes.add(deleteProperty3);
		changes.add(deleteProperty4);
		*/
		//  changes.add(renameClass); 
		//changes.add(renameClass2);

		//  changes.add(renameClass1);
		 //changes.add(renameClass);
		 //changes.add(renameClass3);
		// changes.add(renameProperty);
		//changes.add(renameProperty1);
		//changes.add(deleteClass);
		//changes.add(deleteProperty);
		//changes.add(moveProperty);

		/*	 	changes.add(deleteClass1);
	 	changes.add(deleteClass2);

	 	changes.add(deleteProperty1);
	 	changes.add(deleteProperty2);

	 	 changes.add(renameClass1);

	 	changes.add(renameProperty1);
	 	changes.add(renameProperty2);
	 	changes.add(renameProperty3);

	 	changes.add(moveProperty1);
		 */

	
		/*changes.add(renameClass1);
		changes.add(renameProperty1);
		changes.add(renameProperty2);
		changes.add(renameProperty3);

		changes.add(deleteProperty1);

		changes.add(moveProperty1);
*/
		//changes.add(pushproperty);
		//changes.add(pushproperty2);
	//	changes.add(changeUpperBound);
	//	changes.add(changeUpperBound1);

	//	changes.add(changeUpperBound2);
		//changes.add(setProperty1);
		
	//	changes.add(setProperty2);
		
	/* Modisco starts	*/
	RenameProperty rp1 = new RenameProperty("discoveryError", "discoveryErrors", "Discovery");		
		RenameProperty rp2 = new RenameProperty("dicoveryDate", "discoveryDate", "Discovery");
		RenameProperty rp3 = new RenameProperty("totalExecutionTimeInSeconds", "discoveryTimeInSeconds", "Discovery");
		RenameProperty rp4 = new RenameProperty("averageSaveTimeInSeconds", "saveTimeAverageInSeconds", "AveragedProjectDiscovery");
		RenameProperty rp5 = new RenameProperty("averageExecutionTimeInSeconds", "discoveryTimeAverageInSeconds", "AveragedProjectDiscovery");
		
		changes.add(rp1);
		changes.add(rp2);
		changes.add(rp3);
		changes.add(rp4);
		changes.add(rp5);
		
		ArrayList<ComplexChange> moves = new ArrayList<ComplexChange>();
		
		MoveProperty mp1 = new MoveProperty("dicoveryDate", "Discovery", "DiscoveryIteration");//after its rename
		mp1.setThroughReference("iterations");
		mp1.setUpperBound(-1);
		MoveProperty mp2 = new MoveProperty("maxUsedMemoryInBytes", "Discovery", "DiscoveryIteration");
		mp2.setThroughReference("iterations");
		mp2.setUpperBound(-1);
		MoveProperty mp3 = new MoveProperty("saveTimeInSeconds", "Discovery", "DiscoveryIteration");
		mp3.setThroughReference("iterations");
		mp3.setUpperBound(-1);
		MoveProperty mp4 = new MoveProperty("discoveryError", "Discovery", "DiscoveryIteration");//after its rename
		mp4.setThroughReference("iterations");
		mp4.setUpperBound(-1);
		MoveProperty mp5 = new MoveProperty("totalExecutionTimeInSeconds", "Discovery", "DiscoveryIteration");//after its rename
		mp5.setThroughReference("iterations");
		mp5.setUpperBound(-1);
		moves.add(mp1);
		moves.add(mp2);
		moves.add(mp3);
		moves.add(mp4);
		moves.add(mp5);
		
		ExtractClass ec = new ExtractClass("EC", "Discovery", "DiscoveryIteration", null, moves);
		
		changes.add(ec);
		
		MoveProperty mp6 = new MoveProperty("saveTimeStandardDeviation", "AveragedProjectDiscovery", "ProjectDiscovery");
		MoveProperty mp7 = new MoveProperty("executionTimeStandardDeviation", "AveragedProjectDiscovery", "ProjectDiscovery");
		MoveProperty mp8 = new MoveProperty("saveTimeAverageInSeconds", "AveragedProjectDiscovery", "ProjectDiscovery");//after its rename
		MoveProperty mp9 = new MoveProperty("discoveryTimeAverageInSeconds", "AveragedProjectDiscovery", "ProjectDiscovery");//after its rename
		
		changes.add(mp6);
		changes.add(mp7);
		changes.add(mp8);
		changes.add(mp9);
		
		ArrayList<String> subclasses = new ArrayList<String>();
		subclasses.add("ProjectDiscovery");
		
		PullProperty pp1 = new PullProperty("saveTimeStandardDeviation", "Discovery", subclasses);
		PullProperty pp2 = new PullProperty("executionTimeStandardDeviation", "Discovery", subclasses);
		PullProperty pp3 = new PullProperty("saveTimeAverageInSeconds", "Discovery", subclasses);
		PullProperty pp4 = new PullProperty("discoveryTimeAverageInSeconds", "Discovery", subclasses);
		
		changes.add(pp1);
		changes.add(pp2);
		changes.add(pp3);
		changes.add(pp4);
		
		ArrayList<ComplexChange> pulls = new ArrayList<ComplexChange>();
		
		ArrayList<String> subclasses1 = new ArrayList<String>();
		subclasses1.add("Porject");
		PullProperty pp5 = new PullProperty("name", "Resource", subclasses1);
		PullProperty pp6 = new PullProperty("totalSizeInBytes", "Resource", subclasses1);
		//pulls.add(pp5);
		//pulls.add(pp6);
		changes.add(pp5);
		changes.add(pp6);
		ExtractSuperClass esc = new ExtractSuperClass("", "Resource", subclasses1, null, pulls);
		changes.add(esc);
		
		ArrayList<String> subclasses2 = new ArrayList<String>();
		subclasses2.add("MultiProjectBenchmark");
		subclasses2.add("ProjectDiscovery");
		
		ArrayList<String> subclasses3 = new ArrayList<String>();
		subclasses3.add("MultiDiscoveryBenchmark");
		subclasses3.add("AveragedMultiDiscoveryBenchmark");
		subclasses3.add("DiscoveredProject");
		
		PullProperty pp7 = new PullProperty("projects", "Benchmark", subclasses2);
		PullProperty pp8 = new PullProperty("discoveries", "Benchmark", subclasses3);
		changes.add(pp7);
		changes.add(pp8);
		
		DeleteProperty dp1 = new DeleteProperty("occurrences", "AveragedProjectDiscovery"); 
		DeleteProperty dp2 = new DeleteProperty("metaModelVariant", "Discovery");
		DeleteProperty dp3 = new DeleteProperty("algorithmVariant", "Discovery");
		
		changes.add(dp1);
		changes.add(dp2);
		changes.add(dp3);
		
		DeleteClass dc1 = new DeleteClass("AveragedProjectDiscovery");
		DeleteClass dc2 = new DeleteClass("AveragedMultiDiscoveryBenchmark");
		DeleteClass dc3 = new DeleteClass("DiscoveredProject");
		DeleteClass dc4 = new DeleteClass("ProjectDiscovery");
		DeleteClass dc5 = new DeleteClass("MultiDiscoveryBenchmark");
		DeleteClass dc6 = new DeleteClass("MultiProjectBenchmark");
		
		changes.add(dc1);
		changes.add(dc2);
		changes.add(dc3);
		changes.add(dc4);
		changes.add(dc5);
		changes.add(dc6);
		
		
		
		
		/* Modisco ends */
		
		return changes;
	}

}
