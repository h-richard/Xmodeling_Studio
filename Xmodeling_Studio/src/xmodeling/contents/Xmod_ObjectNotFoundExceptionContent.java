package xmodeling.contents;

public class Xmod_ObjectNotFoundExceptionContent implements FileContent {

    @Override
    public String getContentFor(String projectName, String projectClass) {
        return """
                package exceptions;
                
                public class Xmod_ObjectNotFoundException extends Exception {
                
                	public Xmod_ObjectNotFoundException() {
                		super();
                	}
                
                	public Xmod_ObjectNotFoundException(String message) {
                		super(message);
                	}
                
                }
                """;
    }
}
