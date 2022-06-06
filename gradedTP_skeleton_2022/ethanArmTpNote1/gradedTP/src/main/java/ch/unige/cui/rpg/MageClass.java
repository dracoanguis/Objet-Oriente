package ch.unige.cui.rpg;

public class MageClass extends GameCharacter implements CharClass{
    
    public MageClass(String name,
                int maxHP,
                long gold,
                ProtectionStack protectionSt,
                CharProfile pr
                ) {
        super(name,maxHP,gold,protectionSt,pr);
    }
    
    public CharProfile levelUp(CharProfile pr){
        if (pr.getXp() >= LevelClass.getXPToNextLvl(pr.getLvl()) && pr.getLvl() < LevelClass.getMaxLvl()){
            if ((pr.getLvl()+1)%2 == 0){
                return new CharProfile(pr.getIntellect()+2,pr.getStrength(),pr.getStamina()+1,0,pr.getLvl()+1);
            }
            return new CharProfile(pr.getIntellect()*3,pr.getStrength(),pr.getStamina(),0,pr.getLvl()+1);
        } 
        return pr;
    }

    @Override
    public int completeQuest(Quest q) {
        int nXp = super.completeQuest(q);
        this.pr = new CharProfile(this.pr.getIntellect(),this.pr.getStrength(),this.pr.getStamina(),this.pr.getXp()+nXp,this.pr.getLvl());
        this.pr = this.levelUp(this.pr);
        return 0;
    }
}
