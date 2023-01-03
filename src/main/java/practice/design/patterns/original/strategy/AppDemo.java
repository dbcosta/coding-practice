package practice.design.patterns.original.strategy;

public class AppDemo {
    public static void main(String[] args) {
        CareerPathContext careerPathContext = new CareerPathContext();
        careerPathContext.setCareerPathStrategy(new AgilistCareerPathStrategy());
        careerPathContext.applyRules("Agilist");
    }
}
