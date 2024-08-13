import java.math.BigDecimal;
import java.util.List;

public class ProductService {
    private ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public boolean addProduct(String name, double price, int quantity, int sellerId) {
        Product product = new Product();
        return productDAO.addProduct(product);
    }

    public List<Product> getProductsBySeller(int sellerId) {
        return productDAO.getProductsBySellerId(sellerId);
    }

    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    public boolean updateProduct(int productId, String name, double price, int quantity) {
        Product product = productDAO.getProductById(productId);
        if (product != null) {
            product.setName(name);
            product.setPrice(BigDecimal.valueOf(price));
            product.setQuantity(quantity);
            return productDAO.updateProduct(product);
        }
        return false;
    }

    public boolean deleteProduct(int productId) {
        return productDAO.deleteProduct(productId);
    }
}