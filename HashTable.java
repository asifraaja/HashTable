import java.util.List;
import java.util.ArrayList;

/*
	Hash Table
*/
public class HashTable<K,V>{
	private HashNode<K,V>[] hashTable;
	private List<K> keys;
	private List<V> values;
	private static int HASHSIZE = 10;
/*
	returns all the keys of the hash table
*/
	public List<K> getKeys(){
		return keys;
	}
/*
	returns all the values
*/
	public List<V> getValues(){
		return values;
	}

	@SuppressWarnings("unchecked")
	public HashTable(){
		hashTable = new HashNode[HASHSIZE];
		keys = new ArrayList<K>();
		values = new ArrayList<V>();
		for(int i =0;i<10;i++){
			hashTable[i] = new HashNode<K,V>();
		}
	}
/*
	@params(key) = key sent.
	returns the index in which the key must be inserted
*/
	public int getHashKey(K key) {
		int hashKey;
		try{
			hashKey = key.hashCode() % HASHSIZE;
		}catch(NullPointerException e){
			throw new NullPointerException("Key cannot be null");
		}

		if(hashKey < 0) {
			hashKey += HASHSIZE;
		}
		return hashKey;
	}
/*
	@params(key) = key to inserted
	@params(value) = value to be inserted
	inserts (K,V) pair in hashtable
*/
	public void put(K key, V value){
		int tableKey = getHashKey(key);
		if(hashTable[tableKey].insert(key,value) == 1){
			keys.add(key);
			values.add(value);
		}else if(hashTable[tableKey].insert(key,value) == 2){
			values.set(keys.indexOf(key),value);
		}

	}
/*
	@params(key) = key
	returns the value for the specific Key
*/
	public V get(K key){
		int tableKey = getHashKey(key);
		return hashTable[tableKey].get(key);
	}
/*
	@params(key)
	removes the (K,V) pair based on Key
*/
	public void remove(K key){
		int tableKey = getHashKey(key);
		hashTable[tableKey].remove(key);
	}
/*
	@params(key)
	checks if key is present in hashTable
*/
	public boolean contains(K key){
		int tableKey = getHashKey(key);
		if(hashTable[tableKey].isKeypresent(key) != -1)
			return true;
		return false;
	}
}
