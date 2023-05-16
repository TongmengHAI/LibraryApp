package samples.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectData {
    public void find(int id){
        String sql = "SELECT * FROM products WHERE id = "+id;
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:myDbFile.db");
        PreparedStatement pst = conn.prepareStatement(sql)){
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
