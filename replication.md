# Replication <!-- omit in toc -->

## Contents <!-- omit in toc -->

- [1. Single/Master/Backup Replication](#1-singlemasterbackup-replication)
- [2. Multi-Master Replication](#2-multi-master-replication)
- [3. Synchronous vs Asynchronous Replication](#3-synchronous-vs-asynchronous-replication)
- [4. Pros \& Cons of Replication](#4-pros--cons-of-replication)

# 1. Single/Master/Backup Replication

- One Master/Leader node that accepts writes/ddls.
- One or more backup/standby nodes that receive those writes from the master.
- Simple to implement no conflicts.
  ![Single/Master/Backup Replication](/images/single-master-backup-replication.png)

# 2. Multi-Master Replication

- **Multiple** Master/Leader node that accepts writes/ddls.
- One or more backup/follower nodes that receive those writes from the masters.
- Need to resolves conflict.
  ![Single/Master/Backup Replication](/images/multi-master-replication.png)

# 3. Synchronous vs Asynchronous Replication

- **Synchronous Replication:** A write transaction to the master will be blocked until it is written to the backup/standby nodes.
  - First 2, First 1 or Any
- **Asynchronous Replication:** A write transaction is considered successful if it written to the master, then asynchronously the writes are applied to backup nodes.

# 4. Pros & Cons of Replication

- **Pros**
  - Horizontal Scaling.
  - Region based queries - DB per region.
- **Cons**
  - Eventual Consistency.
  - Slow Writes (synchronous).
  - Complex to Implement (multi-master).
