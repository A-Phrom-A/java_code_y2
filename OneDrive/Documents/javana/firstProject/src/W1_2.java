import java.util.Scanner;

public class W1_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int initialPopulation = scanner.nextInt();
        int rounds = scanner.nextInt();
        RoachPopulation roachPopulation = new RoachPopulation(initialPopulation);

        for (int i = 0; i < rounds; i++) {
            roachPopulation.waitForDoubling();
            

               roachPopulation.spay();
            
            System.out.println(roachPopulation.getPopulation());
        }
        
    }
}

class RoachPopulation {
    private int population;

    public RoachPopulation(int population) {
        this.population = population;
    }

    public void waitForDoubling() {
        this.population *= 2;
    }

    public void spay() {
        this.population -= Math.round(population * 0.1);
    }

    public int getPopulation() {
        return this.population;
    }
}
