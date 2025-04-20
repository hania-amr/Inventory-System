package backend;

import java.io.IOException;

public class test {
    //testEmployee user
    public static void main(String[] args) throws IOException {
        EmployeeUser user1 = new EmployeeUser("12345", "name", "email", "address", "0123648");
        user1.lineRepresentation();
        System.out.println(user1.getSearchKey());
        EmployeeUserDatabase employeeUserDatabase = new EmployeeUserDatabase("C:\\Users\\ADMIN\\IdeaProjects\\Lab4\\employees.txt");
        employeeUserDatabase.readFromFile();
        employeeUserDatabase.createRecordFrom(user1.lineRepresentation());
        employeeUserDatabase.createRecordFrom("186268,name2,email2,adress2,phonenumber2");
        employeeUserDatabase.returnAllRecords();
        employeeUserDatabase.insertRecord(user1);
        System.out.println("Conatins?");
        //System.out.println(employeeUserDatabase.contains(user1.getSearchKey()));
        employeeUserDatabase.saveToFile();
        //employeeUserDatabase.deleteRecord(user1.getSearchKey());

        //testProduct
        Product p1 = new Product("15892","prName","manname","suppname",60,1000);
        Product p2= new Product("155622","prName2","manname2","suppname2",99,10);
        ProductDatabase productDatabase = new ProductDatabase("C:\\Users\\ADMIN\\IdeaProjects\\Lab4\\src\\Products.txt");
        productDatabase.readFromFile();

        productDatabase.insertRecord(productDatabase.createRecordFrom(p1.lineRepresentation()));
        productDatabase.insertRecord(productDatabase.createRecordFrom(p2.lineRepresentation()));
        productDatabase.returnAllRecords();
        productDatabase.contains(p1.getSearchKey());










    }
}