package ch.unige.cui.rpg;

public class Armor implements Protection, Item{

    private final String name;

    private final int physic;
    private final int magic;
    private final int fire;
    private final int electrical;

    private final int weight;
    private final int maxDurability;
    private int currentDurability;
    private boolean broken=false;

    public Armor(String name, int physic, int magic, int fire, int electrical,int weight,int maxDurability) throws IllegalArgumentException{
        if(name == null ||  name.trim().isEmpty()){
			throw new IllegalArgumentException("name is non-valid");
		}

        if(physic<0 || magic<0 || fire<0 || electrical<0 || weight<0 || maxDurability<0){
            throw new IllegalArgumentException("stats should be positive or zero");
        }

        this.name = name;
        this.physic = physic;
        this.magic = magic;
        this.fire = fire;
        this.electrical = electrical;
        this.weight = weight;
        this.maxDurability = maxDurability;
        this.currentDurability = maxDurability;
    }

    public int weight(){
        return (this.weight);
    }

    private int[] getResistance(){
        int[] res = {this.physic,this.magic,this.fire,this.electrical};
        return (res);
    }

    private static int setDamage(int res, int dmg){
        if(res > dmg){
            return (0);
        }

        return (dmg-res);
    }

    public void damage(int dmg) throws IllegalArgumentException{

        if (dmg<0){
            throw new IllegalArgumentException("lost durability should be positive");
        }

        if (dmg > this.currentDurability){
            this.currentDurability = 0;
            this.broken = true;
        } else {
            this.currentDurability -= dmg;
        }
    }

    public void repair(int rpr) throws IllegalArgumentException {

        if (rpr<0){
            throw new IllegalArgumentException("repaired durability should be positive");
        }

        if (this.maxDurability < (this.currentDurability+rpr)){
            this.currentDurability = this.maxDurability;
        } else {
            this.currentDurability += rpr;
        }

        this.broken = true;
    }

    public Damage absorb(Damage abs){

        if (this.broken){
            return (abs);
        }

        int[] dmg = abs.getDamageArray();
        int[] res = this.getResistance();
        int[] ndmg = new int[dmg.length];

        for(int i=0; i<dmg.length; i++){
            ndmg[i] = Armor.setDamage(res[i], dmg[i]);
        }

        return (new Damage(ndmg));
    }

    public String getName(){

        if(this.broken){
            return(String.format("%s (Broken)", this.name));
        }

        return (this.name);
    }

    public String getDescription(){
        return (String.format("durability: %d/%d", this.currentDurability,this.maxDurability));
    }

    public String toString(){
        return (String.format("Name: %s, Durability: %d/%d", this.getName(),this.currentDurability,this.maxDurability));
    }

    public Armor clone(){
        return (new Armor(name, physic, magic, fire, electrical, weight, maxDurability));
    }

}
