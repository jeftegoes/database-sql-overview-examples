# Database Engine <!-- omit in toc -->

## Contents <!-- omit in toc -->

- [1. Database Engine](#1-database-engine)
- [2. Database Engines](#2-database-engines)
  - [2.1. MyISAM](#21-myisam)
  - [2.2. Aria](#22-aria)
  - [2.3. InnoDB](#23-innodb)
  - [2.4. XtraDB](#24-xtradb)
  - [2.5. LevelDB](#25-leveldb)
  - [2.6. RocksDB](#26-rocksdb)
  - [2.7. SQLite](#27-sqlite)
  - [2.8. Berkeley DB](#28-berkeley-db)

# 1. Database Engine

- Library that takes care of the on disk storage and CRUD.
  - Can be as simple as key-value store.
  - Or as rich and complex as full support ACID and transactions with foreign keys.
- DBMS can use the database engine and build features on top (server, replication, isolation, stored procedures, etc...)
- Want to write a new database?
  - Don't start from scratch use an engine.
- Sometimes referred as Storage Engine or embedded database.

# 2. Database Engines

- Some DBMS give us the flexibility to switch engines like MySQL & MariaDB.
- Some DBMS comes with a built-in engine that we can't change (Postgres).

## 2.1. MyISAM

- Stands for Indexed sequential access method.
- B-tree (Balanced tree) indexes point to the rows directly.
- No Transaction support.
- Open Source & Owned by Oracle.
- Inserts are fast, updates and deletes are problematic (fragments).
- Database Crashes corrupts tables (have to manually repair).
- Table level locking.
- MySQL 5.5, MariaDB, Percona (MySQL forks) supports MyISAM.
- Used to be default engine for MySQL.

## 2.2. Aria

- Created by Michael Widenius.
- Very similar to MyISAM.
- Crash-safe unlike MyISAM.
- Not owned by Oracle.
- Designed specifically for MariaDB (mySQL Fork).
- In MariaDB 10.4 all system tables are Aria.

## 2.3. InnoDB

- B+tree - With indexes point to the primary key and the PK points to the row.
- Replaces MyISAM.
- Default for MySQL & MariaDB.
- ACID compliant transactions support.
- Foreign keys.
- Tablespaces.
- Row level locking.
- Spatial operations.
- Owned by Oracle.

## 2.4. XtraDB

- Fork of InnoDB.
- Was the default for MariaDB until 10.1.
- In MariaDB 10.2 switched the default for InnoDB.
- "XtraDB couldn't be kept up to date with the latest features of InnoDB and cannot be used."
- System tables in MariaDB starting with 10.4 are all Aria

## 2.5. LevelDB

- Written by Jeff and Sanjay from Google in 2011.
- Log structured merge tree (LSM) (great for high insert and SSD).
- No transactions.
- Inspired by Google BigTable.
- **Levels of files**
  - Memtable
  - Level 0 (young level)
  - Level 1 - 6
- As files grow large levels are merged.
- Used in bitcoin core blockchain, AutoCad, Minecraft.

## 2.6. RocksDB

- Facebook forked LevelDB in 2012 to become RocksDB.
- Transactional.
- High Performance, Multi-threaded compaction.
- Many features not in LevelDB.
- MyRocks for MySQL, MariaDB and Percona.
- MongoRocks for MongoDB.
- Many many more use it!.

## 2.7. SQLite

- Designed by D. Richard Hipp in 2000.
- Very populate embedded database for local data.
- B-Tree (LSM as extension).
- Postgres-like syntax.
- Full ACID & table locking.
- Concurrent read & writes.
- Web SQL in browsers uses it.
- Included in many operating systems by default.

## 2.8. Berkeley DB

- Developed by Sleepycat Software in 1994 (owned by Oracle).
- Key-value embedded database.
- Supports ACID transactions, locks, replications etc..
- Used to be used in bitcoin core (switched to LevelDB).
- Used MemcacheDB.
