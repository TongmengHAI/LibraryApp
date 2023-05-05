
import java.io.IOException;

import javafx.collections.FXCollections;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.net.URL;
import java.util.ResourceBundle;

import samples.db.ConnectDB;
import samples.db.SelectData;
import script.Book;
import java.sql.ResultSet;
public class controller implements Initializable {
    @FXML 
    private TableView<Book> tableview = new TableView<Book>();
    @FXML
    private TableColumn<Book,String> nameColumn = new TableColumn<Book,String>();
    @FXML
    private TableColumn<Book,Integer> idColumn = new TableColumn<Book,Integer>();
    @FXML
    private TableColumn<Book,Double> priceColumn = new TableColumn<Book,Double>();
    @FXML
    private TableColumn<Book,Integer> qntColumn = new TableColumn<Book,Integer>();
    @FXML
    private TableColumn <Book,String> typeColumn = new TableColumn <Book,String>();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){//initialize the table value
        idColumn.setCellValueFactory(new PropertyValueFactory<Book,Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Book, Double>("price"));
        qntColumn.setCellValueFactory(new PropertyValueFactory<Book, Integer>("qnt"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("type"));
        try{
            autolistbook();
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    public void autolistbook()throws IOException{
        try(ResultSet rs = ConnectDB.getConnection().execute("SELECT * FROM products")){
            while(rs.next()){
                addbookTotable(rs.getInt(1) ,rs.getString(2), rs.getDouble(7), rs.getInt(8), rs.getString(6));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void addbookTotable(int id,String n,Double p,int q,String t)throws IOException{
        ObservableList<Book> books = tableview.getItems();
        Book newbook = new Book(id,n,p,q,t);
        tableview.getItems().add(newbook);
        tableview.setItems(books);
    }
}
