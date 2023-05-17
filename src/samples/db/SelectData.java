package samples.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import script.*;

public class SelectData {
    public Book findbook(int id){
        String sql = "SELECT * FROM products WHERE id = "+id;
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:myDbFile.db");
        PreparedStatement pst = conn.prepareStatement(sql)){
            // pst.setInt(1,id);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                Book b = new Book();
                b.setId(rs.getInt(1));
                b.setName(rs.getString(2));
                b.setDetail(rs.getString(3));
                b.setAuthor(rs.getString(4));
                b.setPublis(rs.getString(5));
                b.setPrice(rs.getDouble(7));
                b.setQnt(rs.getInt(8));
                b.setType(rs.getString(6));
                return b;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public BorrowBook findborrowbook(int id){
        String sql = "SELECT * FROM Borrowedbooks WHERE id = "+id;
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:myDbFile.db");
        PreparedStatement pst = conn.prepareStatement(sql)){
            // pst.setInt(1,id);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                BorrowBook b = new BorrowBook();
                b.setId(rs.getInt(1));
                b.setStudentname(rs.getString(2));
                b.setId(rs.getInt(3));
                b.setGender(rs.getString(4));
                b.setDepartment(rs.getString(5));
                b.setTitle(rs.getString(7));
                b.setBorrowdate(rs.getString(9));
                b.setDeadline(rs.getString(10));
                return b;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public void updateborrowbook(BorrowBook b){
        
    }
}
