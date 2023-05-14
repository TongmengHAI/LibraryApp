import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import samples.db.InsertData;

public class borrowbookcontroller implements Initializable{
    private Stage stage;
    private Scene scene;
    private Parent root;

    
    @FXML
    Label alert = new Label();
    //borrowbookfxml
    @FXML
    TextField studentname = new TextField();
    @FXML 
    TextField studentid = new TextField();
    @FXML
    MenuButton gender = new MenuButton();
    //menu item
    @FXML
    MenuItem gendermale = new MenuItem();
    @FXML
    MenuItem genderfemale = new MenuItem();
    @FXML
    TextField department = new TextField();
    @FXML
    TextField year = new TextField();
    @FXML 
    TextField booktitle = new TextField();
    @FXML 
    TextField bookid = new TextField();
    @FXML
    DatePicker borrowdate = new DatePicker();
    @FXML
    DatePicker returndate = new DatePicker();
    //this is for menubutton selection, has to be a global var else wont work
    String select;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gendermale.setOnAction(event ->{
            select = gendermale.getText();gender.setText(gendermale.getText());
        });
        genderfemale.setOnAction(event->{
            select = genderfemale.getText();gender.setText(genderfemale.getText());
        });

        
    }
    public void borrow(ActionEvent event)throws IOException{
        gender.setText("Select");
        String studname = studentname.getText();studentname.clear();
        String studid = studentid.getText();studentid.clear();
        String gend = select;
        String dep = department.getText();department.clear();
        String y = year.getText();year.clear();
        String bookt = booktitle.getText();booktitle.clear();
        int booki = Integer.parseInt(bookid.getText());bookid.clear();
        String borrowd = null;
        String returnd = null;
        InsertData d = new InsertData();
        try{
            LocalDate bordate = borrowdate.getValue();borrowdate.setValue(null);
            LocalDate redate = returndate.getValue();returndate.setValue(null);
            borrowd = bordate.toString();
            returnd = redate.toString();
        }catch(Exception e){
            alert.setText("Error");
            e.printStackTrace();
        }
        try{
            d.insert2(studname,studid,gend,dep,y,bookt,booki,borrowd,returnd);
            alert.setText("Success");
        }catch(Exception e){
            e.printStackTrace();
        }
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
}
