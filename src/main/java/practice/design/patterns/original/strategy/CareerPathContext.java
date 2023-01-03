package practice.design.patterns.original.strategy;

public class CareerPathContext {

    private ICareerPathStrategy careerPathStrategy;

    public void setCareerPathStrategy(ICareerPathStrategy careerPathStrategy){
        this.careerPathStrategy = careerPathStrategy;
    }

    public void applyRules(String careerPath){
        careerPathStrategy.applyRules(careerPath);
    }
}
