package backend;

public class Product implements Member{
    private String productID;
    private String productName;
    private String manufacturerName;
    private String supplierName;
    private int quantity;
    private float price;

    public Product(String productID, String productName, String manufacturerName, String supplierName, int quantity, float price) {
        this.productID = productID;
        this.productName = productName;
        this.manufacturerName = manufacturerName;
        this.supplierName = supplierName;
        this.quantity = quantity;
        this.price = price;
    }

   public int getQuantity()
   {
       return quantity;

   }
   public float getPrice() {
       return price;
   }
    public void increaseQuantity() {
        quantity++;
    }
    public void decreaseQuantity() {
        if (quantity > 0) {
            quantity--;
        }
    }
    public void setQuantity(int quantity)
    {
        if (quantity >= 0)
            this.quantity = quantity;
    }
    public String lineRepresentation() {
        return productID + "," + productName + "," + manufacturerName + "," + supplierName + "," + quantity + "," + price;
    }

    public String getSearchKey() {
        return productID;
    }
}

