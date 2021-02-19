package inversionofcontrol;

public class ScreenPrinter implements Printer {
    @Override
    public void print(String text) {
        System.out.println(text);
    }
}
