package subtitles;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Subtitles {

    public void delay(final String in, final String out, int delay, int fps) throws IncorrectCharSequenceException,
            IncorrectFrameSequenceException,
            IOException {

        BufferedReader input = new BufferedReader(new FileReader(in));
        BufferedWriter output = new BufferedWriter(new FileWriter(out));

        String line = "";

        int numberOfLine = 0;
        int firstMatch, secondMatch;

        Pattern pattern = Pattern.compile("\\{(\\d*)}\\{(\\d*)}(.*)");

        StringBuilder result = new StringBuilder();
        Matcher matcher;

        while ((line = input.readLine()) != null) {
            numberOfLine++;
            matcher = pattern.matcher(line);

            if (!matcher.matches()) throw new IncorrectCharSequenceException(numberOfLine);

            firstMatch = Integer.parseInt(matcher.group(1));
            secondMatch = Integer.parseInt(matcher.group(2));

            if (firstMatch > secondMatch) throw new IncorrectFrameSequenceException(numberOfLine);

            firstMatch += delay * fps / 1000;
            secondMatch += delay * fps / 1000;

            result.append("{").append(Integer.toString(firstMatch)).append("}")
                    .append("{").append(Integer.toString(secondMatch)).append("}").append(matcher.group(3));

            output.write(result.toString() + "\n");
            result.delete(0, result.length());

        }

        input.close();
        output.close();
    }


    public static void main(String[] args) {
        Subtitles subtitles = new Subtitles();

        try {
            subtitles.delay("/home/klaudia/IdeaProjects/testMotorola1/src/subtitles/gravity.txt",
                    "/home/klaudia/IdeaProjects/testMotorola1/src/subtitles/gravityResult.txt",
                    Integer.parseInt("3000"), Integer.parseInt("1000"));


        } catch (IncorrectFrameSequenceException e) {
            System.out.println("poczatek>koniec");
        } catch (IncorrectCharSequenceException ex) {
            System.out.println("nie takie znaki w klamrach");
        } catch (IOException exx) {
            exx.printStackTrace();
        }
    }
}
