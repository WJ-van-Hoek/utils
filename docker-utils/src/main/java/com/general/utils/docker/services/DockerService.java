package com.general.utils.docker.services;

import com.general.utils.docker.container.ContainerResponse;

public interface DockerService {
    ContainerResponse launchContainer(String image, String name, String version);
}
