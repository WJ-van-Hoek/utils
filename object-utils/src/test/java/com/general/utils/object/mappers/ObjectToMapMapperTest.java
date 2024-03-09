package com.general.utils.object.mappers;

import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The {@code ObjectToMapMapperTest} class contains tests for the {@code ObjectToMapMapper} class.
 */
public class ObjectToMapMapperTest {

    /** Expected size of the map when converting the sample object. */
    private static final int EXPECTED_MAP_SIZE = 2;

    /** Expected value for the 'name' key in the map. */
    private static final String EXPECTED_NAME_VALUE = "John";

    /** Expected value for the 'age' key in the map. */
    private static final int EXPECTED_AGE_VALUE = 30;

    /**
     * Tests the {@link ObjectToMapMapper#convertObjectToMap(Object, boolean)} method.
     */
    @Test
    public void testConvertObjectToMap() {
        // Create a sample object for testing
        SampleObject sampleObject = new SampleObject(EXPECTED_NAME_VALUE, EXPECTED_AGE_VALUE);

        // Convert the sample object to a map
        Map<String, Object> result = ObjectToMapMapper.convertObjectToMap(sampleObject, false);

        // Verify the content of the map
        assertEquals(EXPECTED_MAP_SIZE, result.size());
        assertEquals(EXPECTED_NAME_VALUE, result.get("name"));
        assertEquals(EXPECTED_AGE_VALUE, result.get("age"));
    }

    /**
     * A sample object used for testing.
     */
    static class SampleObject {
        /** The name of the sample object. */
        private String name;

        /** The age of the sample object. */
        private int age;

        /**
         * Constructs a new sample object with the given name and age.
         *
         * @param nameParam the name of the sample object.
         * @param ageParam  the age of the sample object.
         */
        SampleObject(final String nameParam, final int ageParam) {
            this.name = nameParam;
            this.age = ageParam;
        }

        /**
         * Gets the name of the sample object.
         *
         * @return the name of the sample object.
         */
        public String getName() {
            return name;
        }

        /**
         * Gets the age of the sample object.
         *
         * @return the age of the sample object.
         */
        public int getAge() {
            return age;
        }
    }
}
