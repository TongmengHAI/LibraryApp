package samples.db;
import java.sql. *;
import java.sql.PreparedStatement;

public class InsertData {
     public void insert(String a,String b,String c,String d,String e,Double f,int g,String h) {
        String sql = "INSERT INTO products(name,detail,author,public,type,price,quantity,image) VALUES(?,?,?,?,?,?,?,?)";
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:myDbFile.db");
        PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setString(1,a);
            pst.setString(2,b);
            pst.setString(3,c);
            pst.setString(4,d);
            pst.setString(5,e);
            pst.setDouble(6,f);
            pst.setInt(7, g);
            pst.setString(8, h);
            pst.executeUpdate();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
    public void insert2(String a,String b,String c,String d,String e,String f,int g,String h,String i,String j,String k){
        String sql = "INSERT INTO Borrowedbooks(studentname,studentid,gender,department,year,booktitle,bookid,borrowdate,deadline,returndate,img) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:myDbFile.db");
        PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setString(1, a);
            pst.setString(2, b);
            pst.setString(3, c);
            pst.setString(4, d);
            pst.setString(5, e);
            pst.setString(6, f);
            pst.setInt(7, g);
            pst.setString(8, h);
            pst.setString(9, i);
            pst.setString(10, j);
            pst.setString(11,k);
            pst.executeUpdate();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void insert3(String a,String b,String c,String d,String e,String f,int g,String h,String i,String k){
        String sql = "INSERT INTO Borrowedbooks(studentname,studentid,gender,department,year,booktitle,bookid,borrowdate,deadline,returndate,img) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:myDbFile.db");
        PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setString(1, a);
            pst.setString(2, b);
            pst.setString(3, c);
            pst.setString(4, d);
            pst.setString(5, e);
            pst.setString(6, f);
            pst.setInt(7, g);
            pst.setString(8, h);
            pst.setString(9, i);
            pst.setString(10, "null");
            pst.setString(11,k);
            pst.executeUpdate();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
