package practice.design.patterns.practice1.singleton;

public class LoggerSingleton {
    private static volatile LoggerSingleton instance = null;

    private LoggerSingleton() {
        if(instance!=null){
            throw new RuntimeException("Can't create another one!");
        }
    }

    public static LoggerSingleton getInstance(){
        if(instance==null){
            synchronized (LoggerSingleton.class){
               if(instance == null){
                   instance = new LoggerSingleton();
               }
            }
        }
        return instance;
    }

}
