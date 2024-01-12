// import java.io.*;
// import javax.swing.*;
// class hello
// {
//     static JLabel J[] = new JLabel[50];
//     static int i=0;
//     static void billed(String fname) throws IOException
//     {
//         BufferedReader br = new BufferedReader(new FileReader(fname));
//         String str = "";
//         String s="hello";

//         while (s!=null)
//         {
//             s=br.readLine();
//             str+="\n";
//             str+=s;
//             J[i] = new JLabel(s);
//             J[i].setHorizontalTextPosition(JLabel.CENTER);
//             i++;
//         }

//         System.out.println(str);
//         br.close();
//         new frame();
//     }
// }

import java.io.*;
import javax.swing.*;

class hello {
    static JLabel J[] = new JLabel[50];
    static int i = 0;

    static void billed(String fname) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fname));
        String str = "";
        String s = "hello";

        while (s != null) {
            s = br.readLine();
            str += "\n";
            str += s;
            J[i] = new JLabel(s);
            J[i].setHorizontalTextPosition(JLabel.CENTER);
            i++;
        }

        System.out.println(str);
        br.close();
        new frame();
    }
}

class frame extends JFrame {
    static JLabel JN[] = hello.J;

    frame() {
        this.setVisible(true);
        for (int k = 0; k < hello.i; k++) {
            JN[k].setBounds(0, 100 + k * 15, 1700, 15);
            JN[k].setHorizontalAlignment(JLabel.CENTER);
            this.add(JN[k]);
        }
        this.setExtendedState(MAXIMIZED_BOTH);
    }
}

// import javax.swing.*;
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;

// class Hello {
// static JLabel J[] = new JLabel[50];
// static int i = 0;

// static void billed(String username) {
// // Define your MySQL database connection details
// String DB_URL = "jdbc:mysql://localhost:3306/java_project";
// String DB_USER = "root";
// String DB_PASSWORD = "Vineet0707";

// // SQL query to retrieve data from the database
// String sqlQuery = "SELECT username FROM users";

// try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER,
// DB_PASSWORD);
// PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
// ResultSet resultSet = preparedStatement.executeQuery()) {

// while (resultSet.next()) {
// String data = resultSet.getString("username"); // Replace with the actual
// column name
// J[i] = new JLabel(data);
// J[i].setHorizontalTextPosition(JLabel.CENTER);
// i++;
// }

// new Frame();
// } catch (SQLException e) {
// e.printStackTrace();
// JOptionPane.showMessageDialog(null, "Error accessing the database: " +
// e.getMessage(), "Database Error",
// JOptionPane.ERROR_MESSAGE);
// }
// }
// }

// class Frame extends JFrame {
// static JLabel JN[] = Hello.J;

// Frame() {
// this.setVisible(true);
// for (int k = 0; k < Hello.i; k++) {
// JN[k].setBounds(0, 100 + k * 15, 1700, 15);
// JN[k].setHorizontalAlignment(JLabel.CENTER);
// this.add(JN[k]);
// }
// this.setExtendedState(MAXIMIZED_BOTH);
// }
// }

