//java მონაცემთა სტრუქტურა რომელიც გვაძლევს საშუალებას O(1) დროში წავშალოთ ელემენტი
//დავალება არ ითხოვდა თუმცა მონაცემთა სტრუქტურა საშუალებას გვაძლევს  არამარტო წავშალოთ არამედ ჩავსვათ და  მივიღოთ ყველაზე ხშირად გამოყენებული ელემენტი
import java.util.*;
 
class Node {
	int value;
	Node prev;
	Node next;
	HashSet<Integer> set;
 
	public Node(int v){
		value = v;
		set = new HashSet<Integer>();
	}
 
	public String toString(){
		return value + ":" + set.toString();
	}
}
 
public class FrequentCollection {	
 
	HashMap<Integer, Node> map;
	Node head, tail;
 

	public FrequentCollection() {
		map = new HashMap<Integer, Node>();
	}
 
	public void insert(int val) {
		if(map.containsKey(val)){
			Node n = map.get(val);
			n.set.remove(val);
 
			if(n.next!=null){
				n.next.set.add(val); 
				map.put(val, n.next);
			}else{
				Node t = new Node(n.value+1);
				t.set.add(val);
				n.next = t;
				t.prev = n;
				map.put(val, t);
			}
 
			
			if(head.next!=null)
				head = head.next;
		}else{
			if(tail==null||head==null){
				Node n = new Node(1);
				n.set.add(val);
				map.put(val, n);
 
				head = n;
				tail = n;
				return;
			}
 
			if(tail.value>1){
				Node n = new Node(1);
				n.set.add(val);
				map.put(val, n);
				tail.prev = n;
				n.next = tail;
				tail = n;
			}else{
				tail.set.add(val);
				map.put(val, tail);
			}
 
		}
 
 
	}
 
	public void remove(int val) {
		Node n = map.get(val);
		n.set.remove(val);
 
		if(n.value==1){
			map.remove(val);
		}else{
			n.prev.set.add(val);
			map.put(val, n.prev);
		}
 
 
		while(head!=null && head.set.size()==0){
			head = head.prev;
		}
 
 
	}
 
	public int getMostFrequent() {
		if(head==null)
			return -1;
		else
			return head.set.iterator().next();
	}
 
	public static void main(String[] args) {
		FrequentCollection fc = new FrequentCollection();
		//ჩავსვათ ელემტი
		fc.insert(1);
		fc.insert(1);
		fc.insert(2);
		fc.insert(1);
		fc.insert(1);
		fc.insert(1);
		fc.insert(2);
		fc.insert(2);
 
 //შევამოწმოთ ყველაზე ხშირად გამოყენებული ელემენტი
	System.out.println("ყველაზე ხშირად გამოყენებული ელემენტი:"+fc.getMostFrequent());
	
	//წავშალოთ ელემენტი
		fc.remove(1);
		fc.remove(1);
		fc.remove(1);
		//შევამოწმოთ ყველაზე ხშირად გამოყენებული ელემენტი
		System.out.println("ყველაზე ხშირად გამოყენებული ელემენტი:"+fc.getMostFrequent());
 
	}
}