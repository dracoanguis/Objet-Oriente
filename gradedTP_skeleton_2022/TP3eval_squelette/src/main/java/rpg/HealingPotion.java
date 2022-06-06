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

    public int getHP(){
	return HP;
    }

    @Override
    public String toString(){
	return "[HealingPotion: health="+String.valueOf(HP)+", price="+String.valueOf(price)+"]";
    }
}
