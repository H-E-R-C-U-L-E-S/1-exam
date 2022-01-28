// Java პროგრამა რომელიც ამოწმებს არის თუ არა ფრჩხილები  მათემატიკურად სწორად დასმული
import java.util.*;
public class MyClass {

	static boolean areBracketsCorrect(String str)
	{
		//ამ შემთხვევაში ArrayDeque-ის გამოყენება უფრო უპრიანია, ვიდრე Stack კლასის გამომდინარე სისწრაფიდან
		Deque<Character> stack
			= new ArrayDeque<Character>();

		for (int i = 0; i < str.length(); i++)
		{
			char x = str.charAt(i);

			if (x == '(' || x == '[' || x == '{')
			{
				stack.push(x);
				continue;
			}

			if (stack.isEmpty())
				return false;
			char check;
			switch (x) {
			case ')':
				check = stack.pop();
				if (check == '{' || check == '[')
					return false;
				break;

			case '}':
				check = stack.pop();
				if (check == '(' || check == '[')
					return false;
				break;

			case ']':
				check = stack.pop();
				if (check == '(' || check == '{')
					return false;
				break;
			}
		}

		return (stack.isEmpty());
	}

	public static void main(String[] args)
	{
	    //string-ის მნიშვნელობად მიუთითეთ ფრჩხილების მიმდევრობა რომლის შემოწმებაც გსურთ
		String str = "([{}])(()";

		if (areBracketsCorrect(str))
			System.out.println(" მიმდევრობა სწორია");
		else
			System.out.println("მიმდევრობა არასწორია");
	}
}

