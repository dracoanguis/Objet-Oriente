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
	// a completer
    }

    //remplacer les Stream.empty() par ce qui est demande dans l enonce.
    public static Stream<Item> createManaPotionStream(){
	return Stream.empty();
    }

    public static Stream<Item> createHPPotionStream(){
	return Stream.empty();
    }

    public static Stream<Item> filterManaPotionsByPrice(ArrayList<Item> items, int price){
	return Stream.empty();
    }

    public static Stream<Item> filterManaPotionsByMana(ArrayList<Item> items, int mana){
	return Stream.empty();
    }

    public static <T> void copy_a_b(ArrayList<? extends T> a, ArrayList<? super T> b){
	// a completer ...
    }
}
