
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Register extends JFrame {

    private static Connection connection;
    private static PreparedStatement preparedStatement;

    private static final long serialVersionUID = 1L;

    private  String qu[] = { "Choose question", "What is your favorite subject?", "Your favorite singer or band", "Your favorite series", "Favorite country" };

    private JPanel p = new JPanel();

    private JLabel l = new JLabel("User Registration");
    private JLabel l0 = new JLabel();

    private JTextField tf1 = new JTextField(" Login", 30);
    private JTextField tf2 = new JTextField(" Answer", 100);
    private JTextField tf3 = new JTextField(" Password", 30);


    private JButton b1 = new JButton("Sing Up");
    private JButton b2 = new JButton("Back");

    private JComboBox cb = new JComboBox<>(qu);

    public static void main(String[] args) {
       new Register();
    }

    Register() {

  
        connection = Connect.ConnectDb();

        JFrame f = new JFrame();
        f.setIconImage(new ImageIcon("film.png").getImage());
        f.setSize(553, 829);
        f.setTitle("User registration");
       
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        p.setLayout(null);

        l.setBounds(145, 140, 300, 40);
        l.setFont(new Font("Bahnschrift SemiCondensed", Font.BOLD, 30));
        l.setForeground(new Color(255, 255, 255)); p.add(l);

        tf1.setBounds(130, 270, 280, 35);
        tf1.setFont(new Font("Bahnschrift SemiCondensed", Font.BOLD, 21));
        tf1.setForeground(Color.BLACK);
        tf1.setBackground(new Color(255, 101, 101)); p.add(tf1);

        cb.setBounds(130, 316, 280, 35);
        cb.setFont(new Font("Bahnschrift SemiCondensed", Font.BOLD, 20));
        cb.setForeground(Color.BLACK);
        cb.setBackground(new Color(255, 101, 101)); p.add(cb);

        tf2.setBounds(130, 364, 280, 35);
        tf2.setFont(new Font("Bahnschrift SemiCondensed", Font.BOLD, 20));
        tf2.setForeground(Color.BLACK);
        tf2.setBackground(new Color(255, 101, 101)); p.add(tf2);

        tf3.setBounds(130, 412, 280, 35);
        tf3.setFont(new Font("Bahnschrift SemiCondensed", Font.BOLD, 20));
        tf3.setForeground(Color.BLACK);
        tf3.setBackground(new Color(255, 101, 101)); p.add(tf3);

        b1.setBounds(218, 495, 100, 40);
        b1.setFont(new Font("Bahnschrift SemiCondensed", Font.BOLD, 17));
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

        tf3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                tf3.setText("");
            }
        });


        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    String query = "INSERT INTO `sign` (Login, Password, Question, Answer) values (?,?,?,?)";

                    preparedStatement = connection.prepareStatement(query);

                    preparedStatement.setString(1,tf1.getText());
                    preparedStatement.setString(2,tf3.getText());
                    preparedStatement.setString(3, (String) cb.getSelectedItem());
                    preparedStatement.setString(4,tf2.getText());

                    preparedStatement.execute();

                    JOptionPane.showMessageDialog(null, "New acoount created");

                }catch (Exception ex){
                    ex.printStackTrace();
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