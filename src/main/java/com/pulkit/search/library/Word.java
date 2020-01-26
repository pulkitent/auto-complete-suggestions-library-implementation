package com.pulkit.search.library;

class Word {
    String text;

    Word(String text) {
        this.text = text;
    }

    void updateText(String text) {
        this.text = text;
    }

    Word addTextToCurrentWord(String text) {
        this.text = this.text + text;
        return this;
    }
}