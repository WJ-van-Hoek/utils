/**
 * This package contains utility classes for interacting with Docker clients. It
 * provides functionality for creating Docker client configurations and HTTP
 * clients based on the provided configurations.
 *
 * <p>
 * The {@link DockerClientConfigFactory} class is a factory for creating Docker
 * client configurations with specified Docker hosts. It utilizes the
 * {@link com.github.dockerjava.core.DefaultDockerClientConfig} to build the
 * configurations.
 *
 * <p>
 * The {@link DockerHttpClientFactory} class is a utility for creating Docker
 * HTTP clients based on the provided Docker client configuration. It uses the
 * {@link com.github.dockerjava.httpclient5.ApacheDockerHttpClient}
 * implementation and is configured with the specified Docker client
 * configuration.
 *
 * <p>
 * Both classes in this package are marked as {@code final} and have private
 * constructors, indicating that they are not meant to be instantiated. They
 * provide static methods for creating Docker client configurations and HTTP
 * clients, respectively.
 *
 * @author Wim Joost van Hoek
 * @version 1
 * @see com.general.utils.docker.client.DockerClientConfigFactory
 * @see com.general.utils.docker.client.DockerHttpClientFactory
 */
package com.general.utils.docker.client;
