import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[] {1,3,5,7,9};
        System.out.println("Индекс элемента = " + binary_search(array,5));
        System.out.println("Индекс элемента = " + binary_search(array,11));
        System.out.println("--------------------------------------------------");

        // Тест для более детального сравнения времени и кол-ва операций
        // Отсортированный массив из уникальных элементов


        int[] big_array = new int[10000000];
        ArrayList<Integer> big_list = new ArrayList<>();
        for (int i = 0; i <big_array.length; i++)
            big_list.add(i+1);
        for (int i = 0; i < big_array.length; i++)
            big_array[i] = big_list.get(i);

        //Генерация случайного числа для поиска
        Random random = new Random();
        int randomNumber = random.nextInt(big_array[big_array.length-1] - big_array[0] + 1) + big_array[0];
        System.out.println("Случайное число = " + randomNumber);

        //Засекаю время поиска через бинарный поиск
        long startTime = System.nanoTime();
        binary_search(big_array,randomNumber); // Важно ! Кол-во операций = log2(n)
        long endTime = System.nanoTime();
        long timeBinarySearch = endTime - startTime;
        System.out.println("Время бинарного поиска = " + timeBinarySearch + " наносекунд");

        //Засекаю время поиска через простой поиск
        long startTime1 = System.nanoTime();
        simple_search(big_array,randomNumber);
        long endTime1 = System.nanoTime();
        long timeSimpleSearch = endTime1 - startTime1;
        System.out.println("Время простого поиска = " + timeSimpleSearch + " наносекунд");

    }

    /**
     * Алгоритм бинарного поиска + небольшой апгрейд - количество операций для более детального сравнения
     * @param arr Отсортированный массив
     * @param item Элемент, который мы бы хотели найти
     * @return Индекс элемента
     */
    public static int binary_search(int[] arr, int item) {
        int low = 0; // Нижняя граница массива
        int high = arr.length-1; // Верхняя граница поиска
        int operationsCount = 0; // Кол-во операций
        while (low <= high) { // Пока мы не сократим диапазон до 1 элемента
            operationsCount++;
            int mid = (low + high)/2; // Средний элемент
            int guess = arr[mid]; // Предполагаемый элемент
            if (guess == item) { // Если совпало
                System.out.println("Количество операций = " + operationsCount);
                return mid;
            }
            if (guess > item)  // Если много
                high = mid - 1;
            else // Если мало
                low = mid + 1;
        }
        return -1; // На случай, если не найдем нужного значения
    }

    /**
     * Простой поиск (в лоб, либо же тупой)
     * @param arr Отсортированный массив
     * @param item Элемент, который мы бы хотели найти
     * @return Индекс элемента
     */
    public static int simple_search (int[] arr, int item) {
        int operationsCount = 0;
        for (int i = 0 ; i < arr.length; i++) {
            operationsCount++;
            if (arr[i] == item) {
                System.out.println("Количество операций = " + operationsCount);
                return i;
            }
        }
        return -1;
    }
}