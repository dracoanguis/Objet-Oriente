package ch.unige.cui.rpg;

public class Undead implements GameCharacter {
    private final String name;
    private int level;
    protected final int maxHP;
    protected int currentHP;
    private final DamageSensi dmgSensi;
    
    public Undead(String name, int level, int maxHP){
	this.name = name;
	this.level = level;
	this.maxHP = maxHP;
	this.currentHP = maxHP;
	//les morts vivants ne sont pas sensibles aux degats physiques
	this.dmgSensi = new DamageSensi(false,true,true);
    }

    //pour les mort-vivants (undead) la logique est inversee: les dommages subis les soigne alors que les soins les blessent
    public void heal(Damage dmg){	
	final int nextHP = currentHP - Math.max(dmg.getMagical(),0) - Math.max(dmg.getFire(),0);
	if( nextHP > 0 ) {
	    currentHP = nextHP;
	}
	else{
	    currentHP = 0;
	}
    }

    //pour les mort-vivants (undead) la logique est inversee: les dommages subis les soigne alors que les soins les blessent
    public void wound(Damage dmg){
	//the undead player will be healed by the total amount of physical damage!
	int totalDmg = dmg.getPhysical();//seul les dommages physiques sont pris en compte, les autres types sont ignores
	if(totalDmg <= 0){ 
	    return;//pas de dommages negatifs
	}
	final int nextHP = currentHP + totalDmg;
	if( nextHP < maxHP ) {
	    currentHP = nextHP;
	}
	else{
	    currentHP = maxHP;
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
	return "name = "+name+", level = "+String.valueOf(level)+", maxHP = "+String.valueOf(maxHP)+", currentHP="+String.valueOf(currentHP)+", sensitivities: "+dmgSensi.toString();
    }
}
