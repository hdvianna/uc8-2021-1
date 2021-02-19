package inversionofcontrol;

import java.io.FileWriter;
import java.io.IOException;

public class FilePrinter implements Printer {

    private FileWriter fileWriter;

    public FilePrinter(String filePath) throws IOException {
        this.fileWriter = new FileWriter(filePath);
    }

    @Override
    public void print(String text) {
        try {
            this.fileWriter.write(text + "\r\n");
            this.fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
