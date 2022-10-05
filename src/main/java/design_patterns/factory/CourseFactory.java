package design_patterns.factory;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class CourseFactory {

    public static final String PACKAGE = "design_patterns.factory.";
    public static Map<String,Object> courseMap = new HashMap<>();

    static {
        courseMap.put("HLD",new HLD());
        courseMap.put("LLD",new LLD());
    }

    public static Course getCourse(String course){
        return (Course) courseMap.get(course);
    }

    public static void registerCourse(String course) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        courseMap.put(course,Class.forName(PACKAGE +course).getDeclaredConstructor().newInstance());
    }
}
