package finance;

public class FinancialForecasting {
//Recursion
    public static double predictFutureValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return predictFutureValue(presentValue, growthRate, years - 1) * (1 + growthRate);
    }
	// without Recursion
	public static double predictFutureValueIterative(double presentValue, double rate, int years) {
	    double value = presentValue;
	    for (int i = 0; i < years; i++) {
	        value *= (1 + rate);
	    }
	    return value;
	}


    public static void main(String[] args) {
        double presentValue = 1000.0;
        double rate = 0.05; 
        int years = 10;
        System.out.println("Using Recurison:");

        double predicted = predictFutureValue(presentValue, rate, years);
        System.out.printf("Predicted future value after %d years: %.2f\n", years, predicted);
        System.out.println("Using Iteration:");
        double predicted1 = predictFutureValueIterative(presentValue, rate, years);
        System.out.printf("Predicted future value after %d years: %.2f\n", years, predicted1);
    }
}
