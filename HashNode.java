import java.util.List;
import java.util.ArrayList;

public class HashNode{
	List<KeyValue> hashList;

	public HashNode(){
		hashList = new ArrayList<KeyValue>();
	}

	private boolean isPresent(int key,int value){
		for(KeyValue temp : hashList){
			if(temp.getKey() == key && temp.getValue() == value)
				return true;
		}
		return false;
	}

	public int isKeypresent(int key){
		for(KeyValue temp : hashList){
			if(temp.getKey() == key)
				return hashList.indexOf(temp);
		}
		return -1;
	}

	public int insert(int key,int value){
		int index = -1;
		if(!isPresent(key,value)){
			KeyValue temp = new KeyValue();
			temp.setKey(key);
			temp.setValue(value);
			hashList.add(temp);
			System.out.println("New Key Value Added "+key + " "+value);
			return 1;
		}else if((index=isKeypresent(key))!=-1){
			KeyValue temp = hashList.get(index);
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

	public int get(int key){
		int index = isKeypresent(key);
		if(index!=-1){
			KeyValue temp = hashList.get(index);
			return temp.getValue();
		}
		return -1;
	}

	public void remove(int key){
		int index = isKeypresent(key);
		if(index!=-1){
			hashList.remove(index);
		}else{
			System.out.println("No such key");
		}
	}

}