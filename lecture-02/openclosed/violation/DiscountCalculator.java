package openclosed.violation;

public class DiscountCalculator {

    private static double CENT = 100;

    public double calculate(Membership membership, double value) {
        double discount;
        switch (membership) {
            case GOLD:
                discount = 25;
                break;
            case SILVER:
                discount = 15;
                break;
            case BRONZE:
                discount = 5;
                break;
            default:
                discount = 0;

        }
        return value - (value * (discount/CENT));
    }

    public enum Membership {
        GOLD, SILVER, BRONZE, REGULAR
    }
}
