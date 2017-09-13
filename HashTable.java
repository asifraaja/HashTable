import java.util.List;
import java.util.ArrayList;

public class HashTable{
	private HashNode[] hashTable;
	private List<Integer> keys;
	private List<Integer> values;

	public List<Integer> getKeys(){
		return keys;
	}
	public List<Integer> getValues(){
		return values;
	}

	public HashTable(){
		hashTable = new HashNode[10];
		keys = new ArrayList<Integer>();
		values = new ArrayList<Integer>();
		for(int i =0;i<10;i++){
			hashTable[i] = new HashNode();
		}
	}

	public void put(int key, int value){
		int tableKey = key % 10;
		if(hashTable[tableKey].insert(key,value) == 1){
			keys.add(key);
			values.add(value);
		}else if(hashTable[tableKey].insert(key,value) == 2){
			values.set(keys.indexOf(key),value);
		}

	}

	public int get(int key){
		int tableKey = key % 10;
		return hashTable[tableKey].get(key);
	}

	public void remove(int key){
		int tableKey = key % 10;
		hashTable[tableKey].remove(key);
	}

	public boolean contains(int key){
		int tableKey = key % 10;
		if(hashTable[tableKey].isKeypresent(key) != -1)
			return true;
		return false;
	}

	public static void main(String[] args){
		HashTable table = new HashTable();
		int arr[] = {3,3,3,3,1,2,3,4,5,5,4,4,3,2};
		for(int i = 0;i<arr.length;i++){
			if(table.contains(arr[i])){
				int temp = table.get(arr[i]) + 1;
				table.put(arr[i],temp);
			}else{
				table.put(arr[i],1);
			}
		}
		System.out.println(table.get(3));
		System.out.println(table.getKeys());
		System.out.println(table.getValues());

	}
}