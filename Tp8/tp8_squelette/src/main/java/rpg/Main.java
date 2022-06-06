package rpg;
//import java.util.Random;
import java.util.*;
import java.util.stream.*;

public class Main{
	//expr lambda: delarer apres public class ...
	//mais pas dans la method main(..)
	public static RandomGenerator<HealingPotion> emptyHPGen(){ return (Random rng) -> {return new HealingPotion();};}

	//il faudra, a un moment donne, dans cette implementation, appeler la methode genItem(...) pour effectivement generer un item
	public static RandomGenerator<HealingPotion> anonymous_healingPotionRG(HealingPotion hp)  {
		return new RandomGenerator<>() {
			public HealingPotion single(Random rng){
				return hp.genItem(rng);
			}
		};
	}

	//ceci fait la meme chose que la declaration en haut mais avec un expression lambda
	public static RandomGenerator<HealingPotion> lambda_healingPotionRG(HealingPotion hp){
		return (Random rng) -> {return hp.genItem(rng);};
	}
	
	public static void main(String[] args){
	Random gameRNG = new Random(System.currentTimeMillis());
	//emptyHPGen est une fonction donc meme si elle ne prend pas d args en l occurence il faut l appeler
	//avec les () puis le . pour acceder a la methode single de l object RandomGenerator renvoye.
	HealingPotion emptyPotion = emptyHPGen().single(new Random(System.currentTimeMillis()) );

	//REM: le constructeur vide HealingPotion() renvoie une potion "vide" i.e. HP=0 price=0
	HealingPotion potionAnonyme = anonymous_healingPotionRG(new HealingPotion()).single(gameRNG);

	HealingPotion potionLambda = lambda_healingPotionRG(new HealingPotion()).single(gameRNG);
	
	System.out.println("potion vide: "+emptyPotion.toString());
	System.out.println("potion anonyme: "+potionAnonyme.toString());
	System.out.println("potion lambda: "+potionLambda.toString());
	
	System.out.println("-------------------------------------------");
	System.out.println("-------------------------------------------");
	
	ArrayList<HealingPotion> goods = new ArrayList<>();
	for(int i=0;i<100;i++){
		goods.add(lambda_healingPotionRG(new HealingPotion()).single(gameRNG));
	}

	System.out.println("goods : "+goods.toString());

	System.out.println("-------------------------------------------");
	System.out.println("-------------------------------------------");

	
	int priceLimit1 = 2;
	//filter items with price <= priceLimit
	var priceFilter_leqPrLimit1 = goods.stream()
										.filter( hp -> hp.getPrice()<= priceLimit1 );

	System.out.println("\nGoods with price <= "+String.valueOf(priceLimit1)+" :");

	System.out.println(priceFilter_leqPrLimit1.collect(Collectors.toList()));



	/////////////////////////////////////////////////
	// map( Function<? super T,? extends R> f ) is based on: Function interface
	//cf cours 08-ClassesFonctionsAnonymes.pdf sl. 29
	//PECS => Function prend en arg un type T et retourne en sortie un type R
	//(et l'interf Function, i.e. interface fonctionnelle n a qu une seule fonction)
	var totalGoodsValue = goods.stream()
								.mapToInt(hp -> hp.getPrice())
								.sum();

	System.out.println("\nTotal goods value in gold: "+String.valueOf(totalGoodsValue));


	var totalGoldVal_3FirstItems = goods.stream()
										.limit(3)
										.mapToInt(hp -> hp.getPrice())
										.sum();

	System.out.println("\nTotal gold value of 3 first items: "+String.valueOf(totalGoldVal_3FirstItems));


	var mediumPriceOfItem = goods.stream()
									.collect(Collectors.averagingInt(hp -> hp.getPrice()));

	System.out.println("\nmediumPriceOfItem = "+String.valueOf(mediumPriceOfItem));
	}
}
