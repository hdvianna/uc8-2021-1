package gui.jtable;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HelloJTable extends JFrame {
    private JPanel rootContainer;
    private JButton newButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton closeButton;
    private JTable charactersTable;

    public HelloJTable() {
        initializeWindow();
        initializeJTable();
        initializeButtons();
    }

    private void initializeWindow() {
        setTitle("Hello JTable");
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

    private void initializeJTable() {
        TableModel tableModel = new CharactersTableModel();
        charactersTable.setModel(tableModel);
        DefaultTableCellRenderer defaultHeaderRenderer = (DefaultTableCellRenderer) charactersTable
                .getTableHeader()
                .getDefaultRenderer();
        defaultHeaderRenderer.setHorizontalAlignment(JLabel.CENTER);
    }


    private void initializeButtons() {
        JFrame owner = this;
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                HelloModal helloModal = new HelloModal(owner, true);
                helloModal.showMe();
            }
        });
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }

    public void showMe() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                setSize(500, 300);
                setVisible(true);
            }
        });
    }
}
