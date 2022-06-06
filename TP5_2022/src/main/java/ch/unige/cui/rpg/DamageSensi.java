package ch.unige.cui.rpg;

public class DamageSensi{
    private final boolean[] sensi = new boolean[3];
    //for internal use 
    private final String[] sensiStr = new String[]{"physical", "magical", "fire"};
    
    public DamageSensi(boolean physical, boolean magical, boolean fire){
	this.sensi[0] = physical;
	this.sensi[1] = magical;
	this.sensi[2] = fire;
    }

    public boolean[] getSensi(){
	return sensi;
    }

    @Override
    public String toString(){
	String str = "";
	for(int i=0;i<sensiStr.length;i++){
	    if(sensi[i]){
		str += sensiStr[i]+", ";
	    }
	}
	return "is sensitive to dmg of type(s) : "+str;
    }

}
