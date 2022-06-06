package rpg;
import java.util.*;

public class Main{

	public static void main(String[] args){
	System.out.println("Successfully entered in main.");

	Buyer<Item> itemBuyer = new Buyer<>("itemBuyer",100);//100 gold

	ArrayList<HealingPotion> goods = new ArrayList<>();
	goods.add(new HealingPotion(8,3));
	goods.add(new HealingPotion(16,4));
	goods.add(new HealingPotion(32,5));
	Seller<HealingPotion> healingPotionVendor = new Seller<>("HPVendor",goods, 0);


	ArrayList<Item> goods2 = new ArrayList<>();
	goods2.add(new HealingPotion(64,6));
	goods2.add(new HealingPotion(128,7));
	goods2.add(new ManaPotion(256,8));
	Seller<Item> itemVendor = new Seller<>("itemVendor",goods2,0);

	//Signature of trade func: public static <T extends Item> boolean trade(Buyer<? super T> buyer, Seller<? extends T> seller, int goodsIndex)

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//transaction 1
	System.out.println("\n\n\n---------------------------------------------------------------------------------");
	
	System.out.println(">>>> BEFORE transaction 1 :");
	System.out.println("\nitemBuyer: "+itemBuyer.toString());
	System.out.println("\nhealingPotionVendor:"+healingPotionVendor.toString());

	int goodsIdx = 2;//index of an item in the vendor s goods list that is assumed to have been chosen by buyer (e.g. player)
	boolean transaction1 = Game.trade(itemBuyer, healingPotionVendor,goodsIdx);
	if(transaction1){
		Game.applyTransaction(healingPotionVendor, goodsIdx);
	}
	System.out.println("\n\n>>>> AFTER transaction 1 :");
	System.out.println("\nitemBuyer: "+itemBuyer.toString());
	System.out.println("\nhealingPotionVendor:"+healingPotionVendor.toString());

	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//transaction 2  (this one works without the ? wildcards in Game.trade)
	System.out.println("\n\n\n---------------------------------------------------------------------------------");
	
	System.out.println("\n\n>>>> BEFORE transaction 2 :");
	System.out.println("\nitemBuyer: "+itemBuyer.toString());
	System.out.println("\nitemVendor:"+itemVendor.toString());

	int goodsIdx2 = 2;//index of an item in the vendor s goods list that is assumed to have been chosen by buyer (e.g. player)
	boolean transaction2 = Game.trade(itemBuyer, itemVendor,goodsIdx2);
	if(transaction2){
		Game.applyTransaction(itemVendor, goodsIdx2);
	}
	System.out.println("\n\n>>>> AFTER transaction 2 :");
	System.out.println("\nitemBuyer: "+itemBuyer.toString());
	System.out.println("\nitemVendor:"+itemVendor.toString());

	
	}
}
