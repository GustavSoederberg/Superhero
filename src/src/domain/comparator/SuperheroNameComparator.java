package domain.comparator;

import domain.Superhero;

import java.util.Comparator;

public class SuperheroNameComparator implements Comparator<Superhero> {
    public int compare(Superhero s1, Superhero s2){
        return s1.getName().compareTo(s2.getName());
    }
}
