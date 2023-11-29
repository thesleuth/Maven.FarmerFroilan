package com.zipcodewilmington.froilansfarm.livingthings;

import com.zipcodewilmington.froilansfarm.crops.EarCorn;
import com.zipcodewilmington.froilansfarm.interfaces.Noisemaker;

public class Horse extends Animal<EarCorn> implements Noisemaker {
    public String makeNoise() {
        return null;
    }
}
