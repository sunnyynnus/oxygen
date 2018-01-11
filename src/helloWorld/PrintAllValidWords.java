package helloWorld;

import java.util.*;

public class PrintAllValidWords{

	public static void main(String[] args){
		PrintAllValidWords obj = new PrintAllValidWords();
		
		Set<String> dict = new HashSet<>();
		dict.add("apple");
		dict.add("boy");
		dict.add("mango");
		String input = "obmppplaaeeyyg";
		System.out.println(obj.getAllValidWords(dict, input));
	}

	public Set<String> getAllValidWords(Set<String> dict, String input){
		
		if(dict == null || dict.size() ==0 || input == null || input.length()==0 ) return null;
		
		Set<String> out = new HashSet<>();
		Trie<String> trie = buildTrie(dict);
		
		int[] map = new int[256];
		for(int i=0; i< input.length(); i++){
			map[input.charAt(i)]++;
		}

		for(int i =0; i<256; i++){
			int[] cloneMap = map.clone();
			if(cloneMap[i] !=0 && trie.root.next[i] !=null){
				cloneMap[i]--;
				getAllValidWordsUtil(cloneMap, trie.root.next[i], String.valueOf((char)i), out);	
			}
		}	
		
		return out;
	}


	private void getAllValidWordsUtil(int[] map, Trie.Node<String> node, String str, Set<String> set){
		if(node.value !=null && node.value.equals(str)){
			set.add(str);
		}

		for(int i =0; i<256; i++){
			int[] cloneMap = map.clone();
			if(cloneMap[i] !=0 && node.next[i] !=null){
				cloneMap[i]--;
				getAllValidWordsUtil(cloneMap, node.next[i], str+String.valueOf((char)i), set);
			}
		}
	}

	public Trie<String> buildTrie(Set<String> dict){
		Trie<String> trie = new Trie<>();
		for(String str: dict){
			trie.insert(str, str);
		}

		return trie;
	}

	static class Trie<T>{
		
		private static final int CodeLen = 256;
		private Node<T> root;

		public Trie(){
			this.root = new Node<T>();
		}

		public void insert(String str, T value){
			Node<T> current = root;
			
			for(int i=0 ; i< str.length(); i++){
				if(current.next[str.charAt(i)] == null){
					current.next[str.charAt(i)] = new Node<T>();
				}
				current = current.next[str.charAt(i)];
			}

			current.value = value;
		}

		static class Node<T>{
			private T value;
			private Node<T>[] next;

			public Node(){
				this.next = new Node[CodeLen];
			}
		}

	}

}
