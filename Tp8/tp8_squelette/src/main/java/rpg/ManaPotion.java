package rpg;
import java.util.Random;


public class ManaPotion implements Randomizable<ManaPotion>, Item{
    
    private final int manaPoints;
    private final int price;
    
    public ManaPotion(){
	this.manaPoints = 0;
	this.price = 0;
    }
    
    public ManaPotion( int mana, int price){
	this.manaPoints = mana;
	this.price = price;
    }

    public ManaPotion genItem(Random rng){
	//maxMPMP i.e. max ManaPotionManaPoints is ''a game variable'' defined
	//in the static class Game, where the ''game engine'' static functions
	//(moteur de jeu) would be defined
	final int rndMPVal = (int) Math.round( rng.nextDouble()*(Game.maxMPMP - Game.minMPMP))+Game.minMPMP;
	return new ManaPotion(rndMPVal, (int) Math.round(rndMPVal/Game.priceConversionFactor));
    }

    public int getPrice(){
	return price;
    }

    @Override
    public String toString(){
	return "[ Mana potion: mana = "+String.valueOf(manaPoints)+", price = " + String.valueOf(price)+" ]";
    }
}
