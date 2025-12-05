package xmodeling;

import org.eclipse.core.runtime.CoreException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws CoreException, IOException {
        String source = "C:\\Users\\dojib\\Projets\\SpiceWorkspace\\Test\\model\\test.ecore";
        String target = "C:\\Users\\dojib\\Projets\\SpiceWorkspace\\Test\\model\\transfo.ecore";

        XmodelingTransformationEngine engine = new XmodelingTransformationEngine();
        
        try { engine.modifyMetaModel(source, target); }
		catch (IOException | CoreException e1) { e1.printStackTrace(); }
    }
}
