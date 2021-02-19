package openclosed.implementation;

public class SilverMembership implements DiscountCalculator {

    private static double DISCOUNT = 15;
    private static double CENT = 100;

    @Override
    public double discount(double value) {
        return value - (value * (DISCOUNT/CENT));
    }

}