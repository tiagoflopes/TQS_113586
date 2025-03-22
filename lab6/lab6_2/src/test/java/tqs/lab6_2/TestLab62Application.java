package tqs.lab6_2;

import org.springframework.boot.SpringApplication;

public class TestLab62Application {

    public static void main(String[] args) {
        SpringApplication.from(Lab62Application::main).with(TestcontainersConfiguration.class).run(args);
    }

}
