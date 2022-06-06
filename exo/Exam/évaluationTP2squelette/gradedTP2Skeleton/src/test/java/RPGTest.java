import ch.unige.cui.rpg.*;
//import jdk.jfr.Timestamp;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
//@TestInstance(TestInstance.Lifecycle.PER_METHOD);

class RPGTest {
    private Player p1;
    private Player p2;
    private Player p3;
    private MagicalObject magicalRing;
    private MagicalObject magicalStaff;
    private MagicalObject magicalSword;
    private ArrayList<Item> arenaInventory;
    private boolean b;
    private Armor a;
    private Damage dmg;

    @BeforeAll
    static void setUpAll(){
        System.out.println("BeforeAll test");
    }

    @BeforeEach
    void setUp(){
        p1 = new Player("Smeagol",50,  new Armor(11, DmgType.PHYSICAL), new CharProfile(1,5,5),PlayerClass.WARRIOR);
        p2 = new Player("Gandalf",100, new Armor(55,DmgType.MAGICAL), new CharProfile(10, 2, 3), PlayerClass.MAGE);
        p3 = new Player("Sauron",5000,  new Armor(99, DmgType.PHYSICAL), new CharProfile(105,25,10),PlayerClass.MAGE);
        magicalRing = new MagicalObject(11,10,0,1);
        magicalStaff = new MagicalObject(3,2,0,1);
		arenaInventory = new ArrayList<>();
        arenaInventory.add(magicalRing);
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
    @DisplayName("equipTest:")
    void equipTest(){
        b = magicalRing.equip(p1, arenaInventory);

        assertAll("equipTest:", () -> assertEquals(12,p1.getPr().getIntellect()),
                                 () -> assertEquals(15,p1.getPr().getStrength()),
                                 () -> assertEquals(5,p1.getPr().getStamina()),
                                 () -> assertEquals(true,arenaInventory.isEmpty()),
                                 () -> assertEquals(true,b)
                                 );
    }

    @Test
    @DisplayName("equipTwiceTest:")
    void equipTwiceTest(){
        b = magicalRing.equip(p1, arenaInventory);
        b = magicalRing.equip(p1, arenaInventory);

        assertAll("equipTwiceTest:", () -> assertEquals(12,p1.getPr().getIntellect()),
                                 () -> assertEquals(15,p1.getPr().getStrength()),
                                 () -> assertEquals(5,p1.getPr().getStamina()),
                                 () -> assertEquals(true,arenaInventory.isEmpty()),
                                 () -> assertEquals(false,b)
                                 );
    }


    @Test
    @DisplayName("unEquipTest:")
    void unEquipTest(){
        b = magicalRing.equip(p1, arenaInventory);
        b = magicalRing.unEquip(p1, arenaInventory);
        assertAll("unEquipTest:", () -> assertEquals(1,p1.getPr().getIntellect()),
                                 () -> assertEquals(5,p1.getPr().getStrength()),
                                 () -> assertEquals(5,p1.getPr().getStamina()),
                                 () -> assertEquals(false,arenaInventory.isEmpty())
                                 );
    }


    @Test
    @DisplayName("SauronAttacksGandalfTest:")
    void SauronAttacksGandalfTest(){
        p3.attack(p2);
        assertAll("SauronAttacksGandalfTest:", () -> assertEquals(53,p2.getCurrentHP()),
                                 () -> assertEquals(5000,p3.getCurrentHP())
                                 );
    }

    @Test
    @DisplayName("SmeagolAttacksGandalfTest:")
    void SmeagolAttacksGandalfTest(){
        p1.attack(p2);
        assertAll("SmeagolAttacksGandalfTest:", () -> assertEquals(95,p2.getCurrentHP()),
                                 () -> assertEquals(50,p1.getCurrentHP())
                                 );
    }

    @Test
    @DisplayName("doubleAttackTest:")
    void doubleAttackTest(){
        p3.attack(p2);
        p1.attack(p2);
        assertAll("doubleAttackTest:", () -> assertEquals(48,p2.getCurrentHP()),
                                 () -> assertEquals(50,p1.getCurrentHP()),
                                 () -> assertEquals(5000,p3.getCurrentHP())
                                 );
    }

    @Test
    @DisplayName("exceptionTest:")
    void exceptionTest(){
        Exception exception = assertThrows(RuntimeException.class, () -> {
            Armor a = new Armor(101, DmgType.PHYSICAL);
        });
    
        String expectedMessage = "Illegal armorVal. Max possible armor value: 100.";
        String actualMessage = exception.getMessage();
    
        assertTrue(actualMessage.contains(expectedMessage));
    }


    @Test
    @DisplayName("armorAbsorbTest:")
    void armorAbsorbTest(){
        a = new Armor(50, DmgType.PHYSICAL);
        dmg = a.absorb(new Damage(100,100));
        assertEquals(150,dmg.getPhysical()+dmg.getMagical());
    }


}
