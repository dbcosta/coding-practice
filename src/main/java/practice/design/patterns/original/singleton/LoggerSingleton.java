package practice.design.patterns.original.singleton;

public class LoggerSingleton {
    //eager loading
    /*private static LoggerSingleton instance = new LoggerSingleton(); //singleton instance

    private LoggerSingleton(){} //private constructor

    public static LoggerSingleton getInstance(){ //getter
        return instance;
    }*/

    //lazy - loading
    /*private static LoggerSingleton instance = null;

    private LoggerSingleton(){}

    public static LoggerSingleton getInstance(){
        if(instance==null){
            instance = new LoggerSingleton();
        }
        return instance;
    }*/

    //thread-safety
    private static volatile LoggerSingleton instance = null;
    //volatile keyword makes the changes/threads which are accessing this variable visible.

    private LoggerSingleton(){ //used to avoid reflection breaking a singleton
        if(instance!=null){
            throw new RuntimeException("Please don't try to be smart!");
        }
    }

    public static LoggerSingleton getInstance(){
        if(instance==null){
            synchronized (LoggerSingleton.class){
                if(instance==null){
                    instance = new LoggerSingleton();
                }
            }
        }
        return instance;
    }
}
