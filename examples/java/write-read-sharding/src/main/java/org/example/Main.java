package org.example;

public class Main {
    static void main() {
        DatabaseServer db1 = new DatabaseServer("Database Server 1");
        DatabaseServer db2 = new DatabaseServer("Database Server 2");
        DatabaseServer db3 = new DatabaseServer("Database Server 3");

        ShardRouter router = new ShardRouter(db1, db2, db3);

        router.saveCustomer(1, "Alice");
        router.saveCustomer(2, "Bob");
        router.saveCustomer(3, "Charlie");
        router.saveCustomer(4, "David");
        router.saveCustomer(5, "Eva");
        router.saveCustomer(6, "Frank");

        System.out.println("\n--- Database contents ---");

        db1.printData();
        db2.printData();
        db3.printData();

        System.out.println("\n--- Query ---");

        System.out.println(
                "Result: " + router.findCustomer(5)
        );
    }
}
