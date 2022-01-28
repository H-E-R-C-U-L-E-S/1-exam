// Java პროგრამა უმცირესი დადებითი  რიცხვის საპოვნელად რომელიც არ შედის მასივში
import java.util.*;
public class MyClass {

	static int way(int[] A)
	{
		int n = A.length;

		boolean[] present = new boolean[n + 1];

		for (int i = 0; i < n; i++) {

			if (A[i] > 0 && A[i] <= n)
				present[A[i]] = true;
		}

		for (int i = 1; i <= n; i++)
			if (!present[i])
				return i;

		return n + 1;
	}

	public static void main(String[] args)
	{
	    //A სიაში შეიყვანეთ სასურველი რიცხვები და გამოყავით მძიმით ერთმანეთისგან
		int A[] = {1,2,3,4,5,6,7,8,9,-10,-1,23,12};
		System.out.println(way(A));
	}
}
