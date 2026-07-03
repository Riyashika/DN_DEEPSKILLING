public class FinancialForecast {
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }
    public static double memoizedFutureValue(double presentValue, double growthRate, int years, double[] memo) {
        if (years == 0) {
            return presentValue;
        }
        if (memo[years] != 0) {
            return memo[years];
        }
        memo[years] = memoizedFutureValue(presentValue, growthRate, years - 1, memo) * (1 + growthRate);
        return memo[years];
    }
}
class FinancialForecastTest {
    public static void main(String[] args) {
        double presentValue = 10000.0;
        double growthRate = 0.08;
        int years = 5;
        System.out.println("=== Financial Forecasting Tool ===");
        System.out.println("Present Value  : Rs." + presentValue);
        System.out.println("Growth Rate    : " + (growthRate * 100) + "%");
        System.out.println("Years          : " + years);
        System.out.println();
        double result = FinancialForecast.calculateFutureValue(presentValue, growthRate, years);
        System.out.printf("Future Value (Recursive)   : Rs.%.2f%n", result);
        double[] memo = new double[years + 1];
        double memoResult = FinancialForecast.memoizedFutureValue(presentValue, growthRate, years, memo);
        System.out.printf("Future Value (Memoized)    : Rs.%.2f%n", memoResult);
        System.out.println();
        System.out.println("=== Year by Year Forecast ===");
        for (int i = 1; i <= years; i++) {
            double value = FinancialForecast.calculateFutureValue(presentValue, growthRate, i);
            System.out.printf("Year %d : Rs.%.2f%n", i, value);
        }
        System.out.println();
        System.out.println("=== Analysis ===");
        System.out.println("Recursive Time Complexity  : O(n)");
        System.out.println("Recursive Space Complexity : O(n) due to call stack");
        System.out.println("Memoized Time Complexity   : O(n) but avoids recomputation");
        System.out.println("Memoization stores already computed values so repeated");
        System.out.println("calls for the same year do not recalculate from scratch.");
    }
}
