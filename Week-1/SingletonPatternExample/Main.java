public class Main {
    public static void main(String[] args) {

        Logger objLog1 = Logger.getInstance();
        Logger objLog2 = Logger.getInstance();

        if (objLog1 == objLog2)
            System.out.println("Only one instance exists in Lazy Instantiation");
        else
            System.out.println("Multiple instances exist in Lazy Instantiation");

        Thread t1 = new Thread(() -> {
            Logger objSync1 = Logger.getInstanceSync();
        });

        Thread t2 = new Thread(() -> {
            Logger objSync2 = Logger.getInstanceSync();
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Logger objDouble1 = Logger.getInstanceDouble();
        Logger objDouble2 = Logger.getInstanceDouble();

        if (objDouble1 == objDouble2)
            System.out.println("Same Instance in Double Checked Locking");
        else
            System.out.println("Different Instances in Double Checked Locking");
    }
}
