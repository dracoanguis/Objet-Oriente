package ch.unige.cui.rpg;

public class Game{
    

	public static void main(String[] args){
		System.out.println("Successfully entered in main.");

    	ChainMail scarletChestpieceOfTheBoar;
    	FireProofLeatherVest scarletLeatherVestOfFireResistance;
    	MageRobes embersilkRobesOfArcaneWrath;
    	ZeroStatShirt protectionlessShirt;
    	ProtectionStack knightProtectionSt, mageProtectionSt;
    	Quest q1, q2, q3, q4, q5, emptyQuest;
    	CharProfile initProfWar, initProfMage;
    	Damage longswordDmg, magicalStaffDmg;

		WarriorClass lancelot, percival;
    	MageClass merlin;

		scarletChestpieceOfTheBoar = new ChainMail(55,27);
		//fire prot=100, phys prot=25, weight=6
		scarletLeatherVestOfFireResistance = new FireProofLeatherVest(25,100, 6);
		embersilkRobesOfArcaneWrath = new MageRobes(150,25,0);
		protectionlessShirt = new ZeroStatShirt();
		//above, below
		knightProtectionSt = new ProtectionStack(scarletChestpieceOfTheBoar,scarletLeatherVestOfFireResistance);
		mageProtectionSt = new ProtectionStack(embersilkRobesOfArcaneWrath,protectionlessShirt);
		initProfWar = new CharProfile(1, 1, 1, 0, 1);//int,str,stam,xp,lvl
		initProfMage = new CharProfile(2,1,0,0,1);
		lancelot = new WarriorClass("Lancelot",101,10,knightProtectionSt,initProfWar);
        percival  = new WarriorClass("Lancelot",90,10,knightProtectionSt,initProfWar);
		merlin = new MageClass("Merlin",75,10,mageProtectionSt,initProfMage);

        q1 = new Quest("Holy grail quest",400);
        q2 = new Quest("Holy grail quest 2",880);
        q3 = new Quest("Holy grail quest 3",1440);

        lancelot.completeQuest(q1);
        lancelot.completeQuest(q2);
        lancelot.completeQuest(q3);
        
        merlin.completeQuest(q1);
        merlin.completeQuest(q2);
        merlin.completeQuest(q3);
	}
}