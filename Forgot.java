import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;



public class Forgot extends JFrame {

    private static final long serialVersionUID = -7025433544363129040L;

    private static Connection connection;

    private static ResultSet resultSet;

    private static PreparedStatement preparedStatement;

    private String qu[] = { "Choose question", "What is your favorite subject?", "Your favorite singer or band", "Your favorite series", "Favorite country" };

    private JPanel p = new JPanel();

    private JLabel l = new JLabel("Password Recovery");
    private JLabel l0 = new JLabel();

    private JTextField tf1 = new JTextField(" Login");
    private JTextField tf2 = new JTextField(" Answer", 30);
    private JTextField tf3 = new JTextField();

    private JButton b1 = new JButton("Show Password");
    private JButton b2 = new JButton("Back");

    private JComboBox cb = new JComboBox<>(qu);

    public static void main(String[] args) {
        new Forgot();
    }

    Forgot() {
       

        connection = Connect.ConnectDb();

        
        JFrame f = new JFrame();
        f.setIconImage(new ImageIcon("film.png").getImage());
        f.setSize(553, 829);
        f.setTitle("Password Recovery");
    
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        p.setLayout(null);

        l.setBounds(125, 140, 300, 40);
        l.setFont(new Font("Bahnschrift SemiCondensed", Font.BOLD, 30));
        l.setForeground(new Color(255, 255, 255)); p.add(l);

        tf1.setBounds(130, 270, 280, 35);
        tf1.setFont(new Font("Bahnschrift SemiCondensed", Font.BOLD, 21));
        tf1.setForeground(Color.BLACK);
        tf1.setBackground(new Color(255, 101, 101)); p.add(tf1);

        cb.setBounds(130, 364, 280, 35);
        cb.setFont(new Font("Bahnschrift SemiCondensed", Font.BOLD, 20));
        cb.setForeground(Color.BLACK);
        cb.setBackground(new Color(255, 101, 101)); p.add(cb);

        tf2.setBounds(130, 412, 280, 35);
        tf2.setFont(new Font("Bahnschrift SemiCondensed", Font.BOLD, 21));
        tf2.setForeground(Color.BLACK);
        tf2.setBackground(new Color(255, 101, 101)); p.add(tf2);

        tf3.setBounds(130, 316, 280, 35);
        tf3.setFont(new Font("Bahnschrift SemiCondensed", Font.BOLD, 20));
        tf3.setForeground(Color.BLACK);
        tf3.setBackground(new Color(255, 101, 101)); p.add(tf3);

        b1.setBounds(165, 495, 210, 40);
        b1.setFont(new Font("Bahnschrift SemiCondensed", Font.BOLD, 20));
        b1.setForeground(Color.BLACK);
        b1.setBackground(new Color(242,205,123)); p.add(b1);

        b2.setBounds(218, 545, 100, 40);
        b2.setFont(new Font("Bahnschrift SemiCondensed", Font.BOLD, 20));
        b2.setForeground(Color.BLACK);
        b2.setBackground(new Color(242,205,123)); p.add(b2);
        
        l0.setBounds(-6, 0, 550, 826);
        ImageIcon image = new ImageIcon("c2.jpg");
        l0.setIcon(image); p.add(l0);

        tf1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                tf1.setText("");
            }
        });

        tf2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                tf2.setText("");
            }
        });

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String login = tf1.getText();
        
                    String query = "SELECT * FROM sign where Login ='" + login + "'" ;
        
                    Statement statement = connection.createStatement();
        
                     resultSet = statement.executeQuery(query);
        
                    if (resultSet.next()){
                        JOptionPane.showMessageDialog(null,"It is login true");
        
                        String pass = resultSet.getString("Password");
        
                        System.out.println(pass);
        
                       tf3.setText(pass);
        
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Incorerct login");
                    }
                    String a = tf2.getText();
                    String query2 = "SELECT * FROM users where Answer = '" + a + "'";

                    preparedStatement = connection.prepareStatement(query2);
                    preparedStatement.executeQuery();

                    Statement statement2 = connection.createStatement();
                    resultSet = statement2.executeQuery(query2);

                    if (resultSet.next()){
                        String ans = resultSet.getString("Answer");
                        String pas = resultSet.getString("Password");
                        if (a.equalsIgnoreCase(ans)){
                            JOptionPane.showMessageDialog(null, "Answer is Correct");
                            tf3.setText(pas);
                        }else {
                            JOptionPane.showMessageDialog(null,"Incorrect answer");
                        }
                    }
                } catch (SQLException es) {
                    es.printStackTrace();
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GUI();
                f.dispose();
            }
        });

        f.add(p);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
    }
}