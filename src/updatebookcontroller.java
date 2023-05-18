import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import script.Book;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import samples.db.SelectData;

public class updatebookcontroller {
    private Stage stage;
    private Scene scene;
    private Parent  root;
    Book tempbook  = new Book();

    @FXML
    TextField name = new TextField();
    @FXML
    TextField id = new TextField();
    @FXML
    TextField detail = new TextField();
    @FXML
    TextField author = new TextField();
    @FXML
    TextField publis = new TextField();
    @FXML
    TextField type = new TextField();
    @FXML
    TextField price = new TextField();
    @FXML
    Button img = new Button();

    public void setdetail(Book b){
        name.setText(b.getName());
        id.setText(Integer.toString(b.getId()));
        detail.setText(b.getDetail());
        author.setText(b.getAuthor());
        publis.setText(b.getPublis());
        type.setText(b.getType());
        price.setText(Double.toString(b.getPrice()));
    }
    public void update(ActionEvent event){
        SelectData sd = new SelectData();
        tempbook.setId(Integer.parseInt(id.getText()));
        tempbook.setName(name.getText());
        tempbook.setDetail(detail.getText());
        tempbook.setAuthor(author.getText());
        tempbook.setPublis(publis.getText());
        tempbook.setType(type.getText());
        tempbook.setPrice(Double.parseDouble(price.getText()));
    
        sd.updatereturnbook2(tempbook);
    }
    public void back(ActionEvent event)throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("listBookDetail.fxml"));
        root = loader.load();
        bookdetailcontroller bd = loader.getController();
        bd.setdetail(tempbook);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    // list book
    public void listbook(Event event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("listbook.fxml"));
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
}
