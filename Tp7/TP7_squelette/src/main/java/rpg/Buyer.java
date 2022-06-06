package rpg;
import java.util.*;

//il faut garantir l existance de la methode getPrice()
public class Buyer<T extends Item> implements Buy<T> {
	 private final String name;
	 private ArrayList<T> backpack;
	 private int gold;

	 public Buyer(String name, int gold){
		this.name = name;
		//backpack initially empty
		backpack = new ArrayList<T>();
		this.gold = gold;
	 }
	 
	 public boolean buy(T item){
		int itemPrice = item.getPrice();
		if(itemPrice <= this.gold){
			this.gold -= itemPrice;
			this.backpack.add(item);
			return true;
		}
		return false;
	 }

	 @Override
	 public String toString(){
		return "[ Buyer: name = "+name+", backpack:"+backpack.toString()+", gold = "+String.valueOf(gold)+" ]";
	 }
}
