import java.io.IOException;

public class main {


    public static void main(String[] args) throws IOException {
        ToyStore store = new ToyStore();

        // add some toys
        store.addToy(1,"Lego",10,2.0);
        store.addToy(2,"Robot",5,2.0);
        store.addToy(3,"Doll",20,6.0);

        // set the weight of a toy
        store.setToyWeight(2, 30);

        // play the game
        store.play();

        // get the prize toy

        store.getPrizeToy();
    }
}