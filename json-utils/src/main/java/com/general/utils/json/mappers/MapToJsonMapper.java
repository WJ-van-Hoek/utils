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
package com.general.utils.json.mappers;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Utility class for mapping a {@code Map<String, Object>} to its JSON
 * representation using Jackson ObjectMapper.
 * <p>
 * This class provides a single static method, {@code convertMapToJson}, which
 * takes a Map and uses the Jackson ObjectMapper to serialize it into a JSON
 * string. If the conversion is successful, the JSON string is returned. In case
 * of any exception during the conversion process, the exception is printed to
 * the standard error stream, and the method returns null.
 * </p>
 *
 * @see com.fasterxml.jackson.databind.ObjectMapper
 */
public final class MapToJsonMapper {

    // Private constructor to prevent instantiation of the utility class.
    private MapToJsonMapper() {
    }

    /**
     * Converts a {@code Map<String, Object>} to its JSON representation using
     * Jackson ObjectMapper.
     *
     * @param map The {@code Map<String, Object>} to be converted to JSON.
     * @return A JSON representation of the input Map, or null if an exception
     * occurs.
     * @see com.fasterxml.jackson.databind.ObjectMapper
     */
    public static String convertMapToJson(final Map<String, Object> map) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(map);
        } catch (Exception e) {
            // Print the exception to the standard error stream.
            e.printStackTrace();
            return null;
        }
    }
}
