package be.bxl.formation.models;

import be.bxl.formation.enums.FishEnum;
import be.bxl.formation.enums.GenderEnum;
import be.bxl.formation.interfaces.IFood;
import be.bxl.formation.interfaces.IMeatFood;

public abstract class CarnivorousFish extends Fish{

    public CarnivorousFish(String name, FishEnum specie, GenderEnum gender) {
        super(name, specie, gender);
    }

    public CarnivorousFish(int hp, int age, String name, FishEnum specie, GenderEnum gender) {
        super(hp, age, name, specie, gender);
    }

    @Override
    public boolean eat(IFood food) {

        if(food instanceof IMeatFood) {
            food.toBeEat();
            this.modifyHp(5);
            return true;
        }
        return false;
    }
}
