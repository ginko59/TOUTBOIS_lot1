package controller;

import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
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
import model.Adresse;
import model.Client;
import model.ClientListWrapper;
//import model.ClientListWrapper;
import model.Contact;
import model.Prospect;
import model.ProspectListWrapper;
import model.Representant;
import model.RepresentantListWrapper;
import view.ClientOverviewController;
import view.FormulaireClientController;
import view.RepresentantOverviewController;
import view.StartOverviewController;
import view.ProspectOverviewController;
import view.FormulaireEditClientController;
import view.FormulaireEditProspectController;
import view.FormulaireProspectController;
import view.FormulaireRepresentantController;
import view.FormulaireEditRepresentantController;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	/**
	 * The data as an observable list of Clients.
	 */
	private ObservableList<Client> clientData = FXCollections.observableArrayList();
	private ObservableList<Representant> representantData = FXCollections.observableArrayList();
	private ObservableList<Prospect> prospectData = FXCollections.observableArrayList();
	
	public MainApp() {
		// Add some sample data
		/*representantData.add(new Representant("abcb", "Muster","MMe","medecin","lll@gmail","063522","IBM1","001122"));
		representantData.add(new Representant("hfls", "Mueller","MMe","medecin","lll@gmail","063522","IBM2","001122"));
		representantData.add(new Representant("azerty", "Kurz","MMe","medecin","lll@gmail","063522","IBM3","001122"));
		
		clientData.add(new Client("Hans", "Muster","MMe","medecin","lll@gmail","063522",121,"IBM1","001122"));
		clientData.add(new Client("Ruth", "Mueller","MMe","medecin","lll@gmail","063522",122,"IBM2","001122"));
		clientData.add(new Client("Heinz", "Kurz","MMe","medecin","lll@gmail","063522",13,"IBM3","001122"));
		clientData.add(new Client("Cornelia", "Meier","MMe","medecin","lll@gmail","063522",12,"IBM4","001122"));
		clientData.add(new Client("Werner", "Meyer","MMe","medecin","lll@gmail","063522",17,"IBM5","001122"));
		clientData.add(new Client("Lydia", "Kunz","MMe","medecin","lll@gmail","063522",126,"IBM6","001122"));
		clientData.add(new Client("Anna", "Best","MMe","medecin","lll@gmail","063522",12,"IBM7","001122"));
		clientData.add(new Client("Stefan", "Meier","MMe","medecin","lll@gmail","063522",12,"IBM8","001122"));
		clientData.add(new Client("Martin", "Mueller","MMe","medecin","lll@gmail","063522",17,"IBM9","001122"));*/
		
	}

	public ObservableList<Client> getClientData() {
		return clientData;
	}
	
	public ObservableList<Prospect> getProspectData() {
		return prospectData;
	}
	
	public ObservableList<Representant> getRepresentantData() {
		return representantData;
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
	 * 
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
			// Load overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/ProspectOverview.fxml"));
			AnchorPane prospectOverview = (AnchorPane) loader.load();
			// Give the controller access to the main app
			ProspectOverviewController controller = loader.getController();
			controller.setMainApp(this);

			// Set overview into the center of root layout.
			rootLayout.setCenter(prospectOverview);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public boolean showFormulaireProspect(Prospect prospect) {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/FormulaireProspect.fxml"));
			AnchorPane formulaireProspect = (AnchorPane) loader.load();
			// Give the controller access to the main app
			FormulaireProspectController controller = loader.getController();
			controller.setMainApp(this);
			controller.setProspect(prospect);
			// Set person overview into the center of root layout.
			rootLayout.setCenter(formulaireProspect);
			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean showFormulaireRepresentant(Representant representant) {
		try {
			// Load representant overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/FormulaireRepresentant.fxml"));
			AnchorPane formulaireRepresentant = (AnchorPane) loader.load();
			// Give the controller access to the main app
			FormulaireRepresentantController controller = loader.getController();
			controller.setMainApp(this);
			controller.setRepresentant(representant);

			// Set person overview into the center of root layout.
			rootLayout.setCenter(formulaireRepresentant);
			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

	}
	
	
	public boolean showFormulaireClient(Client client) {
		try {
			// Load client formulaire.
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/FormulaireClient.fxml"));
			AnchorPane formulaireClient = (AnchorPane) loader.load();

			// Give the controller access to the main app
			FormulaireClientController controller = loader.getController();
			controller.setMainApp(this);
			controller.setClient(client);

			// Set client overview into the center of root layout.
			rootLayout.setCenter(formulaireClient);
			
			return controller.isOkClicked();
			
		} catch (IOException e) {
			e.printStackTrace();
			return false;
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
	
	public File getRepresentantFilePath() {
		Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
		String filePath = prefs.get("filePath", null);
		if (filePath != null) {
			return new File(filePath);
		} else {
			return null;
		}
	}
	
	public File getProspectFilePath() {
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
	 * @param file
	 *            the file or null to remove the path
	 */
	public void setClientFilePath(File file) {
		Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
		if (file != null) {
			prefs.put("filePath", file.getPath());

			// Update the stage title.
			// primaryStage.setTitle("AddressApp - " + file.getName());
		} else {
			prefs.remove("filePath");

			// Update the stage title.
			// primaryStage.setTitle("AddressApp");
		}
	}
	
	public void setRepresentantFilePath(File file) {
		Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
		if (file != null) {
			prefs.put("filePath", file.getPath());

			// Update the stage title.
			// primaryStage.setTitle("AddressApp - " + file.getName());
		} else {
			prefs.remove("filePath");

			// Update the stage title.
			// primaryStage.setTitle("AddressApp");
		}
	}

	
	public void setProspectFilePath(File file) {
		Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
		if (file != null) {
			prefs.put("filePath", file.getPath());

			// Update the stage title.
			// primaryStage.setTitle("AddressApp - " + file.getName());
		} else {
			prefs.remove("filePath");

			// Update the stage title.
			// primaryStage.setTitle("AddressApp");
		}
	}


	
	public boolean showFormulaireEditClient(Client client) {
		try {
			// Load client formulaire.
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/FormulaireEditClient.fxml"));
			AnchorPane formulaireEditClient = (AnchorPane) loader.load();

			// Give the controller access to the main app
			FormulaireEditClientController controller = loader.getController();
			controller.setMainApp(this);
			controller.setClient(client);

			// Set client overview into the center of root layout.
			rootLayout.setCenter(formulaireEditClient);
			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean showFormulaireEditRepresentant(Representant selectedRepresentant) {
		try {
			// Load client formulaire.
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/FormulaireEditRepresentant.fxml"));
			AnchorPane formulaireEditRepresentant = (AnchorPane) loader.load();

			// Give the controller access to the main app
			FormulaireEditRepresentantController controller = loader.getController();
			controller.setMainApp(this);
			controller.setRepresentant(selectedRepresentant);

			// Set client overview into the center of root layout.
			rootLayout.setCenter(formulaireEditRepresentant);
			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	
	}
	public boolean showFormulaireEditProspect(Prospect selectedProspect) {
		try {
			// Load client formulaire.
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/FormulaireEditProspect.fxml"));
			AnchorPane formulaireEditProspect = (AnchorPane) loader.load();

			// Give the controller access to the main app
			FormulaireEditProspectController controller = loader.getController();
			controller.setMainApp(this);
			controller.setProspect(selectedProspect);

			// Set client overview into the center of root layout.
			rootLayout.setCenter(formulaireEditProspect);
			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	
	}
/**
	
	 * Loads client data from the specified file. The current client data will
	 * be replaced.
	 * 
	 * @param file
	 **/
	 
	public void loadClientDataFromFile(File file) {
		try {
			JAXBContext context = JAXBContext.newInstance(ClientListWrapper.class);
			Unmarshaller um = context.createUnmarshaller();

			// Reading XML from the file and unmarshalling.
			ClientListWrapper wrapper = (ClientListWrapper) um.unmarshal(file);

			clientData.clear();
			clientData.addAll(wrapper.getClients());

			// Save the file path to the registry.
			setClientFilePath(file);

		} catch (Exception e) { // catches ANY exception*
			e.printStackTrace();
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Could not load data");
			alert.setContentText("Could not load data from file:\n" + file.getPath());

			alert.showAndWait();
		}
	}
	
	public void loadRepresentantDataFromFile(File file) {
		try {
			JAXBContext context = JAXBContext.newInstance(RepresentantListWrapper.class);
			Unmarshaller um = context.createUnmarshaller();

			// Reading XML from the file and unmarshalling.
			RepresentantListWrapper wrapper = (RepresentantListWrapper) um.unmarshal(file);

			representantData.clear();
			representantData.addAll(wrapper.getRepresentants());

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
	
	public void loadProspectDataFromFile(File file) {
		try {
			JAXBContext context = JAXBContext.newInstance(ProspectListWrapper.class);
			Unmarshaller um = context.createUnmarshaller();

			// Reading XML from the file and unmarshalling.
			ProspectListWrapper wrapper = (ProspectListWrapper) um.unmarshal(file);

			prospectData.clear();
			prospectData.addAll(wrapper.getProspects());

			// Save the file path to the registry.
			setProspectFilePath(file);

		} catch (Exception e) { // catches ANY exception
			e.printStackTrace();
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
	 * @param file**/
	 
	public void saveClientDataToFile(File file) {
		try {
			JAXBContext context = JAXBContext.newInstance(ClientListWrapper.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// Wrapping our client data.
			ClientListWrapper wrapper = new ClientListWrapper();
			wrapper.setClients(clientData);

			// Marshalling and saving XML to the file.
			m.marshal(wrapper, file);

			// Save the file path to the registry.
			setClientFilePath(file);
		} catch (Exception e) { // catches ANY exception
			e.printStackTrace();
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Could not save data");
			alert.setContentText("Could not save data to file:\n" + file.getPath());

			alert.showAndWait();
		}
	}

	
	public void saveRepresentantDataToFile(File file) {
		try {
			JAXBContext context = JAXBContext.newInstance(RepresentantListWrapper.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// Wrapping our client data.
			RepresentantListWrapper wrapper = new RepresentantListWrapper();
			wrapper.setRepresentants(representantData);

			// Marshalling and saving XML to the file.
			m.marshal(wrapper, file);

			// Save the file path to the registry.
			setRepresentantFilePath(file);
		} catch (Exception e) { // catches ANY exception
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Could not save data");
			alert.setContentText("Could not save data to file:\n" + file.getPath());

			alert.showAndWait();
		}
	}

	public void saveProspectDataToFile(File file) {
		try {
			JAXBContext context = JAXBContext.newInstance(ProspectListWrapper.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// Wrapping our client data.
			ProspectListWrapper wrapper = new ProspectListWrapper();
			wrapper.setProspects(prospectData);

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
