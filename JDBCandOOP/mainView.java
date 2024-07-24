package JDBCandOOP;

public class mainView {
    public static void main(String[] args) {
        
        JDBCConnection connection = new JDBCConnection();
        System.out.println(connection.getConnection());
    
        user user = new user(0, "Gani@", null);
        employeeDAO employeeDAO = new employeeDAO(0, user.getUserName(), null, connection.getConnection(), null, null);
        boolean loginResult = employeeDAO.login(employeeDAO);
        System.out.println(" Login Berhasil " + loginResult);

        int empID = 29;
        int typeOfLeave = 1;
        String startDate = "2024-07-01";
        String endDate = "2024-07-10";
        String status = "Pending";
        String description = "Vacation";
        int numberOfLeaveApplication = 1;
        // String name = "John Doe";

        boolean result = employeeDAO.leaveApplication2(user, empID, typeOfLeave, startDate, endDate, status, description, numberOfLeaveApplication);
        System.out.println("Leave application successful: " + result);
    }
}
