package battle;

public class Character {
	String name;
	int health, attack, defense, speed;
	
	public Character(String name) {
		this.name = name;
		this.attack = randomStat();
		this.defense = randomStat();
		this.speed = randomStat();
		this.health = 50;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void getDamage(int hit) {
		this.setHealth(this.getHealth() - hit);
	}

	public int randomStat() {
		return (int)(Math.random() * 3) + 1;
	}


	@Override
	public String toString() {
		return "[" + this.getName() + " - HP: " + this.getHealth() +  " | At: " + this.getAttack() + " | Def: " + this.getDefense() + "]";
	}
	
	
}
