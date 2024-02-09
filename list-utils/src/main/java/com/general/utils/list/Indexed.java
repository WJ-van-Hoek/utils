package com.general.utils.list;

/**
 * Represents an indexed object
 *
 * <p>
 * Implementing classes must provide a method to retrieve and set the index.
 *
 * @author Wim Joost van Hoek
 * @version 0.0.1
 * @since 0.0.1
 */
public interface Indexed {
    /**
     * @return the configured index of the object.
     */
    int getIndex();

    /**
     * Sets the index of the specified element.
     * 
     * <p>
     * Note that calling this method multiple times for the same element may lead to unexpected behavior. It's
     * recommended to call this method only once for each element.
     * 
     * @param index the index to set
     * @throws IllegalStateException if the index has already been set for the element
     */
    void setIndex(int index);
}
