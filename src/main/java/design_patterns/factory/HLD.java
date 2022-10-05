package design_patterns.factory;

public class HLD extends Course{
    @Override
    public void createCourse() {
        modules.add(new IntroModule());
        modules.add(new ConceptModule());
        modules.add(new SummaryModule());
    }
}
