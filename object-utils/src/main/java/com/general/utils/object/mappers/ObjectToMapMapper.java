package com.general.utils.object.mappers;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ObjectToMapMapper {
    
    private ObjectToMapMapper() {}
    
    public static <T> Map<String, Object> convertObjectToMap(T object) {
        Map<String, Object> objectMap = new HashMap<>();

        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            try {
                field.setAccessible(true);

                // Get the field name and value
                String fieldName = field.getName();
                Object fieldValue = field.get(object);

		// Add the field name and value to the map
                objectMap.put(fieldName, fieldValue);
                
                field.setAccessible(false);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return objectMap;
    }
}
    