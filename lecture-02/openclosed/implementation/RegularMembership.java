package openclosed.implementation;

public class RegularMembership implements DiscountCalculator {
    private static double DISCOUNT = 0;
    private static double CENT = 100;

    @Override
    public double discount(double value) {
        return value - (value * (DISCOUNT/CENT));
    }

}