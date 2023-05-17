package samples.db;

import java.sql.Statement;

public class CreateProductTable {
    public static void main(String[] args) {
        ConnectDB conn = ConnectDB.getConnection();
        if(conn.isError()){
            System.err.println(conn.getException());
            System.exit(-1);
        }
        try (Statement stmt = conn.getDb().createStatement()) {
            stmt.executeUpdate("DROP TABLE IF EXISTS Borrowedbooks");
            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS Borrowedbooks
                (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    studentname TEXT,
                    studentid TEXT,
                    gender TEXT,
                    department TEXT,
                    year TEXT,
                    booktitle TEXT,
                    bookid INTEGER,
                    borrowdate TEXT,
                    deadline TEXT,
                    returndate TEXT
                )
            """);
            // stmt.executeUpdate("DROP TABLE IF EXISTS products");
            // stmt.executeUpdate("""
            //     CREATE TABLE IF NOT EXISTS products
            //     (
            //         id INTEGER PRIMARY KEY AUTOINCREMENT,
            //         name TEXT,
            //         detail BLOB,
            //         author TEXT,
            //         public TEXT,
            //         type TEXT,
            //         price DECIMAL,
            //         quantity INTEGER
            //     )
            // """);
        } catch (Exception e) {
            e.printStackTrace();
        }
        conn.close();
    }
}
