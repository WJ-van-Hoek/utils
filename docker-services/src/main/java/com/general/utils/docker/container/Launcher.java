package com.general.utils.docker.container;

import com.general.utils.docker.client.DockerClientConfigFactory;
import com.general.utils.docker.client.DockerHttpClientFactory;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.transport.DockerHttpClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Launcher {

    private final DockerClient dockerClient;

    public Launcher(String dockerHost) {
	DockerClientConfig config = DockerClientConfigFactory.createDockerClientConfig(dockerHost);
	DockerHttpClient client = DockerHttpClientFactory.createDockerHttpClient(config);
	dockerClient = DockerClientBuilder.getInstance(config).withDockerHttpClient(client).build();
    }

    public boolean launchContainer(String imageName, String containerName, String version) {
	try {
	    start(imageName, containerName, version);

	    log.info("Docker container started successfully");
	    return true;
	} catch (Exception e) {
	    log.error("Error starting Docker container: ", e);
	    return false;
	}
    }

    private void start(String imageName, String containerName, String version) {
	CreateContainerResponse container = dockerClient.createContainerCmd(imageName.concat(version))
		.withName(containerName).exec();

	dockerClient.startContainerCmd(container.getId()).exec();
    }
}
