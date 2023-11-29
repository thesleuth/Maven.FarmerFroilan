package com.zipcodewilmington.froilansfarm;

import com.zipcodewilmington.froilansfarm.crops.*;
import com.zipcodewilmington.froilansfarm.equipment.CropDuster;
import com.zipcodewilmington.froilansfarm.equipment.Tractor;
import com.zipcodewilmington.froilansfarm.equipment.Vehicle;
import com.zipcodewilmington.froilansfarm.interfaces.*;
import com.zipcodewilmington.froilansfarm.livingthings.*;
import com.zipcodewilmington.froilansfarm.storingthings.ChickenCoop;
import com.zipcodewilmington.froilansfarm.storingthings.FarmField;
import com.zipcodewilmington.froilansfarm.storingthings.Farmhouse;
import com.zipcodewilmington.froilansfarm.storingthings.HorseStable;
import org.junit.Assert;
import org.junit.Test;

public class LivingThingsTests {

    @Test
    public void AnimalHorseTest(){
        Horse horse = new Horse();
        Assert.assertTrue(horse instanceof Animal);
    }
    @Test
    public void AnimalChickenTest(){
        Chicken chicken = new Chicken();
        Assert.assertTrue(chicken instanceof Animal);
    }

    @Test
    public void ProduceChickenTest(){
        Chicken chicken = new Chicken();
        Assert.assertTrue(chicken instanceof Produce);
    }

    @Test
    public void NotFertilizedChickenTest(){
        Chicken chicken = new Chicken();
        Assert.assertFalse(chicken.hasBeenFertilized());
    }
    @Test
    public void UnfertilizedYieldChickenTest(){
        Chicken chicken = new Chicken();
        Edible edible = chicken.yield();
        Assert.assertTrue(edible instanceof EdibleEgg);
    }
    @Test
    public void FertilizedYieldChickenTest(){
        Chicken chicken = new Chicken();
        chicken.fertilize();
        Edible edible = chicken.yield();
        Assert.assertTrue(edible == null);
    }

    @Test
    public void EaterHorseTest(){
        Horse horse = new Horse();
        Assert.assertTrue(horse instanceof Eater);
    }
    @Test
    public void EatsHorseTest(){
        Horse horse = new Horse();
        EarCorn earcorn = new EarCorn();

        Assert.assertTrue(horse.eat(earcorn));
    }

    @Test
    public void RideableHorseTest(){
        Horse horse = new Horse();
        Assert.assertTrue(horse instanceof Rideable);
    }
    @Test
    public void NoisemakerHorseTest(){
        Horse horse = new Horse();
        Assert.assertTrue(horse instanceof Noisemaker);
    }
    @Test
    public void NoisemakerMakeNoiceHorseTest(){
        Horse horse = new Horse();
        String noise = "Neigh!";
        String actual = horse.makeNoise();

        Assert.assertEquals(noise,actual);
    }

    @Test
    public void RiderCanMountTest(){
        Rider rider = new Farmer();
        Rideable rideable = new Tractor();
        Assert.assertTrue(rider.mount(rideable));
    }

    @Test
    public void RiderCanDismountTest(){
        Rider rider = new Farmer();
        Rideable rideable = new Tractor();
        rider.mount(rideable);
        Assert.assertTrue(rider.dismount(rideable));
    }

    @Test
    public void BotanistCanPlantCropInCropRowTest(){
        Botanist botanist = new Farmer();
        CropRow<CornStalk> cropRow = new CornStalkRow();
        Crop<EarCorn> crop = new CornStalk();
        Assert.assertTrue(botanist.plant(crop, cropRow));
    }

    @Test
    public void CropRowCanStoreCropsTest(){
        CropRow<CornStalk> cropRow = new CornStalkRow();
        CornStalk crop1 = new CornStalk();
        CornStalk crop2 = new CornStalk();
        cropRow.add(crop1);
        cropRow.add(crop2);
        Assert.assertTrue(cropRow.size() == 2);
    }

    @Test
    public void FieldCanStoreCropRowsTest(){
        CropRow<CornStalk> cropRow1 = new CornStalkRow();
        CropRow<CornStalk> cropRow2 = new CornStalkRow();
        FarmField farmField = new FarmField();
        farmField.add(cropRow1);
        farmField.add(cropRow2);

        Assert.assertTrue(farmField.size() == 2);
    }

    @Test
    public void VehicleNoisemakerTest(){
        Vehicle vehicle = new Tractor();
        Assert.assertTrue(vehicle instanceof Noisemaker);
    }

    @Test
    public void VehicleRideableTest(){
        Vehicle vehicle = new Tractor();
        Assert.assertTrue(vehicle instanceof Rideable);
    }

    @Test
    public void FarmVehicleOperateOnFarmTest(){

    }

    @Test
    public void TractorFarmVehicleTest(){
        Tractor tractor = new Tractor();
        Assert.assertTrue(tractor instanceof FarmVehicle);
    }

    /**
     *      * Tractor is a FarmVehicle which can harvest a Crop.
     *      * Aircraft are Vehicle which can fly
     */
    @Test
    public void TractorHarvestCropTest(){
        Tractor tractor = new Tractor();
        CornStalk cornStalk = new CornStalk();
        cornStalk.fertilize();
        Edible earcorn = tractor.harvest(cornStalk);
        Assert.assertTrue(earcorn != null);
    }

    @Test
    public void AircraftVehicleTest(){
        Aircraft aircraft = new CropDuster();
        Assert.assertTrue(aircraft instanceof Vehicle);
    }

    @Test
    public void AircraftFlyTest(){
        Aircraft aircraft = new CropDuster();
        Assert.assertTrue(aircraft.fly());
    }

    @Test
    public void CropdusterFarmVehicleTest(){
        CropDuster cropduster = new CropDuster();
        Assert.assertTrue(cropduster instanceof FarmVehicle);
    }
    @Test
    public void CropdusterAircraftTest(){
        CropDuster cropduster = new CropDuster();
        Assert.assertTrue(cropduster instanceof Aircraft);
    }
    @Test
    public void CropdusterFertilizeCropRowTest(){
        CropDuster cropduster = new CropDuster();
        CropRow<CornStalk> cropRow = new CornStalkRow();
        Assert.assertTrue(cropduster.fertilize(cropRow));

    }
    @Test
    public void ProduceUnfertizedYieldTest(){
        CornStalk produce = new CornStalk();
        EarCorn edible = produce.yield();
        Assert.assertTrue(edible == null);
    }
    @Test
    public void ProduceFertizedYieldTest(){
        CornStalk produce = new CornStalk();
        produce.fertilize();
        EarCorn edible = produce.yield();
        Assert.assertTrue(edible == null);
    }

    @Test
    public void CropProduceTest(){
        Crop<EarCorn> cornStalk = new CornStalk();
        Assert.assertTrue(cornStalk instanceof Produce);
    }

    @Test
    public void CropUnHarvestedUnfertilizedYieldTest(){

    }

    @Test
    public void CropUnHarvestedFertilizedYieldTest(){

    }
    @Test
    public void CropYieldHarvestedFertilizedEdibleTest(){

    }

    @Test
    public void CropYieldHarvestedUnfertilizedEdibleTest(){

    }
    @Test
    public void CornstalkCropTest(){
        CornStalk cornStalk = new CornStalk();
        Assert.assertTrue(cornStalk instanceof Crop);
    }
    @Test
    public void CornstalkCropYieldTest(){

    }
    @Test
    public void TomatoPlantCropTest(){
        TomatoPlant tomatoPlant = new TomatoPlant();
        Assert.assertTrue(tomatoPlant instanceof Crop);
    }

    @Test
    public void TomatoPlantCropYieldTest(){

    }

    @Test
    public void PersonNoisemakerTest(){
        Person person = new Person();
        Assert.assertTrue(person instanceof Noisemaker);
    }

    @Test
    public void PersonNoisemakerMakeNoiseTest(){

    }
    @Test
    public void PersonEatEdibleTest(){

    }
    //     * Farmer is an Eater, a Rider, a Botanist, and a Person.
    @Test
    public void FarmerEaterTest(){
        Farmer farmer = new Farmer();
        Assert.assertTrue(farmer instanceof Eater);
    }
    @Test
    public void FarmerRiderTest(){
        Farmer farmer = new Farmer();
        Assert.assertTrue(farmer instanceof Rider);

    }
    @Test
    public void FarmerBotanistTest(){
        Farmer farmer = new Farmer();
        Assert.assertTrue(farmer instanceof Botanist);

    }
    @Test
    public void FarmerPersonTest(){
        Farmer farmer = new Farmer();
        Assert.assertTrue(farmer instanceof Person);

    }

    /**
     * Stable stores many Horse.
     *      *
     *      * FarmHouse stores many Person
     *      *
     *      * ChickenCoop stores many Chicken
     *      *
     *      * Farm stores many Stable, many ChickenCoop, and a single FarmHouse
     */

    @Test
    public void StableStoreHorseTest(){
        HorseStable stable = new HorseStable();
        Horse horse1 = new Horse();
        Horse horse2 = new Horse();
        stable.add(horse1);
        stable.add(horse2);
        Assert.assertTrue(stable.size() == 2);
    }

    @Test
    public void FarmHouseStorePersonTest(){
        Farmhouse farmhouse = new Farmhouse();
        Person person1 = new Farmer();
        Person person2 = new Farmer();
        farmhouse.add(person1);
        farmhouse.add(person2);
        Assert.assertTrue(farmhouse.size() == 2);
    }

    @Test
    public void ChickenCoopStableStoreChickenTest(){
        ChickenCoop chickenCoop = new ChickenCoop();
        Chicken chicken1 = new Chicken();
        Chicken chicken2 = new Chicken();
        chickenCoop.add(chicken1);
        chickenCoop.add(chicken2);
        Assert.assertTrue(chickenCoop.size() == 2);
    }

    @Test
    public void FarmStoreStableTest(){

    }

    @Test
    public void FarmStoreChickenCoopTest(){

    }

    @Test
    public void FarmStoreFarmHouseTest(){

    }




    /**
     * Rider can mount and dismount a Rideable object.
     *
     * Botanist can plant a Crop in a CropRow.
     *
     * CropRow can store many Crop.
     *
     * Field can store many CropRow
     *
     * Vehicle are NoiseMaker and Rideable
     *
     * FarmVehicle can operate on a Farm
     *
     * Tractor is a FarmVehicle which can harvest a Crop.
     * Aircraft are Vehicle which can fly
     *
     * CropDuster is a FarmVehicle and Aircraft which can fertilize a CropRow
     * Produce can yield an Edible object depending on their hasBeenFertilized flag.
     *
     * Crop is a Produce which can yield an Edible object depending on its hasBeenHarvested and hasBeenFertilized flag.
     * CornStalk is a Crop which can yield a EarCorn
     * TomatoPlant is a Crop which can yield a Tomato
     * Person can makeNoise and can eat an Edible object.
     *
     * Farmer is an Eater, a Rider, a Botanist, and a Person.
     *
     * Stable stores many Horse.
     *
     * FarmHouse stores many Person
     *
     * ChickenCoop stores many Chicken
     *
     * Farm stores many Stable, many ChickenCoop, and a single FarmHouse
     */



}
