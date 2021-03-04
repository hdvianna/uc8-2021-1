package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class HelloJComboBox extends JFrame {
    private JPanel rootContainer;
    private JComboBox themeCombo;
    private JButton closeButton;

    public HelloJComboBox() {
        initForm();
        initThemeCombo();
        initCloseButton();
    }

    private void initForm() {
        setTitle("Hello JComboBox");
        setContentPane(rootContainer);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initThemeCombo() {
        initComboData();
        initComboItemListener();
    }

    private void initComboData() {
        themeCombo.addItem(new ItemData(
                "Gnome",
                "com.sun.java.swing.plaf.gtk.GTKLookAndFeel")
        );
        themeCombo.addItem(new ItemData(
                "Metal",
                "javax.swing.plaf.metal.MetalLookAndFeel")
        );
        themeCombo.addItem(new ItemData(
                "Motif",
                "com.sun.java.swing.plaf.motif.MotifLookAndFeel")
        );
        themeCombo.addItem(new ItemData(
                "Nimbus",
                "javax.swing.plaf.nimbus.NimbusLookAndFeel")
        );
        themeCombo.addItem(new ItemData(
                "Windows",
                "com.sun.java.swing.plaf.windows.WindowsLookAndFeel")
        );
    }

    private void initComboItemListener() {
        //Listen to the combo box changes
        themeCombo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                //Peforms the action just to the selected item
                if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
                    changeLookAndFeel();
                }
            }
        });
    }

    private void changeLookAndFeel() {
        try {
            ItemData itemData = (ItemData) themeCombo.getSelectedItem();
            UIManager.setLookAndFeel((String) itemData.getValue());
            SwingUtilities.updateComponentTreeUI(this);
            pack();
        } catch (Exception exception) {
            System.err.println(exception);
        }
    }

    private void initCloseButton() {
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }

    public void showMe() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                changeLookAndFeel();
                setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        (new HelloJComboBox()).showMe();
    }

}
