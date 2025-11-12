package work5;

/**
 * Демонстрація створення ієрархії мережі та виконання операцій через Visitor.
 */
public class Main {
    public static void main(String[] args) {
        // Створюємо кореневу мережу
        Network office = new Network("OfficeNet", 50.0);

        // Додаємо сервер
        Server dbServer = new Server("S1", "Dell-R740", 2000.0);
        office.addElement(dbServer);

        // Додаємо кабелі і робочі станції
        Cable c1 = new Cable("C1", 10.0, 2.5);
        Workstation w1 = new Workstation("W1", "alice", 700.0);
        Workstation w2 = new Workstation("W2", "bob", 650.0);

        office.addElement(c1);
        office.addElement(w1);
        office.addElement(w2);

        // Створюємо підмережу (subnet)
        Network floor1 = new Network("Floor1", 20.0);
        floor1.addElement(new Cable("C2", 5.0, 2.5));
        floor1.addElement(new Workstation("W3", "charlie", 600.0));
        office.addElement(floor1);

        // 1) Відобразити структуру
        System.out.println("=== Display network structure ===");
        DisplayVisitor display = new DisplayVisitor();
        office.accept(display);


        System.out.println("\n=== Calculate total cost ===");
        CostCalculatorVisitor costCalc = new CostCalculatorVisitor();
        office.accept(costCalc);
        System.out.printf("Total estimated cost: %.2f%n", costCalc.getTotalCost());


    }
}
