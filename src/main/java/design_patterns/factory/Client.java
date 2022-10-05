package design_patterns.factory;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class Client {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Course hldCourse = CourseFactory.getCourse("HLD");
        Course lldCourse = CourseFactory.getCourse("LLD");
        CourseFactory.registerCourse("UML");
        Course umlCourse = CourseFactory.getCourse("UML");
        assert hldCourse!=null;
        log.info("HLD Modules: {}",hldCourse.getModules());
        assert lldCourse!=null;
        log.info("LLD Modules: {}",lldCourse.getModules());
        assert umlCourse!=null;
        log.info("UML Modules: {}",umlCourse.getModules());
    }
}
