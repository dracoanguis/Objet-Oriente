package ch.unige.cui.rpg;
import java.util.Random;

public class MageRobes implements Randomizable {
    private final Damage mageRobesProt;

    
    public MageRobes(){
        this.mageRobesProt = new Damage(0,0,0,0);
    }
    
    public MageRobes(int magicalProtVal){
        this.mageRobesProt = new Damage(0,magicalProtVal,0,0);
    }

    public MageRobes single(Random rng, int maxChar){
        int magic = rng.nextInt(maxChar);
        return new MageRobes(magic);
    }

    public Damage getMageRobesProt() {
        return mageRobesProt;
    }    

    @Override
    public String toString(){
        return "[ MageRobes with protection against: "+mageRobesProt.toString()+"]";
    }
}
