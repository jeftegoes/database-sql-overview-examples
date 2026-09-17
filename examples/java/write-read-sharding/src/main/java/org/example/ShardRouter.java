package org.example;

public class ShardRouter {
    private final DatabaseServer[] shards;

    public ShardRouter(DatabaseServer... shards) {
        this.shards = shards;
    }

    private DatabaseServer getShard(int customerId) {
        int shardIndex = customerId % shards.length;
        return shards[shardIndex];
    }

    public void saveCustomer(int customerId, String name) {
        DatabaseServer shard = getShard(customerId);

        System.out.println(
                "Customer " + customerId +
                        " -> " + shard.getName()
        );

        shard.save(customerId, name);
    }

    public String findCustomer(int customerId) {
        DatabaseServer shard = getShard(customerId);

        System.out.println(
                "Searching Customer " + customerId +
                        " in " + shard.getName()
        );

        return shard.find(customerId);
    }
}
