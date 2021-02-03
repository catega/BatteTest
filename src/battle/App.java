package battle;

import java.util.ArrayList;
import java.util.Iterator;


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Character> charsP1 = new ArrayList<>();
		ArrayList<Character> charsP2 = new ArrayList<>();
		
		Character c1 = new Character("Char 1");
		charsP1.add(c1);
		Character c3 = new Character("Char 3");
		charsP1.add(c3);
		Character c5 = new Character("Char 5");
		charsP1.add(c5);
		Character c2 = new Character("Char 2");
		charsP2.add(c2);
		Character c4 = new Character("Char 4");
		charsP2.add(c4);
		
		/*c4.setAttack(10);
		c4.setDefense(10);*/
		
		Player p1 = new Player("Player 1", charsP1);
		Player p2 = new Player("Player 2", charsP2);
		
		System.out.println(charsP1);
		System.out.println(charsP2);
		
		battle(p1, p2);
	}
	
	static public boolean dodge(Character a) {
		return (int)(Math.random() * 100) <= (a.getSpeed() * 5) ? true : false;
	}
	
	// No fa falta tornar un int, era per a test
	static public int round(Character a, Character b) {
		if (!dodge(b)){
			if ((a.getAttack() + 10) < b.getDefense()) {
				b.getDamage(1);
				return 1;
			}else 
				b.getDamage((a.getAttack() + 10) - b.getDefense());
			
			if (b.getHealth() < 0)
				b.setHealth(0);
			
			return (a.getAttack() + 10) - b.getDefense();
		}
		
		return 0;
	}
	
	
	static public void fight(Character a, Character b) {
		boolean round = true;
		int damage = 0; //
		
		while (a.getHealth() > 0 && b.getHealth() > 0) {
			if (round)
				damage = round(a, b); //
			else
				damage = round(b, a); //
			
			// Test prints
			System.out.println(round ? a.getName() + " deals " + damage + " damage" : b.getName() + " deals " + damage + " damage");
			System.out.println(a.getName() + ": " + a.getHealth() + " | " + b.getName() + ": " + b.getHealth());
			round = !round;
		}
	}
	
	static public void removeDefeated(ArrayList<Character> a, ArrayList<Character> b) {
		Iterator<Character> i = a.iterator();
		while (i.hasNext()) {
		   Character c = i.next();
		   
		   if (c.getHealth() == 0)
				i.remove();
		}
		
		i = b.iterator();
		while (i.hasNext()) {
		   Character c = i.next();
		   
		   if (c.getHealth() == 0)
				i.remove();
		}
	}
	
	static public boolean checkChars(ArrayList<Character> characters) {
		for (Character c : characters) {
			if (c.getHealth() > 0)
				return true;		
		}
		
		return false;
	}
	
	static public void battle(Player player1, Player player2) {
		ArrayList<Character> at_chars = player1.getCharacters();
		ArrayList<Character> def_chars = player2.getCharacters();
		
		int rounds = 0, contA = 0, contB = 0;
		
		if (at_chars.size() > def_chars.size())
			rounds = def_chars.size() - 1;
		else
			rounds = at_chars.size() - 1;
		
		while (checkChars(at_chars) && checkChars(def_chars)) {
			for(int i = 0; i <= rounds; i++) {
				while (at_chars.get(contA).getHealth() > 0 && def_chars.get(contB).getHealth() > 0) {
					fight(at_chars.get(contA), def_chars.get(contB));
				}
				
				// Test print
				System.out.println(checkChars(at_chars) + " - " + checkChars(def_chars));
				if (checkChars(at_chars) && checkChars(def_chars)) {
					removeDefeated(at_chars, def_chars);
					
					if (contA >= at_chars.size() - 1)
						contA = 0;
					else
						contA++;
					
					if (contB >= def_chars.size() - 1)
						contB = 0;
					else
						contB++;
				}
				
				// Test prints
				System.out.println(at_chars);
				System.out.println(def_chars);
			}
			
			if (at_chars.size() > def_chars.size())
				rounds = def_chars.size() - 1;
			else
				rounds = at_chars.size() - 1;
			
		}
		
		// Cambiar el leader de la zona o no, depen de quí guanye
		if (checkChars(at_chars))
			System.out.println("Player 1 wins");
		else
			System.out.println("Player 2 wins");
	}

}
