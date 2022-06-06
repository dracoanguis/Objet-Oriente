package ch.unige.cui.rpg;
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
    
    //pour simplifier le player sera tjrs un guerrier humain pour l instant
    public static HumanWarrior initPlayer(String name){
	//tout cela est fixe pour simplifier, mais libre a vous de faire mieux
	ChainMail scarletChestpieceOfTheBoar = new ChainMail(55,27);
	
	FireProofLeatherVest scarletLeatherVestOfFireResistance = new FireProofLeatherVest(100, 15, 6);
	
	ProtectionStack knightProtectionSt = new ProtectionStack(scarletChestpieceOfTheBoar,scarletLeatherVestOfFireResistance);
	
	return new HumanWarrior(name,100,10,knightProtectionSt);

    }
    
    public static void main(String[] args){
	System.out.println("\n\n\n>>>>>>>>>>> START of GAME \n\n\n");

	
	String filename = "./src/main/resources/quests.txt";
	ArrayList<Quest> quests = readQuestFile(filename);
	
	HumanWarrior Lancelot = initPlayer("Lancelot");

	for(Quest q : quests){
	    Lancelot.startQuest(q);
	}

	
	System.out.println("\n\n Starting fight with dragon...");
	System.out.println("Player : "+Lancelot.toString());
	
	
	System.out.println("\nCharacter state BEFORE damage:");
	System.out.println(Lancelot.toString());
    
	System.out.println("a dragon attacks, inflicting 75 phyical, 33 magical, and 99 fire damage ...");
	Damage dragonDmg = new Damage(75,33,99);
	Lancelot.wound(dragonDmg);
    
	System.out.println("\nCharacter state AFTER damage:");
	System.out.println(Lancelot.toString());

 	System.out.println("A (very) powerful priest heals player by an insane amount...");
	Lancelot.heal(new Damage(999,999,999));

	System.out.println("\nafter healing wave :");
	System.out.println(Lancelot.toString());

	System.out.println("Dragon finally kills Lancelot by inflicting 6666 fire and physical damage ...");
	dragonDmg = new Damage(666,0,666);
	Lancelot.wound(dragonDmg);
	
	System.out.println("\nAFTER FATAL dragon attack:");
	System.out.println(Lancelot.toString());

	System.out.println("The (very) powerful priest tries to heal Lancelot (again) but..."); 
	Lancelot.heal(new Damage(999,999,999));
	System.out.println("\nAFTER POSTMORTEM healing tentative:");
	System.out.println(Lancelot.toString());
	
	System.out.println("\n\n\nEND of GAME <<<<<<<<<<< \n\n\n");

	//////////////////////////////////////////////////////////////////////////////////////////
	
	System.out.println("\n\n>>>>>>>>>> STARTING NEW GAME ...");
	System.out.println("\n\n Starting fight with ghoul mage...");

	
	HumanWarrior Parseval = initPlayer("Parseval");
	GhoulMage ghoul = new GhoulMage("Bonechewer",1,100);//"mâcheur d'os"

	System.out.println("\n\n main player:"+Parseval.toString());
	
	Damage magicalDmg = new Damage(0,51,0);
	
	ghoul.wound(magicalDmg);

	System.out.println("\nghoul state after being wounded : "+ghoul.toString());
	
	ghoul.heal(magicalDmg);

	System.out.println("\nghoul state after being healed : "+ghoul.toString());

	Damage ghoulAttack = ghoul.castSpell();

	Parseval.wound(ghoulAttack);

	System.out.println("\nPlayer state after ghoul casts spell on him : "+Parseval.toString());
	System.out.println("\nGhoul state after ghoul casting spell : "+ghoul.toString());

	Damage physicalDmg = new Damage(101,0,0);

	ghoul.wound(physicalDmg);

	System.out.println("\nghoul state after being wounded (physical) : "+ghoul.toString());

	
	System.out.println("A (very) powerful priest heals player by an insane amount...");
	Parseval.heal(new Damage(999,999,999));

	System.out.println("\nPlayer stated after being healed : "+Parseval.toString());

	ghoul.manaRegen(150);

	for(int i=0;i<3;i++){
	    ghoulAttack = ghoul.castSpell();
	    //debug info
	    System.out.println("ghoul's remaining mana : "+ghoul.getMana()+" and ghoul attack is:"+ghoulAttack.toString());
	    Parseval.wound(ghoulAttack);
	}
	
	System.out.println("\nPlayer state after 3 ghoul attacks (3*35 dmg) : " +Parseval.toString());
	System.out.println("\nGhoul state after 3 attacks and NO mana regen :"+ghoul.toString());

	ghoul.manaRegen(150);
	ghoulAttack = ghoul.castSpell();
	Parseval.wound(ghoulAttack);

	System.out.println("\nPlayer state after final attack: "+Parseval.toString());
	System.out.println("\nGhoul state after final attack and mana regen : "+ghoul.toString());
	
	System.out.println("\n\n\nEND of GAME <<<<<<<<<<< \n\n\n");
		
	
	/*
	HashSet<Quest> questLogCopy = Lancelot.getQuestLog();
	int i=1;
	for(Quest q: questLogCopy){
	    System.out.println("Quest#"+String.valueOf(i)+q.toString());
	    i++;
	}
	*/
    }
}
