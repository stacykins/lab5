package work5;

/**
 * Елемент мережі: робоча станція.
 */
public class Workstation implements NetworkElement {
    private final String id;
    private final String user;
    private final double baseCost;

    public Workstation(String id, String user, double baseCost) {
        this.id = id;
        this.user = user;
        this.baseCost = baseCost;
    }

    public String getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public double getBaseCost() {
        return baseCost;
    }

    /**
     * Оцінка вартості робочої станції (заглушка).
     */
    public double estimateCost() {
        System.out.printf("Workstation[%s].estimateCost() called: user=%s, baseCost=%.2f%n",
                id, user, baseCost);
        return baseCost;
    }

    @Override
    public void accept(NetworkVisitor visitor) {
        visitor.visit(this);
    }
}
