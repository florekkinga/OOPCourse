package lab1;
import java.util.Scanner;
public class Problem115A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj liczbę pracowników");
        int n = scan.nextInt();

        int[] arr = new int[n + 1];
        arr[0] = 0;
        int managed;
        int result = 0;

        for (int i = 1; i <= n; i++) {
            System.out.printf("Podaj managera pracownika %d\n", i);
            arr[i] = scan.nextInt();

            managed = 0;
            int manager = arr[i];

            while(manager != -1){
                manager = arr[manager];
                managed += 1;
            }
            result = Math.max(result, managed);
            System.out.println(result);

        }
        System.out.println(result + 1);
    }
}