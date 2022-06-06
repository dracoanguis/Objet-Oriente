package rpg;
import java.util.*;

//il faut garantir l existance de la methode getPrice()
public class Seller<T extends Item> implements Sell<T> {
	private final String name;
	private ArrayList<T> goods;//goods have a price field
	private int gold;

	//the merchant s goods are supposed to be initialized non empty
	public Seller(String name, ArrayList<T> goods, int gold){
		this.name = name;
		this.goods = goods;
		this.gold = gold;
	}

	public T sell(int idx){
		return goods.get(idx);
	}

	public void confirmTransaction(int idx){
		this.gold += this.goods.get(idx).getPrice();
		this.goods.remove(idx);
	}

	@Override
	public String toString(){
	   return "[ Seller: name = "+name+", goods:"+goods.toString()+", gold = "+String.valueOf(gold)+" ]";
	}
}
