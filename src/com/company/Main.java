package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        String fileName = args[0];
        System.out.println(args[0]);
        Scanner in = new Scanner(new File(fileName));
        int n = in.nextInt();
        Hashtable<String,ArrayList<Anagram>> h = new Hashtable<>();


//        Anagram a = new Anagram("items");
//        Anagram b = new Anagram("emits");
//        Anagram c = new Anagram("metis");
//        Anagram d = new Anagram("mites");
//        Anagram e = new Anagram("smite");
//        Anagram f = new Anagram("stime");
//        Anagram g = new Anagram("times");
//
//
//        System.out.println(a.compareTo(b));
//        System.out.println(a.getCode());
//        System.out.println(b.getCode());
//        System.out.println(c.getCode());
//        System.out.println(d.getCode());
//        System.out.println(e.getCode());
//        System.out.println(f.getCode());
//        System.out.println(g.getCode());


        for (int i = 0; i < n; i++) {
            String s = in.next();
            Anagram agram = new Anagram(s);
            ArrayList<Anagram> l = h.get(agram.getCode());
            if (l == null){
                l = new ArrayList<>();
               l.add(agram);
               h.put(agram.getCode(),l);
            } else {
                l.add(agram);
            }

        }
        System.out.println(h.size());
    }

    public static long hash(String string) {
        long h = 1125899906842597L; // prime
        int len = string.length();

        for (int i = 0; i < len; i++) {
            h = 31*h + string.charAt(i);
        }
        return h;
    }
}

