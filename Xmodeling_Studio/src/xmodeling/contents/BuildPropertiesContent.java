package xmodeling.contents;

public class BuildPropertiesContent implements FileContent {
    @Override
    public String getContentFor(String projectName, String projectClass) {
        return
            """
            #
    
            bin.includes = .,
                           model/,
                           META-INF/,
                           plugin.properties,
                           plugin.xml
            jars.compile.order = .
            source.. = src-gen/,
                       src/
            output.. = bin/
            """;
    }
}
