package backend;

import java.io.IOException;
import java.time.LocalDate;

public class Main {

        public static void main(String[] args) throws IOException {
            EmployeeUser e1 = new EmployeeUser("758578", "hania", "hauhuygduywei", "123456", "78654");
            Product p1 = new Product("789244", "chips", "chipsy", "hania", 100, 5);
            CustomerProduct c1 = new CustomerProduct("569529","T8957", LocalDate.parse("2023-02-10"));
            EmployeeUserDatabase empDatabase = new EmployeeUserDatabase("C:\\Users\\ADMIN\\IdeaProjects\\Lab4\\employees.txt");
            ProductDatabase productDatabase = new ProductDatabase("C:\\Users\\ADMIN\\IdeaProjects\\Lab4\\products.txt");
            CustomerProductDatabase customerProductDatabase = new CustomerProductDatabase("C:\\Users\\ADMIN\\IdeaProjects\\Lab4\\customerproducts.txt");
            empDatabase.readFromFile();
            empDatabase.createRecordFrom(e1.lineRepresentation());
            empDatabase.returnAllRecords();
            empDatabase.contains("E1200");
            productDatabase.readFromFile();
            productDatabase.returnAllRecords();
            System.out.println(c1.lineRepresentation());
            customerProductDatabase.createRecordFrom(c1.lineRepresentation());
            customerProductDatabase.contains("569529");








    }



}
