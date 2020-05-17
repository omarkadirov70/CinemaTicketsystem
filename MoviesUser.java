import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class MoviesUser extends JFrame {

    private JLabel idLabel ;
    private JButton backmenu;
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
