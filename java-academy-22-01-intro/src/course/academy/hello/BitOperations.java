package course.academy.hello;

public class BitOperations {
    public static String toBinary(int n) {
        var result = new StringBuilder("");
        do {
//            result = result.insert(0, n % 2);
            result = result.append(n % 2);
            n = n >> 1;
        } while (n > 0);
        return result.reverse().toString();
    }

    public static int toDecimal(String binary) {
        int result = 0;
        for (int i = binary.length() - 1, j = 0; i >= 0; i--, j++) {
            result += (1 << j) * (binary.charAt(i) - '0');
        }
        return result;
    }

    public static void main(String[] args) {
        int b = 576889696;
        System.out.printf("%s\n", Integer.toBinaryString(b));
        String binN = toBinary(b);
        System.out.printf("%s\n", binN);
        System.out.printf("%s\n", toDecimal(binN));

    }
}
