package openclosed.implementation;

public class GoldMembership implements DiscountCalculator {
    private static double DISCOUNT = 25;
    private static double CENT = 100;

    @Override
    public double discount(double value) {
        return value - (value * (DISCOUNT/CENT));
    }

}
