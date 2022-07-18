package com.udemy.java;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JoiningTest {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Apple","Aeroplane","Bat","Cat","Apple","Pizza","Ball","Boy","Cat","Delta");

        /*String collect = names.stream()
                .filter(s -> s.length() > 3)
                .collect(Collectors.joining("_"));

        System.out.println(collect);*/

        Map<Integer, List<String>> map = names.stream()
                .collect(Collectors.groupingBy(s -> s.length()));

        System.out.println(map);

        System.out.println(map.get(4));

        Map<Character, List<String>> map1 = names.stream().collect(Collectors.groupingBy(s -> s.charAt(0)));
        System.out.println(map1);


    }


}