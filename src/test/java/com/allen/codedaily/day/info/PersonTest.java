package com.allen.codedaily.day.info;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class PersonTest {

    @Autowired
    private Person person;

    @Test
    public void testPerson(){
        log.info("person: {}",person);
    }
}