package com.zipcodewilmington.froilansfarm.equipment;

import com.zipcodewilmington.froilansfarm.crops.CornStalk;
import com.zipcodewilmington.froilansfarm.crops.CropRow;
import com.zipcodewilmington.froilansfarm.interfaces.Aircraft;

public class CropDuster implements Aircraft {
    public boolean fly() {
        return false;
    }

    public boolean fertilize(CropRow cropRow) {
        return false;
    }
}
