public class Car {

    private static final int MAX_SPEED = 200;
    private static final int SPEED_STEP = 20;

    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        System.out.println("[Car] Starting engine at speed 0.");
    }

    public void stop() {
        System.out.println("[Car] Stopping — reducing speed to 0 first.");
        while (engine.getSpeed() > 0) {
            engine.decrease();
        }
        System.out.println("[Car] Engine stopped.");
    }

    public void accelerate() {
        int current = engine.getSpeed();
        if (current >= MAX_SPEED) {
            System.out.println("[Car] Already at max speed (" + MAX_SPEED + " km/h). Cannot accelerate.");
            return;
        }
        int steps = Math.min(SPEED_STEP, MAX_SPEED - current);
        System.out.println("[Car] Accelerating by " + steps + " km/h...");
        for (int i = 0; i < steps; i++) {
            engine.increase();
        }
        System.out.println("[Car] Speed is now " + engine.getSpeed() + " km/h.");
    }

    public void brake() {
        int current = engine.getSpeed();
        if (current == 0) {
            System.out.println("[Car] Already stopped. Cannot brake further.");
            return;
        }
        int steps = Math.min(SPEED_STEP, current);
        System.out.println("[Car] Braking by " + steps + " km/h...");
        for (int i = 0; i < steps; i++) {
            engine.decrease();
        }
        System.out.println("[Car] Speed is now " + engine.getSpeed() + " km/h.");
    }

    public int getSpeed() {
        return engine.getSpeed();
    }
}
