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
package com.general.utils.docker.container;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Abstract base class representing a container entity. This class provides
 * common attributes for containers.
 */
@Getter
@AllArgsConstructor
public class Container {
    /** The base image used for creating the container. */
    private final String baseImage;

    /** The name assigned to the container. */
    private final String name;

    /** The version information associated with the container. */
    private final String version;
}
