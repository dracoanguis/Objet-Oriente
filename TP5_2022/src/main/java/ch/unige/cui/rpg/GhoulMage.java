package ch.unige.cui.rpg;

public class GhoulMage extends Undead{
    private final int maxMana;
    private int mana;
    
    public GhoulMage(String name, int level, int maxHP){
	super(name,level,maxHP);
	maxMana = 100;
	mana = maxMana;
    }

    //we could implement a spellbook with objects of class Spell inside etc.
    //but to simplify things here we just assume these Ghouls can cast a unique spell
    public Damage castSpell(){
	final int spellCost = 35;
	if( (mana-spellCost) < 0){//cannot cast spell if not enough mana
	    return new Damage(0,0,0);
	}
	else{
	    mana -= spellCost;
	    return new Damage(0,spellCost,0);
	}
    }
    
    
    public void manaRegen(int mana){
	if(mana <= 0 ){
	    return;
	}
	if( (mana+this.mana) <= maxMana ){
	    this.mana = mana;
	}
	else{
	    this.mana = maxMana;
	}
    }

    public int getMana(){
	return mana;
    }
    
    @Override
    public String toString(){
	return super.toString()+", mana = "+String.valueOf(mana);
    }
}
