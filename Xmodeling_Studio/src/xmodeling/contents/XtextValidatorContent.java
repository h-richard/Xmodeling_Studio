package xmodeling.contents;

import java.text.MessageFormat;

public class XtextValidatorContent implements FileContent {

	@Override
	public String getContentFor(String projectName, String projectClass) {
		return MessageFormat.format(
			"""
			package org.xtext.validation;
			
			import java.util.ArrayDeque;
			import java.util.ArrayList;
			import java.util.Arrays;
			import java.util.Deque;
			import java.util.List;
			import java.util.function.Predicate;
			
			import org.eclipse.emf.common.util.EList;
			import org.eclipse.emf.ecore.EAttribute;
			import org.eclipse.emf.ecore.EClass;
			import org.eclipse.emf.ecore.EClassifier;
			import org.eclipse.emf.ecore.EObject;
			import org.eclipse.emf.ecore.EPackage;
			import org.eclipse.emf.ecore.EReference;
			import org.eclipse.emf.ecore.EStructuralFeature;
			import org.eclipse.xtext.EcoreUtil2;
			import org.eclipse.xtext.validation.Check;
			
			import {0}.{1}Package;
			import {0}.Xmod_Element;
			import {0}.Xmod_Operation;
			
			/**
			 * This class contains custom validation rules.
			 * Use these alongside your own for Xmodeling script validation.
			 *
			 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
			 *
			 * @author Hugo Richard
			 */
			public class {1}Validator extends Abstract{1}Validator '{'
			
				private static final String MODEL_NAMESPACE = "model";
				private static final String EXTERNAL_NAMESPACE = "ext";
				private static final String JAVA_NAMESPACE = "java";
			
				@Check
				public void checkOperation(Xmod_Operation op) '{'
					EObject root = getModelRoot(op);
			
					// checks each parameter chain
					// format of each chain is namespace:tag.navigation
					EList<String> params = op.getParametersTag();
					for (String p : params)
						checkChain(p, root, {1}Package.Literals.XMOD_OPERATION__PARAMETERS_TAG, params.indexOf(p));
			
					// checks the object chain
					// it follows the ''on'' keyword, stating from which class the method belongs to
					checkChain(op.getObjectTag(), root, {1}Package.Literals.XMOD_OPERATION__OBJECT_TAG, -1);
			
					// checks the optional return chain
					// it follows the ''returns'' keyword
					if (op.getReturnTag() != null)
						checkChain(op.getReturnTag(), root, {1}Package.Literals.XMOD_OPERATION__RETURN_TAG, -1);
			
				'}'
			
				/**
				 * Get the instance of the model root class.
				 * It does so by going up container by container until it reaches an instance contained by no other.
				 * @param o any object from the model
				 * @return the model root class instance
				 */
				private static EObject getModelRoot(EObject o) '{'
					while (o.eContainer() != null) o = o.eContainer();
					return o;
				'}'
			
				/**
				 * Retrieve an instance of any class from the model that inherits from Xmod_Element.
				 * @param modelRoot the model root class instance
				 * @param xmod_id the xmod_id of the element you are looking for
				 * @return the element of null if not found
				 */
				private static EObject findElementById(EObject modelRoot, String xmod_id) '{'
					List<Xmod_Element> allNamed = EcoreUtil2.getAllContentsOfType(modelRoot, Xmod_Element.class);
					for (Xmod_Element e : allNamed)
						if (xmod_id.equals(e.getXmod_id()))
							return e;
					return null;
				'}'
			
				/**
				 * Check the validity of a given chain.
				 * @param chain the said chain, usually formatted as namespace:tag.navigation
				 * @param root the model root class instance
				 * @param literal the meta object literal for the attribute represented by the tag chain
				 * @param featureIndex the index of the sub-literal if the attribute is a collection (or -1 if a regular attribute)
				 */
				private void checkChain(String chain, EObject root, EAttribute literal, int featureIndex) '{'
					String[] couple = chain.split(":");
					if (couple.length < 2) return;
					Deque<String> navigationChain = new ArrayDeque<>(Arrays.asList(couple[1].split("\\\\.")));
					switch (couple[0]) '{'
					case MODEL_NAMESPACE: '{'
						checkModelChain(root, navigationChain, literal, featureIndex);
					'}'
					case EXTERNAL_NAMESPACE: '{'
						break;
					'}'
					case JAVA_NAMESPACE: '{'
						break;
					'}'
					default: '{'
						if (featureIndex == -1) error("Unknown namespace : ''" + couple[0] + "''", literal);
						else error("Unknown namespace : ''" + couple[0] + "''", literal, featureIndex);
						break;
					'}'
					'}'
				'}'
			
				/**
				 * Check specifically for chains starting with "model".
				 * @param root the model root class instance
				 * @param chain the chain split as a Deque (doesnt carry the namespace)
				 * @param literal the meta object literal for the attribute represented by the chain
				 * @param featureIndex the index of the sub-literal if the attribute is a collection (or -1 if a regular attribute)
				 */
				private void checkModelChain(EObject root, Deque<String> chain, EAttribute literal, int featureIndex) '{'
					EObject chainRoot = findElementById(root, chain.pollFirst());
			
					// if the chain root is null, it means the given object has not been instantiated yet
					// it could be valid nonetheless, so we try to infer its type
					if (chainRoot == null) '{'
						if (chain.isEmpty()) '{'
							if (featureIndex == -1) error("Cannot confirm validity : Too few elements.", literal);
							else error("Cannot confirm validity : Too few elements.", literal, featureIndex);
							return;
						'}'
			
						List<EClassifier> inferedTypeList = getInferedTypeCandidates(chain);
			
						if (inferedTypeList.isEmpty()) '{'
							if (featureIndex == -1) error("Cannot confirm validity : No matching type found.", literal);
							else error("Cannot confirm validity : No matching type found.", literal, featureIndex);
							return;
						'}'
			
						if (inferedTypeList.size() > 1) '{'
							if (featureIndex == -1) warning("Cannot confirm validity : Multiple matching types found.", literal);
							else warning("Cannot confirm validity : Multiple matching types found.", literal, featureIndex);
							return;
						'}'
			
						if (featureIndex == -1) info("Infered type : "+inferedTypeList.get(0).getInstanceClass().getSimpleName()+".\\nMake sure this is consistent at runtime.", literal);
						else info("Infered type : "+inferedTypeList.get(0).getInstanceClass().getSimpleName()+".\\nMake sure this is consistent at runtime.", literal, featureIndex);
					'}'
			
					// the chain root exists, meaning the object has been instantiated
					// thus the whole chain must be valid
					else '{'
						// we start our search at the chain root
						EObject pointedObject = chainRoot;
			
						while (!chain.isEmpty()) '{'
							String fieldName = chain.pollFirst();
			
							// if the current element contains brackets, it is a collection
							if (fieldName.contains("[") && fieldName.contains("]")) '{'
								int open = fieldName.indexOf(''['');
								int close = fieldName.indexOf('']'');
								String collectionName = fieldName.substring(0, open);
								String elementName = fieldName.substring(open + 1, close);
								EStructuralFeature feature = pointedObject.eClass().getEStructuralFeature(collectionName);
								if (feature == null) '{'
									error("Collection ''"+collectionName+"'' doesn''t exist.", literal, featureIndex);
									return;
								'}'
								Object featureValue = pointedObject.eGet(feature);
								if (!(featureValue instanceof EList<?> list)) '{'
									error("''"+collectionName+"'' isn''t a collection.", literal, featureIndex);
									return;
								'}'
			
								// we try to find an attribute within that collection that carries the given id
								EObject match = null;
								for (Object o : list) '{'
									if (!(o instanceof EObject eo)) continue;
									EStructuralFeature keyFeature = eo.eClass().getEStructuralFeature("xmod_id");
									if (keyFeature == null) keyFeature = eo.eClass().getEStructuralFeature("name");
									if (keyFeature == null) continue;
									Object keyValue = eo.eGet(keyFeature);
									if (elementName.equals(String.valueOf(keyValue))) '{'
										match = eo;
										break;
									'}'
								'}'
								if (match == null) '{'
									error("No element ''"+elementName+"'' in ''"+collectionName+"''.", literal, featureIndex);
									return;
								'}'
								pointedObject = match;
							'}'
			
							// the current element doesnt contain brackets, it is a regular feature
							else '{'
								EStructuralFeature feature = pointedObject.eClass().getEStructuralFeature(fieldName);
								if (feature == null) '{'
									warning("No field ''"+fieldName+"'' found. Possible false-field.", literal, featureIndex);
									return;
								'}'
			
								Object value = pointedObject.eGet(feature);
			
								if (value == null) '{'
									// some features are optional (lower bound is 0), if thats the case we ignore the null value
									if (feature.getLowerBound() != 0)
										warning("No field ''"+fieldName+"'' found. Possible false-field.", literal, featureIndex);
									return;
								'}'
			
								if (value instanceof EObject eo) pointedObject = eo;
								// we cant access another feature of something that isnt an EObject
								else if (!chain.isEmpty()) '{'
									if (value instanceof EList<?>) '{'
										error("''"+fieldName+"'' is a collection.", literal, featureIndex);
										return;
									'}'
									error("''"+fieldName+"'' is a primitive.", literal, featureIndex);
									return;
								'}'
							'}'
						'}'
					'}'
				}
			
				/**
				 * Returns the possible types the object represented by the chain could be, despite not being instantiated.
				 * In a way, it tries to infer its type.
				 * @param chain the chain split as a Deque (doesnt carry the tag)
				 * @return a list of possible types for the given object chain
				 */
				private static List<EClassifier> getInferedTypeCandidates(Deque<String> chain) '{'
					List<EClass> allClasses = getModelClasses(ecls -> true);
			
					final String fieldName = normalizeFieldName(chain.pollFirst());
			
					List<EClassifier> candidates = new ArrayList<>();
					for (EClass ecls : allClasses) '{'
						EClassifier clsf = getFeatureType(ecls, fieldName);
						if (clsf == null) continue;
						if (chain.isEmpty()) candidates.add(clsf);
						else if (clsf instanceof EClass containerClass) '{'
							EClassifier c = getInferedTypeCandidate(new ArrayDeque<>(chain), containerClass);
							if (c != null) candidates.add(c);
						'}'
					'}'
			
					return candidates;
				'}'
			
				/**
				 * Returns the possible type, if any, the object represented by the chain could be, despite not being instantiated.
				 * This method is meant to be used within getInferedTypeCandidates(), not by itself.
				 * @param chain the chain split as a Deque (doesnt carry the tag)
				 * @param containerClass the super-class already inferred
				 * @return a possible type for the given object chain or null if none
				 */
				private static EClassifier getInferedTypeCandidate(Deque<String> chain, EClass containerClass) '{'
					System.out.println(chain.toString());
					final String fieldName = normalizeFieldName(chain.pollFirst());
			
					EClassifier clsf = getFeatureType(containerClass, fieldName);
			
					if (clsf != null && !chain.isEmpty()) '{'
						if (clsf instanceof EClass ecls) return getInferedTypeCandidate(chain, ecls);
						return null;
					'}'
			
					return clsf;
				'}'
			
				// this method is currently only used with a dumb "any -> true" predicate, but it may be helpful in the future
				/**
				 * Get classes from the model, filtered using the given predicate.
				 * @param filter a predicate for filtering the classes to retrieve
				 * @return a list of classes from the model
				 */
				private static List<EClass> getModelClasses(Predicate<EClass> filter) '{'
					EPackage pack = {1}Package.eINSTANCE;
					List<EClass> clslist = new ArrayList<>();
			
					for (EClassifier clsf : pack.getEClassifiers())
						if (clsf instanceof EClass ecls)
							if (filter.test(ecls))
								clslist.add(ecls);
			
					return clslist;
				'}'
			
				/**
				 * Get the type of a feature of any eclass.
				 * @param ecls the said eclass
				 * @param featureName the name of its feature you are trying to get the type of
				 * @return the type of the retrieved feature or null if not found
				 */
				private static EClassifier getFeatureType(EClass ecls, String featureName) '{'
					for (EStructuralFeature f : ecls.getEAllStructuralFeatures()) '{'
						if (featureName.equals(f.getName())) '{'
							if (f instanceof EAttribute attr) return attr.getEAttributeType();
							if (f instanceof EReference ref) return ref.getEReferenceType();
						'}'
					'}'
					return null;
				'}'
			
				/**
				 * Strips a String of its brackets.
				 * For example : "[attribute]" returns "attribute"
				 * @param raw the version of the String with brackets
				 * @return the version of the String without brackets
				 */
				private static String normalizeFieldName(String raw) '{'
					int idx = raw.indexOf(''['');
					return (idx >= 0) ? raw.substring(0, idx) : raw;
				'}'
			'}'
			""",
			projectClass, projectName);
	}

}
