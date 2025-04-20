package backend;

import java.time.LocalDate;

public class EmployeeRole {
    private final ProductDatabase productDatabase;
    private final CustomerProductDatabase customerProductDatabase ;

    public EmployeeRole(ProductDatabase productDatabase ,CustomerProductDatabase customerProductDatabase)
    {
        this.productDatabase=productDatabase;
        this.customerProductDatabase=customerProductDatabase;
    }

    public void addProduct(String productID, String productName, String manufacturerName, String supplierName, int quantity,float price)
        {
        Product product = new Product(productID, productName, manufacturerName, supplierName, quantity,price);
        productDatabase.insertRecord(product);
        }
        public Product[] getListOfProducts()
        {
            return productDatabase.returnAllRecords().toArray(new Product[0]);
        }
    public CustomerProduct[] getListOfPurchasingOperations()
    {
        return customerProductDatabase.returnAllRecords().toArray(new CustomerProduct[0]);
    }
     public boolean purchaseProduct(String customerSSN, String productID, LocalDate purchaseDate)
     {
         Product p = (Product) productDatabase.getRecord(productID);
         if (p != null && p.getQuantity() > 0) {
             CustomerProduct customerProduct = new CustomerProduct(customerSSN, productID, purchaseDate);
             customerProductDatabase.insertRecord(customerProduct);
             p.decreaseQuantity();
             return true;
         }
         return false;
     }
    public double returnProduct(String customerSSN, String productID, LocalDate purchaseDate, LocalDate returnDate) {
        if (returnDate.isBefore(purchaseDate)) {
            return -1;
        }

        String customerProductKey = customerSSN + "," + productID + "," + purchaseDate.toString();
        if (!customerProductDatabase.contains(customerProductKey)) {
            return -1;
        }

        Member customerProduct = customerProductDatabase.getRecord(customerProductKey);

        LocalDate maxReturnDate = purchaseDate.plusDays(14);
        if (returnDate.isAfter(maxReturnDate)) {
            return -1;
        }

        Product product = (Product) productDatabase.getRecord(productID);
        if (product != null) {
            product.increaseQuantity();
        }

        customerProductDatabase.deleteRecord(customerProductKey);

        productDatabase.saveToFile();

        return product.getPrice();
    }

    public void logout() {
        productDatabase.saveToFile();
        customerProductDatabase.saveToFile();
    }

     }








