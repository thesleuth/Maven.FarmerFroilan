package com.zipcodewilmington.froilansfarm.interfaces;

public interface Eater <EdibleType extends Edible>{
    boolean eat(EdibleType edibleType);
}
