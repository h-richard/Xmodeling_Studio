package xmodeling.handler;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import xmodeling.XmodelingTransformationEngine;

/**
 * <b> XmodelingTransformationHandler is the class which deals with the popup menu action. </b>
 * 
 * @see XmodelingTransformationEngine
 * 
 * @author Lea Brunschwig
 * @author Hugo Richard
 *
 */
public class XmodelingTransformationHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) {

		ISelection selection = HandlerUtil.getCurrentSelection(event);
		
		if (selection instanceof IStructuredSelection structured) {
			
		    Object element = structured.getFirstElement();
		    
		    // has the user right-clicked on an .ecore file?
		    if (element instanceof IFile file && file.getFileExtension().equals("ecore")) { 
		    	if (!MessageDialog.openQuestion(null, "Xmodeling", "Do you want to apply the transformation on this file?")) return null;
		        
		    	String source = file.getLocation().toOSString();
		    	String target = file.getLocation().toOSString();

				XmodelingTransformationEngine engine = new XmodelingTransformationEngine();

		    	try { engine.modifyMetaModel(source, target); }
				catch (IOException | CoreException e1) { e1.printStackTrace(); }
		    }
		    else MessageDialog.openInformation(null, "Xmodeling", "Please select a valid file (.ecore)");
		}

		return null;
	}
	
	//TODO possible amelioration : le fichier source est celui sur lequel on applique la transfo et on choisit un autre MM pour la cible
	/*public void selectFile(String source) {
		
		MessageDialog.openInformation(null, "Xmodeling", "Not implemented yet.");
		JFileChooser dialogue = new JFileChooser(new File("."));
		File fichier;
		
		if (dialogue.showOpenDialog(null)== 
		    JFileChooser.APPROVE_OPTION) {
		    fichier = dialogue.getSelectedFile();
		    if(fichier.getName().contains(".ecore")) {
		    	MessageDialog.openInformation(null, "Xmodeling", "Transformation");
		    } else {
		    	MessageDialog.openInformation(null, "Xmodeling", "Veuillez selectioner un fichier correct (.ecore).");
		    	selectFile();
		    }
		    XmodelingTransformationEngine e = new XmodelingTransformationEngine();
		    e.execute(fichier.getAbsolutePath(), fichier.getAbsolutePath());
		    try {
				e.modifyMetaModel(source, source);
			} catch (IOException | CoreException e1) {
				e1.printStackTrace();
			}
		    e.execute(source, source, sourcePath);
		}
	}*/

}
