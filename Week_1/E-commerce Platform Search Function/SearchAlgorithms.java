public class SearchAlgorithms {
    public static Product linearSearch(Product[] products, int targetId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productId == targetId) {
                System.out.println("Linear Search: Found at index " + i);
                return products[i];
            }
        }
        System.out.println("Linear Search: Product not found");
        return null;
    }
    public static Product binarySearch(Product[] products, int targetId) {
        int low = 0;
        int high = products.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (products[mid].productId == targetId) {
                System.out.println("Binary Search: Found at index " + mid);
                return products[mid];
            } else if (products[mid].productId < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Binary Search: Product not found");
        return null;
    }
}
class EcommerceSearchTest {
    public static void main(String[] args) {
        System.out.println("=== E-commerce Platform Search Test ===\n");
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(203, "Running Shoes", "Footwear"),
            new Product(305, "Coffee Mug", "Kitchen"),
            new Product(412, "Headphones", "Electronics"),
            new Product(567, "Yoga Mat", "Sports"),
            new Product(634, "Novel Book", "Books"),
            new Product(789, "Smartphone", "Electronics")
        };
        int searchId = 412;
        System.out.println("Searching for Product ID: " + searchId);
        System.out.println("--- Linear Search ---");
        Product result1 = SearchAlgorithms.linearSearch(products, searchId);
        System.out.println("Result: " + result1);
        System.out.println();
        System.out.println("Searching for Product ID: " + searchId);
        System.out.println("--- Binary Search ---");
        Product result2 = SearchAlgorithms.binarySearch(products, searchId);
        System.out.println("Result: " + result2);
        System.out.println();
        System.out.println("Searching for Product ID: 999 (does not exist)");
        System.out.println("--- Linear Search ---");
        SearchAlgorithms.linearSearch(products, 999);
        System.out.println("--- Binary Search ---");
        SearchAlgorithms.binarySearch(products, 999);
        System.out.println();
        System.out.println("=== Analysis Summary ===");
        System.out.println("Linear Search Time Complexity : O(n)");
        System.out.println("Binary Search Time Complexity : O(log n)");
        System.out.println("Binary Search is faster for large datasets but needs sorted array.");
        System.out.println("Linear Search works on unsorted data but is slower.");
    }
}
