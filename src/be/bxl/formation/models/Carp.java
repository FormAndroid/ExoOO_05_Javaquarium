package be.bxl.formation.models;

import be.bxl.formation.enums.FishEnum;
import be.bxl.formation.enums.GenderEnum;
import be.bxl.formation.helpers.RandomHelper;
import be.bxl.formation.interfaces.IFish;

import java.time.LocalDateTime;
import java.util.Random;

public class Carp extends HerbivorousFish{

    public Carp(String name, GenderEnum gender) {
        super(name, FishEnum.CARP, gender);
    }

    public Carp(int hp, int age, String name, GenderEnum gender) {
        super(hp, age, name, FishEnum.CARP, gender);
    }


    @Override
    protected IFish makeBaby() {
        RandomHelper rng = new RandomHelper();
        String name = rng.nextName();
        GenderEnum gender = rng.nextGender();

        return new Carp(name, gender);
    }
}
