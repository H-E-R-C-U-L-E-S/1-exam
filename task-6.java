/* Java პროგრამა მონაცემთა სტრუქტურის შესაქმნელად
დავალება ითხოვდა მხოლოდ O(1) დროში ელემენტის წაშლის ოპერაციას 
თუმცა ამ შემთხვევაში შეგვიძლია

ა)ჩავსვათ ელემნტი
ბ)წავშალოთ ელემენტი
გ)მოვძებნოთ ელემენტი
დ)რენდომ ელემენტი ავიღოთ

*/

import java.util.*;

class MyDS{
ArrayList<Integer> arr;

HashMap<Integer, Integer> hash;

public MyDS(){
	arr = new ArrayList<Integer>();
	hash = new HashMap<Integer, Integer>();
}
	
void add(int x)
{
	if (hash.get(x) != null)
		return;

	int s = arr.size();
	arr.add(x);

	hash.put(x, s);
}

void remove(int x)
{

	Integer index = hash.get(x);
	if (index == null)
		return;

	hash.remove(x);

	int size = arr.size();
	Integer last = arr.get(size-1);
	Collections.swap(arr, index, size-1);


	arr.remove(size-1);

	hash.put(last, index);
	}


	int getRandom()
	{
	
	Random rand = new Random(); 
	int index = rand.nextInt(arr.size());

	
	return arr.get(index);
	}


	Integer search(int x)
	{
	return hash.get(x);
	}
}

public class Main
{
    // ელემენტის ჩასასმელად ვიყენებთ ფუნქციას  add,წასაშლელად remove,მოსაძებნად search,რენდომ მისაღებად getRandom
	public static void main (String[] args)
	{
		MyDS ds = new MyDS();
		ds.add(1);
		ds.add(2);
		ds.add(3);
		ds.add(4);
		ds.add(5);
	
		ds.remove(2);
	
		System.out.println("searched:"+ds.search(2));
		System.out.println("random:"+ds.getRandom());
	}
}
