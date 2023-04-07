package org.example;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PracticeFunctionalInterface {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "Hello World!";
        System.out.println(supplier.get());

        Consumer<String> consumer = (String str) -> System.out.println(str.split(" ")[0]);
        consumer.accept("Hello World!");
        consumer.andThen(System.out::println).accept("Hello World!"); // accept로 매개변수 하나 받아서, accept 먼저 실행시키고나서 andThen을 실행한다.

        Function<String, String> function = String::toLowerCase;
        String result = function.compose((String value) -> value.concat("B")).apply("A"); // a.concat("B") -> "ab".toLowerCase();
        String result = function.andThen(value -> value.concat("B")).apply("A"); // apply("A") -> "a".concat("B");
        System.out.println(result);

        Predicate<String> predicate = String::isBlank;
        boolean result = predicate.test("AA"); // false
        boolean result = predicate.test(" "); // true
        boolean result = predicate.and(otherValue -> otherValue.length() == 0).test(""); // true
        System.out.println(result);
    }
}
