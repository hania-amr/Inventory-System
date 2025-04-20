package backend;

import java.time.LocalDate;

public class CustomerProduct implements Member {
    private String customerSSN;
    private String productID;
    private LocalDate purchaseDate;

    public CustomerProduct(String customerSSN, String productID, LocalDate purchaseDate) {
        this.customerSSN = customerSSN;
        this.productID = productID;
        this.purchaseDate = purchaseDate;
    }

   public String getCustomerSSN()
   {return customerSSN;}
    public String getProductID(){return productID;}
    public LocalDate getPurchaseDate(){return purchaseDate;}

    public String lineRepresentation() {
        return customerSSN + "," + productID + "," + purchaseDate.toString();
    }

    public String getSearchKey() {
        return customerSSN + "," + productID + "," + purchaseDate.toString();
    }
}

