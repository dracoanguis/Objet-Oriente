package rpg;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.io.*;
import java.util.stream.*;

public class RPGTest {
    //private Random rng = new Random(System.currentTimeMillis());
    private String fn = "./src/main/resources/potions.txt";
    private ArrayList<Item> it = new ArrayList<>();
    private ArrayList<ManaPotion> m = new ArrayList<>();
    private ArrayList<HealingPotion> h = new ArrayList<>();
    
    @BeforeAll
    static void setUpAll(){
        System.out.println("BeforeAll test");
    }

    @BeforeEach
    void setUp(){
        it.add(new ManaPotion(10,5));
	it.add(new ManaPotion(20,10));
	it.add(new HealingPotion(60,6));
	it.add(new ManaPotion(30,15));
	it.add(new HealingPotion(100,20));
	it.add(new ManaPotion(100,25));
	it.add(new ManaPotion(150,35));
	
    }

    @AfterEach
    void tearDown(){
        System.out.println("AfterEach test");
    }

    @AfterAll
    static void tearDownAll(){
        System.out.println("AfterALl test");
    }


    ///////////////////////////////////////////

    @Test
    @DisplayName("readFileTest")
    void readFileTest(){
	Game.storeFileContentsForGame(fn);
	var contents = Game.getItems();
	String line0 = "";
	if( !contents.isEmpty()){ line0 = contents.get(0); }
	final String line0_ = line0;//needs final for lambda
        assertAll("readFileTest:", () -> assertEquals(false,contents.isEmpty()),
		  () -> assertEquals("Mana 99 15",line0_));
    }
    
    @Test
    @DisplayName("filtByPriceTest")
    void filtByPriceTest(){
	int p = 20;
	Stream<Item>  s = Game.filterManaPotionsByPrice(it,p);
	int res = s.map(x -> x.getPrice()).reduce(0,(a,b) -> a+b);
        assertAll("filtByPriceTest:", () -> assertEquals(30,res));
    }


    @Test
    @DisplayName("filtByManaTest")
    void filtByManaTest(){
	int manaVal = 50;
	Stream<Item>  s = Game.filterManaPotionsByMana(it,manaVal);
	int res = s.map(x -> ((ManaPotion)x).getMana()).reduce(0,(a,b) -> a+b);
        assertAll("filtByManaTest:", () -> assertEquals(250,res));
    }

    
    @Test
    @DisplayName("createManaPotionStreamTest")
    void createManaPotionStreamTest(){
	Game.storeFileContentsForGame(fn);
	Stream<Item>  s = Game.createManaPotionStream();
	int totalMana = s.map(x -> ((ManaPotion)x).getMana()).reduce(0,(a,b) -> a+b);
	s = Game.createManaPotionStream();
	int totalPrice = s.map(x -> x.getPrice()).reduce(0,(a,b) -> a+b);
        assertAll("createManaPotionStreamTest:", () -> assertEquals(40,totalPrice),
		                                 () -> assertEquals(179,totalMana));
    }


    @Test
    @DisplayName("createHPStreamTest")
    void createHPStreamTest(){
	Game.storeFileContentsForGame(fn);
	Stream<Item>  s = Game.createHPPotionStream();
	int totalHP = s.map(x -> ((HealingPotion)x).getHP()).reduce(0,(a,b) -> a+b);
	s = Game.createHPPotionStream();
	int totalPrice = s.map(x -> x.getPrice()).reduce(0,(a,b) -> a+b);
        assertAll("createHPStreamTest:", () -> assertEquals(18,totalPrice),
		                         () -> assertEquals(175,totalHP));
    }



    @Test
    @DisplayName("copyABTest")
    void copyABTest(){
	ArrayList<ManaPotion> a = new ArrayList<>();
	a.add(new ManaPotion(10,1));
	a.add(new ManaPotion(20,2));
	a.add(new ManaPotion(30,3));
	ArrayList<Item> b = new ArrayList<>();
	Game.copy_a_b(a,b);
        assertAll("copyABTest:", () -> assertEquals(true,a.equals(b)));
    }


    @Test
    @DisplayName("copyAB2ndTest")
    void copyAB2ndTest(){
	ArrayList<ManaPotion> a = new ArrayList<>();
	a.add(new ManaPotion(10,1));
	a.add(new ManaPotion(20,2));
	a.add(new ManaPotion(30,3));
	ArrayList<Object> b = new ArrayList<>();
	Game.copy_a_b(a,b);
        assertAll("copyAB2ndTest:", () -> assertEquals(true,a.equals(b)));
    }

}
