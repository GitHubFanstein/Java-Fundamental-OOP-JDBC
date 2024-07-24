// package
package JDBCandOOP;

// field import
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// class employeeDAO yang extends dari user
class employeeDAO extends user implements JavaOOPInterface{
    private Connection connection;
     private String nameEmployee;
    private String departemenEmployee;

    // objek constructor employeeDAo dari class employeeDAO
    public employeeDAO(int userId, String userName, String userPassword, Connection connection, String nameEmployee,
        String departemenEmployee) {
      super(userId, userName, userPassword);
      this.connection = connection;
      this.nameEmployee = nameEmployee;
      this.departemenEmployee = departemenEmployee;
    }

    // Method getDepartemenEmployee
    public String getDepartemenEmployee() {
        return departemenEmployee;
    }

    // method setDepatemenEmployee
    public void setDepartemenEmployee(String departemenEmployee) {
        this.departemenEmployee = departemenEmployee;
    }

    // method getNameEmployee
    public String getNameEmployee() {
        return nameEmployee;
    }

    // method setNameEmployee
    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    // method login employee
    public boolean login(user user) {
      String querySelect = "SELECT username FROM tbl_user WHERE username = ?";
      boolean found = false;
      try {
        PreparedStatement preparedStatement = connection.prepareStatement(querySelect);
        preparedStatement.setString(1, user.getUserName());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            found = true;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return found;
        }



//     public void leaveApplication(String empID) {

//         String[][] inputdata = {
//             {empID, "Annual Leave", "2024-07-20", "2024-07-30", "Pending", "Vacation", "10", nameEmployee} 
//           };

//           String[][] applicationResult = user.leaveApplication(inputdata);

//     for(int i = 0; i < applicationResult.length; i++){
//         for (int j = 0; j < applicationResult[i].length; j++) {
//             System.out.println(applicationResult[i][j]) ;
//         }
//         System.out.println();
// }
//     }
    
    // Method insert 
  //   public boolean insert(user user){
  //     try{
  //       PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO tbl_cuti (region_id, region_name) VALUES (?,?)");
  //       preparedStatement.setInt(1, user.getUserId());
  //       preparedStatement.setString(2, user.getUserName());
  //       preparedStatement.execute();
  //       return true;
  //     } catch(SQLException e){
  //       e.printStackTrace();
  //     }
  //     return false;
  // }

   
    // method penajuan cuti / leave apllication
    public boolean leaveApplication2(user user, int empID, int typeOfLeave, 
                                     String startDate, String endDate, String status, String description, 
                                     int numberOfLeaveApplication) {
        boolean success = false;
        PreparedStatement preparedStatement = null;
        try {
            // Create a PreparedStatement
            preparedStatement = connection.prepareStatement("INSERT INTO tbl_cuti (ID_karyawan, ID_Jenis_Cuti, Tanggal_Mulai_Cuti, Tanggal_selesai_Cuti, Status_Pengajuan, Keterangan, Jumlah_Pengajuan_Cuti) VALUES (?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, empID);
            preparedStatement.setInt(2, typeOfLeave);
            preparedStatement.setString(3, startDate);
            preparedStatement.setString(4, endDate);
            preparedStatement.setString(5, status);
            preparedStatement.setString(6, description);
            preparedStatement.setInt(7, numberOfLeaveApplication);
            // preparedStatement.setString(8, name);

            // Execute the update
            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                success = true;
            }

             // array List 
            // Create an ArrayList to store data
            ArrayList<String> storeData = new ArrayList<>();

            // Insert elements into the ArrayList
            storeData.add("Employee ID : " + empID);
            storeData.add("Cuti Tahunan : " + typeOfLeave);
            storeData.add("Tanggal Awal Cuti : " + startDate);
            storeData.add("Tanggal Akhir Cuti : " + endDate);
            storeData.add("Status : " + status);
            storeData.add("Keterangan : " + description);
            storeData.add("Jumlah Pengajuan Cuti : " + numberOfLeaveApplication);
            // storeData.add("Nama Employee : " + name);

            // Print the stored data
            System.out.println("\nLeave Employee : " + storeData + "\n");

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception (e.g., log it)
        } finally {
            // Close the PreparedStatement
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return success;
    }
    


    public String testClass() {
        return "berhasil";
    }
}
