import ch.unige.cui.rpg.*;
import jdk.jfr.Timestamp;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
//@TestInstance(TestInstance.Lifecycle.PER_METHOD);

class RPGTest {

    private ChainMail scarletChestpieceOfTheBoar;
    private FireProofLeatherVest scarletLeatherVestOfFireResistance;
    private MageRobes embersilkRobesOfArcaneWrath;
    private ZeroStatShirt protectionlessShirt;
    private ProtectionStack knightProtectionSt, MageProtectionSt;
    private Quest q1, q2, q3, q4, q5, emptyQuest;
    private CharProfile initProfWar, initProfMage;
    private Damage longswordDmg, magicalStaffDmg;
    private WarriorClass Lancelot, Percival;
    private MageClass Merlin;


    @BeforeAll
    static void setUpAll(){
        System.out.println("BeforeAll test");
    }

    @BeforeEach
    void setUp(){
		scarletChestpieceOfTheBoar = new ChainMail(55,27);
		//fire prot=100, phys prot=25, weight=6
		scarletLeatherVestOfFireResistance = new FireProofLeatherVest(25,100, 6);
		embersilkRobesOfArcaneWrath = new MageRobes(150,25,0);
		protectionlessShirt = new ZeroStatShirt();
		//above, below
		knightProtectionSt = new ProtectionStack(scarletChestpieceOfTheBoar,scarletLeatherVestOfFireResistance);
		MageProtectionSt = new ProtectionStack(embersilkRobesOfArcaneWrath,protectionlessShirt);
		initProfWar = new CharProfile(1, 1, 1, 0, 1);//int,str,stam,xp,lvl
		initProfMage = new CharProfile(2,1,0,0,1);
		Lancelot = new WarriorClass("Lancelot",101,10,knightProtectionSt,initProfWar);
        Percival  = new WarriorClass("Lancelot",90,10,knightProtectionSt,initProfWar);
		Merlin = new MageClass("Merlin",75,10,MageProtectionSt,initProfMage);
    }

    @AfterEach
    void tearDown(){
        System.out.println("AfterEach test");
    }

    @AfterAll
    static void tearDownAll(){
        System.out.println("AfterAll test");
    }

    @Test
    @DisplayName("(unit test) MageRobes magical and electrical prot:")
    void magicalProtectionTest(){
        Damage dmg = new Damage(0,150,25,0);
        assertEquals(true,dmg.equals(embersilkRobesOfArcaneWrath.getMageRobesProt()));
    }

    @Test
    @DisplayName("(unit test) notPassLvlTest:")
    void notPassLvlTest(){
        q1 = new Quest("Holy grail quest",399);
        Lancelot.completeQuest(q1);
        assertEquals(1,Lancelot.getPr().getLvl());
    }

    @Test
    @DisplayName("(unit test) warPassLvlTest:")
    void warPassLvlTest(){
        q1 = new Quest("Holy grail quest",400);
        Lancelot.completeQuest(q1);
        assertEquals(2,Lancelot.getPr().getLvl());
    }

    @Test
    @DisplayName("(unit test) magePassLvlTest:")
    void magePassLvlTest(){
        q1 = new Quest("Holy grail quest",400);
        Merlin.completeQuest(q1);
        assertEquals(2,Merlin.getPr().getLvl());
    }
    

    @Test
    @DisplayName("(scenario) lvlUp xp test:")
    void lvlUpXPTest(){
        q1 = new Quest("Holy grail quest",399);
        q2 = new Quest("Holy grail quest 2",400);

        Lancelot.completeQuest(q1);

        Merlin.completeQuest(q2);

        Percival.completeQuest(q1);
        Percival.completeQuest(q2);

        assertAll("(scenario) lvlUp xp test:", () -> assertEquals(399,Lancelot.getPr().getXp()),
                                 () -> assertEquals(1,Lancelot.getPr().getLvl()),
                                 () -> assertEquals(0,Merlin.getPr().getXp()),
                                 () -> assertEquals(0,Percival.getPr().getXp()),
                                 () -> assertEquals(2,Percival.getPr().getLvl())
                                 );
    }

    @Test
    @DisplayName("(scenario) lvlUpStatTestBoth:")
    void lvlUpStatTestBoth(){
        q1 = new Quest("Holy grail quest",400);
        q2 = new Quest("Holy grail quest 2",880);
        q3 = new Quest("Holy grail quest 3",1440);

        Lancelot.completeQuest(q1);
        Lancelot.completeQuest(q2);
        Lancelot.completeQuest(q3);
        
        Merlin.completeQuest(q1);
        Merlin.completeQuest(q2);
        Merlin.completeQuest(q3);

        assertAll("(scenario) lvlUpStatTestBoth:", () -> assertEquals(1,Lancelot.getPr().getIntellect()),
                                      () -> assertEquals(7,Lancelot.getPr().getStrength()),
                                      () -> assertEquals(10,Lancelot.getPr().getStamina()),
                                      () -> assertEquals(14,Merlin.getPr().getIntellect()),
                                      () -> assertEquals(1,Merlin.getPr().getStrength()),
                                      () -> assertEquals(2,Merlin.getPr().getStamina()),
                                      () -> assertEquals(4,Lancelot.getPr().getLvl()),
                                      () -> assertEquals(4,Merlin.getPr().getLvl())
                                 );
    }


    @Test
    @DisplayName("(scenario) lvlUpStatTestWarOnly:")
    void lvlUpStatTestWarOnly(){
        q1 = new Quest("Holy grail quest",400);
        q2 = new Quest("Holy grail quest 2",880);
        q3 = new Quest("Holy grail quest 3",1440);

        Lancelot.completeQuest(q1);
        Lancelot.completeQuest(q2);
        Lancelot.completeQuest(q3);

        assertAll("(scenario) lvlUpStatTestWarOnly:", () -> assertEquals(1,Lancelot.getPr().getIntellect()),
                                      () -> assertEquals(7,Lancelot.getPr().getStrength()),
                                      () -> assertEquals(10,Lancelot.getPr().getStamina()),
                                      () -> assertEquals(4,Lancelot.getPr().getLvl())
                                 );
    }


    @Test
    @DisplayName("(scenario) lvlUpStatTestMageOnly:")
    void lvlUpStatTestMageOnly(){
        q1 = new Quest("Holy grail quest",400);
        q2 = new Quest("Holy grail quest 2",880);
        q3 = new Quest("Holy grail quest 3",1440);
        
        Merlin.completeQuest(q1);
        Merlin.completeQuest(q2);
        Merlin.completeQuest(q3);

        assertAll("(scenario) lvlUpStatTestMageOnly :",() -> assertEquals(14,Merlin.getPr().getIntellect()),
                                      () -> assertEquals(1,Merlin.getPr().getStrength()),
                                      () -> assertEquals(2,Merlin.getPr().getStamina()),
                                      () -> assertEquals(4,Merlin.getPr().getLvl())
                                 );
    }

    @Test
    @DisplayName("(unit test) mageIntellectLvl")
    void mageIntellectLvl(){
	q1 = new Quest("Holy grail quest",400);
	Merlin.completeQuest(q1);

	assertAll("(unit test) mageIntellectLvl :",() -> assertEquals(4,Merlin.getPr().getIntellect()),
		  () -> assertEquals(2,Merlin.getPr().getLvl())
		  );
    }
    
}
