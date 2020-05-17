
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
    private JButton addButton, deleteButton,refreshButton ,backmenu;
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
        setSize(900,600);
        setTitle("Shop Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        clientSocket=new ClientSocket();

        table=new JTable();
        tableModel=new DefaultTableModel();
        tableModel.setColumnIdentifiers(columns);;
        table.setModel(tableModel);
        table.setBackground(new Color(134,22,22));
        table.setForeground(new Color(5,33,146));
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
        pane.setBounds(0,0, 450, 600);
        pane.setBackground(new Color(0x9FC5D5));
        pane.setForeground(new Color(0x7F2E4D));
        add(pane);

        idLabel=new JLabel("ID");
        idLabel.setBounds(470, 40, 80, 25);
        idLabel.setForeground(Color.white);
        add(idLabel);
        idField=new JTextField();
        idField.setBounds(530, 40, 120, 25);
        add(idField);

        ratingLabel=new JLabel("Rating: ");
        ratingLabel.setBounds(470, 80, 80, 25);
        ratingLabel.setForeground(Color.white);
        add( ratingLabel);
        ratingBox=new JComboBox(rating);
        ratingBox.setBounds(530, 80, 120, 25);
        ratingBox.setBackground(new Color(0xFDF8FF));
        ratingBox.setForeground(new Color(0x000000));
        add(ratingBox);


        nameLabel=new JLabel("Name: ");
        nameLabel.setBounds(470, 160, 80, 25);
        nameLabel.setForeground(Color.white);
        add(nameLabel);
        nameField=new JTextField();
        nameField.setBounds(530, 160, 120, 25);
        add(nameField);


        priceLabel=new JLabel("Price:");
        priceLabel.setBounds(470, 200, 80, 25);
        priceLabel.setForeground(Color.white);
        add(priceLabel);
        priceField=new JTextField();
        priceField.setBounds(530, 200, 120, 25);
        add(priceField);

        durLabel=new JLabel("Duration:");
        durLabel.setBounds(470, 240, 80, 25);
        durLabel.setForeground(Color.white);
        add(durLabel);
        durField=new JTextField();
        durField.setBounds(530, 240, 120, 25);
        add(durField);

        countLabel=new JLabel("Count:");
        countLabel.setBounds(470, 280, 80, 25);
        countLabel.setForeground(Color.white);
        add(countLabel);
        countField=new JTextField();
        countField.setBounds(530, 280, 120, 25);
        add(countField);

        addButton=new JButton("ADD");
        addButton.setBounds(680, 30, 150, 30);
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
        backmenu.setBounds(680, 300, 150, 30);
        add(backmenu);
        AdminMenu adm = new AdminMenu();
        backmenu.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent a) {
                adm.setVisible(true);
                        
               dispose();
			}
        });

        refreshButton=new JButton("REFRESH");
        refreshButton.setBounds(680, 210, 150, 30);
        add(refreshButton);

        deleteButton=new JButton("DELETE");
        deleteButton.setBounds(680, 150, 150, 30);
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
