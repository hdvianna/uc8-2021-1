package openclosed.implementation;

public class BronzeMembership implements DiscountCalculator {
    private static double DISCOUNT = 5;
    private static double CENT = 100;
    @Override
    public double discount(double value) {
        return value - (value * (DISCOUNT/CENT));
    }
}
