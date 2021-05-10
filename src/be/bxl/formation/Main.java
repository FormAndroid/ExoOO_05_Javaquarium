package be.bxl.formation;

import be.bxl.formation.enums.GenderEnum;
import be.bxl.formation.interfaces.IBeing;
import be.bxl.formation.models.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Aquarium a = new Aquarium();

        a.addBeing(new Seaweed());
        a.addBeing(new ClownFish("Némo", GenderEnum.MALE));
        a.addBeing(new ClownFish("Roberta", GenderEnum.FEMALE));
        a.addBeing(new Seaweed());
        a.addBeing(new Bar("Fifi"));
        a.addBeing(new Bar("Fifi"));
        a.addBeing(new Bar(10, 11, "Zaza"));
        a.addBeing(new Seaweed());
        a.addBeing(new Tuna("Jo", GenderEnum.MALE));
        a.addBeing(new Seaweed());
        a.addBeing(new Bar(10, 5,"Donald"));
        a.addBeing(new Bar(9, 15,"Daisy"));


        int turn = 1;
        Scanner sc = new Scanner(System.in);

        while(a.getNbFish() > 0) {
            System.out.println("Jour " + turn + "\n");
            System.out.println(" - Event");
            String resume = a.simulation();
            System.out.println(resume);
            System.out.println();

            System.out.println("- Liste des habitants");
            for(IBeing b : a.getBeings()) {
                System.out.println(b);
            }

            turn++;
            System.out.println("\n");
            sc.nextLine();
        }

        System.out.println("Fin !");
    }
}
