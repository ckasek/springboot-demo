package com.ck4.mediaservice.utils;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.FeatureDescriptor;
import java.util.stream.Stream;

public class ObjectUtils {

    /**
     * Get a list of properties on an object with null values.  Primarily used with BeanUtils.copyProperties to ensure
     * we do not overwrite existing values with nulls when updating from a partially populated object.
     * <a href="https://stackoverflow.com/a/32066155">Stack Overflow Answer</a>
     *
     * @param source The object to examine
     * @return A String array containing the list of fields which are null
     */
    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
        return Stream.of(wrappedSource.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null)
                .toArray(String[]::new);
    }
}
