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

@Slf4j
public final class Launcher {
    private Launcher() {
    }

    public static ContainerResponse launchContainer(DockerClient dockerClient,
            String imageName, String containerName, String version) {
        try {
            launchContainerRaw(dockerClient, imageName, containerName, version);

            log.info("Docker container started successfully");
            return new ContainerResponse(imageName, containerName, version);
        } catch (Exception e) {
            log.error("Error starting Docker container: ", e);
            return null;
        }
    }

    private static void launchContainerRaw(DockerClient dockerClient,
            String imageName, String containerName, String version) {
        CreateContainerResponse container = dockerClient
                .createContainerCmd(imageName.concat(version))
                .withName(containerName).exec();

        dockerClient.startContainerCmd(container.getId()).exec();
    }
}
