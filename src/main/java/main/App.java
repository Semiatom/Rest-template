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
        String cookie =  communication.getCookie();

        User user = new User(3,"James","Brown", 28);
        User user2 = new User(3,"Thomas", "Shelby",28);

        communication.createUser(user, cookie);
        System.out.println(communication.getUsers());
        communication.editUser(user2, cookie);
        System.out.println(communication.getUsers());
////        communication.deleteUser(2, cookie);
//        System.out.println(communication.getUsers());


    }
}
