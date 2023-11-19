/**
 * This package contains classes and interfaces related to Docker services. It
 * includes an abstract class,
 * {@link com.general.utils.docker.services.AbstractDockerService}, which
 * provides common functionality for interacting with Docker, such as creating a
 * Docker client and launching containers. Concrete classes extending this
 * abstract class must implement additional Docker-related functionality.
 *
 * <p>
 * The package also contains the
 * {@link com.general.utils.docker.services.DockerService} interface, defining
 * the contract for interacting with Docker services. Classes implementing this
 * interface are expected to provide functionality related to Docker containers,
 * such as launching containers with specific images and configurations.
 *
 * <p>
 * Implementing classes of {@code DockerService} must provide a concrete
 * implementation for the {@link com.general.utils.docker.services.
 * DockerService#launchContainer(String, String, String)} method, specifying the
 * details of how Docker containers are launched.
 *
 * @author Wim Joost van Hoek
 * @version 1
 * @see com.general.utils.docker.services.AbstractDockerService
 * @see com.general.utils.docker.services.DockerService
 */

package com.general.utils.docker.services;
