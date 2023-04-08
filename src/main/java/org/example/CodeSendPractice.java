package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CodeSendPractice {
    public static void main(String[] args) {
        // 1. Apple 리스트를 생성한다.
        List<Apple> apples = new ArrayList<>(List.of(
                new Apple(1, "red"),
                new Apple(50, "green"),
                new Apple(100, "red"),
                new Apple(30, "red"),
                new Apple(80, "green"))
        );

        // 2. Apple내에 static 메서드를 만들어 color가 red인 사과를 필터링한다.
        List<Apple> redApples = Apple.filterRedApples(apples);
        System.out.println(redApples); // [Apple{size=1, color='red'}, Apple{size=100, color='red'}, Apple{size=30, color='red'}]

        // 3. Apple내에 static 메서드를 만들어 size가 50 이상인 사과를 필터링한다.
        List<Apple> bigApples = Apple.filterBigApples(apples);
        System.out.println(bigApples); // [Apple{size=50, color='green'}, Apple{size=100, color='red'}, Apple{size=80, color='green'}]

        // 4. 메서드를 전달하는 방식으로 color가 red인 사과를 필터링한다.
        List<Apple> advancedRedApples = Apple.filterApples(apples, apple -> apple.isRedApple(apple));
        System.out.println(advancedRedApples); // [Apple{size=1, color='red'}, Apple{size=100, color='red'}, Apple{size=30, color='red'}]

        // 5. 메서드를 전달하는 방식으로 size가 50 이상인 사과를 필터링한다.
        List<Apple> advancedBigApples = Apple.filterApples(apples, apple -> apple.isBigApple(apple));
        System.out.println(advancedBigApples); // [Apple{size=50, color='green'}, Apple{size=100, color='red'}, Apple{size=80, color='green'}]
    }
}

class Apple {
    private final int size;
    private final String color;

    public Apple(final int size, final String color) {
        this.size = size;
        this.color = color;
    }

    public static List<Apple> filterRedApples(final List<Apple> apples) {
        List<Apple> result = new ArrayList<>();

        for (final Apple apple : apples) {
            if (apple.color.equals("red")) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterBigApples(final List<Apple> apples) {
        List<Apple> result = new ArrayList<>();

        for (final Apple apple : apples) {
            if (apple.size >= 50) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApples(final List<Apple> apples, final Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();

        for (final Apple apple : apples) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public boolean isRedApple(final Apple apple) {
        return apple.color.equals("red");
    }

    public boolean isBigApple(final Apple apple) {
        return apple.size >= 50;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "size=" + size +
                ", color='" + color + '\'' +
                '}';
    }
}
