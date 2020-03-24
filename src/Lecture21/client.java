package Lecture21;

public class client {
	
	public static void main(String[] args) {
		Tries trie=new Tries();
		
		trie.addword("art");
		trie.addword("arts");
		trie.addword("bug");
		trie.addword("boy");
		trie.addword("sea");
		trie.addword("see");
		trie.addword("seen");
		
		trie.display();
		
		System.out.println(trie.search("art"));
		System.out.println(trie.search("artist"));
		
		
	}

}
