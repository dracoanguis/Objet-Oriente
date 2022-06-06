package ch.unige.cui.rpg;

public class Quest{
	private final String description;
	private final int xp;
	
	public Quest(String description, int xp){
		this.description=description;
		this.xp=xp;
	}

	//empty quest constructor
	public Quest(){
		this.description="";
		this.xp=0;
	}
	
	public String toString(){
		return "Description="+description+", XP="+xp;
	}

	public String getDescription() {
		return description;
	}

	public int getXp() {
		return xp;
	}
	
}