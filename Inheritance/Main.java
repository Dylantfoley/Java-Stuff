package inheritanceChallenge;

public class Main {
    public static void main(String[] args) {

        Outlander outlander = new Outlander(12);

        outlander.steer(45);
        outlander.accelerate(30);
        outlander.accelerate(20);

        outlander.accelerate(-42);
    }


}
