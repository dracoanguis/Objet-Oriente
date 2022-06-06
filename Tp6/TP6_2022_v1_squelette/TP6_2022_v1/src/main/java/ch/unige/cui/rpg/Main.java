package ch.unige.cui.rpg;
import java.util.Random;

public class Main{

	public static void main(String[] args){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ");

		Random rng = new Random(System.currentTimeMillis());
		System.out.println("Entered in Main().");

		LootBox<HealingPotion> lbh = new LootBox(rng,16,new HealingPotion(),true,100);

		HealingPotion h = lbh.getItem();
		int gold = lbh.getGold();

		System.out.println("Got item: "+h.toString()+" and got gold amount:"+String.valueOf(gold));

		LootBox<MageRobes> lbm = new LootBox(rng,16,new MageRobes(),true,75);

		MageRobes m = lbm.getItem();
		int gold2 = lbm.getGold();

		System.out.println("Got item: "+m.toString()+" and got gold amount: "+String.valueOf(gold2));

		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	}
}
