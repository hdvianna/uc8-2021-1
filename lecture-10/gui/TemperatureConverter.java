package gui;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class TemperatureConverter extends JFrame {
    private JPanel rootContainer;
    private JTextField temperatureTextField;
    private JRadioButton celsiusRadioButton;
    private JRadioButton fahrenheitRadioButton;
    private JLabel convertedTemperatureLabel;

    public TemperatureConverter() {
        initForm();
        initRadioButtons();
        initTemperatureTextField();
        updateTemperature();
    }

    public void initForm() {
        setTitle("Temperature Converter");
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

    private void initRadioButtons() {
        ItemListener itemListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
                    updateTemperature();
                }
            }
        };

        celsiusRadioButton.addItemListener(itemListener);
        fahrenheitRadioButton.addItemListener(itemListener);
    }

    private void initTemperatureTextField() {
        temperatureTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                updateTemperature();
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                updateTemperature();
            }

            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                updateTemperature();
            }
        });
    }

    private void updateTemperature() {
        String temperatureText = temperatureTextField.getText();
        if (isNumber(temperatureText)) {
            long temperature = Integer.parseInt(temperatureText);
            String convertedTemperatureType = celsiusRadioButton.isSelected() ? "Fahrenheit" : "Celsius";
            String convertedTemperature = convertTemperature(temperature) + "° " + convertedTemperatureType;
            convertedTemperatureLabel.setText(convertedTemperature);
        } else {
            convertedTemperatureLabel.setText("Please type in a number ...");
        }
    }

    private double convertTemperature(long temperature) {
        if (celsiusRadioButton.isSelected()) {
            return (temperature * 9/5) + 32;
        } else {
            return (temperature - 32) * 5/9;
        }
    }

    private boolean isNumber(String value) {
        for (char c : value.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return value.length() > 0;
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
        (new TemperatureConverter()).showMe();
    }

}
