import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
import java.sql.*;

import net.proteanit.sql.DbUtils;
public class AdminUser {

    public static void main(String[] args) {
        new AdminUser();
    }

    private final JTable table = new JTable();

    Connection connection2 = null;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    public AdminUser(){
        connection2 = Connect.ConnectDb();
        JFrame f = new JFrame(); 
        f.setSize(700, 500);
        f.setTitle("List of Users");
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setIconImage(new ImageIcon("film.png").getImage());

        JPanel panel2 = new JPanel();
panel2.setBackground(new Color(13,18,135));
        JButton button = new JButton("Show");

		button.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent a) {
				try {
					String query="select * from sign";
					preparedStatement = connection2.prepareStatement(query);
					resultSet = preparedStatement.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(resultSet));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
        });
        
        JButton backb = new JButton("Back");
        backb.setBounds(50, 200, 100, 30);
        backb.setForeground(Color.WHITE);
        backb.setBackground(new Color(39, 48, 57));
        panel2.add(backb);


AdminMenu adm = new AdminMenu();

		backb.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent a) {
                adm.setVisible(true);
                        
                f.dispose();
			}
        });

		panel2.add(button);
		JScrollPane scrollPane = new JScrollPane();
		panel2.add(scrollPane);
        scrollPane.setViewportView(table);

        f.add(panel2);
        f.validate();
        f.setVisible(true);
    }
}