

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Settings extends JFrame implements ActionListener{
    Container c = getContentPane();
    private JButton btnLogin ,btnCancel,btnReset;
    private JLabel Setting;
    private JTextField txtData;
    public static String s;
    public Settings() {
        super("Setting Database path...");
        this.setSize(550, 200);
        this.setLayout(null);
        this.setResizable(true);
        this.setLocation((Settings.getScreenSize().width / 2) - 175, (Settings.getScreenSize().height / 2) - 150);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Setting = new JLabel("Database Location");
        txtData = new JTextField();
        btnLogin = new JButton("Set Path");
        btnCancel=new JButton("Cancel");
        btnReset=new JButton("Reset");
        Setting.setBounds(50, 40, 140, 25);
        txtData.setBounds(180, 40, 250, 25);
        btnLogin.setBounds(50, 120, 100, 25);
        btnCancel.setBounds(350, 120, 100, 25);
        btnReset.setBounds(200, 120, 100, 25);
        btnLogin.addActionListener(this);
        btnCancel.addActionListener(this);
        btnReset.addActionListener(this);
        this.add(Setting);
        this.add(btnLogin);
        this.add(txtData);
        this.add(btnCancel);
        this.add(btnReset);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
          s ="jdbc:ucanaccess://"+txtData.getText()+"\\student.accdb"; 
          txtData.setText("");
          
          new Login().setVisible(true);
          
        }
        if (e.getSource() == btnReset) {
           txtData.setText("");
        }
        if (e.getSource() == btnCancel) {
           System.exit(0);
        }
    }
    public static Dimension getScreenSize(){
        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        return d;   
    }//getScreenSize() closed
    
    public static Connection getDBConnection(){
        Connection con;
        try{
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            //con=DriverManager.getConnection("jdbc:odbc:student");
            con=DriverManager.getConnection(s);
            // con=DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Abhishek\\Documents\\NetBeansProjects\\SchoolManagementSystem\\student.accdb");
            return con;
        }catch(Exception ex){
            return null;
        }
    }
    
}//class closed
