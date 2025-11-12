package work5;

/**
 * Загальний інтерфейс для всіх елементів мережі.
 * Кожен елемент повинен вміти прийняти відвідувача (Visitor).
 */
public interface NetworkElement {
    /**
     * Прийняти відвідувача, який виконає операцію над елементом.
     * @param visitor відвідувач (операція)
     */
    void accept(NetworkVisitor visitor);
}
