/**
 * This package contains utility classes for working with Docker containers. It
 * includes an abstract base class,
 * {@link com.general.utils.docker.container.Container}, representing common
 * attributes for containers, and a utility class,
 * {@link com.general.utils.docker.container.Launcher}, for launching Docker
 * containers.
 *
 * <p>
 * The {@code Container} class serves as an abstract base class providing common
 * attributes for Docker containers, such as the base image, container name, and
 * version information.
 *
 * <p>
 * The {@code Launcher} class provides a simple utility for launching Docker
 * containers using the provided Docker client. It utilizes the Lombok
 * {@code @Slf4j} annotation for logging. The class is marked as {@code final}
 * and has a private constructor, indicating that it is not meant to be extended
 * or instantiated, as it only contains static methods for container launching.
 *
 * @author Wim Joost van Hoek
 * @version 1
 * @see com.general.utils.docker.container.Container
 * @see com.general.utils.docker.container.Launcher
 */
package com.general.utils.docker.container;
