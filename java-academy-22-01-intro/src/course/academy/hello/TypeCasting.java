package course.academy.hello;

import java.util.Date;

public class TypeCasting {
    public static void main(String[] args) {
        byte b = 124;
        short s = b;
        System.out.printf("byte to short: %d\n", s);
        int i = b;
        System.out.printf("byte to int: %d\n", i);
        long l = b;
        System.out.printf("byte to long: %d\n", l);

        int i2 = (int) 435335343444534454L;
        System.out.printf("long to int: %d\n", i2);

        String str = "Hello Java!";
        Object obj = str; // Upcasting is automatic
        System.out.println("Upcasting String -> Object: " + str );

        Object obj2 = new Date();
        if(obj2 instanceof String) {
            String str2 = (String) obj2;
            System.out.println("Downcasting Object -> String: " + str2);
        } else {
            System.out.printf("Imposible to cast %s to %s",
                    obj2.getClass().getSimpleName(), String.class.getSimpleName());
        }
    }
}
