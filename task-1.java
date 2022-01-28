// Java პროგრამა სიტყვის შესამოწმებლად პალინდრომია თუ არა

public class MyClass {

	// დააბრუნებს true-ს თუ სიტყვა პალინდრომია
	static boolean isPalindrome(String word)
	{

		int i = 0, j = word.length() - 1;

		while (i < j) {

			if (word.charAt(i) != word.charAt(j))
				return false;

			i++;
			j--;
		}

		return true;
	}

	public static void main(String[] args)
	{
		// შეიყვანეთ სიტყვა ან რიცხვი
		String word = " აქ ";
		
	
	if(word != null && !word.trim().isEmpty()) {
	 	if (isPalindrome(word))
			System.out.print("პალინდრომია");
		else
			System.out.print("არ არის პალინდრომი");   
	}
	else{
	    	System.out.print("შეყვანეთ სიტყვა");   
	}
	
	}
}
