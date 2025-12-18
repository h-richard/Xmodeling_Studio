package xmodeling.contents;

public class Xmod_UnknownNamespaceExceptionContent implements  FileContent {

    @Override
    public String getContentFor(String projectName, String projectClass) {
        return """
                package exceptions;
                
                public class Xmod_UnknownNamespaceException extends Exception {
                
                	public Xmod_UnknownNamespaceException() {
                		super();
                	}
                
                	public Xmod_UnknownNamespaceException(String message) {
                		super(message);
                	}
                }
                """;
    }
}
