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

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * The {@code Launcher} class provides a simple utility for launching Docker
 * containers. It uses the Lombok {@code @Slf4j} annotation for logging.
 *
 * <p>
 * This class is marked as {@code final} and has a private constructor,
 * indicating that it is not meant to be extended or instantiated, as it only
 * contains static methods.
 *
 */
@Slf4j
public final class Launcher {
    /**
     * Private constructor to prevent instantiation of the class.
     */
    private Launcher() {
    }

    /**
     * Launches a Docker container with the specified parameters.
     *
     * @param dockerClient The Docker client used to interact with the Docker
     * daemon.
     * @param imageName The name of the Docker image to be used for the
     * container.
     * @param containerName The desired name for the Docker container.
     * @param version The version tag for the Docker image.
     * @return A {@code Container} object representing the launched Docker
     * container, or {@code null} if an error occurs during the container
     * launch.
     */
    public static Container launchContainer(final DockerClient dockerClient,
            final String imageName, final String containerName,
            final String version) {
        try {
            launchContainerRaw(dockerClient, imageName, containerName, version);

            log.info("Docker container started successfully");
            return new Container(imageName, containerName, version);
        } catch (Exception e) {
            log.error("Error starting Docker container: ", e);
            return null;
        }
    }

    private static void launchContainerRaw(final DockerClient dockerClient,
            final String imageName, final String containerName,
            final String version) {
        CreateContainerResponse container = dockerClient
                .createContainerCmd(imageName.concat(version))
                .withName(containerName).exec();

        dockerClient.startContainerCmd(container.getId()).exec();
    }
}
