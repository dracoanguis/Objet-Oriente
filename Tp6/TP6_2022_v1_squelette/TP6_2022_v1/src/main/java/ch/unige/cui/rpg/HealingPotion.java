package ch.unige.cui.rpg;
import java.util.Random;

public class HealingPotion implements Randomizable {
    
    private final int hp;

    public HealingPotion(int hp){
	   this.hp = hp;
    }

    public HealingPotion(){
        this.hp = 0;
    }

    public HealingPotion single(Random rng, int maxHp){
        int hp = rng.nextInt(maxHp);
        return new HealingPotion(hp);
    }

    @Override
    public String toString(){
    	return "[ Healing potion: HP="+String.valueOf(this.hp)+" ]";
    }
}
