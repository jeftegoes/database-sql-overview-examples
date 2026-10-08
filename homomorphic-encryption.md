# Homomorphic Encryption <!-- omit in toc -->

## Contents <!-- omit in toc -->

- [1. Symmetric Encryption](#1-symmetric-encryption)
- [2. Why we can't always encrypt](#2-why-we-cant-always-encrypt)
- [3. Homomorphic Encryption](#3-homomorphic-encryption)

# 1. Symmetric Encryption

[Symmetric Encryption](https://github.com/jeftegoes/Cybersecurity#132-encryption)

# 2. Why we can't always encrypt

- Database Queries can only be performed on plain text.
- Analysis, Indexing, tuning.
- Applications must read data to process it.
- TLS Termination Layer 7 Reverse Proxies and Load Balancing.

# 3. Homomorphic Encryption

- Ability to perform arithmetic operations on encrypted data.
- No need to decrypt!
- You can query a database that is encrypted!
- Layer 7 Reverse Proxies don't have to terminate TLS, can route traffic based on rules without decrypting traffic.
- Databases can index and optimize without decrypting data.
