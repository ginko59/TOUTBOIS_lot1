package view;

import controller.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;

public class StartOverviewController {
	@FXML
    private Button bClient;
    @FXML
    private Button bRepresentant;
    @FXML
    private Button bProspect;
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
	private void handleclient(){
		MainApp.showClientOverview();
	}
	@FXML
	private void handlerepresentant(){
		MainApp.showrepresentantOverview();
	}
	@FXML
	private void handleprospect(){
		MainApp.showprospectOverview();
	}
	
	@FXML
	private void formulairerepresentant(){
		MainApp.showFormulaireRepresentant();
	}
	@FXML
	private void formulaiprospect(){
		MainApp.showFormulaireProspect();
	}
	@FXML
	private void formulaiclient(){
		MainApp.showFormulaireClient();
	}
}




