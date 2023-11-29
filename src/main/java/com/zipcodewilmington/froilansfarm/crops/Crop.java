package com.zipcodewilmington.froilansfarm.crops;

import com.zipcodewilmington.froilansfarm.interfaces.Edible;

public abstract class Crop<T extends Edible> {
    public void fertilize() {
    }

    public T yield() {
        return null;
    }
}
