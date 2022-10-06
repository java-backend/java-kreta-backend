package org.example.kreta.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class StudentsControllerTest {
    @Autowired
    private SchoolClassesController controller;

    // https://spring.io/guides/gs/testing-web/
    // https://thepracticaldeveloper.com/guide-spring-boot-controller-tests/
    @Test
    public void contextLoads() throws  Exception {
        assertThat(controller).isNotNull();
    }
}
