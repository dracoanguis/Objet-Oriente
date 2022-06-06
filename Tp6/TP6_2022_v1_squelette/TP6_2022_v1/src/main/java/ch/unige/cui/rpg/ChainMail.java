package ch.unige.cui.rpg;
import java.util.Random;

public class ChainMail  {
    private final Damage protectionValues;
    
    public ChainMail(){
        this.protectionValues = new Damage(0,0,0,0);
    }

    public ChainMail(int physicalProt){
        this.protectionValues = new Damage(physicalProt,0,0,0);
    }

    public ChainMail single(Random rnd){
        int physical = rnd.nextInt(100);
        return new ChainMail(physical);
    }


    public Damage getProtectionValues() {
        return protectionValues;
    }

    
}
