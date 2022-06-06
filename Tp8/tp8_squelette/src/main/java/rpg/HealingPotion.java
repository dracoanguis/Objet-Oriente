package rpg;
import java.util.Random;


public class HealingPotion implements Randomizable<HealingPotion>, Item{
	
	private final int healthPoints;
	private final int price;
	
	public HealingPotion(){
		this.healthPoints = 0;
		this.price = 0;
	}
	
	public HealingPotion( int HP, int price){
		this.healthPoints = HP;
		this.price = price;
	}

	public HealingPotion genItem(Random rng){
		//maxHPHP i.e. max HealingPotionHealthPoints is ''a game variable'' defined
		//in the static class Game, where the ''game engine'' static functions
		//(moteur de jeu) would be defined
		final int rndHPVal = (int) Math.round( rng.nextDouble()*(Game.maxHPHP - Game.minHPHP))+Game.minHPHP;
		return new HealingPotion(rndHPVal, (int) Math.round(rndHPVal/Game.priceConversionFactor));
	}

	public int getPrice(){
		return price;
	}

	@Override
	public String toString(){
		return "[ Healing potion: HP="+String.valueOf(healthPoints)+", price = " + String.valueOf(price)+" ]";
	}
}
