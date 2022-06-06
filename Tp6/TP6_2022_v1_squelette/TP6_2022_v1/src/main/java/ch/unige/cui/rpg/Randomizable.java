package ch.unige.cui.rpg;
import java.util.Random;

public interface Randomizable<T,U>{
    public T single(Random rng, U maxChar);
}
