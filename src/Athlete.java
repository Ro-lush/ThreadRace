
public class Athlete extends Thread {
    private final int id;
    private final int speed;
    private final int barriersCount;
    private long finishTime;

    public Athlete(int id, int speed, int barriersCount) {
        this.id = id;
        this.speed = speed;
        this.barriersCount = barriersCount;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();


        for (int i = 1; i <= barriersCount; i++) {

            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Спортсмен № " + id + " пробежал барьер № " + i);
        }

        finishTime = System.currentTimeMillis() - startTime;
        System.out.println("Спортсмен № " + id + " финишировал за " + finishTime + " мс!");
    }

}

