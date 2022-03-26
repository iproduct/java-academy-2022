package course.demos.io;

import java.io.*;

public class LineNumbering {
    public static void main(String[] args) {
        int n = 0;
        try (var in = new BufferedReader(
                new FileReader("./src/course/demos/io/LineNumbering.java"));
             var out = new PrintWriter(
                     new BufferedWriter(
                             new FileWriter("out.txt")))
        ) {
            String line;
            while((line = in.readLine()) != null) {
                out.printf("%3d: %s%n", ++n, line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
