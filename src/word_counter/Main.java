package word_counter;/*
Программа на вход принимает строку(str) и количество совпадений(n), подсчитать какие слова встречаются (n) раз.
Результат вывести на экран.
Пример: hello world qwerty world; n = 2;
Результат: world
Имя проекта: word_counter
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = "";
        int n = 0;

        System.out.println("Введите строку (str):");
        str = input.nextLine();

        System.out.println("Введите число (n) для получения совпадений из (str):");
        n = input.nextInt();

        String[] words = str.split(" ");

        //
        Map<String, Integer> counter = new LinkedHashMap<>();
        for (String word : words) {
            if (word == null || word.isEmpty()){
                continue;
            }

            counter.put(word, counter.getOrDefault(word, 0) + 1);
        }

        // Здесь я беру все ключи из мапы counter что встречаются n раз в лист
        List<String> output = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : counter.entrySet()) {
            if (entry.getValue() == n){
                output.add(entry.getKey());
            }
        }

        // Лист я использовал потому что в (str) могло попасться множество слов с частотой появления (n)
        if (output.isEmpty()){
            System.out.printf("Слов что встречаются %d раз не существет\n", n);
        }else{
            System.out.printf("Слова что встречаются %d раз это: %s\n", n, String.join(" ", output));
        }
    }
}
