package view;

import controller.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;

public class FormulaireProspectController {

	@FXML
    private Button bSauvegarder;
    @FXML
    private Button bAnnuler;
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
	private void formulaireprospect(){
		MainApp.showFormulaireProspect();
	}

}