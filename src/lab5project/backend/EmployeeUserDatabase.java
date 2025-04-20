package backend;

import java.io.*;

public class EmployeeUserDatabase extends Database
{

    public EmployeeUserDatabase(String filename) {
        super(filename);
    }

   public void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                EmployeeUser employee = createRecordFrom(line);
                records.add(employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public EmployeeUser createRecordFrom(String line) {
        String[] data = line.split(",");
        if (data.length == 5) {
            String employeeId = data[0];
            String name = data[1];
            String email = data[2];
            String address = data[3];
            String phoneNumber = data[4];
            return new EmployeeUser(employeeId, name, email, address, phoneNumber);
        } else {
            return null;
        }
    }

    /*public ArrayList<EmployeeUser> returnAllRecords() {
        return records;
    }

    public boolean contains(String key) {
        for (EmployeeUser employee : records) {
            if (employee.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public EmployeeUser getRecord(String key) {
        for (EmployeeUser employee : records) {
            if (employee.getSearchKey().equals(key)) {
                return (EmployeeUser) employee;
            }
        }
        return null;
    }

    public void insertRecord(EmployeeUser record) {
        records.add(record);
    }

    public void deleteRecord(String key) {
        EmployeeUser employeeToRemove = null;
        for (EmployeeUser employee : records) {
            if (employee.getSearchKey().equals(key)) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            records.remove(employeeToRemove);
        }
    }*/

    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Member employee : records) {
                writer.write(employee.lineRepresentation());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
