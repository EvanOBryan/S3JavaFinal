import java.util.List;

public class Admin extends User {

    public Admin() {}

    public Admin(String username, String password, String email) {
        super(username, password, email, "admin");
    }

    // Admin-specific functionality
    public void viewAllUsers(UserDAO userDAO) {
        System.out.println("Viewing all users...");
        List<User> users = userDAO.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }

    public void deleteUser(UserDAO userDAO, int userId) {
        boolean success = userDAO.deleteUser(userId);
        if (success) {
            System.out.println("User deleted successfully!");
        } else {
            System.out.println("Failed to delete user.");
        }
    }

    public void viewAllProducts(ProductDAO productDAO) {
        System.out.println("Viewing all products...");
        List<Product> products = productDAO.getAllProducts();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    @Override
    public void displayUserDetails() {
        super.displayUserDetails();
        // Additional details specific to admins can be added here
    }
}