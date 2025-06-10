import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static final int BARRIERS_COUNT = 10;
    private static final Random random = new Random();
    public static void main(String[] args) throws InterruptedException {
        int athletesCount = 13;
        List<Athlete> athletes = new ArrayList<>();


        for (int i = 1; i <= athletesCount; i++) {
            Athlete athlete = new Athlete(i, 100 + random.nextInt(200), BARRIERS_COUNT);
            athletes.add(athlete);
            athlete.start();
        }


        for (Athlete athlete : athletes) {
            athlete.join();
        }

        Athlete winner = athletes.get(0);
        Athlete loser = athletes.get(0);

        for (Athlete athlete : athletes) {
            if (athlete.getFinishTime() < winner.getFinishTime()) {
                winner = athlete;
            }
            if (athlete.getFinishTime() > loser.getFinishTime()) {
                loser = athlete;
            }
        }

        System.out.println("Победитель: Спортсмен № " + winner.getId());
        System.out.println("Проигравший: Спортсмен № " + loser.getId());
    }

}