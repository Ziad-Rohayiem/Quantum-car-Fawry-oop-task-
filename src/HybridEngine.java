public class HybridEngine implements Engine {

    private static final int THRESHOLD = 50;

    private final GasEngine gasEngine;
    private final ElectricEngine electricEngine;
    private int speed = 0;

    public HybridEngine() {
        this.gasEngine = new GasEngine();
        this.electricEngine = new ElectricEngine();
    }

    @Override
    public void increase() {
        if (speed < THRESHOLD) {
            System.out.println("  [HybridEngine] speed " + speed + " < " + THRESHOLD + " → delegating to ElectricEngine");
            electricEngine.increase();
        } else {
            System.out.println("  [HybridEngine] speed " + speed + " >= " + THRESHOLD + " → delegating to GasEngine");
            gasEngine.increase();
        }
        speed++;
    }

    @Override
    public void decrease() {
        if (speed <= THRESHOLD) {
            System.out.println("  [HybridEngine] speed " + speed + " <= " + THRESHOLD + " → delegating to ElectricEngine");
            electricEngine.decrease();
        } else {
            System.out.println("  [HybridEngine] speed " + speed + " > " + THRESHOLD + " → delegating to GasEngine");
            gasEngine.decrease();
        }
        speed--;
    }

    @Override
    public int getSpeed() {
        return speed;
    }
}
