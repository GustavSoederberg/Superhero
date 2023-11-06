package domain.comparator;

import domain.Superhero;

import java.util.Comparator;

public class SuperPowerComparator implements Comparator<Superhero> {
    public int compare(Superhero s1, Superhero s2){
        return s1.getSuperPower().compareTo(s2.getSuperPower());
    }
}
