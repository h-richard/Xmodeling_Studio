package xmodeling.contents;

public class Xmod_MethodNotFoundExceptionContent implements FileContent {

    @Override
    public String getContentFor(String projectName, String projectClass) {
        return """
                package exceptions;
                
                public class Xmod_MethodNotFoundException extends Exception {
                
                	public Xmod_MethodNotFoundException() {
                		super();
                	}
                
                	public Xmod_MethodNotFoundException(String message) {
                		super(message);
                	}
                
                }
                """;
    }
}
