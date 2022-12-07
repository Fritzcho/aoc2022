package alire.day.four;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    private static int sum = 0;
    public static void main(String[] args) throws IOException {
        part2();
    }

    private static int part1() throws IOException {
        String fileName = "src/alire/day/four/demo.txt";
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;

        while((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            String[] left = parts[0].split("-");
            String[] right = parts[1].split("-");
            if (Integer.parseInt(left[0]) >= Integer.parseInt(right[0]) &&
                    Integer.parseInt(left[1]) <= Integer.parseInt(right[1])) {
                sum++;
            } else if (Integer.parseInt(right[0]) >= Integer.parseInt(left[0]) &&
                    Integer.parseInt(right[1]) <= Integer.parseInt(left[1])) {
                sum++;
            }
        }
        System.out.println(sum);
        return 0;
    }

    private static int part2() throws IOException {
        String fileName = "src/alire/day/four/input.txt";
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;

        while((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            String[] left = parts[0].split("-");
            String[] right = parts[1].split("-");
            Range rleft = new Range(Integer.parseInt(left[0]), Integer.parseInt(left[1]));
            Range rright = new Range(Integer.parseInt(right[0]), Integer.parseInt(right[1]));

            if (rleft.overlaps(rright))
                sum++;
        }
        System.out.println(sum);
        return 0;
    }
}

class Range {
    public int start;
    public int end;
    public Range(int s, int e) {
        start = s;
        end = e;
    }

    public boolean overlaps(Range scndrange) {
        if (scndrange.start>=start && scndrange.end<=end || scndrange.end>=start && scndrange.end<=end)
            return true;
        else return start >= scndrange.start && end <= scndrange.end || end >= scndrange.start && end <= scndrange.end;
    }
}
