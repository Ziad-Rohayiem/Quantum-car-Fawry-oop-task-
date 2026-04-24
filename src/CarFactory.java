public class CarFactory {

    public enum EngineType {
        GAS, ELECTRIC, HYBRID
    }

    public Car createCar(EngineType type) {
        Engine engine = buildEngine(type);
        System.out.println("[CarFactory] Created car with " + type + " engine.");
        return new Car(engine);
    }

    public void replaceEngine(Car car, EngineType type) {
        Engine engine = buildEngine(type);
        car.setEngine(engine);
        System.out.println("[CarFactory] Replaced engine with " + type + " engine.");
    }

    private Engine buildEngine(EngineType type) {
        switch (type) {
            case GAS:      return new GasEngine();
            case ELECTRIC: return new ElectricEngine();
            case HYBRID:   return new HybridEngine();
            default:       throw new IllegalArgumentException("Unknown engine type: " + type);
        }
    }
}
