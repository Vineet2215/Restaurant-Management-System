
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


class Lgf extends JFrame implements ActionListener {

    JLabel userLabel = new JLabel("USERNAME:");
    JLabel welcome = new JLabel("WELCOME TO CHANDANSITA'S");
    JLabel intro = new JLabel("Please provide us with your details!");
    JTextField userTextField = new JTextField();
    JButton loginButton = new JButton();
    String name = "";
    boolean isNewUser;
    static String userName;

    // Define your MySQL database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/java_project";  // database name
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Vineet0707"; // db pswd

    Lgf() {
        initializeFrame();
        setLocationAndSize();
        addComponents();
        addActionEvent();
        customizeUI();
    }

    private void initializeFrame() {
        // Your frame initialization code remains the same

        // ...
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setVisible(true);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setTitle("ChandanSita's Login Portal");
        ImageIcon FAVICON = new ImageIcon("C:/5th SEM/Java Project/OOPS PROJECT/favicon_io/icondis.png");
        this.setIconImage(FAVICON.getImage());
        this.getContentPane().setBackground(new Color(0xFFAAAA));

    }

    private void setLocationAndSize() {
        // Your UI component location and size settings remain the same
        

        welcome.setBounds(250, 70, 1200, 80);
        welcome.setFont(new Font("ROMALIKA", Font.BOLD, 100));

        userLabel.setBounds(520, 225, 300, 50);
        userLabel.setFont(new Font("ROMALIKA", Font.ITALIC, 60));
        userTextField.setBounds(820, 225, 300, 50);

        loginButton.setBounds(400, 325, 850, 450);
        loginButton.setFocusable(false);

    }

    private void addComponents() {
       

        this.add(userLabel);
        this.add(welcome);
        this.add(userTextField);
        this.add(loginButton);
        this.add(intro);

    }

    private void addActionEvent() {
        loginButton.addActionListener(this);
    }

    private void customizeUI() {
        

        ImageIcon lg = new ImageIcon("C:/5th SEM/Java Project/OOPS PROJECT/Food Icons/n1.png");
        loginButton.setIcon(lg);
        loginButton.setBorder(BorderFactory.createLineBorder(Color.black, 10, true));

    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == loginButton) 
        {
            name = userTextField.getText();
            userName = name;

            if (name.isEmpty()) 
            {
                JOptionPane.showMessageDialog(this, "The name seems to be empty!", "Invalid Name Input",
                        JOptionPane.ERROR_MESSAGE);
            } 

            else 
            {
                // Create a connection to the MySQL database
                try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) 
                {
                    // Check if the user exists in the database
                    String checkQuery = "SELECT * FROM users WHERE username = ?";

                    try (PreparedStatement preparedStatement = connection.prepareStatement(checkQuery)) 
                    {
                        preparedStatement.setString(1, name);
                        try (ResultSet resultSet = preparedStatement.executeQuery()) 
                        {
                            if (resultSet.next()) 
                            {
                                JOptionPane.showMessageDialog(this,
                                        "The user " + name + " is already registered in our Database, Welcome!",
                                        "User Found!", JOptionPane.INFORMATION_MESSAGE);
                                isNewUser = false;
                            } 

                            else 
                            {
                                // Insert the new user into the database
                                String insertQuery = "INSERT INTO users (username) VALUES (?)";
                                try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) 
                                {
                                    insertStatement.setString(1, name);
                                    insertStatement.executeUpdate();
                                }

                                JOptionPane.showMessageDialog(this, "The user " + name + " is a new Customer, Welcome!",
                                        "Creating Entry...", JOptionPane.PLAIN_MESSAGE);
                                isNewUser = true;
                            }
                        }
                    }
                } 
                catch (SQLException exc) 
                {
                    exc.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error connecting to the database: " + exc.getMessage(),
                            "Database Error",
                            JOptionPane.ERROR_MESSAGE);
                }

                dispose();
                new Loading();
            }
        }
    }
}

public class LoginFinal {
    public static void main(String[] args) {
        new Lgf();
    }
}
