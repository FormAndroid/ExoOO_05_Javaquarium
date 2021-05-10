package be.bxl.formation.models;

import be.bxl.formation.interfaces.IBeing;

public abstract class Being implements IBeing {

    private int age;
    private int hp;

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public boolean isAlive() {
        return (getHp() > 0) && (getAge() <= 20);
    }


    public Being() {
        this.hp = 10;
        this.age = 0;
    }
    public Being(int hp, int age) {
        this.hp = hp;
        this.age = age;
    }



    protected void incrementAge() {
        this.age++;
    }

    protected void modifyHp(int value)  {
        this.hp += value;
    }

//    protected void modifyHp(boolean gain, int value)  {
//        if(value < 0)
//            throw  new IllegalArgumentException("Value not positive!");
//
//        this.hp = gain ? this.hp + value : this.hp - value;
//    }

    @Override
    public void grow() {
        incrementAge();
    }
}
