package com.zipcodewilmington.froilansfarm.livingthings;

import com.zipcodewilmington.froilansfarm.crops.EarCorn;
import com.zipcodewilmington.froilansfarm.interfaces.Eater;
import com.zipcodewilmington.froilansfarm.interfaces.Edible;

public abstract class Animal<EdibleType extends Edible> implements Eater<EdibleType> {
    public boolean eat(EdibleType edibleType) {
        return false;
    }

}
