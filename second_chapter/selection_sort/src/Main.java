public class Main {
    public static void main(String[] args) {
        int[] a = new int[] {43, 78, 52, 36, 19, 94, 61, 20, 83, 57, 11, 48,
                97, 73, 27, 15, 88, 65, 30, 9, 50, 13, 39, 7, 23, 103, 69, 32, 18, 80,
                55, 16, 42, 90, 66, 35, 22, 85, 59, 12, 46, 92, 67, 33, 21, 81, 56, 17, 41,
                96, 72, 26, 14, 87, 64, 31, 10, 51, 29, 8, 40, 91, 68};
        // Вывод массива до сортировки
        System.out.println("Было: ");
        for (int c : a)
            System.out.print(c + " ");
        System.out.println();
        selectionSort(a);
        // Вывод массива после сортировки
        System.out.println("Стало: ");
        for (int c : a)
            System.out.print(c + " ");

    }

    /**
     * Алгоритм сортировки выбором
     * @param a На вход подается массив чисел
     */

    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length-1; i++) {
            int smallestIndex = i; // Считаем, что самый маленький индекс самый первый
            for (int j = i + 1; j < a.length; j++){ // Начинаем сравнивать с другими элементами
                if (a[smallestIndex] > a[j]){
                    smallestIndex = j;
                }
            }

            // Поменять элементы местами
            if (smallestIndex != i){
                int temp = a[i];
                a[i] = a[smallestIndex];
                a[smallestIndex] = temp;
            }
        }
    }
}