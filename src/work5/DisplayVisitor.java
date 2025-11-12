package work5;

/**
 * Конкретний Visitor: виводить структуру мережі у консоль з відступами.
 * Методів обробки багато — кожен елемент викликає лише visit(this).
 */
public class DisplayVisitor implements NetworkVisitor {
    private int indent = 0;

    private void printlnIndented(String s) {
        System.out.print("  ".repeat(Math.max(0, indent)));
        System.out.println(s);
    }

    @Override
    public void visit(Cable cable) {
        printlnIndented(String.format("Cable[id=%s, length=%.2fm, unit=%.2f]",
                cable.getId(), cable.getLengthMeters(), cable.getCostPerMeter()));
    }

    @Override
    public void visit(Server server) {
        printlnIndented(String.format("Server[id=%s, model=%s, baseCost=%.2f]",
                server.getId(), server.getModel(), server.getBaseCost()));
    }

    @Override
    public void visit(Workstation workstation) {
        printlnIndented(String.format("Workstation[id=%s, user=%s, baseCost=%.2f]",
                workstation.getId(), workstation.getUser(), workstation.getBaseCost()));
    }

    @Override
    public void visit(Network network) {
        printlnIndented("Network[name=" + network.getName() + "]");
        indent++;
        for (NetworkElement child : network.getChildren()) {
            child.accept(this);
        }
        indent--;
    }
}
