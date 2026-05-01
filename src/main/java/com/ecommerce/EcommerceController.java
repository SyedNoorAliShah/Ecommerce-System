package com.ecommerce;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@CrossOrigin(origins = "*")
public class EcommerceController {

    private List<Product> products = Arrays.asList(
        new Product(1, "Laptop", 999.99),
        new Product(2, "Phone", 499.99),
        new Product(3, "Headphones", 79.99)
    );

    private List<Product> cart = new ArrayList<>();

    @GetMapping("/")
    public String health() { return "E-Commerce API Running!"; }

    @GetMapping("/products")
    public List<Product> getProducts() { return products; }

    @GetMapping("/cart")
    public List<Product> getCart() { return cart; }

    @PostMapping("/cart/{id}")
    public String addToCart(@PathVariable int id) {
        products.stream()
            .filter(p -> p.getId() == id)
            .findFirst()
            .ifPresent(cart::add);
        return "Added to cart!";
    }

    @PostMapping("/checkout")
    public Map<String, Object> checkout() {
        double total = cart.stream().mapToDouble(Product::getPrice).sum();
        cart.clear();
        Map<String, Object> res = new HashMap<>();
        res.put("message", "Order placed successfully!");
        res.put("total", total);
        return res;
    }

    @DeleteMapping("/cart")
    public String clearCart() {
        cart.clear();
        return "Cart cleared!";
    }
}
