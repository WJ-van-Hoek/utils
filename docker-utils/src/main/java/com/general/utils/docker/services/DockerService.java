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
package com.general.utils.docker.services;

import com.general.utils.docker.container.Container;

/**
 * The {@code DockerService} interface defines the contract for interacting with
 * Docker services. Classes implementing this interface are expected to provide
 * functionality related to Docker containers, such as launching containers with
 * specific images and configurations.
 *
 * <p>
 * Implementing classes must provide a concrete implementation for the
 * {@link #launchContainer(String, String, String)} method, specifying the
 * details of how Docker containers are launched.
 *
 */
public interface DockerService {
    /**
     * Launches a Docker container with the specified parameters.
     *
     * @param image The name of the Docker image to be used for the container.
     * @param name The desired name for the Docker container.
     * @param version The version tag for the Docker image.
     * @return A {@code Container} object representing the launched Docker
     * container.
     */
    Container launchContainer(String image, String name, String version);
}
