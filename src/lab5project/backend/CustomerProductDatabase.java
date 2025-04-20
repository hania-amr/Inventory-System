package backend;

import java.io.*;
import java.time.LocalDate;

public class CustomerProductDatabase extends Database{

public CustomerProductDatabase(String filename)
{
            super(filename);
    }


    public void readFromFile() {
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    CustomerProduct customerProduct = createRecordFrom(line);
                    records.add(customerProduct);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public CustomerProduct createRecordFrom(String line) {
            String[] data = line.split(",");
            if (data.length == 3) {
                String customerSSN = data[0];
                String productID = data[1];
                LocalDate purchaseDate = LocalDate.parse(data[2]);
                return new CustomerProduct(customerSSN,productID,purchaseDate);
            } else {
                return null;

            }
        }

       /* public ArrayList<CustomerProduct> returnAllRecords() {
            return records;
        }

        public boolean contains(String key) {
            for (CustomerProduct customerProduct : records) {
                if (customerProduct.getSearchKey().equals(key)) {
                    return true;
                }
            }
            return false;
        }

        public CustomerProduct getRecord(String key) {
            for (CustomerProduct customerProduct : records) {
                if (customerProduct.getSearchKey().equals(key)) {
                    return customerProduct;
                }
            }
            return null;
        }

        public void insertRecord(CustomerProduct record) {
            records.add(record);
        }

        public void deleteRecord(String key) {
            CustomerProduct customerProductToRemove = null;
            for (CustomerProduct customerProduct : records) {
                if (customerProduct.getSearchKey().equals(key)) {
                    customerProductToRemove = customerProduct;
                    break;
                }
            }
            if (customerProductToRemove != null) {
                records.remove(customerProductToRemove);
            }
        }*/

        public void saveToFile() {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                for (Member customerProduct : records) {
                    writer.write(customerProduct.lineRepresentation());
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


