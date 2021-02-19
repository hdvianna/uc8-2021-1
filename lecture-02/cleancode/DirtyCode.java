package cleancode;

public class DirtyCode {
    /**
     * This method calculates the average of two values
     * @param value1 value 1
     * @param value2 value 2
     * @return result
     */
    private static double threeValuesAverage(double value1,
                        double value2,
                        double value3) {
        return (value1 + value2 + value3)/3;
    }

    public static void main(String[] args) {
        System.out.println("Three values average: " + threeValuesAverage(2,3,5));
    }


}
