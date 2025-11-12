package work5;

/**
 * Елемент мережі: кабель.
 */
public class Cable implements NetworkElement {
    private final String id;
    private final double lengthMeters;
    private final double costPerMeter;

    public Cable(String id, double lengthMeters, double costPerMeter) {
        this.id = id;
        this.lengthMeters = lengthMeters;
        this.costPerMeter = costPerMeter;
    }

    public String getId() {
        return id;
    }

    public double getLengthMeters() {
        return lengthMeters;
    }

    public double getCostPerMeter() {
        return costPerMeter;
    }


    public double estimateCost() {
        double cost = lengthMeters * costPerMeter;
        System.out.printf("Cable[%s].estimateCost() called: length=%.2f m, unit=%.2f -> cost=%.2f%n",
                id, lengthMeters, costPerMeter, cost);
        return cost;
    }

    @Override
    public void accept(NetworkVisitor visitor) {
        visitor.visit(this);
    }
}
