import java.util.ArrayList;
import java.util.Scanner;

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " - $" + price;
    }
}

class ECommerceSystem {
    private ArrayList<Product> productList = new ArrayList<>();
    private ArrayList<Product> cartList = new ArrayList<>();

    ECommerceSystem() {
        productList.add(new Product("Laptop", 999.99));
        productList.add(new Product("Phone", 499.99));
        productList.add(new Product("Headphones", 79.99));
    }

    void showProducts() {
        System.out.println("\n=== Products ===");
        for (int i = 0; i < productList.size(); i++) {
            System.out.println((i + 1) + ". " + productList.get(i));
        }
    }

    void showCart() {
        System.out.println("\n=== Cart ===");
        if (cartList.isEmpty()) {
            System.out.println("Cart is empty!");
        } else {
            for (Product p : cartList) {
                System.out.println("- " + p);
            }
        }
    }

    void addToCart(int index) {
        if (index >= 1 && index <= productList.size()) {
            cartList.add(productList.get(index - 1));
            System.out.println("Added to cart: " + productList.get(index - 1).name);
        } else {
            System.out.println("Invalid product number!");
        }
    }

    void checkout() {
        double total = 0;
        for (Product p : cartList) {
            total += p.price;
        }
        System.out.println("\n=== Checkout ===");
        System.out.printf("Total: $%.2f%n", total);
        cartList.clear();
        System.out.println("Order placed successfully!");
    }

    public static void main(String[] args) {
        ECommerceSystem system = new ECommerceSystem();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to E-Commerce System!");

        while (true) {
            System.out.println("\n1. Show Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. Show Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1: system.showProducts(); break;
                case 2:
                    system.showProducts();
                    System.out.print("Enter product number: ");
                    int num = scanner.nextInt();
                    system.addToCart(num);
                    break;
                case 3: system.showCart(); break;
                case 4: system.checkout(); break;
                case 5:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}