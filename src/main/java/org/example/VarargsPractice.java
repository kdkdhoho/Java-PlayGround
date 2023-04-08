package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VarargsPractice {
    public static void main(String[] args) {
        printValues();
        printValues("1");
        printValues("1", "2");
        printValues("1", "2", "3");
        printValues(new String[]{"1", "2", "3"});

        List[] strings = new List[]{
                new ArrayList(List.of("1")),
                new ArrayList(List.of("1", "2", "3")),
                new ArrayList(List.of(1, 2, 3))
        };

        try {
            firstOfFirst(strings);
        } catch (final ClassCastException e) {
            System.out.println("ClassCastException 예외 발생!");
        }
    }

    public static void printValues(final String... values) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            stringBuilder.append(values[i]);
        }

        System.out.println(stringBuilder);
    }

    public static String firstOfFirst(List<String>... strings) {
        List<Integer> ints = Collections.singletonList(42);
        Object[] objects = strings;
        objects[0] = ints; // Heap pollution

        return strings[0].get(0); // ClassCastException
    }
}
