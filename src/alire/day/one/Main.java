package alire.day.one;


import java.io.*;

public class Main {
    private static int first = 0;
    private static int second = 0;
    private static int third = 0;

    public static void main(String[] args) throws IOException {
        String fileName = "src/alire/day/one/input.txt";
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        int sum = 0;
        while((line = br.readLine()) != null){
            if(!line.isEmpty())
                sum = Integer.parseInt(line)+sum;
            else {
                sum = getTop3(sum);
            }
        }
        getTop3(sum);
        int top3 = first + second + third;
        System.out.println(top3);
    }

    private static int getTop3(int s) {
        if (s>first) {
            third = second;
            second = first;
            first = s;
        } else if (s>second) {
            third = second;
            second = s;
        } else if (s>third)
            third = s;

        return 0;
    }
}
