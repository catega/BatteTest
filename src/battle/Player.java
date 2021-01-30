package battle;

import java.util.ArrayList;

public class Player {
	String name;
	ArrayList<Character> characters;
	
	public Player(String name, ArrayList<Character> characters) {
		this.name = name;
		this.characters = characters;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Character> getCharacters() {
		return characters;
	}

	public void setCharacters(ArrayList<Character> characters) {
		this.characters = characters;
	}
	
	
}
