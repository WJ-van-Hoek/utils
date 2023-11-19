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

import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;
import com.github.dockerjava.transport.DockerHttpClient;

/*
 * Utility class for creating Docker HTTP clients based on the
 * provided Docker client configuration.This class provides
 * a factory method to create a DockerHttpClient using the
 * ApacheDockerHttpClient implementation, configured with the
 * specified Docker client configuration.
 *
 * This class is final and has a private constructor to prevent
 * instantiation as it is meant to be used as a utility class.
 */
public final class DockerHttpClientFactory {

    private DockerHttpClientFactory() {
    }

    /**
     * Creates a Docker HTTP client based on the provided Docker client
     * configuration.
     *
     * @param config The Docker client configuration.
     * @return A DockerHttpClient configured with the provided Docker client
     * configuration.
     * @throws NullPointerException If the provided Docker client configuration
     * is null.
     * @see DockerHttpClient
     * @see DockerClientConfig
     * @see ApacheDockerHttpClient.Builder
     */
    public static DockerHttpClient createDockerHttpClient(
            final DockerClientConfig config) {
        return new ApacheDockerHttpClient.Builder()
                .dockerHost(config.getDockerHost())
                .sslConfig(config.getSSLConfig()).build();
    }
}
