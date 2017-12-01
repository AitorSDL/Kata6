package kata6.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import kata6.model.Histogram;
import kata6.model.Mail;
import kata6.view.HistogramDisplay;
import kata6.view.HistogramBuilder;
import kata6.view.MailListReader;

public class Kata6 {
    private static List<Mail>  mailList;
    private static Histogram<String> histogram;
    private static Histogram letters;
    
    public static void main(String[] args) throws FileNotFoundException, IOException {  
        execute();
    }
    private static void execute() throws FileNotFoundException, IOException{
        input();
        process();
        output();
    }
    private static void input() throws FileNotFoundException, IOException{
        String filename = "C:\\Users\\usuario\\Desktop\\emails.txt";
        mailList = MailListReader.read(filename);
        System.out.println(mailList.size());
    }
    private static void process(){
        
        HistogramBuilder<Mail> builder = new HistogramBuilder<>(mailList);
        //histogram = HistogramBuilder.build(mailList);
        Histogram<String> domains = builder.build(new Attribute<Mail,String>(){
            @Override
            public String get(Mail item){
                return item.getMail().split("@")[1];
            }
        });
        new HistogramDisplay(domains, "Dominios").execute();
        Histogram<Character> letters = builder.build(new Attribute<Mail,Character>(){
            @Override
            public Character get(Mail item){
                return item.getMail().charAt(0);
            }
        });
        new HistogramDisplay (letters, "Primer Carácter").execute();        
    }
    private static void output(){
       new HistogramDisplay (letters, "Primer Carácter").execute();  
       //HistogramDisplay<T> histoDisplay = null;
       //new HistogramDisplay(histogram).execute(); 
    }
}
