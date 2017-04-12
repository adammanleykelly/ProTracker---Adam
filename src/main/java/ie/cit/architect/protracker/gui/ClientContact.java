package ie.cit.architect.protracker.gui;

import ie.cit.architect.protracker.App.Mediator;
import ie.cit.architect.protracker.helpers.Consts;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Font;

/**
 * Created by Adam on 06/03/2017.
 */
public class ClientContact
{
    private Mediator mainMediator;

    public ClientContact(Mediator mainMediator)
    {
        this.mainMediator = mainMediator;
    }

    HBox hb, hb1,hb2;
    VBox vb;
    public void start(Stage stage)
    {
        BorderPane pane = new BorderPane();
        pane.setTop(homeButtonContainer());
        pane.setCenter(createContactPage());
        pane.setBottom(navButtonContainer());
        Scene scene = new Scene(pane, Consts.APP_WIDTH, Consts.APP_HEIGHT);
        scene.getStylesheets().add("/stylesheet.css");
        stage.setScene(scene);
        stage.setTitle(Consts.APPLICATION_TITLE + " Contact Page");
        stage.show();
    }


    private Pane createContactPage()
    {
        //Contact Info
        Label cinfo = new Label("Contact Info");
        cinfo.setFont(new Font("Arial", 30));
        Label email = new Label ("e-mail: protracker@hotmail.com");
        Label cNumber = new Label ("Contact Number:(021) 4667788");
        Label address = new Label("Address: Monkstown, Cork,");
        Label site = new Label("Website: www.protracker.com");

        VBox vb = new VBox(cinfo, email, cNumber, address, site);
        vb.setSpacing(5);
        vb.setPadding(new Insets(1));
        vb.setAlignment(Pos.CENTER_LEFT);

        //Opening Hours Info
        Label openHours = new Label("Opening Hours");
        openHours.setFont(new Font("Arial", 30));

        Label mon = new Label("Mon 09:00 to 18:00");
        Label tue = new Label("Tue 09:00 to 18:00");
        Label wed = new Label("Wed 09:00 to 18:00");
        Label thur = new Label("Thur 09:00 to 18:00");
        Label fri = new Label("Fri 09:00 to 18:00");

        VBox vbO = new VBox(openHours, mon,tue,wed,thur,fri);
        vbO.setSpacing(5);
        vbO.setPadding(new Insets(1));
        vbO.setAlignment(Pos.CENTER_LEFT);

        //Map info
        Label map = new Label("Map");
        Image map1 = new Image(this.getClass().getResource("/map.png").toString());
        ImageView mapV = new ImageView(map1);
        mapV.setFitWidth(354);
        mapV.setFitHeight(245);
        map.setFont(new Font("Arial", 30));
        VBox vbMap = new VBox(map, mapV);
        vbMap.setSpacing(15);
        vbMap.setPadding(new Insets(1));
        vbMap.setAlignment(Pos.TOP_RIGHT);


        VBox vb2 = new VBox(vb,vbO);
        vb2.setSpacing(15);
        vb2.setPadding(new Insets(10));
        vb2.setAlignment(Pos.TOP_LEFT);

        HBox hb1 = new HBox(vb2, vbMap);
        hb1.setSpacing(150);
        hb1.setPadding(new Insets(1));
        hb1.setAlignment(Pos.CENTER);

        BorderPane pane = new BorderPane();
        pane.setCenter(hb1);

        return pane;
    }

    public HBox homeButtonContainer()
    {
        Button buttonHome = new Button("Home");
        Image logo = new Image(this.getClass().getResource("/Protracker_big.png").toString());
        ImageView iview1 = new ImageView(logo);
        iview1.setFitWidth(236.25);
        iview1.setFitHeight(62.5);

        buttonHome.setOnAction(event -> {
            try {
                mainMediator.changeToClientMenuScene();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        hb = new HBox(buttonHome);
        hb.setSpacing(100);
        hb.setPadding(new Insets(10));
        hb.setAlignment(Pos.TOP_LEFT);

        hb1 = new HBox(iview1);
        hb1.setSpacing(100);
        hb1.setPadding(new Insets(10));
        hb1.setAlignment(Pos.TOP_RIGHT);

        hb2 = new HBox(hb, hb1);
        hb2.setSpacing(450);
        hb2.setPadding(new Insets(10));
        hb2.setAlignment(Pos.TOP_CENTER);

        return hb2;
    }

    public HBox navButtonContainer()
    {
        Button buttonStage = new Button("Back To Timeline");
        Button buttonCancel = new Button("Cancel");
        Button buttonContinue= new Button("Continue");

        buttonCancel.setOnAction(event -> {
            try {
                mainMediator.changeToClientMenuScene();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        buttonContinue.setOnAction(event -> {
            try {
                mainMediator.changeToClientMenuScene();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


        HBox hb = new HBox(buttonCancel, buttonContinue);
        hb.setSpacing(10);
        hb.setPadding(new Insets(10));
        hb.setAlignment(Pos.TOP_RIGHT);

        return hb;
    }
}
