package openclosed.implementation;

public class RunMe {
    public static void main(String args[]) {
        double price = 42;
        System.out.println("Gold members price  : " + (new GoldDiscountMembership()).discount(price));
        System.out.println("Silver members price: " + (new SilverMembership()).discount(price));
        System.out.println("Bronze members price: " + (new BronzeMembership()).discount(price));
        System.out.println("Regular price       : " + (new RegularMembership()).discount(price));
    }
}
