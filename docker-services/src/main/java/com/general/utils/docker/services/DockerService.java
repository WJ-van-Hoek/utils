package com.general.utils.docker.services;

import com.general.utils.docker.container.Container;

public interface DockerService {
    Container launchContainer(String image, String name, String version);
}
