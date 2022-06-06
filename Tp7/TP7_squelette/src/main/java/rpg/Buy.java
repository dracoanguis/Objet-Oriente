package rpg;

public interface Buy<T extends Item>{
	boolean buy(T item);
}
