package samples.db;

public class InsertData {
    public static void main(String[] args) {
        CreateProductTable.main(args);
        try (ConnectDB conn = ConnectDB.getConnection();) {
            int ret = conn.executeUpdate("INSERT INTO products(name,detail,author,public,type,price,quantity) VALUES(?,?,?,?,?,?,?)", "meng book","badbook","sfs",12,"movie",5.50,3);
            System.out.println(ret);
            ret = conn.executeUpdate("INSERT INTO products(name,detail,author,public,type,price,quantity) VALUES(?,?,?,?,?,?,?)", "chin book","vadbook1","dslfs",11,"sfs",90.5,2);
            System.out.println(ret);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
