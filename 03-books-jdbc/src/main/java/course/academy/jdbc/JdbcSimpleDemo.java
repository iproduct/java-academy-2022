package course.academy.jdbc;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JdbcSimpleDemo {
    public void run() {
        log.info("Hello from Lombok!");

    }
    public static void main(String[] args) {
        var demo = new JdbcSimpleDemo();
        demo.run();
    }
}
