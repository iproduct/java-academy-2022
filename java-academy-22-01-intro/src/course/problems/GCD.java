package course.problems;

import java.util.Scanner;

public class GCD {
    public static int getGCD(int a, int b){
        return 0; //TODO Implement me : https://en.wikipedia.org/wiki/Euclidean_algorithm
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.printf("GCD of %d and %d = %d", x, y, getGCD(x, y));
    }
}
