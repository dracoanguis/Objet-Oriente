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

    
    public int hashCode(){
        //a completer
        return 0;
    }
    

    public boolean equals(Object o){
        //a completer
        return false;
    }
    
}
