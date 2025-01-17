import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import samples.db.InsertData;
import samples.db.SelectData;
import script.Book;
import script.BorrowBook;

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

    //reutrn book variable
    @FXML
    Text title= new Text();
    @FXML
    Text name = new Text();
    @FXML
    Text id = new Text();
    @FXML
    Text gen = new Text();
    @FXML
    Text dep = new Text();
    @FXML
    Text bd = new Text();
    @FXML
    Text dd = new Text();
    @FXML 
    DatePicker rd = new DatePicker();
    
    @FXML
    Button returnbtn = new Button();
    BorrowBook tempbook = new BorrowBook();
    //this is for menubutton selection, has to be a global var else wont work
    String select;
    @FXML
    ImageView imgview = new ImageView();
    String image;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gendermale.setOnAction(event ->{
            select = gendermale.getText();gender.setText(gendermale.getText());
        });
        genderfemale.setOnAction(event->{
            select = genderfemale.getText();gender.setText(genderfemale.getText());
        });
        
    }
    public void setreturnbook(BorrowBook b){
        title.setText(b.getTitle());
        dep.setText(b.getDeparment());
        dd.setText(b.getDeadline());
        bd.setText(b.getBorrowdate());
        id.setText(b.getStudentid());
        gen.setText(b.getGender());
        name.setText(b.getStudentname());
        try{
            Image im = new Image("./asset/bookcover/"+b.getImg());
            imgview.setImage(im);
        }catch(Exception e){
            e.printStackTrace();
        }
        tempbook = b;
    }
    public void setdetail(Book b){
        booktitle.setText(b.getName());
        bookid.setText(Integer.toString(b.getId()));
        image = b.getImage();
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
        // InsertData d = new InsertData();

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:myDbFile.db")) {
                // String sql = "SELECT studentid,returndate FROM Borrowedbooks WHERE studentid like ? and returndate like ?";
                String sql = "SELECT studentid,returndate FROM Borrowedbooks WHERE studentid like ? ";
                
                PreparedStatement pst = conn.prepareStatement(sql);
                
                pst.setString(1, "%" + studid + "%");
                // pst1.setString(1, returnd );
                ResultSet rs = pst.executeQuery();
            
                String str = rs.getString(1) ;

                String str1 = rs.getString(2) ;
                conn.close();

                System.out.println(str1);
               
               
                try{
                        LocalDate bordate = borrowdate.getValue();borrowdate.setValue(null);
                        LocalDate redate = returndate.getValue();returndate.setValue(null);
                        borrowd = bordate.toString();
                        returnd = redate.toString();
                    }catch(Exception e){
                        alert.setText("Error");
                        e.printStackTrace();
                    }
               
                if(str1 != null  ){
                    if(str != null){
                        InsertData d = new InsertData();
                        try{
                            d.insert3(studname,studid,gend,dep,y,bookt,booki,borrowd,returnd,image);
                            alert.setText("Success");
                            System.out.println("str");
                            return;
                            
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }else{
                        alert.setText("Return book first!");
                    }
                    
                    
                }else{
                     alert.setText("Return book first!");
                }
                
                if(str == null ){
                    InsertData d = new InsertData();
                    try{
                        d.insert3(studname,studid,gend,dep,y,bookt,booki,borrowd,returnd,image);
                        alert.setText("Success");
                        System.out.println("str1");

                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    
                }else{
                     alert.setText("Return book first!");
                }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // try{
        //     LocalDate bordate = borrowdate.getValue();borrowdate.setValue(null);
        //     LocalDate redate = returndate.getValue();returndate.setValue(null);
        //     borrowd = bordate.toString();
        //     returnd = redate.toString();
        // }catch(Exception e){
        //     alert.setText("Error");
        //     e.printStackTrace();
        // }
        // try{
        //     d.insert3(studname,studid,gend,dep,y,bookt,booki,borrowd,returnd,image);
        //     alert.setText("Success");
        // }catch(Exception e){
        //     e.printStackTrace();
        // }
    }
    public void returnbookbtn(ActionEvent event) throws IOException {
        LocalDate red = rd.getValue();
        String returndat = red.toString();
        SelectData d = new SelectData();
        d.updatereturnbook(tempbook.getId(), returndat);
        
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
    
    public void updateBook(ActionEvent event) throws IOException {
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
