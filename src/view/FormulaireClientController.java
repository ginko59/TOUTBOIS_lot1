package view;

import java.io.File;

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
//import util.DateUtil;


public class FormulaireClientController {
	private MainApp mainApp;
	private Client client;
	private Stage dialogStage;
	private boolean okClicked = false;
	public void setMainApp(MainApp mainApp) {
	    this.mainApp = mainApp;
	    // Add observable list data to the table
	    clientTable.setItems(mainApp.getClientData());
	   
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
	private TextField tfCommande;
	
	@FXML
	private TableView<Client> clientTable;
	@FXML
	private TableColumn<Client, Integer> tcId;
	@FXML
	private TableColumn<Client, String> tcEnseigne;
	@FXML
	private TableColumn<Client, String> tcNom;
	@FXML
	private TableColumn<Client, String> tcPrenom;
	@FXML
	private TableColumn<Client, String> tcTel;
	@FXML
	private TableColumn<Client, String> tcMail;
	@FXML
	private TableColumn<Client, Integer> tcNbCom;
	
	 /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	 // Initialize the client table with the columns.
        tcPrenom.setCellValueFactory(cellData -> (cellData.getValue()).prenomProperty());
        tcNom.setCellValueFactory(cellData -> (cellData.getValue()).nomProperty());
        tcId.setCellValueFactory(cellData -> (cellData.getValue()).identifiantCProperty().asObject());
        tcTel.setCellValueFactory(cellData -> (cellData.getValue()).telProperty());
        tcMail.setCellValueFactory(cellData -> (cellData.getValue()).emailProperty());
        tcNbCom.setCellValueFactory(cellData -> (cellData.getValue()).nbCommandeProperty().asObject());
        tcEnseigne.setCellValueFactory(cellData -> (cellData.getValue()).enseigneProperty());
       
     // Clear person details.
        showClientDetails(null);
     
        // Listen for selection changes and show the client details when changed.
       clientTable.getSelectionModel().selectedItemProperty().addListener(
               (observable, oldValue, newValue) -> showClientDetails(newValue));
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
		mainApp.showFormulaireRepresentant(null);
	}
	@FXML
	private void formulaiprospect(){
		mainApp.showFormulaireProspect();
	}
	@FXML
	private void formulaiclient(){
		mainApp.showFormulaireProspect();
	}
	
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
	            mainApp.loadClientDataFromFile(file);
	        }
	        
	        
	    }
	 
	 @FXML
	    private void handleSave() {
	        File clientFile = mainApp.getClientFilePath();
	        if (clientFile != null) {
	            mainApp.saveClientDataToFile(clientFile);
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
	            mainApp.saveClientDataToFile(file);
	        }
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
	        	
	        	client.setPrenom(tfPrenom.getText());
	        	client.setNom(tfNom.getText());
	        	client.setCivilite(tfCivilite.getText());
	        	client.setFonction(tfFonction.getText());
	        	client.setEmail(tfMail.getText());
	        	client.setTel(tfTel.getText());
	        	//client.setIdentifiantC(Integer.parseInt(tfIdClient.getText()));
	        	//client.getRepresentant().setIdentifiantR(Integer.parseInt(tfIdRepresentant.getText()));
	        	client.setNbCommande(Integer.parseInt(tfCommande.getText()));
	        	client.setEnseigne(tfEnseigne.getText());
	        	client.setSiret(tfSiret.getText());
	        	 
	        	
	        	client.getAdresse().setVoie(tfVoie.getText());
	        	client.getAdresse().setNum(Integer.parseInt(tfNum.getText()));
	        	client.getAdresse().setNomVoie(tfLibelle.getText());
	        	client.getAdresse().setComplement(tfComplement.getText());
	        	client.getAdresse().setCp(Integer.parseInt(tfCP.getText()));
	        	client.getAdresse().setVille(tfVille.getText());
	        	client.getAdresse().setBp(Integer.parseInt(tfBoite.getText()));
	        	client.getAdresse().setPays(tfPays.getText());
	                      
	           

	            okClicked = true;
	            //dialogStage.close();
	            mainApp.getClientData().add(client);
	        }
	    }
	    @FXML
	    private void handleOkedit() {
	        if (isInputValid()) {
	        	Client selectedClient = clientTable.getSelectionModel().getSelectedItem();
	        	
	        	selectedClient.setPrenom(tfPrenom.getText());
	        	selectedClient.setNom(tfNom.getText());
	        	selectedClient.setCivilite(tfCivilite.getText());
	        	selectedClient.setFonction(tfFonction.getText());
	        	selectedClient.setEmail(tfMail.getText());
	        	selectedClient.setTel(tfTel.getText());
	        	//selectedClient.setIdentifiantC(Integer.parseInt(tfIdClient.getText()));
	        	client.getRepresentant().setIdentifiantR(Integer.parseInt(tfIdRepresentant.getText()));
	        	selectedClient.setNbCommande(Integer.parseInt(tfCommande.getText()));
	        	selectedClient.setEnseigne(tfEnseigne.getText());
	        	selectedClient.setSiret(tfSiret.getText());
	        	 
	        	
	        	selectedClient.getAdresse().setVoie(tfVoie.getText());
	        	selectedClient.getAdresse().setNum(Integer.parseInt(tfNum.getText()));
	        	selectedClient.getAdresse().setNomVoie(tfLibelle.getText());
	        	selectedClient.getAdresse().setComplement(tfComplement.getText());
	        	selectedClient.getAdresse().setCp(Integer.parseInt(tfCP.getText()));
	        	selectedClient.getAdresse().setVille(tfVille.getText());
	        	selectedClient.getAdresse().setBp(Integer.parseInt(tfBoite.getText()));
	        	selectedClient.getAdresse().setPays(tfPays.getText());
	                      
	           

	            okClicked = true;
	            //dialogStage.close();
	            //mainApp.getClientData().add(client);
	        }
	    }
	    
	    private void showClientDetails(Client client) {
	        if (client != null) {
	        	
	        	//Client client = clientTable.getSelectionModel().getSelectedItem();
	        	
	            // Fill the textfield with info from the client object.
	        	
	        	/*tfEnseigne.setText(client.getEnseigne());
	            tfSiret.setText(client.getSiret());
	            tfCivilite.setText(client.getCivilite());
	            tfPrenom.setText(client.getPrenom());
	            tfNom.setText(client.getNom());
	            tfFonction.setText(client.getFonction());
	            tfTel.setText(client.getTel());
	            tfMail.setText(client.getEmail());
	            tfCommande.setText(client.getNbCommande().toString());
	            
	            tfIdClient.setText(client.getIdentifiantC().toString());
	            
	            tfPays.setText(client.getAdresse().getPays());
	            tfNum.setText(client.getAdresse().getNum().toString());
	        	tfVoie.setText(client.getAdresse().getVoie());
	        	tfLibelle.setText(client.getAdresse().getNomVoie());
	        	tfComplement.setText(client.getAdresse().getComplement());
	        	tfBoite.setText(client.getAdresse().getBp().toString());
	            tfCP.setText(client.getAdresse().getCp().toString());
	            tfVille.setText(client.getAdresse().getVille());*/
	            
	        
	            
	            
	        	
	            //tfIdRepresentant.setText(client.getRepresentant().getIdentifiantR().toString());

	          
	        }  
	           
	        }
	    
	    
	   
	        
	    
	    /**
	     * Sets the client to be edited in the dialog.
	     *
	     */
	   public void setClient(Client client) {
	        this.client = client;

/*
	        tfEnseigne.setText(client.getEnseigne());
	        tfSiret.setText(client.getSiret());
	        tfPrenom.setText(client.getPrenom());
	        tfNom.setText(client.getNom());
	        tfCivilite.setText(client.getCivilite());
	        tfFonction.setText(client.getFonction());
	        tfTel.setText(client.getTel());
	        tfMail.setText(client.getEmail());
	        tfNum.setText(Integer.toString(client.adresse.getNum()));
	        tfVoie.setText(client.adresse.getVoie());
	        tfLibelle.setText(client.adresse.getNomVoie());
	        tfComplement.setText(client.adresse.getComplement());
	        tfBoite.setText(Integer.toString(client.adresse.getBp()));
	        tfCP.setText(Integer.toString(client.adresse.getCp()));
	        tfVille.setText(client.adresse.getVille());
	        tfPays.setText(client.adresse.getPays());
	        tfIdClient.setText(Integer.toString(client.getIdentifiantC()));
	        tfCommande.setText(Integer.toString(client.getNbCommande()));
	       */
	        //tfIdRepresentant.setText(Integer.toString(client.representant.getIdentifiantR()));
	        
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
	    
	        
	    
}