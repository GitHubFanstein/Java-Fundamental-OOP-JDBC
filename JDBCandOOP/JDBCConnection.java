package JDBCandOOP;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 * JDBCConnection
 */
public class JDBCConnection {

    private Connection con;

  public Connection getConnection() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_pengajuan_cuti", "root", "@MYSQLAten123321");
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
    return this.con;
  }
    
}