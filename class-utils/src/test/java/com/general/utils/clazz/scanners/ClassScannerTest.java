package com.general.utils.clazz.scanners;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

import com.general.testpackage.TestClass1;
import com.general.testpackage.TestClass2;

class ClassScannerTest {

    @Test
    public void testGetClasses() {
        String packageName = "com.general.testpackage";
        Set<Class<?>> classes = ClassScanner.getClasses(packageName);

        // Ensure that the set is not null and not empty
        assertNotNull(classes);
        assertFalse(classes.isEmpty());

        // Add your assertions here to verify the correctness of the returned classes
        assertTrue(classes.contains(TestClass1.class));
        assertTrue(classes.contains(TestClass2.class));
        // Add more assertions as needed
    }

}
