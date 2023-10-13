package com.general.utils.docker.container;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Container {
    private final String baseImage;
    private final String name;
    private final String version;
}
