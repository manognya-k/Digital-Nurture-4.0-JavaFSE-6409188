import java.util.*;

public class Main {
    public static void main(String[] args) {
        Book[] books = {
            new Book(101, "Java", "James Gosling"),
            new Book(102, "C", "Dennis Ritchie"),
            new Book(103, "Python", "Guido van Rossum"),
            new Book(104, "JavaScript", "Brendan Eich"),
            new Book(105, "C++", "Bjarne Stroustrup")
        };

        Scanner sc = new Scanner(System.in);

        // Linear Search
        System.out.println("Enter book title to search (Linear Search):");
        String title1 = sc.nextLine();
        linearSearch(books, title1);

        // Sort before Binary Search
        Arrays.sort(books, Comparator.comparing(b -> b.title));

        System.out.println("\nEnter book title to search (Binary Search):");
        String title2 = sc.nextLine();
        int index = binarySearch(books, title2);
        if (index != -1)
            System.out.println("Book found: " + books[index].title + " by " + books[index].author);
        else
            System.out.println("Book not found.");
        
        sc.close();
    }

    static void linearSearch(Book[] books, String title) {
        boolean found = false;
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                System.out.println("Book found: " + b.title + " by " + b.author);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book not found.");
        }
    }

    static int binarySearch(Book[] books, String title) {
        int low = 0, high = books.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int compare = books[mid].title.compareToIgnoreCase(title);
            if (compare == 0) return mid;
            else if (compare < 0) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}
