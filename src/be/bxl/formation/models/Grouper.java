package be.bxl.formation.models;

import be.bxl.formation.enums.FishEnum;
import be.bxl.formation.enums.GenderEnum;
import be.bxl.formation.helpers.RandomHelper;
import be.bxl.formation.interfaces.IFish;

import java.time.LocalDateTime;

public class Grouper extends CarnivorousFish {

    public Grouper(String name) {
        super(name, FishEnum.GROUPER, GenderEnum.MALE);
    }

    public Grouper(int hp, int age, String name) {
        super(hp, age, name, FishEnum.GROUPER, GenderEnum.MALE);

        if(age >= 10)
            changeGender();
    }


    @Override
    public void grow() {
        super.grow();

        if(isAlive() && getAge() == 10) {
            changeGender();
        }
    }

    @Override
    protected IFish makeBaby() {
        RandomHelper rng = new RandomHelper();
        String name = rng.nextName();

        return new Grouper(name);
    }
}
