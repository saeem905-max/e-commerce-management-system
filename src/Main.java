
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProductService service = new ProductService();

        int choice = 0;

        while (choice != 6) {

            System.out.println("\n=== E-Commerce Management System ===");
            System.out.println("1. View Products");
            System.out.println("2. Search Product");
            System.out.println("3. Add Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Update Product");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:
                        service.displayAllProducts();
                        break;

                    case 2:
                        System.out.print("Enter Product ID: ");
                        int searchId = sc.nextInt();

                        Product found = service.findById(searchId);

                        if (found != null) {
                            found.displayProduct();
                        } else {
                            System.out.println("Product not found!");
                        }
                        break;

                    case 3:
                        System.out.print("Enter Product ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Product Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Product Price: ");
                        double price = sc.nextDouble();

                        try {
                            service.addProduct(id, name, price);
                            System.out.println(
                                    "Product added successfully!"
                            );
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 4:
                        System.out.print("Enter Product ID to delete: ");
                        int deleteId = sc.nextInt();

                        if (service.deleteProduct(deleteId)) {
                            System.out.println(
                                    "Product deleted successfully!"
                            );
                        } else {
                            System.out.println("Product not found!");
                        }
                        break;

                    case 5:
                        System.out.print("Enter Product ID to update: ");
                        int updateId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter new Product Name: ");
                        String newName = sc.nextLine();

                        System.out.print("Enter new Product Price: ");
                        double newPrice = sc.nextDouble();

                        try {
                            boolean updated = service.updateProduct(
                                    updateId, newName, newPrice
                            );

                            if (updated) {
                                System.out.println(
                                        "Product updated successfully!"
                                );
                            } else {
                                System.out.println("Product not found!");
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 6:
                        System.out.println("Thank you for visiting!");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (InputMismatchException e) {
                System.out.println(
                        "Invalid input! Please enter the correct data type."
                );
                sc.nextLine();
            }
        }

        sc.close();
    }
}
