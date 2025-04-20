package backend;

import java.util.ArrayList;

public class AdminRole {
    private EmployeeUserDatabase database;


    public AdminRole(String filename) {
        this.database = new EmployeeUserDatabase(filename);
    }

    public AdminRole(EmployeeUserDatabase database)
    {
        this.database = database;
    }

    public void addEmployee(String employeeId, String name, String email, String address, String phoneNumber) {
        EmployeeUser employee = new EmployeeUser(employeeId, name, email, address, phoneNumber);
        database.insertRecord(employee);
    }
    public Member[] getListOfEmployees()
    {
        ArrayList<Member> employees = database.returnAllRecords();
        return ((ArrayList<Member>) employees).toArray(new EmployeeUser[0]);

    }
    public void removeEmployee(String key)
        {
        database.deleteRecord(key);
    }

    public void logout()
    {
        database.saveToFile();
    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

