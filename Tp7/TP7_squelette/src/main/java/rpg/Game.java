package rpg;

//moteur du jeu
public class Game{
	//boolean indicates if transaction was successful or not
	/* if wildcards are removed, the following kind of errors occurs:
	   Game.java:17: error: type argument T#1 is not within bounds of type-variable T#2
	   public static <T> boolean trade(Buyer<T> buyer, Seller<T> seller, int goodsIndex){
	   ^
	   where T#1,T#2 are type-variables:
	   T#1 extends Object declared in method <T#1>trade(Buyer<T#1>,Seller<T#1>,int)
	   T#2 extends Item declared in class Buyer
	*/
	public static <T extends Item> boolean trade(Buyer<? super T> buyer, Seller<? extends T> seller, int goodsIndex){
		return buyer.buy(seller.sell(goodsIndex));
	}
	//on va considerer que la gestion du stock du vendeur se fait aussi par le moteur du jeu et apres la transaction
	//selon le resultat true/false son stock sera mis a jour
	public static <T extends Item> void applyTransaction(Seller<T> seller, int goodsIndex){
	   seller.confirmTransaction(goodsIndex);
	}
	
}
