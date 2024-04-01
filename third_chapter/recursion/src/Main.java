public class Main {
    public static void main(String[] args) {
        countdown(5);
        System.out.println(factorial(6));
    }
    public static void countdown(int i) {
        System.out.println(i);
        if (i <= 1) // Базовый случай - функция перестает себя вызывать, чтобы предотвратить зацикливание
            return;
        else
            countdown(i-1); // Рекурсивный случай - функция вызывает саму себя
    }

    public static int factorial(int n) {
        if (n <= 1)
            return n;
        else
            return n*factorial(n-1);
    }
}
