package ch.unige.cui.rpg;
import java.util.HashSet;

public class GameCharacter{
    private final static int maxQuests = 10;
    private final String name;
    private final int maxHP;
    private int gold;
    private int currentHP;
    private HashSet<Quest> questLog;
    private Quest currentQuest;
    //instead of armor we now have a protection stack
    private ProtectionStack protectionSt;
    
    public GameCharacter(String name,int maxHP, int gold, ProtectionStack protectionSt){
	this.name=name;
	this.maxHP=maxHP;
	this.currentHP=maxHP;
	this.gold=gold;
	this.protectionSt=protectionSt;
	//to avoid using null
	this.questLog = new HashSet<Quest>();
	this.questLog.add(Quest.emptyQuest());
    }
    
    public void wound(Damage dmg){
		final Damage actual = protectionSt.absorb(dmg);
		// Math.max(actual,0) : if actual.get(...) would return a negative value then we force the value to 0
		//it could possibly be negative if it absorbs more dmg than was done depending on implementation in the specific class e.g. chainMail, possibly can be dealt with there instead of here
		//(( like a ReLU function in ML for those who are interested https://en.wikipedia.org/wiki/Rectifier_(neural_networks) ... (out of scope of the lectures) ))
		final int nextHP = currentHP - Math.max(actual.getPhysical(),0) -  Math.max(actual.getMagical(),0) -  Math.max(actual.getElectrical(),0) -  Math.max(actual.getFire(),0);
		if( nextHP > 0 ) {
	    	currentHP = nextHP;
		}
		else{
	    	currentHP = 0;
		}
    }
    
    public void heal(int hp){
		if(hp <= 0){ 
	    	return;
		}
		final int nextHP = currentHP + hp;
		if( nextHP < maxHP ) {
	    	currentHP = nextHP;
		}
		else{
	    	currentHP = maxHP;
		}
    }
    
    public void startQuest(Quest q){

		// a completer ...

    }

	//you can use this function to display the questlog or create another one
    public HashSet<Quest> getQuestLog(){
		//deep copy to avoid risk of modification of quests inside questlog outside this class
		HashSet<Quest> questLogCopy = new HashSet<Quest>();
		for(Quest q: this.questLog){
	    	questLogCopy.add(q.getCopy());
		}
		return questLogCopy;
    }
    
    public String toString(){
		return "Name="+name+", gold="+gold+", currentHP="+currentHP+", current quest="+ currentQuest.toString();
    }
    
}
