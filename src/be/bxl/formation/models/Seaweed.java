package be.bxl.formation.models;

import be.bxl.formation.interfaces.ISeaweed;
import be.bxl.formation.interfaces.IVegetalFood;

public class Seaweed extends Being implements ISeaweed, IVegetalFood {

    public Seaweed() {
    }

    public Seaweed(int hp, int age) {
        super(hp, age);
    }

    @Override
    public void grow() {
        super.grow();

        if(isAlive()) {
            this.modifyHp(1);
        }
    }

    @Override
    public ISeaweed toMultiply() {
        if(getHp() < 10)
            return null;

        int babyHp = getHp() / 2;
        this.modifyHp(-babyHp);

        return new Seaweed(babyHp, 0);
    }

    @Override
    public void toBeEat() {
        this.modifyHp(-2);
    }
}
