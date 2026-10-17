# Row vs Column Oriented <!-- omit in toc -->

## Contents <!-- omit in toc -->

- [1. Row-Oriented Database](#1-row-oriented-database)
- [2. Column-Oriented Database](#2-column-oriented-database)
- [3. Pros \& Cons](#3-pros--cons)

# 1. Row-Oriented Database

- Tables are stored as rows in disk.
- A single block io read to the table fetches multiple rows with all their columns.
- More IOs are required to find a particular row in a table scan but once you find the row you get all columns for that row.

# 2. Column-Oriented Database

- Tables are stored as columns first in disk.
- A single block io read to the table fetches multiple columns with all matching rows.
- Less IOs are required to get more values of a given column.
  - But working with multiple columns require more IOs.
- **OLAP**.

# 3. Pros & Cons

| **Row-Based**                           | **Column-Based**                          |
| --------------------------------------- | ----------------------------------------- |
| Optimal for reads/writes                | Writes are slower                         |
| OLTP                                    | OLAP                                      |
| Compression isn't efficient             | Compresses greatly                        |
| Aggregation isn't efficient             | Excellent for aggregation                 |
| Efficient queries with multiple columns | Inefficient queries with multiple columns |
