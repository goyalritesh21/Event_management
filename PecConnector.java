package Project;

/**
 *
 * @author ritesh
 */
import java.sql.*;
import javax.swing.JOptionPane;
public class PecConnector{
    Connection conn = null;
    public static Connection ConnectorDb(){
        try{
            //Class.forName("org.sqlite.JDBC"); // for sqlite
             //Connection conn = DriverManager.getConnection("jdbc:sqlite://media//ritesh//Windows//Users//RITESH GOYAL//Documents//NetBeansProjects//Step_tutorials//db1.sqlite");//for sqlite
            Class.forName("com.mysql.jdbc.Driver");  //for mysql
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pec","root","Goyal1998");  //for mysql
            //JOptionPane.showMessageDialog(null, "connection Established");
            return conn;
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        return null;}
    }
}