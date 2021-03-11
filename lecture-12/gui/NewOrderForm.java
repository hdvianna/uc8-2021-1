package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class NewOrderForm extends JFrame {

    private static String CHEESEBURGER_IMAGE_PATH = "./resources/images/cheeseburger.jpg";
    private static String FRENCHFRIES_IMAGE_PATH = "./resources/images/fries.jpg";
    private static String SODA_IMAGE_PATH = "./resources/images/soda.jpg";

    private JPanel rootContainer;
    private JPanel mainContainer;
    private JPanel optionsContainer;
    private JPanel controlsContainer;
    private JPanel viewContainer;
    private JCheckBox cheeseburgerCheckBox;
    private JCheckBox frenchfriesCheckBox;
    private JCheckBox sodaCheckBox;
    private JButton checkoutButton;
    private JScrollPane cheeseburgerContainer;
    private JScrollPane frenchfriesContainer;
    private JScrollPane sodaContainer;

    public NewOrderForm()  {
        initForm();
        initCheckBoxes();
        initCheckoutButton();
        initItemContainers();
    }

    private void initForm() {
        setTitle("New order");
        setContentPane(rootContainer);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    private void initCheckBoxes() {
        initCheckBox(cheeseburgerCheckBox,
                cheeseburgerContainer,
                CHEESEBURGER_IMAGE_PATH);
        initCheckBox(frenchfriesCheckBox,
                frenchfriesContainer,
                FRENCHFRIES_IMAGE_PATH);
        initCheckBox(sodaCheckBox,
                sodaContainer,
                SODA_IMAGE_PATH);
    }

    private void initCheckBox(JCheckBox checkBox,
                              JScrollPane container,
                              String imagePath) {
        checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (itemEvent.getStateChange() == ItemEvent.SELECTED ||
                        itemEvent.getStateChange() == ItemEvent.DESELECTED){

                    togglePicture(checkBox, container, imagePath);
                }
            }
        });
    }

    private void togglePicture(JCheckBox checkBox,
                               JScrollPane container,
                               String imagePath) {
        if (checkBox.isSelected()) {
            showPicture(container, imagePath);
        } else {
            hidePicture(container);
        }
    }

    private void showPicture(JScrollPane container,
                             String imagePath) {
        ImageIcon image = new ImageIcon(imagePath);
        JLabel picture = new JLabel();
        picture.setIcon(image);
        container.setViewportView(picture);
    }

    private void hidePicture(JScrollPane container) {
        container.setViewportView(null);
    }

    private void initCheckoutButton() {
        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }

    private void initItemContainers() {
        cheeseburgerContainer.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        cheeseburgerContainer.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        frenchfriesContainer.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        frenchfriesContainer.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        sodaContainer.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sodaContainer.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
    }

    public void showMe() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                pack();
                setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        (new NewOrderForm()).showMe();
    }
}
