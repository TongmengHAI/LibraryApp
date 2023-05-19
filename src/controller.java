
import java.io.File;
import java.io.IOException;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.scene.Node;
import java.net.URL;
import java.util.ResourceBundle;

import samples.db.ConnectDB;
import samples.db.SelectData;
import script.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class controller implements Initializable {
    @FXML
    private TextField searchBar = new TextField();
    @FXML
    private TableView<Book> tableview = new TableView<Book>();
    @FXML
    private TableColumn<Book, String> nameColumn = new TableColumn<Book, String>();
    @FXML
    private TableColumn<Book, Integer> idColumn = new TableColumn<Book, Integer>();
    @FXML
    private TableColumn<Book, Double> priceColumn = new TableColumn<Book, Double>();
    @FXML
    private TableColumn<Book, Integer> qntColumn = new TableColumn<Book, Integer>();
    @FXML
    private TableColumn<Book, String> typeColumn = new TableColumn<Book, String>();
    @FXML
    private TableColumn<Book, String> authorColumn = new TableColumn<Book, String>();
    

    Book tempbook = new Book();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){// initialize the table value
        idColumn.setCellValueFactory(new PropertyValueFactory<Book, Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Book, Double>("price"));
        qntColumn.setCellValueFactory(new PropertyValueFactory<Book, Integer>("qnt"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("type"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));

        try {
            autolistbook();
        } catch (Exception e) {
            System.out.println(e);
        }
        //set table row click event
        tableview.setRowFactory(new Callback<TableView<Book>,TableRow<Book>>(){
            @Override
            public TableRow<Book> call(TableView<Book> tableview){
                TableRow<Book> row = new TableRow<Book>();
                row.setOnMouseClicked(event->{
                    if(event.getClickCount()==2 && !row.isEmpty()){
                        tempbook = row.getItem();// get the data from the row and give it to tempbook obj
                        //what happen after clicking the row, code
                        SelectData d = new SelectData();
                        tempbook = d.findbook(tempbook.getId());
                        try{
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("listBookDetail.fxml"));
                            root = loader.load();
                            bookdetailcontroller bd = loader.getController();
                            bd.setdetail(tempbook);
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
        
        // search bar event listener
        searchBar.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                String text = searchBar.getText();
                if (text != null) {
                    tableview.getItems().clear();
                    try (Connection conn = DriverManager.getConnection("jdbc:sqlite:myDbFile.db")) {
                        String sql = "SELECT * FROM products WHERE name LIKE ?";
                        PreparedStatement pst = conn.prepareStatement(sql);
                        pst.setString(1, "%" + text + "%");
                        ResultSet rs = pst.executeQuery();
                        while (rs.next()) {
                            addbookTotable(rs.getInt(1), rs.getString(2), rs.getDouble(7), rs.getInt(8),
                                    rs.getString(6), rs.getString(4));
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }

    public void autolistbook() throws IOException {
        try (ResultSet rs = ConnectDB.getConnection().execute("SELECT * FROM products")) {
            while (rs.next()) {
                addbookTotable(rs.getInt(1), rs.getString(2), rs.getDouble(7), rs.getInt(8), rs.getString(6),
                        rs.getString(4));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void addbookTotable(int id, String n, Double p, int q, String t, String a) throws IOException {
        ObservableList<Book> books = tableview.getItems();
        Book newbook = new Book(id, n, p, q, t, a);
        tableview.getItems().add(newbook);
        tableview.setItems(books);
    }

    // list book
    public void listbook(Event event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("listbook.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    TextField username = new TextField();
    @FXML
    TextField password = new TextField();
    @FXML 
    Text a = new Text();
    public void listbook2(Event event) throws IOException{
        if(username.getText().equals("admin") && password.getText().equals("12345")) {
            root = FXMLLoader.load(getClass().getResource("listbook.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else{
            a.setText("Incorrect username or password");
            
        }
            
    }
    // List book Detail
    public void listBookDetail(Event event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("listBookDetail.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // make copy book
    private Stage stage;
    private Scene scene;
    private Parent root;

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

    public void chooseImg(ActionEvent event) throws IOException {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FileChooser fc = new FileChooser();
        File file = fc.showOpenDialog(stage);
        System.out.println(file); 

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
    //logout
    public void siignout(ActionEvent event)throws IOException{
        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
