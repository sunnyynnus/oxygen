package junk;
/**
	Trie implementation based on Sedgewick lecture/work
**/
public class TrieApp
{
	private static final int N=256;

	private static class Node
	{
		Object value;
		Node next[]=new Node[N];
	}

	public static class Trie<V>
	{
		static Node root;
	
		public Trie()
		{
			root=null;
		}
	
		public void put(String key, V value)
		{
			root=put(root, key, value, 0);
		}

		private Node put(Node current, String key, V value, int d)
		{
			if(current==null)
			{
				current= new Node();
			}
			
			if(key.length()==d)
			{
				current.value=value;
				return current;
			}
			
			char ch=key.charAt(d);
			current.next[ch]=put(current.next[ch], key, value, d+1);
			
			return current;
		}
		/*
		public V get(String key)
		{
			V value=null;
			System.out.println(key);
			return value;
		}
		*/
		public String longestPrefix(String input)
		{
			int len= longestPrefixLen(root, input, 0);
			return input.substring(0, len);
		}
		
		private int longestPrefixLen(Node current, String input, int d)
		{
			if(current==null)
			{
				return (d==0? 0: d-1);	
			} 
			//if()
			if(input.length()==d)
			{
				return d;
			}
			char ch= input.charAt(d);
			return longestPrefixLen(current.next[ch], input, d+1);
		}
	
	}

	public static void main(String[] args)
	{
		Trie<Integer> trie= new Trie<>();
		trie.put("abc", 2);
		trie.put("apz", 4);
		System.out.println(trie.longestPrefix("app"));
				
	}

}
