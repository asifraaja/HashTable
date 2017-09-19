public class KeyValue<K,V>{
	private K key;
	private V value;

	@SuppressWarnings("hiding")
	public <K,V> KeyValue(){
		key = null;
		value = null;
	}

	public void setKey(K key){
		this.key = key;
	}
	public void setValue(V value){
		this.value = value;
	}

	public K getKey(){
		return this.key;
	}
	public V getValue(){
		return this.value;
	}
}