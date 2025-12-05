package xmodeling.contents;

import java.text.MessageFormat;

public class EcoreFileContent implements FileContent {
    @Override
    public String getContentFor(String projectName, String projectClass) {
        return MessageFormat.format(
            """
            <?xml version="1.0" encoding="UTF-8"?>
            <ecore:EPackage xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:ecore="http://www.eclipse.org/emf/2002/Ecore
                name="{0}" nsURI="http://www.example.org/{0}" nsPrefix="{0}"/>
            """,
            projectName);
    }
}
