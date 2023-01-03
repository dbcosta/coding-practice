package practice.design.patterns.original.strategy;

public class TechnologyCareerPath implements ICareerPathStrategy{
    @Override
    public void applyRules(String careerPath) {
        System.out.println("Rules for careerpath: "+careerPath);
    }
}
