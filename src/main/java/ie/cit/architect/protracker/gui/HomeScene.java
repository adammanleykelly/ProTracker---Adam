package ie.cit.architect.protracker.gui;

import ie.cit.architect.protracker.App.MainMediator;
import ie.cit.architect.protracker.helpers.Consts;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;



public class HomeScene {

    private MainMediator mainMediator;

    // Composition - passing a reference of MainMediator to HomeScene's constructor. Now HomeScene 'has-a' MainMediator
    public HomeScene(MainMediator mediator) {
        this.mainMediator = mediator;
    }

    private Button buttonSignInArchitect;
    private Button buttonSignInClient;
    private CustomArchitectDialog customArchitectDialog;


    public void start(Stage stage) throws Exception {

        // check the Operating System
        System.out.println(System.getProperty("os.name"));

        Scene scene = new Scene(
                createHomeMenu(), Consts.APP_WIDTH, Consts.APP_HEIGHT);
        scene.getStylesheets().add("/stylesheet.css");
        stage.setScene(scene);
        stage.setTitle(Consts.APPLICATION_TITLE);
        stage.show();
    }


    private GridPane createHomeMenu() {

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(20, 0, 20, 20));
        gridPane.setVgap(20);

        Image logo = new Image(this.getClass().getResource("/Protracker_big.png").toString());
        ImageView iview1 = new ImageView(logo);

        Label labelSubTitle = new Label("Welcome");
        labelSubTitle.getStyleClass().add("label_subtitle");

        buttonSignInClient = new Button("Sign in Client");
        buttonSignInArchitect = new Button("Sign in Architect");
        buttonSignInClient.setMinWidth(150);
        buttonSignInArchitect.setMinWidth(150);


        buttonSignInClient.setOnAction(event -> mainMediator.changeToClientCustomDialog());
        buttonSignInArchitect.setOnAction(event -> mainMediator.changeToArchitectCustomDialog());


        gridPane.add(iview1, 0, 1);
        GridPane.setHalignment(iview1, HPos.CENTER);

        gridPane.add(labelSubTitle, 0, 2);
        GridPane.setHalignment(labelSubTitle, HPos.CENTER);

        gridPane.add(buttonSignInClient, 0, 4);
        GridPane.setHalignment(buttonSignInClient, HPos.CENTER);

        gridPane.add(buttonSignInArchitect, 0, 5);
        GridPane.setHalignment(buttonSignInArchitect, HPos.CENTER);

        return gridPane;
    }
}
