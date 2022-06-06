package ch.unige.cui.rpg;

public class Character{
	
	private final String name;
	private int currentHP;
	private final int maxHP;
	private final ProtectionStack armor;
	private int gold = 0;
	private Quest currentQuest = null;
	private boolean alive;

	public Character(String name, int maxHP, ProtectionStack armor) throws IllegalArgumentException {
		if(name == null ||  name.trim().isEmpty()){
			throw new IllegalArgumentException("Name is non-valid");
		}
		if (maxHP <= 0){
			throw new IllegalArgumentException("maxHP should be greater than 0");
		}
		if (armor == null ){
			throw new IllegalArgumentException("There should at least be an empty ProtectionStack");
		}
		this.name = name;
		this.maxHP = maxHP;
		this.currentHP = maxHP;
		this.armor = armor;
		this.alive = true;
	}

	public void wound(Damage damage) throws IllegalArgumentException {

		if (damage == null){
			throw new IllegalArgumentException("Damage should exist enven if all are 0");
		}

		Damage ndmg = this.armor.absorb(damage);
		int idmg = ndmg.getDamage();

		if (alive){
			if (idmg >= this.currentHP){
				this.currentHP = 0;
				this.alive = false;
			} else {
				this.currentHP -= idmg;
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
		String status = "dead";
		if (alive){
			status = "alive";
		}

		String quest = "No current quest";
		if (this.currentQuest != null){
			quest = this.currentQuest.toString();
		}

		return (String.format("Character  Name: %s\ncurrentHP: %d/%d\tStatus: %s\nArmor: %s\nGold: %d\nQuest: %s",
				this.name,this.currentHP,this.maxHP,status,this.armor.toString(),this.gold,quest));

	}

}