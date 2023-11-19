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

import com.general.utils.docker.client.DockerClientConfigFactory;
import com.general.utils.docker.client.DockerHttpClientFactory;
import com.general.utils.docker.container.Container;
import com.general.utils.docker.container.Launcher;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.transport.DockerHttpClient;

/**
 * The {@code AbstractDockerService} class is an abstract implementation of the
 * {@code DockerService} interface. It provides common functionality for
 * interacting with Docker, such as creating a Docker client and launching
 * containers. Concrete classes extending this abstract class must implement
 * additional Docker-related functionality.
 *
 * <p>
 * The Docker client is initialized during the construction of this class using
 * the provided Docker host information. The client is used to communicate with
 * the Docker daemon for various operations.
 *
 * @see DockerService
 */
public abstract class AbstractDockerService implements DockerService {

    /**
     * The Docker client used for interacting with the Docker daemon.
     */
    private final DockerClient dockerClient;

    /**
     * Constructs an {@code AbstractDockerService} with the specified Docker
     * host.
     *
     * @param dockerHost The address of the Docker host to connect to.
     */
    protected AbstractDockerService(final String dockerHost) {
        DockerClientConfig config = DockerClientConfigFactory
                .createDockerClientConfig(dockerHost);
        DockerHttpClient client = DockerHttpClientFactory
                .createDockerHttpClient(config);
        dockerClient = DockerClientBuilder.getInstance(config)
                .withDockerHttpClient(client).build();
    }

    /**
     * Launches a Docker container using the initialized Docker client.
     * Delegates the container launch to the {@link Launcher} class.
     *
     * @param image The name of the Docker image to be used for the container.
     * @param name The desired name for the Docker container.
     * @param version The version tag for the Docker image.
     * @return A {@code Container} object representing the launched Docker
     * container.
     * @see Launcher#launchContainer(DockerClient, String, String, String)
     */
    public Container launchContainer(final String image, final String name,
            final String version) {
        return Launcher.launchContainer(this.dockerClient, image, name,
                version);
    }

}
