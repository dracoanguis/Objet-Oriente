package rpg;
import java.util.Random;

public interface RandomGenerator<T>{
    public T single(Random rng);
}
