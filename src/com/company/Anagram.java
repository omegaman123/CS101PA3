package com.company;

import java.util.Arrays;

public class Anagram {
    private String word;
    private String code;

    public Anagram(String word) {
        this.word = word;
        char[] c = word.toCharArray();
        Arrays.sort(c);
        this.code = new String(c).toLowerCase();
    }

    public Anagram(char[] word) {
        String s = new String(word);
        this.word = s;
        Arrays.sort(word);
        this.code = new String(word).toLowerCase();
    }

    public void print() {
        System.out.println(this.word);
    }

    public String getWord() {
        return this.word;
    }

    public String getCode(){
        return this.code;
    }

    public boolean compareTo(Anagram that) {
        if (this.code.compareTo(that.code) == 0) {
            return true;
        } else {
            return false;
        }
    }


}



