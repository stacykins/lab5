package work5;

/**
 * Елемент мережі: сервер.
 */
public class Server implements NetworkElement {
    private final String id;
    private final String model;
    private final double baseCost;

    public Server(String id, String model, double baseCost) {
        this.id = id;
        this.model = model;
        this.baseCost = baseCost;
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public double getBaseCost() {
        return baseCost;
    }

    /**
     * Оцінка вартості сервера (заглушка).
     */
    public double estimateCost() {
        System.out.printf("Server[%s].estimateCost() called: model=%s, baseCost=%.2f%n",
                id, model, baseCost);
        return baseCost;
    }

    @Override
    public void accept(NetworkVisitor visitor) {
        visitor.visit(this);
    }
}
