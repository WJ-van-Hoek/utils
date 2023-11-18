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
package com.general.utils.docker.client;

import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientConfig;

/**
 * Factory class for creating Docker client configurations. This class provides
 * a method to create a DockerClientConfig with the specified Docker host.
 */
public final class DockerClientConfigFactory {
    private DockerClientConfigFactory() {
    }

    /**
     * Creates a Docker client configuration with the specified Docker host.
     *
     * @param dockerHost The URL of the Docker host.
     * @return A DockerClientConfig object configured with the provided Docker
     * host.
     *
     * @throws NullPointerException If the provided Docker host is null.
     * @throws IllegalArgumentException If the provided Docker host is empty or
     * malformed.
     * @throws DockerClientConfigException If an error occurs while building the
     * Docker client configuration.
     *
     * @see DefaultDockerClientConfig.Builder#withDockerHost(String)
     * @see DefaultDockerClientConfig.Builder#build()
     */
    public static DockerClientConfig createDockerClientConfig(
            final String dockerHost) {
        return DefaultDockerClientConfig.createDefaultConfigBuilder()
                .withDockerHost(dockerHost).build();
    }
}
