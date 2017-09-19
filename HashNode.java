import java.util.List;
import java.util.ArrayList;

public class HashNode<K,V>{
	List<KeyValue> hashList;
	K key;
	V value;

	@SuppressWarnings("rawtypes")
	public <K,V> HashNode(){
		hashList = new ArrayList<KeyValue>();
	}

	private boolean isPresent(K key,V value){
		for(KeyValue<K,V> temp : hashList){
			if(temp.getKey() == key && temp.getValue() == value)
				return true;
		}
		return false;
	}

	public int isKeypresent(K key){
		for(KeyValue<K,V> temp : hashList){
			if(temp.getKey() == key)
				return hashList.indexOf(temp);
		}
		return -1;
	}

	public int insert(K key,V value){
		int index = -1;
		if((index = isKeypresent(key))==-1){
			KeyValue<K,V> temp = new KeyValue<K,V>();
			temp.setKey(key);
			temp.setValue(value);
			hashList.add(temp);
			System.out.println("New Key Value Added "+key + " "+value);
			return 1;
		}else if((index=isKeypresent(key))!=-1){
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

	public V get(K key){
		int index = isKeypresent(key);
		if(index!=-1){
			KeyValue<K,V> temp = hashList.get(index);
			System.out.println("Returning "+temp.getValue());
			return temp.getValue();
		}
		return null;
	}

	public void remove(K key){
		int index = isKeypresent(key);
		if(index!=-1){
			hashList.remove(index);
		}else{
			System.out.println("No such key");
		}
	}

}