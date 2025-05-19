package com.david.labseq.service;

import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigInteger;
import java.util.NavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

@ApplicationScoped
public class LabSeqService {

    // Values above this threshold exhaust the heap
    public static final int MAX_N = 300_000;

    // Thread-safe, sorted map of computed values
    // NavigableMap allows access to the last computed key
    private final NavigableMap<Integer, BigInteger> cache = new ConcurrentSkipListMap<>();

    // Seed the cache with the base cases
    public LabSeqService() {
        cache.put(0, BigInteger.ZERO);
        cache.put(1, BigInteger.ONE);
        cache.put(2, BigInteger.ZERO);
        cache.put(3, BigInteger.ONE);
    }

    public BigInteger getLabSeq(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Index must be non-negative");
        }
        if (n > MAX_N) {
            throw new IllegalArgumentException("Index exceeds maximum value of " + MAX_N);
        }

        // Check if the value for 'n' is already cached
        BigInteger existing = cache.get(n);
        if (existing != null) {
            return existing;
        }

        // Build the cache iteratively from the highest cached index + 1 up to 'n'
        synchronized (cache) {
            int start = cache.lastKey() + 1;
            for (int i = start; i <= n; i++) {
                // l(i) = l(i-4) + l(i-3)
                BigInteger v4 = cache.get(i - 4);
                BigInteger v3 = cache.get(i - 3);
                cache.put(i, v4.add(v3));
            }
        }

        return cache.get(n);
    }
}

