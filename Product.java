import java.math.BigDecimal;

public class Product {

    private int id;           // Unique identifier for the product
    private String name;      // Name of the product
    private BigDecimal price; // Price of the product
    private int quantity;     // Quantity available
    private int sellerId;     // ID of the seller who listed the product
    private String sellerName; // Name of the seller (Optional, for admin views)
    private String sellerEmail; // Email of the seller (Optional, for admin views)

    // Constructor without seller information (for general use)
    public Product(int id, String name, BigDecimal price, int quantity, int sellerId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.sellerId = sellerId;
    }

    // Constructor with seller information (for admin views)
    public Product(int id, String name, BigDecimal price, int quantity, int sellerId, String sellerName, String sellerEmail) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.sellerId = sellerId;
        this.sellerName = sellerName;
        this.sellerEmail = sellerEmail;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal bigDecimal) {
        this.price = BigDecimal.valueOf(bigDecimal.longValue());
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerEmail() {
        return sellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", sellerId=" + sellerId +
                ", sellerName='" + sellerName + '\'' +
                ", sellerEmail='" + sellerEmail + '\'' +
                '}';
    }
}