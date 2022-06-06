package ch.unige.cui.rpg;
import java.util.Random;

public class LootBox<T extends Randomizable> {

    private final int gold;
    private final T item;

    public LootBox(Random rng, int maxGold, T item){
        int gold = rng.nextInt(maxGold);
        
        this.gold = gold;
        this.item = item;
    }

    public <U> LootBox(Random rng, int maxGold, T item, boolean rand, U maxChar){
        int gold = rng.nextInt(maxGold);
        
        this.gold = gold;

        if (rand) {
            this.item = (T) item.single(rng,maxChar);
        } else {
            this.item = item;
        }
    }

    public LootBox(){
        this.gold = 0;
        this.item = null;
    }

    public <U> LootBox<T> single(Random rng, T itemClass, U maxChar){
        T item = (T) itemClass.single(rng,maxChar);
        return new LootBox<T>(rng,16,item);
    }

    public int getGold(){
	   return this.gold;
    }

    public T getItem(){
	   return this.item;
    }

}
