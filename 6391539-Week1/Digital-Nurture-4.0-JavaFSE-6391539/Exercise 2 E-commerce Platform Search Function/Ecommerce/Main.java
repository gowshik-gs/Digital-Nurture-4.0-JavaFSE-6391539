package Ecommerce;

public class Main {
	public static void main(String[] args) {
        Product[] products = {
            new Product(102, "Phone", "Electronics"),
            new Product(101, "Shoes", "Fashion"),
            new Product(105, "Watch", "Accessories"),
            new Product(104, "Laptop", "Electronics"),
        };
        
        // Test Linear Search
        Product foundLinear = SearchUtil.linearSearch(products, 104);
        System.out.println("Linear search found: " + foundLinear);

        // Sort and test Binary Search
        SearchUtil.sortProducts(products);
        Product foundBinary = SearchUtil.binarySearch(products, 104);
        System.out.println("Binary search found: " + foundBinary);
    }
}
