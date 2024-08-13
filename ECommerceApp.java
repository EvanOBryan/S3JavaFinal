import java.math.BigDecimal;
import java.util.Scanner;

public class ECommerceApp {

    private static UserService userService = new UserService(null);
    private static ProductService productService = new ProductService(null);
    private static Scanner scanner = new Scanner(System.in);
    private static User loggedInUser;

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("Welcome to the E-Commerce Platform");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    running = false;
                    System.out.println("Thank you for using the platform!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            if (loggedInUser != null) {
                switch (loggedInUser.getRole()) {
                    case "buyer":
                        showBuyerMenu();
                        break;
                    case "seller":
                        showSellerMenu();
                        break;
                    case "admin":
                        showAdminMenu();
                        break;
                    default:
                        System.out.println("Invalid role.");
                        loggedInUser = null;
                }
            }
        }

        scanner.close();
    }

    private static void register() {
        System.out.println("Register a new user");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Role (buyer, seller, admin): ");
        String role = scanner.nextLine();

        User user = new User(username, password, email, role);
        boolean success = userService.registerUser(user.getUsername(), user.getPassword(), user.getEmail(), user.getRole());

        if (success) {
            System.out.println("Registration successful!");
        } else {
            System.out.println("Registration failed. Please try again.");
        }
    }

    private static void login() {
        System.out.println("Login to the platform");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        loggedInUser = userService.login(username, password);

        if (loggedInUser == null) {
            System.out.println("Invalid username or password. Please try again.");
        } else {
            System.out.println("Login successful!");
        }
    }

    private static void showBuyerMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\nBuyer Menu");
            System.out.println("1. Browse Products");
            System.out.println("2. Search Product");
            System.out.println("3. Logout");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    browseProducts();
                    break;
                case 2:
                    searchProduct();
                    break;
                case 3:
                    running = false;
                    loggedInUser = null;
                    System.out.println("Logged out successfully.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showSellerMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\nSeller Menu");
            System.out.println("1. Add Product");
            System.out.println("2. View My Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Logout");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    viewMyProducts();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 5:
                    running = false;
                    loggedInUser = null;
                    System.out.println("Logged out successfully.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showAdminMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\nAdmin Menu");
            System.out.println("1. View All Users");
            System.out.println("2. Delete User");
            System.out.println("3. View All Products");
            System.out.println("4. Logout");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewAllUsers();
                    break;
                case 2:
                    deleteUser();
                    break;
                case 3:
                    viewAllProducts();
                    break;
                case 4:
                    running = false;
                    loggedInUser = null;
                    System.out.println("Logged out successfully.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void browseProducts() {
        System.out.println("All Available Products:");
        List<Product> products = productService.getAllProducts();
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }
    private static void searchProducts() {
        System.out.print("Enter the name of the product to search: ");
        String productName = scanner.nextLine();
        List<Product> products = productService.searchProductsByName(productName);
        if (products.isEmpty()) {
            System.out.println("No products found with the name: " + productName);
        } else {
            System.out.println("Search Results:");
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    private static void addProduct() {
        System.out.println("Adding a new product");
        System.out.print("Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Price: ");
        BigDecimal price = scanner.nextBigDecimal();
        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Product product = new Product(quantity, name, price, quantity, loggedInUser.getId());
        productService.addProduct(product.getName(), product.getPrice().doubleValue(), product.getQuantity(), loggedInUser.getId());
        System.out.println("Product added successfully!");
    }

    private static void viewMyProducts(User seller) {
        System.out.println("Your Products:");
        List<Product> products = productService.getProductsBySellerId(seller.getId());
        if (products.isEmpty()) {
            System.out.println("You have not listed any products.");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    private static void updateProduct() {
        System.out.print("Enter product ID to update: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("New Product Name: ");
        String name = scanner.nextLine();
        System.out.print("New Price: ");
        BigDecimal price = scanner.nextBigDecimal();
        System.out.print("New Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Product product = new Product(productId, name, price, quantity, loggedInUser.getId());
        productService.updateProduct(product.getId(), product.getName(), product.getPrice().doubleValue(), product.getQuantity());
        System.out.println("Product updated successfully!");
    }

    private static void deleteProduct() {
        System.out.print("Enter product ID to delete: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        productService.deleteProduct(productId);
        System.out.println("Product deleted successfully!");
    }

    private static void viewAllUsers() {
        System.out.println("All Users:");
        List<User> users = userService.getAllUsers();
        if (users.isEmpty()) {
            System.out.println("No users found.");
        } else {
            for (User user : users) {
                System.out.println(user);
            }
        }
    }

    private static void deleteUser() {
        System.out.print("Enter user ID to delete: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        userService.deleteUser(userId);
        System.out.println("User deleted successfully!");
    }

    private static void viewAllProducts() {
        System.out.println("All Products in the System:");
        List<Product> products = productService.getAllProductsWithSellerInfo();
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            for (Product product : products) {
                System.out.println(product);
                User seller = userService.getUserById(product.getSellerId());
                System.out.println("Sold by: " + seller.getUsername() + " (Email: " + seller.getEmail() + ")");
            }
        }
    }
}