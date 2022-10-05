package design_patterns.factory;

public class UML extends Course{
    @Override
    public void createCourse() {
        modules.add(new IntroModule());
        modules.add(new ConceptModule());
        modules.add(new ExerciseModule());
        modules.add(new SummaryModule());
    }
}
