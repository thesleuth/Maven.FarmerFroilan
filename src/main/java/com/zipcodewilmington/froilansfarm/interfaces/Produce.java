package com.zipcodewilmington.froilansfarm.interfaces;

public interface Produce<EdibeType extends Edible> {
    boolean hasBeenFertilized();

    EdibeType yield();

    void fertilize();
}
