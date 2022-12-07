package alire.day.two;

import java.io.*;

public class Main {
    //A and X = rock = 1p
    //B and Y = Paper = 2p
    //C and Z = Scissor = 3p
    //won = 6p
    //draw = 3p
    private static int score = 0;
    public static void main(String[] args) throws IOException {
        String fileName = "src/alire/day/two/input.txt";
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;

        while((line = br.readLine()) != null) {
            if (line.contains("A"))
                rock(line);
            if (line.contains("B"))
                paper(line);
            if (line.contains("C"))
                scissor(line);
        }

        System.out.println(score);
    }

    private static void rock(String s) {
        if (s.contains("X"))
            score = score + 3;
        if (s.contains("Y"))
            score = score + 4;
        if (s.contains("Z"))
            score = score + 8;
    }

    private static void paper(String s) {
        if (s.contains("X"))
            score = score + 1;
        if (s.contains("Y"))
            score = score + 5;
        if (s.contains("Z"))
            score = score + 9;
    }

    private static void scissor(String s) {
        if (s.contains("X"))
            score = score + 2;
        if (s.contains("Y"))
            score = score + 6;
        if (s.contains("Z"))
            score = score + 7;
    }

}
