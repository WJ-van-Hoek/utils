package com.general.utils.collection;

import java.util.ArrayList;

/**
 * An extension of {@link ArrayList} that automatically sets the index of elements before adding them to the list.
 *
 * <p>
 * This class ensures that the index of elements is set automatically based on their position in the list when they are added.
 * The index is set using the {@link Indexed#setIndex(int)} method of the elements.
 * </p>
 *
 * @param <I> the type of elements in the list, which must implement the {@link Indexed} interface
 * 
 * @author Wim Joost van Hoek
 * @version 0.0.1
 * @since 0.0.1
 */
public class IndexedArrayList<I extends Indexed> extends ArrayList<I> {

    private static final long serialVersionUID = 1652080513877575697L;

    /**
     * Adds the specified element to the end of this list, automatically setting its index.
     *
     * <p>
     * The index of the element is set to the current size of the list.
     * </p>
     *
     * @param indexed the element to be added to this list
     * @return {@code true} (as specified by {@link ArrayList#add})
     */
    @Override
    public boolean add(I indexed) {
        // Automatically set the index before adding the indexed to the list
        indexed.setIndex(this.size());
        return super.add(indexed);
    }
}

