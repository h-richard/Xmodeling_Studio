package xmodeling.contents;

import java.text.MessageFormat;

public class PluginPropertiesContent implements FileContent {
    @Override
    public String getContentFor(String projectName, String projectClass) {
        return MessageFormat.format(
            """
            #
            
            pluginName = {0} Model
            providerName = www.example.org
            """,
            projectClass);
    }
}
