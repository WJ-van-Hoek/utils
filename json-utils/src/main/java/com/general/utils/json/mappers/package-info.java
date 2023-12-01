/**
 * Provides utility classes for mapping data structures to JSON representation
 * using Jackson ObjectMapper.
 * <p>
 * This package includes the following class:
 * <ul>
 * <li>{@link com.general.utils.json.mappers.MapToJsonMapper} - Utility class
 * for mapping a {@code Map<String, Object>} to its JSON representation using
 * Jackson ObjectMapper.</li>
 * </ul>
 * </p>
 * <p>
 * Usage:
 * 
 * <pre>
 * {@code
 * // Example usage of the classes in this package
 * Map<String, Object> dataMap = //... initialize your data map
 * String jsonString = MapToJsonMapper.convertMapToJson(dataMap);
 * if (jsonString != null) {
 *     // Process the JSON string
 * } else {
 *     // Handle the exception
 * }
 * }
 * </pre>
 * </p>
 *
 * @see com.general.utils.json.mappers.MapToJsonMapper
 * @see com.fasterxml.jackson.databind.ObjectMapper
 */
package com.general.utils.json.mappers;
