import java.io.IOException;

import javax.swing.border.LineBorder;

import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import samples.db.ConnectDB;
import samples.db.SelectData;

public class scenecontroller {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML 
    Pane ListbookUI;
    Label WelcomeText;
    Pane listbook;
    public void switchToLogin(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
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
    public void listbook(ActionEvent event)throws IOException{
        Pane newloadedPane = FXMLLoader.load(getClass().getResource("listbook.fxml"));
        ListbookUI.getChildren().clear();
        ListbookUI.getChildren().add(newloadedPane);
        controller c = new controller();
        c.listbook("hello", 2.2, 1, "magazine");
        ListbookUI.requestLayout();

    }
    
}
