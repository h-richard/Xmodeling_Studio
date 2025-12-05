package xmodeling.wizards;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * <b> XmodelingProjectNewWizardFromExistingEcorePage1 is corresponding to the second page of the "Xmodeling project from existing ecore" wizard. </b>
 * 
 * @see NewWizardMessages
 * 
 * @author LeaBrunschwig
 */
public class XmodelingProjectNewWizardFromExistingEcorePage1 extends WizardPage {
	
	/**
	 * The name of the chosen ecore file.
	 * 
	 * @see XmodelingProjectNewWizardFromExistingEcorePage1#getEcore()
	 */
	private Text _ecore;
	
	/**
	 * The name of the class annotated by Xmod_main.
	 * 
	 * @see XmodelingProjectNewWizardFromExistingEcorePage1#getXmodMain()
	 */
	private Text _xmod_main;
	
	/**
	 * The name of the source package of the chosen ecore.
	 * 
	 * @see XmodelingProjectNewWizardFromExistingEcorePage1#getSourcePackage()
	 */
	private String _sourcePackage;
	
	/**
	 * 
	 */
	private ISelection _selection;
	
	/**
	 * Title of the wizard.
	 * 
	 * @see NewWizardMessages#XmodelingProject_XmodelingProjectNewWizardFromExistingEcore_title
	 */
	private static final String WIZARD_TITLE = NewWizardMessages.XmodelingProject_XmodelingProjectNewWizardFromExistingEcore_title;
	
	/**
	 * Constuctor XmodelingProjectNewWizardFromExistingEcorePage1.
	 * <p>The title is initialized with WIZARD_TITLE.</p>
	 * 
	 * @see XmodelingProjectNewWizardFromExistingEcorePage1#WIZARD_TITLE
	 */
	protected XmodelingProjectNewWizardFromExistingEcorePage1(ISelection selection) {
		super("wizardPage");
		setTitle(WIZARD_TITLE);
		setDescription("");
		this._selection = selection;
	}

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 3;
		layout.verticalSpacing = 9;
		
		Label label = new Label(container, SWT.NULL);
		label.setText("&Ecore file:");

		_ecore = new Text(container, SWT.BORDER | SWT.SINGLE);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		_ecore.setLayoutData(gd);
		_ecore.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});

		Button button = new Button(container, SWT.PUSH);
		button.setText("Browse...");
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				handleBrowse();
			}
		});
		
		label = new Label(container, SWT.NULL);
		label.setText("&Xmod_main:");
		_xmod_main = new Text(container, SWT.BORDER | SWT.SINGLE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		_xmod_main.setLayoutData(gd);
		_xmod_main.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});
		//label = new Label(container, SWT.NULL);
		//label.setText(""); // 3eme case vide
		
		initialize();
		dialogChanged();
		setControl(container);
	}
	
	/**
	 * Tests if the current workbench selection is a suitable
	 * container to use.
	 * 
	 * @see XmodelingProjectNewWizardFromExistingEcorePage1#_ecore
	 * @see XmodelingProjectNewWizardFromExistingEcorePage1#_selection
	 */
	private void initialize() {
		if (_selection!=null && _selection.isEmpty()==false && _selection instanceof IStructuredSelection) {
			IStructuredSelection ssel = (IStructuredSelection)_selection;
			if (ssel.size()>1) return;
			Object obj = ssel.getFirstElement();
			if (obj instanceof IResource) {
				IContainer container;
				if (obj instanceof IContainer)
					container = (IContainer)obj;
				else
					container = ((IResource)obj).getParent();
				_ecore.setText(container.getFullPath().toString());
			}
		}
	}
	
	/**
	 * Uses the file dialog to choose the new value for the ecore field.
	 * The Xmod_main is automatically set if the annotation exists in the ecore file.
	 * 
	 * @see XmodelingProjectNewWizardFromExistingEcorePage1#_ecore
	 * @see XmodelingProjectNewWizardFromExistingEcorePage1#_xmod_main
	 * @see XmodelingProjectNewWizardFromExistingEcorePage1#setSourcePackage(String)
	 */
	private void handleBrowse() {
		
		/* Init */
		File f;
		DocumentBuilderFactory factory;
		DocumentBuilder builder;
		Document document;
		Element root;
		NodeList rootNode;
		int rootNodeNb, annotationsNodeNb;
		Element eClassifiers;
		NodeList eAnnotations;
		FileDialog fd;
		String[] filterExt = {"*.ecore"};
		String selected;
		Element annotations;
		
		/* Body */
		fd = new FileDialog(new Shell(), SWT.OPEN);
		fd.setText("Select ecore file");
		fd.setFilterExtensions(filterExt);
		selected = fd.open();
		_ecore.setText(selected);
		
		f = new File(selected);
		factory = DocumentBuilderFactory.newInstance();
		try {
			builder = factory.newDocumentBuilder();
			document = builder.parse(f);
			root = document.getDocumentElement();
			setSourcePackage(root.getAttribute("name"));
			rootNode = root.getChildNodes();
			rootNodeNb = rootNode.getLength();
			for (int i = 0; i<rootNodeNb; i++) {
				if(rootNode.item(i).getNodeType() == Node.ELEMENT_NODE) {
					eClassifiers = (Element) rootNode.item(i);
					eAnnotations = eClassifiers.getElementsByTagName("eAnnotations");
					annotationsNodeNb = eAnnotations.getLength();
					for(int j=0; j< annotationsNodeNb; j++) {
						annotations = (Element) eAnnotations.item(j);
						if(annotations.getAttribute("source").equals("Xmod_main")) {
							_xmod_main.setText(eClassifiers.getAttribute("name"));
							_xmod_main.setEditable(false);
						}
					}
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Ensures that both text fields are set.
	 * 
	 * @see XmodelingProjectNewWizardFromExistingEcorePage1#getEcore()
	 * @see XmodelingProjectNewWizardFromExistingEcorePage1#getXmodMain()
	 */
	private void dialogChanged() {
		
		/* Init */
		String ecore = getEcore();
		String xmod_main = getXmodMain();
		File f = new File(ecore);
		DocumentBuilderFactory factory;
		DocumentBuilder builder;
		Document document;
		Element root;
		NodeList rootNode;
		int rootNodeNb;
		Boolean trouveMain = false;
		Element eClassifiers;
		
		/* Body */
		//ecore
		if (ecore.length() == 0 || !ecore.endsWith(".ecore")) {
			updateStatus("Ecore file must be specified");
			return;
		}
		//xmod_main
		if (xmod_main.length() == 0) {
			updateStatus("Xmod_main annotation must be specified");
			return;
		}
		if (xmod_main.length() != 0 && ecore.endsWith(".ecore")) {
			factory = DocumentBuilderFactory.newInstance();
			try {
				builder = factory.newDocumentBuilder();
				document = builder.parse(f);
				root = document.getDocumentElement();
				rootNode = root.getChildNodes();
				rootNodeNb = rootNode.getLength();
				for (int i = 0; i<rootNodeNb; i++) {
					if(rootNode.item(i).getNodeType() == Node.ELEMENT_NODE) {
						eClassifiers = (Element) rootNode.item(i);
						if(xmod_main.equals(eClassifiers.getAttribute("name"))) {
							trouveMain = true;
						}
					}
				}
				if (!trouveMain) {
					updateStatus("Xmod_main annotation \""+xmod_main+"\" is not valid.");
					return;
				}
				
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		updateStatus(null);
	}

	/**
	 * Updates the status of the page.
	 * 
	 * @param message
	 * 			Error message displayed.
	 */
	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}

	/**
	 * Returns the value of ecore.
	 * 
	 * @return a String that is corresponding to the name of the ecore file.
	 */
	public String getEcore() {
		return _ecore.getText();
	}
	
	/**
	 * Returns the value of xmodMain.
	 * 
	 * @return a String that is corresponding to the name of the class which is annotated with Xmod_main.
	 */
	public String getXmodMain() {
		return _xmod_main.getText();
	}
	
	/**
	 * Updates the sourcePackage value.
	 * 
	 * @param source
	 * 			String that is corresponding to the name of the source package of the ecore file.
	 */
	public void setSourcePackage(String source) {
		_sourcePackage = source;
	}
	
	/**
	 * Returns the value of sourcePackage.
	 * 
	 * @return a String that is corresponding to the name if the source package of the ecore file.
	 */
	public String getSourcePackage() {
		return _sourcePackage;
	}

}
