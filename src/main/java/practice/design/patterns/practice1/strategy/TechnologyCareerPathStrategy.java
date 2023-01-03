package practice.design.patterns.practice1.strategy;

public class TechnologyCareerPathStrategy implements ICareerPathStrategy{
    @Override
    public void applyRules(String careerPath) {
        System.out.println("Technology rules!");
    }
}
