package com.nth.DynamicSchedule.config;

/**
 * @Author: Hong Nguyen
 * @Create: 2020/10/10
 */
public class InitialContext {
    private InitialContext(){
        throw new UnsupportedOperationException();
    }

    public static Task getInstance(String className) {
        try {
            Class clazz = Class.forName(className);
            return cast(clazz.newInstance(), Task.class);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T cast(Object obj, Class<T> clazz) {
        if (clazz.isAssignableFrom(obj.getClass())) {
            return clazz.cast(obj);
        }
        throw new ClassCastException("Failed to cast instance.");
    }
}
