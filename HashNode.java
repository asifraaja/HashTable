import java.util.List;
import java.util.ArrayList;

public class HashNode<K,V>{
	List<KeyValue> hashList;
	K key;
	V value;
/*
	initializes list of keyvalue
*/
	@SuppressWarnings("rawtypes")
	public <K,V> HashNode(){
		hashList = new ArrayList<KeyValue>();
	}
/*
	@params(key,value)
	checks if (K,V) pair present or not
*/
	private boolean isPresent(K key,V value){
		for(KeyValue<K,V> temp : hashList){
			if(temp.getKey() == key && temp.getValue() == value)
				return true;
		}
		return false;
	}
/*
	@param(key)
	returns if key is present in hashList
*/
	public int isKeypresent(K key){
		for(KeyValue<K,V> temp : hashList){
			if(temp.getKey() == key)
				return hashList.indexOf(temp);
		}
		return -1;
	}
/*
	@params(K,V)
	inserts (K,V) pair into hashList
*/
	public int insert(K key,V value){
		int index = -1;
		if((index = isKeypresent(key))==-1){
			// if (K,V) not already present add a new (K,V) pair
			KeyValue<K,V> temp = new KeyValue<K,V>();
			temp.setKey(key);
			temp.setValue(value);
			hashList.add(temp);
			System.out.println("New Key Value Added "+key + " "+value);
			return 1;
		}else if((index=isKeypresent(key))!=-1){
			// if (Key) is already present. change the value for the key
			KeyValue<K,V> temp = hashList.get(index);
			temp.setValue(value);
			hashList.remove(index);
			hashList.add(temp);
			System.out.println("Modified Key Value Added "+key + " "+value);
			return 2;
		}else{
			System.out.println("Key and value already same");
			return 0;
		}
	}
/*
	returns the value
*/
	public V get(K key){
		int index = isKeypresent(key);
		if(index!=-1){
			KeyValue<K,V> temp = hashList.get(index);
			System.out.println("Returning "+temp.getValue());
			return temp.getValue();
		}
		return null;
	}
/*
	removes the (K,V)
*/
	public void remove(K key){
		int index = isKeypresent(key);
		if(index!=-1){
			hashList.remove(index);
		}else{
			System.out.println("No such key");
		}
	}

}
