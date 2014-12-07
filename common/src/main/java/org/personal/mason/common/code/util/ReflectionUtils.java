package org.personal.mason.common.code.util;

import org.axonframework.common.*;

import java.lang.reflect.*;
import java.security.AccessController;
import java.util.*;

/**
 * Created by m00290368 on 2014-12-03.
 */
public abstract class ReflectionUtils {

    private static final Map<Class<?>, Class<?>> primitiveWrapperTypeMap = new HashMap<Class<?>, Class<?>>(8);

    private ReflectionUtils() {
        // utility class
    }

    static {
        primitiveWrapperTypeMap.put(boolean.class, Boolean.class);
        primitiveWrapperTypeMap.put(byte.class, Byte.class);
        primitiveWrapperTypeMap.put(char.class, Character.class);
        primitiveWrapperTypeMap.put(double.class, Double.class);
        primitiveWrapperTypeMap.put(float.class, Float.class);
        primitiveWrapperTypeMap.put(int.class, Integer.class);
        primitiveWrapperTypeMap.put(long.class, Long.class);
        primitiveWrapperTypeMap.put(short.class, Short.class);
    }

    public static Iterable<Method> methodsOf(Class<?> clazz) {
        return methodsOf(clazz, false);
    }

    /**
     * Returns an {@link Iterable} of all the methods declared on the given class and its super classes. The iterator
     * will always return methods declared in a subtype before returning methods declared in a super type.
     *
     * @param clazz The class to return methods for
     * @return an <code>Iterable</code> providing access to all declared methods in the class hierarchy
     */
    public static Iterable<Method> methodsOf(Class<?> clazz, boolean recursive) {
        List<Method> methods = new LinkedList<Method>();
        Class<?> currentClazz = clazz;
        do {
            methods.addAll(Arrays.asList(currentClazz.getDeclaredMethods()));
            addMethodsOnDeclaredInterfaces(currentClazz, methods);

            if (recursive) {
                currentClazz = currentClazz.getSuperclass();
            } else {
                currentClazz = null;
            }
        } while (currentClazz != null);
        return Collections.unmodifiableList(methods);
    }


    public static Iterable<Field> fieldsOf(Class<?> clazz){
        return fieldsOf(clazz, false);
    }

    /**
     * Returns an {@link Iterable} of all the fields declared on the given class and its super classes. The iterator
     * will always return fields declared in a subtype before returning fields declared in a super type.
     *
     * @param clazz The class to return fields for
     * @return an <code>Iterable</code> providing access to all declared fields in the class hierarchy
     */
    public static Iterable<Field> fieldsOf(Class<?> clazz, boolean recursive) {
        List<Field> fields = new LinkedList<Field>();
        Class<?> currentClazz = clazz;
        do {
            fields.addAll(Arrays.asList(currentClazz.getDeclaredFields()));
            if(recursive) {
                currentClazz = currentClazz.getSuperclass();
            } else {
                currentClazz = null;
            }
        } while (currentClazz != null);
        return Collections.unmodifiableList(fields);
    }

    /**
     * Returns the value of the given <code>field</code> in the given <code>object</code>. If necessary, the field is
     * made accessible, assuming the security manager allows it.
     *
     * @param field  The field containing the value
     * @param object The object to retrieve the field's value from
     * @return the value of the <code>field</code> in the <code>object</code>
     *
     * @throws IllegalStateException if the field is not accessible and the security manager doesn't allow it to be
     *                               made
     *                               accessible
     */
    public static Object getFieldValue(Field field, Object object) {
        ensureAccessible(field);
        try {
            return field.get(object);
        } catch (IllegalAccessException ex) {
            throw new IllegalStateException("Unable to access field.", ex);
        }
    }

    /**
     * Makes the given <code>member</code> accessible via reflection if it is not the case already.
     *
     * @param member The member (field, method, constructor, etc) to make accessible
     * @param <T>    The type of member to make accessible
     * @return the given <code>member</code>, for easier method chaining
     *
     * @throws IllegalStateException if the member is not accessible and the security manager doesn't allow it to be
     *                               made accessible
     */
    public static <T extends AccessibleObject> T ensureAccessible(T member) {
        if (!isAccessible(member)) {
            AccessController.doPrivileged(new MemberAccessibilityCallback(member));
        }
        return member;
    }

    /**
     * Indicates whether the given <code>member</code> is accessible. It does so by checking whether the member is
     * non-final and public, or made accessible via reflection.
     *
     * @param member The member (field, method, constructor, etc) to check for accessibility
     * @return <code>true</code> if the member is accessible, otherwise <code>false</code>.
     */
    public static boolean isAccessible(AccessibleObject member) {
        return member.isAccessible() || (Member.class.isInstance(member) && isNonFinalPublicMember((Member) member));
    }

    /**
     * Checks whether the given <code>member</code> is public and non-final. These members do no need to be set
     * accessible using reflection.
     *
     * @param member The member to check
     * @return <code>true</code> if the member is public and non-final, otherwise <code>false</code>.
     *
     * @see #isAccessible(java.lang.reflect.AccessibleObject)
     * @see #ensureAccessible(java.lang.reflect.AccessibleObject)
     */
    public static boolean isNonFinalPublicMember(Member member) {
        return (Modifier.isPublic(member.getModifiers())
                && Modifier.isPublic(member.getDeclaringClass().getModifiers())
                && !Modifier.isFinal(member.getModifiers()));
    }

    /**
     * Returns the boxed wrapper type for the given <code>primitiveType</code>.
     *
     * @param primitiveType The primitive type to return boxed wrapper type for
     * @return the boxed wrapper type for the given <code>primitiveType</code>
     * @throws IllegalArgumentException will be thrown instead of returning null if no wrapper class was found.
     */
    public static Class<?> resolvePrimitiveWrapperType(Class<?> primitiveType) {
        org.axonframework.common.Assert.notNull(primitiveType, "primitiveType may not be null");
        org.axonframework.common.Assert.isTrue(primitiveType.isPrimitive(), "primitiveType is not actually primitive: " + primitiveType);

        Class<?> primitiveWrapperType = primitiveWrapperTypeMap.get(primitiveType);
        org.axonframework.common.Assert.notNull(primitiveWrapperType, "no wrapper found for primitiveType: " + primitiveType);
        return primitiveWrapperType;

    }

    private static void addMethodsOnDeclaredInterfaces(Class<?> currentClazz, List<Method> methods) {
        for (Class iface : currentClazz.getInterfaces()) {
            methods.addAll(Arrays.asList(iface.getDeclaredMethods()));
            addMethodsOnDeclaredInterfaces(iface, methods);
        }
    }
}
