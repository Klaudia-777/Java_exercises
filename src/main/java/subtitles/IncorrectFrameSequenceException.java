package subtitles;

public class IncorrectFrameSequenceException extends Exception {
    public IncorrectFrameSequenceException(int numberOfLine){
        System.out.println("Nieprawidłowe ramy czasowe napisu.\t linijka: "+numberOfLine);
    }
}
