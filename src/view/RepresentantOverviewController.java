package view;

import controller.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.Adresse;
import model.Client;
import model.Representant;

public class RepresentantOverviewController {
	private MainApp mainApp;

	public void setMainApp(MainApp mainApp) {
	    this.mainApp = mainApp;
	    // Add observable list data to the table
	    representantTable.setItems(mainApp.getRepresentantData());
	   
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
	private TextField tfIdRepresentant;
	@FXML
	private TextField tfCommission;
	@FXML
	private TextField tfSalaire;
	
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
	private void formulairerepresentant(){
		mainApp.showFormulaireRepresentant();
	}
	@FXML
	private void formulaiprospect(){
		mainApp.showFormulaireProspect();
	}
	@FXML
	private void formulaiclient(){
		mainApp.showFormulaireClient(null);
	}
	Adresse adresse = new Adresse();
	
	private void showRepresentantDetails(Representant representant) {
	    if (representant != null) {
	        // Fill the labels with info from the person object.
	    	
	    	tfEnseigne.setText(representant.getEnseigne());
	        tfSiret.setText(representant.getSiret());
	        tfCivilite.setText(representant.getCivilite());
	        tfPrenom.setText(representant.getPrenom());
	        tfNom.setText(representant.getNom());
	        tfFonction.setText(representant.getFonction());
	        tfTel.setText(representant.getTel());
	        tfMail.setText(representant.getEmail());
	        
	        tfIdRepresentant.setText(representant.getIdentifiantR().toString());
	        
	        tfPays.setText(representant.getAdresse().getPays());
	        tfNum.setText(representant.getAdresse().getNum().toString());
	    	tfVoie.setText(representant.getAdresse().getVoie());
	    	tfLibelle.setText(representant.getAdresse().getNomVoie());
	    	tfComplement.setText(representant.getAdresse().getComplement());
	    	tfBoite.setText(representant.getAdresse().getBp().toString());
	        tfCP.setText(representant.getAdresse().getCp().toString());
	        tfVille.setText(representant.getAdresse().getVille());
	        
	        tfSalaire.setText(representant.getSalaire().toString());
	        tfCommission.setText(representant.getTauxCommission().toString());

	        
	    	
	        

	      
	            
	       
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
	        
	        
	        tfIdRepresentant.setText("");
	        tfSalaire.setText("");
	        tfCommission.setText("");
	    }
	}
	/**
	 * The constructor.
	 * The constructor is called before the initialize() method.
	 * @return 
	 */
	public RepresentantOverviewController() {
	}
	
	@FXML
	private void initialize() {
	    // Initialize the client table with the two columns.
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
	@FXML
	private void handleDeleteRepresentant() {
	    int selectedIndex = representantTable.getSelectionModel().getSelectedIndex();
	    if (selectedIndex >= 0) {
	        representantTable.getItems().remove(selectedIndex);
	    } else {
	        // Nothing selected.
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(mainApp.getPrimaryStage());
	        alert.setTitle("No Selection");
	        alert.setHeaderText("No representant Selected");
	        alert.setContentText("Please select a representant in the table.");

	        alert.showAndWait();
	    }
}
}	



