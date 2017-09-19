import java.util.List;
import java.util.ArrayList;

public class HashTable<K,V>{
	private HashNode<K,V>[] hashTable;
	private List<K> keys;
	private List<V> values;

	public List<K> getKeys(){
		return keys;
	}
	public List<V> getValues(){
		return values;
	}

	@SuppressWarnings("unchecked")
	public HashTable(){
		hashTable = new HashNode[10];
		keys = new ArrayList<K>();
		values = new ArrayList<V>();
		for(int i =0;i<10;i++){
			hashTable[i] = new HashNode<K,V>();
		}
	}
	
	public int getHashKey(K key) {
		int hashKey = key.hashCode() % 10;
		if(hashKey < 0) {
			hashKey += 10;
		}
		return hashKey;
	}

	public void put(K key, V value){
		int tableKey = getHashKey(key);
		if(hashTable[tableKey].insert(key,value) == 1){
			keys.add(key);
			values.add(value);
		}else if(hashTable[tableKey].insert(key,value) == 2){
			values.set(keys.indexOf(key),value);
		}

	}

	public V get(K key){
		int tableKey = getHashKey(key);
		return hashTable[tableKey].get(key);
	}

	public void remove(K key){
		int tableKey = getHashKey(key);
		hashTable[tableKey].remove(key);
	}

	public boolean contains(K key){
		int tableKey = getHashKey(key);
		if(hashTable[tableKey].isKeypresent(key) != -1)
			return true;
		return false;
	}

	public static void main(String[] args){
		HashTable<String,Integer> table = new HashTable<String,Integer>();
		String arr[] = {"asif","raaja","asif"};
		for(int i = 0;i<arr.length;i++){
			if(table.contains(arr[i])){
				int temp = table.get(arr[i]) + 1;
				table.put(arr[i],temp);
			}else{
				table.put(arr[i],1);
			}
		}
		System.out.println(table.get("asif"));
		System.out.println(table.getKeys());
		System.out.println(table.getValues());

	}
}