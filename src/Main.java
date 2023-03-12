import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Задача на функциональное программирование
//        Напишите приложение, которое на входе получает через консоль текст, а в ответ выдает статистику:
//        1. Количество слов в тексте.
//        2. Топ-10 самых часто упоминаемых слов, упорядоченных по количеству упоминаний в
//        обратном порядке. В случае одинакового количества упоминаний слова должны быть отсортированы по алфавиту.

        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        if (string.isBlank() || string.isEmpty()) {
            System.out.println("no text, test mode :");
            string = "yourapp the quick brown fox jumps over the lazy dog";
            System.out.println(string);
        }

        String[] strings = string.split(" ");
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String s : strings
        ) {
            if (s.length() >= 1) {
                if (hashMap.containsKey(s)) {
                    int value = hashMap.get(s);
                    value++;
                    hashMap.put(s, value);
                } else {
                    hashMap.put(s, 1);
                }
            }
        }

        hashMap.entrySet()
                .stream()
                .sorted((o1, o2) -> {
                    if (o1.getValue() == o2.getValue())
                        return o1.getKey().compareTo(o2.getKey());
                    else if (o1.getValue() < o2.getValue())
                        return 1;
                    else return -1;
                })
                .limit(10)
                .forEach(System.out::println);
    }
}