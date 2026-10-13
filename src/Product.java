
public class Product {

    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        if (id <= 0) {
            throw new IllegalArgumentException(
                    "Product ID must be positive."
            );
        }

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

        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "Product name cannot be empty."
            );
        }

        this.name = name;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(
                    "Product price must be positive."
            );
        }

        this.price = price;
    }

    public void displayProduct() {
        System.out.println("Product ID: " + id);
        System.out.println("Product Name: " + name);
        System.out.println("Product Price: " + price);
        System.out.println("-------------------------");
    }
}
