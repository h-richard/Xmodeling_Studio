package xmodeling.wizards;

import java.net.URI;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

import xmodeling.projects.XmodelingProjectSupport;

/**
 * <b> XmodelingProjectNewWizard corresponds to the "Xmodeling Project" wizard. </b>
 * 
 * @see WizardNewProjectCreationPage
 * @see XmodelingProjectSupport
 * @see NewWizardMessages
 * 
 * @author LeaBrunschwig
 *
 */
public class XmodelingProjectNewWizard extends Wizard implements INewWizard {

	/**
	 * Name of the wizard.
	 * 
	 * @see NewWizardMessages#XmodelingProject_XmodelingProjectNewWizard_wizard_name
	 */
	private static final String WIZARD_NAME = NewWizardMessages.XmodelingProject_XmodelingProjectNewWizard_wizard_name;
	
	/**
	 * Name of the page.
	 * 
	 * @see NewWizardMessages#XmodelingProject_XmodelingProjectNewWizard_page_name
	 */
	private static final String PAGE_NAME = NewWizardMessages.XmodelingProject_XmodelingProjectNewWizard_page_name;
	
	/**
	 * Title of the wizard.
	 * 
	 * @see NewWizardMessages#XmodelingProject_XmodelingProjectNewWizard_title
	 */
	private static final String WIZARD_TITLE = NewWizardMessages.XmodelingProject_XmodelingProjectNewWizard_title;
	
	/**
	 * Description of the wizard.
	 * 
	 * @see NewWizardMessages#XmodelingProject_XmodelingProjectNewWizard_description
	 */
	private static final String WIZARD_DESCRIPTION = NewWizardMessages.XmodelingProject_XmodelingProjectNewWizard_description;
	
	/**
	 * Initialization of the unique page of the wizard.
	 * 
	 * @see WizardNewProjectCreationPage
	 */
	private WizardNewProjectCreationPage _page;
	
	/**
	 * Constuctor XmodelingProjectNewWizard.
	 * <p>The window title is initialized with WIZARD_NAME.</p>
	 * 
	 * @see XmodelingProjectNewWizard#WIZARD_NAME
	 */
	public XmodelingProjectNewWizard() {
		setWindowTitle(WIZARD_NAME);
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean performFinish() {
	    String name = _page.getProjectName();
	    URI location = null;
	    if (!_page.useDefaults()) {
	        location = _page.getLocationURI();
	    } // else location == null((
	    XmodelingProjectSupport.createProject(name, location, "", "", "");
	 
	    return true;
	}
	
	@Override
	public void addPages() {
	    super.addPages();
	 
		
	    _page = new WizardNewProjectCreationPage(PAGE_NAME);
	    _page.setTitle(WIZARD_TITLE);
	    _page.setDescription(WIZARD_DESCRIPTION);
	 
	    addPage(_page);
	}

}
