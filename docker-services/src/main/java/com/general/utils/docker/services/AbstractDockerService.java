package com.general.utils.docker.services;

import com.general.utils.docker.client.DockerClientConfigFactory;
import com.general.utils.docker.client.DockerHttpClientFactory;
import com.general.utils.docker.container.Container;
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

    public Container launchContainer(String image, String name, String version) {
	return Launcher.launchContainer(this.dockerClient, image, name, version);
    }

}
