package gui.desktop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;

public class MainUI extends JFrame {

    private JDesktopPane desktopPane;
    private PictureFrame catFrame;
    private PictureFrame horseFrame;
    private PictureFrame artFrame;
    private JMenuBar menuBar;
    private JMenu mainMenu;

    public MainUI() {
        initializeFrame();
        initializeMenuBar();
        initializeMainMenu();
    }

    private void initializeFrame() {
        int width = 1024;
        int height = 768;
        Point centerPoint = getWindowCenterPoint(width, height);
        desktopPane = new JDesktopPane();
        setContentPane(desktopPane);
        setTitle("Menus and Internal Windows");
        setSize(width, height);
        setLocation(centerPoint);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

    private Point getWindowCenterPoint(int width, int height) {
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point point = graphicsEnvironment.getCenterPoint();
        int x = point.x - (width/2);
        int y = point.y - (height/2);
        point.setLocation(x, y);
        return point;
    }

    private void initializeMenuBar() {
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
    }

    private void initializeMainMenu() {
        mainMenu = new JMenu();
        mainMenu.setText("Actions");

        menuBar.add(mainMenu);

        artFrame = new PictureFrame("This artwork doesn't exist", "https://thisartworkdoesnotexist.com/", "./resources/images/art.png");
        initializeInternalFrameMenuItem(artFrame, "Show me an artwork");

        catFrame = new PictureFrame("This cat doesn't exist", "https://thiscatdoesnotexist.com/", "./resources/images/cat.png");
        initializeInternalFrameMenuItem(catFrame, "Show me a cat");

        horseFrame = new PictureFrame("This horse doesn't exist", "https://thishorsedoesnotexist.com/", "./resources/images/horse.png");
        initializeInternalFrameMenuItem(horseFrame, "Show me a horse");


        mainMenu.addSeparator();
        initializeNewInternalWindowMenuItem();

        mainMenu.addSeparator();
        initializeExitMenuItem();
    }

    private void initializeInternalFrameMenuItem(PictureFrame internalFrame, String title) {
        JMenuItem menuItem = new JMenuItem();
        desktopPane.add(internalFrame);
        menuItem.setText(title);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                internalFrame.showMe();
            }
        });
        mainMenu.add(menuItem);
    }

    private void initializeNewInternalWindowMenuItem() {
        JMenu subMenu = new JMenu();
        subMenu.setText("Submenu example");
        mainMenu.add(subMenu);

        JMenuItem menuItem = new JMenuItem();
        menuItem.setText("New internal window");
        subMenu.add(menuItem);

        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JInternalFrame internalFrame = new JInternalFrame("Internal window", true, true, true, true);
                desktopPane.add(internalFrame);
                internalFrame.setSize(300, 250);
                internalFrame.setVisible(true);
                try {
                    internalFrame.setSelected(true);
                } catch (PropertyVetoException e) {
                    e.printStackTrace();
                }

            }
        });

    }


    private void initializeExitMenuItem() {
        JMenuItem menuItem = new JMenuItem();
        menuItem.setText("Exit");
        mainMenu.add(menuItem);

        KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK);
        menuItem.setAccelerator(keyStroke);

        ImageIcon imageIcon = new ImageIcon("./resources/images/exit.png");
        menuItem.setIcon(imageIcon);

        menuItem.addActionListener(new ActionListener() {
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
                setVisible(true);
            }
        });
    }

}
