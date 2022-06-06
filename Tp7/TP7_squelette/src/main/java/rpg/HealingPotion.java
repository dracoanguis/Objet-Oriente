package rpg;

public class HealingPotion implements Item{
	private int price;
	private int HP;
	
	public HealingPotion(int HP, int price){
	this.HP = HP;
	this.price = price;
	}

	public int getPrice(){
	return price;
	}

	@Override
	public String toString(){
	return "[HealingPotion: HP = "+String.valueOf(HP)+", price = "+String.valueOf(price)+"]";
	}
}
