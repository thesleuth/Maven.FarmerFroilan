package com.zipcodewilmington.froilansfarm.livingthings;

import com.zipcodewilmington.froilansfarm.crops.Crop;
import com.zipcodewilmington.froilansfarm.crops.CropRow;
import com.zipcodewilmington.froilansfarm.interfaces.Botanist;
import com.zipcodewilmington.froilansfarm.interfaces.Rideable;
import com.zipcodewilmington.froilansfarm.interfaces.Rider;

public class Farmer extends Person implements Rider, Botanist {
    public boolean mount(Rideable rideable) {
        return false;
    }

    public boolean dismount(Rideable rideable) {
        return false;
    }

    public boolean plant(Crop crop, CropRow cropRow) {
        return false;
    }
}
