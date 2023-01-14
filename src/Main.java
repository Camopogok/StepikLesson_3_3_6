import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

public class Main extends JComponent implements KeyListener, WindowListener, ActionListener {
    Timer t = new Timer(10,this);
    String pressed = "";
    String log = "";

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Main main = new Main();
        frame.add(main);
        frame.setSize(200,200);
        frame.setLocation(400,200);
        frame.setDefaultCloseOperation(frame.DO_NOTHING_ON_CLOSE);
        frame.addKeyListener(main);
        frame.addWindowListener(main);
        frame.setVisible(true);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(new Font ("Calibri", Font.BOLD,20));
        g2d.setColor(Color.blue);
        g2d.drawString(pressed, 80,90);
        t.start();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        pressed = KeyEvent.getKeyText(keyEvent.getKeyCode());
        log += pressed + " ";
    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        try {
            FileWriter fw = new FileWriter("src/log.txt");
            fw.write(log);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.exit(0);
    }











    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void windowOpened(WindowEvent windowEvent) {

    }


    @Override
    public void windowClosed(WindowEvent windowEvent) {

    }

    @Override
    public void windowIconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowDeiconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowActivated(WindowEvent windowEvent) {

    }

    @Override
    public void windowDeactivated(WindowEvent windowEvent) {

    }
}
