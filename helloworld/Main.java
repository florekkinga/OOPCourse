import java.util.Scanner;
import java.util.Locale;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in).useLocale(Locale.US); 
		// w tym ^ przypadku kropki jako separator dziesiętny; domyślnie jest przecinek
		// aby zostawić przecinek wystarczy usunąć .useLocale(Locale.US) 
		// Locale.US to stała
		String s = scan.next();
		int i = scan.nextInt();
		double d = scan.nextDouble();
		System.out.printf("Wczytano %s , %d, %f", s, i, d);
	}
}
