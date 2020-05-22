
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class AdminPage extends JFrame {

    private JLabel idLabel, nameLabel, durLabel, ratingLabel,  priceLabel, countLabel;
    private JButton addButton, deleteButton ,backmenu;
    private JTextField idField,nameField, durField, priceField, countField;
    private String[] rating={"Rating","G", "PG", "PG-13", "R", "NC-17"};
    private Object[] columns={"Id", "Name", "Duration","Rating","Price", "Count"};
    private JComboBox ratingBox;
    private JTable table;
    private DefaultTableModel tableModel;
    private JScrollPane pane;
    private ArrayList<Movies> movies;
    public ClientSocket clientSocket;


    public AdminPage() {
        setLayout(new FlowLayout());
        setSize(1100,700);
        setTitle("ADD MOVIE INFO");
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
        pane.setBounds(250,0, 800, 600);
        pane.setBackground(new Color(46,10,225));
        pane.setForeground(new Color(255,255,255));
        add(pane);

        idLabel=new JLabel("ID");
        idLabel.setBounds(50, 40, 80, 25);
        idLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        idLabel.setForeground(Color.GRAY);


        add(idLabel);
        idField=new JTextField();
        idField.setBounds(110, 40, 120, 25);
        add(idField);

        ratingLabel=new JLabel("Rating: ");
        ratingLabel.setBounds(50, 80, 80, 25);
        ratingLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        ratingLabel.setForeground(Color.GRAY);
        add( ratingLabel);
        ratingBox=new JComboBox(rating);
        ratingBox.setBounds(110, 80, 120, 25);
        ratingBox.setBackground(new Color(0xFDF8FF));
        ratingBox.setForeground(new Color(0x000000));
        add(ratingBox);


        nameLabel=new JLabel("Name: ");
        nameLabel.setBounds(50, 160, 80, 25);
        nameLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        nameLabel.setForeground(Color.GRAY);
        add(nameLabel);
        nameField=new JTextField();
        nameField.setBounds(110, 160, 120, 25);
        add(nameField);


        priceLabel=new JLabel("Price:");
        priceLabel.setBounds(50, 200, 80, 25);
        priceLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        priceLabel.setForeground(Color.GRAY);
        add(priceLabel);
        priceField=new JTextField();
        priceField.setBounds(110, 200, 120, 25);
        add(priceField);

        durLabel=new JLabel("Duration:");
        durLabel.setBounds(50, 240, 80, 25);
        durLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        durLabel.setForeground(Color.GRAY);
        add(durLabel);
        durField=new JTextField();
        durField.setBounds(110, 240, 120, 25);
        add(durField);

        countLabel=new JLabel("Count:");
        countLabel.setBounds(50, 280, 80, 25);
        countLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        countLabel.setForeground(Color.GRAY);
        add(countLabel);
        countField=new JTextField();
        countField.setBounds(110, 280, 120, 25);
        add(countField);

        addButton=new JButton("ADD");
        addButton.setBounds(90, 400, 150, 30);
        addButton.setFont(new Font("Serif", Font.PLAIN, 20));
        addButton.setForeground(Color.BLACK);
        addButton.setBackground(new Color(242,205,123));
        add(addButton);
        

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name=nameField.getText();
                String duration=durField.getText();
                int price=Integer.parseInt(priceField.getText());
                int count=Integer.parseInt(countField.getText());
                String rating=ratingBox.getSelectedItem().toString();
                if(name.isEmpty() || duration.isEmpty() ){
                    JOptionPane.showMessageDialog(null, "Please fill all fields!");
                }
                else{
                    Movies movies= new Movies(null, name, duration,rating, price, count);
                    clientSocket.addMovie(movies);
                    idField.setText("");
                    nameField.setText("");
                    durField.setText("");
                    ratingBox.setSelectedItem(0);
                    priceField.setText("");
                    countField.setText("");
                    JOptionPane.showMessageDialog(null, "Your movies added successfully");
                    clearMovies();
                    updateMovies();

                }
            }
        });

        backmenu=new JButton("Back");
        backmenu.setBounds(90, 540, 150, 30);
        backmenu.setFont(new Font("Serif", Font.PLAIN, 20));
        backmenu.setForeground(Color.BLACK);
        backmenu.setBackground(new Color(242,205,123));
        add(backmenu);
        AdminMenu adm = new AdminMenu();
        backmenu.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent a) {
                adm.setVisible(true);
                        
               dispose();
			}
        });

    
        deleteButton=new JButton("DELETE");
        deleteButton.setBounds(90, 470, 150, 30);
        deleteButton.setFont(new Font("Serif", Font.PLAIN, 20));
        deleteButton.setForeground(Color.BLACK);
        deleteButton.setBackground(new Color(242,205,123));
        add(deleteButton);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            Long id=Long.valueOf(idField.getText());
            Movies movies=new Movies(id, null, null, null, 0, 0);
            clientSocket.deleteMovies(movies);
            clearMovies();
            updateMovies();
            }
            });

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
