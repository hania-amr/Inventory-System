package backend;

import java.io.*;


public class ProductDatabase extends Database{

    public ProductDatabase(String filename) {
        super(filename);
    }

    public void readFromFile()
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename)))
        {
            String line;
            while ((line = reader.readLine()) != null) {
                Product product = createRecordFrom(line);
                records.add(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Product createRecordFrom(String line) {
        String[] data = line.split(",");
        if (data.length == 6) {
            String productID = data[0];
            String productName = data[1];
            String manufacturerName = data[2];
            String supplierName = data[3];
            int quantity = Integer.parseInt(data[4]);
            float price = Float.parseFloat(data[5]);
            return new Product(productID, productName, manufacturerName, supplierName, quantity, price);
        } else {
            // Handle invalid input data
            return null;
        }
    }

   /* public ArrayList<Product> returnAllRecords() {
        return records;
    }

    public boolean contains(String key) {
        for (Product product : records) {
            if (product.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public Product getRecord(String key) {
        for (Product product : records) {
            if (product.getSearchKey().equals(key)) {
                return product;
            }
        }
        return null; 
    }

    public void insertRecord(Product record) {
        records.add(record);
    }

    public void deleteRecord(String key) {
        Product productToRemove = null;
        for (Product product : records) {
            if (product.getSearchKey().equals(key)) {
                productToRemove = product;
                break;
            }
        }
        if (productToRemove != null) {
            records.remove(productToRemove);
        }
    }*/

    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Member product : records) {
                writer.write(product.lineRepresentation());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

