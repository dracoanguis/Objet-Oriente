package ch.unige.cui.rpg;
import java.lang.Math;

public class Armor{
	private final int MAX_ARMOR_VAL = 100;
	private int armorVal;
	private DmgType armorType;
	
	public Armor(int armorVal, DmgType armorType) {
		if (armorVal > 100){
			throw new IllegalArgumentException("Illegal armor value. Max possible armor value: 100.");
		}
		this.armorVal=armorVal;
		this.armorType = armorType;
	}

	public int getArmorVal(){
		return armorVal;
	}

	public DmgType getArmorType(){
		return armorType;
	}

	public Damage absorb(Damage dmg){
		if (armorType == DmgType.MAGICAL) {
			int magDmg = dmg.getMagical();
			return new Damage(dmg.getPhysical(),Math.round((int)Math.max(magDmg*(1-(this.armorVal/100.0)),(5.0/100.0)*magDmg)));
		}
		if (armorType == DmgType.PHYSICAL) {
			int phyDmg = dmg.getPhysical();
			return new Damage(Math.round((int)Math.max(phyDmg*(1-(this.armorVal/100.0)),(5.0/100.0)*phyDmg)), dmg.getMagical());
		}
		return dmg;
	}
}
