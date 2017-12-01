package kata6.model;

public class Mail {
    private final String mail;
    public Mail(String mail){
        this.mail = mail;
    }
    public String getMail(){
        return mail;
    }
    public String getDomain(){
        if (mail.indexOf("@") == -1){
            return mail;
        }
        return mail.split("@")[1];
    }
}
