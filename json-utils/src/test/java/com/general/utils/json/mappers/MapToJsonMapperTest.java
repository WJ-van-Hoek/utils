package com.general.utils.json.mappers;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;


/**
 * Test class for {@link MapToJsonMapper}.
 * <p>
 * This class contains JUnit tests for the {@code MapToJsonMapper} utility
 * class, covering successful conversion and exception handling scenarios,
 * including the constant {@code NUMBER}.
 * </p>
 */
public class MapToJsonMapperTest {

    /**
     * A constant integer used for testing purposes.
     * <p>
     * This constant represents a specific number (123) and is utilized in the
     * test cases for demonstrating the successful conversion of a Map to JSON.
     * </p>
     */
    private static final int NUMBER = 123;

    /**
     * Test case for successful conversion of a Map to JSON.
     * <p>
     * Verifies that the {@code convertMapToJson} method correctly serializes a
     * Map with string and integer values into a JSON string. The test asserts
     * the presence of expected key-value pairs in the generated JSON.
     * </p>
     */
    @Test
    public void successfulConversion() {
        Map<String, Object> inputMap = new HashMap<>();
        inputMap.put("key1", "value1");
        inputMap.put("key2", NUMBER);

        String jsonString = MapToJsonMapper.convertMapToJson(inputMap);

        assertNotNull(jsonString);
        assertTrue(jsonString.contains("\"key1\":\"value1\""));
        assertTrue(jsonString.contains("\"key2\":123"));
    }

    /**
     * Test case for exception handling during conversion.
     * <p>
     * Verifies that the {@code convertMapToJson} method correctly handles
     * exceptions when attempting to serialize a Map with a complex object
     * as a value. The test asserts that the method returns null in this case.
     * </p>
     */
    @Test
    public void exceptionHandling() {
        Map<String, Object> inputMap = new HashMap<>();
        inputMap.put("key1", "value1");
        inputMap.put("key2", new Object());

        String jsonString = MapToJsonMapper.convertMapToJson(inputMap);

        assertNull(jsonString);
    }
}
