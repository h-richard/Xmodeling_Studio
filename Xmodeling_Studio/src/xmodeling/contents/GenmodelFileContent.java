package xmodeling.contents;

import java.text.MessageFormat;

public class GenmodelFileContent implements FileContent {
    @Override
    public String getContentFor(String projectName, String projectClass) {
        return MessageFormat.format(
            """
            <?xml version="1.0" encoding="UTF-8"?>
            <genmodel:GenModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xmlns:genmodel="http://www.eclipse.org/emf/2002/GenModel" modelDirectory="/"+ {0}+"/src-gen" creationIcons="false" editDirectory="/"+ {0}+".edit/src-gen"
                editorDirectory="/"+ {0}+".editor/src-gen" modelPluginID=""+ {0}+"" modelName=""+ {1}+"" rootExtendsClass="org.eclipse.emf.ecore.impl.MinimalEObjectImpl$Container"
                codeFormatting="true" importerID="org.eclipse.emf.importer.ecore" complianceLevel="8.0"
                copyrightFields="false" operationReflection="true" importOrganizing="true">
              <foreignModel>"+ {0}+".ecore</foreignModel>
              <"+ {0}+"sDirectory xsi:nil="true"/>
              <genPackages prefix=""+ {1}+"" disposableProviderFactory="true" ecorePackage=""+ {0}+".ecore#/"/>
            </genmodel:GenModel>
            """,
            projectName, projectClass);
    }
}
