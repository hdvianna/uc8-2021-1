package openclosed.violation;


public class RunMe {
    public static void main(String args[]) {
        DiscountCalculator discountCalculator = new DiscountCalculator();
        double price = 42;
        System.out.println("Gold members price  : " + discountCalculator.calculate(DiscountCalculator.Membership.GOLD, price));
        System.out.println("Silver members price: " + discountCalculator.calculate(DiscountCalculator.Membership.SILVER, price));
        System.out.println("Bronze members price: " + discountCalculator.calculate(DiscountCalculator.Membership.BRONZE, price));
        System.out.println("Regular price       : " + discountCalculator.calculate(DiscountCalculator.Membership.REGULAR, price));
    }
}
