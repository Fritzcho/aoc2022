package alire.day.five;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int height = 9;


    public static void main(String[] args) throws IOException {
        part1();
    }

    private static void part1() throws IOException {
        BufferedReader br = getFile();
        String line;
        List<List<String>> crates = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            crates.add(new ArrayList<>());
        }
        boolean prevIsEmpty = false;

        while ((line = br.readLine())!=null) {
            while (line.contains("[")) {
                String[] parts = line.split("  ");
                int i = 0;
                for (String part : parts) {
                    String[] subparts = part.split(" ");
                    for (String subpart : subparts) {
                        if (subpart.isEmpty()) {
                            if (!prevIsEmpty) {
                                i++;
                            }
                            prevIsEmpty = true;
                            continue;
                        }
                        crates.get(i).add(subpart);
                        i++;
                        prevIsEmpty = false;
                    }
                }
                System.out.println(line);
                break;
            }
            if (line.contains("move")) {
                String[] parts = line.split(" ");
                List<String> tempList = crates.get(parse(parts[3])-1)
                        .subList(0, crates.get(parse(parts[3])-1).size()
                                -(crates.get(parse(parts[3])-1).size()-parse(parts[1])));
                crates.get(parse(parts[5])-1).addAll(0,tempList);
                if (parse(parts[1]) > 0) {
                    crates.get(parse(parts[3]) - 1).subList(0, parse(parts[1])).clear();
                }
            }
        }
        for (List<String> list : crates) {
            System.out.println(list);
        }
    }

    private static BufferedReader getFile() throws FileNotFoundException {
        String fileName = "src/alire/day/five/input.txt";
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        return new BufferedReader(fr);
    }

    private static int parse(String c) {
        return Integer.parseInt(c);
    }
}