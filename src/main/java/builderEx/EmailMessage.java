package builderEx;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.*;




public class EmailMessage {
    private String from; //required (must be e-mail)
    private LinkedList<String> to; //required at least one (must be e-mail)
    private String subject; //optional
    private String content; //optional
    private String mimeType;  // optional
    private LinkedList<String> cc; //optional
    private LinkedList<String> bcc; // optional


    protected EmailMessage(String from,
                           LinkedList<String> to,
                           String subject,
                           String content,
                           String mimeType,
                           LinkedList<String> cc,
                           LinkedList<String> bcc) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.content = content;
        this.mimeType =mimeType;
        this.cc = cc;
        this.bcc = bcc;
        // wiele if, else, sprawdzania czy string jest e-mail, itd.
    }


    public static class Builder {
        private String from; //required (must be e-mail)
        private LinkedList<String> to; //required at least one (must be e-mail)
        private String subject; //optional
        private String content; //optional
        private String mimeType;  // optional
        private LinkedList<String> cc; //optional
        private LinkedList<String> bcc; // optional

        public Builder(String from, LinkedList<String> to) {  //required - constructor ?
            this.from = from;
            this.to = to;
        }

        public Builder addSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder addContent(String content) {
            this.content = content;
            return this;
        }

        public Builder addMimeType(String mimeType) {
            this.mimeType = mimeType;
            return this;
        }

        public Builder addCc(LinkedList<String> cc) {
            this.cc = cc;
            return this;
        }

        public Builder addCBcc(LinkedList<String> bcc) {
            this.bcc = bcc;
            return this;
        }


        public EmailMessage builder() {
            return new EmailMessage(from, to, subject, content, mimeType, cc, bcc);
        }
    }

    public void send(EmailMessage message){

        String host = "localhost";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);

        try {
            // Create a default MimeMessage object.
            MimeMessage message1 = new MimeMessage(session);

            // Set From: header field of the header.
            message1.setFrom(new InternetAddress(message.from));
            for (int i = 0; i < message.to.size(); i++) {
                message1.addRecipient(Message.RecipientType.TO, new InternetAddress(message.to.get(i)));
            }
            message1.setSubject("HELLO BEAUTY");
            message1.setText("How you doin?");
            Transport.send(message1);
            System.out.println("Sent message successfully....");

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    public static void main (String [] args){
        LinkedList<String> to =new LinkedList<>();
        to.add("k.bednarz777@gmail.com");
        EmailMessage emailMessage=new EmailMessage.Builder("k.bednarz7@interia.pl",to).addSubject("eloMordo").builder();


        System.out.println(emailMessage.from);
        System.out.println(emailMessage.to);
        System.out.println(emailMessage.subject);


        EmailMessage tryHard = new EmailMessage.Builder("k.bednarz7@interia.pl",to).builder();
        tryHard.send(tryHard);

    }


}
