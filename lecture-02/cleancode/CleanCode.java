package cleancode;

public class CleanCode {

    public static void main(String[] args) {
        double values[] = {2,3,5};
        System.out.println("Three values average: " + average(values));
    }

    private static double average(double valores[]) {
        return sum(valores)/valores.length;
    }

    private static double sum(double valores[]) {
        double sum = 0;
        for(double valor:valores) {
            sum += valor;
        }
        return sum;
    }

}
