package xmodeling.contents;

import java.text.MessageFormat;

public class PluginXmlContent implements FileContent {
    @Override
    public String getContentFor(String projectName, String projectClass) {
        return MessageFormat.format(
        """
            <?xml version="1.0" encoding="UTF-8"?>
            <?eclipse version="3.0"?>
            
            <!--
            -->
            
            <plugin>
              <extension point="org.eclipse.emf.ecore.generated_package">
              <package
                  uri="http://www.example.org/{0}"
                  class="{0}.{1}Package"
                  genModel="model/{0}.genmodel"/>
              </extension>
            </plugin>
            """,
        projectName, projectClass);
    }
}
