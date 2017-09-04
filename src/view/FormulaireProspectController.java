package view;

import java.io.File;

import util.DateUtil;
import controller.MainApp;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Adresse;
import model.Client;
import model.Prospect;
//import util.DateUtil;
import model.Representant;

public class FormulaireProspectController {
	private MainApp mainApp;
	private Client client;
	private Stage dialogStage;
	private boolean okClicked = false;

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		// Add observable list data to the table
		tableProspect.setItems(mainApp.getProspectData());

	}

	@FXML
	private Button bSauvegarder;
	@FXML
	private Button bAnnuler;
	@FXML
	private MenuItem fClient;
	@FXML
	private MenuItem fRepresentant;
	@FXML
	private MenuItem fProspect;
	@FXML
	private MenuItem fExit;

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
	private TableView<Prospect> tableProspect;

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

	private Prospect prospect;

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		// Initialize the client table with the columns.
		tcPrenom.setCellValueFactory(cellData -> (cellData.getValue()).prenomProperty());
		tcNom.setCellValueFactory(cellData -> (cellData.getValue()).nomProperty());

		tcTel.setCellValueFactory(cellData -> (cellData.getValue()).telProperty());
		tcMail.setCellValueFactory(cellData -> (cellData.getValue()).emailProperty());

		tcEnseigne.setCellValueFactory(cellData -> (cellData.getValue()).enseigneProperty());

		// Clear person details.
		showProspectDetails(null);

		// Listen for selection changes and show the client details when
		// changed.
		tableProspect.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showProspectDetails(newValue));
	}

	/**
	 * Sets the stage of this dialog.
	 *
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	@FXML
	private void handleclient() {
		mainApp.showClientOverview();
	}

	@FXML
	private void handlerepresentant() {
		mainApp.showrepresentantOverview();
	}

	@FXML
	private void handleprospect() {
		mainApp.showprospectOverview();
	}

	@FXML
	private void formulairerepresentant() {
		mainApp.showFormulaireRepresentant(null);
	}

	@FXML
	private void formulaiprospect() {
		mainApp.showFormulaireProspect(null);
	}

	@FXML
	private void formulaiclient() {
		mainApp.showFormulaireProspect(null);
	}

	/**
	 * Returns true if the user clicked OK, false otherwise.
	 *
	 * @return
	 */
	public boolean isOkClicked() {
		return okClicked;
	}

	@FXML
	private void handleOk() {
		if (isInputValid()) {

			prospect.setPrenom(tfPrenom.getText());
			prospect.setNom(tfNom.getText());
			prospect.setCivilite(tfCivilite.getText());
			prospect.setFonction(tfFonction.getText());
			prospect.setEmail(tfMail.getText());
			prospect.setTel(tfTel.getText());
			// client.setIdentifiantC(Integer.parseInt(tfIdClient.getText()));
			// client.getRepresentant().setIdentifiantR(Integer.parseInt(tfIdRepresentant.getText()));
			// client.setNbCommande(Integer.parseInt(tfCommande.getText()));
			prospect.setEnseigne(tfEnseigne.getText());
			prospect.setSiret(tfSiret.getText());
			prospect.setDateVisite(DateUtil.parse(tfDate.getText()));
			
		

			prospect.getAdresse().setVoie(tfVoie.getText());
			prospect.getAdresse().setNum(Integer.parseInt(tfNum.getText()));
			prospect.getAdresse().setNomVoie(tfLibelle.getText());
			prospect.getAdresse().setComplement(tfComplement.getText());
			prospect.getAdresse().setCp(Integer.parseInt(tfCP.getText()));
			prospect.getAdresse().setVille(tfVille.getText());
			prospect.getAdresse().setBp(tfBoite.getText());
			prospect.getAdresse().setPays(tfPays.getText());

			okClicked = true;
			// dialogStage.close();
			mainApp.getProspectData().add(prospect);
			mainApp.showprospectOverview();
			
			
		}
	}

	/**
	 * Called when the user clicks the new button. Opens a dialog to edit
	 * details for a new person.
	 */
	@FXML
	private void handleNewClient() {
		Client tempClient = new Client();
		boolean okClicked = mainApp.showFormulaireClient(tempClient);

		if (okClicked) {

			mainApp.getClientData().add(tempClient);
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
	private void handleNewProspect() {
		Prospect tempProspect = new Prospect();
		boolean okClicked = mainApp.showFormulaireProspect(tempProspect);

		if (okClicked) {

			mainApp.getProspectData().add(tempProspect);
		}
	}

	@FXML
	private void handleOkedit() {
		if (isInputValid()) {
			Prospect selectedProspect = tableProspect.getSelectionModel().getSelectedItem();

			selectedProspect.setPrenom(tfPrenom.getText());
			selectedProspect.setNom(tfNom.getText());
			selectedProspect.setCivilite(tfCivilite.getText());
			selectedProspect.setFonction(tfFonction.getText());
			selectedProspect.setEmail(tfMail.getText());
			selectedProspect.setTel(tfTel.getText());
			// selectedClient.setIdentifiantC(Integer.parseInt(tfIdClient.getText()));
			client.getRepresentant().setIdentifiantR(Integer.parseInt(tfIdRepresentant.getText()));
			// selectedClient.setNbCommande(Integer.parseInt(tfCommande.getText()));
			selectedProspect.setEnseigne(tfEnseigne.getText());
			selectedProspect.setSiret(tfSiret.getText());

			selectedProspect.getAdresse().setVoie(tfVoie.getText());
			selectedProspect.getAdresse().setNum(Integer.parseInt(tfNum.getText()));
			selectedProspect.getAdresse().setNomVoie(tfLibelle.getText());
			selectedProspect.getAdresse().setComplement(tfComplement.getText());
			selectedProspect.getAdresse().setCp(Integer.parseInt(tfCP.getText()));
			selectedProspect.getAdresse().setVille(tfVille.getText());
			selectedProspect.getAdresse().setBp(tfBoite.getText());
			selectedProspect.getAdresse().setPays(tfPays.getText());

			okClicked = true;
			// dialogStage.close();
			// mainApp.getClientData().add(client);
		}
	}

	private void showProspectDetails(Prospect prospect) {
		if (client != null) {

		}

	}

	/**
	 * Sets the client to be edited in the dialog.
	 *
	 */
	public void setProspect(Prospect prospect) {
		this.prospect = prospect;
		tfDate.setText(DateUtil.format(prospect.getDate()));
		tfDate.setPromptText("dd.mm.yyyy");

	}

	/**
	 * Validates the user input in the text fields.
	 *
	 * @return true if the input is valid
	 */
	private boolean isInputValid() {
		String errorMessage = "";

		if (tfPrenom.getText() == null || tfPrenom.getText().length() == 0) {
			errorMessage += "prenom non valide!\n";
		}
		if (tfNom.getText() == null || tfNom.getText().length() == 0) {
			errorMessage += "nom non valide!\n";
		}
		if (tfLibelle.getText() == null || tfLibelle.getText().length() == 0) {
			errorMessage += "rue non Valide!\n";
		}

		if (tfCP.getText() == null || tfCP.getText().length() == 0) {
			errorMessage += "code postal non valide!\n";
		} else {
			// try to parse the postal code into an int.
			try {
				Integer.parseInt(tfCP.getText());
			} catch (NumberFormatException e) {
				errorMessage += "code postal non valide (must be an integer)!\n";
			}
		}

		if (tfVille.getText() == null || tfVille.getText().length() == 0) {
			errorMessage += "ville non valide!\n";
		}

		if (errorMessage.length() == 0) {
			return true;
		} else {
			// Show the error message.
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);

			alert.showAndWait();

			return false;
		}
	}

	/**
	 * Opens a FileChooser to let the user select an address book to load.
	 */
	@FXML
	private void handleOpen() {
		FileChooser fileChooser = new FileChooser();

		// Set extension filter
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
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
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
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