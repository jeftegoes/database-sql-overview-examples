# Sharding <!-- omit in toc -->

## Contents <!-- omit in toc -->

- [1. What is sharding?](#1-what-is-sharding)
- [2. Consistent Hashing](#2-consistent-hashing)
  - [2.1. Hash Ring](#21-hash-ring)
- [3. Horizontal Partitioning vs Sharding](#3-horizontal-partitioning-vs-sharding)
- [4. Example Code with Java](#4-example-code-with-java)
- [5. Pros of Sharding](#5-pros-of-sharding)
- [6. Cons of Sharding](#6-cons-of-sharding)

# 1. What is sharding?

- Traditionally, applications use one centralized database with very large tables.
  ![Without sharding](/images/without-sharding.png)
- **As the amount of data increases**
  - Tables become larger.
  - Indexes also grow.
  - Queries can become slower.
  - More CPU and memory are required.
  - Eventually, scaling a single database server becomes difficult.Sharding
- Sharding solves this by splitting a large table across multiple database servers.
  ![With sharding](/images/with-sharding.png)

# 2. Consistent Hashing

- Consistent Hashing is a technique for distributing keys across servers consistently.
- **Its main idea is:** Given the same key, we can consistently determine which server should contain the data.
- It is particularly useful when servers are added or removed, because it helps minimize the amount of data that needs to be redistributed.
  ![Consistent Hashing](/images/consistent-hashing.png)

## 2.1. Hash Ring

- Consistent hashing is commonly represented as a hash ring:
  ![Hash Ring](/images/hash-ring.png)
- Each server/node occupies a position on the ring, and a key is hashed to a position that determines which node handles it.

# 3. Horizontal Partitioning vs Sharding

- HP splits big table into multiple tables in the same database.
- Sharding splits big table into multiple tables across multiple database servers.
- HP table name changes (or schema).
- Sharding everything is the same but server changes.

# 4. Example Code with Java

- Spin up 3 postgres instances with identical schema.
  - 5432, 5433, 5434.
- Write to the sharded databases.
- Reads from the sharded databases.
- [Example Code with Java](/examples/java/write-read-sharding/)

# 5. Pros of Sharding

- **Scalability**
  - Data.
  - Memory.
- Security (users can access certain shards).
- Optimal and Smaller index size.

# 6. Cons of Sharding

- Complex client (aware of the shard).
- Transactions across shards problem.
- Rollbacks.
- Schema changes are hard.
- Joins.
- Has to be something we know in the query.
