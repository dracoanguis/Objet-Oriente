package ch.unige.cui.rpg;

public class Armor{
    private final int MAX_ARMOR_VAL = 100;
    private int armorVal;
    private DmgType armorType;

    public Armor(int armorVal, DmgType armorType){
        if(armorVal<=MAX_ARMOR_VAL){
            this.armorVal=armorVal;
            this.armorType = armorType;
        }
    }

    public int getArmorVal(){
        return armorVal;
    }

    public DmgType getArmorType(){
        return armorType;
    }


    public Damage absorb(Damage dmg){
		return new Damage(dmg.getPhysical(),dmg.getMagical());
    }
}