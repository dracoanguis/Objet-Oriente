package ch.unige.cui.game;
import ch.unige.cui.rpg.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.io.*;

public class Game{

    //helper function cf. cours#4, p. 25
    public static ArrayList<Quest> readQuestFile(String filename){
	ArrayList<Quest> quests = new ArrayList<Quest>();
	try( var in = new BufferedReader(new FileReader(filename))) {
	    String line = "";
	    int i = 1;
	    while ((line = in.readLine()) != null) {
		System.out.println(i + ": " + line );
		i++;
		quests.add(new Quest(line.split(",")[0],Integer.parseInt(line.split(",")[1])));
	    }
	} catch( IOException e ) {
	    System.err.println("Couldn't read, because:");
	    System.err.println(e.getMessage());
	}
	return quests;
    }
    
    
    public static void main(String[] args){
	
	String filename = "./src/main/resources/quests.txt";
	ArrayList<Quest> quests = readQuestFile(filename);
	
	//File directory = new File("./");
	//to show what absolute path is actually seen by Java for ./
	//System.out.println(">>>>>>>> "+directory.getAbsolutePath());
	
	//armorVal=75,weight=27 [kg?]
	ChainMail scarletChestpieceOfTheBoar = new ChainMail(55,27);
	//fire prot=100, phys prot=26, weight=6
	FireProofLeatherVest scarletLeatherVestOfFireResistance = new FireProofLeatherVest(100, 15, 6);
	//above, below
	ProtectionStack knightProtectionSt = new ProtectionStack(scarletChestpieceOfTheBoar,scarletLeatherVestOfFireResistance);
	//100 HP
	GameCharacter Lancelot = new GameCharacter("Lancelot",100,10,knightProtectionSt);
	for(Quest q : quests){
	    Lancelot.startQuest(q);
	}
    
	System.out.println("\nCharacter state BEFORE damage:");
	System.out.println(Lancelot.toString());
    
	//phy=50,mag=5,elec=0,fire=100
	Damage dragonDmg = new Damage(75,33,0,99);
	Lancelot.wound(dragonDmg);
    
	System.out.println("\nCharacter state AFTER damage:");
	System.out.println(Lancelot.toString());
    
	Damage longswordDmg = new Damage(200,0,0,0);
	Lancelot.wound(longswordDmg);
    
	System.out.println("\nCharacter state after FATAL damage:");
	//HP will bet at 0 //you could add a test to display that character is dead
	System.out.println(Lancelot.toString());
    
	HashSet<Quest> questLogCopy = Lancelot.getQuestLog();
	int i=1;
	for(Quest q: questLogCopy){
	    System.out.println("Quest#"+String.valueOf(i)+q.toString());
	    i++;
	}
    }
}
