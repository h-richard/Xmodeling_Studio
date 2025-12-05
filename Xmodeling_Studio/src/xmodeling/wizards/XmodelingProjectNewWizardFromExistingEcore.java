package xmodeling.wizards;

import java.net.URI;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

import xmodeling.projects.XmodelingProjectSupport;

/**
 * <b> XmodelingProjectNewWizardFromExistingEcore corresponds to the "Xmodeling Project from existing ecore" wizard. </b>
 * 
 * @see WizardNewProjectCreationPage
 * @see XmodelingProjectSupport
 * @see NewWizardMessages
 * @see XmodelingProjectNewWizardFromExistingEcorePage1
 * 
 * @author LeaBrunschwig
 *
 */
public class XmodelingProjectNewWizardFromExistingEcore extends Wizard implements INewWizard {

	/**
	 * Name of the wizard.
	 * 
	 * @see NewWizardMessages#XmodelingProject_XmodelingProjectNewWizardFromExistingEcore_wizard_name
	 */
	private static final String WIZARD_NAME = NewWizardMessages.XmodelingProject_XmodelingProjectNewWizardFromExistingEcore_wizard_name;
	
	/**
	 * Name of the page.
	 * 
	 * @see NewWizardMessages#XmodelingProject_XmodelingProjectNewWizardFromExistingEcore_page_name
	 */
	private static final String PAGE_NAME = NewWizardMessages.XmodelingProject_XmodelingProjectNewWizardFromExistingEcore_page_name;
	
	/**
	 * Title of the wizard.
	 * 
	 * @see NewWizardMessages#XmodelingProject_XmodelingProjectNewWizardFromExistingEcore_title
	 */
	private static final String WIZARD_TITLE = NewWizardMessages.XmodelingProject_XmodelingProjectNewWizardFromExistingEcore_title;
	
	/**
	 * Description of the wizard.
	 * 
	 * @see NewWizardMessages#XmodelingProject_XmodelingProjectNewWizardFromExistingEcore_description
	 */
	private static final String WIZARD_DESCRIPTION = NewWizardMessages.XmodelingProject_XmodelingProjectNewWizardFromExistingEcore_description;
	
	/**
	 * Initialization of the second page of the wizard.
	 * 
	 * @see XmodelingProjectNewWizardFromExistingEcorePage1
	 */
	private XmodelingProjectNewWizardFromExistingEcorePage1 _pageTwo;
	
	/**
	 * Initialization of the first page of the wizard.
	 * 
	 * @see WizardNewProjectCreationPage
	 */
	private WizardNewProjectCreationPage _pageOne;
	
	/**
	 * 
	 */
	private ISelection _selection;
	
	/**
	 * Constuctor XmodelingProjectNewWizardFromExistingEcore.
	 * <p>The window title is initialized with WIZARD_NAME.</p>
	 * 
	 * @see XmodelingProjectNewWizardFromExistingEcore#WIZARD_NAME
	 */
	public XmodelingProjectNewWizardFromExistingEcore() {
		setWindowTitle(WIZARD_NAME);
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this._selection = selection;
	}

	@Override
	public boolean performFinish() {
		
		String name = _pageOne.getProjectName();
	    URI location = null;
	    if (!_pageOne.useDefaults()) {
	        location = _pageOne.getLocationURI();
	    } 
		final String ecore = _pageTwo.getEcore();
		final String xmod_main = _pageTwo.getXmodMain();
		final String sourcePackage = _pageTwo.getSourcePackage();
		
		XmodelingProjectSupport.createProject(name, location, ecore, xmod_main, sourcePackage);
		return true;
	}
	
	@Override
	public void addPages() {
	    super.addPages();
		
	    _pageOne = new WizardNewProjectCreationPage(PAGE_NAME);
	    _pageOne.setTitle(WIZARD_TITLE);
	    _pageOne.setDescription(WIZARD_DESCRIPTION);
	    addPage(_pageOne);
	    
	    _pageTwo = new XmodelingProjectNewWizardFromExistingEcorePage1(_selection);
		addPage(_pageTwo);
	}

}
