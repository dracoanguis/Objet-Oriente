package ch.unige.cui.rpg;

public class Quest{
    private final String description;
    private final int reward;
    
    public Quest(String description, int reward){
	this.description=description;
	this.reward=reward;
    }

    //sentinel object to avoid the usage of null
    public static Quest emptyQuest(){
	return new Quest("Quest log is empty!",0);
    }
    
    public String toString(){
	return "description = "+description+", reward = "+reward;
    }

    public Quest getCopy(){
	return new Quest(description,reward);
    }

    public String getDescription(){
	return description;
    }

    @Override
    public int hashCode(){
	int h=17;
	h=h*31+description.hashCode();
	h=h*31+reward;
	return h;
    }
    
    @Override
    public boolean equals(Object o){
	if( o == this) return true;
	if(o == null) return false;
	if(! (o instanceof Quest) ) return false;
	Quest q = (Quest) o;
	return (q.description.equals(this.description)) && (q.reward == this.reward);
    }
}
