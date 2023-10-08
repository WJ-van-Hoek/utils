package com.general.utils.docker.client;

import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientConfig;

public class DockerClientConfigFactory {

    public static DockerClientConfig createDockerClientConfig(String dockerHost) {
	return DefaultDockerClientConfig.createDefaultConfigBuilder().withDockerHost(dockerHost).build();
    }
}
