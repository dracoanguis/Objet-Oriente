package ch.unige.cui.rpg;

public class ProtectionStack implements Protection {
    private final Protection above;
    private final Protection below;


    public ProtectionStack(Protection above, Protection below){
        this.above = above;
        this.below = below;
    }

    public int weight(){
        return (this.above.weight()+this.below.weight());
    }

    public Damage absorb(Damage dmg){
        Damage ndmg = dmg;

        if(this.above!=null){
            ndmg = this.above.absorb(ndmg);
        }

        if(this.below!=null){
            ndmg = this.below.absorb(ndmg);
        }

        return (ndmg);
    }

    public String toString(){

        String above = "None";
        String below = "None";

        if( this.above != null){
            above = this.above.toString();
        }

        if (this.below != null){
            below = this.below.toString();
        }

        return (String.format("above: %s, below: %s", above,below));
    }
}
