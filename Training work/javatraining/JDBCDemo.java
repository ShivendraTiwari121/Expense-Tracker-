import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class JDBCDemo {
    public static void main(String[] args) throws SQLException{
    
        String username = "root";
        String password ="";
        String url = "jdbc:mysql://localhost:3306/JavaTrainingItm";
   
        Connection c = DriverManager.getConnection(url, username, password);
        System.out.println("Db connected");
       
    }
}
