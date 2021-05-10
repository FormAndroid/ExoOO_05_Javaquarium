package be.bxl.formation.interfaces;

import be.bxl.formation.enums.FishEnum;
import be.bxl.formation.enums.GenderEnum;

public interface IFish extends IBeing {

    String getName();
    GenderEnum getGender();
    FishEnum getSpecie();
    boolean isHungry();

    void setName(String name);

    boolean eat(IFood food);
    IFish toReproduce(IFish fish);
}
