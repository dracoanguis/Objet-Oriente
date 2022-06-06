package ch.unige.cui.rpg;
import java.util.HashSet;

public class HumanWarrior extends Humanoid {
    
    private int gold;
    private HashSet<Quest> questLog;
    private Quest currentQuest;
    
    public HumanWarrior(String name,int maxHP, int gold, ProtectionStack protectionSt){
	//start with level = 1
	super(name,1,maxHP,protectionSt);
	this.currentHP=maxHP;
	this.gold=gold;
	//to avoid using null
	this.questLog = new HashSet<Quest>();
	Quest theEmptyQuest = Quest.emptyQuest();
	this.questLog.add(theEmptyQuest);
	this.currentQuest = theEmptyQuest; 
    }
    
    
    public void startQuest(Quest q){
	if(this.isAlive){
	    //use "sentinel obj EmptyQuest to avoid using null
	    Quest e = Quest.emptyQuest();
	    System.out.println("questlog size="+String.valueOf(questLog.size()));
	    if(questLog.size() < GameCharacter.maxQuests){
		if( !questLog.contains(q) ){
		    if(questLog.contains(e)){
			questLog.remove(e);
		    }
		    questLog.add(q);
		    currentQuest = q;
		    System.out.println("Added "+q.getDescription()+" to questlog.");
		}
		else{
		    System.out.println("I already have this quest in my questlog!");
		}
	    }
	    else{
		System.out.println("Quest log is full !");
	    }
	}
	else{
	    System.out.println("Cannot start a quest while being dead!");
	}
    }
    
    public HashSet<Quest> getQuestLog(){
	//deep copy to avoid risk of modification of quests inside questlog outside this class
	HashSet<Quest> questLogCopy = new HashSet<Quest>();
	for(Quest q: this.questLog){
	    questLogCopy.add(q.getCopy());
	}
	return questLogCopy;
    }
    
    @Override
    public String toString(){
	return super.toString()+", gold="+gold+", current quest="+ currentQuest.toString();
    }
    
}
