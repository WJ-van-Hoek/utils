package com.general.utils.clazz.scanners;

import java.io.File;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The ClassScanner class provides utility methods for scanning packages and retrieving classes within them.
 *
 * @author Wim Joost van Hoek
 * @version 0.0.1
 * @since 0.0.1
 */
public final class ClassScanner {

    private static final Logger LOG = LoggerFactory.getLogger(ClassScanner.class);

    private ClassScanner() {
    }

    /**
     * Retrieves all classes in the specified package.
     *
     * @param packageName The name of the package containing the classes.
     * @return A set containing all classes found in the package.
     */
    public static Set<Class<?>> getClasses(final String packageName) {
        Set<Class<?>> classes = new HashSet<>();
        String packagePath = packageName.replace('.', '/');
        LOG.info("packagePath: {}", packagePath);
        File packageDirectory = new File(getPackageURL(packagePath).getFile());

        if (packageDirectory.exists() && packageDirectory.isDirectory()) {
            File[] files = packageDirectory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".class")) {
                        String className = packageName + '.' + file.getName().substring(0, file.getName().length() - 6);
                        try {
                            Class<?> clazz = Class.forName(className);
                            classes.add(clazz);
                            LOG.info("clazz added: {}", className);
                        } catch (ClassNotFoundException e) {
                            LOG.error(e.getMessage());
                        }
                    }
                }
            }
        }

        return classes;
    }

    private static URL getPackageURL(String packagePath) {
        return ClassLoader.getSystemResource(packagePath);
    }
}
