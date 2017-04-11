package ie.cit.architect.protracker.App;

import com.sun.deploy.util.SessionState;
import ie.cit.architect.protracker.controller.DBController;
import ie.cit.architect.protracker.gui.*;
import ie.cit.architect.protracker.persistors.DBPersistor;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainMediator extends Application {

    private HomeScene homeMenuScene;
    private ArchitectMenuScene architectMenuScene;
    private ClientMenuScene clientMenuScene;
    private CreateNewProjectScene createNewProjectScene;
    private ViewMessagesScene viewMessagesScene;
    private ManageProjectScene manageProjectScene;
    private NavigationPane navigationPane;
    private CustomArchitectDialog customArchitectDialog;
    private CustomClientDialog customClientDialog;
    private ClientViewProjectTimeline clientViewProjectTimeline;
    private ClientMessages clientMessages;
    private ClientProjectStage clientProjectStage;
    private ClientBilling clientBilling;
    private ClientContact clientContact;

    private Stage primaryStage;

    public static void main(String[] args){ launch(args); }


    //  Swapping scenes. Ref: http://stackoverflow.com/a/14168529/5942254
    public MainMediator(){
        homeMenuScene = new HomeScene(this);
        architectMenuScene = new ArchitectMenuScene(this);
        clientMenuScene = new ClientMenuScene(this);
        createNewProjectScene = new CreateNewProjectScene(this);
        viewMessagesScene = new ViewMessagesScene(this);
        manageProjectScene = new ManageProjectScene(this);
        navigationPane = new NavigationPane(this);
        customArchitectDialog = new CustomArchitectDialog(this);
        customClientDialog = new CustomClientDialog(this);
        clientViewProjectTimeline = new ClientViewProjectTimeline(this);
        clientMessages = new ClientMessages(this);
        clientProjectStage = new ClientProjectStage(this);
        clientBilling = new ClientBilling(this);
        clientContact = new ClientContact(this);

        // TODO:
        // - add new scenes
        // - add methods below for those scenes to be opened
    }

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        stage.getIcons().add(new Image(this.getClass().getResource("/icon.png").toString()));
        homeMenuScene.start(primaryStage); // default

        DBController.getInstance().setPersistor(new DBPersistor());
    }


    // methods to change scene
    public void changeToArchitectMenuScene(){
        architectMenuScene.start(primaryStage);
    }

    public void changeToClientMenuScene(){
        clientMenuScene.start(primaryStage);
    }

    public void changeToCreateProjScene() { createNewProjectScene.start(primaryStage); }

    public void changeToViewMessagesScene() { viewMessagesScene.start(primaryStage); }

    public void changeToManageProjcetScene() { manageProjectScene.start(primaryStage); }

    public void changeToArchitectCustomDialog() { customArchitectDialog.signInArchitectDialog(); }

    public void changeToClientCustomDialog() { customClientDialog.signInClientDialog(); }

    public void changeToHomeScene() throws Exception { homeMenuScene.start(primaryStage); }

    public void changeToClientTimeline() throws Exception { clientViewProjectTimeline.start(primaryStage); }

    public void changeToClientMessages() throws Exception { clientMessages.start(primaryStage);}

    public void changeToClientStage() throws Exception {clientProjectStage.start(primaryStage);}

    public void changeToClientBilling() throws Exception {clientBilling.start(primaryStage);}

    public void changeToClientContact() throws Exception {clientContact.start(primaryStage);}
}