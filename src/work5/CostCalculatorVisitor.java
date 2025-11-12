package work5;

/**
 * Конкретний Visitor: обчислює сумарну вартість всієї структури.
 * При обході викликає методи estimateCost/estimateOverheadCost у елементів
 * (які виводять заглушки) та накопичує суму.
 */
public class CostCalculatorVisitor implements NetworkVisitor {
    private double totalCost = 0.0;
    private int indentLevel = 0;

    private void indentPrint(String msg) {
        System.out.print("  ".repeat(Math.max(0, indentLevel)));
        System.out.println(msg);
    }

    public double getTotalCost() {
        return totalCost;
    }

    @Override
    public void visit(Cable cable) {
        indentPrint("Visiting Cable: " + cable.getId());
        double cost = cable.estimateCost();
        totalCost += cost;
    }

    @Override
    public void visit(Server server) {
        indentPrint("Visiting Server: " + server.getId());
        double cost = server.estimateCost();
        totalCost += cost;
    }

    @Override
    public void visit(Workstation workstation) {
        indentPrint("Visiting Workstation: " + workstation.getId());
        double cost = workstation.estimateCost();
        totalCost += cost;
    }

    @Override
    public void visit(Network network) {
        indentPrint("Entering Network: " + network.getName());
        indentLevel++;
        double overhead = network.estimateOverheadCost();
        totalCost += overhead;
        for (NetworkElement child : network.getChildren()) {
            child.accept(this); // рекурсивний обхід
        }
        indentLevel--;
        indentPrint("Leaving Network: " + network.getName());
    }
}
