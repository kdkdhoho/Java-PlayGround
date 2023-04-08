package org.example;

import static org.example.Color.GREEN;
import static org.example.Color.RED;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

enum Color {
    RED, GREEN
}

class Apple {
    private final int size;
    private final Color color;

    public Apple(final int size, final Color color) {
        this.size = size;
        this.color = color;
    }

    public static List<Apple> filterRedApples(final List<Apple> apples) {
        List<Apple> result = new ArrayList<>();

        for (final Apple apple : apples) {
            if (apple.color.equals(RED)) {
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

    public static void prettyPrintApple(final List<Apple> apples, final Function<Apple, String> function) {
        for (final Apple apple : apples) {
            String result = function.apply(apple);
            System.out.println(result);
        }
    }

    public boolean isRedApple(final Apple apple) {
        return apple.color.equals(RED);
    }

    public boolean isBigApple(final Apple apple) {
        return apple.size >= 50;
    }

    public int compareSize(final Apple otherApple) {
        return this.size - otherApple.size;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "size=" + size +
                ", color='" + color + '\'' +
                '}';
    }
}


public class CodeSendPractice {
    public static void main(String[] args) {
        // 1. Apple 리스트를 생성한다.
        List<Apple> apples = new ArrayList<>(List.of(
                new Apple(1, RED),
                new Apple(50, GREEN),
                new Apple(100, RED),
                new Apple(30, RED),
                new Apple(80, GREEN))
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

        // 사과 리스트를 인수로 받아 다양한 방법으로 문자열을 출력한다.
        // 6. Big Apple인지 출력한다.
        Apple.prettyPrintApple(apples, apple -> {
            if (apple.isBigApple(apple)) {
                return "big";
            }
            return "small";
        });

        // 7. 색과 크기를 출력한다.
        Apple.prettyPrintApple(apples, Apple::toString);

        // 8. Comparator로 크기순으로 정렬한다.
        List<Apple> tempApples = new ArrayList<>(apples);
        tempApples.sort(Apple::compareSize); // 오름차순
        tempApples.sort((apple, otherApple) -> -apple.compareSize(otherApple)); // 내림차순
        System.out.println(tempApples); // [Apple{size=1, color='RED'}, Apple{size=30, color='RED'}, Apple{size=50, color='GREEN'}, Apple{size=80, color='GREEN'}, Apple{size=100, color='RED'}]
    }
}

