package ch.unige.cui.rpg;

public class Damage {
    private final int physic;
    private final int magic;
    private final int fire;
    private final int electrical;

    public Damage(int physic, int magic, int fire, int electrical) {
        this.physic = physic;
        this.magic = magic;
        this.fire = fire;
        this.electrical = electrical;
    }

    public Damage(int[] dmg){
        this.physic = dmg[0];
        this.magic = dmg[1];
        this.fire = dmg[2];
        this.electrical = dmg[3];
    }

    protected int[] getDamageArray(){
        int[] damage = {this.physic ,this.magic,this.fire,this.electrical};
        return (damage);
    }

    public int getDamage(){
        int dmg = 0;
        int[] fullDmg = this.getDamageArray();
        for (int d: fullDmg){
            dmg += d;
        }
        return (dmg);
    }

    public boolean equals(Damage other){
        int[] tval = this.getDamageArray();
        int[] oval = other.getDamageArray();

        for(int i = 0; i<tval.length; i++){
            if (tval[i] != oval[i]){
                return (false);
            }
        }

        return (true);
    }

    public int hashCode(){
        int h = 3;
            h = h*5 + this.physic;
            h = h*7 + this.magic;
            h = h*11 + this.fire;
            h = h*13 + this.electrical;
        return h;
    }

}
