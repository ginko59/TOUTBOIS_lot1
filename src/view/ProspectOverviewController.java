package view;

import controller.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import model.Client;
import model.Representant;

public class ProspectOverviewController {
	private MainApp mainApp;

	public void setMainApp(MainApp mainApp) {
	    this.mainApp = mainApp;
	   
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
	private void formulairerepresentant(Representant representant){
		mainApp.showFormulaireRepresentant(representant);
	}
	@FXML
	private void formulaiprospect(){
		mainApp.showFormulaireProspect();
	}
	@FXML
	private void formulaiclient(Client client){
		mainApp.showFormulaireClient(client);
	}
}