package be.bxl.formation.helpers;

import be.bxl.formation.enums.GenderEnum;

import java.util.Random;

public class RandomHelper extends Random {

    public int nextInt(int minBound, int maxBound) {
        return (this.nextInt(maxBound - minBound)) + minBound;
    }

    public GenderEnum nextGender() {
        return (super.nextInt() == 0) ? GenderEnum.FEMALE : GenderEnum.MALE;
    }

    public String nextName() {
        int lenght = this.nextInt(5, 7);

        StringBuilder sb = new StringBuilder();
        sb.append((char)this.nextInt(65, 91));
        for (int i = 0; i < lenght; i++) {
            sb.append((char)this.nextInt(97, 123));
        }

        return sb.toString();
    }
}
