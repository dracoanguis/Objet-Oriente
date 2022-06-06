package ch.unige.cui.rpg;
import java.lang.Math;

public class GameCharacter {
  private final String name;
  private final int maxHP;
  private int gold;
  private int currentHP;
  private Quest currentQuest;
  private ProtectionStack protectionSt;
  private CharProfile pr;
  
  public GameCharacter(String name,int maxHP, int gold, ProtectionStack protectionSt, CharProfile pr){
	  this.name=name;
	  this.currentHP=maxHP;
	  this.gold=gold;
    this.protectionSt=protectionSt;
    this.pr=pr;
    this.maxHP=maxHP;
  }
  

  public void wound(Damage dmg){
    final Damage actual = protectionSt.absorb(dmg);
	  final int nextHP = currentHP - Math.max(actual.getPhysical(),0) -  Math.max(actual.getMagical(),0) -  Math.max(actual.getElectrical(),0) -  Math.max(actual.getFire(),0);
	  if( nextHP > 0 ) {
      currentHP = nextHP;
    }
    else{
      currentHP = 0;
    }
  }
  
  public void heal(int hp){
    if(hp <= 0){ 
      return;
    }
    final int nextHP = currentHP + hp;
	  if( nextHP < maxHP ) {
      currentHP = nextHP;
    }
	  else{
      currentHP = maxHP;
    }
  }
  
  public void startQuest(Quest q){
      this.currentQuest = q;
  }

  public int completeQuest(Quest q){
      currentQuest=new Quest();//la quete vide
      return q.getXp();
  }
    
  public String toString(){
      return "Name="+name+", gold="+gold+", currentHP="+currentHP+", current quest="+ currentQuest.toString();
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

}