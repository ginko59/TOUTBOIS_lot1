package controller;

import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Client;
import model.ClientListWrapper;
import model.Contact;
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
    private ObservableList<Client> ClientData = FXCollections.observableArrayList();
	
    
    public ObservableList<Client> getClientData() {
		return ClientData;
	}
    		
    		            
    

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
/**
 * Returns the client file preference, i.e. the file that was last opened.
 * The preference is read from the OS specific registry. If no such
 * preference can be found, null is returned.
 * 
 * @return
 */
public File getClientFilePath() {
    Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
    String filePath = prefs.get("filePath", null);
    if (filePath != null) {
        return new File(filePath);
    } else {
        return null;
    }
}

/**
 * Sets the file path of the currently loaded file. The path is persisted in
 * the OS specific registry.
 * 
 * @param file the file or null to remove the path
 */
public void setClientFilePath(File file) {
    Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
    if (file != null) {
        prefs.put("filePath", file.getPath());

        // Update the stage title.
      //  primaryStage.setTitle("AddressApp - " + file.getName());
    } else {
        prefs.remove("filePath");

        // Update the stage title.
        //primaryStage.setTitle("AddressApp");
    }
}

public void showFormulaireClient() {
	try {
        // Load client overview.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("../view/FormulaireClient.fxml"));
        AnchorPane formulaireClient = (AnchorPane) loader.load();
     // Give the controller access to the main app
        FormulaireClientController controller = loader.getController();
        controller.setMainApp(this);

       // Set client overview into the center of root layout.
        rootLayout.setCenter(formulaireClient);
    } catch (IOException e) {
        e.printStackTrace();
    }
	
}


/**
 * Loads client data from the specified file. The current client data will
 * be replaced.
 * 
 * @param file
 */
public void loadClientDataFromFile(File file) {
    try {
        JAXBContext context = JAXBContext
                .newInstance(ClientListWrapper.class);
        Unmarshaller um = context.createUnmarshaller();

        // Reading XML from the file and unmarshalling.
       ClientListWrapper wrapper = (ClientListWrapper) um.unmarshal(file);

        ClientData.clear();
        ClientData.addAll(wrapper.getClients());

        // Save the file path to the registry.
        setClientFilePath(file);

    } catch (Exception e) { // catches ANY exception
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Could not load data");
        alert.setContentText("Could not load data from file:\n" + file.getPath());

        alert.showAndWait();
    }
}

/**
 * Saves the current Client data to the specified file.
 * 
 * @param file
 */
public void saveClientDataToFile(File file) {
    try {
        JAXBContext context = JAXBContext
                .newInstance(ClientListWrapper.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // Wrapping our client data.
        ClientListWrapper wrapper = new ClientListWrapper();
        wrapper.setClients(ClientData);

        // Marshalling and saving XML to the file.
        m.marshal(wrapper, file);

        // Save the file path to the registry.
        setClientFilePath(file);
    } catch (Exception e) { // catches ANY exception
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Could not save data");
        alert.setContentText("Could not save data to file:\n" + file.getPath());

        alert.showAndWait();
    }
}


}
