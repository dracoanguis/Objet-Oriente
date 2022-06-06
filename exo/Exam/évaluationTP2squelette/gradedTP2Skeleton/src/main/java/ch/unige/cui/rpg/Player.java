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
  

  public void wound(Damage dmg){
  }
  
  public void attack(Player player){
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
