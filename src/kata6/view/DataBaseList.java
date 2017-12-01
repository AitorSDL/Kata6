package kata6.view;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import kata6.model.Mail;
import kata6.model.Person;
import org.sqlite.SQLite;

public class DataBaseList {
    public static List<Person> read() throws SQLException, ClassNotFoundException{
        List<Person> listPerson = null;
        Class.forName ("org.sqlite.JDBC");
        Connection connec = DriverManager.getConnection("jdbc:sqlite:KATA.sdB");        
        Statement st = connec.createStatement();
        String query = "SELECT * FROM PEOPLE;";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()){
            Integer id = rs.getInt(1);
            String name = rs.getString(2);
            Character gender = rs.getString(3).charAt(0);
            String birthdate = rs.getString(4);
            Float weight = rs.getFloat(5);
            String mail = rs.getString(6);
            listPerson.add(new Person(id,name,gender,birthdate,weight,mail));
        }
        return listPerson;
    }       
}
