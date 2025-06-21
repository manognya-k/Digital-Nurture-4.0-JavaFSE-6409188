import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nWelcome to Financial Forecasting.\n");

        System.out.print("Enter the Principal Amount: ");
        int principalAmount = sc.nextInt();

        System.out.print("Enter the Growth Rate (in %): ");
        double growthRate = sc.nextDouble();
        growthRate = growthRate / 100;

        System.out.print("Enter the Time Duration (in Years): ");
        int time = sc.nextInt();

        System.out.printf("\nThe Future Predicted Value is: %.3f\n", findFutureValue(principalAmount, growthRate, time));

        sc.close();
    }

    // Iterative method to calculate future value
    static double findFutureValue(int principalAmount, double growthRate, int time) {
        double futureValue = principalAmount;
        for (int i = 1; i <= time; i++) {
            futureValue *= (1 + growthRate);
        }
        return futureValue;
    }
}
