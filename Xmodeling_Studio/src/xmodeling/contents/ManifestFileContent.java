package xmodeling.contents;

import java.text.MessageFormat;

public class ManifestFileContent implements FileContent {
    @Override
    public String getContentFor(String projectName, String projectClass) {
        return MessageFormat.format(
            """
            Manifest-Version: 1.0
            Bundle-ManifestVersion: 2
            Bundle-Name: %pluginName
            Bundle-SymbolicName: {0};singleton:=true
            Bundle-Version: 0.1.0.qualifier
            Bundle-ClassPath: .
            Bundle-Vendor: %providerName
            Bundle-Localization: plugin
            Bundle-RequiredExecutionEnvironment: JavaSE-1.8
            Export-Package: {0},
             {0}.impl,
             {0}.util
            Require-Bundle: org.eclipse.emf.ecore;visibility:=reexport,
             org.eclipse.core.runtime,
             org.eclipse.emf.ecore.xmi
            Bundle-ActivationPolicy: lazy
            """,
            projectName);
    }
}
