package com.allen.codedaily.day.info;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class KeyBoardTest {

    @Autowired
    private KeyBoard keyBoard;

    @Test
    void testKeyBoard() {
        log.info("keyBoard.name:{}", keyBoard.getName());
        log.info("keyBoard.logo:{}", keyBoard.getLogo());
        log.info("keyBoard.isMechanical:{}", keyBoard.isMechanical());
        log.info("keyBoard.axis:{}", keyBoard.getAxis());
        log.info("keyBoard.keycaps:{}", keyBoard.getKeycaps());
        log.info("keyBoard.keysNum:{}", keyBoard.getKeysNum());
    }
}