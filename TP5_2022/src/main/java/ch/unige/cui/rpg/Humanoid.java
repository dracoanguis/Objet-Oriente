package ch.unige.cui.rpg;

//pas de logique pas de class
public class Humanoid implements GameCharacter{
    private final String name;
    private int level;
    protected final int maxHP;
    protected int currentHP;
    protected boolean isAlive;
    private final DamageSensi dmgSensi;//boolean[] dmgSensi;
    private ProtectionStack protectionSt;
    
    public Humanoid(String name, int level, int maxHP, ProtectionStack protectionSt){
	this.name = name;
	this.level = level;
	this.maxHP = maxHP;
	this.currentHP = maxHP;
	this.isAlive = true;
	this.dmgSensi = new DamageSensi(true,true,true);//new boolean[]{true,true,true};
	this.protectionSt = protectionSt;
    }

    public void wound(Damage dmg){
	if(isAlive){
	    final Damage actual = protectionSt.absorb(dmg);
	    final int nextHP = currentHP - Math.max(actual.getPhysical(),0) - Math.max(actual.getMagical(),0) - Math.max(actual.getFire(),0);
	    if( nextHP > 0 ) {
		currentHP = nextHP;
	    }
	    else{
		currentHP = 0;
	    }
	    if(currentHP == 0){
		isAlive = false;
	    }
	}
	else{
	    System.out.println("Cannot wound a dead player!");
	}
    }
    
    public void heal(Damage hp){
	if(isAlive){
	    int totalHPVal = hp.getPhysical()+hp.getMagical()+hp.getFire();
	    if(totalHPVal <= 0){ 
		return;
	    }
	    final int nextHP = currentHP + totalHPVal;
	    if( nextHP < maxHP ) {
		currentHP = nextHP;
	    }
	    else{
		currentHP = maxHP;
	    }
	}
	else{
	    System.out.println("Cannot heal a dead player!");
	}
    }

    public String getName(){
	return name;
    }
    
    public int getLevel(){
	return level;
    }
    
    public int getMaxHP(){
	return maxHP;
    }

    public int getCurrentHP(){
	return currentHP;
    }
    
    @Override
    public String toString(){
	return "name = "+name+", level = "+String.valueOf(level)+", maxHP = "+String.valueOf(maxHP)+", currentHP="+String.valueOf(currentHP)+", isAlive = "+String.valueOf(isAlive)+", sensitivities: "+dmgSensi.toString();
    }
}
