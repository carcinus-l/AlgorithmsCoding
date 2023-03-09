package com.carcinus.code.leetcode.run;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

public class Runner {


    public static Object run(String className, Object...args) throws Exception {
        Class<?> aClass = Class.forName(className);
        return run(aClass, args);
    }

    public static Object run(Class<?> c, Object...args) throws Exception {
        Method[] methods = c.getMethods();
        Optional<Method> optionalMethod = Arrays.stream(methods)
                .filter(method -> {
                    Runnable annotation = method.getAnnotation(Runnable.class);
                    return annotation != null;
                })
                .findFirst();
        if (optionalMethod.isPresent()) {
            Method method = optionalMethod.get();
            Constructor<?> constructor = c.getConstructor();
            Object instance = constructor.newInstance();
            return method.invoke(instance, args);

        }else {
            throw new RuntimeException("not found method impl Runnable");
        }
    }
}
