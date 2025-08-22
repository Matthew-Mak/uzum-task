package two_sums;

/*
Дан отсортированный массив целых чисел и целевая сумма.Необходимо написать алгоритм поиска двух чисел в массиве, которые в сумме равны целевой сумме. Результат вывести на экран.
Пример: [1,2,5,6,7,8] 	целевая сумма = 11;
Результат: 5+6 = 11
Имя проекта: two_sums
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int targetSum = 0;

        System.out.println("Введите набор уникальных чисел разделённых пробелом, которые будут отсортированы в массив (4 5 3 6 8 2):");
        String str = input.nextLine().trim();

        if (str.isEmpty()) {
            System.err.println("ERROR: массив пустой");
            return;
        }

        String[] strArr = str.split(" ");
        int[] nums = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            nums[i] = Integer.parseInt(strArr[i]);
        }
        Arrays.sort(nums);

        System.out.println("Введите целевую сумму:");
        targetSum = input.nextInt();

        // Здесь я используя метод двух указателей для поиска всех пар соответствующих условию и кладу их в лист
        // на мой взгляд этот метод здесь самый эффективный по количеству шагов.
        List<int[]> output = new ArrayList<>();
        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == targetSum) {
                output.add(new int[]{nums[i], nums[j]});
                i++;
                j--;
            }else if (sum < targetSum) {
                i++;
            }else{
                j--;
            }
        }

        if (output.isEmpty()) {
            System.out.println("Пар для требуемой суммы не найдено.");
        }else{
            System.out.println("Соответствующие пары:");
            for (int[] pair : output) {
                System.out.println(pair[0] + " + " + pair[1] + " = " + targetSum);
            }
        }
    }
}
