import java.io.IOException;

import javax.management.modelmbean.XMLParseException;
import javax.xml.stream.XMLStreamException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Listbook.fxml"));
        stage.setTitle("Welcome to Library App");
        stage.setScene(new Scene(root));
        stage.show();
        
    }
}
