package kata6.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kata6.model.Mail;
import kata6.model.Person;

public class MailListReader {
        
    public static List<Mail> read(String fileName) throws FileNotFoundException, IOException {        
        List <Mail>mailList = new ArrayList<>();
        Integer id=0;
        BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
        String mail;
        while((mail = reader.readLine()) != null){
            mailList.add(new Mail(mail, id));
        }
        return mailList;    
    }
}
