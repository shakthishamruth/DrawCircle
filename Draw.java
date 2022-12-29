import java.awt.*;
import javax.swing.*;

class OvalPanel extends JPanel {
    private int diameter = 0;

    // Draw an oval of the specified diameter
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)));
        g.fillOval(50, 75, diameter, diameter);
    }

    // validate and set diameter, then repaint
    public void setDiameter(int newDiameter) {
        // if diameter invalid, default to 10
        diameter = (newDiameter >= 5 ? newDiameter : 6);
        repaint();
    }

    public Dimension getPreferredSize() {

        return new Dimension(200, 200);
    }

    // used by layout manager to determine minimum size
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }
}

public class Draw extends JFrame {
    private JLabel label;
    private OvalPanel mypanel;


    Draw() {
        super("Circle");
        mypanel = new OvalPanel();
        Container can = getContentPane();
        can.setLayout(new FlowLayout());
        // Label
        label = new JLabel("0");
        label.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 14));
        can.add(label);
        // button
        JButton button = new JButton("Click");
        can.add(button);
        button.addActionListener(e -> {
            int i = Integer.parseInt(label.getText());
            i += 1;
            label.setText(String.valueOf(i));
            mypanel.setDiameter(i);
        });
        can.add(mypanel);
        setVisible(true);
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Draw();
    }

}
