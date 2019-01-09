package lab1;

public class Pesel {

    public static boolean checkIfCorrect(String pesel) {
        int sum = 0;
        int[] multipliers = {9, 7, 3, 1};
        int iterator = 0;
        for (char it : pesel.substring(0, pesel.length() - 1).toCharArray()) {
            if (iterator == 4) iterator = 0;
            sum += (it - '0') * multipliers[iterator];
            iterator++;
        }
        if(sum%10==(pesel.charAt(pesel.length()-1)-'0')) return true;
      return false;
    }

    public static void main(String[] argv){
//        Pesel pesel=new Pesel();

        System.out.println( Pesel.checkIfCorrect("97050703405"));
    }

}



