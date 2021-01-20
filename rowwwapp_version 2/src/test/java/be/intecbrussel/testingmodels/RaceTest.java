package be.intecbrussel.testingmodels;

import be.intecbrussel.models.competition.Race;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;


public class RaceTest {

    Race race1 = new Race();

    @Test
    public void construct(){

        assertNotNull(race1);
    }
    @Test
    public void getNumber(){
        Assert.assertNull(race1.getNumber());
    }

}
