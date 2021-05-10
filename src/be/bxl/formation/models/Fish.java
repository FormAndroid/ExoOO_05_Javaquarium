package be.bxl.formation.models;

import be.bxl.formation.enums.FishEnum;
import be.bxl.formation.enums.GenderEnum;
import be.bxl.formation.interfaces.IFish;
import be.bxl.formation.interfaces.IFood;
import be.bxl.formation.interfaces.IMeatFood;

public abstract class Fish extends Being implements IFish, IMeatFood {

    private String name;
    private FishEnum specie;
    private GenderEnum gender;


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public FishEnum getSpecie() {
        return specie;
    }

    @Override
    public GenderEnum getGender() {
        return gender;
    }

    @Override
    public boolean isHungry() {
        return getHp() <= 5;
    }


    public Fish(String name, FishEnum specie, GenderEnum gender) {
        super();
        this.name = name;
        this.specie = specie;
        this.gender = gender;
    }

    public Fish(int hp, int age, String name, FishEnum specie, GenderEnum gender) {
        super(hp, age);
        this.name = name;
        this.specie = specie;
        this.gender = gender;
    }


    protected void changeGender() {
        this.gender = (this.gender == GenderEnum.MALE) ? GenderEnum.FEMALE : GenderEnum.MALE;
    }

    @Override
    public abstract void eat(IFood food);

    protected boolean checkCompatibleForReproduce(IFish fish) {
        return this.getSpecie() == fish.getSpecie()
                && this.getGender() != fish.getGender();
    }

    protected abstract IFish makeBaby();

    @Override
    public IFish toReproduce(IFish fish) {

        if(checkCompatibleForReproduce(fish)) {
            return makeBaby();
        }

        return null;
    }

    @Override
    public void toBeEat() {
        this.modifyHp(-4);
    }
}
