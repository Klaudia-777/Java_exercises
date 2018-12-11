package Lab1;

import java.util.ArrayList;
import java.util.List;

public class LoginDB {
    private List<Login> accounts;
    public LoginDB(){
        this.accounts=new ArrayList<>();
    };

    public void addLogin(Login login){
        if(!accounts.contains(login)) accounts.add(login);
        else throw new RuntimeException();
    }

    public void removeLogin(Login login){
        accounts.remove(login);
    }
    public boolean chechLogin(String login,String password){
        for (int i = 0; i < accounts.size(); i++) {
        if(accounts.get(i).check(login,password)) return true;
        }
        return false;

    }
}
