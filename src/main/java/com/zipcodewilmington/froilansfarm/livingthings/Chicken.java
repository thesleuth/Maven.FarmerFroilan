package com.zipcodewilmington.froilansfarm.livingthings;

import com.zipcodewilmington.froilansfarm.crops.EdibleEgg;
import com.zipcodewilmington.froilansfarm.interfaces.Produce;

public class Chicken extends Animal implements Produce<EdibleEgg> {

    public boolean hasBeenFertilized() {
        return false;
    }

    public EdibleEgg yield() {
        return null;
    }

    public void fertilize() {

    }
}
