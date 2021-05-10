package be.bxl.formation.models;

import be.bxl.formation.enums.FishEnum;
import be.bxl.formation.enums.GenderEnum;
import be.bxl.formation.interfaces.IFish;

import java.time.LocalDateTime;
import java.util.Random;

public class Sole extends HerbivorousFish {

    public Sole(String name, GenderEnum gender) {
        super(name, FishEnum.SOLE, gender);
    }

    public Sole(int hp, int age, String name, GenderEnum gender) {
        super(hp, age, name, FishEnum.SOLE, gender);
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
        Random rng = new Random();
        GenderEnum gender = (rng.nextInt(2) == 0) ? GenderEnum.FEMALE : GenderEnum.MALE;

        //TODO Make random name
        String name = this.getName() + LocalDateTime.now().getSecond();

        return new Sole(name, gender);
    }
}
