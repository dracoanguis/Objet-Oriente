package ch.unige.cui.rpg;

public class ProtectionStack implements Protection{
    private Protection layerAbove;
    private Protection layerBelow;

    public ProtectionStack(Protection layerAbove, Protection layerBelow){
        this.layerAbove=layerAbove;
        this.layerBelow=layerBelow;
    }

    
    public int getWeight() {
        return layerAbove.getWeight()+layerBelow.getWeight();
    }

    
    public Damage absorb(Damage dmg) {
        return layerBelow.absorb(layerAbove.absorb(dmg));
    }


    
}