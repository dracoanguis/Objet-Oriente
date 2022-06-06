package rpg;

public class ManaPotion implements Item{
	private int price;
	private int mana;
	
	public ManaPotion(int mana, int price){
	this.mana = mana;
	this.price = price;
	}

	public int getPrice(){
	return price;
	}

	@Override
	public String toString(){
	return "[ManaPotion: mana = "+String.valueOf(mana)+", price = "+String.valueOf(price)+"]";
	}
}
