package be.bxl.formation.models;

import be.bxl.formation.enums.FishEnum;
import be.bxl.formation.enums.GenderEnum;
import be.bxl.formation.interfaces.IFish;

import java.time.LocalDateTime;

public class Bar extends HerbivorousFish {

    public Bar(String name) {
        super(name, FishEnum.BAR, GenderEnum.MALE);
    }

    public Bar(int hp, int age, String name) {
        super(hp, age, name, FishEnum.BAR, GenderEnum.MALE);

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
        //TODO Make random name
        String name = this.getName() + LocalDateTime.now().getSecond();

        return new Bar(name);
    }
}
