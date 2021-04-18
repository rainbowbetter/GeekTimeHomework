package com.rainbowbetter.week05.item1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = CDPlayerConfig.class)
class Item1ApplicationTests {

    @Autowired
    private CDPlayer cdPlayer;

    @Autowired
    private CompactDisc compactDisc;

    @Test
    public void testPlayer() {
        compactDisc.play();
        cdPlayer.play();
    }
}
