import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import samples.db.ConnectDB;
import samples.db.SelectData;
import script.Book;

public class controller implements Initializable {
    @FXML 
    private TableView<Book> tableview = new TableView<Book>() ;
    @FXML
    private TableColumn<Book,String> nameColumn = new TableColumn<Book,String>();
    @FXML
    private TableColumn<Book,Double> priceColumn = new TableColumn<Book,Double>();
    @FXML
    private TableColumn<Book,Integer> qntColumn = new TableColumn<Book,Integer>();
    @FXML
    private TableColumn <Book,String> typeColumn = new TableColumn <Book,String>();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        nameColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Book, Double>("price"));
        qntColumn.setCellValueFactory(new PropertyValueFactory<Book, Integer>("qnt"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("type"));
    }
    public void listbook(String n,Double p,int q,String t)throws IOException{
        initialize(null, null);
        Book newbook = new Book(n, p, q, t);
        ObservableList<Book> books = tableview.getItems();
        books.add(newbook);
        tableview.setItems(books);
        
    }
}
