package group144.khodko;

import java.util.Comparator;
import java.util.Random;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class SecondPartTasks {

    private SecondPartTasks() {}

    // Найти строки из переданных файлов, в которых встречается указанная подстрока.
    public static List<String> findQuotes(List<String> paths, CharSequence sequence) {
        return paths.stream().filter(string -> string.contains(sequence)).collect(Collectors.toList());
    }

    // В квадрат с длиной стороны 1 вписана мишень.
    // Стрелок атакует мишень и каждый раз попадает в произвольную точку квадрата.
    // Надо промоделировать этот процесс с помощью класса java.util.Random и посчитать, какова вероятность попасть в мишень.
    public static double piDividedBy4() {
        class Shot{
            private Random randomizer = new Random();
            private double x = randomizer.nextDouble();
            private double y = randomizer.nextDouble();

            public boolean isHitTheTarget(){
                return x * x + y * y <= 1;
            }
        }

        final int SHOTS_NUMBER = 1000 * 1000;
        return (double) Stream.generate(Shot::new).limit(SHOTS_NUMBER).filter(Shot::isHitTheTarget).count() / SHOTS_NUMBER;
    }

    // Дано отображение из имени автора в список с содержанием его произведений.
    // Надо вычислить, чья общая длина произведений наибольшая.
    public static String findPrinter(Map<String, List<String>> compositions) {
        return compositions.entrySet().stream().max(Comparator.comparing(
                entry -> entry.getValue().stream().mapToInt(String::length).sum()
        )).get().getKey();
    }

    // Вы крупный поставщик продуктов. Каждая торговая сеть делает вам заказ в виде Map<Товар, Количество>.
    // Необходимо вычислить, какой товар и в каком количестве надо поставить.
    public static Map<String, Integer> calculateGlobalOrder(List<Map<String, Integer>> orders) {
        return orders.stream().flatMap(map -> map.entrySet().stream()).collect(
                Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        Integer::sum
                )
        );
    }
}