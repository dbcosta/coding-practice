package practice.design.patterns.original.strategy;

public class AgilistCareerPathStrategy implements ICareerPathStrategy{

    @Override
    public void applyRules(String careerPath) {
        System.out.println("Rules for careerPath: "+careerPath);
    }
}
