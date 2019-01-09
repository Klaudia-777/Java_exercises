package lab1;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;

/**
 * @author Szymon
 */
public class LoginProgram {
    public static void main(String[] argv) {
        Login log = new Login("ala", "makota");
        LoginDB db = new LoginDB();
        db.addLogin(log);

        try {
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader bfr = new BufferedReader(rd);

            // TODO: prosba o wpisanie hasła i loginu
            System.out.println("Enter login");
            String login = bfr.readLine();
            System.out.println("Enter password");
            String haslo = bfr.readLine();

        /*TODO: sprawdzenie czy podane hasło i login zgadzaja sie z tymi
         przechowywanymi w obiekcie log Jeśli tak, to ma zostać
         wyswietlone "OK", jesli nie - prosze wyswietlić informacje o błedzie
         */
            if (log.check(login, haslo)) System.out.println("OK");
            else System.out.println("fail");


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}