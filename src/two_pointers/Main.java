package two_pointers;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите массив чисел с дубликатами (1 1 2 1 2 2 3 1 3 3):");
        String str = input.nextLine();

        String[] strArr = str.split(" ");
        int[] nums  = new int[strArr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strArr[i]);
        }
        Arrays.sort(nums);

        // Снова я использую алгоритм двух указателей, но в этот раз в формате одного массива
        // так как по условию я понял что здесь требуется максимально эффективное распределение
        // памяти, этот алгоритм выдаёт эффективность O(1) так как работает с одним массивом
        int i = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[j - 1]) {
                nums[i]  = nums[j];
                i++;
            }
        }

        // Происходит это так, мы идём по массиву и ищем когда число сменится, условно с единицы на двойку
        // как только это происходит, мы присваиваем последней единице из дубликатов единиц эту двойку
        // и пропускаем её позицию, повторяем так пока все уникальные числа не будут в начале
        // переменная i в конце также выполняет функцию длины нового массива, в конце я бы мог добавить все
        // уникальные значения в новый массив, но это бы повлияло на память, так что я их просто вывел
        System.out.println("Итоговый массив без дубликатов:");
        System.out.print("[");
        for (int j = 0; j < i; j++) {
            if (j > 0){
                System.out.print(" ");
            }
            System.out.print(nums[j]);
        }
        System.out.print("]");
    }
}