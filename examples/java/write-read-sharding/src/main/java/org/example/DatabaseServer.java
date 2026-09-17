package org.example;

import java.util.HashMap;
import java.util.Map;

public class DatabaseServer {
    private final String name;
    private final Map<Integer, String> customers = new HashMap<>();

    public DatabaseServer(String name) {
        this.name = name;
    }

    public void save(int customerId, String name) {
        customers.put(customerId, name);
    }

    public String find(int customerId) {
        return customers.get(customerId);
    }

    public void printData() {
        System.out.println(name + ": " + customers);
    }

    public String getName() {
        return name;
    }
}
