import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class ToyStore {

    Scanner sc = new Scanner(System.in);

    public static ArrayList<Toy> toys = new ArrayList<>();
    public static ArrayList<Toy> prizeToys = new ArrayList<>();
    
    public void addToy(int id, String name,int quantity, Double weight) {
        Toy toy = new Toy(id, name,quantity,weight);
        toys.add(toy);
    }

    public void setToyWeight(int id, double weight) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setWeight(weight);
                break;
            }
        }
    }

    public void play() {
        // calculate total weight
        double totalWeight = 0;
        for (Toy toy : toys) {
            totalWeight += toy.getWeight();
        }

        // generate random number
        Random rand = new Random();
        double randomNumber = rand.nextDouble() * totalWeight;

        // find the prize toy
        Toy prizeToy = null;
        for (Toy toy : toys) {
            if (randomNumber < toy.getWeight()) {
                prizeToy = toy;
                break;
            }
            randomNumber -= toy.getWeight();
        }

        // add the prize toy to the list of prize toys
        if (prizeToy != null && prizeToy.getQuantity() > 0) {
            prizeToys.add(prizeToy);

            // decrement the quantity of the prize toy
            prizeToy.setQuantity(prizeToy.getQuantity() - 1);
        }
    }

    public void getPrizeToy() throws IOException {
        if (prizeToys.size() > 0) {
            // remove the first prize toy from the list of prize toys
            Toy prizeToy = prizeToys.remove(0);

            // write the prize toy to a file
            FileWriter writer = new FileWriter("prize_toys.txt", true);
            writer.write(prizeToy.getId() + "," + prizeToy.getName() + "\n");
            writer.close();
        }
    }
}
