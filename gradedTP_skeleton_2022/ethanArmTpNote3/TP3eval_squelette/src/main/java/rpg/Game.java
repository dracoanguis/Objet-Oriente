package rpg;
import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Game {
	private static ArrayList<String> items = new ArrayList<String>();

	public static ArrayList<String> getItems(){
		return Game.items;//idealement on ferait une copie profonde "deep copy" mais on ne va pas le faire ici.
	}
	
	static ArrayList<String> readFile(String fn){
		ArrayList<String> tmp = new ArrayList<String>();
		try( var in = new BufferedReader(new FileReader(fn))) {
			String line = "";
			int i = 1;
			while ((line = in.readLine()) != null) {
			System.out.println(i + ": " + line );
			i++;
			tmp.add(line);
		}
	} catch( IOException e ) {
			System.err.println("Couldn't read, because:");
			System.err.println(e.getMessage());
		}
		return tmp;
	}

	public static void storeFileContentsForGame(String fn){
		items = readFile(fn);
	}

	//remplacer les Stream.empty() par ce qui est demande dans l enonce.
	public static Stream<Item> createManaPotionStream(){
		storeFileContentsForGame("./src/main/resources/potions.txt");
		var potionsList = new ArrayList<>(items);
		var potions = new ArrayList<Item>();
		for (String s: potionsList) {
			String[] arS = s.split(" ",3);
			if (arS[0].equals("Mana")){
				potions.add(new ManaPotion(Integer.parseInt(arS[1]),Integer.parseInt(arS[2])));
			}
		}
		return potions.stream();
	}

	public static Stream<Item> createHPPotionStream(){
		storeFileContentsForGame("./src/main/resources/potions.txt");
		var potionsList = new ArrayList<>(items);
		var potions = new ArrayList<Item>();
		for (String s: potionsList) {
			String[] arS = s.split(" ",3);
			if (arS[0].equals("Health")){
				potions.add(new HealingPotion(Integer.parseInt(arS[1]),Integer.parseInt(arS[2])));
			}
		}
		return potions.stream();
	}

	public static Stream<Item> filterManaPotionsByPrice(ArrayList<Item> items, int price){
		return items.stream().filter(p -> p instanceof ManaPotion).filter(mp -> mp.getPrice()<price);
	}

	public static Stream<Item> filterManaPotionsByMana(ArrayList<Item> items, int mana){
		var manaStream = items.stream().filter(p -> p instanceof ManaPotion).map(p -> (ManaPotion)p).filter(mp -> mp.getMana()>mana);
		Stream<Item> itemStream = manaStream.map(mp -> (Item)mp);
		return itemStream;
	}

	public static <T> void copy_a_b(ArrayList<? extends T> a, ArrayList<? super T> b){
		for (T i: a){
			b.add(i);
		}
	}
}
