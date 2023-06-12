import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import com.mysql.jdbc.Statement;
import java.sql.SQLException;


/**
 *
 * @author seyme
 */
public class baglantiWmetod {
    static Connection baglanti;
    static Statement myStat;
static ResultSet yap(){
    ResultSet myRs = null;
            try {
          baglanti = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dbkullanici","root","root");
          myStat = (Statement) baglanti.createStatement();
             myRs = myStat.executeQuery("Select * From dbkullanici.kullanicilar");
            return myRs;
            }catch(Exception e){
                e.printStackTrace();
}
    return myRs;
    
    
}

   static void ekle (String sql_sorgu) throws SQLException{
       myStat.executeUpdate(sql_sorgu);
   }


}
