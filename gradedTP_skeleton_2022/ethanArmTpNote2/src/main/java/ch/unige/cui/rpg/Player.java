package ch.unige.cui.rpg;
import java.lang.Math;
import java.util.Random;
import java.util.ArrayList;

public class Player {
	private final String name;
	private final int maxHP;
	private int currentHP;
	private Armor armor;
	private CharProfile pr;
	private PlayerClass pc;
	private MagicalObject magicalObj = MagicalObject.empty();
  
	public Player(String name,int maxHP, Armor armor, CharProfile pr, PlayerClass pc){
		this.name=name;
		this.maxHP=maxHP;
		this.currentHP=maxHP;
		this.armor=armor;
		this.pr=pr;
		this.pc=pc;
	}
  
	private int absorbDmg(Damage dmg){
		final Damage actualDmg = armor.absorb(dmg);
		return ( currentHP - Math.max(actualDmg.getPhysical(),0) - Math.max(actualDmg.getMagical(),0) );
	}

  
	public void wound(Damage dmg){
		Damage realDmg = armor.absorb(dmg);
		int takenDmg = realDmg.getPhysical() + realDmg.getMagical();
		if (takenDmg >= this.currentHP){
			this.currentHP = 0;
		} else {
			this.currentHP -= takenDmg;
		}
	}
  
	public void attack(Player player){
		if (this.pc == PlayerClass.WARRIOR) {
			int str = this.getPr().getStrength();
			int phyDmg = (int)Math.ceil(str/2)+1;
			var dmg = new Damage(phyDmg,0);
			player.wound(dmg);
		} else {
			int intel = this.getPr().getIntellect();
			int magDmg = (int)Math.ceil(intel/2)+1;
			var dmg = new Damage(0,magDmg);
			player.wound(dmg);
		}
	}
  
	public CharProfile getPr() {
	return pr;
	}

  
	public void setPr(CharProfile pr) {
	this.pr = pr;
	}
  

	public int getMaxHP() {
	return maxHP;
	}

	public int getCurrentHP(){
	return currentHP;
	}

	public MagicalObject getMagicalObj(){
	return magicalObj;
	}

	public void setMagicalObj(MagicalObject magicalObj){
	this.magicalObj=magicalObj;
	}


	public String toString(){
	return "Name: "+name+", currentHP: "+currentHP+", armor points: "+armor.getArmorVal()+", profile: "+pr.toString() + ", magicalObj: "+magicalObj.toString();
	}

}
