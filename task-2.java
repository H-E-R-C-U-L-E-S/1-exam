//java პროგრამა საჭირო მონეტების მინიმალური რაოდენობის  საპოვნელად

public class MyClass {
	// L არის იმ მონეტების რაოდენობა რომლებიც გვაქვს ამ შემთხვევაში 5
	// M არის თანხა რომლის დახურდავებაც გვსურს
	
	static int minAmounOfCoins(int coins[], int L, int M)
	{
	
		int table[] = new int[M + 1];

		table[0] = 0;

		for (int i = 1; i <= M; i++)
		table[i] = Integer.MAX_VALUE;

		for (int i = 1; i <= M; i++)
		{
			for (int j = 0; j < L; j++)
			if (coins[j] <= i)
			{
				int sub_res = table[i - coins[j]];
				if (sub_res != Integer.MAX_VALUE
					&& sub_res + 1 < table[i])
					table[i] = sub_res + 1;
			}
		}
	
		if(table[M]==Integer.MAX_VALUE)
			return -1;
	
		return table[M];
		
	}

	public static void main (String[] args)
	{
		int coins[] = {1,5,10,20,50};
		int L = coins.length;
		//M-ის მნიშვნელობად მიუთითეთ დასახურდავებელი თანხის ოდენობა
		int M = 0;
		System.out.println ( "თანხის დასახურდავებლად საჭიროა მინიმუმ " + minAmounOfCoins(coins, L, M) + " მონეტა");
	}
}