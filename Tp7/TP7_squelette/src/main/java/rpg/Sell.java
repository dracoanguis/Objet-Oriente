package rpg;

public interface Sell<T extends Item >{
	T sell(int goodsIndex);
}
