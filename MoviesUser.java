import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class MoviesUser extends JFrame {

   
    private JButton backmenu,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19;
    private JTextField idField,nameField, durField, priceField, countField;
    private String[] rating={"Rating","G", "PG", "PG-13", "R", "NC-17"};
    private Object[] columns={"Id", "Name", "Duration","Rating","Price", "Count"};
    private JComboBox ratingBox;
    private JTable table;
    private DefaultTableModel tableModel;
    private JScrollPane pane;
    private ArrayList<Movies> movies;
    public ClientSocket clientSocket;


    public MoviesUser() {
        setLayout(new FlowLayout());
        setSize(1100,700);
        setTitle("CHOOSE MOVIE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        clientSocket=new ClientSocket();

        table=new JTable();
        tableModel=new DefaultTableModel();
        tableModel.setColumnIdentifiers(columns);;
        table.setModel(tableModel);
        table.setBackground(new Color(81,52,223));
        table.setForeground(new Color(255,255,255));
        table.setFont(new Font("Arial", 1, 16));
        table.setRowHeight(30);
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = table.getSelectedRow();
                idField.setText(tableModel.getValueAt(i, 0).toString());
                nameField.setText(tableModel.getValueAt(i, 1).toString());
                durField.setText(tableModel.getValueAt(i, 2).toString());
                ratingBox.setSelectedItem(tableModel.getValueAt(i, 3).toString());
                priceField.setText(tableModel.getValueAt(i, 4).toString());
                countField.setText(tableModel.getValueAt(i, 5).toString());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        pane=new JScrollPane(table);
        pane.setBounds(260,0, 800, 600);
        pane.setBackground(new Color(0x9FC5D5));
        pane.setForeground(new Color(0x7F2E4D));
        add(pane);


     
        backmenu=new JButton("Back");
        backmenu.setBounds(40, 300, 100, 40);
        backmenu.setFont(new Font("Serif", Font.PLAIN, 20));
        backmenu.setForeground(Color.WHITE);
        backmenu.setBackground(new Color(39, 48, 57));
        add(backmenu);
        User user = new User();
        backmenu.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent a) {
                user.setVisible(true);
                        
               dispose();
			}
        });

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
        b1=new JButton("ADD");
        b1.setBounds(180, 23, 60, 25);
        b1.setFont(new Font("Serif", Font.PLAIN, 10));
        b1.setForeground(Color.BLACK);
        b1.setBackground(new Color(249, 231, 73));
        add( b1);

        b2=new JButton("ADD");
        b2.setBounds(180,52, 60, 25);
        b2.setFont(new Font("Serif", Font.PLAIN, 10));
        b2.setForeground(Color.BLACK);
        b2.setBackground(new Color(249, 231, 73));
        add(b2);

        b3=new JButton("ADD");
        b3.setBounds(180, 81, 60, 25);
        b3.setFont(new Font("Serif", Font.PLAIN, 10));
        b3.setForeground(Color.BLACK);
        b3.setBackground(new Color(249, 231, 73));
        add(b3);

        b4=new JButton("ADD");
        b4.setBounds(180, 114, 60, 25);
        b4.setFont(new Font("Serif", Font.PLAIN, 10));
        b4.setForeground(Color.BLACK);
        b4.setBackground(new Color(249, 231, 73));
        add(b4);

        b5=new JButton("ADD");
        b5.setBounds(180, 145, 60, 25);
        b5.setFont(new Font("Serif", Font.PLAIN, 10));
        b5.setForeground(Color.BLACK);
        b5.setBackground(new Color(249, 231, 73));
        add(b5);

        b6=new JButton("ADD");
        b6.setBounds(180, 175, 60, 25);
        b6.setFont(new Font("Serif", Font.PLAIN, 10));
        b6.setForeground(Color.BLACK);
        b6.setBackground(new Color(249, 231, 73));
        add(b6);

        b7=new JButton("ADD");
        b7.setBounds(180, 204, 60, 25);
        b7.setFont(new Font("Serif", Font.PLAIN, 10));
        b7.setForeground(Color.BLACK);
        b7.setBackground(new Color(249, 231, 73));
        add(b7);

        b8=new JButton("ADD");
        b8.setBounds(180, 234, 60, 25);
        b8.setFont(new Font("Serif", Font.PLAIN, 10));
        b8.setForeground(Color.BLACK);
        b8.setBackground(new Color(249, 231, 73));
        add(b8);

       b9=new JButton("ADD");
       b9.setBounds(180, 264, 60, 25);
       b9.setFont(new Font("Serif", Font.PLAIN, 10));
       b9.setForeground(Color.BLACK);
       b9.setBackground(new Color(249, 231, 73));
        add(b9);

        b10=new JButton("ADD");
        b10.setBounds(180, 297, 60, 25);
        b10.setFont(new Font("Serif", Font.PLAIN, 10));
        b10.setForeground(Color.BLACK);
        b10.setBackground(new Color(249, 231, 73));
        add(b10);

        b11=new JButton("ADD");
        b11.setBounds(180, 326, 60, 25);
        b11.setFont(new Font("Serif", Font.PLAIN, 10));
        b11.setForeground(Color.BLACK);
        b11.setBackground(new Color(249, 231, 73));
        add( b11);

        b12=new JButton("ADD");
        b12.setBounds(180, 353, 60, 25);
        b12.setFont(new Font("Serif", Font.PLAIN, 10));
        b12.setForeground(Color.BLACK);
        b12.setBackground(new Color(249, 231, 73));
        add(b12);

        b13=new JButton("ADD");
        b13.setBounds(180, 383, 60, 25);
        b13.setFont(new Font("Serif", Font.PLAIN, 10));
        b13.setForeground(Color.BLACK);
        b13.setBackground(new Color(249, 231, 73));
        add(b13);

        b14=new JButton("ADD");
        b14.setBounds(180, 416, 60, 25);
        b14.setFont(new Font("Serif", Font.PLAIN, 10));
        b14.setForeground(Color.BLACK);
        b14.setBackground(new Color(249, 231, 73));
        add( b14);

        b15=new JButton("ADD");
        b15.setBounds(180, 445, 60, 25);
        b15.setFont(new Font("Serif", Font.PLAIN, 10));
        b15.setForeground(Color.BLACK);
        b15.setBackground(new Color(249, 231, 73));
        add(b15);

        b16=new JButton("ADD");
        b16.setBounds(180, 474, 60, 25);
        b16.setFont(new Font("Serif", Font.PLAIN, 10));
        b16.setForeground(Color.BLACK);
        b16.setBackground(new Color(249, 231, 73));
        add(b16);

        b17=new JButton("ADD");
        b17.setBounds(180, 503, 60, 25);
        b17.setFont(new Font("Serif", Font.PLAIN, 10));
        b17.setForeground(Color.BLACK);
        b17.setBackground(new Color(249, 231, 73));
        add(b17);

        b18=new JButton("ADD");
        b18.setBounds(180, 532, 60, 25);
        b18.setFont(new Font("Serif", Font.PLAIN, 10));
        b18.setForeground(Color.BLACK);
        b18.setBackground(new Color(249, 231, 73));
        add( b18);

        b19=new JButton("ADD");
        b19.setBounds(180, 561, 60, 25);
        b19.setFont(new Font("Serif", Font.PLAIN, 10));
        b19.setForeground(Color.BLACK);
        b19.setBackground(new Color(249, 231, 73));
        add( b19);



        b1.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent a) {
                new booking();
                        
               dispose();
			}
        });

        b2.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent a) {
                new booking();
                        
               dispose();
			}
        });

        b3.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent a) {
                new booking();
                        
               dispose();
			}
        });

        b4.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent a) {
                new booking();
                        
               dispose();
			}
        });

        
        b5.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent a) {
                new booking();
                        
               dispose();
			}
        });

        b6.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent a) {
                new booking();
                        
               dispose();
			}
        });

        b7.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent a) {
                new booking();
                        
               dispose();
			}
        });

        b8.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent a) {
                new booking();
                        
               dispose();
			}
        });

        b9.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent a) {
                new booking();
                        
               dispose();
			}
        });

        b10.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent a) {
                new booking();
                        
               dispose();
			}
        });

        b11.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent a) {
                new booking();
                        
               dispose();
			}
        });

        b12.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent a) {
                new booking();
                        
               dispose();
			}
        });

        b13.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent a) {
                new booking();
                        
               dispose();
			}
        });

        b14.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent a) {
                new booking();
                        
               dispose();
			}
        });

        b15.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent a) {
                new booking();
                        
               dispose();
			}
        });

        b16.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent a) {
                new booking();
                        
               dispose();
			}
        });

        b17.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent a) {
                new booking();
                        
               dispose();
			}
        });

        b18.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent a) {
                new booking();
                        
               dispose();
			}
        });

        b19.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent a) {
                new booking();
                        
               dispose();
			}
        });

  


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    }
    public void updateMovies(){
        movies=clientSocket.getAllMovies();
        Object[] row=new Object[6];
        for(Movies d:movies){
            row[0]=d.getId();
            row[1]=d.getName();
            row[2]=d.getDuration();
            row[3]=d.getRating();
            row[4]=d.getPrice();
            row[5]=d.getCount();
            tableModel.addRow(row);
        }
    }
    public void clearMovies(){
        DefaultTableModel dm = (DefaultTableModel)table.getModel();
        while(dm.getRowCount() > 0)
        {
            dm.removeRow(0);
        }
    }
}
