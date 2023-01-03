package practice.design.patterns.practice1.strategy;

public class AppMain {
    public static void main(String[] args) {
        CareerPathContext careerPathContext = new CareerPathContext();
        careerPathContext.setCareerPathContext(new TechnologyCareerPathStrategy());
        careerPathContext.applyRules("TECHNOLOGY");
    }
}
