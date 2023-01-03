package practice.design.patterns.practice1.strategy;

public class AgilistCareerPathStrategy implements ICareerPathStrategy{
    @Override
    public void applyRules(String careerPath) {
        System.out.println("Agilist rules!");
    }
}
