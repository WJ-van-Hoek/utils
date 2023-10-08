package com.general.utils.docker.container;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Launcher {
    private Launcher() {}
    
    public static Container launchContainer(DockerClient dockerClient, String imageName, String containerName, String version) {
	try {
	    launchContainerRaw(dockerClient, imageName, containerName, version);

	    log.info("Docker container started successfully");
	    return new Container(imageName, containerName, version);
	} catch (Exception e) {
	    log.error("Error starting Docker container: ", e);
	    return null;
	}
    }

    private static void launchContainerRaw(DockerClient dockerClient, String imageName, String containerName, String version) {
	CreateContainerResponse container = dockerClient.createContainerCmd(imageName.concat(version))
		.withName(containerName).exec();

	dockerClient.startContainerCmd(container.getId()).exec();
    }
}
