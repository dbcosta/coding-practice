package practice.design.patterns.practice1.singleton;

public class SingletonDemo {
    public static void main(String[] args) {
        LoggerSingleton loggerSingleton1 = LoggerSingleton.getInstance();
        System.out.println(loggerSingleton1);

        LoggerSingleton loggerSingleton2 = LoggerSingleton.getInstance();
        System.out.println(loggerSingleton2);
    }
}
