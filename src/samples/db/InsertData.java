package samples.db;
import java.sql. *;
import java.sql.PreparedStatement;

public class InsertData {
    public void insert(String a,String b,String c,String d,String e,Double f,int g) {
        String sql = "INSERT INTO products(name,detail,author,public,type,price,quantity) VALUES(?,?,?,?,?,?,?)";
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:myDbFile.db");
        PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setString(1,a);
            pst.setString(2,b);
            pst.setString(3,c);
            pst.setString(4,d);
            pst.setString(5,e);
            pst.setDouble(6,f);
            pst.setInt(7, g);
            pst.executeUpdate();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
