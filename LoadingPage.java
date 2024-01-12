
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class Loading extends JFrame implements ActionListener {
    JLabel L;
    JButton B;

    Loading() {
        ImageIcon LOGO = new ImageIcon("C:/5th SEM/Java Project/OOPS PROJECT/favicon_io/logo.png");
        B = new JButton();
        this.add(B);

        B.setIcon(LOGO);
        B.addActionListener(this);
        B.setFocusable(false);
        B.setText("WELCOME TO CHANDANSITA'S!");
        B.setHorizontalTextPosition(JButton.CENTER);
        B.setVerticalTextPosition(JButton.BOTTOM);
        B.setFont(new Font("ROMALIKA", Font.BOLD, 60));
        B.setForeground(Color.RED);
        B.setBackground(new Color(0xFAFAFA));
        B.setIconTextGap(100);

        ImageIcon FAVICON = new ImageIcon("C:/5th SEM/Java Project/OOPS PROJECT/favicon_io/icondis.png");
        this.setIconImage(FAVICON.getImage());

        this.getContentPane().setBackground(new Color(0xFAFAFA));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setTitle("ChandanSita's Restaurant...");
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == B) 
        {
            dispose();
            new FoodFrame();
        }
    }
}
public class LoadingPage {

    public static void main(String[] args) {
        new Loading();
    }
    
}
