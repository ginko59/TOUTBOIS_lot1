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
import javafx.stage.Stage;
import model.Client;
import model.Representant;

public class FormulaireRepresentantController {
	
	private MainApp mainApp;
	private Representant representant;
	private Stage dialogStage;
	private boolean okClicked = false;

	public void setMainApp(MainApp mainApp) {
	    this.mainApp = mainApp;
	    representantTable.setItems(mainApp.getRepresentantData());
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
	private TextField tfCommande;
	@FXML
	private TextField tfSalaire;
	@FXML
	private TextField tfCommission;
	
	
	
	@FXML
	private TableView<Representant> representantTable;
	
	@FXML
	private TableColumn<Representant, Integer> tcIdR;
	
	@FXML
	private TableColumn<Representant, String> tcNom;
	@FXML
	private TableColumn<Representant, String> tcPrenom;
	@FXML
	private TableColumn<Representant, String> tcTel;
	@FXML
	private TableColumn<Representant, String> tcMail;
	
	
    
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
	private void formulaireprospect(){
		mainApp.showFormulaireProspect();
	}
	@FXML
	private void formulaireclient(){
		mainApp.showFormulaireClient(null);
	}
	
	 @FXML
	    private void initialize() {
	    	 // Initialize the client table with the columns.
		 	tcPrenom.setCellValueFactory(cellData -> (cellData.getValue()).prenomProperty());
		    tcNom.setCellValueFactory(cellData -> (cellData.getValue()).nomProperty());
		    tcIdR.setCellValueFactory(cellData -> (cellData.getValue()).identifiantRProperty().asObject());
		    tcTel.setCellValueFactory(cellData -> (cellData.getValue()).telProperty());
		    tcMail.setCellValueFactory(cellData -> (cellData.getValue()).emailProperty());
	       
	     // Clear person details.
	        showRepresentantDetails(null);
	     
	        // Listen for selection changes and show the client details when changed.
	       representantTable.getSelectionModel().selectedItemProperty().addListener(
	               (observable, oldValue, newValue) -> showRepresentantDetails(newValue));
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
		    private void handleOpen() {
		        FileChooser fileChooser = new FileChooser();

		        // Set extension filter
		        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
		                "XML files (*.xml)", "*.xml");
		        fileChooser.getExtensionFilters().add(extFilter);

		        // Show save file dialog
		        File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());

		        if (file != null) {
		            mainApp.loadRepresentantDataFromFile(file);
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
		        	
		        	
		        	representant.setEnseigne(tfEnseigne.getText());
		        	representant.setSiret(tfSiret.getText());
		        	
		        	representant.setPrenom(tfPrenom.getText());
		        	representant.setNom(tfNom.getText());
		        	representant.setCivilite(tfCivilite.getText());
		        	representant.setFonction(tfFonction.getText());
		        	representant.setEmail(tfMail.getText());
		        	representant.setTel(tfTel.getText());
		        	//client.setIdentifiantC(Integer.parseInt(tfIdClient.getText()));
		        	//client.getRepresentant().setIdentifiantR(Integer.parseInt(tfIdRepresentant.getText()));
		        	representant.setSalaire(Float.parseFloat(tfSalaire.getText()));
		        	representant.setTauxCommission(Float.parseFloat(tfCommission.getText()));
		        	
		        	 
		        	
		        	representant.getAdresse().setVoie(tfVoie.getText());
		        	representant.getAdresse().setNum(Integer.parseInt(tfNum.getText()));
		        	representant.getAdresse().setNomVoie(tfLibelle.getText());
		        	representant.getAdresse().setComplement(tfComplement.getText());
		        	representant.getAdresse().setCp(Integer.parseInt(tfCP.getText()));
		        	representant.getAdresse().setVille(tfVille.getText());
		        	representant.getAdresse().setBp(Integer.parseInt(tfBoite.getText()));
		        	representant.getAdresse().setPays(tfPays.getText());
		                      
		           

		            okClicked = true;
		            //dialogStage.close();
		            mainApp.getRepresentantData().add(representant);
		        }
		    }
		    @FXML
		    private void handleOkedit() {
		        if (isInputValid()) {
		        	Representant selectedRepresentant = representantTable.getSelectionModel().getSelectedItem();
		        	
		        	selectedRepresentant.setPrenom(tfPrenom.getText());
		        	selectedRepresentant.setNom(tfNom.getText());
		        	selectedRepresentant.setCivilite(tfCivilite.getText());
		        	selectedRepresentant.setFonction(tfFonction.getText());
		        	selectedRepresentant.setEmail(tfMail.getText());
		        	selectedRepresentant.setTel(tfTel.getText());
		        	//selectedClient.setIdentifiantC(Integer.parseInt(tfIdClient.getText()));
		        	//selectedRepresentant.setIdentifiantR(Integer.parseInt(tfIdRepresentant.getText()));
		        	selectedRepresentant.setSalaire(Float.parseFloat(tfSalaire.getText()));
		        	selectedRepresentant.setTauxCommission(Float.parseFloat(tfCommission.getText()));
		        	selectedRepresentant.setEnseigne(tfEnseigne.getText());
		        	selectedRepresentant.setSiret(tfSiret.getText());
		        	 
		        	
		        	selectedRepresentant.getAdresse().setVoie(tfVoie.getText());
		        	selectedRepresentant.getAdresse().setNum(Integer.parseInt(tfNum.getText()));
		        	selectedRepresentant.getAdresse().setNomVoie(tfLibelle.getText());
		        	selectedRepresentant.getAdresse().setComplement(tfComplement.getText());
		        	selectedRepresentant.getAdresse().setCp(Integer.parseInt(tfCP.getText()));
		        	selectedRepresentant.getAdresse().setVille(tfVille.getText());
		        	selectedRepresentant.getAdresse().setBp(Integer.parseInt(tfBoite.getText()));
		        	selectedRepresentant.getAdresse().setPays(tfPays.getText());
		                      
		           

		            okClicked = true;
		            //dialogStage.close();
		            //mainApp.getClientData().add(client);
		        }
		    }
		    
		    private void showRepresentantDetails(Representant representant) {
		        if (representant != null) {
		        	
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
		   public void setRepresentant(Representant representant) {
		        this.representant = representant;

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