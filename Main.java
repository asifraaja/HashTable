
public class Main{
	public static void main(String[] args){
		HashTable<String,Integer> table = new HashTable<String,Integer>();
		String arr[] = {"asif"};
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
