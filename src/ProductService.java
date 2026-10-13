
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    private final List<Product> products = new ArrayList<>();

    public ProductService() {
        products.add(new Product(101, "Laptop", 55000));
        products.add(new Product(102, "Mobile", 25000));
        products.add(new Product(103, "Headphones", 2000));
    }

    public void displayAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        for (Product product : products) {
            product.displayProduct();
        }
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }

        return null;
    }

    public void addProduct(int id, String name, double price) {
        if (findById(id) != null) {
            throw new IllegalArgumentException(
                    "Product ID already exists."
            );
        }

        products.add(new Product(id, name, price));
    }

    public boolean deleteProduct(int id) {
        Product product = findById(id);

        if (product != null) {
            products.remove(product);
            return true;
        }

        return false;
    }

    // Update product name and price
    public boolean updateProduct(int id, String name, double price) {

        Product product = findById(id);

        if (product == null) {
            return false;
        }

        // Validate before changing either field
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "Product name cannot be empty."
            );
        }

        if (price <= 0) {
            throw new IllegalArgumentException(
                    "Product price must be positive."
            );
        }

        product.setName(name);
        product.setPrice(price);

        return true;
    }
}
