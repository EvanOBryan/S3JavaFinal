import java.util.List;

public class Seller extends User {

    public Seller() {}

    public Seller(String username, String password, String email) {
        super(username, password, email, "seller");
    }

    // Seller-specific functionality
    public void addProduct(ProductDAO productDAO, Product product) {
        boolean success = productDAO.addProduct(product);
        if (success) {
            System.out.println("Product added successfully!");
        } else {
            System.out.println("Failed to add product.");
        }
    }

    public void viewMyProducts(ProductDAO productDAO) {
        System.out.println("Viewing my products...");
        List<Product> products = productDAO.getProductsBySellerId(this.getId());
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void updateProduct(ProductDAO productDAO, Product product) {
        boolean success = productDAO.updateProduct(product);
        if (success) {
            System.out.println("Product updated successfully!");
        } else {
            System.out.println("Failed to update product.");
        }
    }

    public void deleteProduct(ProductDAO productDAO, int productId) {
        boolean success = productDAO.deleteProduct(productId);
        if (success) {
            System.out.println("Product deleted successfully!");
        } else {
            System.out.println("Failed to delete product.");
        }
    }

    @Override
    public void displayUserDetails() {
        super.displayUserDetails();
        // Additional details specific to sellers can be added here
    }
}