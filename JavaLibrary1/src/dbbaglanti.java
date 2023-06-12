
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbbaglanti {
    static String username = "root";
    static String password = "root";
    static String dbUrl = "jdbc:mysql://localhost:3306/dbkullanici";
    
    public Connection getConnection() throws SQLException{
    return(Connection) DriverManager.getConnection(dbUrl,username,password);
    }
    public void ShowError(SQLException exception){
        System.out.println("Hata: "+ exception.getMessage());
        System.out.println("Hata Kodu: "+ exception.getErrorCode());
                
        }
}
