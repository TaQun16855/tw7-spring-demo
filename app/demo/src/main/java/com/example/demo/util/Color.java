package com.example.demo.util;

public enum Color {
    GRAY("\u001b[00;30m"),
    RED("\u001b[00;31m"),
    GREEN("\u001b[00;32m"),
    YELLOW("\u001b[00;33m"),
    BLUE("\u001b[00;34m"),
    PINK("\u001b[00;35m"),
    CYAN("\u001b[00;36m"),
    WHITE("\u001b[00;37m"),
    $GRAY("\\u001b[00;40m"),
    $RED("\u001b[00;41m"),
    $GREEN("\u001b[00;42m"),
    $YELLOW("\u001b[00;43m"),
    $BLUE("\u001b[00;44m"),
    $PINK("\u001b[00;45m"),
    $CYAN("\u001b[00;46m"),
    $WHITE("\u001b[00;47m"),
    END("\u001b[00m");

    private final String value;


    private Color(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}