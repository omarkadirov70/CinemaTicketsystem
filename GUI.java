import javax.swing.*;

import java.awt.event.*;
import java.sql.*;
import java.awt.*;

public class GUI extends JFrame {

    
    Connection connection;
    ResultSet resultSet;
    PreparedStatement preparedStatement;
    private JPanel p = new JPanel();
    private JLabel l0 = new JLabel();
    private JLabel title;
    private JLabel note;
    private JLabel ftxt;
    private JLabel removetxt;

    private JTextField text1;
    private JTextField textResult;
    private JButton b1;
    private JButton fb;
    private JButton signupb;
  


    public static void main(String[] args) {
        new GUI();
    }

    public GUI() {
        connection = Connect.ConnectDb(); 

        JFrame f = new JFrame();
        f.setIconImage(new ImageIcon("film.png").getImage());
        f.setSize(553, 829);
        f.setTitle("Register");
        f.setTitle("Secretariat");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p.setLayout(null);

        p.setSize(553, 829);
        f.add(p);

        title = new JLabel("Secretariat Cinema");
        title.setBounds(82, 110, 400, 90);
        title.setFont(new Font("Serif", Font.PLAIN, 50));
        title.setForeground(new Color(255, 255, 255));
       p.add(title);

        note = new JLabel("----------- or -----------");
        note.setBounds(150, 460, 300, 90);
        note.setFont(new Font("Serif", Font.PLAIN, 27));
        note.setForeground(new Color(255, 255, 255));
        p.add(note);

        ftxt = new JLabel("Forgot your details ?");
        ftxt.setBounds(125, 525, 300, 90);
        ftxt.setFont(new Font("Serif", Font.PLAIN, 21));
        ftxt.setForeground(new Color(255, 255, 255));
        p.add(ftxt);

        removetxt = new JLabel("Don't have an account ?");
        removetxt.setBounds(125, 570, 300, 90);
        removetxt.setFont(new Font("Serif", Font.PLAIN, 21));
        removetxt.setForeground(new Color(255, 255, 255));
        p.add(removetxt);

        text1 = new JTextField(" Username");
        text1.setBounds(130, 270, 280, 35);
        text1.setFont(new Font("Serif", Font.PLAIN, 25));
        text1.setForeground(Color.BLACK);
        text1.setBackground(new Color(255, 101, 101));
        p.add(text1);

        b1 = new JButton("Log In");
        b1.setBounds(220, 400, 90, 50);
        b1.setFont(new Font("Serif", Font.PLAIN, 21));
        b1.setForeground(Color.BLACK);
        b1.setBackground(new Color(242,205,123));
        p.add(b1);

        fb = new JButton("Restore");
        fb.setBounds(324, 555, 100, 30);
        fb.setFont(new Font("Serif", Font.PLAIN, 18));
        fb.setForeground(Color.BLACK);
        fb.setBackground(new Color(242,205,123));
        p.add(fb);

        signupb = new JButton("Sign Up");
        signupb.setBounds(335, 600, 100, 30);
        signupb.setFont(new Font("Serif", Font.PLAIN, 18));
        signupb.setForeground(Color.BLACK);
        signupb.setBackground(new Color(242,205,123));
        p.add(signupb);

        textResult = new JTextField(" Password");
        textResult.setBounds(130, 330, 280, 35);
        textResult.setFont(new Font("Serif", Font.PLAIN, 25));
        textResult.setForeground(Color.BLACK);
        textResult.setBackground(new Color(242, 98, 98));
        p.add(textResult);

        l0.setBounds(-6, 0, 550, 826);
        ImageIcon image = new ImageIcon("c2.jpg");
        l0.setIcon(image); p.add(l0);
 
        fb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Forgot();
                dispose();
            }
        });

        signupb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Register();
                dispose();
            }
        });


        text1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                text1.setText("");
            }
        });

        textResult.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                textResult.setText("");
            }
        });

User user = new User();
AdminMenu am = new AdminMenu();
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String query = "select * from sign where Login=? and Password=?";

                    preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, text1.getText());

                    preparedStatement.setString(2, textResult.getText());

                    resultSet = preparedStatement.executeQuery();
                    if (text1.getText().equals("Omar") && textResult.getText().equals("2137824")
                            || text1.getText().equals("Shyryn") && textResult.getText().equals("123456789")) {
                                JOptionPane.showMessageDialog(null, "Admin logged in");
                                am.setVisible(true);
                                
                                f.dispose();
                    
                    } else if (resultSet.next()) {
                        resultSet.close();
                        preparedStatement.close();
                        setVisible(false);
                        JOptionPane.showMessageDialog(null, "You logged in");
                        user.setVisible(true);
                        
                        f.dispose();

                    } else {
                        JOptionPane.showMessageDialog(null, "Incorrect login or password");
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
/////////////////////////////////////////////////////////////////


        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setResizable(false);

    }
}