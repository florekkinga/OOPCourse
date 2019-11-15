package lab1;

import java.util.Scanner;

public class Problem610A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        if(n%2!=0){
            System.out.print(0);
        }
        else{
            int result = n/ 4;
            if (n%4 == 0) result -= 1;
            System.out.print(result);
        }
    }
}
