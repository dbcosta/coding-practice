package design_patterns.factory;

public class LLD extends Course{
    @Override
    public void createCourse() {
        modules.add(new IntroModule());
        modules.add(new ConceptModule());
        modules.add(new DemoModule());
        modules.add(new ExerciseModule());
        modules.add(new SummaryModule());
    }
}
