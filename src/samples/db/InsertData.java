package samples.db;

public class InsertData {
    public static void main(String[] args) {
        CreateProductTable.main(args);
        try (ConnectDB conn = ConnectDB.getConnection();) {
            int ret = conn.executeUpdate("INSERT INTO products(name,detail,author,public,type,price,quantity) VALUES(?,?,?,?,?,?,?)", "Grape book","goodbook","chhit",12,"horror",5.50,3);
            System.out.println(ret);
            ret = conn.executeUpdate("INSERT INTO products(name,detail,author,public,type,price,quantity) VALUES(?,?,?,?,?,?,?)", "Banana book","goodbook1","mengtong",11,"scifi",90.5,2);
            System.out.println(ret);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
