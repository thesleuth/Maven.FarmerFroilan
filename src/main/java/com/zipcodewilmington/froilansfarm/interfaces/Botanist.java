package com.zipcodewilmington.froilansfarm.interfaces;

import com.zipcodewilmington.froilansfarm.crops.CropRow;
import com.zipcodewilmington.froilansfarm.crops.Crop;

public interface Botanist {
    boolean plant(Crop crop, CropRow cropRow);
}
