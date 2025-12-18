package xmodeling.contents;

import java.text.MessageFormat;

public class XmodUtilContent implements FileContent {
	
	private static final String firstPart = 
			"""
			package {0}.util;

			import java.beans.XMLDecoder;
			import java.beans.XMLEncoder;
			import java.io.*;
			import java.util.Map;
			import java.util.Collections;
			import java.util.HashMap;
			
			import org.eclipse.emf.ecore.resource.ResourceSet;
			import org.eclipse.emf.common.util.TreeIterator;
			import org.eclipse.emf.common.util.URI;
			import org.eclipse.emf.ecore.EObject;
			import org.eclipse.emf.ecore.EPackage;
			import org.eclipse.emf.ecore.resource.Resource;
			import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
			import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
			import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
			import org.eclipse.xtext.resource.XtextResource;
			import org.eclipse.xtext.resource.XtextResourceSet;
			
			import com.google.inject.Injector;
			
			import {0}.{2};
			import {0}.{1}Factory;
			import {0}.{1}Package;
			import {0}.Xmod_Element;
			import {0}.Xmod_Exception;
			import {0}.Xmod_ExceptionKind;
			import {0}.Xmod_ExceptionReaction;
			import {0}.Xmod_Operation;
			
			import org.xtext.{1}StandaloneSetup;
			import org.xtext.{1}StandaloneSetupGenerated;
			
			public class {1}Utils '{'
			    private static Map<String,Object> EXTMAP = new HashMap<>();
			    private static Map<String,Object> MODELMAP = new HashMap<>();
			
			    public static Map<String,Object> getExtMap() '{'
			        return EXTMAP;
			    '}'
			
			    public static Map<String,Object> getModelMap() '{'
			        return MODELMAP;
			    '}'
			
			    public static void setExtMap(Map<String,Object> map) '{'
			        EXTMAP = map;
			    '}'
			
			    public static void setModelMap(Map<String,Object> map) '{'
			        MODELMAP = map;
			    '}'
			    
			    public static void putExtMap(String key, Object value) '{'
			    	EXTMAP.put(key, value);
			    '}'
			    
			    public static void putModelMap(String key, Object value) '{'
					MODELMAP.put(key, value);
				'}'
			
			    @SuppressWarnings("unchecked")
			    public static Map<String, Object> loadMap(String fileName) '{'
			        /* Init */
			        File xmlFile;
			        XMLDecoder decoder = null;
			        HashMap<String, Object> map = new HashMap<>();
			
			        /* Body */
			        try '{'
			            xmlFile = new File(fileName);
			            if (xmlFile.exists()) '{' // if an xml file with the name of the map does exist, we deserialize it.
			                decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(xmlFile)));
			                map = (HashMap<String, Object>) decoder.readObject();
			                decoder.close();
			            '}'
			
			        '}' catch (FileNotFoundException e1) '{' e1.printStackTrace(); '}'
			
			        return map;
			    '}'
			
			    public static void saveMap(String fileName, HashMap<String,Object> map) '{'
			        /* Init */
			        File xmlFile;
			        XMLEncoder encoder = null;
			
			        /* Body */
			        try '{'
			            xmlFile = new File(fileName);
			            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(xmlFile)));
			            encoder.writeObject(map);
			            encoder.flush();
			        '}'
			        catch (FileNotFoundException e) '{' e.printStackTrace(); '}'
			        finally '{' encoder.close(); '}'
			    '}'
			
			
			    public static void saveModel(String uri, EObject root) '{'
			        Resource resource = null;
			        try '{'
			            URI uriUri = URI.createURI(uri);
			            Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
			            resource = (new ResourceSetImpl()).createResource(uriUri);
			            resource.getContents().add(root);
			            resource.save(null);
			        '}' catch (Exception e) '{'
			            System.err.println("Error in saving the model: "+e);
			            e.printStackTrace();
			        '}'
			    '}'
			
			    public static Resource loadModelFromXmi(String uri, EPackage pack) '{'
			        Resource resource = null;
			        try '{'
			            EPackage.Registry.INSTANCE.put(pack.getNsURI(), pack);
			
			            ResourceSet resourceSet = new ResourceSetImpl();
			            Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
			
			            InputStream ecoreStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("metamodels/{0}.ecore");
			            if (ecoreStream != null) '{'
			                Resource ecoreResource = new XMIResourceImpl(URI.createURI("{0}.ecore"));
			                ecoreResource.load(ecoreStream, Collections.EMPTY_MAP);
			            '}'
			
			            InputStream xmiStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(uri);
			            if (xmiStream != null) '{'
			                resource = new XMIResourceImpl(URI.createURI(uri));
			                resource.load(xmiStream, Collections.EMPTY_MAP);
			            '}' else '{'
			                File file = new File(uri);
			                if (file.exists()) '{'
			                    resource = resourceSet.createResource(URI.createFileURI(file.getAbsolutePath()));
			                    resource.load(Collections.EMPTY_MAP);
			                '}' else '{'
			                    URI platformUri = URI.createPlatformResourceURI(uri, true);
			                    resource = resourceSet.getResource(platformUri, true);
			                '}'
			            '}'
			
			        '}' catch (Exception e) '{'
			            e.printStackTrace();
			            throw new RuntimeException("Failed to load model: " + uri, e);
			        '}'
			        return resource;
			    '}'
			""";
	
    @Override
    public String getContentFor(String projectName, String projectClass) {
        return MessageFormat.format(firstPart, projectName, projectClass) + '}';
    }
    
    public String getContentFor(String projectName, String projectClass, String rootClassName) {
    	return MessageFormat.format(
    		firstPart +
    		"""
                public static {2} load{2}FromXmi(String uri) '{'
                    Resource resource = {1}Utils.loadModelFromXmi(uri, {1}Package.eINSTANCE);
                    if (resource == null) return null;
        
                    TreeIterator<EObject> it = resource.getAllContents();
        
                    {2} root = null;
                    while(it.hasNext()) '{'
                        EObject obj = it.next();
                        if (obj instanceof {2}) '{'
                            root = ({2})obj;
                            break;
                        '}'
                    '}'
                    if (root == null) System.err.println("No root instance in the model");
                    else init(root);
        
                    return root;
                '}'
        
                public static {2} load{2}From{1}Model(String uri) '{'
                    try '{'
                        EPackage.Registry.INSTANCE.put({1}Package.eNS_URI, {1}Package.eINSTANCE);
        
                        {1}StandaloneSetup.doSetup();
                        {1}StandaloneSetupGenerated setup = new {1}StandaloneSetupGenerated();
                        Injector injector = setup.createInjectorAndDoEMFRegistration();
        
                        XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
                        resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
        
                        XtextResource resource;
        
                        if (Thread.currentThread().getContextClassLoader().getResource(uri) != null) '{'
                            resource = (XtextResource) resourceSet.getResource(
                                    URI.createURI(uri), true);
                        '}' else '{'
                            File file = new File(uri);
                            if (file.exists()) '{'
                                resource = (XtextResource) resourceSet.getResource(
                                        URI.createFileURI(file.getAbsolutePath()), true);
                            '}' else '{'
                                URI platformUri = URI.createPlatformResourceURI(uri, true);
                                resource = (XtextResource) resourceSet.getResource(platformUri, true);
                            '}'
                        '}'
        
                        {2} root = null;
						for (EObject e : resource.getContents()) '{'
							if (e instanceof {2}) '{'
								root = ({2}) e;
								break;
							}
						}
						if (root == null) System.err.println("No root instance in the model");
						else init(root);
        
                        return root;
        
                    '}' catch (Exception e) '{'
                        e.printStackTrace();
                        throw new RuntimeException("Failed to load model: " + uri, e);
                    '}'
                '}'
        
                private static void init({2} r) '{'
                    TreeIterator<EObject> it = r.eAllContents();
        
                    if (r instanceof Xmod_Element)
						MODELMAP.put(r.getXmod_id(), r);
        
                    while (it.hasNext()) '{'
                        EObject obj = it.next();
        
                        if (obj instanceof Xmod_Element e)
                            MODELMAP.put(e.getXmod_id(), e);
        
                        if (obj instanceof Xmod_Operation o) '{'
                            Xmod_Exception ok = {1}Factory.eINSTANCE.createXmod_Exception();
                            ok.setKind(Xmod_ExceptionKind.OK);
                            ok.setReaction(Xmod_ExceptionReaction.CONTINUE);
                            o.setEOK(ok);
                            o.addException(ok);
        
                            if (o.getException(Xmod_ExceptionKind.OTHER) == null) '{'
                                Xmod_Exception other = {1}Factory.eINSTANCE.createXmod_Exception();
                                other.setKind(Xmod_ExceptionKind.OTHER);
                                other.setReaction(Xmod_ExceptionReaction.CONTINUE);
                                o.addException(other);
                            '}'
                        '}'
                    '}'
                '}'
            '}'
			""",
    		projectName, projectClass, rootClassName);
    }
}
