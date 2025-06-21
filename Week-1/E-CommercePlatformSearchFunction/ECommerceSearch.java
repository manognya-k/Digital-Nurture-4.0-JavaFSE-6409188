import java.util.*;

public class ECommerceSearch {
    public static void main(String[] args) {
        // Unsorted products for linear search
        Product[] productsLinear = {
            new Product(303, "Camera", "Electronics"),
            new Product(101, "Laptop", "Electronics"),
            new Product(220, "Shoes", "Footwear"),
            new Product(150, "Phone", "Electronics"),
            new Product(400, "Book", "Stationery")
        };

        // Sorted products for binary search
        Product[] productsBinary = {
            new Product(101, "Laptop", "Electronics"),
            new Product(150, "Phone", "Electronics"),
            new Product(220, "Shoes", "Footwear"),
            new Product(303, "Camera", "Electronics"),
            new Product(400, "Book", "Stationery")
        };

        int targetId = 150;

        // Linear Search
        System.out.println("\n Linear Search Result:\n");
        Product linearResult = linearSearch(productsLinear, targetId);
        if (linearResult != null)
            System.out.println("Product Found: " + linearResult);
        else
            System.out.println("Product not found using Linear Search.");

        // Binary Search
        System.out.println("\n Binary Search Result:\n");
        Product binaryResult = binarySearch(productsBinary, targetId);
        if (binaryResult != null)
            System.out.println("Product Found: " + binaryResult);
        else
            System.out.println("Product not found using Binary Search.");
    }

    // Linear Search Algorithm
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product p : products) {
            if (p.productId == targetId)
                return p;
        }
        return null;
    }

    // Binary Search Algorithm (Assumes array is sorted by productId)
    public static Product binarySearch(Product[] products, int targetId) {
        int low = 0, high = products.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (products[mid].productId == targetId)
                return products[mid];
            else if (products[mid].productId < targetId)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return null;
    }
}

// Product Class Definition
class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "ID: " + productId + ", Name: " + productName + ", Category: " + category;
    }
}
