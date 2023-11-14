package com.general.utils.docker.client;

import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;
import com.github.dockerjava.transport.DockerHttpClient;

public class DockerHttpClientFactory {

    public static DockerHttpClient createDockerHttpClient(DockerClientConfig config) {
	return new ApacheDockerHttpClient.Builder().dockerHost(config.getDockerHost()).sslConfig(config.getSSLConfig())
		.build();
    }
}
