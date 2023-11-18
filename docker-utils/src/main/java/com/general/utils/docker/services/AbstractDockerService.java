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
import com.general.utils.docker.container.ContainerResponse;
import com.general.utils.docker.container.Launcher;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.transport.DockerHttpClient;

public abstract class AbstractDockerService implements DockerService {
    
    private final DockerClient dockerClient;

    protected AbstractDockerService(String dockerHost) {
	DockerClientConfig config = DockerClientConfigFactory.createDockerClientConfig(dockerHost);
	DockerHttpClient client = DockerHttpClientFactory.createDockerHttpClient(config);
	dockerClient = DockerClientBuilder.getInstance(config).withDockerHttpClient(client).build();
    }

    public ContainerResponse launchContainer(String image, String name, String version) {
	return Launcher.launchContainer(this.dockerClient, image, name, version);
    }

}
