package ch.unige.cui.rpg;

public class ProtectionStack implements Protection{
    private Protection layerAbove;
    private Protection layerBelow;

    public ProtectionStack(Protection layerAbove, Protection layerBelow){
        this.layerAbove=layerAbove;
        this.layerBelow=layerBelow;
    }

    
    public int getWeight() {
        //sum of the weight of each layer
        return layerAbove.getWeight()+layerBelow.getWeight();
    }

    
    public Damage absorb(Damage dmg) {
        //similar idea as function composition in mathematics
        //below absorbe les dégats restant d' above 
        return layerBelow.absorb(layerAbove.absorb(dmg));
    }


    
}