package demo;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
@Scope(scopeName = "prototype")
public class Doctor implements Staff, BeanNameAware {
    @Override
    public String toString() {
        return "Doctor{" +
                "qualiaction='" + qualiaction + '\'' +
                '}';
    }

    private String qualiaction;

    @Override
    public void assist() {
        System.out.println("Doctror is assisted!");
    }

    public void setQualiaction(String qualiaction) {
        this.qualiaction = qualiaction;
    }

    public String getQualiaction() {
        return qualiaction;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Set Bean Name is called!");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("Post Construct is called!");
    }
}
