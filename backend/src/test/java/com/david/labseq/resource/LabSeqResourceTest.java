package com.david.labseq.resource;

import com.david.labseq.service.LabSeqService;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


@QuarkusTest
public class LabSeqResourceTest {

    @InjectMock
    LabSeqService labSeqService;

    @Test
    void testGetLabSeqValue_validIndex_returnsValue() {
        int n = 5;
        BigInteger expected = BigInteger.valueOf(5);

        when(labSeqService.getLabSeq(n)).thenReturn(expected);

        given()
                .when().get("/labseq/{n}", n)
                .then()
                .statusCode(200)
                .body(is(expected.toString()));
    }

    @Test
    void testGetLabSeqValue_invalidIndex_throwsError() {
        int invalid = -1;

        when(labSeqService.getLabSeq(invalid)).thenThrow(new IllegalArgumentException("Index must be non-negative"));

        given()
                .when().get("/labseq/{n}", invalid)
                .then()
                .statusCode(400)
                .body(is("Index must be non-negative"));
    }
}
