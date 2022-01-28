// java  პროგრამა n საფეხურებიან კიბეზე ასვლის ვარიანტებს იმ შემთხვევაში თუ შეგვიძლია ერთ მოქმედებაში 1 ან 2 საფეხურით ასვლა
import java.lang.*;
import java.util.*;

public class MyClass {

	public static int countStep(int n)
	{
		if ( n == 0)
			return 1;
		else if (n < 0)
			return 0;

		else
			return countStep(n - 1)	+ countStep(n - 2);
	}

	public static void main(String argc[])
	{
	    //n ის ადგილზე მითითეთ საფეხურების რაოდენობა
		int n = 3;
		System.out.println(countStep(n));
	}
}
