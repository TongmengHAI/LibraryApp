package samples.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
                b.setStudentid(rs.getString(3));
                b.setGender(rs.getString(4));
                b.setDepartment(rs.getString(5));
                b.setTitle(rs.getString(7));
                b.setBorrowdate(rs.getString(9));
                b.setDeadline(rs.getString(10));
                b.setReturndate(rs.getString(11));
                return b;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public void updatereturnbook(int id,String rd){
        String sql = "UPDATE `Borrowedbooks` SET" 
                    +" `returndate` = ? WHERE id = "+"'"+ (id) + "'";
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:myDbFile.db");
        PreparedStatement pst = conn.prepareStatement(sql)){
            System.out.println(id);
            pst.setString(1, rd);
            int ra = pst.executeUpdate();

            if(ra >0){//tell if update successful
                System.out.println("success");//code doesnt work at all
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void updatereturnbook2(Book b){
        String sql = "UPDATE `products` SET" 
                    +"`name` = ?," 
                    +"`detail` = ?,"
                    +" `author` = ?,"
                    +" `public` = ?,"
                    +" `type` = ?,"
                    +" `price` = ?,"
                    +" `quantity` = ? WHERE id = "+"'"+ (b.getId()) + "'";
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:myDbFile.db");
        PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setString(1, b.getName());
            pst.setString(2, b.getDetail());
            pst.setString(3, b.getAuthor());
            pst.setString(4, b.getPublis());
            pst.setString(5, b.getType());
            pst.setDouble(6, b.getPrice());
            pst.setInt(7, b.getQnt());
            System.out.println(b.getName());
            int ra = pst.executeUpdate();

            if(ra >0){//tell if update successful
                System.out.println("success");//code doesnt work at all
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
