public class ProfitLossCalculator {
    public static void main(String[] args) {
        // Given cost and selling prices
        double costPrice = 129.0;
        double sellingPrice = 191.0;

        // Calculate profit
        double profit = sellingPrice - costPrice;

        // Calculate profit percentage
        double profitPercentage = (profit / costPrice) * 100.0;

        // Display results using a single print statement and formatted output
        System.out.printf(
            "The Cost Price is INR %.2f and Selling Price is INR %.2f%n" +
            "The Profit is INR %.2f and the Profit Percentage is %.2f%%",
            costPrice, sellingPrice, profit, profitPercentage
        );
    }
}
