package design_patterns.factory;

import java.util.ArrayList;
import java.util.List;

public abstract class Course {
    List<Module> modules = new ArrayList<>();

    public Course(){
        this.createCourse();
    }

    public abstract void createCourse();

    public List<Module> getModules(){
        return this.modules;
    }
    
}
