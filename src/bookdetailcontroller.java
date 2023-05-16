import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import script.Book;
import javafx.scene.Node;

public class bookdetailcontroller {
    private Stage stage;
    private Scene scene;
    private Parent root;

    //list book detail

    @FXML
    Text titleLabel = new Text();
    @FXML
    Text idLabel = new Text();
    @FXML
    Text authorLabel= new Text();
    @FXML
    Text publicLabel = new Text();
    @FXML
    Text typeLabel = new Text();
    @FXML
    Text priceLabel = new Text();
    @FXML
    Text qntLabel = new Text();
    @FXML 
    Text detailLabel = new Text();
    Book tempbook = new Book();

    public void setdetail(Book b){
        titleLabel.setText(b.getName());
        idLabel.setText(Integer.toBinaryString(b.getId()));
        authorLabel.setText(b.getAuthor());
        publicLabel.setText(b.getPublis());
        typeLabel.setText(b.getType());
        priceLabel.setText(Double.toString(b.getPrice())+"$");
        qntLabel.setText(Integer.toString(b.getQnt()));
        detailLabel.setText(b.getDetail());
        tempbook=b;
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

    public void makeCopyDetail(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("copyBookDetail.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // borrow book form
    public void borrowBook(ActionEvent event) throws IOException {
        
        // root = FXMLLoader.load(getClass().getResource("borrowBook.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("borrowBook.fxml"));
        root = loader.load();
        borrowbookcontroller bc = loader.getController();
        bc.setdetail(tempbook);
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
