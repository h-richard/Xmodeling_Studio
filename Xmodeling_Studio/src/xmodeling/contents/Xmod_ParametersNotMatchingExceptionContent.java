package xmodeling.contents;

public class Xmod_ParametersNotMatchingExceptionContent implements FileContent {

    @Override
    public String getContentFor(String projectName, String projectClass) {
        return """
                package exceptions;
                
                public class Xmod_ParametersNotMatchingException extends Exception {
                
                	public Xmod_ParametersNotMatchingException() {
                		super();
                	}
                
                	public Xmod_ParametersNotMatchingException(String message) {
                		super(message);
                	}
                
                }
                """;
    }
}
