public class Main {
    public static void main(String[] args) {
        Order[] orders1 = {
            new Order(101, "Alice", 2000),
            new Order(102, "Bob", 5000),
            new Order(105, "Charlie", 4000),
            new Order(104, "David", 3000),
            new Order(103, "Eva", 6000)
        };

        Order[] orders2 = {
            new Order(101, "Alice", 2000),
            new Order(102, "Bob", 7000),
            new Order(105, "Eva", 4000),
            new Order(104, "David", 3000),
            new Order(103, "Charlie", 6000)
        };

        System.out.println("\nOrders before Bubble Sort:");
        displayOrders(orders1);

        bubbleSort(orders1);
        System.out.println("\nOrders after Bubble Sort:");
        displayOrders(orders1);

        System.out.println("\nOrders before Quick Sort:");
        displayOrders(orders2);

        quickSort(orders2, 0, orders2.length - 1);
        System.out.println("\nOrders after Quick Sort:");
        displayOrders(orders2);
    }

    static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    static int partition(Order[] orders, int low, int high) {
        Order pivot = orders[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice < pivot.totalPrice) {
                i++;
                swap(orders, i, j);
            }
        }
        swap(orders, i + 1, high);
        return i + 1;
    }

    static void swap(Order[] orders, int i, int j) {
        Order temp = orders[i];
        orders[i] = orders[j];
        orders[j] = temp;
    }

    static void displayOrders(Order[] orders) {
        for (Order o : orders) {
            System.out.println("OrderID: " + o.orderId + ", Name: " + o.customerName + ", Price: " + o.totalPrice);
        }
    }
}
