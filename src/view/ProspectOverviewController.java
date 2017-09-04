package view;

import java.io.File;

import controller.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import model.Client;
import model.Prospect;
import model.Representant;
import util.DateUtil;

public class ProspectOverviewController {
	private MainApp mainApp;

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		// Add observable list data to the table
		prospectTable.setItems(mainApp.getProspectData());
	}

	@FXML
	private Button bAjouter;
	@FXML
	private Button bModifier;
	@FXML
	private Button bSupprimer;
	@FXML
	private MenuItem fClient;
	@FXML
	private MenuItem fRepresentant;
	@FXML
	private MenuItem fProspect;

	@FXML
	private MenuItem aClient;
	@FXML
	private MenuItem aRepresentant;
	@FXML
	private MenuItem aProspect;
	@FXML
	private MenuItem mClient;
	@FXML
	private MenuItem mRepresentant;
	@FXML
	private MenuItem mProspect;
	
	@FXML
    private MenuItem fSave;
    @FXML
    private MenuItem fSaveAs;
    @FXML
    private MenuItem fOpen;
    @FXML
    private MenuItem fExit;
    
    @FXML
	private TextField tfEnseigne;
	@FXML
	private TextField tfSiret;
	@FXML
	private TextField tfNum;
	@FXML
	private TextField tfVoie;
	@FXML
	private TextField tfLibelle;
	@FXML
	private TextField tfComplement;
	@FXML
	private TextField tfBoite;
	@FXML
	private TextField tfCP;
	@FXML
	private TextField tfVille;
	@FXML
	private TextField tfPays;
	@FXML
	private TextField tfCivilite;
	@FXML
	private TextField tfNom;
	@FXML
	private TextField tfPrenom;
	@FXML
	private TextField tfFonction;
	@FXML
	private TextField tfTel;
	@FXML
	private TextField tfMail;
	@FXML
	private TextField tfIdClient;
	@FXML
	private TextField tfIdRepresentant;
	@FXML
	private TextField tfDate;
	
	@FXML
	private TableView<Prospect> prospectTable;
	@FXML
	private TableColumn<Prospect, Integer> tcId;
	@FXML
	private TableColumn<Prospect, String> tcEnseigne;
	@FXML
	private TableColumn<Prospect, String> tcNom;
	@FXML
	private TableColumn<Prospect, String> tcPrenom;
	@FXML
	private TableColumn<Prospect, String> tcTel;
	@FXML
	private TableColumn<Prospect, String> tcMail;
	@FXML
	private TableColumn<Prospect, Integer> tcNbCom;

	@FXML
	private void handleclient(){
		mainApp.showClientOverview();
	}
	@FXML
	private void handlerepresentant(){
		mainApp.showrepresentantOverview();
	}
	@FXML
	private void handleprospect(){
		mainApp.showprospectOverview();
	}
	
	@FXML
	private void formulairerepresentant(){
		//mainApp.showFormulaireRepresentant();
	}

	
	@FXML
	private void formulaireprospect() {
		mainApp.showFormulaireProspect(null);
	}

	@FXML
	private void formulaireclient() {
		mainApp.showFormulaireClient(null);

	}

	@FXML
	private void formulaireEditClient() {
		mainApp.showFormulaireEditClient(null);
	
	
}
	
	private void showProspectDetails(Prospect prospect) {
		if (prospect != null) {
			// Fill the textfield with info from the client object.

			tfEnseigne.setText(prospect.getEnseigne());
			tfSiret.setText(prospect.getSiret());
			tfCivilite.setText(prospect.getCivilite());
			tfPrenom.setText(prospect.getPrenom());
			tfNom.setText(prospect.getNom());
			tfFonction.setText(prospect.getFonction());
			tfTel.setText(prospect.getTel());
			tfMail.setText(prospect.getEmail());
			//tfCommande.setText(prospect.getNbCommande().toString());

			

			tfPays.setText(prospect.getAdresse().getPays());
			tfNum.setText(prospect.getAdresse().getNum().toString());
			tfVoie.setText(prospect.getAdresse().getVoie());
			tfLibelle.setText(prospect.getAdresse().getNomVoie());
			tfComplement.setText(prospect.getAdresse().getComplement());
			tfBoite.setText(prospect.getAdresse().getBp().toString());
			tfCP.setText(prospect.getAdresse().getCp().toString());
			tfVille.setText(prospect.getAdresse().getVille());
			System.out.println(DateUtil.format(prospect.getDate()));
			tfDate.setText(DateUtil.format(prospect.getDate()));
			tfDate.setPromptText("dd.MM.yyyy");

			//tfIdRepresentant.setText(prospect.getRepresentant().getIdentifiantR().toString());

		} else {
			// Client is null, remove all the text.

			tfEnseigne.setText("");
			tfSiret.setText("");

			tfNum.setText("");
			tfVoie.setText("");
			tfLibelle.setText("");
			tfComplement.setText("");
			tfBoite.setText("");
			tfCP.setText("");
			tfVille.setText("");
			tfPays.setText("");

			tfCivilite.setText("");
			tfPrenom.setText("");
			tfNom.setText("");
			tfFonction.setText("");
			tfTel.setText("");
			tfMail.setText("");
			//tfCommande.setText("");

			//tfIdClient.setText("");
			// tfIdRepresentant.setText("");
		}
	}
	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 * 
	 * @return
	 */
	public ProspectOverviewController() {
	}
	
	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */

	@FXML
	private void initialize() {
		// Initialize the client table with the columns.
		tcPrenom.setCellValueFactory(cellData -> (cellData.getValue()).prenomProperty());
		tcNom.setCellValueFactory(cellData -> (cellData.getValue()).nomProperty());
		//tcId.setCellValueFactory(cellData -> (cellData.getValue()).identifiantCProperty().asObject());
		tcTel.setCellValueFactory(cellData -> (cellData.getValue()).telProperty());
		tcMail.setCellValueFactory(cellData -> (cellData.getValue()).emailProperty());
		//tcNbCom.setCellValueFactory(cellData -> (cellData.getValue()).nbCommandeProperty().asObject());
		tcEnseigne.setCellValueFactory(cellData -> (cellData.getValue()).enseigneProperty());

		// Clear person details.
		showProspectDetails(null);
		// Listen for selection changes and show the client details when
		// changed.
		prospectTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showProspectDetails(newValue));

	}
	
	/**
	 * Called when the user clicks on the delete button.
	 */
	@FXML
	private void handleDeleteProspect() {
		int selectedIndex = prospectTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			prospectTable.getItems().remove(selectedIndex);
		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No client Selected");
			alert.setContentText("Please select a client in the table.");

			alert.showAndWait();
		}

	}

	@FXML
	private void handleEditProspect() {

		Prospect selectedProspect = prospectTable.getSelectionModel().getSelectedItem();

		boolean okClicked = mainApp.showFormulaireEditProspect(selectedProspect);
		mainApp.showFormulaireEditProspect(selectedProspect);

		if (selectedProspect != null) {
			showProspectDetails(selectedProspect);

		}

		if (okClicked) {
			/*
			 * else { // Nothing selected. Alert alert = new
			 * Alert(AlertType.WARNING);
			 * alert.initOwner(mainApp.getPrimaryStage());
			 * alert.setTitle("No Selection");
			 * alert.setHeaderText("No CLient Selected");
			 * alert.setContentText("Please select a client in the table.");
			 * 
			 * alert.showAndWait();
			 */
		}
	}

	/**
	 * Called when the user clicks the new button. Opens a dialog to edit
	 * details for a new person.
	 */
	@FXML
	private void handleNewProspect() {
		Prospect tempProspect = new Prospect();
		boolean okClicked = mainApp.showFormulaireProspect(tempProspect);

		if (okClicked) {

			mainApp.getProspectData().add(tempProspect);
		}
	}
	@FXML
	private void handleNewRepresentant() {
		Representant tempRepresentant = new Representant();
		boolean okClicked = mainApp.showFormulaireRepresentant(tempRepresentant);

		if (okClicked) {

			mainApp.getRepresentantData().add(tempRepresentant);
		}
	}
	 @FXML
	    private void handleNew() {
	        mainApp.getProspectData().clear();
	        mainApp.setProspectFilePath(null);
	    }
	 @FXML
		private void handleNewClient() {
			Client tempClient = new Client();
			boolean okClicked = mainApp.showFormulaireClient(tempClient);

			if (okClicked) {

				mainApp.getClientData().add(tempClient);
			}
		}

	    /**
	     * Opens a FileChooser to let the user select an address book to load.
	     */
	    @FXML
	    private void handleOpen() {
	        FileChooser fileChooser = new FileChooser();

	        // Set extension filter
	        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
	                "XML files (*.xml)", "*.xml");
	        fileChooser.getExtensionFilters().add(extFilter);

	        // Show save file dialog
	        File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());

	        if (file != null) {
	            mainApp.loadProspectDataFromFile(file);
	        }
	    }

	    /**
	     * Saves the file to the person file that is currently open. If there is no
	     * open file, the "save as" dialog is shown.
	     */
	    @FXML
	    private void handleSave() {
	        File prospectFile = mainApp.getProspectFilePath();
	        if (prospectFile != null) {
	            mainApp.saveProspectDataToFile(prospectFile);
	        } else {
	            handleSaveAs();
	        }
	    }

	    /**
	     * Opens a FileChooser to let the user select a file to save to.
	     */
	    @FXML
	    private void handleSaveAs() {
	        FileChooser fileChooser = new FileChooser();

	        // Set extension filter
	        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
	                "XML files (*.xml)", "*.xml");
	        fileChooser.getExtensionFilters().add(extFilter);

	        // Show save file dialog
	        File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());

	        if (file != null) {
	            // Make sure it has the correct extension
	            if (!file.getPath().endsWith(".xml")) {
	                file = new File(file.getPath() + ".xml");
	            }
	            mainApp.saveProspectDataToFile(file);
	        }
	    }
	    /**
	     * Closes the application.
	     */
	    @FXML
	    private void handleExit() {
	        System.exit(0);
	    }
}


