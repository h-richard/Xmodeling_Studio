package xmodeling.contents;

public class Xmod_ReturnTypeNotMatchingExceptionContent implements FileContent {

    @Override
    public String getContentFor(String projectName, String projectClass) {
        return """
                package exceptions;
                
                public class Xmod_ReturnTypeNotMatchingException extends Exception {
                
                	public Xmod_ReturnTypeNotMatchingException() {
                		super();
                	}
                
                	public Xmod_ReturnTypeNotMatchingException(String message) {
                		super(message);
                	}
                
                }
                """;
    }
}
