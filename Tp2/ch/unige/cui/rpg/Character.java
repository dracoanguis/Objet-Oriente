package ch.unige.cui.rpg;

public class Character{
	
	private final String name;
	private int currentHP;
	private final int maxHP;
	private final int armor;
	private int gold = 0;
	private Quest currentQuest = null;
	private boolean alive;

	public Character(String name, int maxHP, int armor) throws IllegalArgumentException {
		if(name == null ||  name.trim().isEmpty()){
			throw new IllegalArgumentException("Name is non-valid");
		}
		if (maxHP <= 0){
			throw new IllegalArgumentException("maxHP should be greater than 0");
		}
		if (armor < 0 ){
			throw new IllegalArgumentException("There is no cursed armor in this game");
		}
		this.name = name;
		this.maxHP = maxHP;
		this.currentHP = maxHP;
		this.armor = armor;
		this.alive = true;
	}

	public void wound(int damage) throws IllegalArgumentException {
		if (damage < 0){
			throw new IllegalArgumentException("damage should be at least 0");
		}

		if (alive && (damage-this.armor) > 0) {
			if ((this.currentHP - (damage-this.armor)) <= 0 ){
				this.currentHP = 0;
				alive = false;
			} else {
				this.currentHP -= (damage-this.armor);
			}
		}
	}

	public void heal(int hp) throws IllegalArgumentException {
		if (hp<0){
			throw new IllegalArgumentException("restored currentHP should not be negative");
		}

		if (alive){
			if ((this.currentHP+hp)>this.maxHP){
				this.currentHP = this.maxHP;
			} else {
				this.currentHP += hp;
			}
		}
	}

	public void startQuest(Quest q) throws IllegalArgumentException, IllegalStateException {
		if (q == null){
			throw new IllegalArgumentException("q should exist");
		}

		if (this.currentQuest != null){
			throw new IllegalStateException("There is already an active quest");
		}

		this.currentQuest = q;
	}

	public void failQuest() throws IllegalStateException {
		if (this.currentQuest == null){
			throw new IllegalStateException("You need a quest to fail a quest");
		}
		this.currentQuest = null;
	}

	public void accomplishQuest() throws IllegalStateException {
		if (this.currentQuest == null){
			throw new IllegalStateException("You need a quest to accomplish a quest");
		}
		this.gold += this.currentQuest.reward;
		this.currentQuest = null;
	}

	public String toString(){
		String status ="dead";
		if (alive){
			status = "alive";
		}

		String quest = "No current quest";
		if (this.currentQuest != null){
			quest = this.currentQuest.toString();
		}

		return ("Character Name: "+name
				+"\ncurrentHP: "+Integer.toString(this.currentHP)+"/"+Integer.toString(this.maxHP)+"\tStatus: "+status
				+"\nArmor: "+Integer.toString(this.armor)+"\tGold: "+Integer.toString(this.gold)
				+"\nQuest: "+quest);
	}

}