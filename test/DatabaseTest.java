
import java.util.ArrayList;

import domain.Database;
import domain.Superhero;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DatabaseTest {
    private Database database;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        database = new Database();
        database.addDataSuperheroes();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        database = null;
    }

    @org.junit.jupiter.api.Test
    void addSuperhero() {
        database.addSuperhero("Nick Fury", "Nick Fury", "S.H.I.E.L.D", 1950, true, 89);
        int actualResult = database.size();
        int expectedResult = 6;

        Assertions.assertEquals(expectedResult, actualResult);

    }

    @org.junit.jupiter.api.Test
    void findAllSuperhero() {
        ArrayList<Superhero> searchResult = database.findAllSuperhero("Bat");
        int actualResult = searchResult.size();
        int expectedResult = 2;

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @org.junit.jupiter.api.Test
    void findAllSuperhero2() {
        ArrayList<Superhero> searchResult = database.findAllSuperhero("Bat");
        int actualResult = searchResult.size();
        int expectedResult = 1;

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @org.junit.jupiter.api.Test
    void TestfindSuperhero() {
        String actualResult = database.findSuperhero("Bat").getName();
        String expectedResult = "Batman";

        Assertions.assertEquals(expectedResult, actualResult);
    }
    @org.junit.jupiter.api.Test
    void size() {
        int actualResult = database.size();
        int expectedResult = 5;

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @org.junit.jupiter.api.Test
    void get() {
        Superhero superheroTest = database.get(0);
        String actualResult = superheroTest.getName();
        String expectedResult = "Batman";

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void testRemoveSuperhero() {
        database.removeSuperhero(0);
        int actualResult = database.size();
        int expectedResult = 4;

        Assertions.assertEquals(expectedResult, actualResult);
    }
}