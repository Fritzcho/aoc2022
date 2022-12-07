package alire.day.three;

import java.io.*;

public class Main {
    private static int sum = 0;
    private static int sum2 = 0;

    public static void main(String[] args) throws IOException {
        //part1();
        part2();
        System.out.println(sum2);

    }

    private static int part1() throws IOException {
        String fileName = "src/alire/day/three/input.txt";
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;

        while((line = br.readLine()) != null) {
            final char[] left = line.substring(0, line.length() / 2).toCharArray();
            final char[] right = line.substring(line.length() / 2).toCharArray();

            boolean isFound = false;

            for (char leftchar : left) {
                if (isFound)
                    break;
                for (char rightchar : right) {
                    if (leftchar == rightchar) {
                        sum += (leftchar <= 90) ? (leftchar - 65) + 27 : (leftchar - 97) + 1;
                        isFound = true;
                        break;
                    }
                }
            }
        }

        return sum;
    }

    private static int part2() throws IOException {
        String fileName = "src/alire/day/three/input.txt";
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        char[] charArray1 = new char[0];
        char[] charArray2 = new char[0];
        char[] charArray3 = new char[0];

        int linec = 1;


        while((line = br.readLine()) != null) {
            if (linec == 1)
                charArray1 = line.toCharArray();
            if (linec == 2)
                charArray2 = line.toCharArray();
            if (linec == 3)
                charArray3 = line.toCharArray();
            boolean isFound = false;

            if (linec == 3) {
                for (char char1 : charArray1) {
                    if (isFound)
                        break;
                    for (char char2 : charArray2) {
                        if (isFound)
                            break;
                        for (char char3 : charArray3) {
                            if (char1 == char2 && char2 == char3) {
                                sum2 += (char1 <= 90) ? (char2 - 65) + 27 : (char3 - 97) + 1;
                                isFound = true;
                                linec = 0;
                                break;
                            }
                        }
                    }
                }
            }
            linec++;
        }

        return sum2;
    }
}
