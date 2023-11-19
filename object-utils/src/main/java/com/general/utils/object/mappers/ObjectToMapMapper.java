/**
 * <p>This software is distributed under the terms of the
 * GNU General Public License version 2.
 * For details and the full license text, please see:
 * <a href="https://www.gnu.org/licenses/old-licenses/gpl-2.0.html">
 * GNU General Public License, Version 2</a>.
 *
 * @author Wim Joost van Hoek
 * @version 1
 */
package com.general.utils.object.mappers;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * The {@code ObjectToMapMapper} class provides a utility for converting objects
 * of any type to a {@code Map}. It extracts the fields and their corresponding
 * values from the object and stores them in a {@code Map<String, Object>}.
 *
 * <p>This class is marked as {@code final} and has a private constructor,
 * indicating that it is not meant to be extended or instantiated, as it only
 * contains static methods for mapping objects to maps.
 *
 * <p>The main method, {@link #convertObjectToMap(Object)}, takes an object of
 * any type and returns a {@code Map} containing the names of the object's
 * fields as keys and their corresponding values as values.
 *
 * <p>Note: The fields are accessed using reflection, and if a field cannot be
 * accessed due to visibility restrictions, it will be ignored, and an exception
 * will be logged.
 *
 */
public final class ObjectToMapMapper {

    /**
     * Private constructor to prevent instantiation of the class.
     */
    private ObjectToMapMapper() {
    }

    /**
     * Converts an object of any type to a {@code Map} by extracting its fields
     * and values.
     *
     * @param object The object to be converted to a {@code Map}.
     * @param <T>    The type of the object.
     * @return A {@code Map<String, Object>} containing the object's field names
     * as keys and their values as values.
     * @throws NullPointerException if the provided object is {@code null}.
     */
    public static <T> Map<String, Object> convertObjectToMap(final T object) {
        Map<String, Object> objectMap = new HashMap<>();

        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            try {
                field.setAccessible(true);

                // Get the field name and value
                String fieldName = field.getName();
                Object fieldValue = field.get(object);

                // Add the field name and value to the map
                objectMap.put(fieldName, fieldValue);

                field.setAccessible(false);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return objectMap;
    }
}
