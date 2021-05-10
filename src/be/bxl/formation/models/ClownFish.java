package be.bxl.formation.models;

import be.bxl.formation.enums.FishEnum;
import be.bxl.formation.enums.GenderEnum;
import be.bxl.formation.helpers.RandomHelper;
import be.bxl.formation.interfaces.IFish;

import java.time.LocalDateTime;
import java.util.Random;

public class ClownFish extends CarnivorousFish {

    public ClownFish(String name, GenderEnum gender) {
        super(name, FishEnum.CLOWN_FISH, gender);
    }

    public ClownFish(int hp, int age, String name, GenderEnum gender) {
        super(hp, age, name, FishEnum.CLOWN_FISH, gender);
    }


    @Override
    protected boolean checkCompatibleForReproduce(IFish fish) {
        boolean isOk = this.getSpecie() == fish.getSpecie();

        if(isOk && this.getGender() == fish.getGender()){
            this.changeGender();
        }

        return isOk;
    }

    @Override
    protected IFish makeBaby() {
        RandomHelper rng = new RandomHelper();
        String name = rng.nextName();
        GenderEnum gender = rng.nextGender();

        return new ClownFish(name, gender);
    }
}
