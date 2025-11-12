package work5;

import java.util.ArrayList;
import java.util.List;

/**
 * Комплексний елемент — мережа (Composite). Може містити інші NetworkElement,
 * в тому числі вкладені Network.
 */
public class Network implements NetworkElement {
    private final String name;
    private final List<NetworkElement> children = new ArrayList<>();
    private final double overheadCost; // наприклад, вартість організації підмережі

    public Network(String name, double overheadCost) {
        this.name = name;
        this.overheadCost = overheadCost;
    }

    public String getName() {
        return name;
    }

    public double getOverheadCost() {
        return overheadCost;
    }

    public void addElement(NetworkElement element) {
        children.add(element);
    }

    public void removeElement(NetworkElement element) {
        children.remove(element);
    }

    public List<NetworkElement> getChildren() {
        return new ArrayList<>(children);
    }

    /**
     * Оцінка додаткових витрат на саму підмережу (заглушка).
     */
    public double estimateOverheadCost() {
        System.out.printf("Network[%s].estimateOverheadCost() called: overhead=%.2f%n",
                name, overheadCost);
        return overheadCost;
    }

    @Override
    public void accept(NetworkVisitor visitor) {
        visitor.visit(this);
    }
}
