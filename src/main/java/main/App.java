package main;

import configuration.MyConfig;
import entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        Communication communication = context.getBean("communication", Communication.class);

        System.out.println(communication.getUsers());
        System.out.println(communication.getCookie());

        User user = new User(3,"James","Brown", 28);

    }
}
