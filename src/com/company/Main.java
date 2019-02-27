package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;

import java.util.NoSuchElementException;
import java.util.Scanner;


public class Main {
    private static final int hashsize = 128000;

    public static void main(String[] args) throws Exception {
        String fileName = args[0];
        String testFileName;
        try {
            testFileName = args[1];
        } catch (Exception e) {
            testFileName = null;
        }
        Scanner in = new Scanner(new File(fileName));
        int n = in.nextInt();
        ArrayList<ArrayList<Anagram>> a = new ArrayList<>(hashsize);

        for (int i = 0; i < hashsize; i++) {
            a.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            String s = in.next();
            Anagram agram = new Anagram(s);
            long hsh = hash(agram.getCode());
            int idx = Math.abs((int) (hsh % hashsize));
            a.get(idx).add(agram);
        }
        FindAnagrams(a, testFileName);
    }

    public static void FindAnagrams(ArrayList<ArrayList<Anagram>> a, String testfile) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input;
        try {
            if (testfile != null) {
                Scanner in = new Scanner(new File(testfile));
                while (in.hasNextLine()) {
                    System.out.println("type a string of letters");
                    input = in.nextLine();
                    System.out.println(input);
                    Anagram agm = new Anagram(input);
                    long hsh = hash(agm.getCode());
                    int idx = Math.abs((int) (hsh % hashsize));
                    ArrayList<Anagram> l = a.get(idx);
                    if (l == null) {
                        System.out.printf("No anagrams for word %s found", input);
                        continue;
                    }
                    for (int i = 0; i < l.size(); i++) {
                        if (l.get(i).getWord().compareTo(agm.getWord()) == 0) {
                            continue;
                        }
                        if (l.get(i).getCode().compareTo(agm.getCode()) == 0) {
                            System.out.println(l.get(i).getWord());
                        }
                    }

                    if (in.hasNextLine()) {
                        System.out.println("Do another (y/n)?");
                        System.out.println("y");
                        continue;
                    }
                    System.out.println("Do another (y/n)?");
                    System.out.println("n");
                }


            } else {
                while (true) {
                    System.out.println("type a string of letters");
                    input = scanner.nextLine();
                    String[] words = input.split("\\s+");
                    for (int j = 0; j < words.length; j++) {
                        System.out.printf("Anagrams for input word %s:\n", words[j]);
                        Anagram agm = new Anagram(words[j]);
                        long hsh = hash(agm.getCode());
                        int idx = Math.abs((int) (hsh % hashsize));
                        ArrayList<Anagram> l = a.get(idx);
                        if (l == null) {
                            System.out.printf("No anagrams for word %s found", words[j]);
                            continue;
                        }
                        for (int i = 0; i < l.size(); i++) {
                            if (l.get(i).getWord().compareTo(agm.getWord()) == 0) {
                                continue;
                            }
                            if (l.get(i).getCode().compareTo(agm.getCode()) == 0) {
                                System.out.println(l.get(i).getWord());
                            }
                        }

                    }
                    System.out.println("Do another (y/n)?");
                    input = scanner.nextLine();
                    if (input.compareTo("y") == 0) {
                        continue;
                    }
                    break;
                }
            }
        } catch (IllegalStateException | NoSuchElementException e) {
            System.out.println("System.in was closed; exiting");
        }

    }


    public static long hash(String string) {
        long h = 1125899906842597L; // prime
        int len = string.length();

        for (int i = 0; i < len; i++) {
            h = 31 * h + string.charAt(i);
        }
        return h;
    }
}

