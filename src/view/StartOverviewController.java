package view;

import controller.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

public class StartOverviewController {
	@FXML
    private Button bClient;
    @FXML
    private Button bRepresentant;
    @FXML
    private Button bProspect;
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



}
