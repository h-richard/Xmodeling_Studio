package xmodeling.contents;

public class FileGenerator {
    private final FileContent fc;

    public FileGenerator(FileContent fc) {
        this.fc = fc;
    }

    public String getContentFor(String projectName, String projectClass) {
        return fc.getContentFor(projectName, projectClass);
    }
}
