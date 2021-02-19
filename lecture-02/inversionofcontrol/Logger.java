package inversionofcontrol;

public class Logger {

    private Printer printer;

    public Logger(Printer printer) {
        this.printer = printer;
    }

    public Printer getPrinter() {
        return printer;
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    public void warning(String message) {
        printer.print("[WARNING]: " + message);
    }

    public void error(String message) {
        printer.print("[ERROR]: " + message);
    }

    public void info(String message) {
        printer.print("[INFO]: " + message);
    }
}
