package controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.ClientOverviewController;
import view.RepresentantOverviewController;
import view.StartOverviewController;
import view.ProspectOverviewController;
import view.FormulaireClientController;
import view.FormulaireProspectController;
import view.FormulaireRepresentantController;


public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    
   
    		
    		            
    

   @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("TOUTBOIS");
        this.primaryStage.setResizable(false);
     // Set the application icon.
        this.primaryStage.getIcons().add(new Image("file:ressources/logo.png"));

       initRootLayout();

       showStartOverview();
       
    }

   /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

           // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.sizeToScene();
            primaryStage.show();
           
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   /**
     * Shows the person overview inside the root layout.
     */
    public void showStartOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../view/StartOverview.fxml"));
            AnchorPane startOverview = (AnchorPane) loader.load();
         // Give the controller access to the main app
            StartOverviewController controller = loader.getController();
            controller.setMainApp(this);
            // Give the controller access to the main app
           
           // Set person overview into the center of root layout.
            rootLayout.setCenter(startOverview);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

   public static void main(String[] args) {
        launch(args);
    }

public void showClientOverview() {
	try {
        // Load person overview.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("../view/ClientOverview.fxml"));
        AnchorPane clientOverview = (AnchorPane) loader.load();
     // Give the controller access to the main app
        ClientOverviewController controller = loader.getController();
        controller.setMainApp(this);

       // Set person overview into the center of root layout.
        rootLayout.setCenter(clientOverview);
    } catch (IOException e) {
        e.printStackTrace();
    }
	
}

public void showrepresentantOverview() {
	try {
        // Load person overview.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("../view/RepresentantOverview.fxml"));
        AnchorPane representantOverview = (AnchorPane) loader.load();
     // Give the controller access to the main app
        RepresentantOverviewController controller = loader.getController();
        controller.setMainApp(this);

       // Set person overview into the center of root layout.
        rootLayout.setCenter(representantOverview);
    } catch (IOException e) {
        e.printStackTrace();
    }
	
}

public void showprospectOverview() {
	try {
        // Load  overview.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("../view/ProspectOverview.fxml"));
        AnchorPane prospectOverview = (AnchorPane) loader.load();
     // Give the controller access to the main app
        ProspectOverviewController controller = loader.getController();
        controller.setMainApp(this);

       // Set  overview into the center of root layout.
        rootLayout.setCenter(prospectOverview);
    } catch (IOException e) {
        e.printStackTrace();
    }
	
}

public void showFormulaireProspect() {
	try {
        // Load person overview.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("../view/FormulaireProspect.fxml"));
        AnchorPane formulaireProspect = (AnchorPane) loader.load();
     // Give the controller access to the main app
        FormulaireProspectController controller = loader.getController();
        controller.setMainApp(this);

       // Set person overview into the center of root layout.
        rootLayout.setCenter(formulaireProspect);
    } catch (IOException e) {
        e.printStackTrace();
    }
	
}
public void showFormulaireRepresentant() {
	try {
        // Load person overview.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("../view/FormulaireReprésentant.fxml"));
        AnchorPane formulaireRepresentant = (AnchorPane) loader.load();
     // Give the controller access to the main app
        FormulaireRepresentantController controller = loader.getController();
        controller.setMainApp(this);

       // Set person overview into the center of root layout.
        rootLayout.setCenter(formulaireRepresentant);
    } catch (IOException e) {
        e.printStackTrace();
    }
	
}

public void showFormulaireClient() {
	try {
        // Load person overview.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("../view/FormulaireClient.fxml"));
        AnchorPane formulaireClient = (AnchorPane) loader.load();
     // Give the controller access to the main app
        FormulaireClientController controller = loader.getController();
        controller.setMainApp(this);

       // Set person overview into the center of root layout.
        rootLayout.setCenter(formulaireClient);
    } catch (IOException e) {
        e.printStackTrace();
    }
	
}



}
