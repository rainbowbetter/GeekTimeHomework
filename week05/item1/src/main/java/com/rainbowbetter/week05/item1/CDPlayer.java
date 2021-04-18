package com.rainbowbetter.week05.item1;

public class CDPlayer {

    //通过构造器 实现DI功能
    private CompactDisc compactDisc;

    public CDPlayer(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }

    public void play() {
        compactDisc.play();
    }
}
