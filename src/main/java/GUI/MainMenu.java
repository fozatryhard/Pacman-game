package GUI;

import AnimationEngine.BlinkAnimator;
import Painter.Scaler;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URI;

/**
 * The Mainmenu of the game
 */
public class MainMenu extends JFrame {

    private StartGamePanel startpanel;

    public static void main(String[] args) {
        System.setProperty("sun.java2d.opengl", "true");
        System.setProperty("prism.allowhidpi", "false");
        System.setProperty("sun.java2d.uiScale", "1");

        new MainMenu();
    }

    /**
     * Initializes the MainMenu frame.
     */
    public MainMenu() {
        super();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int size = Math.min(screenSize.height, screenSize.width);
        Scaler.setNewsize(size);

        setTitle("SwingPacman - MENU");
        //setIconImage(Media.getImg(EImage.pacman_right_1)); // Removed icon setting

        initComponents();
        adjustSizes();

        startpanel = new StartGamePanel(this.getWidth(), this);
        exit_button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                BlinkAnimator blinkAnimator = new BlinkAnimator(exit_button, 80, true);
                blinkAnimator.start();
                System.exit(0);
            }
        });
        play_button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                BlinkAnimator blinkAnimator = new BlinkAnimator(play_button, 80, true);
                blinkAnimator.start();
                showNewGamepanel();
            }
        });

        setUndecorated(true);

        add(startpanel, 0);
        startpanel.setLocation(0, 0);
        startpanel.setVisible(false);

        try {
            InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("res/gif/gameplay.gif");
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int nRead;
            byte[] data = new byte[16384];
            while ((nRead = in.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }

            ImageIcon imageIcon = new ImageIcon(new ImageIcon(
                    buffer.toByteArray()
            ).getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT));

            JLabel label = new JLabel(imageIcon);
            add(label);
            label.setBounds(0, 0, getWidth(), getHeight());

        } catch (Exception e) {
            e.printStackTrace();
        }
        setVisible(true);
    }




    public void showMainPanel() {
        startpanel.setVisible(false);
        main_panel.setVisible(true);
    }

    public void showNewGamepanel() {
        main_panel.setVisible(false);
        startpanel.setVisible(true);
    }


    public void adjustSizes() {
        setSize(Scaler.scale(main_panel.getWidth()), Scaler.scale(main_panel.getHeight()));
        int width = this.getWidth();
        int height = this.getHeight();
        // Media.rescaleMedia(Scaler.getScale_factor()); // Removed media scaling

        main_panel.setSize(width, height);
        title.setBounds(Scaler.scale(title.getX()), Scaler.scale(title.getY()), Scaler.scale(title.getWidth()), Scaler.scale(title.getHeight()));
        title.setFont(title.getFont().deriveFont(Font.PLAIN, Scaler.scale(title.getFont().getSize())));

        play_button.setFont(play_button.getFont().deriveFont(Font.PLAIN, (int) Scaler.scale(play_button.getFont().getSize())));
        play_button.setBounds(Scaler.scale(play_button.getX()), Scaler.scale(play_button.getY()), Scaler.scale(play_button.getWidth()), Scaler.scale(play_button.getHeight()));
        play_button.setBorder(BorderFactory.createLineBorder(Color.yellow, Scaler.scale(3)));
        play_button.setOpaque(true);

        exit_button.setFont(exit_button.getFont().deriveFont(Font.PLAIN, (int) Scaler.scale(exit_button.getFont().getSize())));
        exit_button.setBounds(Scaler.scale(exit_button.getX()), Scaler.scale(exit_button.getY()), Scaler.scale(exit_button.getWidth()), Scaler.scale(exit_button.getHeight()));
        exit_button.setBorder(BorderFactory.createLineBorder(Color.yellow, Scaler.scale(3)));
        exit_button.setOpaque(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        main_panel = new JPanel();
        title = new JLabel();
        play_button = new JButton();
        exit_button = new JButton();

        //======== this ========
        setTitle("Pacman");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setMinimumSize(null);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== main_panel ========
        {
            main_panel.setBackground(new Color(0, 0, 0, 170));
            main_panel.setPreferredSize(null);
            main_panel.setMaximumSize(null);
            main_panel.setMinimumSize(null);
            main_panel.setLayout(null);

            //---- title ----
            title.setText("Pacman");
            title.setFont(new Font(Font.SANS_SERIF, title.getFont().getStyle(), title.getFont().getSize() + 32));
            title.setForeground(Color.yellow);
            title.setMaximumSize(null);
            title.setMinimumSize(null);
            title.setPreferredSize(null);
            title.setHorizontalAlignment(SwingConstants.CENTER);
            main_panel.add(title);
            title.setBounds(0, 55, 400, title.getPreferredSize().height);

            //---- play_button ----
            play_button.setText("PLAY");
            play_button.setBackground(new Color(0, 0, 27));
            play_button.setBorder(new LineBorder(Color.yellow, 2, true));
            play_button.setFont(play_button.getFont().deriveFont(play_button.getFont().getStyle() | Font.BOLD, play_button.getFont().getSize() + 6f));
            play_button.setForeground(new Color(255, 0, 204));
            play_button.setContentAreaFilled(false);
            play_button.setPreferredSize(null);
            play_button.setMaximumSize(null);
            play_button.setMinimumSize(null);
            main_panel.add(play_button);
            play_button.setBounds(100, 160, 205, 45);

            //---- exit_button ----
            exit_button.setText("EXIT");
            exit_button.setBackground(new Color(0, 0, 27));
            exit_button.setForeground(new Color(255, 0, 204));
            exit_button.setFont(exit_button.getFont().deriveFont(exit_button.getFont().getStyle() | Font.BOLD, exit_button.getFont().getSize() + 6f));
            exit_button.setBorder(new LineBorder(Color.yellow, 2, true));
            exit_button.setContentAreaFilled(false);
            exit_button.setPreferredSize(null);
            exit_button.setMaximumSize(null);
            exit_button.setMinimumSize(null);
            main_panel.add(exit_button);
            exit_button.setBounds(100, 220, 205, 45);
        }
        contentPane.add(main_panel);
        main_panel.setBounds(0, 0, 400, 400);

        contentPane.setPreferredSize(new Dimension(400, 425));
        setSize(400, 425);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel main_panel;
    private JLabel title;
    private JButton play_button;
    private JButton exit_button;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
