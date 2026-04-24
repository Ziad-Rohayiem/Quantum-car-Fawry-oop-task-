public class GasEngine implements Engine {

    private int speed = 0;

    @Override
    public void increase() {
        speed++;
        System.out.println("  [GasEngine] speed → " + speed);
    }

    @Override
    public void decrease() {
        speed--;
        System.out.println("  [GasEngine] speed → " + speed);
    }

    @Override
    public int getSpeed() {
        return speed;
    }
}
