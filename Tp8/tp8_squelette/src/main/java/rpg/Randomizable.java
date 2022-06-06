package rpg;
import java.util.Random;

//Randomizable<? extends T> : interface Randomizable utilise (dans sa declaration),
//autrement dit, requiert l usage de,  un type generique T, qui lui-meme doit
//implementer cette meme interface Randomizable (pour garantir que ce type T possede la methode genItem)
//qui elle-meme (l interf Randomizable) - comme on vient de le dire - utilise ce type meme type generique T qui doit impl...
//De plus: on peut constater que cette interface a une methode unique qui renvoie le type generique en arg de retour, alors
//il s'agit d'un 'producteur' au sens 'PECS' donc ProducerExtends => n importe quel type qui extends T est acceptable i.e., <? extends T>
public interface Randomizable<T extends Randomizable<? extends T>> {
    public T genItem(Random rng);
}
