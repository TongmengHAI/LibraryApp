import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import samples.db.ConnectDB;
import samples.db.SelectData;
import script.BorrowBook;

public class listborrowcontroller implements Initializable{
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    TableView<BorrowBook> tableview = new TableView<BorrowBook>();
    @FXML
    TableColumn<BorrowBook,Integer> idColumn = new TableColumn<BorrowBook,Integer>();
    @FXML
    TableColumn<BorrowBook,String> booktitleColumn = new TableColumn<BorrowBook,String>();
    @FXML
    TableColumn<BorrowBook,String> studentnameColumn = new TableColumn<BorrowBook,String>();
    @FXML
    TableColumn<BorrowBook,Integer> qntColumn = new TableColumn<BorrowBook,Integer>();
    @FXML
    TableColumn<BorrowBook,String> borrowdateColumn = new TableColumn<BorrowBook,String>();
    @FXML
    TableColumn<BorrowBook,String> deadlineColumn = new TableColumn<BorrowBook,String>();
    @FXML
    TableColumn<BorrowBook,String> returndateColumn = new TableColumn<BorrowBook,String>();
    BorrowBook tempbook = new BorrowBook();
    public void initialize(URL url,ResourceBundle resourceBundle){
        idColumn.setCellValueFactory(new PropertyValueFactory<BorrowBook, Integer>("id"));
        booktitleColumn.setCellValueFactory(new PropertyValueFactory<BorrowBook, String>("title"));
        studentnameColumn.setCellValueFactory(new PropertyValueFactory<BorrowBook, String>("studentname"));
        qntColumn.setCellValueFactory(new PropertyValueFactory<BorrowBook, Integer>("qnt"));
        borrowdateColumn.setCellValueFactory(new PropertyValueFactory<BorrowBook, String>("borrowdate"));
        deadlineColumn.setCellValueFactory(new PropertyValueFactory<BorrowBook, String>("deadline"));
        returndateColumn.setCellValueFactory(new PropertyValueFactory<BorrowBook, String>("returndate"));
        
        //set table row click event
        tableview.setRowFactory((Callback<TableView<BorrowBook>, TableRow<BorrowBook>>) new Callback<TableView<BorrowBook>,TableRow<BorrowBook>>(){
            @Override
            public TableRow<BorrowBook> call(TableView<BorrowBook> tableview){
                TableRow<BorrowBook> row = new TableRow<BorrowBook>();
                row.setOnMouseClicked(event->{
                    if(event.getClickCount()==2 && !row.isEmpty()){
                        tempbook = row.getItem();// get the data from the row and give it to tempbook obj
                        //what happen after clicking the row, code
                        SelectData d = new SelectData();
                        tempbook = d.findborrowbook(tempbook.getId());
                        try{
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("returnBook.fxml"));
                            root = loader.load();
                            borrowbookcontroller b = loader.getController();
                            b.setreturnbook(tempbook);
                        }catch(IOException e){
                            e.printStackTrace();
                        }
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    } 
                });
                return row;// this doesnt do anything
            }
        });
        //initialize table
        try{
            autolistdata();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void autolistdata() throws IOException {
        try (ResultSet rs = ConnectDB.getConnection().execute("SELECT * FROM Borrowedbooks")) {
            while (rs.next()) {
                adddataTotable(rs.getInt(1),rs.getString(7),rs.getString(2),rs.getInt(4),rs.getString(9),rs.getString(10),rs.getString(11));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void adddataTotable(int id, String title,String studname, int q, String bd, String dl,String rd) throws IOException {
        ObservableList<BorrowBook> books = tableview.getItems();
        BorrowBook newbook = new BorrowBook(id,title,studname,q,bd,dl,rd);
        tableview.getItems().add(newbook);
        tableview.setItems(books);
    }


    //code from another controller
    public void listbook(Event event)throws IOException{
        root = FXMLLoader.load(getClass().getResource("listbook.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void makeCopyList(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("copyBookList.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void makeCopyDetail(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("copyBookDetail.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    // borrow book form
    public void borrowBook(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("borrowBook.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    // book borrowing 
    public void bookBorrowingList(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("borrowingList.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // return book
    public void bookBorrowingDetail(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("returnBook.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void UpdateBook(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("updatebook.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
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
