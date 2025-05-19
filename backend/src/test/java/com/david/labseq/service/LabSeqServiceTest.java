package com.david.labseq.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class LabSeqServiceTest {

    LabSeqService service = new LabSeqService();

    @BeforeEach
    void setUp() {
        service = new LabSeqService();
    }

    @Test
    void testBaseCases() {
        assertEquals(BigInteger.ZERO, service.getLabSeq(0));
        assertEquals(BigInteger.ONE, service.getLabSeq(1));
        assertEquals(BigInteger.ZERO, service.getLabSeq(2));
        assertEquals(BigInteger.ONE, service.getLabSeq(3));
    }

    @Test
    void testRecursiveValues() {
        assertEquals(BigInteger.ONE, service.getLabSeq(4));
        assertEquals(BigInteger.ONE, service.getLabSeq(5));
        assertEquals(BigInteger.ONE, service.getLabSeq(6));
        assertEquals(BigInteger.TWO, service.getLabSeq(7));
    }

    @Test
    void testCaching() {
        BigInteger val = service.getLabSeq(10);
        BigInteger again = service.getLabSeq(10);
        assertSame(val, again); // should return cached value (same reference)
    }

    // Performance test for index of 100,000
    @Test
    void testPerformanceForLargeIndex_isUnderTenSeconds() {
        assertTimeout(
                Duration.ofSeconds(10),
                () -> {
                    BigInteger result = service.getLabSeq(100_000);

                    // Sanity check: the result should be non-null (and non-negative)
                    assertNotNull(result, "Result must not be null");
                    assertTrue(result.signum() >= 0, "Result should be non-negative");
                },
                "Calculation of l(100_000) must finish in under 10 seconds"
        );
    }

    @Test
    void testNegativeIndexThrows() {
        assertThrows(IllegalArgumentException.class, () -> service.getLabSeq(-1));
    }

    @Test
    void testMaxLimitThrows() {
        assertThrows(IllegalArgumentException.class, () -> service.getLabSeq(-1));
    }
}
