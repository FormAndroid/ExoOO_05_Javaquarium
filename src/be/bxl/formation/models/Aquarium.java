package be.bxl.formation.models;

import be.bxl.formation.helpers.RandomHelper;
import be.bxl.formation.interfaces.IBeing;
import be.bxl.formation.interfaces.IFish;
import be.bxl.formation.interfaces.IFood;
import be.bxl.formation.interfaces.ISeaweed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Aquarium {

    private ArrayList<IBeing> beings;

    public List<IBeing> getBeings() {
        return Collections.unmodifiableList(beings);
    }

    public void addBeing(IFish fish) {
        this.beings.add(fish);
    }

    public void addBeing(ISeaweed seaweed) {
        this.beings.add(seaweed);
    }

    public int getNbFish() {
        int count = 0;
        for (IBeing b : beings) {
            if (b instanceof IFish) {
                count++;
            }
        }
        return count;
    }

    public int getNbSeaweed() {
        int count = 0;
        for (IBeing b : beings) {
            if (b instanceof ISeaweed) {
                count++;
            }
        }
        return count;
    }

    public Aquarium() {
        this.beings = new ArrayList<>();
    }

    private IFood searchFood() {
        RandomHelper rng = new RandomHelper();

        int targetIndex = rng.nextInt(this.beings.size());
        IBeing target = this.beings.get(targetIndex);

        if (!target.isAlive()) {
            return null; // Pas de chance :p
        }

        return (target instanceof IFood) ? (IFood) target : null;
    }

    private IFish searchPartner() {
        int nbFish = getNbFish();

        if (nbFish == 0) {
            return null;
        } else if (nbFish == 1) {
            // Utilisation d'un stream => Matiere aborbé plus tard ;)
            return (IFish) beings.stream().filter(b -> b instanceof IFish).findFirst().orElseThrow();
        }

        RandomHelper rng = new RandomHelper();
        boolean found = false;
        int target;

        do {
            target = rng.nextInt(beings.size());

            if (beings.get(target) instanceof IFish) {
                found = true;
            }
        } while (!found);

        return (IFish) beings.get(target);
    }

    public String simulation() {
        StringBuilder sb = new StringBuilder();

        // Debut de journée
        for (IBeing b : beings) {
            b.grow();

            if (!b.isAlive()) {
                sb.append(b).append(" est mort de vieillesse").append("\n");
            }
        }

        // Nourriture
        for (IBeing b : beings) {
            if (b instanceof IFish fish) {
                IFood food = searchFood();
                boolean hasEat = fish.eat(food);

                if(hasEat) {
                    sb.append(fish).append(" mange ").append(food).append("\n");

                    if (food instanceof IBeing bf && !bf.isAlive()) {
                        sb.append(fish).append(" a tué ").append(food).append("\n");
                    }
                }

            }
        }

        // Reproduction
        ArrayList<IBeing> babies = new ArrayList<>();
        for (IBeing b : beings) {
            IBeing baby = null;

            // Poisson
            if (b instanceof IFish fish) {
                IFish partner = searchPartner();
                baby = fish.toReproduce(partner);
            }

            // Algue
            if (b instanceof ISeaweed seaweed) {
                baby = seaweed.toMultiply();
            }

            if (baby != null) {
                babies.add(baby);

                sb.append(baby).append(" vien de naitre").append("\n");
            }
        }
        this.beings.addAll(babies);

        //Retrait des poissons morts
        for (int i = beings.size() -1; i >= 0; i--) {
            if(!beings.get(i).isAlive()) {
                beings.remove(i);
            }
        }

        return sb.toString();
    }
}
