package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        Doctor doctor = context.getBean(Doctor.class);
        doctor.assist();
        doctor.setQualiaction("MBBA");
        System.out.println(doctor);

        Doctor doctor1 = context.getBean(Doctor.class);
        System.out.println(doctor1);

        Nurse nurse = context.getBean(Nurse.class);
        nurse.assist();
        nurse.setQualiaction("MBBA");
        System.out.println(nurse);


        Nurse nurse1 = context.getBean(Nurse.class);
        System.out.println(nurse1);

    }
}
