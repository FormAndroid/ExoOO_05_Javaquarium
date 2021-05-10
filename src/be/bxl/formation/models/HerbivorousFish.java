package be.bxl.formation.models;

import be.bxl.formation.enums.FishEnum;
import be.bxl.formation.enums.GenderEnum;
import be.bxl.formation.interfaces.IFood;
import be.bxl.formation.interfaces.IVegetalFood;

public abstract class HerbivorousFish extends Fish {

    public HerbivorousFish(String name, FishEnum specie, GenderEnum gender) {
        super(name, specie, gender);
    }

    public HerbivorousFish(int hp, int age, String name, FishEnum specie, GenderEnum gender) {
        super(hp, age, name, specie, gender);
    }

    @Override
    public boolean eat(IFood food) {

        if(food instanceof IVegetalFood) {
            food.toBeEat();
            this.modifyHp(3);
            return  true;
        }
        return false;
    }
}
