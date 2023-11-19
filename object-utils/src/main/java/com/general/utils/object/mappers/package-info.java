/**
 * The {@code ObjectToMapMapper} package provides a utility for converting
 * objects of any type to a {@code Map}. It extracts the fields and their
 * corresponding values from the object and stores them in a
 * {@code Map<String, Object>}.
 *
 * <p>
 * This class is marked as {@code final} and has a private constructor,
 * indicating that it is not meant to be extended or instantiated, as it only
 * contains static methods for mapping objects to maps.
 *
 * <p>
 * The main method, {@link ObjectToMapMapper#convertObjectToMap(Object)}, takes
 * an object of any type and returns a {@code Map} containing the names of the
 * object's fields as keys and their corresponding values as values.
 *
 * <p>
 * Note: The fields are accessed using reflection, and if a field cannot be
 * accessed due to visibility restrictions, it will be ignored, and an exception
 * will be logged.
 *
 * @author Wim Joost van Hoek
 * @version 1
 * @see com.general.utils.object.mappers.ObjectToMapMapper
 */
package com.general.utils.object.mappers;
