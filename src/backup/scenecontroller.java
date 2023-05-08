package backup;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.border.LineBorder;

import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import samples.db.ConnectDB;
import samples.db.SelectData;

public class scenecontroller implements Initializable {
    private Stage stage;
    private Scene scene;
    Parent root;
    @FXML
    AnchorPane listbookAnchorPane;
    @FXML 
    AnchorPane ListbookUI;
    @FXML
    Label WelcomeText;
    @FXML
    Pane listbook;
    @FXML
    AnchorPane table = new AnchorPane();
    @FXML
    Button backButton = new Button();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        
    }
    public void switchToLogin(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void switchToGUI(ActionEvent event)throws IOException{
        root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        //this is for connecting to the database, it will output in the console saying it connected succcesfully
        //ConnectDB.main(null);
        //SelectData.main(null);
        
    }
    @FXML
    public void listbook(ActionEvent event)throws IOException{
        AnchorPane newloadedPane = FXMLLoader.load(getClass().getResource("listbook.fxml"));
        //table = FXMLLoader.load(getClass().getResource("table.fxml"));
        //newloadedPane.getChildren().add(table);
        
        ListbookUI.getChildren().clear();
        ListbookUI.getChildren().add(newloadedPane);
        AnchorPane newpane = new AnchorPane();
        newpane = FXMLLoader.load(getClass().getResource("table.fxml"));
        table.getChildren().add(newpane);
        

    }
    @FXML
    public void makeCopiesList(ActionEvent event)throws IOException{//make a copy
        Pane newloadedPane = FXMLLoader.load(getClass().getResource("makecopylist.fxml"));
        ListbookUI.getChildren().clear();
        ListbookUI.getChildren().add(newloadedPane);
        System.out.println("hi");
        
    }
    public void makeCopyDetail(ActionEvent event)throws IOException{//update book
        Pane newloadedPane = FXMLLoader.load(getClass().getResource("makecopydetail.fxml"));
        ListbookUI.getChildren().clear();
        ListbookUI.getChildren().add(newloadedPane);
        
    }
}