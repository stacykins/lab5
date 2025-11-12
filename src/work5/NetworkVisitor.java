package work5;

/**
 * Інтерфейс Visitor — визначає набір операцій для кожного типу елемента.
 * Додаючи нові операції, ми реалізуємо нові класи відвідувачів, не змінюючи елементи.
 */
public interface NetworkVisitor {
    void visit(Cable cable);
    void visit(Server server);
    void visit(Workstation workstation);
    void visit(Network network);
}
