package practice.design.patterns.practice1.strategy;

public class CareerPathContext {
    private ICareerPathStrategy careerPathStrategy;

    public void setCareerPathContext(ICareerPathStrategy careerPathStrategy){
        this.careerPathStrategy = careerPathStrategy;
    }

    public void applyRules(String careerPath){
        careerPathStrategy.applyRules(careerPath);
    }
}
