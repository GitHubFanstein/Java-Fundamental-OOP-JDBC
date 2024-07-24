package JDBCandOOP;

public interface JavaOOPInterface {
    public boolean login(user user);
    public boolean leaveApplication2(user user, int empID, int typeOfLeave, 
                                     String startDate, String endDate, String status, String description, 
                                     int numberOfLeaveApplication);
    
} 