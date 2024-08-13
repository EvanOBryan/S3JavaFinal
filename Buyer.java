import java.util.List;

public class Buyer extends User {
    private final ProductDAO productDAO;

    public Buyer(int id, String username, String password, String email, ProductDAO productDAO) {
        super(id, username, password, email, "buyer");
        this.productDAO = productDAO;
    }

    // Browse all products available in the system
    public void browseProducts() {
        System.out.println("Browsing all available products:");
        List<Product> products = productDAO.getAllProducts();
        if (products.isEmpty()) {
            System.out.println("No products available at the moment.");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    // Search for a specific product by name
    public void searchProducts(String productName) {
        System.out.println("Searching for products with name: " + productName);
        List<Product> products = productDAO.searchProductsByName(productName);
        if (products.isEmpty()) {
            System.out.println("No products found with the name: " + productName);
        } else {
            System.out.println("Search Results:");
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }
}