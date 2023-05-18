import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import script.Book;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javax.swing.Action;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.scene.Node;
import samples.db.ConnectDB;
import samples.db.InsertData;
import samples.db.SelectData;
import script.Book;
public class copybookdetail {
    private Stage stage;
    private Scene scene;
    private Parent root;
    //copybookdetail
    @FXML
    TextField title =  new TextField();
    @FXML
    Text id = new Text();
    @FXML
    TextField author = new TextField();
    @FXML
    TextField price = new TextField();
    @FXML
    TextField publis = new TextField();
    @FXML
    TextField type = new TextField();
    @FXML
    TextField qnt = new TextField();
    @FXML
    TextArea detail = new TextArea();
    Book tempbook = new Book();

    public void setdetail(Book tempbook){
        title.setText(tempbook.getName());
        id.setText(Integer.toString(tempbook.getId()));
        author.setText(tempbook.getAuthor());
        price.setText(Double.toString(tempbook.getPrice()));
        type.setText(tempbook.getType());
        qnt.setText(Integer.toString(tempbook.getQnt()));
        detail.setText(tempbook.getDetail());
        this.tempbook = tempbook;
    }
    public void copybook(ActionEvent event) throws IOException{
        InsertData i = new InsertData();
        if(tempbook != null){
            i.insert(tempbook.getName(), tempbook.getDetail(), tempbook.getAuthor(), tempbook.getPublis(), tempbook.getType(), tempbook.getPrice(), tempbook.getQnt());
            root = FXMLLoader.load(getClass().getResource("copyBookList.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    // list book
    public void listbook(Event event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("listbook.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    // List book Detail
    public void listBookDetail(Event event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("listBookDetail.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void makeCopyList(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("copyBookList.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // borrow book form
    public void borrowBook(ActionEvent event) throws IOException {
        
        root = FXMLLoader.load(getClass().getResource("borrowBook.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // book borrowing
    public void bookBorrowingList(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("borrowingList.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // Add book
    public void addBook(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("addBook.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // Log out book
    public void logout(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Logout.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    // Update book
    public void updateBook(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("updatebook.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
