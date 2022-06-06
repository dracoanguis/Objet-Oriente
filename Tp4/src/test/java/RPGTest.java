import ch.unige.cui.rpg.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
//@TestInstance(TestInstance.Lifecycle.PER_METHOD);

class RPGTest {


    @BeforeAll
    static void setUpAll(){
        System.out.println("BeforeAll test");
    }

    @BeforeEach
    void setUp(){
        System.out.println("BeforeEach test");
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
    void getMagicalTest(){
        System.out.println("Test Damage getter method for magical damages.");

        Damage dmg = new Damage(0,120,0,0);

        assertEquals(120,dmg.getMagical());
    }



}
