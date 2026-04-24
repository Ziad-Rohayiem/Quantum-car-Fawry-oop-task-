public class ElectricEngine implements Engine {

    private int speed = 0;

    @Override
    public void increase() {
        speed++;
        System.out.println("  [ElectricEngine] speed → " + speed);
    }

    @Override
    public void decrease() {
        speed--;
        System.out.println("  [ElectricEngine] speed → " + speed);
    }

    @Override
    public int getSpeed() {
        return speed;
    }
}
