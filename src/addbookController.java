import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import samples.db.InsertData;
public class addbookController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    Text alert = new Text();
    @FXML
    TextField titleField = new TextField();
    @FXML
    TextField authorField = new TextField();
    @FXML
    TextField typeField = new TextField();
    @FXML
    DatePicker publisField = new DatePicker();
    @FXML
    TextField priceField = new TextField();
    @FXML
    TextField quantityField = new TextField();
    @FXML
    TextArea detailField = new TextArea();
    String imgname;
    
    public void insertBook(ActionEvent event)throws IOException{
        String title = titleField.getText(); titleField.clear();
        String author = authorField.getText(); authorField.clear();
        String type = typeField.getText(); typeField.clear();
        
        String publis;
        try{//add try catch to catch error but not brick the entire function  
        LocalDate publish = publisField.getValue(); publisField.setValue(null);
        publis = publish.toString();
        }catch(Exception e){
            alert.setText("error");
            publis = null;
            System.out.println(e);
        }
        double price = Double.parseDouble(priceField.getText()); priceField.clear();
        int quantity = Integer.parseInt(quantityField.getText()); quantityField.clear();
        String detail = detailField.getText();detailField.clear();
        InsertData db = new InsertData();
        try{
            db.insert(title, detail, author, publis, type, price, quantity,imgname);
            alert.setText("Book Added");
        }catch(Exception e){
            alert.setText("error");
            System.out.println(e);
        }
        try{ 
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        alert.setText(null);
    }


    //copy from other controller
    public void chooseImg(ActionEvent event) throws IOException{
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();;
        
        FileChooser fc = new FileChooser();
        File file = fc.showOpenDialog(stage);
        if(file !=null){
            
            String destination = "./src/asset/bookcover";
            try{
                File destinationfolder = new File(destination);
                if(!destinationfolder.exists()){
                    destinationfolder.mkdirs();
                }
                String destinationfilepath = destination + File.separator + file.getName();
                Files.copy(file.toPath(), new File(destinationfilepath).toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("copied to "+destinationfilepath);
                imgname = file.getName();

            }catch(IOException e){
                e.printStackTrace();
            }
        }

    }
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
    // Log out book
    public void logout(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Logout.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
