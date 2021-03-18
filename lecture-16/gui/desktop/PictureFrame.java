package gui.desktop;

import javax.swing.*;
import java.beans.PropertyVetoException;

public class PictureFrame extends JInternalFrame {
    private JPanel rootContainer;
    private JLabel pictureLabel;
    private JLabel linkLabel;
    private String title;
    private String url;
    private String imagePath;

    public PictureFrame(String title, String url, String imagePath) {
        super(title, true, true, true);
        this.title = title;
        this.url = url;
        this.imagePath = imagePath;
        initPicture();
        initLink();
        initWindow();
    }

    private void initWindow() {
        setContentPane(rootContainer);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        pack();
    }

    private void initPicture() {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        pictureLabel.setText("");
        pictureLabel.setIcon(imageIcon);
    }

    private void initLink() {
        String html = "<html><div style='text-align: center;'><strong>" + title + "</strong> <br>(" + url + ")</div></html>";
        linkLabel.setText(html);
    }

    public void showMe() {
        setVisible(true);
        try {
            setSelected(true);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }
}
