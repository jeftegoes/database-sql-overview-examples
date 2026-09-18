# ACID <!-- omit in toc -->

## Contents <!-- omit in toc -->

- [1. What is a Transaction?](#1-what-is-a-transaction)
- [2. Nature of Transactions](#2-nature-of-transactions)
- [3. Atomicity](#3-atomicity)
  - [3.1. Isolation](#31-isolation)
- [4. Isolation - Isolation Levels for inflight transactions](#4-isolation---isolation-levels-for-inflight-transactions)
- [5. Isolation Levels vs read phenomena](#5-isolation-levels-vs-read-phenomena)
- [6. Database Implementation of Isolation](#6-database-implementation-of-isolation)
- [7. Consistency](#7-consistency)
  - [7.1. Consistency in Data](#71-consistency-in-data)
  - [7.2. Consistency in reads](#72-consistency-in-reads)
- [8. Durability](#8-durability)
  - [8.1. WAL](#81-wal)
  - [8.2. OS Cache](#82-os-cache)

# 1. What is a Transaction?

- A collection of queries.
- One unit of work.
- E.g. Account deposit (`SELECT`, `UPDATE`, `UPDATE`).
- **Transaction Lifespan**
  - Transaction `BEGIN`.
  - Transaction `COMMIT`.
  - Transaction `ROLLBACK`.
  - Transaction unexpected ending = `ROLLBACK` (e.g. crash).

# 2. Nature of Transactions

- Usually Transactions are used to change and modify data.
- However, it is perfectly normal to have a read only transaction.
- E.g. We want to generate a report and we want to get consistent snapshot based at the time of transaction.
  ![ACID - Transaction](/images/acid-transaction.png)

# 3. Atomicity

- All queries in a transaction must succeed.
- If one query fails, all prior successful queries in the transaction should rollback.
- If the database went down prior to a commit of a transaction, all the successful queries in the transactions should rollback.
- **Situation**
  ![ACID - Atomicity](/images/acid-atomicity.png)
  - After we restarted the machine the first account has been debited but the other account has not been credited.
  - This is really bad as we just lost data, and the information is inconsistent.
  - An atomic transaction is a transaction that will rollback all queries if one or more queries failed.
  - The database should clean this up after restart.

## 3.1. Isolation

- Can my inflight transaction see changes made by other transactions?
- Read phenomena.
- Isolation Levels.
- **Read phenomena**
  - Dirty reads.
  - Non-repeatable reads.
  - Phantom reads.
  - Lost updates.

# 4. Isolation - Isolation Levels for inflight transactions

- Read uncommitted - No Isolation, any change from the outside is visible to the transaction, committed or not.
- Read committed - Each query in a transaction only sees committed changes by other transactions
- Repeatable Read - The transaction will make sure that when a query reads a row, that row will remain unchanged while its running.
- Snapshot - Each query in a transaction only sees changes that have been committed up to the start of the transaction.
  - It's like a snapshot version of the database at that moment.
- Serializable - Transactions are run as if they serialized one after the other.
- Each DBMS implements Isolation level differently.

# 5. Isolation Levels vs read phenomena

https://en.wikipedia.org/wiki/Isolation_(database_systems)

# 6. Database Implementation of Isolation

- Each DBMS implements Isolation level differently.
- Pessimistic - Row level locks, table locks, page locks to avoid lost updates.
- Optimistic - No locks, just track if things changed and fail the transaction if so.
- Repeatable read "locks" the rows it reads but it could be expensive if we read a lot of rows, postgres implements RR as snapshot. That is why we don't get phantom reads with postgres in repeatable read.
- Serializable are usually implemented with optimistic concurrency control, we can implement it pessimistically with `SELECT FOR UPDATE`.

# 7. Consistency

- Consistency in Data
- Consistency in reads

## 7.1. Consistency in Data

- Defined by the user.
- Referential integrity (foreign keys).
- Atomicity.
- Isolation.

## 7.2. Consistency in reads

- If a transaction committed a change will a new transaction immediately see the change?
- Affects the system as a whole.
- Relational and NoSQL databases suffer from this.
- Eventual consistency.

# 8. Durability

- Changes made by committed transactions must be persisted in a durable non-volatile storage.
- **Durability techniques**
  - WAL - Write ahead log.
  - Asynchronous snapshot.
  - AOF.

## 8.1. WAL

- Writing a lot of data to disk is expensive (indexes, data files, columns, rows, etc..).
- That is why DBMSs persist a compressed version of the changes known as WAL (write-ahead-log segments).

## 8.2. OS Cache

- A write request in OS usually goes to the OS cache.
- When the writes go the OS cache, an OS crash, machine restart could lead to loss of data.
- Fsync OS command forces writes to always go to disk.
- fsync can be expensive and slows down commits.
