package inversionofcontrol;

import java.io.IOException;

public class RunMe {
    public static void main(String[] args) {
        Logger logger = new Logger(new ScreenPrinter());
        logger.info("Starting logger ...");
        logger.info("Switching to file mode ...");
        try {
            logger.setPrinter(new FilePrinter("./log.txt"));
            logger.info("Switched to file mode [OK]");
            logger.info("Over");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
