/*
11.2Write a method to sort an array of Strings so that all the anagrams
are next to each other
*/

void sortAnagrams(String[] array){

	HashTable<String, LinkedList<String>> table = new HashTable<String, LinkedList<String>>();

	//put all strings in the array into the HashTable, 
	//the key is the sorted char
	for(String s: array){
		String key = sortChars(s);

		if(!table.containsKey(key)){
			LinkedList<String> list = new LinkeList<String>();
			list.addLast(s);
			table.put(key, list);
		}
		else{
			LinkedList<String> list = table.get(key);
			list.addLast(s);
		}
	}
	//covert the HashTable into array
	int index =0;
	for(String key: table.keySet()){
		LinedList<String> list =  table.get(key);

		for(String s : list){
			array[index] = s;
			index++;
		}
	}

}

String sortChars(String s){
	char[] chars = s.toCharArray();
	Arrays.sort(chars);
	return new String(chars);
}
