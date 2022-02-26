package course.academy.hello;

enum DayOfWeek {
    MON, TUE, WED, THU, FRI, SAT, SUN
}

public class SwitchDemo {
    public static boolean isWorkingDay(DayOfWeek dow ){
        switch (dow) {
            case TUE:
            case MON:
            case WED:
            case THU:
            case FRI: return true;
            default: return false;
        }
    }

    public static void main(String[] args) {
        for(DayOfWeek dayOfWeek : DayOfWeek.values()){
            System.out.printf("%s -> Is working = %b%n", dayOfWeek.toString(), isWorkingDay(dayOfWeek));
        }
        DayOfWeek today = DayOfWeek.valueOf("SAT");
        System.out.printf("%s [%d] -> Is working = %b%n", today, today.ordinal(), isWorkingDay(today));

    }
}
