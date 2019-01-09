package subtitles;

public class IncorrectCharSequenceException extends Exception{

    public IncorrectCharSequenceException(int numberOfLine) {
        System.out.println("Nieprawidłowa sekwencja znaków.\t linijka: "+numberOfLine);
    }

}
