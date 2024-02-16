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
 * The {@code ObjectToMapMapper} class provides static methods to convert an object to a map of its fields and values.
 *
 * <p>
 * This utility class is marked as {@code final} and has a private constructor, indicating that it is not meant to be
 * extended or instantiated.
 */
public final class ObjectToMapMapper {

    /**
     * Private constructor to prevent instantiation of the class.
     */
    private ObjectToMapMapper() {
    }

    /**
     * Converts the specified object to a map of its fields and values.
     *
     * @param object The object to be converted to a map.
     * @param superClass {@code true} if fields from superclasses should also be included, {@code false} otherwise.
     * @param <T> The type of the object.
     * @return A {@code Map} containing the fields and values of the object.
     */
    public static <T> Map<String, Object> convertObjectToMap(final T object, final boolean superClass) {
        Map<String, Object> objectMap = new HashMap<>();

        Class<?> clazz = object.getClass();
        if (superClass) {
            clazz = clazz.getSuperclass();
        }
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
