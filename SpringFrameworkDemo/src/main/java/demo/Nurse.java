package demo;

import org.springframework.stereotype.Component;

@Component
public class Nurse implements Staff{

    @Override
    public String toString() {
        return "Nurse{" +
                "qualiaction='" + qualiaction + '\'' +
                '}';
    }

    private String qualiaction;

    @Override
    public void assist() {
        System.out.println("Nurse is assisted!");
    }

    public void setQualiaction(String qualiaction) {
        this.qualiaction = qualiaction;
    }
}
