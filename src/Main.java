public class Main {

    public static void main(String[] args) {
        CarFactory factory = new CarFactory();

        separator("GAS CAR");
        Car gasCar = factory.createCar(CarFactory.EngineType.GAS);
        gasCar.start();
        gasCar.accelerate();  // 0 → 20
        gasCar.accelerate();  // 20 → 40
        gasCar.brake();       // 40 → 20
        gasCar.stop();        // 20 → 0

        separator("ELECTRIC CAR");
        Car electricCar = factory.createCar(CarFactory.EngineType.ELECTRIC);
        electricCar.start();
        electricCar.accelerate();  // 0 → 20
        electricCar.accelerate();  // 20 → 40
        electricCar.accelerate();  // 40 → 60
        electricCar.stop();        // 60 → 0

        separator("HYBRID CAR — crossing the 50 km/h threshold");
        Car hybridCar = factory.createCar(CarFactory.EngineType.HYBRID);
        hybridCar.start();
        hybridCar.accelerate();  // 0 → 20  (all electric)
        hybridCar.accelerate();  // 20 → 40 (all electric)
        hybridCar.accelerate();  // 40 → 60 (electric until 49→50, gas from 50 onward)
        hybridCar.brake();       // 60 → 40 (gas until 51→50, electric from 50 onward)
        hybridCar.stop();        // 40 → 0  (all electric)

        separator("ENGINE REPLACEMENT");
        System.out.println("Gas car is at speed: " + gasCar.getSpeed());
        factory.replaceEngine(gasCar, CarFactory.EngineType.HYBRID);
        gasCar.start();
        gasCar.accelerate();  // 0 → 20 (now hybrid)
        gasCar.stop();
    }

    private static void separator(String title) {
        System.out.println("\n══════════════════════════════════════");
        System.out.println("  " + title);
        System.out.println("══════════════════════════════════════");
    }
}
