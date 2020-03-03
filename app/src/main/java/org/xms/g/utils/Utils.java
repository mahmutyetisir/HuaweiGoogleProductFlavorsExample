package org.xms.g.utils;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Utils {

    private static Map<String, String> map = new HashMap<>();

    private static Map<String, String> G2H = new HashMap<>();
    private static Map<String, String> H2G= new HashMap<>();

    private static Map<Class, Constructor> wrapperCache = new ConcurrentHashMap<>();

    private static Map<Class, Method> getGHInstCache = new ConcurrentHashMap<>();

    private static final String G = "g";
    private static final String H = "h";

    public static <T, R> T[] mapArray(R[] array, java.util.function.Function<R, T> mapper) {
        T[] result = (T[]) (java.util.stream.Stream.of(array).map(mapper).toArray());
        String arrayType = array == null ? null : array.getClass().getName();
        String resultType = result == null ? null : result.getClass().getName();
        org.xms.g.utils.XmsLog.i("1", "array : " + arrayType +
            " result : " + resultType, new Throwable());
        return result;
    }

    public static <T, R> T[] mapArray2GH(R[] array, Class<T> cls, boolean isH) {
         Object[] result = (java.util.stream.Stream.of(array).map(it -> (T) Utils.getInstanceInInterface(it, isH)).toArray());
         if (null == result) {
             org.xms.g.utils.XmsLog.w("1", "result is null", new Throwable());
             return null;
         }
         T[] res = (T[]) Array.newInstance(cls, result.length);
         System.arraycopy(res, 0, result, 0, result.length);
         String arrayType = array == null ? null : array.getClass().getName();
         String resultType = result.getClass().getName();
         org.xms.g.utils.XmsLog.i("2", "array : " + arrayType +
                 " isH : " + isH +
                 " result : " + resultType, new Throwable());
         return res;
    }

    public static <T, R> ArrayList<T> mapArrayList(ArrayList<R> list, java.util.function.Function<R, T> mapper) {
        if (null == list) {
            org.xms.g.utils.XmsLog.w("1", "input list is null", new Throwable());
            return null;
        }
        ArrayList<T> result = list.stream().map(mapper).collect(Collectors.toCollection(ArrayList::new));
        String listType = list.getClass().getName();
        String resultType = result == null ? null : result.getClass().getName();
        org.xms.g.utils.XmsLog.i("2", "list : " + listType +
            " result : " + resultType, new Throwable());
        return result;
    }

    public static  <R, T> Iterable<T> transformIterable(Iterable<R> iterable, Function<R, T> mapper) {
        Iterator<T> iterator = StreamSupport.stream(iterable.spliterator(), false).map(mapper).iterator();
        String iteratorType = iterator == null ? null : iterator.getClass().getName();
        org.xms.g.utils.XmsLog.i("1", "iterable : " + iterable.getClass().getName() +
            " result : " + iteratorType, new Throwable());
        return () -> iterator;
    }


    public static <T, R> T[] genericArrayCopy(R[] array, Class<T> type, java.util.function.Function<R, T> mapper) {
        T[] arr = (T[]) Array.newInstance(type, array.length);
        Object[] objects = Stream.of(array).map(mapper).toArray();
        System.arraycopy(objects, 0, arr, 0, arr.length);
        String typeType = type == null ? null : type.getClass().getName();
        org.xms.g.utils.XmsLog.i("1", "array : " + array.getClass().getName() +
            " type : " + typeType +
            " result : " + arr.getClass().getName(), new Throwable());
        return arr;
    }

    public static <K, V, T> Map<T, K> convertMap(Map<T, V> map,
                                                 java.util.function.Function<V, K> mapper) {
        Map<T, K> returnMap = new HashMap<>();
        for (Map.Entry<T, V> entry : map.entrySet()) {
            returnMap.put(entry.getKey(), mapper.apply(map.get(entry.getKey())));
        }
        org.xms.g.utils.XmsLog.i("1", "map : " + map.getClass().getName() +
            " result : " + returnMap.getClass().getName(), new Throwable());
        return returnMap;
    }

    public static <T, R> android.util.SparseArray<T> genericArrayCopy(android.util.SparseArray<R> array, java.util.function.Function<R, T> mapper) {
        android.util.SparseArray<T> arr = new android.util.SparseArray<>(array.size());
        for (int i = 0; i < array.size(); i++) {
		    int key = array.keyAt(i);
            arr.put(key, mapper.apply(array.get(key)));
        }
        org.xms.g.utils.XmsLog.i("1", "array : " + array.getClass().getName() +
            " result : " + arr.getClass().getName(), new Throwable());
        return arr;
    }

    public static <T, R> List<T> mapList(List<R> list, java.util.function.Function<R, T> mapper) {
        if (list == null) {
            org.xms.g.utils.XmsLog.i("1", "list is null", new Throwable());
            return null;
        }
        List<T> result = list.stream().map(mapper).collect(Collectors.toList());
        String resultType = result == null ? null : result.getClass().getName();
        org.xms.g.utils.XmsLog.i("2", "list : " + list.getClass().getName() +
            " result : " + resultType, new Throwable());
        return result;
    }

    public static <T, R> List<T> mapList2GH(List<R> list, boolean isH) {
        List<T> result = mapList(list, it -> getInstanceInInterface(it, isH));
        String listType = list == null ? null : list.getClass().getName();
        String resultType = result == null ? null : result.getClass().getName();
        org.xms.g.utils.XmsLog.i("1", "list : " + listType +
            " isH : " + isH +
            " result : " + resultType, new Throwable());
        return result;
    }

    public static <T, R> List<T> mapList2X(List<R> list, boolean isH) {
        List<T> result = isH ?
                mapList(list, it -> (T) getXmsObjectWithHmsObject(it)) :
                mapList(list, it -> (T) getXmsObjectWithGmsObject(it));
        String listType = list == null ? null : list.getClass().getName();
        String resultType = result == null ? null : result.getClass().getName();
        org.xms.g.utils.XmsLog.i("1", "list : " + listType +
            " isH : " + isH +
            " result : " + resultType, new Throwable());
        return result;
    }

    public static <T, R> Collection<T> mapCollection(Collection<? extends R> collection,
        java.util.function.Function<R, T> mapper) {
        if (collection == null) {
            org.xms.g.utils.XmsLog.i("0", "collection : null", new Throwable());
            return null;
        }

        String collectionType = collection.getClass().getName();
        if (collection instanceof Set) {
            Collection<T> result = collection.stream().map(mapper).collect(Collectors.toSet());
            String resultType = result == null ? null : result.getClass().getName();
            org.xms.g.utils.XmsLog.i("1", "collection : " + collectionType +
                " collection type is Set " +
                " result : " + resultType, new Throwable());
            return result;
        } else {
            Collection<T> result = collection.stream().map(mapper).collect(Collectors.toList());
            String resultType = result == null ? null : result.getClass().getName();
            org.xms.g.utils.XmsLog.i("2", "collection : " + collectionType +
                " collection type is not Set " +
                " result : " + resultType, new Throwable());
            return result;
        }
    }

    public static <T, R> Collection<T> mapCollection2GH(Collection<R> collection, boolean isH) {
        Collection<T> result = mapCollection(collection, it -> getInstanceInInterface(it, isH));
        String collectionType = collection == null ? null : collection.getClass().getName();
        String resultType = result == null ? null : result.getClass().getName();
        org.xms.g.utils.XmsLog.i("1", "collection : " + collectionType +
            " isH : " + isH +
            " result : " + resultType, new Throwable());
        return result;
    }

    public static <T, R> Collection<T> mapCollection2X(Collection<R> collection, boolean isH) {
        Collection<T> result = isH ?
                        mapCollection(collection, it -> (T) getXmsObjectWithHmsObject(it)) :
                        mapCollection(collection, it -> (T) getXmsObjectWithGmsObject(it));
        String collectionType = collection == null ? null : collection.getClass().getName();
        String resultType = result == null ? null : result.getClass().getName();
        org.xms.g.utils.XmsLog.i("1", "collection : " + collectionType +
            " isH : " + isH +
            " result : " + resultType, new Throwable());
        return result;
    }

    private static Object transformList2X(Object object, boolean isH) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        if (!(object instanceof List)) {
            org.xms.g.utils.XmsLog.i("1", "object is List", new Throwable());
            return object;
        }
        List result = (List) object.getClass().newInstance();
        for (int i = 0; i < ((List) object).size(); i++) {
            Object o = ((List) object).get(i);
            if (o == null || !map.containsKey(o.getClass().getCanonicalName())) {
                result.add(o);
                continue;
            }
            // should transform to X.
            String xName = map.get(o.getClass().getCanonicalName());
            Class clazz = Class.forName(xName);
            if (isH) {
                result.add(getOrCreateInstance(clazz, null, o, isH));
            } else {
                result.add(getOrCreateInstance(clazz, o, null, isH));
            }
        }
        String objectType = object.getClass().getName();
        String resultType = result == null ? null : result.getClass().getName();
        org.xms.g.utils.XmsLog.i("2", "object : " + objectType +
            " isH : " + isH +
            " result : " + resultType, new Throwable());
        return result;
    }

    public static Object getXmsObjectWithGmsObject(Object object) {
        if (object == null) {
            return object;
        }
        if (object instanceof List) {
            try {
                return transformList2X(object, false);
            } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (!isGmsType(object)) {
            return object;
        }
        org.xms.g.utils.XmsLog.i("1", "inObject : " + object.getClass().getName(), new Throwable());
        return getXmsObject(object, G);
    }

    public static Object getXmsObjectWithHmsObject(Object object) {
        if (object == null) {
            return object;
        }
        if (object instanceof List) {
            try {
                return transformList2X(object, true);
            } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (!isHmsType(object)) {
            return object;
        }
        org.xms.g.utils.XmsLog.i("1", "inObject : " + object.getClass().getName(), new Throwable());
        return getXmsObject(object, H);
    }

    private static Object getXmsObject(Object object, String GorH) {
        String xmsClassName = null;
        String interfaceClass = null;
        String inClassName = object.getClass().getName();
        inClassName = inClassName.replaceAll("\\$", ".");
        if (map.containsKey(inClassName)) {
            xmsClassName = map.get(inClassName);
            org.xms.g.utils.XmsLog.i("1", "inClassName : " + inClassName + ", xmsClassName : " + xmsClassName, new Throwable());
        } else {
            Class inSuperClass = object.getClass().getSuperclass();
            Class[] interfaces = object.getClass().getInterfaces();
            String inSuperClassStr = inSuperClass.getName();
            inSuperClassStr = inSuperClassStr.replaceAll("\\$", ".");
            while (!map.containsKey(inSuperClassStr)) {
                if (inSuperClassStr.equals("java.lang.Object")) {
                    if (interfaces != null && interfaces.length > 0) {
                        String interfacesStr = interfaces[0].getName();
                        interfacesStr = interfacesStr.replaceAll("\\$", ".");
                        while (!map.containsKey(interfacesStr)) {
                            interfaces = interfaces[0].getInterfaces();
                        }
                        interfaceClass = map.get(interfacesStr);
                        org.xms.g.utils.XmsLog.d("2", "interfacesStr : " + interfacesStr + ", interfaceClass : " + interfaceClass, new Throwable());
                        if (interfaceClass != null) {
                            xmsClassName = interfaceClass;
                            break;
                        }
                    }
                } else {
                    inSuperClass = inSuperClass.getSuperclass();
                    interfaces = inSuperClass.getInterfaces();
                    org.xms.g.utils.XmsLog.d("3", "inSuperClass : " + inSuperClass, new Throwable());
                    if (null != interfaces && interfaces.length > 0) {
                        StringBuffer interfacesSb = new StringBuffer();
                        for (int i = 0; i < interfaces.length; i++) {
                            interfacesSb.append("interfaces [" + i + "] : ").append(interfaces[i].getClass().getName()).append(", ");
                        }
                        org.xms.g.utils.XmsLog.d("4", "interfaces : " + interfacesSb, new Throwable());
                    }
                }
            }
            if (interfaceClass != null) {
                xmsClassName = interfaceClass;
                org.xms.g.utils.XmsLog.i("5", "xmsClassName : " + xmsClassName, new Throwable());
            } else {
                xmsClassName = map.get(inSuperClassStr);
                org.xms.g.utils.XmsLog.i("6", "xmsClassName : " + xmsClassName, new Throwable());
            }
        }

        try {
            Class clazz = Class.forName(xmsClassName);
            org.xms.g.utils.XmsLog.i("7", "clazz : " + clazz.getName(), new Throwable());
            Constructor[] constructors = clazz.getConstructors();
            for (Constructor constructor: constructors) {
                if (constructor.getParameterTypes().length == 2
                        && isGmsClass(constructor.getParameterTypes()[0].getName())) {
                    return "g".equals(GorH) ? constructor.newInstance(object, null)
                            : constructor.newInstance(null, object);
                }
            }
        } catch (ClassNotFoundException e) {
            org.xms.g.utils.XmsLog.e("8", e.getMessage(), e);
        } catch (IllegalAccessException e) {
            org.xms.g.utils.XmsLog.e("9", e.getMessage(), e);
        } catch (InstantiationException e) {
            org.xms.g.utils.XmsLog.e("10", e.getMessage(), e);
        } catch (InvocationTargetException e) {
            org.xms.g.utils.XmsLog.e("11", e.getMessage(), e);
        }
        return null;
    }

    public static boolean isGmsClass(String className) {
        if (className.startsWith("com.google.android.gms")
                || className.startsWith("com.google.firebase")
                || className.startsWith("com.google.ads")
                || className.startsWith("com.android.installreferrer")
                || className.startsWith("com.google.android.libraries")
                || className.startsWith("com.google.api")) {
            org.xms.g.utils.XmsLog.i("1", "true", new Throwable());
            return true;
        }
        org.xms.g.utils.XmsLog.i("2", "false", new Throwable());
        return false;
    }

    public static boolean isHmsClass(String className) {
        if (className.startsWith("com.huawei.hms")
                || className.startsWith("com.huawei.hmf")) {
            org.xms.g.utils.XmsLog.i("1", "true", new Throwable());
            return true;
        }
        org.xms.g.utils.XmsLog.i("2", "false", new Throwable());
        return false;
    }

    private static String wrapGH(String className, String currentIsGorH) {
        if (currentIsGorH.equals(G)) {
            String result = G2H.get(className);
            org.xms.g.utils.XmsLog.i("1", "inClassName : " + className + ", result : " + result, new Throwable());
            return result;
        } else {
            String result = H2G.get(className);
            org.xms.g.utils.XmsLog.i("2", "inClassName : " + className + ", result : " + result, new Throwable());
            return result;
        }
    }

    public static boolean isGmsType(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass().isAnonymousClass() || obj.getClass().isMemberClass()) {
            if (isGmsClass(obj.getClass().getName())) {
                return true;
            }
            if (obj.getClass().getSuperclass().getName().equals("java.lang.Object")) {
                Class[] superInterfaces = obj.getClass().getInterfaces();
                // anonymous class or inner class has only one interface
                for (Class inter : superInterfaces) {
                    return isGmsClass(inter.getName());
                }
            } else {
                Class superClassName = obj.getClass().getSuperclass();
                return isGmsClass(superClassName.getName());
            }
        }
        return isGmsClass(obj.getClass().getName());
    }

    public static boolean isHmsType(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass().isAnonymousClass() || obj.getClass().isMemberClass()) {
            if (isHmsClass(obj.getClass().getName())) {
                return true;
            }
            if (obj.getClass().getSuperclass().getName().equals("java.lang.Object")) {
                Class[] superInterfaces = obj.getClass().getInterfaces();
                // anonymous class or inner class has only one interface
                for (Class inter : superInterfaces) {
                    return isHmsClass(inter.getName());
                }
            } else {
                Class superClassName = obj.getClass().getSuperclass();
                return isHmsClass(superClassName.getName());
            }
        }
        return isHmsClass(obj.getClass().getName());
    }

    public static Class getGmsClassWithXmsClass(Class xmsClass) {
        try {
            Field field = xmsClass.getField("gInstance");
            org.xms.g.utils.XmsLog.i("1", "field.getType : " + field.getType(), new Throwable());
            return field.getType();
        } catch (NoSuchFieldException e) {
            org.xms.g.utils.XmsLog.w("2", "xmsClass : " + xmsClass + ", e : " + e.getMessage(), new Throwable());
            return xmsClass;
        }
    }

    public static Class getHmsClassWithXmsClass(Class xmsClass) {
        try {
            Field field = xmsClass.getField("hInstance");
            org.xms.g.utils.XmsLog.i("1", "field.getType : " + field.getType(), new Throwable());
            return field.getType();
        } catch (NoSuchFieldException e) {
            org.xms.g.utils.XmsLog.w("2", "xmsClass : " + xmsClass + ", e : " + e.getMessage(), new Throwable());
            return xmsClass;
        }
    }

    public static Class getXmsClassWithClass(Class clazz) {

        try {
            if (map.containsKey(clazz.getName())) {
                org.xms.g.utils.XmsLog.i("1", "XmsClass : " + map.get(clazz.getName()), new Throwable());
                return Class.forName(map.get(clazz.getName()));
            }
        } catch (ClassNotFoundException e) {
            org.xms.g.utils.XmsLog.e("2", e.getMessage(), e);
        }
        return null;
    }

    /**
     * Tell a clazz is xms type or not.
     *
     * @param clazz, the clazz need to be identified.
     * @return if clazz is xms type, return true.
     */
    public static boolean isXmsType(Class clazz) {
        boolean result = XInterface.class.isAssignableFrom(clazz);
        org.xms.g.utils.XmsLog.i("1", "isXmsType : " + result, new Throwable());
        return result;
    }

    /**
     * Create an instance from its Class, and we MUST use
     * its wrapper constructor.
     *
     * @param clazz, Create an instance from clazz.
     * @param gInst, first parameter for constructor.
     * @param hInst, second parameter for constructor.
     * @return the instance.
     */
    public static Object getOrCreateInstance(Class clazz, Object gInst, Object hInst, boolean isH) {
        // transform ghList to xList.
        Object instance = isH ? hInst : gInst;
        if (instance == null) {
            org.xms.g.utils.XmsLog.i("1", "instance : null", new Throwable());
            return null;
        }
        if (instance instanceof List) {
            org.xms.g.utils.XmsLog.i("2", "instance is List", new Throwable());
            return mapList2X((List) instance, isH);
        }

        if (!isXmsType(clazz)) {
            org.xms.g.utils.XmsLog.i("3", "instance : " + instance.getClass().getName(), new Throwable());
            // maybe instance is GInstance or HInstance
            if (isH) { // HInstance
                return getXmsObjectWithHmsObject(instance);
            }
            // GInstance
            return getXmsObjectWithGmsObject(instance);
        }

        String className = "";
        if (clazz.isInterface() || Modifier.isAbstract(clazz.getModifiers())) {
            className = clazz.getName();
            className += "$XImpl";
            try {
                org.xms.g.utils.XmsLog.d("4", "className : " + className, new Throwable());
                clazz = Class.forName(className);
            } catch (ClassNotFoundException e) {
                org.xms.g.utils.XmsLog.e("5", e.getMessage(), new Throwable());
            }
        }

        Constructor constructor = getWrapperConstructor(clazz);
        if (constructor != null) {
            try {
                return constructor.newInstance(gInst, hInst);
            } catch (InstantiationException e) {
                org.xms.g.utils.XmsLog.e("6", e.getMessage(), e);
            } catch (IllegalAccessException e) {
                org.xms.g.utils.XmsLog.e("7", e.getMessage(), e);
            } catch (InvocationTargetException e) {
                org.xms.g.utils.XmsLog.e("8", e.getMessage(), e);
            }
        }

        return null;
    }

    /**
     * Find wrapper constructor for an xms class.
     *
     * @param xmsType, the class whose wrapper constructor need to be found.
     * @return xmsType's wrapper constructor.
     */
    public static Constructor getWrapperConstructor(Class xmsType) {
        if (wrapperCache.containsKey(xmsType)) {
            org.xms.g.utils.XmsLog.i("1", "wrapperCache.get(xmsType) xmsType : " + xmsType.getName(), new Throwable());
            return wrapperCache.get(xmsType);
        }

        Constructor[] constructors = xmsType.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            if (constructors[i].getParameterCount() != 2) {
                continue;
            }

            if (map.containsKey(constructors[i].getParameterTypes()[0].getCanonicalName())) {
                wrapperCache.put(xmsType, constructors[i]);
                org.xms.g.utils.XmsLog.i("2", "wrapperCache.put(xmsType, constructors[i]) xmsType : " + xmsType.getName(), new Throwable());
                return constructors[i];
            } else {
                org.xms.g.utils.XmsLog.w("3", "map not containsKey " + constructors[i].getParameterTypes()[0].getCanonicalName(), new Throwable());
            }
        }

        return null;
    }


    /**
     * If an object is xms instance, get its G instance or H instance.
     * An xms object may be an XGettable instance, then it has a concrete g instance,
     * also, it may be an XInterface but not XGettable, we must call these methods
     * by reflection.
     *
     * @param o object to get its g instance.
     * @param isH show we need its g or h instance.
     * @return xms object's g/h instance.
     */
    public static <T> T getInstanceInInterface(Object o, boolean isH) {
        if (!(o instanceof XInterface)) {
            String inObjectType = o == null ? null : o.getClass().getName();
            org.xms.g.utils.XmsLog.i("1", "inObject : " + inObjectType, new Throwable());
            return (T) o;
        }

        if (o instanceof XGettable) {
            if (isH) {
                org.xms.g.utils.XmsLog.i("2", "hInstance : " + ((XGettable) o).getHInstance().getClass().getName(), new Throwable());
                return (T) ((XGettable) o).getHInstance();
            } else {
                org.xms.g.utils.XmsLog.i("3", "gInstance : " + ((XGettable) o).getGInstance().getClass().getName(), new Throwable());
                return (T) ((XGettable) o).getGInstance();
            }
        }

        // o must be an XInterface and not XGettable.
        return (T) reflectiveGetInstance(o, isH);
    }

    private static Object reflectiveGetInstance(Object o, boolean isH) {
        if (getGHInstCache.containsKey(o.getClass())) {
            org.xms.g.utils.XmsLog.i("1", "inObject : " + o.getClass(), new Throwable());
            try {
                return getGHInstCache.get(o.getClass()).invoke(o);
            } catch (IllegalAccessException e) {
                org.xms.g.utils.XmsLog.i("2", "inObject : " + o.getClass(), e);
            } catch (InvocationTargetException e) {
                org.xms.g.utils.XmsLog.i("3", "inObject : " + o.getClass(), e);
            }
        }

        Method[] methods = o.getClass().getMethods();
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].getParameterCount() > 0) {
                continue;
            }

            if (isH && (!methods[i].getName().startsWith("getHInstance"))) {
                continue;
            }

            if (!isH && (!methods[i].getName().startsWith("getGInstance"))) {
                continue;
            }

            org.xms.g.utils.XmsLog.i("2", "inObject : " + o.getClass() + ", methods[i] : " + methods[i].getName(), new Throwable());
            getGHInstCache.put(o.getClass(), methods[i]);
            try {
                return methods[i].invoke(o);
            } catch (IllegalAccessException e) {
                org.xms.g.utils.XmsLog.e("3", e.getMessage(), e);
            } catch (InvocationTargetException e) {
                org.xms.g.utils.XmsLog.e("4", e.getMessage(), e);
            }
        }

        return null;
    }

    /**
     * Invoke the bridge method with the original parameter types.
     *
     * @param receiver the invoke target
     * @param methodName the method name
     * @param params parameters
     * @param paramTypes the declaration types of parameters (the upper bound type for the generic type)
     * @param isH HMS if true; GMS, otherwise
     * @throws IllegalStateException capsuling the real refection exception
     * @return the return value
     */
    public static Object invokeBridgeMethod(Object receiver, String methodName,
                                            Object[] params, Class[] paramTypes, boolean isH)
            throws IllegalStateException {
        if (params == null) {
            org.xms.g.utils.XmsLog.w("1", "params == null", new Throwable());
            throw new IllegalArgumentException("null params");
        }

        if (paramTypes == null) {
            org.xms.g.utils.XmsLog.w("2", "paramTypes == null", new Throwable());
            throw new IllegalArgumentException("null paramTypes");
        }

        if (params.length != paramTypes.length) {
            org.xms.g.utils.XmsLog.w("3", "params.length != paramTypes.length", new Throwable());
            throw new IllegalArgumentException("mismatched params and paramTypes");
        }

        Method bridgeMethod = org.xms.thirdparty.ClassUtils.getMethod(receiver.getClass(), methodName, paramTypes);
        Method bridgedMethod = org.xms.thirdparty.BridgeMethodResolver.findBridgedMethod(bridgeMethod);
        try {
            String bridgeMethodType = bridgeMethod.getName();
            String bridgedMethodMethodType = bridgedMethod.getName();
            org.xms.g.utils.XmsLog.d("4", "bridgeMethod : " + bridgeMethodType + ", bridgedMethod : " + bridgedMethodMethodType, new Throwable());
            Class<?>[] types = bridgedMethod.getParameterTypes();
            Object[] args = new Object[params.length];
            for (int i = 0; i < params.length; i++) {
                if (isH) {
                    args[i] = Utils.getOrCreateInstance(types[i], null, params[i], isH);
                } else {
                    args[i] = Utils.getOrCreateInstance(types[i], params[i], null, isH);
                }
            }
            org.xms.g.utils.XmsLog.i("5", "receiver : " + receiver.getClass().getName(), new Throwable());
            if (args.length > 0) {
                StringBuffer argSb = new StringBuffer();
                for (int i = 0; i < args.length; i++) {
                    String argsType =  args[i] == null ? null : args[i].getClass().getName();
                    argSb.append("args [" + i + "] : ").append(argsType).append(", ");
                }
                org.xms.g.utils.XmsLog.i("6", argSb.toString(), new Throwable());
            }
            bridgedMethod.setAccessible(true);
            return bridgedMethod.invoke(receiver, args);
        } catch (Exception ex) {
            org.xms.g.utils.XmsLog.e("7", ex.getMessage(), ex);
            throw new IllegalStateException(ex);
        }
    }

    /**
     * handle invokeBridge method return value.
     * return value need type cast.
     *
     * @param receiver the invoke target
     * @param isH      HMS if true; GMS, otherwise
     * @return the return value
     */
    public static Object handleInvokeBridgeReturnValue(Object receiver, boolean isH) {
        // not xms type
        if (!isXmsType(receiver.getClass())) {
            org.xms.g.utils.XmsLog.d("1", "receiver : " + receiver.getClass().getName(), new Throwable());
            return receiver;
        }
        // gettable, use Gettable getGorHinstance
        if (receiver instanceof XGettable) {
            if (isH) {
                org.xms.g.utils.XmsLog.i("2", "hInstance : " + ((XGettable) receiver).getHInstance().getClass().getName(), new Throwable());
                return ((XGettable) receiver).getHInstance();
            }
            org.xms.g.utils.XmsLog.i("3", "gInstance : " + ((XGettable) receiver).getGInstance().getClass().getName(), new Throwable());
            return ((XGettable) receiver).getGInstance();
        }
        // interface, invoke default getHorGInstance method
        Method[] methods = receiver.getClass().getMethods();
        int cnt = 0;
        String prefix = isH ? "getHInstance" : "getGInstance";
        Method target = null;
        for (Method m : methods) {
            if (m.getName().startsWith(prefix)) {
                cnt++;
                target = m;
            }
        }
        if (cnt == 1) {
            try {
                org.xms.g.utils.XmsLog.i("4", "receiver : " + receiver.getClass().getName(), new Throwable());
                return target.invoke(receiver);
            } catch (IllegalAccessException e) {
                org.xms.g.utils.XmsLog.e("5", e.getMessage(), e);
            } catch (InvocationTargetException e) {
                org.xms.g.utils.XmsLog.e("6", e.getMessage(), e);
            }
        }
        IllegalStateException illegalStateException = new IllegalStateException("mutiple getInstance methods found.");
        org.xms.g.utils.XmsLog.w("7", illegalStateException.getMessage(), new Throwable());
        throw illegalStateException;
    }

    public static Object invokeProtectMethod(Object receiver, Class targetClass, String methodName, Class[] methodParametersType, Object[] args) {
        if (targetClass == null) {
            throw new IllegalStateException("null class.");
        }
        if (methodName == null || methodName.isEmpty()) {
            throw new IllegalStateException("methodName not exist.");
        }
        try {
            Method method = null;
            method = targetClass.getDeclaredMethod(methodName, methodParametersType);
            assert method != null;
            method.setAccessible(true);
            return method.invoke(receiver, args);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    static {
        map.put("com.google.android.gms.nearby.messages.BleSignal", "org.xms.g.nearby.messages.BleSignal$XImpl");
        map.put("com.huawei.hms.nearby.discovery.BleSignal", "org.xms.g.nearby.messages.BleSignal$XImpl");
        map.put("com.google.android.gms.ads.mediation.UnifiedNativeAdMapper", "org.xms.g.ads.mediation.UnifiedNativeAdMapper");
        map.put("com.google.android.gms.maps.model.MapStyleOptions", "org.xms.g.maps.model.MapStyleOptions");
        map.put("com.huawei.hms.maps.model.MapStyleOptions", "org.xms.g.maps.model.MapStyleOptions");
        map.put("com.google.firebase.ml.vision.cloud.landmark.FirebaseVisionCloudLandmark", "org.xms.f.ml.vision.cloud.landmark.FirebaseVisionCloudLandmark");
        map.put("com.huawei.hms.mlsdk.landmark.MLRemoteLandmark", "org.xms.f.ml.vision.cloud.landmark.FirebaseVisionCloudLandmark");
        map.put("com.google.android.gms.ads.VideoOptions.Builder", "org.xms.g.ads.VideoOptions$Builder");
        map.put("com.huawei.hms.ads.VideoConfiguration.Builder", "org.xms.g.ads.VideoOptions$Builder");
        map.put("com.google.android.gms.games.video.CaptureState", "org.xms.g.games.video.CaptureState");
        map.put("com.google.android.gms.maps.StreetViewPanorama.OnStreetViewPanoramaClickListener", "org.xms.g.maps.StreetViewPanorama$OnStreetViewPanoramaClickListener$XImpl");
        map.put("com.google.android.gms.ads.mediation.VersionInfo", "org.xms.g.ads.mediation.VersionInfo");
        map.put("com.google.firebase.ml.custom.FirebaseModelInterpreterOptions", "org.xms.f.ml.custom.FirebaseModelInterpreterOptions");
        map.put("com.google.android.gms.nearby.messages.MessagesClient", "org.xms.g.nearby.messages.MessagesClient$XImpl");
        map.put("com.huawei.hms.nearby.message.MessageEngine", "org.xms.g.nearby.messages.MessagesClient$XImpl");
        map.put("com.google.android.gms.ads.AdSize", "org.xms.g.ads.AdSize");
        map.put("com.huawei.hms.ads.BannerAdSize", "org.xms.g.ads.AdSize");
        map.put("com.google.android.gms.games.Games", "org.xms.g.games.Games");
        map.put("com.huawei.hms.jos.games.Games", "org.xms.g.games.Games");
        map.put("com.google.android.gms.location.GeofencingClient", "org.xms.g.location.GeofencingClient");
        map.put("com.huawei.hms.location.GeofenceService", "org.xms.g.location.GeofencingClient");
        map.put("com.google.android.gms.vision.barcode.Barcode.PersonName", "org.xms.g.vision.barcode.Barcode$PersonName");
        map.put("com.huawei.hms.ml.scan.HmsScan.PeopleName", "org.xms.g.vision.barcode.Barcode$PersonName");
        map.put("com.google.android.gms.auth.api.signin.GoogleSignInResult", "org.xms.g.auth.api.signin.ExtensionSignInResult");
        map.put("com.huawei.hms.support.hwid.result.HuaweiIdAuthResult", "org.xms.g.auth.api.signin.ExtensionSignInResult");
        map.put("com.google.android.gms.ads.mediation.customevent.CustomEventBannerListener", "org.xms.g.ads.mediation.customevent.CustomEventBannerListener$XImpl");
        map.put("com.google.android.gms.common.data.AbstractDataBuffer", "org.xms.g.common.data.AbstractDataBuffer$XImpl");
        map.put("com.huawei.hms.common.data.AbstractDataBuffer", "org.xms.g.common.data.AbstractDataBuffer$XImpl");
        map.put("com.google.android.gms.nearby.messages.StatusCallback", "org.xms.g.nearby.messages.StatusCallback");
        map.put("com.huawei.hms.nearby.message.StatusCallback", "org.xms.g.nearby.messages.StatusCallback");
        map.put("com.google.android.gms.fitness.data.DataSource", "org.xms.g.fitness.data.DataSource");
        map.put("com.huawei.hms.hihealth.data.DataCollector", "org.xms.g.fitness.data.DataSource");
        map.put("com.google.android.gms.common.data.FreezableUtils", "org.xms.g.common.data.FreezableUtils");
        map.put("com.huawei.hms.common.data.FreezableUtils", "org.xms.g.common.data.FreezableUtils");
        map.put("com.google.android.gms.games.multiplayer.realtime.RoomUpdateCallback", "org.xms.g.games.multiplayer.realtime.RoomUpdateCallback$XImpl");
        map.put("com.google.android.gms.ads.mediation.MediationAdConfiguration", "org.xms.g.ads.mediation.MediationAdConfiguration");
        map.put("com.google.android.gms.fitness.GoalsClient", "org.xms.g.fitness.GoalsClient");
        map.put("com.google.android.gms.ads.rewarded.RewardItem", "org.xms.g.ads.rewarded.RewardItem$XImpl");
        map.put("com.huawei.hms.ads.reward.Reward", "org.xms.g.ads.rewarded.RewardItem$XImpl");
        map.put("com.google.android.gms.ads.reward.RewardedVideoAd", "org.xms.g.ads.reward.RewardedVideoAd$XImpl");
        map.put("com.google.android.gms.maps.model.Dot", "org.xms.g.maps.model.Dot");
        map.put("com.huawei.hms.maps.model.Dot", "org.xms.g.maps.model.Dot");
        map.put("com.google.android.gms.vision.face.LargestFaceFocusingProcessor.Builder", "org.xms.g.vision.face.LargestFaceFocusingProcessor$Builder");
        map.put("com.huawei.hms.mlsdk.face.MLMaxSizeFaceTransactor.Creator", "org.xms.g.vision.face.LargestFaceFocusingProcessor$Builder");
        map.put("com.google.android.gms.maps.StreetViewPanorama", "org.xms.g.maps.StreetViewPanorama");
        map.put("com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult", "org.xms.g.games.multiplayer.turnbased.TurnBasedMultiplayer$LeaveMatchResult$XImpl");
        map.put("com.google.android.gms.ads.doubleclick.CustomRenderedAd", "org.xms.g.ads.doubleclick.CustomRenderedAd$XImpl");
        map.put("com.google.android.gms.ads.instream.InstreamAd", "org.xms.g.ads.instream.InstreamAd$XImpl");
        map.put("com.google.android.gms.analytics.HitBuilders.HitBuilder", "org.xms.g.analytics.HitBuilders$HitBuilder");
        map.put("com.google.android.gms.auth.api.accounttransfer.AccountTransfer", "org.xms.g.auth.api.accounttransfer.AccountTransfer");
        map.put("com.google.android.gms.ads.reward.RewardedVideoAdListener", "org.xms.g.ads.reward.RewardedVideoAdListener$XImpl");
        map.put("com.huawei.hms.ads.reward.RewardAdListener", "org.xms.g.ads.reward.RewardedVideoAdListener$XImpl");
        map.put("com.google.android.gms.fitness.BleClient", "org.xms.g.fitness.BleClient");
        map.put("com.huawei.hms.hihealth.BleController", "org.xms.g.fitness.BleClient");
        map.put("com.android.installreferrer.api.ReferrerDetails", "org.xms.installreferrer.api.ReferrerDetails");
        map.put("com.huawei.hms.ads.installreferrer.api.ReferrerDetails", "org.xms.installreferrer.api.ReferrerDetails");
        map.put("com.google.android.gms.games.Game", "org.xms.g.games.Game$XImpl");
        map.put("com.huawei.hms.jos.games.gamesummary.GameSummary", "org.xms.g.games.Game$XImpl");
        map.put("com.google.android.gms.vision.Frame.Builder", "org.xms.g.vision.Frame$Builder");
        map.put("com.huawei.hms.mlsdk.common.MLFrame.Creator", "org.xms.g.vision.Frame$Builder");
        map.put("com.google.android.gms.gcm.GcmTaskService", "org.xms.g.gcm.GcmTaskService$XImpl");
        map.put("com.google.firebase.ml.vision.common.FirebaseVisionImage", "org.xms.f.ml.vision.common.FirebaseVisionImage");
        map.put("com.huawei.hms.mlsdk.common.MLFrame", "org.xms.f.ml.vision.common.FirebaseVisionImage");
        map.put("com.google.android.gms.awareness.SnapshotClient", "org.xms.g.awareness.SnapshotClient");
        map.put("com.huawei.hms.kit.awareness.CaptureClient", "org.xms.g.awareness.SnapshotClient");
        map.put("com.google.firebase.ml.custom.FirebaseModelInterpreter", "org.xms.f.ml.custom.FirebaseModelInterpreter");
        map.put("com.google.android.gms.nearby.connection.PayloadCallback", "org.xms.g.nearby.connection.PayloadCallback$XImpl");
        map.put("com.huawei.hms.nearby.transfer.DataCallback", "org.xms.g.nearby.connection.PayloadCallback$XImpl");
        map.put("com.google.android.gms.gcm.OneoffTask", "org.xms.g.gcm.OneoffTask");
        map.put("com.google.android.gms.games.GamesMetadataClient", "org.xms.g.games.GamesMetadataClient");
        map.put("com.huawei.hms.jos.games.GameSummaryClient", "org.xms.g.games.GamesMetadataClient");
        map.put("com.google.android.gms.fitness.data.Subscription", "org.xms.g.fitness.data.Subscription");
        map.put("com.huawei.hms.hihealth.data.Record", "org.xms.g.fitness.data.Subscription");
        map.put("com.google.android.gms.ads.formats.NativeAdOptions.Builder", "org.xms.g.ads.formats.NativeAdOptions$Builder");
        map.put("com.huawei.hms.ads.nativead.NativeAdConfiguration.Builder", "org.xms.g.ads.formats.NativeAdOptions$Builder");
        map.put("com.google.android.gms.awareness.snapshot.HeadphoneStateResult", "org.xms.g.awareness.snapshot.HeadphoneStateResult$XImpl");
        map.put("com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig.Builder", "org.xms.g.games.multiplayer.turnbased.TurnBasedMatchConfig$Builder");
        map.put("com.google.android.gms.ads.formats.NativeCustomTemplateAd.DisplayOpenMeasurement", "org.xms.g.ads.formats.NativeCustomTemplateAd$DisplayOpenMeasurement$XImpl");
        map.put("com.google.android.gms.analytics.HitBuilders.AppViewBuilder", "org.xms.g.analytics.HitBuilders$AppViewBuilder");
        map.put("com.google.firebase.ml.vision.text.FirebaseVisionText.TextBlock", "org.xms.f.ml.vision.text.FirebaseVisionText$TextBlock");
        map.put("com.huawei.hms.mlsdk.text.MLText.Block", "org.xms.f.ml.vision.text.FirebaseVisionText$TextBlock");
        map.put("com.google.firebase.ml.custom.FirebaseModelInputOutputOptions", "org.xms.f.ml.custom.FirebaseModelInputOutputOptions");
        map.put("com.google.android.gms.games.multiplayer.Multiplayer", "org.xms.g.games.multiplayer.Multiplayer$XImpl");
        map.put("com.google.android.gms.awareness.fence.FenceUpdateRequest", "org.xms.g.awareness.fence.FenceUpdateRequest$XImpl");
        map.put("com.huawei.hms.kit.awareness.barrier.BarrierUpdateRequest", "org.xms.g.awareness.fence.FenceUpdateRequest$XImpl");
        map.put("com.google.android.gms.games.multiplayer.realtime.RoomConfig", "org.xms.g.games.multiplayer.realtime.RoomConfig$XImpl");
        map.put("com.google.android.gms.wallet.PaymentMethodToken", "org.xms.g.wallet.PaymentMethodToken");
        map.put("com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig", "org.xms.g.games.multiplayer.turnbased.TurnBasedMatchConfig$XImpl");
        map.put("com.google.android.gms.vision.text.TextRecognizer", "org.xms.g.vision.text.TextRecognizer");
        map.put("com.huawei.hms.mlsdk.text.MLTextAnalyzer", "org.xms.g.vision.text.TextRecognizer");
        map.put("com.google.android.gms.maps.GoogleMap.OnIndoorStateChangeListener", "org.xms.g.maps.ExtensionMap$OnIndoorStateChangeListener$XImpl");
        map.put("com.huawei.hms.maps.HuaweiMap.OnIndoorStateChangeListener", "org.xms.g.maps.ExtensionMap$OnIndoorStateChangeListener$XImpl");
        map.put("com.google.firebase.FirebaseApiNotAvailableException", "org.xms.f.FirebaseApiNotAvailableException");
        map.put("com.google.android.gms.fitness.SensorsClient", "org.xms.g.fitness.SensorsClient");
        map.put("com.huawei.hms.hihealth.SensorsController", "org.xms.g.fitness.SensorsClient");
        map.put("com.google.android.gms.maps.model.TileProvider", "org.xms.g.maps.model.TileProvider$XImpl");
        map.put("com.huawei.hms.maps.model.TileProvider", "org.xms.g.maps.model.TileProvider$XImpl");
        map.put("com.google.android.gms.nearby.connection.AppIdentifier", "org.xms.g.nearby.connection.AppIdentifier");
        map.put("com.google.android.gms.maps.LocationSource.OnLocationChangedListener", "org.xms.g.maps.LocationSource$OnLocationChangedListener$XImpl");
        map.put("com.huawei.hms.maps.LocationSource.OnLocationChangedListener", "org.xms.g.maps.LocationSource$OnLocationChangedListener$XImpl");
        map.put("com.google.android.gms.maps.model.ButtCap", "org.xms.g.maps.model.ButtCap");
        map.put("com.huawei.hms.maps.model.ButtCap", "org.xms.g.maps.model.ButtCap");
        map.put("com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode.CalendarDateTime", "org.xms.f.ml.vision.barcode.FirebaseVisionBarcode$CalendarDateTime");
        map.put("com.huawei.hms.ml.scan.HmsScan.EventTime", "org.xms.f.ml.vision.barcode.FirebaseVisionBarcode$CalendarDateTime");
        map.put("com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener", "org.xms.g.ads.doubleclick.OnCustomRenderedAdLoadedListener$XImpl");
        map.put("com.google.android.gms.vision.Tracker", "org.xms.g.vision.Tracker");
        map.put("com.huawei.hms.mlsdk.common.MLResultTrailer", "org.xms.g.vision.Tracker");
        map.put("com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener", "org.xms.g.games.multiplayer.realtime.RoomStatusUpdateListener$XImpl");
        map.put("com.google.android.gms.nearby.messages.Distance", "org.xms.g.nearby.messages.Distance$XImpl");
        map.put("com.huawei.hms.nearby.discovery.Distance", "org.xms.g.nearby.messages.Distance$XImpl");
        map.put("com.google.android.gms.auth.api.accounttransfer.AccountTransferStatusCodes", "org.xms.g.auth.api.accounttransfer.AccountTransferStatusCodes");
        map.put("com.google.android.gms.games.snapshot.SnapshotMetadataChange.Builder", "org.xms.g.games.snapshot.SnapshotMetadataChange$Builder");
        map.put("com.huawei.hms.jos.games.archive.ArchiveSummaryUpdate.Builder", "org.xms.g.games.snapshot.SnapshotMetadataChange$Builder");
        map.put("com.google.android.gms.fitness.result.SessionReadResponse", "org.xms.g.fitness.result.SessionReadResponse");
        map.put("com.huawei.hms.hihealth.result.ActivityRecordReply", "org.xms.g.fitness.result.SessionReadResponse");
        map.put("com.google.android.gms.analytics.AnalyticsJobService", "org.xms.g.analytics.AnalyticsJobService");
        map.put("com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener", "org.xms.g.ads.reward.mediation.MediationRewardedVideoAdListener$XImpl");
        map.put("com.google.android.gms.maps.model.StreetViewPanoramaLocation", "org.xms.g.maps.model.StreetViewPanoramaLocation");
        map.put("com.google.android.gms.common.data.DataBufferObserver.Observable", "org.xms.g.common.data.DataBufferObserver$Observable$XImpl");
        map.put("com.google.android.gms.identity.intents.AddressConstants", "org.xms.g.identity.intents.AddressConstants$XImpl");
        map.put("com.huawei.hms.identity.AddressConstants", "org.xms.g.identity.intents.AddressConstants$XImpl");
        map.put("com.google.android.gms.common.api.BatchResult", "org.xms.g.common.api.BatchResult");
        map.put("com.google.android.gms.tasks.OnFailureListener", "org.xms.g.tasks.OnFailureListener$XImpl");
        map.put("com.huawei.hmf.tasks.OnFailureListener", "org.xms.g.tasks.OnFailureListener$XImpl");
        map.put("com.google.android.gms.analytics.ExceptionReporter", "org.xms.g.analytics.ExceptionReporter");
        map.put("com.google.android.gms.ads.mediation.customevent.CustomEventNativeListener", "org.xms.g.ads.mediation.customevent.CustomEventNativeListener$XImpl");
        map.put("com.google.android.gms.ads.mediation.MediationBannerAd", "org.xms.g.ads.mediation.MediationBannerAd$XImpl");
        map.put("com.google.android.gms.fitness.request.DataDeleteRequest.Builder", "org.xms.g.fitness.request.DataDeleteRequest$Builder");
        map.put("com.huawei.hms.hihealth.options.DeleteOptions.Builder", "org.xms.g.fitness.request.DataDeleteRequest$Builder");
        map.put("com.google.android.gms.maps.SupportStreetViewPanoramaFragment", "org.xms.g.maps.SupportStreetViewPanoramaFragment");
        map.put("com.google.android.gms.safetynet.SafetyNetStatusCodes", "org.xms.g.safetynet.SafetyNetStatusCodes");
        map.put("com.huawei.hms.support.api.safetydetect.SafetyDetectStatusCodes", "org.xms.g.safetynet.SafetyNetStatusCodes");
        map.put("com.google.android.gms.nearby.messages.PublishOptions", "org.xms.g.nearby.messages.PublishOptions");
        map.put("com.huawei.hms.nearby.message.PutOption", "org.xms.g.nearby.messages.PublishOptions");
        map.put("com.google.android.gms.maps.model.BitmapDescriptor", "org.xms.g.maps.model.BitmapDescriptor");
        map.put("com.huawei.hms.maps.model.BitmapDescriptor", "org.xms.g.maps.model.BitmapDescriptor");
        map.put("com.google.android.gms.maps.LocationSource", "org.xms.g.maps.LocationSource$XImpl");
        map.put("com.huawei.hms.maps.LocationSource", "org.xms.g.maps.LocationSource$XImpl");
        map.put("com.google.android.gms.auth.api.credentials.CredentialsApi", "org.xms.g.auth.api.credentials.CredentialsApi$XImpl");
        map.put("com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter", "org.xms.g.ads.reward.mediation.MediationRewardedVideoAdAdapter$XImpl");
        map.put("com.google.android.gms.measurement.AppMeasurementJobService", "org.xms.g.measurement.AppMeasurementJobService");
        map.put("com.google.android.gms.safetynet.SafetyNetClient", "org.xms.g.safetynet.SafetyNetClient");
        map.put("com.huawei.hms.support.api.safetydetect.SafetyDetectClient", "org.xms.g.safetynet.SafetyNetClient");
        map.put("com.google.android.gms.auth.account.WorkAccountApi.AddAccountResult", "org.xms.g.auth.account.WorkAccountApi$AddAccountResult$XImpl");
        map.put("com.google.android.gms.maps.model.Dash", "org.xms.g.maps.model.Dash");
        map.put("com.huawei.hms.maps.model.Dash", "org.xms.g.maps.model.Dash");
        map.put("com.google.android.gms.awareness.snapshot.DetectedActivityResult", "org.xms.g.awareness.snapshot.DetectedActivityResult$XImpl");
        map.put("com.google.android.gms.maps.GoogleMap.OnMapLongClickListener", "org.xms.g.maps.ExtensionMap$OnMapLongClickListener$XImpl");
        map.put("com.huawei.hms.maps.HuaweiMap.OnMapLongClickListener", "org.xms.g.maps.ExtensionMap$OnMapLongClickListener$XImpl");
        map.put("com.google.android.gms.games.achievement.AchievementEntity", "org.xms.g.games.achievement.AchievementEntity");
        map.put("com.huawei.hms.jos.games.achievement.Achievement", "org.xms.g.games.achievement.AchievementEntity");
        map.put("com.google.android.gms.auth.account.WorkAccountApi", "org.xms.g.auth.account.WorkAccountApi$XImpl");
        map.put("com.google.android.gms.location.LocationAvailability", "org.xms.g.location.LocationAvailability");
        map.put("com.huawei.hms.location.LocationAvailability", "org.xms.g.location.LocationAvailability");
        map.put("com.google.android.gms.auth.api.credentials.CredentialsOptions", "org.xms.g.auth.api.credentials.CredentialsOptions");
        map.put("com.google.android.gms.maps.GoogleMap.OnMapClickListener", "org.xms.g.maps.ExtensionMap$OnMapClickListener$XImpl");
        map.put("com.huawei.hms.maps.HuaweiMap.OnMapClickListener", "org.xms.g.maps.ExtensionMap$OnMapClickListener$XImpl");
        map.put("com.google.android.gms.games.Player", "org.xms.g.games.Player$XImpl");
        map.put("com.huawei.hms.jos.games.player.Player", "org.xms.g.games.Player$XImpl");
        map.put("com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult", "org.xms.g.games.snapshot.Snapshots$LoadSnapshotsResult$XImpl");
        map.put("com.google.android.gms.ads.formats.NativeContentAd", "org.xms.g.ads.formats.NativeContentAd$XImpl");
        map.put("com.google.android.gms.games.GameEntity", "org.xms.g.games.GameEntity");
        map.put("com.google.android.gms.location.GeofencingApi", "org.xms.g.location.GeofencingApi$XImpl");
        map.put("com.google.android.gms.wallet.IsReadyToPayRequest.Builder", "org.xms.g.wallet.IsReadyToPayRequest$Builder");
        map.put("com.google.firebase.analytics.FirebaseAnalytics.Event", "org.xms.f.analytics.FirebaseAnalytics$Event");
        map.put("com.huawei.hms.analytics.type.HAEventType", "org.xms.f.analytics.FirebaseAnalytics$Event");
        map.put("com.google.android.gms.games.achievement.Achievement", "org.xms.g.games.achievement.Achievement$XImpl");
        map.put("com.huawei.hms.jos.games.achievement.Achievement", "org.xms.g.games.achievement.Achievement$XImpl");
        map.put("com.google.android.gms.identity.intents.AddressConstants.ErrorCodes", "org.xms.g.identity.intents.AddressConstants$ErrorCodes$XImpl");
        map.put("com.google.android.gms.nearby.connection.PayloadTransferUpdate.Status", "org.xms.g.nearby.connection.PayloadTransferUpdate$Status$XImpl");
        map.put("com.huawei.hms.nearby.transfer.TransferStateUpdate.Status", "org.xms.g.nearby.connection.PayloadTransferUpdate$Status$XImpl");
        map.put("com.google.android.gms.actions.NoteIntents", "org.xms.g.actions.NoteIntents");
        map.put("com.google.android.gms.games.snapshot.SnapshotMetadataChange", "org.xms.g.games.snapshot.SnapshotMetadataChange$XImpl");
        map.put("com.huawei.hms.jos.games.archive.ArchiveSummaryUpdate", "org.xms.g.games.snapshot.SnapshotMetadataChange$XImpl");
        map.put("com.google.firebase.ml.vision.text.FirebaseVisionText.Line", "org.xms.f.ml.vision.text.FirebaseVisionText$Line");
        map.put("com.huawei.hms.mlsdk.text.MLText.TextLine", "org.xms.f.ml.vision.text.FirebaseVisionText$Line");
        map.put("com.google.android.gms.vision.Detector", "org.xms.g.vision.Detector$XImpl");
        map.put("com.huawei.hms.mlsdk.common.MLAnalyzer", "org.xms.g.vision.Detector$XImpl");
        map.put("com.google.android.gms.games.GamesCallbackStatusCodes", "org.xms.g.games.GamesCallbackStatusCodes");
        map.put("com.google.android.gms.nearby.connection.Connections.StartAdvertisingResult", "org.xms.g.nearby.connection.Connections$StartAdvertisingResult$XImpl");
        map.put("com.google.android.gms.awareness.state.BeaconState.BeaconInfo", "org.xms.g.awareness.state.BeaconState$BeaconInfo$XImpl");
        map.put("com.huawei.hms.kit.awareness.status.BeaconStatus.BeaconData", "org.xms.g.awareness.state.BeaconState$BeaconInfo$XImpl");
        map.put("com.google.android.gms.auth.api.credentials.Credential.Builder", "org.xms.g.auth.api.credentials.Credential$Builder");
        map.put("com.google.android.gms.vision.barcode.Barcode", "org.xms.g.vision.barcode.Barcode");
        map.put("com.huawei.hms.ml.scan.HmsScan", "org.xms.g.vision.barcode.Barcode");
        map.put("com.google.android.gms.fitness.HistoryApi.ViewIntentBuilder", "org.xms.g.fitness.HistoryApi$ViewIntentBuilder");
        map.put("com.huawei.hms.hihealth.DataManager.GetIntentInfos", "org.xms.g.fitness.HistoryApi$ViewIntentBuilder");
        map.put("com.google.android.gms.ads.mediation.MediationRewardedAd", "org.xms.g.ads.mediation.MediationRewardedAd$XImpl");
        map.put("com.google.android.gms.common.api.Api.ApiOptions", "org.xms.g.common.api.Api$ApiOptions$XImpl");
        map.put("com.huawei.hms.api.Api.ApiOptions", "org.xms.g.common.api.Api$ApiOptions$XImpl");
        map.put("com.google.android.gms.fitness.request.StartBleScanRequest", "org.xms.g.fitness.request.StartBleScanRequest");
        map.put("com.huawei.hms.hihealth.options.StartBleScanOptions", "org.xms.g.fitness.request.StartBleScanRequest");
        map.put("com.google.android.gms.safetynet.SafetyNet", "org.xms.g.safetynet.SafetyNet");
        map.put("com.huawei.hms.support.api.safetydetect.SafetyDetect", "org.xms.g.safetynet.SafetyNet");
        map.put("com.google.android.gms.ads.formats.PublisherAdViewOptions.Builder", "org.xms.g.ads.formats.PublisherAdViewOptions$Builder");
        map.put("com.google.android.gms.games.snapshot.SnapshotMetadata", "org.xms.g.games.snapshot.SnapshotMetadata$XImpl");
        map.put("com.huawei.hms.jos.games.archive.ArchiveSummary", "org.xms.g.games.snapshot.SnapshotMetadata$XImpl");
        map.put("com.google.firebase.ml.naturallanguage.FirebaseNaturalLanguage", "org.xms.f.ml.naturallanguage.FirebaseNaturalLanguage");
        map.put("com.google.android.gms.maps.GoogleMap.OnGroundOverlayClickListener", "org.xms.g.maps.ExtensionMap$OnGroundOverlayClickListener$XImpl");
        map.put("com.android.installreferrer.commons.InstallReferrerCommons", "org.xms.installreferrer.commons.InstallReferrerCommons");
        map.put("com.huawei.hms.ads.installreferrer.commons.InstallReferrerCommons", "org.xms.installreferrer.commons.InstallReferrerCommons");
        map.put("com.google.android.gms.games.multiplayer.Invitation", "org.xms.g.games.multiplayer.Invitation$XImpl");
        map.put("com.google.android.gms.common.api.Api.ApiOptions.Optional", "org.xms.g.common.api.Api$ApiOptions$Optional$XImpl");
        map.put("com.huawei.hms.api.Api.ApiOptions.Optional", "org.xms.g.common.api.Api$ApiOptions$Optional$XImpl");
        map.put("com.google.android.gms.panorama.PanoramaApi.PanoramaResult", "org.xms.g.panorama.PanoramaApi$PanoramaResult$XImpl");
        map.put("com.huawei.hms.panorama.PanoramaInterface.ImageInfoResult", "org.xms.g.panorama.PanoramaApi$PanoramaResult$XImpl");
        map.put("com.google.firebase.ml.vision.barcode.FirebaseVisionBarcodeDetectorOptions.Builder", "org.xms.f.ml.vision.barcode.FirebaseVisionBarcodeDetectorOptions$Builder");
        map.put("com.huawei.hms.ml.scan.HmsScanAnalyzerOptions.Creator", "org.xms.f.ml.vision.barcode.FirebaseVisionBarcodeDetectorOptions$Builder");
        map.put("com.google.android.gms.fitness.result.DataSourcesResult", "org.xms.g.fitness.result.DataSourcesResult");
        map.put("com.huawei.hms.hihealth.result.DataCollectorsResult", "org.xms.g.fitness.result.DataSourcesResult");
        map.put("com.google.android.gms.vision.Frame", "org.xms.g.vision.Frame");
        map.put("com.huawei.hms.mlsdk.common.MLFrame", "org.xms.g.vision.Frame");
        map.put("com.google.android.gms.vision.face.FaceDetector.Builder", "org.xms.g.vision.face.FaceDetector$Builder");
        map.put("com.huawei.hms.mlsdk.face.MLFaceAnalyzer.Factory", "org.xms.g.vision.face.FaceDetector$Builder");
        map.put("com.google.android.gms.fitness.request.BleScanCallback", "org.xms.g.fitness.request.BleScanCallback$XImpl");
        map.put("com.huawei.hms.hihealth.options.BleScanCallback", "org.xms.g.fitness.request.BleScanCallback$XImpl");
        map.put("com.google.android.gms.gcm.PeriodicTask.Builder", "org.xms.g.gcm.PeriodicTask$Builder");
        map.put("com.google.android.gms.common.api.Api.ApiOptions.HasAccountOptions", "org.xms.g.common.api.Api$ApiOptions$HasAccountOptions$XImpl");
        map.put("com.huawei.hms.support.api.hwid.HuaweiAccountOptions.HasAccountOptions", "org.xms.g.common.api.Api$ApiOptions$HasAccountOptions$XImpl");
        map.put("com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder", "org.xms.g.auth.api.signin.ExtensionSignInOptions$Builder");
        map.put("com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper", "org.xms.g.auth.api.signin.ExtensionSignInOptions$Builder");
        map.put("com.google.firebase.ml.common.modeldownload.FirebaseModelDownloadConditions", "org.xms.f.ml.common.modeldownload.FirebaseModelDownloadConditions");
        map.put("com.google.android.gms.maps.StreetViewPanorama.OnStreetViewPanoramaCameraChangeListener", "org.xms.g.maps.StreetViewPanorama$OnStreetViewPanoramaCameraChangeListener$XImpl");
        map.put("com.google.android.gms.ads.doubleclick.AppEventListener", "org.xms.g.ads.doubleclick.AppEventListener$XImpl");
        map.put("com.google.android.gms.nearby.messages.MessageFilter", "org.xms.g.nearby.messages.MessageFilter");
        map.put("com.huawei.hms.nearby.message.MessagePicker", "org.xms.g.nearby.messages.MessageFilter");
        map.put("com.google.android.gms.games.TurnBasedMultiplayerClient", "org.xms.g.games.TurnBasedMultiplayerClient");
        map.put("com.google.android.gms.location.LocationSettingsStatusCodes", "org.xms.g.location.LocationSettingsStatusCodes");
        map.put("com.huawei.hms.location.LocationSettingsStatusCodes", "org.xms.g.location.LocationSettingsStatusCodes");
        map.put("com.google.android.gms.fitness.result.BleDevicesResult", "org.xms.g.fitness.result.BleDevicesResult");
        map.put("com.huawei.hms.hihealth.result.BleDeviceInfosResult", "org.xms.g.fitness.result.BleDevicesResult");
        map.put("com.google.firebase.ml.custom.FirebaseModelInputOutputOptions.Builder", "org.xms.f.ml.custom.FirebaseModelInputOutputOptions$Builder");
        map.put("com.google.android.gms.maps.model.TileOverlayOptions", "org.xms.g.maps.model.TileOverlayOptions");
        map.put("com.huawei.hms.maps.model.TileOverlayOptions", "org.xms.g.maps.model.TileOverlayOptions");
        map.put("com.google.android.gms.common.api.ResultCallbacks", "org.xms.g.common.api.ResultCallbacks$XImpl");
        map.put("com.huawei.hms.support.api.client.ResultCallbacks", "org.xms.g.common.api.ResultCallbacks$XImpl");
        map.put("com.google.android.gms.auth.AccountChangeEventsRequest", "org.xms.g.auth.AccountChangeEventsRequest");
        map.put("com.google.android.gms.awareness.snapshot.TimeIntervalsResponse", "org.xms.g.awareness.snapshot.TimeIntervalsResponse");
        map.put("com.huawei.hms.kit.awareness.capture.TimeCategoriesResponse", "org.xms.g.awareness.snapshot.TimeIntervalsResponse");
        map.put("com.google.android.gms.common.GoogleApiAvailability", "org.xms.g.common.ExtensionApiAvailability");
        map.put("com.huawei.hms.api.HuaweiApiAvailability", "org.xms.g.common.ExtensionApiAvailability");
        map.put("com.google.android.gms.common.api.Result", "org.xms.g.common.api.Result$XImpl");
        map.put("com.huawei.hms.support.api.client.Result", "org.xms.g.common.api.Result$XImpl");
        map.put("com.google.android.gms.fitness.request.GoalsReadRequest", "org.xms.g.fitness.request.GoalsReadRequest");
        map.put("com.google.android.gms.fitness.service.FitnessSensorServiceRequest", "org.xms.g.fitness.service.FitnessSensorServiceRequest");
        map.put("com.google.android.gms.ads.formats.UnifiedNativeAd.OnUnifiedNativeAdLoadedListener", "org.xms.g.ads.formats.UnifiedNativeAd$OnUnifiedNativeAdLoadedListener$XImpl");
        map.put("com.huawei.hms.ads.nativead.NativeAd.NativeAdLoadedListener", "org.xms.g.ads.formats.UnifiedNativeAd$OnUnifiedNativeAdLoadedListener$XImpl");
        map.put("com.google.android.gms.tasks.CancellationToken", "org.xms.g.tasks.CancellationToken$XImpl");
        map.put("com.huawei.hmf.tasks.CancellationToken", "org.xms.g.tasks.CancellationToken$XImpl");
        map.put("com.google.firebase.ml.naturallanguage.languageid.FirebaseLanguageIdentification", "org.xms.f.ml.naturallanguage.languageid.FirebaseLanguageIdentification");
        map.put("com.google.android.gms.common.api.BatchResultToken", "org.xms.g.common.api.BatchResultToken");
        map.put("com.google.android.gms.fitness.data.DataSource.Builder", "org.xms.g.fitness.data.DataSource$Builder");
        map.put("com.huawei.hms.hihealth.data.DataCollector.Builder", "org.xms.g.fitness.data.DataSource$Builder");
        map.put("com.google.android.gms.location.ActivityTransitionResult", "org.xms.g.location.ActivityTransitionResult");
        map.put("com.huawei.hms.location.ActivityConversionResponse", "org.xms.g.location.ActivityTransitionResult");
        map.put("com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener", "org.xms.g.ads.rewarded.OnAdMetadataChangedListener$XImpl");
        map.put("com.huawei.hms.ads.reward.OnMetadataChangedListener", "org.xms.g.ads.rewarded.OnAdMetadataChangedListener$XImpl");
        map.put("com.google.android.gms.auth.account.WorkAccountClient", "org.xms.g.auth.account.WorkAccountClient");
        map.put("com.google.android.gms.identity.intents.UserAddressRequest", "org.xms.g.identity.intents.UserAddressRequest");
        map.put("com.google.android.gms.vision.text.Line", "org.xms.g.vision.text.Line");
        map.put("com.huawei.hms.mlsdk.text.MLText.TextLine", "org.xms.g.vision.text.Line");
        map.put("com.google.android.gms.nearby.connection.EndpointDiscoveryCallback", "org.xms.g.nearby.connection.EndpointDiscoveryCallback$XImpl");
        map.put("com.huawei.hms.nearby.discovery.ScanEndpointCallback", "org.xms.g.nearby.connection.EndpointDiscoveryCallback$XImpl");
        map.put("com.google.android.gms.nearby.messages.MessageFilter.Builder", "org.xms.g.nearby.messages.MessageFilter$Builder");
        map.put("com.huawei.hms.nearby.message.MessagePicker.Builder", "org.xms.g.nearby.messages.MessageFilter$Builder");
        map.put("com.google.android.gms.location.LocationSettingsRequest", "org.xms.g.location.LocationSettingsRequest");
        map.put("com.huawei.hms.location.LocationSettingsRequest", "org.xms.g.location.LocationSettingsRequest");
        map.put("com.google.android.gms.maps.model.StreetViewPanoramaCamera", "org.xms.g.maps.model.StreetViewPanoramaCamera");
        map.put("com.google.android.gms.ads.MuteThisAdListener", "org.xms.g.ads.MuteThisAdListener$XImpl");
        map.put("com.huawei.hms.ads.nativead.DislikeAdListener", "org.xms.g.ads.MuteThisAdListener$XImpl");
        map.put("com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode.Phone", "org.xms.f.ml.vision.barcode.FirebaseVisionBarcode$Phone");
        map.put("com.huawei.hms.ml.scan.HmsScan.TelPhoneNumber", "org.xms.f.ml.vision.barcode.FirebaseVisionBarcode$Phone");
        map.put("com.google.android.gms.maps.GoogleMap.OnMarkerClickListener", "org.xms.g.maps.ExtensionMap$OnMarkerClickListener$XImpl");
        map.put("com.huawei.hms.maps.HuaweiMap.OnMarkerClickListener", "org.xms.g.maps.ExtensionMap$OnMarkerClickListener$XImpl");
        map.put("com.google.firebase.ml.vision.objects.FirebaseVisionObjectDetectorOptions", "org.xms.f.ml.vision.objects.FirebaseVisionObjectDetectorOptions");
        map.put("com.huawei.hms.mlsdk.objects.MLObjectAnalyzerSetting", "org.xms.f.ml.vision.objects.FirebaseVisionObjectDetectorOptions");
        map.put("com.google.android.gms.games.AchievementsClient", "org.xms.g.games.AchievementsClient");
        map.put("com.huawei.hms.jos.games.AchievementsClient", "org.xms.g.games.AchievementsClient");
        map.put("com.google.android.gms.fitness.ConfigClient", "org.xms.g.fitness.ConfigClient");
        map.put("com.huawei.hms.hihealth.SettingController", "org.xms.g.fitness.ConfigClient");
        map.put("com.google.android.gms.panorama.Panorama", "org.xms.g.panorama.Panorama");
        map.put("com.google.android.gms.wallet.GiftCardWalletObject.Builder", "org.xms.g.wallet.GiftCardWalletObject$Builder");
        map.put("com.huawei.hms.wallet.pass.PassObject.Builder", "org.xms.g.wallet.GiftCardWalletObject$Builder");
        map.put("com.google.android.gms.vision.barcode.Barcode.DriverLicense", "org.xms.g.vision.barcode.Barcode$DriverLicense");
        map.put("com.huawei.hms.ml.scan.HmsScan.DriverInfo", "org.xms.g.vision.barcode.Barcode$DriverLicense");
        map.put("com.google.android.gms.vision.FocusingProcessor", "org.xms.g.vision.FocusingProcessor$XImpl");
        map.put("com.huawei.hms.mlsdk.common.MLProminentTransactor", "org.xms.g.vision.FocusingProcessor$XImpl");
        map.put("com.google.android.gms.nearby.messages.Strategy", "org.xms.g.nearby.messages.Strategy");
        map.put("com.huawei.hms.nearby.message.Policy", "org.xms.g.nearby.messages.Strategy");
        map.put("com.google.android.gms.vision.face.LargestFaceFocusingProcessor", "org.xms.g.vision.face.LargestFaceFocusingProcessor");
        map.put("com.huawei.hms.mlsdk.face.MLMaxSizeFaceTransactor", "org.xms.g.vision.face.LargestFaceFocusingProcessor");
        map.put("com.google.android.gms.analytics.HitBuilders.TransactionBuilder", "org.xms.g.analytics.HitBuilders$TransactionBuilder");
        map.put("com.google.android.gms.fitness.SensorsApi", "org.xms.g.fitness.SensorsApi$XImpl");
        map.put("com.google.android.gms.common.AccountPicker.AccountChooserOptions", "org.xms.g.common.AccountPicker$AccountChooserOptions");
        map.put("com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener", "org.xms.g.ads.formats.OnPublisherAdViewLoadedListener$XImpl");
        map.put("com.google.firebase.ml.naturallanguage.translate.FirebaseTranslatorOptions", "org.xms.f.ml.naturallanguage.translate.FirebaseTranslatorOptions");
        map.put("com.google.android.gms.wallet.Wallet.WalletOptions.Builder", "org.xms.g.wallet.Wallet$WalletOptions$Builder");
        map.put("com.google.android.gms.identity.intents.Address", "org.xms.g.identity.intents.Address");
        map.put("com.google.android.gms.ads.appopen.AppOpenAd.AppOpenAdLoadCallback", "org.xms.g.ads.appopen.AppOpenAd$AppOpenAdLoadCallback");
        map.put("com.google.android.gms.wallet.wobs.LabelValueRow.Builder", "org.xms.g.wallet.wobs.LabelValueRow$Builder");
        map.put("com.google.android.gms.wallet.OfferWalletObject", "org.xms.g.wallet.OfferWalletObject");
        map.put("com.huawei.hms.wallet.pass.PassObject", "org.xms.g.wallet.OfferWalletObject");
        map.put("com.google.android.gms.wallet.CardInfo", "org.xms.g.wallet.CardInfo");
        map.put("com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer", "org.xms.g.games.leaderboard.LeaderboardScoreBuffer");
        map.put("com.google.android.gms.auth.api.credentials.CredentialPickerConfig", "org.xms.g.auth.api.credentials.CredentialPickerConfig");
        map.put("com.google.android.gms.location.ActivityTransition.Builder", "org.xms.g.location.ActivityTransition$Builder");
        map.put("com.huawei.hms.location.ActivityConversionInfo.Builder", "org.xms.g.location.ActivityTransition$Builder");
        map.put("com.google.android.gms.vision.barcode.Barcode.Email", "org.xms.g.vision.barcode.Barcode$Email");
        map.put("com.huawei.hms.ml.scan.HmsScan.EmailContent", "org.xms.g.vision.barcode.Barcode$Email");
        map.put("com.google.android.gms.common.api.TransformedResult", "org.xms.g.common.api.TransformedResult$XImpl");
        map.put("com.huawei.hms.support.api.client.ConvertedResult", "org.xms.g.common.api.TransformedResult$XImpl");
        map.put("com.google.android.gms.tasks.Continuation", "org.xms.g.tasks.Continuation$XImpl");
        map.put("com.huawei.hmf.tasks.Continuation", "org.xms.g.tasks.Continuation$XImpl");
        map.put("com.google.android.gms.maps.model.CustomCap", "org.xms.g.maps.model.CustomCap");
        map.put("com.huawei.hms.maps.model.CustomCap", "org.xms.g.maps.model.CustomCap");
        map.put("com.google.android.gms.awareness.fence.FenceStateMap", "org.xms.g.awareness.fence.FenceStateMap$XImpl");
        map.put("com.huawei.hms.kit.awareness.barrier.BarrierStatusMap", "org.xms.g.awareness.fence.FenceStateMap$XImpl");
        map.put("com.google.android.gms.fitness.request.SessionInsertRequest", "org.xms.g.fitness.request.SessionInsertRequest");
        map.put("com.huawei.hms.hihealth.options.ActivityRecordInsertOptions", "org.xms.g.fitness.request.SessionInsertRequest");
        map.put("com.google.android.gms.nearby.messages.MessagesOptions.Builder", "org.xms.g.nearby.messages.MessagesOptions$Builder");
        map.put("com.huawei.hms.nearby.message.MessageOption.Builder", "org.xms.g.nearby.messages.MessagesOptions$Builder");
        map.put("com.google.android.gms.analytics.HitBuilders.ExceptionBuilder", "org.xms.g.analytics.HitBuilders$ExceptionBuilder");
        map.put("com.google.android.gms.location.LocationServices", "org.xms.g.location.LocationServices");
        map.put("com.huawei.hms.location.LocationServices", "org.xms.g.location.LocationServices");
        map.put("com.google.android.gms.analytics.HitBuilders.EventBuilder", "org.xms.g.analytics.HitBuilders$EventBuilder");
        map.put("com.google.android.gms.wallet.PaymentMethodTokenizationParameters", "org.xms.g.wallet.PaymentMethodTokenizationParameters");
        map.put("com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks", "org.xms.g.common.api.ExtensionApiClient$ConnectionCallbacks$XImpl");
        map.put("com.huawei.hms.api.HuaweiApiClient.ConnectionCallbacks", "org.xms.g.common.api.ExtensionApiClient$ConnectionCallbacks$XImpl");
        map.put("com.google.android.gms.fitness.ConfigApi", "org.xms.g.fitness.ConfigApi$XImpl");
        map.put("com.google.android.gms.ads.formats.NativeAdOptions", "org.xms.g.ads.formats.NativeAdOptions");
        map.put("com.google.android.gms.maps.CameraUpdate", "org.xms.g.maps.CameraUpdate");
        map.put("com.huawei.hms.maps.CameraUpdate", "org.xms.g.maps.CameraUpdate");
        map.put("com.google.android.gms.wallet.WalletObjectsClient", "org.xms.g.wallet.WalletObjectsClient");
        map.put("com.huawei.hms.wallet.WalletPassClient", "org.xms.g.wallet.WalletObjectsClient");
        map.put("com.google.android.gms.games.multiplayer.ParticipantEntity", "org.xms.g.games.multiplayer.ParticipantEntity");
        map.put("com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch", "org.xms.g.games.multiplayer.turnbased.TurnBasedMatch$XImpl");
        map.put("com.google.android.gms.maps.model.RuntimeRemoteException", "org.xms.g.maps.model.RuntimeRemoteException");
        map.put("com.huawei.hms.maps.model.RuntimeRemoteException", "org.xms.g.maps.model.RuntimeRemoteException");
        map.put("com.google.android.gms.auth.api.credentials.CredentialRequestResult", "org.xms.g.auth.api.credentials.CredentialRequestResult$XImpl");
        map.put("com.google.android.gms.ads.AdRequest", "org.xms.g.ads.AdRequest");
        map.put("com.google.android.gms.auth.GoogleAuthUtil", "org.xms.g.auth.ExtensionAuthUtil");
        map.put("com.huawei.hms.support.hwid.tools.HuaweiIdAuthTool", "org.xms.g.auth.ExtensionAuthUtil");
        map.put("com.google.android.gms.fitness.HistoryApi", "org.xms.g.fitness.HistoryApi$XImpl");
        map.put("com.google.android.gms.maps.model.JointType", "org.xms.g.maps.model.JointType");
        map.put("com.huawei.hms.maps.model.JointType", "org.xms.g.maps.model.JointType");
        map.put("com.google.android.gms.ads.formats.AdChoicesView", "org.xms.g.ads.formats.AdChoicesView");
        map.put("com.huawei.hms.ads.ChoicesView", "org.xms.g.ads.formats.AdChoicesView");
        map.put("com.google.android.gms.nearby.connection.Connections.MessageListener", "org.xms.g.nearby.connection.Connections$MessageListener$XImpl");
        map.put("com.google.android.gms.ads.formats.NativeContentAdView", "org.xms.g.ads.formats.NativeContentAdView");
        map.put("com.huawei.hms.ads.nativead.NativeView", "org.xms.g.ads.formats.NativeContentAdView");
        map.put("com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener", "org.xms.g.games.multiplayer.realtime.RoomUpdateListener$XImpl");
        map.put("com.google.android.gms.identity.intents.UserAddressRequest.Builder", "org.xms.g.identity.intents.UserAddressRequest$Builder");
        map.put("com.google.android.gms.analytics.HitBuilders", "org.xms.g.analytics.HitBuilders");
        map.put("com.google.android.gms.vision.text.Element", "org.xms.g.vision.text.Element");
        map.put("com.huawei.hms.mlsdk.text.MLText.Word", "org.xms.g.vision.text.Element");
        map.put("com.google.firebase.ml.vision.text.FirebaseVisionText", "org.xms.f.ml.vision.text.FirebaseVisionText");
        map.put("com.huawei.hms.mlsdk.text.MLText", "org.xms.f.ml.vision.text.FirebaseVisionText");
        map.put("com.google.android.gms.awareness.fence.FenceQueryRequest", "org.xms.g.awareness.fence.FenceQueryRequest$XImpl");
        map.put("com.huawei.hms.kit.awareness.barrier.BarrierQueryRequest", "org.xms.g.awareness.fence.FenceQueryRequest$XImpl");
        map.put("com.google.android.gms.games.PlayerStatsClient", "org.xms.g.games.PlayerStatsClient");
        map.put("com.google.android.gms.maps.model.Marker", "org.xms.g.maps.model.Marker");
        map.put("com.huawei.hms.maps.model.Marker", "org.xms.g.maps.model.Marker");
        map.put("com.google.android.gms.games.multiplayer.ParticipantUtils", "org.xms.g.games.multiplayer.ParticipantUtils");
        map.put("com.google.android.gms.security.ProviderInstaller.ProviderInstallListener", "org.xms.g.security.ProviderInstaller$ProviderInstallListener$XImpl");
        map.put("com.huawei.hms.security.SecComponentInstallWizard.SecComponentInstallWizardListener", "org.xms.g.security.ProviderInstaller$ProviderInstallListener$XImpl");
        map.put("com.google.android.gms.maps.model.Polyline", "org.xms.g.maps.model.Polyline");
        map.put("com.huawei.hms.maps.model.Polyline", "org.xms.g.maps.model.Polyline");
        map.put("com.google.android.gms.fitness.data.Goal.MismatchedGoalException", "org.xms.g.fitness.data.Goal$MismatchedGoalException");
        map.put("com.google.android.gms.location.ActivityRecognitionResult", "org.xms.g.location.ActivityRecognitionResult");
        map.put("com.huawei.hms.location.ActivityIdentificationResponse", "org.xms.g.location.ActivityRecognitionResult");
        map.put("com.google.android.gms.maps.model.Circle", "org.xms.g.maps.model.Circle");
        map.put("com.huawei.hms.maps.model.Circle", "org.xms.g.maps.model.Circle");
        map.put("com.google.firebase.ml.vision.document.FirebaseVisionDocumentText.Symbol", "org.xms.f.ml.vision.document.FirebaseVisionDocumentText$Symbol");
        map.put("com.huawei.hms.mlsdk.document.MLDocument.Character", "org.xms.f.ml.vision.document.FirebaseVisionDocumentText$Symbol");
        map.put("com.google.android.gms.common.api.GoogleApi", "org.xms.g.common.api.ExtensionApi$XImpl");
        map.put("com.google.firebase.ml.naturallanguage.smartreply.SmartReplySuggestion", "org.xms.f.ml.naturallanguage.smartreply.SmartReplySuggestion");
        map.put("com.google.android.gms.analytics.StandardExceptionParser", "org.xms.g.analytics.StandardExceptionParser");
        map.put("com.google.android.gms.fitness.data.BleDevice", "org.xms.g.fitness.data.BleDevice");
        map.put("com.huawei.hms.hihealth.data.BleDeviceInfo", "org.xms.g.fitness.data.BleDevice");
        map.put("com.google.android.gms.location.DetectedActivity", "org.xms.g.location.DetectedActivity");
        map.put("com.huawei.hms.location.ActivityIdentificationData", "org.xms.g.location.DetectedActivity");
        map.put("com.google.android.gms.common.UserRecoverableException", "org.xms.g.common.UserRecoverableException");
        map.put("com.huawei.hms.api.UserRecoverableException", "org.xms.g.common.UserRecoverableException");
        map.put("com.google.android.gms.nearby.messages.Message", "org.xms.g.nearby.messages.Message");
        map.put("com.huawei.hms.nearby.message.Message", "org.xms.g.nearby.messages.Message");
        map.put("com.google.firebase.ml.vision.common.FirebaseVisionImageMetadata.Builder", "org.xms.f.ml.vision.common.FirebaseVisionImageMetadata$Builder");
        map.put("com.huawei.hms.mlsdk.common.MLFrame.Property.Creator", "org.xms.f.ml.vision.common.FirebaseVisionImageMetadata$Builder");
        map.put("com.google.android.gms.fitness.data.Field", "org.xms.g.fitness.data.Field");
        map.put("com.huawei.hms.hihealth.data.Field", "org.xms.g.fitness.data.Field");
        map.put("com.google.android.gms.maps.StreetViewPanoramaOptions", "org.xms.g.maps.StreetViewPanoramaOptions");
        map.put("com.google.firebase.ml.vision.document.FirebaseVisionDocumentText.Paragraph", "org.xms.f.ml.vision.document.FirebaseVisionDocumentText$Paragraph");
        map.put("com.huawei.hms.mlsdk.document.MLDocument.Section", "org.xms.f.ml.vision.document.FirebaseVisionDocumentText$Paragraph");
        map.put("com.google.android.gms.tasks.OnSuccessListener", "org.xms.g.tasks.OnSuccessListener$XImpl");
        map.put("com.huawei.hmf.tasks.OnSuccessListener", "org.xms.g.tasks.OnSuccessListener$XImpl");
        map.put("com.google.android.gms.common.api.Api", "org.xms.g.common.api.Api");
        map.put("com.huawei.hms.api.Api", "org.xms.g.common.api.Api");
        map.put("com.google.android.gms.vision.MultiDetector.Builder", "org.xms.g.vision.MultiDetector$Builder");
        map.put("com.huawei.hms.mlsdk.common.MLCompositeAnalyzer.Creator", "org.xms.g.vision.MultiDetector$Builder");
        map.put("com.google.android.gms.ads.appopen.AppOpenAdView", "org.xms.g.ads.appopen.AppOpenAdView");
        map.put("com.google.firebase.ml.vision.objects.FirebaseVisionObjectDetectorOptions.Builder", "org.xms.f.ml.vision.objects.FirebaseVisionObjectDetectorOptions$Builder");
        map.put("com.huawei.hms.mlsdk.objects.MLObjectAnalyzerSetting.Factory", "org.xms.f.ml.vision.objects.FirebaseVisionObjectDetectorOptions$Builder");
        map.put("com.google.android.gms.ads.mediation.customevent.CustomEventNative", "org.xms.g.ads.mediation.customevent.CustomEventNative$XImpl");
        map.put("com.google.android.gms.games.multiplayer.realtime.RealTimeMessage", "org.xms.g.games.multiplayer.realtime.RealTimeMessage");
        map.put("com.google.android.gms.location.LocationSettingsRequest.Builder", "org.xms.g.location.LocationSettingsRequest$Builder");
        map.put("com.huawei.hms.location.LocationSettingsRequest.Builder", "org.xms.g.location.LocationSettingsRequest$Builder");
        map.put("com.google.android.gms.games.multiplayer.OnInvitationReceivedListener", "org.xms.g.games.multiplayer.OnInvitationReceivedListener$XImpl");
        map.put("com.google.android.gms.maps.MapView", "org.xms.g.maps.MapView");
        map.put("com.huawei.hms.maps.MapView", "org.xms.g.maps.MapView");
        map.put("com.google.android.gms.games.SnapshotsClient", "org.xms.g.games.SnapshotsClient");
        map.put("com.huawei.hms.jos.games.ArchivesClient", "org.xms.g.games.SnapshotsClient");
        map.put("com.google.android.gms.fitness.RecordingClient", "org.xms.g.fitness.RecordingClient");
        map.put("com.huawei.hms.hihealth.AutoRecorderController", "org.xms.g.fitness.RecordingClient");
        map.put("com.google.android.gms.location.LocationSettingsResponse", "org.xms.g.location.LocationSettingsResponse");
        map.put("com.huawei.hms.location.LocationSettingsResponse", "org.xms.g.location.LocationSettingsResponse");
        map.put("com.google.android.gms.fitness.SessionsClient", "org.xms.g.fitness.SessionsClient");
        map.put("com.huawei.hms.hihealth.ActivityRecordsController", "org.xms.g.fitness.SessionsClient");
        map.put("com.google.android.gms.ads.mediation.MediationRewardedAdCallback", "org.xms.g.ads.mediation.MediationRewardedAdCallback$XImpl");
        map.put("com.google.android.gms.vision.barcode.Barcode.Phone", "org.xms.g.vision.barcode.Barcode$Phone");
        map.put("com.huawei.hms.ml.scan.HmsScan.TelPhoneNumber", "org.xms.g.vision.barcode.Barcode$Phone");
        map.put("com.google.android.gms.maps.GoogleMap.OnCircleClickListener", "org.xms.g.maps.ExtensionMap$OnCircleClickListener$XImpl");
        map.put("com.huawei.hms.maps.HuaweiMap.OnCircleClickListener", "org.xms.g.maps.ExtensionMap$OnCircleClickListener$XImpl");
        map.put("com.google.android.gms.nearby.messages.PublishCallback", "org.xms.g.nearby.messages.PublishCallback");
        map.put("com.huawei.hms.nearby.message.PutCallback", "org.xms.g.nearby.messages.PublishCallback");
        map.put("com.google.android.gms.auth.api.phone.SmsRetriever", "org.xms.g.auth.api.phone.SmsRetriever");
        map.put("com.huawei.hms.support.sms.common.ReadSmsConstant", "org.xms.g.auth.api.phone.SmsRetriever");
        map.put("com.google.android.gms.auth.GooglePlayServicesAvailabilityException", "org.xms.g.auth.ExtensionPlayServicesAvailabilityException");
        map.put("com.google.android.gms.games.leaderboard.LeaderboardBuffer", "org.xms.g.games.leaderboard.LeaderboardBuffer");
        map.put("com.google.android.gms.maps.GoogleMap.OnInfoWindowLongClickListener", "org.xms.g.maps.ExtensionMap$OnInfoWindowLongClickListener$XImpl");
        map.put("com.huawei.hms.maps.HuaweiMap.OnInfoWindowLongClickListener", "org.xms.g.maps.ExtensionMap$OnInfoWindowLongClickListener$XImpl");
        map.put("com.google.android.gms.wallet.wobs.WalletObjectsConstants", "org.xms.g.wallet.wobs.WalletObjectsConstants$XImpl");
        map.put("com.google.android.gms.fitness.result.GoalsResult", "org.xms.g.fitness.result.GoalsResult");
        map.put("com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener", "org.xms.g.ads.mediation.OnImmersiveModeUpdatedListener$XImpl");
        map.put("com.google.android.gms.ads.RequestConfiguration.Builder", "org.xms.g.ads.RequestConfiguration$Builder");
        map.put("com.huawei.hms.ads.RequestOptions.Builder", "org.xms.g.ads.RequestConfiguration$Builder");
        map.put("com.google.android.gms.awareness.snapshot.LocationResult", "org.xms.g.awareness.snapshot.LocationResult$XImpl");
        map.put("com.google.android.gms.location.Geofence.Builder", "org.xms.g.location.Geofence$Builder");
        map.put("com.huawei.hms.location.Geofence.Builder", "org.xms.g.location.Geofence$Builder");
        map.put("com.google.android.gms.maps.model.VisibleRegion", "org.xms.g.maps.model.VisibleRegion");
        map.put("com.huawei.hms.maps.model.VisibleRegion", "org.xms.g.maps.model.VisibleRegion");
        map.put("com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode.DriverLicense", "org.xms.f.ml.vision.barcode.FirebaseVisionBarcode$DriverLicense");
        map.put("com.huawei.hms.ml.scan.HmsScan.DriverInfo", "org.xms.f.ml.vision.barcode.FirebaseVisionBarcode$DriverLicense");
        map.put("com.google.android.gms.common.api.Api.ApiOptions.NotRequiredOptions", "org.xms.g.common.api.Api$ApiOptions$NotRequiredOptions$XImpl");
        map.put("com.huawei.hms.api.Api.ApiOptions.NotRequiredOptions", "org.xms.g.common.api.Api$ApiOptions$NotRequiredOptions$XImpl");
        map.put("com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult", "org.xms.g.games.multiplayer.turnbased.TurnBasedMultiplayer$LoadMatchesResult$XImpl");
        map.put("com.google.android.gms.iid.InstanceIDListenerService", "org.xms.g.iid.InstanceIDListenerService");
        map.put("com.google.android.gms.wallet.wobs.TextModuleData", "org.xms.g.wallet.wobs.TextModuleData");
        map.put("com.google.android.gms.wallet.LoyaltyWalletObject", "org.xms.g.wallet.LoyaltyWalletObject");
        map.put("com.huawei.hms.wallet.pass.PassObject", "org.xms.g.wallet.LoyaltyWalletObject");
        map.put("com.google.android.gms.wallet.wobs.WalletObjects", "org.xms.g.wallet.wobs.WalletObjects$XImpl");
        map.put("com.google.android.gms.auth.api.Auth", "org.xms.g.auth.api.Auth");
        map.put("com.huawei.hms.support.hwid.HuaweiIdAuthAPIManager", "org.xms.g.auth.api.Auth");
        map.put("com.google.android.gms.auth.api.credentials.CredentialsOptions.Builder", "org.xms.g.auth.api.credentials.CredentialsOptions$Builder");
        map.put("com.google.android.gms.ads.identifier.AdvertisingIdClient", "org.xms.g.ads.identifier.AdvertisingIdClient");
        map.put("com.huawei.hms.ads.identifier.AdvertisingIdClient", "org.xms.g.ads.identifier.AdvertisingIdClient");
        map.put("com.google.android.gms.measurement.AppMeasurementInstallReferrerReceiver", "org.xms.g.measurement.AppMeasurementInstallReferrerReceiver");
        map.put("com.huawei.hms.analytics.HiAnalyticsInstallReceiver", "org.xms.g.measurement.AppMeasurementInstallReferrerReceiver");
        map.put("com.google.android.gms.fitness.data.Goal", "org.xms.g.fitness.data.Goal");
        map.put("com.google.android.gms.nearby.connection.Payload.Stream", "org.xms.g.nearby.connection.Payload$Stream");
        map.put("com.huawei.hms.nearby.transfer.Data.Stream", "org.xms.g.nearby.connection.Payload$Stream");
        map.put("com.google.android.gms.analytics.CampaignTrackingReceiver", "org.xms.g.analytics.CampaignTrackingReceiver");
        map.put("com.google.android.gms.maps.GoogleMap.OnCameraMoveCanceledListener", "org.xms.g.maps.ExtensionMap$OnCameraMoveCanceledListener$XImpl");
        map.put("com.huawei.hms.maps.HuaweiMap.OnCameraMoveCanceledListener", "org.xms.g.maps.ExtensionMap$OnCameraMoveCanceledListener$XImpl");
        map.put("com.google.android.gms.fitness.data.DataSet", "org.xms.g.fitness.data.DataSet");
        map.put("com.huawei.hms.hihealth.data.SampleSet", "org.xms.g.fitness.data.DataSet");
        map.put("com.google.android.gms.ads.reward.AdMetadataListener", "org.xms.g.ads.reward.AdMetadataListener");
        map.put("com.huawei.hms.ads.reward.OnMetadataChangedListener", "org.xms.g.ads.reward.AdMetadataListener");
        map.put("com.google.android.gms.common.api.Releasable", "org.xms.g.common.api.Releasable$XImpl");
        map.put("com.huawei.hms.common.api.Releasable", "org.xms.g.common.api.Releasable$XImpl");
        map.put("com.google.android.gms.vision.CameraSource", "org.xms.g.vision.CameraSource");
        map.put("com.huawei.hms.mlsdk.common.LensEngine", "org.xms.g.vision.CameraSource");
        map.put("com.google.android.gms.auth.api.credentials.CredentialRequestResponse", "org.xms.g.auth.api.credentials.CredentialRequestResponse");
        map.put("com.google.android.gms.vision.text.TextRecognizer.Builder", "org.xms.g.vision.text.TextRecognizer$Builder");
        map.put("com.huawei.hms.mlsdk.text.MLTextAnalyzer.Factory", "org.xms.g.vision.text.TextRecognizer$Builder");
        map.put("com.google.android.gms.location.LocationStatusCodes", "org.xms.g.location.LocationStatusCodes");
        map.put("com.google.android.gms.ads.mediation.MediationNativeListener", "org.xms.g.ads.mediation.MediationNativeListener$XImpl");
        map.put("com.google.android.gms.ads.mediation.MediationInterstitialAd", "org.xms.g.ads.mediation.MediationInterstitialAd$XImpl");
        map.put("com.google.android.gms.fitness.result.DataTypeResult", "org.xms.g.fitness.result.DataTypeResult");
        map.put("com.huawei.hms.hihealth.result.DataTypeResult", "org.xms.g.fitness.result.DataTypeResult");
        map.put("com.google.android.gms.games.snapshot.SnapshotContents", "org.xms.g.games.snapshot.SnapshotContents$XImpl");
        map.put("com.huawei.hms.jos.games.archive.ArchiveDetails", "org.xms.g.games.snapshot.SnapshotContents$XImpl");
        map.put("com.google.android.gms.awareness.snapshot.BeaconStateResult", "org.xms.g.awareness.snapshot.BeaconStateResult$XImpl");
        map.put("com.google.android.gms.games.RealTimeMultiplayerClient", "org.xms.g.games.RealTimeMultiplayerClient");
        map.put("com.google.android.gms.location.GeofenceStatusCodes", "org.xms.g.location.GeofenceStatusCodes");
        map.put("com.huawei.hms.location.GeofenceErrorCodes", "org.xms.g.location.GeofenceStatusCodes");
        map.put("com.google.android.gms.games.VideosClient", "org.xms.g.games.VideosClient");
        map.put("com.google.android.gms.wallet.WalletConstants.CardNetwork", "org.xms.g.wallet.WalletConstants$CardNetwork$XImpl");
        map.put("com.google.android.gms.fitness.data.Device", "org.xms.g.fitness.data.Device");
        map.put("com.huawei.hms.hihealth.data.DeviceInfo", "org.xms.g.fitness.data.Device");
        map.put("com.google.android.gms.location.FusedLocationProviderApi", "org.xms.g.location.FusedLocationProviderApi$XImpl");
        map.put("com.google.android.gms.maps.model.CameraPosition.Builder", "org.xms.g.maps.model.CameraPosition$Builder");
        map.put("com.huawei.hms.maps.model.CameraPosition.Builder", "org.xms.g.maps.model.CameraPosition$Builder");
        map.put("com.google.android.gms.auth.api.signin.GoogleSignInOptions", "org.xms.g.auth.api.signin.ExtensionSignInOptions");
        map.put("com.huawei.hms.support.hwid.request.HuaweiIdAuthParams", "org.xms.g.auth.api.signin.ExtensionSignInOptions");
        map.put("com.google.android.gms.measurement.AppMeasurementReceiver", "org.xms.g.measurement.AppMeasurementReceiver");
        map.put("com.huawei.hms.analytics.HiAnalyticsReceiver", "org.xms.g.measurement.AppMeasurementReceiver");
        map.put("com.google.android.gms.maps.model.BitmapDescriptorFactory", "org.xms.g.maps.model.BitmapDescriptorFactory");
        map.put("com.huawei.hms.maps.model.BitmapDescriptorFactory", "org.xms.g.maps.model.BitmapDescriptorFactory");
        map.put("com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions", "org.xms.g.common.api.Api$ApiOptions$HasExtensionSignInAccountOptions$XImpl");
        map.put("com.huawei.hms.support.api.hwid.HuaweiAccountOptions.HasAuthHuaweiIdOptions", "org.xms.g.common.api.Api$ApiOptions$HasExtensionSignInAccountOptions$XImpl");
        map.put("com.google.android.gms.vision.barcode.Barcode.CalendarEvent", "org.xms.g.vision.barcode.Barcode$CalendarEvent");
        map.put("com.huawei.hms.ml.scan.HmsScan.EventInfo", "org.xms.g.vision.barcode.Barcode$CalendarEvent");
        map.put("com.google.android.gms.common.api.ResultCallback", "org.xms.g.common.api.ResultCallback$XImpl");
        map.put("com.huawei.hms.support.api.client.ResultCallback", "org.xms.g.common.api.ResultCallback$XImpl");
        map.put("com.google.android.gms.wallet.ShippingAddressRequirements", "org.xms.g.wallet.ShippingAddressRequirements");
        map.put("com.google.android.gms.analytics.CampaignTrackingService", "org.xms.g.analytics.CampaignTrackingService");
        map.put("com.google.android.gms.common.SignInButton", "org.xms.g.common.SignInButton");
        map.put("com.google.android.gms.ads.mediation.MediationAdapter", "org.xms.g.ads.mediation.MediationAdapter$XImpl");
        map.put("com.google.android.gms.awareness.snapshot.PlacesResponse", "org.xms.g.awareness.snapshot.PlacesResponse");
        map.put("com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult", "org.xms.g.games.multiplayer.Invitations$LoadInvitationsResult$XImpl");
        map.put("com.google.android.gms.location.ActivityRecognition", "org.xms.g.location.ActivityRecognition");
        map.put("com.huawei.hms.location.ActivityIdentification", "org.xms.g.location.ActivityRecognition");
        map.put("com.google.android.gms.maps.model.UrlTileProvider", "org.xms.g.maps.model.UrlTileProvider$XImpl");
        map.put("com.huawei.hms.maps.model.UrlTileProvider", "org.xms.g.maps.model.UrlTileProvider$XImpl");
        map.put("com.google.android.gms.common.api.PendingResults", "org.xms.g.common.api.PendingResults");
        map.put("com.huawei.hms.support.api.client.PendingResultsCreator", "org.xms.g.common.api.PendingResults");
        map.put("com.google.android.gms.games.Games.GamesOptions", "org.xms.g.games.Games$GamesOptions");
        map.put("com.huawei.hms.jos.games.GameOptions", "org.xms.g.games.Games$GamesOptions");
        map.put("com.google.android.gms.ads.mediation.customevent.CustomEventInterstitial", "org.xms.g.ads.mediation.customevent.CustomEventInterstitial$XImpl");
        map.put("com.google.android.gms.games.video.VideoConfiguration", "org.xms.g.games.video.VideoConfiguration");
        map.put("com.google.android.gms.wallet.Wallet.WalletOptions", "org.xms.g.wallet.Wallet$WalletOptions");
        map.put("com.google.android.gms.awareness.fence.TimeFence", "org.xms.g.awareness.fence.TimeFence");
        map.put("com.huawei.hms.kit.awareness.barrier.TimeBarrier", "org.xms.g.awareness.fence.TimeFence");
        map.put("com.google.android.gms.safetynet.SafetyNetApi.SafeBrowsingResponse", "org.xms.g.safetynet.SafetyNetApi$SafeBrowsingResponse");
        map.put("com.huawei.hms.support.api.entity.safetydetect.UrlCheckResponse", "org.xms.g.safetynet.SafetyNetApi$SafeBrowsingResponse");
        map.put("com.google.android.gms.ads.mediation.MediationInterstitialListener", "org.xms.g.ads.mediation.MediationInterstitialListener$XImpl");
        map.put("com.google.android.gms.wallet.OfferWalletObject.Builder", "org.xms.g.wallet.OfferWalletObject$Builder");
        map.put("com.huawei.hms.wallet.pass.PassObject.Builder", "org.xms.g.wallet.OfferWalletObject$Builder");
        map.put("com.google.firebase.iid.InstanceIdResult", "org.xms.f.iid.InstanceIdResult$XImpl");
        map.put("com.huawei.hms.aaid.entity.AAIDResult", "org.xms.f.iid.InstanceIdResult$XImpl");
        map.put("com.android.installreferrer.api.InstallReferrerClient.Builder", "org.xms.installreferrer.api.InstallReferrerClient$Builder");
        map.put("com.huawei.hms.ads.installreferrer.api.InstallReferrerClient.Builder", "org.xms.installreferrer.api.InstallReferrerClient$Builder");
        map.put("com.google.android.gms.ads.mediation.MediationConfiguration", "org.xms.g.ads.mediation.MediationConfiguration");
        map.put("com.google.android.gms.games.PlayerEntity", "org.xms.g.games.PlayerEntity");
        map.put("com.huawei.hms.jos.games.player.Player", "org.xms.g.games.PlayerEntity");
        map.put("com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener", "org.xms.g.maps.ExtensionMap$OnMyLocationButtonClickListener$XImpl");
        map.put("com.huawei.hms.maps.HuaweiMap.OnMyLocationButtonClickListener", "org.xms.g.maps.ExtensionMap$OnMyLocationButtonClickListener$XImpl");
        map.put("com.google.android.gms.location.LocationListener", "org.xms.g.location.LocationListener$XImpl");
        map.put("com.google.firebase.ml.vision.label.FirebaseVisionOnDeviceAutoMLImageLabelerOptions", "org.xms.f.ml.vision.label.FirebaseVisionOnDeviceAutoMLImageLabelerOptions");
        map.put("com.google.firebase.ml.vision.text.FirebaseVisionCloudTextRecognizerOptions", "org.xms.f.ml.vision.text.FirebaseVisionCloudTextRecognizerOptions");
        map.put("com.huawei.hms.mlsdk.text.MLRemoteTextSetting", "org.xms.f.ml.vision.text.FirebaseVisionCloudTextRecognizerOptions");
        map.put("com.google.android.gms.nearby.connection.ConnectionInfo", "org.xms.g.nearby.connection.ConnectionInfo");
        map.put("com.huawei.hms.nearby.discovery.ConnectInfo", "org.xms.g.nearby.connection.ConnectionInfo");
        map.put("com.google.android.gms.nearby.connection.Payload.File", "org.xms.g.nearby.connection.Payload$File");
        map.put("com.huawei.hms.nearby.transfer.Data.File", "org.xms.g.nearby.connection.Payload$File");
        map.put("com.google.android.gms.identity.intents.model.CountrySpecification", "org.xms.g.identity.intents.model.CountrySpecification");
        map.put("com.google.android.gms.auth.api.signin.GoogleSignInAccount", "org.xms.g.auth.api.signin.ExtensionSignInAccount");
        map.put("com.huawei.hms.support.hwid.result.AuthHuaweiId", "org.xms.g.auth.api.signin.ExtensionSignInAccount");
        map.put("com.google.android.gms.fitness.SessionsApi", "org.xms.g.fitness.SessionsApi$XImpl");
        map.put("com.google.android.gms.wallet.PaymentInstrumentType", "org.xms.g.wallet.PaymentInstrumentType");
        map.put("com.google.android.gms.ads.formats.UnifiedNativeAd", "org.xms.g.ads.formats.UnifiedNativeAd$XImpl");
        map.put("com.huawei.hms.ads.nativead.NativeAd", "org.xms.g.ads.formats.UnifiedNativeAd$XImpl");
        map.put("com.google.android.gms.common.api.Status", "org.xms.g.common.api.Status");
        map.put("com.huawei.hms.support.api.client.Status", "org.xms.g.common.api.Status");
        map.put("com.google.firebase.ml.custom.FirebaseModelInputs.Builder", "org.xms.f.ml.custom.FirebaseModelInputs$Builder");
        map.put("com.google.android.gms.awareness.fence.AwarenessFence", "org.xms.g.awareness.fence.AwarenessFence$XImpl");
        map.put("com.huawei.hms.kit.awareness.barrier.AwarenessBarrier", "org.xms.g.awareness.fence.AwarenessFence$XImpl");
        map.put("com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration", "org.xms.g.ads.mediation.MediationRewardedAdConfiguration");
        map.put("com.google.android.gms.games.GameBuffer", "org.xms.g.games.GameBuffer");
        map.put("com.google.android.gms.fitness.request.SensorRequest", "org.xms.g.fitness.request.SensorRequest");
        map.put("com.huawei.hms.hihealth.options.SensorOptions", "org.xms.g.fitness.request.SensorRequest");
        map.put("com.google.android.gms.ads.reward.mediation.InitializableMediationRewardedVideoAdAdapter", "org.xms.g.ads.reward.mediation.InitializableMediationRewardedVideoAdAdapter$XImpl");
        map.put("com.google.android.gms.maps.GoogleMap.InfoWindowAdapter", "org.xms.g.maps.ExtensionMap$InfoWindowAdapter$XImpl");
        map.put("com.huawei.hms.maps.HuaweiMap.InfoWindowAdapter", "org.xms.g.maps.ExtensionMap$InfoWindowAdapter$XImpl");
        map.put("com.google.android.gms.common.api.AvailabilityException", "org.xms.g.common.api.AvailabilityException");
        map.put("com.huawei.hms.common.api.AvailabilityException", "org.xms.g.common.api.AvailabilityException");
        map.put("com.google.android.gms.auth.GoogleAuthException", "org.xms.g.auth.ExtensionAuthException");
        map.put("com.huawei.hms.support.hwid.common.HuaweiIdAuthException", "org.xms.g.auth.ExtensionAuthException");
        map.put("com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode.UrlBookmark", "org.xms.f.ml.vision.barcode.FirebaseVisionBarcode$UrlBookmark");
        map.put("com.huawei.hms.ml.scan.HmsScan.LinkUrl", "org.xms.f.ml.vision.barcode.FirebaseVisionBarcode$UrlBookmark");
        map.put("com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode.Address", "org.xms.f.ml.vision.barcode.FirebaseVisionBarcode$Address");
        map.put("com.huawei.hms.ml.scan.HmsScan.AddressInfo", "org.xms.f.ml.vision.barcode.FirebaseVisionBarcode$Address");
        map.put("com.google.android.gms.common.AccountPicker.AccountChooserOptions.Builder", "org.xms.g.common.AccountPicker$AccountChooserOptions$Builder");
        map.put("com.google.android.gms.auth.api.signin.GoogleSignIn", "org.xms.g.auth.api.signin.ExtensionSignIn");
        map.put("com.huawei.hms.support.hwid.HuaweiIdAuthManager", "org.xms.g.auth.api.signin.ExtensionSignIn");
        map.put("com.google.android.gms.awareness.fence.FenceQueryResult", "org.xms.g.awareness.fence.FenceQueryResult$XImpl");
        map.put("com.google.android.gms.auth.api.signin.RevocationBoundService", "org.xms.g.auth.api.signin.RevocationBoundService");
        map.put("com.google.firebase.ml.vision.cloud.landmark.FirebaseVisionCloudLandmarkDetector", "org.xms.f.ml.vision.cloud.landmark.FirebaseVisionCloudLandmarkDetector");
        map.put("com.huawei.hms.mlsdk.landmark.MLRemoteLandmarkAnalyzer", "org.xms.f.ml.vision.cloud.landmark.FirebaseVisionCloudLandmarkDetector");
        map.put("com.google.android.gms.auth.api.credentials.CredentialRequest", "org.xms.g.auth.api.credentials.CredentialRequest");
        map.put("com.google.android.gms.fitness.result.SessionStopResult", "org.xms.g.fitness.result.SessionStopResult");
        map.put("com.huawei.hms.hihealth.result.ActivityRecordStopResult", "org.xms.g.fitness.result.SessionStopResult");
        map.put("com.google.android.gms.wallet.Wallet", "org.xms.g.wallet.Wallet");
        map.put("com.huawei.hms.wallet.Wallet", "org.xms.g.wallet.Wallet");
        map.put("com.google.android.gms.games.event.Events.LoadEventsResult", "org.xms.g.games.event.Events$LoadEventsResult$XImpl");
        map.put("com.google.firebase.ml.vision.common.FirebaseVisionLatLng", "org.xms.f.ml.vision.common.FirebaseVisionLatLng");
        map.put("com.huawei.hms.mlsdk.common.MLCoordinate", "org.xms.f.ml.vision.common.FirebaseVisionLatLng");
        map.put("com.google.android.gms.vision.face.Face", "org.xms.g.vision.face.Face");
        map.put("com.huawei.hms.mlsdk.face.MLFace", "org.xms.g.vision.face.Face");
        map.put("com.google.android.gms.nearby.connection.ConnectionsClient", "org.xms.g.nearby.connection.ConnectionsClient$XImpl");
        map.put("com.google.android.gms.awareness.snapshot.DetectedActivityResponse", "org.xms.g.awareness.snapshot.DetectedActivityResponse");
        map.put("com.google.android.gms.awareness.snapshot.WeatherResult", "org.xms.g.awareness.snapshot.WeatherResult$XImpl");
        map.put("com.google.android.gms.games.snapshot.SnapshotMetadataEntity", "org.xms.g.games.snapshot.SnapshotMetadataEntity");
        map.put("com.huawei.hms.jos.games.archive.ArchiveSummary", "org.xms.g.games.snapshot.SnapshotMetadataEntity");
        map.put("com.google.android.gms.wallet.wobs.WalletObjectsConstants.State", "org.xms.g.wallet.wobs.WalletObjectsConstants$State$XImpl");
        map.put("com.google.android.gms.common.api.Response", "org.xms.g.common.api.Response");
        map.put("com.huawei.hms.common.api.Response", "org.xms.g.common.api.Response");
        map.put("com.google.android.gms.ads.mediation.NativeAdMapper", "org.xms.g.ads.mediation.NativeAdMapper");
        map.put("com.google.android.gms.fitness.request.DataTypeCreateRequest", "org.xms.g.fitness.request.DataTypeCreateRequest");
        map.put("com.huawei.hms.hihealth.options.DataTypeAddOptions", "org.xms.g.fitness.request.DataTypeCreateRequest");
        map.put("com.google.android.gms.wallet.TransactionInfo", "org.xms.g.wallet.TransactionInfo");
        map.put("com.google.android.gms.vision.Detector.Detections", "org.xms.g.vision.Detector$Detections");
        map.put("com.huawei.hms.mlsdk.common.MLAnalyzer.Result", "org.xms.g.vision.Detector$Detections");
        map.put("com.google.android.gms.fitness.request.DataUpdateRequest", "org.xms.g.fitness.request.DataUpdateRequest");
        map.put("com.huawei.hms.hihealth.options.UpdateOptions", "org.xms.g.fitness.request.DataUpdateRequest");
        map.put("com.google.android.gms.fitness.result.DataReadResponse", "org.xms.g.fitness.result.DataReadResponse");
        map.put("com.huawei.hms.hihealth.result.ReadReply", "org.xms.g.fitness.result.DataReadResponse");
        map.put("com.google.android.gms.wallet.CreateWalletObjectsRequest", "org.xms.g.wallet.CreateWalletObjectsRequest");
        map.put("com.huawei.hms.wallet.CreateWalletPassRequest", "org.xms.g.wallet.CreateWalletObjectsRequest");
        map.put("com.google.android.gms.ads.mediation.MediationExtrasReceiver", "org.xms.g.ads.mediation.MediationExtrasReceiver$XImpl");
        map.put("com.google.android.gms.analytics.ecommerce.Product", "org.xms.g.analytics.ecommerce.Product");
        map.put("com.google.android.gms.maps.model.MarkerOptions", "org.xms.g.maps.model.MarkerOptions");
        map.put("com.huawei.hms.maps.model.MarkerOptions", "org.xms.g.maps.model.MarkerOptions");
        map.put("com.google.android.gms.ads.doubleclick.PublisherAdRequest.Builder", "org.xms.g.ads.doubleclick.PublisherAdRequest$Builder");
        map.put("com.google.android.gms.iid.InstanceID", "org.xms.g.iid.InstanceID");
        map.put("com.google.firebase.ml.common.modeldownload.FirebaseModelDownloadConditions.Builder", "org.xms.f.ml.common.modeldownload.FirebaseModelDownloadConditions$Builder");
        map.put("com.google.android.gms.awareness.fence.HeadphoneFence", "org.xms.g.awareness.fence.HeadphoneFence");
        map.put("com.huawei.hms.kit.awareness.barrier.HeadsetBarrier", "org.xms.g.awareness.fence.HeadphoneFence");
        map.put("com.google.android.gms.games.video.Videos", "org.xms.g.games.video.Videos$XImpl");
        map.put("com.google.android.gms.ads.mediation.customevent.CustomEventListener", "org.xms.g.ads.mediation.customevent.CustomEventListener$XImpl");
        map.put("com.google.android.gms.fitness.Fitness", "org.xms.g.fitness.Fitness");
        map.put("com.huawei.hms.hihealth.HuaweiHiHealth", "org.xms.g.fitness.Fitness");
        map.put("com.google.android.gms.fitness.request.DataUpdateListenerRegistrationRequest", "org.xms.g.fitness.request.DataUpdateListenerRegistrationRequest");
        map.put("com.huawei.hms.hihealth.options.ModifyDataMonitorOptions", "org.xms.g.fitness.request.DataUpdateListenerRegistrationRequest");
        map.put("com.google.android.gms.common.api.OptionalPendingResult", "org.xms.g.common.api.OptionalPendingResult$XImpl");
        map.put("com.huawei.hms.common.api.OptionalPendingResult", "org.xms.g.common.api.OptionalPendingResult$XImpl");
        map.put("com.google.android.gms.wallet.PaymentDataRequest", "org.xms.g.wallet.PaymentDataRequest");
        map.put("com.google.firebase.ml.vision.barcode.FirebaseVisionBarcodeDetectorOptions", "org.xms.f.ml.vision.barcode.FirebaseVisionBarcodeDetectorOptions");
        map.put("com.huawei.hms.ml.scan.HmsScanAnalyzerOptions", "org.xms.f.ml.vision.barcode.FirebaseVisionBarcodeDetectorOptions");
        map.put("com.google.android.gms.awareness.state.BeaconState.TypeFilter", "org.xms.g.awareness.state.BeaconState$TypeFilter$XImpl");
        map.put("com.huawei.hms.kit.awareness.status.BeaconStatus.Filter", "org.xms.g.awareness.state.BeaconState$TypeFilter$XImpl");
        map.put("com.google.android.gms.tasks.SuccessContinuation", "org.xms.g.tasks.SuccessContinuation$XImpl");
        map.put("com.huawei.hmf.tasks.SuccessContinuation", "org.xms.g.tasks.SuccessContinuation$XImpl");
        map.put("com.google.android.gms.fitness.request.GoalsReadRequest.Builder", "org.xms.g.fitness.request.GoalsReadRequest$Builder");
        map.put("com.google.android.gms.safetynet.SafetyNetApi", "org.xms.g.safetynet.SafetyNetApi$XImpl");
        map.put("com.google.android.gms.vision.barcode.Barcode.WiFi", "org.xms.g.vision.barcode.Barcode$WiFi");
        map.put("com.huawei.hms.ml.scan.HmsScan.WiFiConnectionInfo", "org.xms.g.vision.barcode.Barcode$WiFi");
        map.put("com.google.android.gms.fitness.service.FitnessSensorService", "org.xms.g.fitness.service.FitnessSensorService$XImpl");
        map.put("com.google.android.gms.fitness.data.Session.Builder", "org.xms.g.fitness.data.Session$Builder");
        map.put("com.huawei.hms.hihealth.data.ActivityRecord.Builder", "org.xms.g.fitness.data.Session$Builder");
        map.put("com.google.firebase.ml.vision.cloud.FirebaseVisionCloudDetectorOptions", "org.xms.f.ml.vision.cloud.FirebaseVisionCloudDetectorOptions");
        map.put("com.huawei.hms.mlsdk.landmark.MLRemoteLandmarkAnalyzerSetting", "org.xms.f.ml.vision.cloud.FirebaseVisionCloudDetectorOptions");
        map.put("com.google.android.gms.maps.StreetViewPanorama.OnStreetViewPanoramaLongClickListener", "org.xms.g.maps.StreetViewPanorama$OnStreetViewPanoramaLongClickListener$XImpl");
        map.put("com.google.android.gms.awareness.FenceApi", "org.xms.g.awareness.FenceApi$XImpl");
        map.put("com.google.android.gms.games.stats.Stats", "org.xms.g.games.stats.Stats$XImpl");
        map.put("com.google.android.gms.nearby.messages.EddystoneUid", "org.xms.g.nearby.messages.EddystoneUid");
        map.put("com.huawei.hms.nearby.message.BeaconId", "org.xms.g.nearby.messages.EddystoneUid");
        map.put("com.google.firebase.ml.vision.document.FirebaseVisionDocumentTextRecognizer", "org.xms.f.ml.vision.document.FirebaseVisionDocumentTextRecognizer");
        map.put("com.huawei.hms.mlsdk.document.MLDocumentAnalyzer", "org.xms.f.ml.vision.document.FirebaseVisionDocumentTextRecognizer");
        map.put("com.google.android.gms.fitness.data.DataUpdateNotification", "org.xms.g.fitness.data.DataUpdateNotification");
        map.put("com.huawei.hms.hihealth.data.DataModifyInfo", "org.xms.g.fitness.data.DataUpdateNotification");
        map.put("com.google.android.gms.wallet.AutoResolveHelper", "org.xms.g.wallet.AutoResolveHelper");
        map.put("com.huawei.hms.wallet.ResolveTaskHelper", "org.xms.g.wallet.AutoResolveHelper");
        map.put("com.google.android.gms.games.leaderboard.LeaderboardVariant", "org.xms.g.games.leaderboard.LeaderboardVariant$XImpl");
        map.put("com.huawei.hms.jos.games.ranking.RankingVariant", "org.xms.g.games.leaderboard.LeaderboardVariant$XImpl");
        map.put("com.google.android.gms.tasks.CancellationTokenSource", "org.xms.g.tasks.CancellationTokenSource");
        map.put("com.huawei.hmf.tasks.CancellationTokenSource", "org.xms.g.tasks.CancellationTokenSource");
        map.put("com.google.android.gms.tasks.Tasks", "org.xms.g.tasks.Tasks");
        map.put("com.huawei.hmf.tasks.Tasks", "org.xms.g.tasks.Tasks");
        map.put("com.google.android.gms.auth.account.WorkAccount", "org.xms.g.auth.account.WorkAccount");
        map.put("com.google.android.gms.ads.mediation.MediationAdLoadCallback", "org.xms.g.ads.mediation.MediationAdLoadCallback$XImpl");
        map.put("com.google.android.gms.ads.mediation.NetworkExtras", "org.xms.g.ads.mediation.NetworkExtras$XImpl");
        map.put("com.google.android.gms.awareness.fence.FenceUpdateRequest.Builder", "org.xms.g.awareness.fence.FenceUpdateRequest$Builder");
        map.put("com.huawei.hms.kit.awareness.barrier.BarrierUpdateRequest.Builder", "org.xms.g.awareness.fence.FenceUpdateRequest$Builder");
        map.put("com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode.GeoPoint", "org.xms.f.ml.vision.barcode.FirebaseVisionBarcode$GeoPoint");
        map.put("com.huawei.hms.ml.scan.HmsScan.LocationCoordinate", "org.xms.f.ml.vision.barcode.FirebaseVisionBarcode$GeoPoint");
        map.put("com.google.android.gms.gcm.PeriodicTask", "org.xms.g.gcm.PeriodicTask");
        map.put("com.google.android.gms.gcm.OneoffTask.Builder", "org.xms.g.gcm.OneoffTask$Builder");
        map.put("com.google.android.gms.fitness.request.DataUpdateListenerRegistrationRequest.Builder", "org.xms.g.fitness.request.DataUpdateListenerRegistrationRequest$Builder");
        map.put("com.huawei.hms.hihealth.options.ModifyDataMonitorOptions.Builder", "org.xms.g.fitness.request.DataUpdateListenerRegistrationRequest$Builder");
        map.put("com.google.android.gms.ads.formats.NativeAppInstallAdView", "org.xms.g.ads.formats.NativeAppInstallAdView");
        map.put("com.huawei.hms.ads.nativead.NativeView", "org.xms.g.ads.formats.NativeAppInstallAdView");
        map.put("com.google.android.gms.wallet.wobs.TimeInterval", "org.xms.g.wallet.wobs.TimeInterval");
        map.put("com.google.android.gms.games.snapshot.Snapshot", "org.xms.g.games.snapshot.Snapshot$XImpl");
        map.put("com.huawei.hms.jos.games.archive.Archive", "org.xms.g.games.snapshot.Snapshot$XImpl");
        map.put("com.google.android.gms.games.GamesStatusCodes", "org.xms.g.games.GamesStatusCodes");
        map.put("com.huawei.hms.jos.games.GamesStatusCodes", "org.xms.g.games.GamesStatusCodes");
        map.put("com.google.android.gms.nearby.connection.PayloadTransferUpdate", "org.xms.g.nearby.connection.PayloadTransferUpdate");
        map.put("com.huawei.hms.nearby.transfer.TransferStateUpdate", "org.xms.g.nearby.connection.PayloadTransferUpdate");
        map.put("com.google.android.gms.ads.rewarded.RewardedAdLoadCallback", "org.xms.g.ads.rewarded.RewardedAdLoadCallback");
        map.put("com.huawei.hms.ads.reward.RewardAdLoadListener", "org.xms.g.ads.rewarded.RewardedAdLoadCallback");
        map.put("com.google.android.gms.maps.model.IndoorBuilding", "org.xms.g.maps.model.IndoorBuilding");
        map.put("com.huawei.hms.maps.model.IndoorBuilding", "org.xms.g.maps.model.IndoorBuilding");
        map.put("com.google.android.gms.games.SnapshotsClient.DataOrConflict", "org.xms.g.games.SnapshotsClient$DataOrConflict");
        map.put("com.huawei.hms.jos.games.archive.OperationResult", "org.xms.g.games.SnapshotsClient$DataOrConflict");
        map.put("com.google.android.gms.common.GooglePlayServicesUtil", "org.xms.g.common.ExtensionPlayServicesUtil");
        map.put("com.huawei.hms.api.HuaweiMobileServicesUtil", "org.xms.g.common.ExtensionPlayServicesUtil");
        map.put("com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateCallback", "org.xms.g.games.multiplayer.realtime.RoomStatusUpdateCallback$XImpl");
        map.put("com.google.android.gms.maps.GoogleMap.OnInfoWindowCloseListener", "org.xms.g.maps.ExtensionMap$OnInfoWindowCloseListener$XImpl");
        map.put("com.huawei.hms.maps.HuaweiMap.OnInfoWindowCloseListener", "org.xms.g.maps.ExtensionMap$OnInfoWindowCloseListener$XImpl");
        map.put("com.google.android.gms.common.api.PendingResult", "org.xms.g.common.api.PendingResult$XImpl");
        map.put("com.huawei.hms.support.api.client.PendingResult", "org.xms.g.common.api.PendingResult$XImpl");
        map.put("com.google.firebase.ml.custom.FirebaseModelInputs", "org.xms.f.ml.custom.FirebaseModelInputs");
        map.put("com.google.android.gms.games.TurnBasedMultiplayerClient.MatchOutOfDateApiException", "org.xms.g.games.TurnBasedMultiplayerClient$MatchOutOfDateApiException");
        map.put("com.google.android.gms.ads.mediation.rtb.RtbAdapter", "org.xms.g.ads.mediation.rtb.RtbAdapter$XImpl");
        map.put("com.google.android.gms.common.ErrorDialogFragment", "org.xms.g.common.ErrorDialogFragment");
        map.put("com.huawei.hms.common.ErrorDialogFragment", "org.xms.g.common.ErrorDialogFragment");
        map.put("com.google.android.gms.vision.MultiProcessor", "org.xms.g.vision.MultiProcessor");
        map.put("com.huawei.hms.mlsdk.common.MLCompositeTransactor", "org.xms.g.vision.MultiProcessor");
        map.put("com.google.android.gms.ads.appopen.AppOpenAdPresentationCallback", "org.xms.g.ads.appopen.AppOpenAdPresentationCallback");
        map.put("com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder", "org.xms.g.analytics.HitBuilders$ScreenViewBuilder");
        map.put("com.google.android.gms.fitness.request.DataReadRequest.Builder", "org.xms.g.fitness.request.DataReadRequest$Builder");
        map.put("com.huawei.hms.hihealth.options.ReadOptions.Builder", "org.xms.g.fitness.request.DataReadRequest$Builder");
        map.put("com.google.android.gms.ads.mediation.MediationNativeAdConfiguration", "org.xms.g.ads.mediation.MediationNativeAdConfiguration");
        map.put("com.google.android.gms.location.GeofencingEvent", "org.xms.g.location.GeofencingEvent");
        map.put("com.huawei.hms.location.GeofenceData", "org.xms.g.location.GeofencingEvent");
        map.put("com.google.android.gms.games.GamesMetadata", "org.xms.g.games.GamesMetadata$XImpl");
        map.put("com.google.android.gms.common.AccountPicker", "org.xms.g.common.AccountPicker");
        map.put("com.google.firebase.ml.vision.face.FirebaseVisionFaceLandmark", "org.xms.f.ml.vision.face.FirebaseVisionFaceLandmark");
        map.put("com.huawei.hms.mlsdk.face.MLFaceKeyPoint", "org.xms.f.ml.vision.face.FirebaseVisionFaceLandmark");
        map.put("com.google.android.gms.ads.mediation.MediationInterstitialAdapter", "org.xms.g.ads.mediation.MediationInterstitialAdapter$XImpl");
        map.put("com.google.android.gms.ads.RequestConfiguration", "org.xms.g.ads.RequestConfiguration");
        map.put("com.google.android.gms.fitness.request.DataSourcesRequest", "org.xms.g.fitness.request.DataSourcesRequest");
        map.put("com.huawei.hms.hihealth.options.DataCollectorsOptions", "org.xms.g.fitness.request.DataSourcesRequest");
        map.put("com.google.android.gms.ads.mediation.customevent.CustomEventExtras", "org.xms.g.ads.mediation.customevent.CustomEventExtras");
        map.put("com.google.android.gms.games.multiplayer.realtime.Room", "org.xms.g.games.multiplayer.realtime.Room$XImpl");
        map.put("com.google.android.gms.ads.formats.NativeCustomTemplateAd", "org.xms.g.ads.formats.NativeCustomTemplateAd$XImpl");
        map.put("com.google.android.gms.common.data.Freezable", "org.xms.g.common.data.Freezable$XImpl");
        map.put("com.huawei.hms.common.data.Freezable", "org.xms.g.common.data.Freezable$XImpl");
        map.put("com.google.android.gms.vision.face.Landmark", "org.xms.g.vision.face.Landmark");
        map.put("com.huawei.hms.mlsdk.face.MLFaceKeyPoint", "org.xms.g.vision.face.Landmark");
        map.put("com.google.android.gms.analytics.ecommerce.ProductAction", "org.xms.g.analytics.ecommerce.ProductAction");
        map.put("com.google.android.gms.identity.intents.AddressConstants.ResultCodes", "org.xms.g.identity.intents.AddressConstants$ResultCodes$XImpl");
        map.put("com.google.android.gms.maps.UiSettings", "org.xms.g.maps.UiSettings");
        map.put("com.huawei.hms.maps.UiSettings", "org.xms.g.maps.UiSettings");
        map.put("com.google.android.gms.nearby.messages.SubscribeCallback", "org.xms.g.nearby.messages.SubscribeCallback");
        map.put("com.huawei.hms.nearby.message.GetCallback", "org.xms.g.nearby.messages.SubscribeCallback");
        map.put("com.google.android.gms.ads.search.DynamicHeightSearchAdRequest.Builder", "org.xms.g.ads.search.DynamicHeightSearchAdRequest$Builder");
        map.put("com.google.android.gms.games.multiplayer.ParticipantResult", "org.xms.g.games.multiplayer.ParticipantResult");
        map.put("com.google.firebase.ml.vision.barcode.FirebaseVisionBarcodeDetector", "org.xms.f.ml.vision.barcode.FirebaseVisionBarcodeDetector");
        map.put("com.huawei.hms.ml.scan.HmsScanAnalyzer", "org.xms.f.ml.vision.barcode.FirebaseVisionBarcodeDetector");
        map.put("com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer", "org.xms.g.games.multiplayer.realtime.RealTimeMultiplayer$XImpl");
        map.put("com.google.android.gms.nearby.connection.Payload", "org.xms.g.nearby.connection.Payload");
        map.put("com.huawei.hms.nearby.transfer.Data", "org.xms.g.nearby.connection.Payload");
        map.put("com.google.android.gms.fitness.data.Goal.DurationObjective", "org.xms.g.fitness.data.Goal$DurationObjective");
        map.put("com.google.android.gms.vision.barcode.BarcodeDetector.Builder", "org.xms.g.vision.barcode.BarcodeDetector$Builder");
        map.put("com.huawei.hms.ml.scan.HmsScanAnalyzer.Creator", "org.xms.g.vision.barcode.BarcodeDetector$Builder");
        map.put("com.google.android.gms.common.api.Batch", "org.xms.g.common.api.Batch");
        map.put("com.google.android.gms.ads.AdLoader.Builder", "org.xms.g.ads.AdLoader$Builder");
        map.put("com.huawei.hms.ads.nativead.NativeAdLoader.Builder", "org.xms.g.ads.AdLoader$Builder");
        map.put("com.google.android.gms.ads.formats.UnifiedNativeAd.UnconfirmedClickListener", "org.xms.g.ads.formats.UnifiedNativeAd$UnconfirmedClickListener$XImpl");
        map.put("com.google.android.gms.awareness.snapshot.BeaconStateResponse", "org.xms.g.awareness.snapshot.BeaconStateResponse");
        map.put("com.huawei.hms.kit.awareness.capture.BeaconStatusResponse", "org.xms.g.awareness.snapshot.BeaconStateResponse");
        map.put("com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener", "org.xms.g.ads.formats.NativeCustomTemplateAd$OnCustomClickListener$XImpl");
        map.put("com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode.Email", "org.xms.f.ml.vision.barcode.FirebaseVisionBarcode$Email");
        map.put("com.huawei.hms.ml.scan.HmsScan.EmailContent", "org.xms.f.ml.vision.barcode.FirebaseVisionBarcode$Email");
        map.put("com.google.android.gms.awareness.AwarenessStatusCodes", "org.xms.g.awareness.AwarenessStatusCodes");
        map.put("com.huawei.hms.kit.awareness.AwarenessStatusCodes", "org.xms.g.awareness.AwarenessStatusCodes");
        map.put("com.google.android.gms.common.api.Scope", "org.xms.g.common.api.Scope");
        map.put("com.huawei.hms.support.api.entity.auth.Scope", "org.xms.g.common.api.Scope");
        map.put("com.google.android.gms.nearby.connection.Connections.EndpointDiscoveryListener", "org.xms.g.nearby.connection.Connections$EndpointDiscoveryListener$XImpl");
        map.put("com.google.android.gms.safetynet.SafetyNetApi.VerifyAppsUserResponse", "org.xms.g.safetynet.SafetyNetApi$VerifyAppsUserResponse");
        map.put("com.huawei.hms.support.api.entity.safetydetect.VerifyAppsCheckEnabledResp", "org.xms.g.safetynet.SafetyNetApi$VerifyAppsUserResponse");
        map.put("com.google.android.gms.maps.GoogleMap.OnMarkerDragListener", "org.xms.g.maps.ExtensionMap$OnMarkerDragListener$XImpl");
        map.put("com.huawei.hms.maps.HuaweiMap.OnMarkerDragListener", "org.xms.g.maps.ExtensionMap$OnMarkerDragListener$XImpl");
        map.put("com.google.android.gms.games.SnapshotsClient.SnapshotConflict", "org.xms.g.games.SnapshotsClient$SnapshotConflict");
        map.put("com.huawei.hms.jos.games.archive.OperationResult.Difference", "org.xms.g.games.SnapshotsClient$SnapshotConflict");
        map.put("com.google.firebase.ml.naturallanguage.translate.FirebaseTranslateRemoteModel.Builder", "org.xms.f.ml.naturallanguage.translate.FirebaseTranslateRemoteModel$Builder");
        map.put("com.google.android.gms.nearby.messages.Distance.Accuracy", "org.xms.g.nearby.messages.Distance$Accuracy");
        map.put("com.huawei.hms.nearby.discovery.Distance.Precision", "org.xms.g.nearby.messages.Distance$Accuracy");
        map.put("com.google.firebase.ml.naturallanguage.translate.FirebaseTranslateRemoteModel", "org.xms.f.ml.naturallanguage.translate.FirebaseTranslateRemoteModel");
        map.put("com.google.android.gms.nearby.connection.Connections.ConnectionRequestListener", "org.xms.g.nearby.connection.Connections$ConnectionRequestListener$XImpl");
        map.put("com.google.android.gms.maps.GoogleMap.CancelableCallback", "org.xms.g.maps.ExtensionMap$CancelableCallback$XImpl");
        map.put("com.huawei.hms.maps.HuaweiMap.CancelableCallback", "org.xms.g.maps.ExtensionMap$CancelableCallback$XImpl");
        map.put("com.google.android.gms.fitness.result.DailyTotalResult", "org.xms.g.fitness.result.DailyTotalResult");
        map.put("com.huawei.hms.hihealth.result.DailyStatisticsResult", "org.xms.g.fitness.result.DailyTotalResult");
        map.put("com.google.android.gms.maps.GoogleMap.OnPolylineClickListener", "org.xms.g.maps.ExtensionMap$OnPolylineClickListener$XImpl");
        map.put("com.huawei.hms.maps.HuaweiMap.OnPolylineClickListener", "org.xms.g.maps.ExtensionMap$OnPolylineClickListener$XImpl");
        map.put("com.google.android.gms.games.Players", "org.xms.g.games.Players$XImpl");
        map.put("com.google.android.gms.location.Geofence", "org.xms.g.location.Geofence$XImpl");
        map.put("com.huawei.hms.location.Geofence", "org.xms.g.location.Geofence$XImpl");
        map.put("com.google.android.gms.fitness.GoalsApi", "org.xms.g.fitness.GoalsApi$XImpl");
        map.put("com.google.android.gms.common.api.ApiException", "org.xms.g.common.api.ApiException");
        map.put("com.huawei.hms.common.ApiException", "org.xms.g.common.api.ApiException");
        map.put("com.google.android.gms.ads.formats.NativeAd", "org.xms.g.ads.formats.NativeAd$XImpl");
        map.put("com.google.android.gms.auth.api.phone.SmsRetrieverClient", "org.xms.g.auth.api.phone.SmsRetrieverClient$XImpl");
        map.put("com.google.android.gms.games.leaderboard.Leaderboard", "org.xms.g.games.leaderboard.Leaderboard$XImpl");
        map.put("com.huawei.hms.jos.games.ranking.Ranking", "org.xms.g.games.leaderboard.Leaderboard$XImpl");
        map.put("com.google.android.gms.games.PlayersClient", "org.xms.g.games.PlayersClient");
        map.put("com.huawei.hms.jos.games.PlayersClient", "org.xms.g.games.PlayersClient");
        map.put("com.google.android.gms.wallet.wobs.LoyaltyPointsBalance.Builder", "org.xms.g.wallet.wobs.LoyaltyPointsBalance$Builder");
        map.put("com.google.android.gms.auth.api.credentials.Credential", "org.xms.g.auth.api.credentials.Credential");
        map.put("com.google.android.gms.awareness.state.Weather", "org.xms.g.awareness.state.Weather$XImpl");
        map.put("com.google.android.gms.ads.MuteThisAdReason", "org.xms.g.ads.MuteThisAdReason$XImpl");
        map.put("com.huawei.hms.ads.nativead.DislikeAdReason", "org.xms.g.ads.MuteThisAdReason$XImpl");
        map.put("com.google.android.gms.security.ProviderInstaller", "org.xms.g.security.ProviderInstaller");
        map.put("com.huawei.hms.security.SecComponentInstallWizard", "org.xms.g.security.ProviderInstaller");
        map.put("com.google.android.gms.common.data.DataBufferObserverSet", "org.xms.g.common.data.DataBufferObserverSet");
        map.put("com.google.android.gms.games.leaderboard.ScoreSubmissionData", "org.xms.g.games.leaderboard.ScoreSubmissionData");
        map.put("com.huawei.hms.jos.games.ranking.ScoreSubmissionInfo", "org.xms.g.games.leaderboard.ScoreSubmissionData");
        map.put("com.google.android.gms.awareness.state.HeadphoneState", "org.xms.g.awareness.state.HeadphoneState$XImpl");
        map.put("com.huawei.hms.kit.awareness.status.HeadsetStatus", "org.xms.g.awareness.state.HeadphoneState$XImpl");
        map.put("com.google.android.gms.ads.mediation.NativeAppInstallAdMapper", "org.xms.g.ads.mediation.NativeAppInstallAdMapper");
        map.put("com.google.android.gms.games.multiplayer.realtime.RoomConfig.Builder", "org.xms.g.games.multiplayer.realtime.RoomConfig$Builder");
        map.put("com.google.android.gms.nearby.connection.DiscoveryOptions", "org.xms.g.nearby.connection.DiscoveryOptions");
        map.put("com.huawei.hms.nearby.discovery.ScanOption", "org.xms.g.nearby.connection.DiscoveryOptions");
        map.put("com.google.android.gms.auth.api.credentials.IdToken", "org.xms.g.auth.api.credentials.IdToken");
        map.put("com.google.android.gms.wallet.wobs.UriData", "org.xms.g.wallet.wobs.UriData");
        map.put("com.google.android.gms.ads.initialization.InitializationStatus", "org.xms.g.ads.initialization.InitializationStatus$XImpl");
        map.put("com.google.android.gms.games.multiplayer.ParticipantBuffer", "org.xms.g.games.multiplayer.ParticipantBuffer");
        map.put("com.google.android.gms.nearby.Nearby", "org.xms.g.nearby.Nearby");
        map.put("com.huawei.hms.nearby.Nearby", "org.xms.g.nearby.Nearby");
        map.put("com.google.android.gms.vision.MultiProcessor.Builder", "org.xms.g.vision.MultiProcessor$Builder");
        map.put("com.huawei.hms.mlsdk.common.MLCompositeTransactor.Creator", "org.xms.g.vision.MultiProcessor$Builder");
        map.put("com.google.android.gms.wallet.wobs.LabelValueRow", "org.xms.g.wallet.wobs.LabelValueRow");
        map.put("com.google.android.gms.analytics.AnalyticsReceiver", "org.xms.g.analytics.AnalyticsReceiver");
        map.put("com.google.android.gms.maps.model.SquareCap", "org.xms.g.maps.model.SquareCap");
        map.put("com.huawei.hms.maps.model.SquareCap", "org.xms.g.maps.model.SquareCap");
        map.put("com.google.android.gms.games.LeaderboardsClient.LeaderboardScores", "org.xms.g.games.LeaderboardsClient$LeaderboardScores");
        map.put("com.huawei.hms.jos.games.RankingsClient.RankingScores", "org.xms.g.games.LeaderboardsClient$LeaderboardScores");
        map.put("com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode", "org.xms.f.ml.vision.barcode.FirebaseVisionBarcode");
        map.put("com.huawei.hms.ml.scan.HmsScan", "org.xms.f.ml.vision.barcode.FirebaseVisionBarcode");
        map.put("com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchUpdateCallback", "org.xms.g.games.multiplayer.turnbased.TurnBasedMatchUpdateCallback$XImpl");
        map.put("com.google.android.gms.location.ActivityTransitionEvent", "org.xms.g.location.ActivityTransitionEvent");
        map.put("com.huawei.hms.location.ActivityConversionData", "org.xms.g.location.ActivityTransitionEvent");
        map.put("com.google.android.gms.auth.api.accounttransfer.AuthenticatorTransferCompletionStatus", "org.xms.g.auth.api.accounttransfer.AuthenticatorTransferCompletionStatus$XImpl");
        map.put("com.google.android.gms.nearby.connection.ConnectionLifecycleCallback", "org.xms.g.nearby.connection.ConnectionLifecycleCallback$XImpl");
        map.put("com.huawei.hms.nearby.discovery.ConnectCallback", "org.xms.g.nearby.connection.ConnectionLifecycleCallback$XImpl");
        map.put("com.google.android.gms.common.SupportErrorDialogFragment", "org.xms.g.common.SupportErrorDialogFragment");
        map.put("com.huawei.hms.common.ErrDlgFragmentForSupport", "org.xms.g.common.SupportErrorDialogFragment");
        map.put("com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode.CalendarEvent", "org.xms.f.ml.vision.barcode.FirebaseVisionBarcode$CalendarEvent");
        map.put("com.huawei.hms.ml.scan.HmsScan.EventInfo", "org.xms.f.ml.vision.barcode.FirebaseVisionBarcode$CalendarEvent");
        map.put("com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks", "org.xms.g.ads.VideoController$VideoLifecycleCallbacks$XImpl");
        map.put("com.huawei.hms.ads.VideoOperator.VideoLifecycleListener", "org.xms.g.ads.VideoController$VideoLifecycleCallbacks$XImpl");
        map.put("com.google.android.gms.safetynet.SafeBrowsingThreat", "org.xms.g.safetynet.SafeBrowsingThreat");
        map.put("com.huawei.hms.support.api.entity.safetydetect.UrlCheckThreat", "org.xms.g.safetynet.SafeBrowsingThreat");
        map.put("com.google.android.gms.safetynet.SafetyNetApi.HarmfulAppsResponse", "org.xms.g.safetynet.SafetyNetApi$HarmfulAppsResponse");
        map.put("com.huawei.hms.support.api.entity.safetydetect.MaliciousAppsListResp", "org.xms.g.safetynet.SafetyNetApi$HarmfulAppsResponse");
        map.put("com.google.android.gms.ads.search.SearchAdRequest", "org.xms.g.ads.search.SearchAdRequest");
        map.put("com.google.android.gms.wallet.wobs.WalletObjectMessage.Builder", "org.xms.g.wallet.wobs.WalletObjectMessage$Builder");
        map.put("com.google.android.gms.maps.SupportMapFragment", "org.xms.g.maps.SupportMapFragment");
        map.put("com.google.android.gms.awareness.fence.DetectedActivityFence", "org.xms.g.awareness.fence.DetectedActivityFence");
        map.put("com.huawei.hms.kit.awareness.barrier.BehaviorBarrier", "org.xms.g.awareness.fence.DetectedActivityFence");
        map.put("com.google.android.gms.tasks.OnCompleteListener", "org.xms.g.tasks.OnCompleteListener$XImpl");
        map.put("com.huawei.hmf.tasks.OnCompleteListener", "org.xms.g.tasks.OnCompleteListener$XImpl");
        map.put("com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode.Sms", "org.xms.f.ml.vision.barcode.FirebaseVisionBarcode$Sms");
        map.put("com.huawei.hms.ml.scan.HmsScan.SmsContent", "org.xms.f.ml.vision.barcode.FirebaseVisionBarcode$Sms");
        map.put("com.google.android.gms.nearby.connection.Payload.Type", "org.xms.g.nearby.connection.Payload$Type$XImpl");
        map.put("com.huawei.hms.nearby.transfer.Data.Type", "org.xms.g.nearby.connection.Payload$Type$XImpl");
        map.put("com.google.android.gms.games.achievement.AchievementBuffer", "org.xms.g.games.achievement.AchievementBuffer");
        map.put("com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult", "org.xms.g.games.multiplayer.turnbased.TurnBasedMultiplayer$CancelMatchResult$XImpl");
        map.put("com.google.android.gms.safetynet.VerifyAppsConstants", "org.xms.g.safetynet.VerifyAppsConstants");
        map.put("com.google.android.gms.vision.face.FaceDetector", "org.xms.g.vision.face.FaceDetector");
        map.put("com.google.android.gms.wallet.wobs.WalletObjectMessage", "org.xms.g.wallet.wobs.WalletObjectMessage");
        map.put("com.google.android.gms.awareness.fence.LocationFence", "org.xms.g.awareness.fence.LocationFence");
        map.put("com.huawei.hms.kit.awareness.barrier.LocationBarrier", "org.xms.g.awareness.fence.LocationFence");
        map.put("com.google.android.gms.fitness.data.Bucket", "org.xms.g.fitness.data.Bucket");
        map.put("com.huawei.hms.hihealth.data.Group", "org.xms.g.fitness.data.Bucket");
        map.put("com.google.android.gms.nearby.messages.NearbyPermissions", "org.xms.g.nearby.messages.NearbyPermissions$XImpl");
        map.put("com.huawei.hms.nearby.message.Permission", "org.xms.g.nearby.messages.NearbyPermissions$XImpl");
        map.put("com.google.android.gms.location.ActivityRecognitionClient", "org.xms.g.location.ActivityRecognitionClient");
        map.put("com.huawei.hms.location.ActivityIdentificationService", "org.xms.g.location.ActivityRecognitionClient");
        map.put("com.google.android.gms.games.Games.GamesOptions.Builder", "org.xms.g.games.Games$GamesOptions$Builder");
        map.put("com.google.android.gms.games.leaderboard.LeaderboardScore", "org.xms.g.games.leaderboard.LeaderboardScore$XImpl");
        map.put("com.huawei.hms.jos.games.ranking.RankingScore", "org.xms.g.games.leaderboard.LeaderboardScore$XImpl");
        map.put("com.google.android.gms.nearby.messages.SubscribeOptions.Builder", "org.xms.g.nearby.messages.SubscribeOptions$Builder");
        map.put("com.huawei.hms.nearby.message.GetOption.Builder", "org.xms.g.nearby.messages.SubscribeOptions$Builder");
        map.put("com.google.android.gms.games.PlayerBuffer", "org.xms.g.games.PlayerBuffer");
        map.put("com.google.android.gms.games.snapshot.Snapshots", "org.xms.g.games.snapshot.Snapshots$XImpl");
        map.put("com.google.android.gms.auth.api.accounttransfer.AccountTransferClient", "org.xms.g.auth.api.accounttransfer.AccountTransferClient");
        map.put("com.google.firebase.ml.vision.common.FirebaseVisionPoint", "org.xms.f.ml.vision.common.FirebaseVisionPoint");
        map.put("com.huawei.hms.mlsdk.common.MLPosition", "org.xms.f.ml.vision.common.FirebaseVisionPoint");
        map.put("com.google.android.gms.tasks.RuntimeExecutionException", "org.xms.g.tasks.RuntimeExecutionException");
        map.put("com.google.android.gms.wallet.PaymentMethodTokenizationParameters.Builder", "org.xms.g.wallet.PaymentMethodTokenizationParameters$Builder");
        map.put("com.google.android.gms.maps.GoogleMap.OnPoiClickListener", "org.xms.g.maps.ExtensionMap$OnPoiClickListener$XImpl");
        map.put("com.huawei.hms.maps.HuaweiMap.OnPoiClickListener", "org.xms.g.maps.ExtensionMap$OnPoiClickListener$XImpl");
        map.put("com.google.android.gms.nearby.connection.PayloadTransferUpdate.Builder", "org.xms.g.nearby.connection.PayloadTransferUpdate$Builder");
        map.put("com.google.android.gms.games.EventsClient", "org.xms.g.games.EventsClient");
        map.put("com.huawei.hms.jos.games.EventsClient", "org.xms.g.games.EventsClient");
        map.put("com.google.android.gms.maps.GoogleMap.OnCameraMoveListener", "org.xms.g.maps.ExtensionMap$OnCameraMoveListener$XImpl");
        map.put("com.huawei.hms.maps.HuaweiMap.OnCameraMoveListener", "org.xms.g.maps.ExtensionMap$OnCameraMoveListener$XImpl");
        map.put("com.google.android.gms.nearby.connection.DiscoveryOptions.Builder", "org.xms.g.nearby.connection.DiscoveryOptions$Builder");
        map.put("com.huawei.hms.nearby.discovery.ScanOption.Builder", "org.xms.g.nearby.connection.DiscoveryOptions$Builder");
        map.put("com.google.android.gms.fitness.request.DataReadRequest", "org.xms.g.fitness.request.DataReadRequest");
        map.put("com.huawei.hms.hihealth.options.ReadOptions", "org.xms.g.fitness.request.DataReadRequest");
        map.put("com.google.android.gms.ads.MobileAds.Settings", "org.xms.g.ads.MobileAds$Settings");
        map.put("com.google.android.gms.maps.model.LatLngBounds.Builder", "org.xms.g.maps.model.LatLngBounds$Builder");
        map.put("com.huawei.hms.maps.model.LatLngBounds.Builder", "org.xms.g.maps.model.LatLngBounds$Builder");
        map.put("com.google.android.gms.common.api.CommonStatusCodes", "org.xms.g.common.api.CommonStatusCodes");
        map.put("com.huawei.hms.common.api.CommonStatusCodes", "org.xms.g.common.api.CommonStatusCodes");
        map.put("com.google.android.gms.common.api.Batch.Builder", "org.xms.g.common.api.Batch$Builder");
        map.put("com.google.android.gms.location.LocationRequest", "org.xms.g.location.LocationRequest");
        map.put("com.huawei.hms.location.LocationRequest", "org.xms.g.location.LocationRequest");
        map.put("com.google.android.gms.games.GamesActivityResultCodes", "org.xms.g.games.GamesActivityResultCodes");
        map.put("com.google.android.gms.ads.InterstitialAd", "org.xms.g.ads.InterstitialAd");
        map.put("com.huawei.hms.ads.InterstitialAd", "org.xms.g.ads.InterstitialAd");
        map.put("com.google.android.gms.ads.rewarded.ServerSideVerificationOptions", "org.xms.g.ads.rewarded.ServerSideVerificationOptions");
        map.put("com.huawei.hms.ads.reward.RewardVerifyConfig", "org.xms.g.ads.rewarded.ServerSideVerificationOptions");
        map.put("com.google.android.gms.ads.doubleclick.PublisherAdView", "org.xms.g.ads.doubleclick.PublisherAdView");
        map.put("com.google.android.gms.ads.NativeExpressAdView", "org.xms.g.ads.NativeExpressAdView");
        map.put("com.huawei.hms.ads.template.view.NativeTemplateView", "org.xms.g.ads.NativeExpressAdView");
        map.put("com.google.android.gms.fitness.data.DataType", "org.xms.g.fitness.data.DataType");
        map.put("com.huawei.hms.hihealth.data.DataType", "org.xms.g.fitness.data.DataType");
        map.put("com.google.android.gms.ads.formats.NativeAppInstallAd", "org.xms.g.ads.formats.NativeAppInstallAd$XImpl");
        map.put("com.google.firebase.ml.vision.FirebaseVision", "org.xms.f.ml.vision.FirebaseVision");
        map.put("com.huawei.hms.mlsdk.MLAnalyzerFactory", "org.xms.f.ml.vision.FirebaseVision");
        map.put("com.google.android.gms.ads.mediation.MediationNativeAdapter", "org.xms.g.ads.mediation.MediationNativeAdapter$XImpl");
        map.put("com.google.android.gms.tasks.OnCanceledListener", "org.xms.g.tasks.OnCanceledListener$XImpl");
        map.put("com.huawei.hmf.tasks.OnCanceledListener", "org.xms.g.tasks.OnCanceledListener$XImpl");
        map.put("com.google.android.gms.vision.text.Text", "org.xms.g.vision.text.Text$XImpl");
        map.put("com.huawei.hms.mlsdk.text.MLText.Text", "org.xms.g.vision.text.Text$XImpl");
        map.put("com.google.android.gms.nearby.messages.PublishOptions.Builder", "org.xms.g.nearby.messages.PublishOptions$Builder");
        map.put("com.huawei.hms.nearby.message.PutOption.Builder", "org.xms.g.nearby.messages.PublishOptions$Builder");
        map.put("com.google.android.gms.maps.model.PolygonOptions", "org.xms.g.maps.model.PolygonOptions");
        map.put("com.huawei.hms.maps.model.PolygonOptions", "org.xms.g.maps.model.PolygonOptions");
        map.put("com.google.android.gms.vision.barcode.Barcode.Sms", "org.xms.g.vision.barcode.Barcode$Sms");
        map.put("com.huawei.hms.ml.scan.HmsScan.SmsContent", "org.xms.g.vision.barcode.Barcode$Sms");
        map.put("com.google.firebase.ml.vision.objects.FirebaseVisionObject", "org.xms.f.ml.vision.objects.FirebaseVisionObject");
        map.put("com.huawei.hms.mlsdk.objects.MLObject", "org.xms.f.ml.vision.objects.FirebaseVisionObject");
        map.put("com.google.android.gms.common.api.ResultTransform", "org.xms.g.common.api.ResultTransform$XImpl");
        map.put("com.huawei.hms.support.api.client.ResultConvert", "org.xms.g.common.api.ResultTransform$XImpl");
        map.put("com.google.android.gms.ads.mediation.MediationBannerAdCallback", "org.xms.g.ads.mediation.MediationBannerAdCallback$XImpl");
        map.put("com.google.firebase.ml.vision.document.FirebaseVisionCloudDocumentRecognizerOptions", "org.xms.f.ml.vision.document.FirebaseVisionCloudDocumentRecognizerOptions");
        map.put("com.huawei.hms.mlsdk.document.MLDocumentSetting", "org.xms.f.ml.vision.document.FirebaseVisionCloudDocumentRecognizerOptions");
        map.put("com.google.android.gms.games.achievement.Achievements", "org.xms.g.games.achievement.Achievements$XImpl");
        map.put("com.google.android.gms.fitness.data.Session", "org.xms.g.fitness.data.Session");
        map.put("com.huawei.hms.hihealth.data.ActivityRecord", "org.xms.g.fitness.data.Session");
        map.put("com.google.android.gms.location.ActivityTransitionRequest", "org.xms.g.location.ActivityTransitionRequest");
        map.put("com.huawei.hms.location.ActivityConversionRequest", "org.xms.g.location.ActivityTransitionRequest");
        map.put("com.google.android.gms.nearby.messages.MessagesOptions", "org.xms.g.nearby.messages.MessagesOptions");
        map.put("com.huawei.hms.nearby.message.MessageOption", "org.xms.g.nearby.messages.MessagesOptions");
        map.put("com.google.android.gms.ads.formats.PublisherAdViewOptions", "org.xms.g.ads.formats.PublisherAdViewOptions");
        map.put("com.google.android.gms.ads.search.SearchAdView", "org.xms.g.ads.search.SearchAdView");
        map.put("com.google.android.gms.tasks.Task", "org.xms.g.tasks.Task$XImpl");
        map.put("com.huawei.hmf.tasks.Task", "org.xms.g.tasks.Task$XImpl");
        map.put("com.google.android.gms.games.event.EventBuffer", "org.xms.g.games.event.EventBuffer");
        map.put("com.google.android.gms.maps.Projection", "org.xms.g.maps.Projection");
        map.put("com.huawei.hms.maps.Projection", "org.xms.g.maps.Projection");
        map.put("com.google.android.gms.vision.barcode.Barcode.CalendarDateTime", "org.xms.g.vision.barcode.Barcode$CalendarDateTime");
        map.put("com.huawei.hms.ml.scan.HmsScan.EventTime", "org.xms.g.vision.barcode.Barcode$CalendarDateTime");
        map.put("com.google.android.gms.vision.barcode.BarcodeDetector", "org.xms.g.vision.barcode.BarcodeDetector");
        map.put("com.huawei.hms.ml.scan.HmsScanAnalyzer", "org.xms.g.vision.barcode.BarcodeDetector");
        map.put("com.google.android.gms.safetynet.SafetyNetApi.AttestationResponse", "org.xms.g.safetynet.SafetyNetApi$AttestationResponse");
        map.put("com.huawei.hms.support.api.entity.safetydetect.SysIntegrityResp", "org.xms.g.safetynet.SafetyNetApi$AttestationResponse");
        map.put("com.google.android.gms.maps.GoogleMap.OnCameraMoveStartedListener", "org.xms.g.maps.ExtensionMap$OnCameraMoveStartedListener$XImpl");
        map.put("com.huawei.hms.maps.HuaweiMap.OnCameraMoveStartedListener", "org.xms.g.maps.ExtensionMap$OnCameraMoveStartedListener$XImpl");
        map.put("com.google.firebase.ml.common.modeldownload.FirebaseLocalModel.Builder", "org.xms.f.ml.common.modeldownload.FirebaseLocalModel$Builder");
        map.put("com.google.android.gms.ads.reward.RewardItem", "org.xms.g.ads.reward.RewardItem$XImpl");
        map.put("com.huawei.hms.ads.reward.Reward", "org.xms.g.ads.reward.RewardItem$XImpl");
        map.put("com.google.android.gms.maps.model.LatLng", "org.xms.g.maps.model.LatLng");
        map.put("com.huawei.hms.maps.model.LatLng", "org.xms.g.maps.model.LatLng");
        map.put("com.google.android.gms.auth.api.credentials.Credentials", "org.xms.g.auth.api.credentials.Credentials");
        map.put("com.google.android.gms.games.snapshot.SnapshotEntity", "org.xms.g.games.snapshot.SnapshotEntity");
        map.put("com.huawei.hms.jos.games.archive.ArchiveImpl", "org.xms.g.games.snapshot.SnapshotEntity");
        map.put("com.google.android.gms.maps.GoogleMap.OnPolygonClickListener", "org.xms.g.maps.ExtensionMap$OnPolygonClickListener$XImpl");
        map.put("com.huawei.hms.maps.HuaweiMap.OnPolygonClickListener", "org.xms.g.maps.ExtensionMap$OnPolygonClickListener$XImpl");
        map.put("com.google.android.gms.location.ActivityTransition", "org.xms.g.location.ActivityTransition");
        map.put("com.huawei.hms.location.ActivityConversionInfo", "org.xms.g.location.ActivityTransition");
        map.put("com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener", "org.xms.g.maps.ExtensionMap$OnInfoWindowClickListener$XImpl");
        map.put("com.huawei.hms.maps.HuaweiMap.OnInfoWindowClickListener", "org.xms.g.maps.ExtensionMap$OnInfoWindowClickListener$XImpl");
        map.put("com.google.android.gms.games.PlayerLevelInfo", "org.xms.g.games.PlayerLevelInfo");
        map.put("com.google.android.gms.ads.MediaAspectRatio", "org.xms.g.ads.MediaAspectRatio");
        map.put("com.huawei.hms.ads.nativead.NativeAdConfiguration.MediaAspect", "org.xms.g.ads.MediaAspectRatio");
        map.put("com.google.android.gms.actions.ReserveIntents", "org.xms.g.actions.ReserveIntents");
        map.put("com.google.android.gms.wallet.CreateWalletObjectsRequest.Builder", "org.xms.g.wallet.CreateWalletObjectsRequest$Builder");
        map.put("com.google.android.gms.common.data.DataBufferUtils", "org.xms.g.common.data.DataBufferUtils");
        map.put("com.huawei.hms.common.data.DataBufferUtils", "org.xms.g.common.data.DataBufferUtils");
        map.put("com.google.android.gms.wallet.AutoResolvableVoidResult", "org.xms.g.wallet.AutoResolvableVoidResult");
        map.put("com.huawei.hms.wallet.AutoResolvableForegroundIntentResult", "org.xms.g.wallet.AutoResolvableVoidResult");
        map.put("com.google.android.gms.wallet.PaymentsClient", "org.xms.g.wallet.PaymentsClient");
        map.put("com.google.android.gms.maps.StreetViewPanorama.OnStreetViewPanoramaChangeListener", "org.xms.g.maps.StreetViewPanorama$OnStreetViewPanoramaChangeListener$XImpl");
        map.put("com.google.android.gms.gcm.Task", "org.xms.g.gcm.Task");
        map.put("com.google.android.gms.common.api.GoogleApiClient", "org.xms.g.common.api.ExtensionApiClient$XImpl");
        map.put("com.huawei.hms.api.HuaweiApiClient", "org.xms.g.common.api.ExtensionApiClient$XImpl");
        map.put("com.google.android.gms.nearby.connection.Connections", "org.xms.g.nearby.connection.Connections$XImpl");
        map.put("com.google.android.gms.ads.mediation.customevent.CustomEvent", "org.xms.g.ads.mediation.customevent.CustomEvent$XImpl");
        map.put("com.google.android.gms.nearby.connection.AppMetadata", "org.xms.g.nearby.connection.AppMetadata");
        map.put("com.google.android.gms.maps.model.TileOverlay", "org.xms.g.maps.model.TileOverlay");
        map.put("com.huawei.hms.maps.model.TileOverlay", "org.xms.g.maps.model.TileOverlay");
        map.put("com.google.android.gms.auth.UserRecoverableNotifiedException", "org.xms.g.auth.UserRecoverableNotifiedException");
        map.put("com.google.android.gms.games.event.Events", "org.xms.g.games.event.Events$XImpl");
        map.put("com.google.android.gms.identity.intents.Address.AddressOptions", "org.xms.g.identity.intents.Address$AddressOptions");
        map.put("com.google.firebase.ml.vision.common.FirebaseVisionImageMetadata", "org.xms.f.ml.vision.common.FirebaseVisionImageMetadata");
        map.put("com.huawei.hms.mlsdk.common.MLFrame.Property", "org.xms.f.ml.vision.common.FirebaseVisionImageMetadata");
        map.put("com.google.firebase.analytics.FirebaseAnalytics", "org.xms.f.analytics.FirebaseAnalytics");
        map.put("com.huawei.hms.analytics.HiAnalyticsInstance", "org.xms.f.analytics.FirebaseAnalytics");
        map.put("com.google.android.gms.games.video.Videos.CaptureCapabilitiesResult", "org.xms.g.games.video.Videos$CaptureCapabilitiesResult$XImpl");
        map.put("com.google.firebase.ml.vision.objects.FirebaseVisionObjectDetector", "org.xms.f.ml.vision.objects.FirebaseVisionObjectDetector");
        map.put("com.huawei.hms.mlsdk.objects.MLObjectAnalyzer", "org.xms.f.ml.vision.objects.FirebaseVisionObjectDetector");
        map.put("com.google.android.gms.ads.mediation.admob.AdMobExtras", "org.xms.g.ads.mediation.admob.AdMobExtras");
        map.put("com.google.android.gms.fitness.request.DataUpdateRequest.Builder", "org.xms.g.fitness.request.DataUpdateRequest$Builder");
        map.put("com.huawei.hms.hihealth.options.UpdateOptions.Builder", "org.xms.g.fitness.request.DataUpdateRequest$Builder");
        map.put("com.google.firebase.ml.naturallanguage.smartreply.FirebaseSmartReply", "org.xms.f.ml.naturallanguage.smartreply.FirebaseSmartReply");
        map.put("com.google.android.gms.games.NotificationsClient", "org.xms.g.games.NotificationsClient");
        map.put("com.google.android.gms.fitness.RecordingApi", "org.xms.g.fitness.RecordingApi$XImpl");
        map.put("com.google.android.gms.maps.GoogleMap.OnCameraIdleListener", "org.xms.g.maps.ExtensionMap$OnCameraIdleListener$XImpl");
        map.put("com.huawei.hms.maps.HuaweiMap.OnCameraIdleListener", "org.xms.g.maps.ExtensionMap$OnCameraIdleListener$XImpl");
        map.put("com.google.android.gms.fitness.data.Goal.Recurrence", "org.xms.g.fitness.data.Goal$Recurrence");
        map.put("com.google.android.gms.auth.AccountChangeEvent", "org.xms.g.auth.AccountChangeEvent");
        map.put("com.google.android.gms.games.multiplayer.InvitationEntity", "org.xms.g.games.multiplayer.InvitationEntity");
        map.put("com.google.android.gms.location.ActivityRecognitionApi", "org.xms.g.location.ActivityRecognitionApi$XImpl");
        map.put("com.google.firebase.ml.naturallanguage.smartreply.FirebaseTextMessage", "org.xms.f.ml.naturallanguage.smartreply.FirebaseTextMessage");
        map.put("com.google.android.gms.ads.AdListener", "org.xms.g.ads.AdListener");
        map.put("com.huawei.hms.ads.AdListener", "org.xms.g.ads.AdListener");
        map.put("com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult", "org.xms.g.games.leaderboard.Leaderboards$LeaderboardMetadataResult$XImpl");
        map.put("com.google.android.gms.vision.barcode.Barcode.ContactInfo", "org.xms.g.vision.barcode.Barcode$ContactInfo");
        map.put("com.huawei.hms.ml.scan.HmsScan.ContactDetail", "org.xms.g.vision.barcode.Barcode$ContactInfo");
        map.put("com.android.installreferrer.api.InstallReferrerStateListener", "org.xms.installreferrer.api.InstallReferrerStateListener$XImpl");
        map.put("com.huawei.hms.ads.installreferrer.api.InstallReferrerStateListener", "org.xms.installreferrer.api.InstallReferrerStateListener$XImpl");
        map.put("com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener", "org.xms.g.ads.formats.NativeContentAd$OnContentAdLoadedListener$XImpl");
        map.put("com.google.android.gms.maps.MapFragment", "org.xms.g.maps.MapFragment");
        map.put("com.google.android.gms.nearby.connection.DiscoveredEndpointInfo", "org.xms.g.nearby.connection.DiscoveredEndpointInfo");
        map.put("com.huawei.hms.nearby.discovery.ScanEndpointInfo", "org.xms.g.nearby.connection.DiscoveredEndpointInfo");
        map.put("com.google.android.gms.auth.api.signin.GoogleSignInClient", "org.xms.g.auth.api.signin.ExtensionSignInClient");
        map.put("com.huawei.hms.support.hwid.service.HuaweiIdAuthService", "org.xms.g.auth.api.signin.ExtensionSignInClient");
        map.put("com.google.android.gms.vision.text.TextBlock", "org.xms.g.vision.text.TextBlock");
        map.put("com.huawei.hms.mlsdk.text.MLText.Block", "org.xms.g.vision.text.TextBlock");
        map.put("com.google.firebase.ml.naturallanguage.languageid.FirebaseLanguageIdentificationOptions", "org.xms.f.ml.naturallanguage.languageid.FirebaseLanguageIdentificationOptions");
        map.put("com.google.android.gms.auth.api.signin.GoogleSignInApi", "org.xms.g.auth.api.signin.ExtensionSignInApi$XImpl");
        map.put("com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService", "org.xms.g.auth.api.signin.ExtensionSignInApi$XImpl");
        map.put("com.google.android.gms.awareness.snapshot.PlacesResult", "org.xms.g.awareness.snapshot.PlacesResult$XImpl");
        map.put("com.google.android.gms.fitness.FitnessOptions.Builder", "org.xms.g.fitness.FitnessOptions$Builder");
        map.put("com.huawei.hms.hihealth.HiHealthOptions.Builder", "org.xms.g.fitness.FitnessOptions$Builder");
        map.put("com.google.android.gms.ads.doubleclick.PublisherAdRequest", "org.xms.g.ads.doubleclick.PublisherAdRequest");
        map.put("com.google.android.gms.safetynet.SafetyNetApi.RecaptchaTokenResult", "org.xms.g.safetynet.SafetyNetApi$RecaptchaTokenResult$XImpl");
        map.put("com.google.android.gms.ads.mediation.NativeContentAdMapper", "org.xms.g.ads.mediation.NativeContentAdMapper");
        map.put("com.google.android.gms.ads.VideoOptions", "org.xms.g.ads.VideoOptions");
        map.put("com.huawei.hms.ads.VideoConfiguration", "org.xms.g.ads.VideoOptions");
        map.put("com.google.android.gms.vision.face.Contour", "org.xms.g.vision.face.Contour");
        map.put("com.huawei.hms.mlsdk.face.MLFaceShape", "org.xms.g.vision.face.Contour");
        map.put("com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult", "org.xms.g.games.achievement.Achievements$LoadAchievementsResult$XImpl");
        map.put("com.google.android.gms.fitness.request.SessionReadRequest.Builder", "org.xms.g.fitness.request.SessionReadRequest$Builder");
        map.put("com.huawei.hms.hihealth.options.ActivityRecordReadOptions.Builder", "org.xms.g.fitness.request.SessionReadRequest$Builder");
        map.put("com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult", "org.xms.g.games.snapshot.Snapshots$DeleteSnapshotResult$XImpl");
        map.put("com.google.android.gms.location.places.PlaceLikelihood", "org.xms.g.location.places.PlaceLikelihood");
        map.put("com.google.android.gms.tasks.TaskCompletionSource", "org.xms.g.tasks.TaskCompletionSource");
        map.put("com.huawei.hmf.tasks.TaskCompletionSource", "org.xms.g.tasks.TaskCompletionSource");
        map.put("com.google.firebase.iid.FirebaseInstanceIdReceiver", "org.xms.f.iid.FirebaseInstanceIdReceiver");
        map.put("com.google.android.gms.games.VideosClient.OnCaptureOverlayStateListener", "org.xms.g.games.VideosClient$OnCaptureOverlayStateListener$XImpl");
        map.put("com.google.android.gms.measurement.AppMeasurementService", "org.xms.g.measurement.AppMeasurementService");
        map.put("com.google.android.gms.games.AnnotatedData", "org.xms.g.games.AnnotatedData");
        map.put("com.google.android.gms.games.leaderboard.Leaderboards", "org.xms.g.games.leaderboard.Leaderboards$XImpl");
        map.put("com.google.android.gms.gcm.GcmNetworkManager", "org.xms.g.gcm.GcmNetworkManager");
        map.put("com.google.android.gms.ads.mediation.customevent.CustomEventInterstitialListener", "org.xms.g.ads.mediation.customevent.CustomEventInterstitialListener$XImpl");
        map.put("com.google.android.gms.nearby.messages.NearbyMessagesStatusCodes", "org.xms.g.nearby.messages.NearbyMessagesStatusCodes");
        map.put("com.huawei.hms.nearby.StatusCode", "org.xms.g.nearby.messages.NearbyMessagesStatusCodes");
        map.put("com.google.android.gms.ads.AdView", "org.xms.g.ads.AdView");
        map.put("com.huawei.hms.ads.banner.BannerView", "org.xms.g.ads.AdView");
        map.put("com.google.android.gms.maps.model.StreetViewPanoramaCamera.Builder", "org.xms.g.maps.model.StreetViewPanoramaCamera$Builder");
        map.put("com.google.android.gms.vision.Frame.Metadata", "org.xms.g.vision.Frame$Metadata");
        map.put("com.huawei.hms.mlsdk.common.MLFrame.Property", "org.xms.g.vision.Frame$Metadata");
        map.put("com.google.firebase.ml.common.modeldownload.FirebaseModelManager", "org.xms.f.ml.common.modeldownload.FirebaseModelManager");
        map.put("com.google.firebase.ml.vision.face.FirebaseVisionFaceDetectorOptions.Builder", "org.xms.f.ml.vision.face.FirebaseVisionFaceDetectorOptions$Builder");
        map.put("com.huawei.hms.mlsdk.face.MLFaceAnalyzerSetting.Factory", "org.xms.f.ml.vision.face.FirebaseVisionFaceDetectorOptions$Builder");
        map.put("com.google.android.gms.maps.model.PointOfInterest", "org.xms.g.maps.model.PointOfInterest");
        map.put("com.huawei.hms.maps.model.PointOfInterest", "org.xms.g.maps.model.PointOfInterest");
        map.put("com.google.android.gms.nearby.connection.AdvertisingOptions.Builder", "org.xms.g.nearby.connection.AdvertisingOptions$Builder");
        map.put("com.huawei.hms.nearby.discovery.BroadcastOption.Builder", "org.xms.g.nearby.connection.AdvertisingOptions$Builder");
        map.put("com.google.android.gms.games.multiplayer.realtime.RoomEntity", "org.xms.g.games.multiplayer.realtime.RoomEntity");
        map.put("com.google.android.gms.ads.instream.InstreamAdView", "org.xms.g.ads.instream.InstreamAdView");
        map.put("com.google.android.gms.wallet.wobs.LoyaltyPointsBalance.Type", "org.xms.g.wallet.wobs.LoyaltyPointsBalance$Type$XImpl");
        map.put("com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchEntity", "org.xms.g.games.multiplayer.turnbased.TurnBasedMatchEntity");
        map.put("com.google.android.gms.nearby.connection.Strategy", "org.xms.g.nearby.connection.Strategy");
        map.put("com.huawei.hms.nearby.discovery.Policy", "org.xms.g.nearby.connection.Strategy");
        map.put("com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer", "org.xms.g.games.multiplayer.turnbased.TurnBasedMultiplayer$XImpl");
        map.put("com.google.android.gms.common.data.DataBufferObserver", "org.xms.g.common.data.DataBufferObserver$XImpl");
        map.put("com.huawei.hms.common.data.DataBufferObserver", "org.xms.g.common.data.DataBufferObserver$XImpl");
        map.put("com.google.firebase.messaging.RemoteMessage.Notification", "org.xms.f.messaging.RemoteMessage$Notification");
        map.put("com.huawei.hms.push.RemoteMessage.Notification", "org.xms.f.messaging.RemoteMessage$Notification");
        map.put("com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener", "org.xms.g.ads.formats.NativeAppInstallAd$OnAppInstallAdLoadedListener$XImpl");
        map.put("com.google.android.gms.ads.identifier.AdvertisingIdClient.Info", "org.xms.g.ads.identifier.AdvertisingIdClient$Info");
        map.put("com.huawei.hms.ads.identifier.AdvertisingIdClient.Info", "org.xms.g.ads.identifier.AdvertisingIdClient$Info");
        map.put("com.google.android.gms.wallet.wobs.LoyaltyPointsBalance", "org.xms.g.wallet.wobs.LoyaltyPointsBalance");
        map.put("com.google.android.gms.wallet.InstrumentInfo", "org.xms.g.wallet.InstrumentInfo");
        map.put("com.google.android.gms.games.video.Videos.CaptureStateResult", "org.xms.g.games.video.Videos$CaptureStateResult$XImpl");
        map.put("com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult", "org.xms.g.games.snapshot.Snapshots$OpenSnapshotResult$XImpl");
        map.put("com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult", "org.xms.g.games.leaderboard.Leaderboards$LoadScoresResult$XImpl");
        map.put("com.google.android.gms.ads.formats.UnifiedNativeAd.MediaContent", "org.xms.g.ads.formats.UnifiedNativeAd$MediaContent$XImpl");
        map.put("com.huawei.hms.ads.nativead.MediaContent", "org.xms.g.ads.formats.UnifiedNativeAd$MediaContent$XImpl");
        map.put("com.google.firebase.FirebaseException", "org.xms.f.FirebaseException");
        map.put("com.google.android.gms.common.images.WebImage", "org.xms.g.common.images.WebImage");
        map.put("com.huawei.hms.common.webserverpic.WebServerPic", "org.xms.g.common.images.WebImage");
        map.put("com.google.android.gms.auth.api.credentials.HintRequest", "org.xms.g.auth.api.credentials.HintRequest");
        map.put("com.google.android.gms.maps.StreetViewPanoramaView", "org.xms.g.maps.StreetViewPanoramaView");
        map.put("com.google.android.gms.fitness.FitnessActivities", "org.xms.g.fitness.FitnessActivities");
        map.put("com.huawei.hms.hihealth.HiHealthActivities", "org.xms.g.fitness.FitnessActivities");
        map.put("com.google.android.gms.vision.MultiProcessor.Factory", "org.xms.g.vision.MultiProcessor$Factory$XImpl");
        map.put("com.huawei.hms.mlsdk.common.MLCompositeTransactor.TrailerFactory", "org.xms.g.vision.MultiProcessor$Factory$XImpl");
        map.put("com.google.android.gms.location.LocationCallback", "org.xms.g.location.LocationCallback");
        map.put("com.huawei.hms.location.LocationCallback", "org.xms.g.location.LocationCallback");
        map.put("com.google.android.gms.maps.model.GroundOverlay", "org.xms.g.maps.model.GroundOverlay");
        map.put("com.google.android.gms.nearby.messages.IBeaconId", "org.xms.g.nearby.messages.IBeaconId");
        map.put("com.huawei.hms.nearby.message.BeaconId", "org.xms.g.nearby.messages.IBeaconId");
        map.put("com.google.android.gms.wallet.GiftCardWalletObject", "org.xms.g.wallet.GiftCardWalletObject");
        map.put("com.huawei.hms.wallet.pass.PassObject", "org.xms.g.wallet.GiftCardWalletObject");
        map.put("com.google.android.gms.maps.model.GroundOverlayOptions", "org.xms.g.maps.model.GroundOverlayOptions");
        map.put("com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration", "org.xms.g.ads.mediation.MediationInterstitialAdConfiguration");
        map.put("com.google.android.gms.auth.api.Auth.AuthCredentialsOptions", "org.xms.g.auth.api.Auth$AuthCredentialsOptions");
        map.put("com.google.android.gms.common.images.ImageManager", "org.xms.g.common.images.ImageManager");
        map.put("com.google.android.gms.common.GooglePlayServicesNotAvailableException", "org.xms.g.common.ExtensionPlayServicesNotAvailableException");
        map.put("com.huawei.hms.api.HuaweiServicesNotAvailableException", "org.xms.g.common.ExtensionPlayServicesNotAvailableException");
        map.put("com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer", "org.xms.g.games.multiplayer.turnbased.TurnBasedMatchBuffer");
        map.put("com.google.android.gms.games.GamesMetadata.LoadGamesResult", "org.xms.g.games.GamesMetadata$LoadGamesResult$XImpl");
        map.put("com.google.android.gms.ads.search.SearchAdRequest.Builder", "org.xms.g.ads.search.SearchAdRequest$Builder");
        map.put("com.google.android.gms.maps.model.RoundCap", "org.xms.g.maps.model.RoundCap");
        map.put("com.huawei.hms.maps.model.RoundCap", "org.xms.g.maps.model.RoundCap");
        map.put("com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback", "org.xms.g.games.multiplayer.realtime.RealTimeMultiplayer$ReliableMessageSentCallback$XImpl");
        map.put("com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener", "org.xms.g.ads.formats.NativeCustomTemplateAd$OnCustomTemplateAdLoadedListener$XImpl");
        map.put("com.google.android.gms.awareness.state.TimeIntervals", "org.xms.g.awareness.state.TimeIntervals$XImpl");
        map.put("com.huawei.hms.kit.awareness.status.TimeCategories", "org.xms.g.awareness.state.TimeIntervals$XImpl");
        map.put("com.google.android.gms.vision.barcode.Barcode.Address", "org.xms.g.vision.barcode.Barcode$Address");
        map.put("com.huawei.hms.ml.scan.HmsScan.AddressInfo", "org.xms.g.vision.barcode.Barcode$Address");
        map.put("com.google.android.gms.common.GooglePlayServicesRepairableException", "org.xms.g.common.ExtensionPlayServicesRepairableException");
        map.put("com.huawei.hms.api.HuaweiServicesRepairableException", "org.xms.g.common.ExtensionPlayServicesRepairableException");
        map.put("com.google.android.gms.common.api.ResolvableApiException", "org.xms.g.common.api.ResolvableApiException");
        map.put("com.huawei.hms.common.ResolvableApiException", "org.xms.g.common.api.ResolvableApiException");
        map.put("com.google.android.gms.maps.model.PatternItem", "org.xms.g.maps.model.PatternItem");
        map.put("com.huawei.hms.maps.model.PatternItem", "org.xms.g.maps.model.PatternItem");
        map.put("com.google.android.gms.fitness.data.DataPoint", "org.xms.g.fitness.data.DataPoint");
        map.put("com.huawei.hms.hihealth.data.SamplePoint", "org.xms.g.fitness.data.DataPoint");
        map.put("com.google.android.gms.ads.mediation.MediationAdCallback", "org.xms.g.ads.mediation.MediationAdCallback$XImpl");
        map.put("com.google.android.gms.tasks.OnTokenCanceledListener", "org.xms.g.tasks.OnTokenCanceledListener$XImpl");
        map.put("com.google.android.gms.games.multiplayer.realtime.OnRealTimeMessageReceivedListener", "org.xms.g.games.multiplayer.realtime.OnRealTimeMessageReceivedListener$XImpl");
        map.put("com.google.android.gms.analytics.HitBuilders.TimingBuilder", "org.xms.g.analytics.HitBuilders$TimingBuilder");
        map.put("com.google.android.gms.maps.GoogleMap.SnapshotReadyCallback", "org.xms.g.maps.ExtensionMap$SnapshotReadyCallback$XImpl");
        map.put("com.huawei.hms.maps.HuaweiMap.SnapshotReadyCallback", "org.xms.g.maps.ExtensionMap$SnapshotReadyCallback$XImpl");
        map.put("com.google.firebase.ml.vision.label.FirebaseVisionOnDeviceAutoMLImageLabelerOptions.Builder", "org.xms.f.ml.vision.label.FirebaseVisionOnDeviceAutoMLImageLabelerOptions$Builder");
        map.put("com.google.android.gms.fitness.data.Goal.FrequencyObjective", "org.xms.g.fitness.data.Goal$FrequencyObjective");
        map.put("com.google.android.gms.auth.api.accounttransfer.DeviceMetaData", "org.xms.g.auth.api.accounttransfer.DeviceMetaData");
        map.put("com.google.android.gms.games.Players.LoadPlayersResult", "org.xms.g.games.Players$LoadPlayersResult$XImpl");
        map.put("com.google.android.gms.fitness.request.DataSourcesRequest.Builder", "org.xms.g.fitness.request.DataSourcesRequest$Builder");
        map.put("com.huawei.hms.hihealth.options.DataCollectorsOptions.Builder", "org.xms.g.fitness.request.DataSourcesRequest$Builder");
        map.put("com.google.android.gms.maps.model.LatLngBounds", "org.xms.g.maps.model.LatLngBounds");
        map.put("com.huawei.hms.maps.model.LatLngBounds", "org.xms.g.maps.model.LatLngBounds");
        map.put("com.google.android.gms.analytics.AnalyticsService", "org.xms.g.analytics.AnalyticsService");
        map.put("com.google.android.gms.fitness.data.DataPoint.Builder", "org.xms.g.fitness.data.DataPoint$Builder");
        map.put("com.huawei.hms.hihealth.data.SamplePoint.Builder", "org.xms.g.fitness.data.DataPoint$Builder");
        map.put("com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult", "org.xms.g.games.multiplayer.turnbased.TurnBasedMultiplayer$LoadMatchResult$XImpl");
        map.put("com.google.android.gms.location.GeofencingRequest", "org.xms.g.location.GeofencingRequest");
        map.put("com.huawei.hms.location.GeofenceRequest", "org.xms.g.location.GeofencingRequest");
        map.put("com.google.android.gms.ads.AdRequest.Builder", "org.xms.g.ads.AdRequest$Builder");
        map.put("com.huawei.hms.ads.AdParam.Builder", "org.xms.g.ads.AdRequest$Builder");
        map.put("com.google.android.gms.fitness.request.DataTypeCreateRequest.Builder", "org.xms.g.fitness.request.DataTypeCreateRequest$Builder");
        map.put("com.huawei.hms.hihealth.options.DataTypeAddOptions.Builder", "org.xms.g.fitness.request.DataTypeCreateRequest$Builder");
        map.put("com.google.android.gms.analytics.ExceptionParser", "org.xms.g.analytics.ExceptionParser$XImpl");
        map.put("com.google.android.gms.fitness.request.SessionInsertRequest.Builder", "org.xms.g.fitness.request.SessionInsertRequest$Builder");
        map.put("com.huawei.hms.hihealth.options.ActivityRecordInsertOptions.Builder", "org.xms.g.fitness.request.SessionInsertRequest$Builder");
        map.put("com.google.firebase.ml.vision.label.FirebaseVisionImageLabeler", "org.xms.f.ml.vision.label.FirebaseVisionImageLabeler");
        map.put("com.huawei.hms.mlsdk.classification.MLImageClassificationAnalyzer", "org.xms.f.ml.vision.label.FirebaseVisionImageLabeler");
        map.put("com.google.android.gms.auth.api.credentials.CredentialsClient", "org.xms.g.auth.api.credentials.CredentialsClient");
        map.put("com.google.android.gms.vision.MultiDetector", "org.xms.g.vision.MultiDetector");
        map.put("com.huawei.hms.mlsdk.common.MLCompositeAnalyzer", "org.xms.g.vision.MultiDetector");
        map.put("com.google.firebase.ml.vision.label.FirebaseVisionImageLabel", "org.xms.f.ml.vision.label.FirebaseVisionImageLabel");
        map.put("com.huawei.hms.mlsdk.classification.MLImageClassification", "org.xms.f.ml.vision.label.FirebaseVisionImageLabel");
        map.put("com.google.firebase.ml.vision.document.FirebaseVisionDocumentText.Word", "org.xms.f.ml.vision.document.FirebaseVisionDocumentText$Word");
        map.put("com.huawei.hms.mlsdk.document.MLDocument.Word", "org.xms.f.ml.vision.document.FirebaseVisionDocumentText$Word");
        map.put("com.google.firebase.messaging.RemoteMessage", "org.xms.f.messaging.RemoteMessage");
        map.put("com.huawei.hms.push.RemoteMessage", "org.xms.f.messaging.RemoteMessage");
        map.put("com.google.android.gms.awareness.Awareness", "org.xms.g.awareness.Awareness");
        map.put("com.huawei.hms.kit.awareness.Awareness", "org.xms.g.awareness.Awareness");
        map.put("com.google.android.gms.maps.model.Polygon", "org.xms.g.maps.model.Polygon");
        map.put("com.huawei.hms.maps.model.Polygon", "org.xms.g.maps.model.Polygon");
        map.put("com.google.android.gms.location.LocationSettingsStates", "org.xms.g.location.LocationSettingsStates");
        map.put("com.huawei.hms.location.LocationSettingsStates", "org.xms.g.location.LocationSettingsStates");
        map.put("com.google.firebase.ml.vision.label.FirebaseVisionCloudImageLabelerOptions.Builder", "org.xms.f.ml.vision.label.FirebaseVisionCloudImageLabelerOptions$Builder");
        map.put("com.huawei.hms.mlsdk.classification.MLRemoteClassificationAnalyzerSetting.Factory", "org.xms.f.ml.vision.label.FirebaseVisionCloudImageLabelerOptions$Builder");
        map.put("com.google.android.gms.nearby.messages.Strategy.Builder", "org.xms.g.nearby.messages.Strategy$Builder");
        map.put("com.huawei.hms.nearby.message.Policy.Builder", "org.xms.g.nearby.messages.Strategy$Builder");
        map.put("com.google.android.gms.awareness.state.BeaconState", "org.xms.g.awareness.state.BeaconState$XImpl");
        map.put("com.huawei.hms.kit.awareness.status.BeaconStatus", "org.xms.g.awareness.state.BeaconState$XImpl");
        map.put("com.google.android.gms.ads.mediation.InitializationCompleteCallback", "org.xms.g.ads.mediation.InitializationCompleteCallback$XImpl");
        map.put("com.google.android.gms.ads.VideoController", "org.xms.g.ads.VideoController");
        map.put("com.huawei.hms.ads.VideoOperator", "org.xms.g.ads.VideoController");
        map.put("com.google.android.gms.nearby.connection.Connections.ConnectionResponseCallback", "org.xms.g.nearby.connection.Connections$ConnectionResponseCallback$XImpl");
        map.put("com.google.android.gms.maps.model.CircleOptions", "org.xms.g.maps.model.CircleOptions");
        map.put("com.huawei.hms.maps.model.CircleOptions", "org.xms.g.maps.model.CircleOptions");
        map.put("com.google.android.gms.wallet.IsReadyToPayRequest", "org.xms.g.wallet.IsReadyToPayRequest");
        map.put("com.google.android.gms.games.video.VideoCapabilities", "org.xms.g.games.video.VideoCapabilities");
        map.put("com.google.android.gms.wallet.AutoResolvableResult", "org.xms.g.wallet.AutoResolvableResult$XImpl");
        map.put("com.huawei.hms.wallet.IResolvableTaskResult", "org.xms.g.wallet.AutoResolvableResult$XImpl");
        map.put("com.google.android.gms.games.GamesClientStatusCodes", "org.xms.g.games.GamesClientStatusCodes");
        map.put("com.huawei.hms.jos.games.GamesStatusCodes", "org.xms.g.games.GamesClientStatusCodes");
        map.put("com.google.android.gms.fitness.data.HealthDataTypes", "org.xms.g.fitness.data.HealthDataTypes");
        map.put("com.huawei.hms.hihealth.data.HealthDataTypes", "org.xms.g.fitness.data.HealthDataTypes");
        map.put("com.google.android.gms.gcm.TaskParams", "org.xms.g.gcm.TaskParams");
        map.put("com.google.android.gms.common.api.UnsupportedApiCallException", "org.xms.g.common.api.UnsupportedApiCallException");
        map.put("com.huawei.hms.common.api.UnsupportedApiCallException", "org.xms.g.common.api.UnsupportedApiCallException");
        map.put("com.google.firebase.ml.common.modeldownload.FirebaseLocalModel", "org.xms.f.ml.common.modeldownload.FirebaseLocalModel");
        map.put("com.google.android.gms.games.multiplayer.InvitationBuffer", "org.xms.g.games.multiplayer.InvitationBuffer");
        map.put("com.google.firebase.ml.vision.document.FirebaseVisionCloudDocumentRecognizerOptions.Builder", "org.xms.f.ml.vision.document.FirebaseVisionCloudDocumentRecognizerOptions$Builder");
        map.put("com.huawei.hms.mlsdk.document.MLDocumentSetting.Factory", "org.xms.f.ml.vision.document.FirebaseVisionCloudDocumentRecognizerOptions$Builder");
        map.put("com.google.android.gms.analytics.ecommerce.Promotion", "org.xms.g.analytics.ecommerce.Promotion");
        map.put("com.google.android.gms.actions.SearchIntents", "org.xms.g.actions.SearchIntents");
        map.put("com.huawei.hms.actions.SearchIntents", "org.xms.g.actions.SearchIntents");
        map.put("com.google.firebase.ml.vision.face.FirebaseVisionFaceContour", "org.xms.f.ml.vision.face.FirebaseVisionFaceContour");
        map.put("com.huawei.hms.mlsdk.face.MLFaceShape", "org.xms.f.ml.vision.face.FirebaseVisionFaceContour");
        map.put("com.google.android.gms.wallet.wobs.LoyaltyPoints", "org.xms.g.wallet.wobs.LoyaltyPoints");
        map.put("com.google.android.gms.vision.CameraSource.PictureCallback", "org.xms.g.vision.CameraSource$PictureCallback$XImpl");
        map.put("com.huawei.hms.mlsdk.common.LensEngine.PhotographListener", "org.xms.g.vision.CameraSource$PictureCallback$XImpl");
        map.put("com.google.android.gms.maps.model.StreetViewSource", "org.xms.g.maps.model.StreetViewSource");
        map.put("com.google.firebase.messaging.FirebaseMessaging", "org.xms.f.messaging.FirebaseMessaging");
        map.put("com.huawei.hms.push.HmsMessaging", "org.xms.f.messaging.FirebaseMessaging");
        map.put("com.google.android.gms.games.snapshot.SnapshotMetadataBuffer", "org.xms.g.games.snapshot.SnapshotMetadataBuffer");
        map.put("com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult", "org.xms.g.games.snapshot.Snapshots$CommitSnapshotResult$XImpl");
        map.put("com.google.firebase.iid.FirebaseInstanceId", "org.xms.f.iid.FirebaseInstanceId");
        map.put("com.huawei.hms.aaid.HmsInstanceId", "org.xms.f.iid.FirebaseInstanceId");
        map.put("com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult", "org.xms.g.games.leaderboard.Leaderboards$SubmitScoreResult$XImpl");
        map.put("com.google.firebase.ml.vision.document.FirebaseVisionDocumentText.Block", "org.xms.f.ml.vision.document.FirebaseVisionDocumentText$Block");
        map.put("com.huawei.hms.mlsdk.document.MLDocument.Block", "org.xms.f.ml.vision.document.FirebaseVisionDocumentText$Block");
        map.put("com.google.firebase.messaging.SendException", "org.xms.f.messaging.SendException");
        map.put("com.huawei.hms.push.SendException", "org.xms.f.messaging.SendException");
        map.put("com.google.android.gms.auth.api.phone.SmsRetrieverApi", "org.xms.g.auth.api.phone.SmsRetrieverApi$XImpl");
        map.put("com.google.android.gms.awareness.fence.BeaconFence", "org.xms.g.awareness.fence.BeaconFence");
        map.put("com.huawei.hms.kit.awareness.barrier.BeaconBarrier", "org.xms.g.awareness.fence.BeaconFence");
        map.put("com.google.android.gms.games.multiplayer.Participant", "org.xms.g.games.multiplayer.Participant$XImpl");
        map.put("com.google.firebase.ml.naturallanguage.languageid.FirebaseLanguageIdentificationOptions.Builder", "org.xms.f.ml.naturallanguage.languageid.FirebaseLanguageIdentificationOptions$Builder");
        map.put("com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension", "org.xms.g.auth.api.signin.ExtensionSignInOptionsExtension$XImpl");
        map.put("com.huawei.hms.support.hwid.request.HuaweiIdAuthExtendedParams", "org.xms.g.auth.api.signin.ExtensionSignInOptionsExtension$XImpl");
        map.put("com.google.firebase.ml.common.FirebaseMLException", "org.xms.f.ml.common.FirebaseMLException");
        map.put("com.huawei.hms.mlsdk.common.MLException", "org.xms.f.ml.common.FirebaseMLException");
        map.put("com.google.android.gms.vision.CameraSource.ShutterCallback", "org.xms.g.vision.CameraSource$ShutterCallback$XImpl");
        map.put("com.huawei.hms.mlsdk.common.LensEngine.ShutterListener", "org.xms.g.vision.CameraSource$ShutterCallback$XImpl");
        map.put("com.google.android.gms.fitness.SessionsApi.ViewIntentBuilder", "org.xms.g.fitness.SessionsApi$ViewIntentBuilder");
        map.put("com.huawei.hms.hihealth.ActivityRecordsManager.GetIntentInfos", "org.xms.g.fitness.SessionsApi$ViewIntentBuilder");
        map.put("com.google.android.gms.fitness.FitnessStatusCodes", "org.xms.g.fitness.FitnessStatusCodes");
        map.put("com.huawei.hms.hihealth.HiHealthStatusCodes", "org.xms.g.fitness.FitnessStatusCodes");
        map.put("com.google.android.gms.safetynet.SafetyNetApi.RecaptchaTokenResponse", "org.xms.g.safetynet.SafetyNetApi$RecaptchaTokenResponse");
        map.put("com.huawei.hms.support.api.entity.safetydetect.UserDetectResponse", "org.xms.g.safetynet.SafetyNetApi$RecaptchaTokenResponse");
        map.put("com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo", "org.xms.g.ads.formats.NativeAd$AdChoicesInfo$XImpl");
        map.put("com.huawei.hms.ads.nativead.NativeAd.ChoicesInfo", "org.xms.g.ads.formats.NativeAd$AdChoicesInfo$XImpl");
        map.put("com.google.android.gms.games.event.EventEntity", "org.xms.g.games.event.EventEntity");
        map.put("com.huawei.hms.jos.games.event.Event", "org.xms.g.games.event.EventEntity");
        map.put("com.google.android.gms.wallet.CardRequirements", "org.xms.g.wallet.CardRequirements");
        map.put("com.google.android.gms.ads.instream.InstreamAd.InstreamAdLoadCallback", "org.xms.g.ads.instream.InstreamAd$InstreamAdLoadCallback$XImpl");
        map.put("com.google.android.gms.fitness.request.SensorRequest.Builder", "org.xms.g.fitness.request.SensorRequest$Builder");
        map.put("com.huawei.hms.hihealth.options.SensorOptions.Builder", "org.xms.g.fitness.request.SensorRequest$Builder");
        map.put("com.google.android.gms.auth.api.Auth.AuthCredentialsOptions.Builder", "org.xms.g.auth.api.Auth$AuthCredentialsOptions$Builder");
        map.put("com.google.android.gms.awareness.SnapshotApi", "org.xms.g.awareness.SnapshotApi$XImpl");
        map.put("com.google.android.gms.ads.mediation.OnContextChangedListener", "org.xms.g.ads.mediation.OnContextChangedListener$XImpl");
        map.put("com.google.android.gms.auth.AccountChangeEventsResponse", "org.xms.g.auth.AccountChangeEventsResponse");
        map.put("com.google.android.gms.fitness.result.ListSubscriptionsResult", "org.xms.g.fitness.result.ListSubscriptionsResult");
        map.put("com.huawei.hms.hihealth.result.ListRecordsResult", "org.xms.g.fitness.result.ListSubscriptionsResult");
        map.put("com.google.android.gms.games.event.Event", "org.xms.g.games.event.Event$XImpl");
        map.put("com.huawei.hms.jos.games.event.Event", "org.xms.g.games.event.Event$XImpl");
        map.put("com.google.android.gms.identity.intents.model.UserAddress", "org.xms.g.identity.intents.model.UserAddress");
        map.put("com.huawei.hms.identity.entity.UserAddress", "org.xms.g.identity.intents.model.UserAddress");
        map.put("com.google.android.gms.ads.mediation.customevent.CustomEventBanner", "org.xms.g.ads.mediation.customevent.CustomEventBanner$XImpl");
        map.put("com.google.android.gms.ads.doubleclick.PublisherInterstitialAd", "org.xms.g.ads.doubleclick.PublisherInterstitialAd");
        map.put("com.huawei.hms.ads.InterstitialAd", "org.xms.g.ads.doubleclick.PublisherInterstitialAd");
        map.put("com.google.android.gms.auth.api.credentials.CredentialPickerConfig.Prompt", "org.xms.g.auth.api.credentials.CredentialPickerConfig$Prompt");
        map.put("com.google.android.gms.fitness.HistoryClient", "org.xms.g.fitness.HistoryClient");
        map.put("com.huawei.hms.hihealth.DataController", "org.xms.g.fitness.HistoryClient");
        map.put("com.google.firebase.ml.naturallanguage.translate.FirebaseTranslator", "org.xms.f.ml.naturallanguage.translate.FirebaseTranslator");
        map.put("com.google.android.gms.gcm.Task.Builder", "org.xms.g.gcm.Task$Builder$XImpl");
        map.put("com.google.android.gms.fitness.FitnessOptions", "org.xms.g.fitness.FitnessOptions");
        map.put("com.huawei.hms.hihealth.HiHealthOptions", "org.xms.g.fitness.FitnessOptions");
        map.put("com.google.firebase.ml.naturallanguage.smartreply.SmartReplySuggestionResult", "org.xms.f.ml.naturallanguage.smartreply.SmartReplySuggestionResult");
        map.put("com.google.android.gms.auth.CookieUtil", "org.xms.g.auth.CookieUtil");
        map.put("com.huawei.hms.support.hwid.tools.NetworkTool", "org.xms.g.auth.CookieUtil");
        map.put("com.google.android.gms.ads.mediation.MediationAdRequest", "org.xms.g.ads.mediation.MediationAdRequest$XImpl");
        map.put("com.google.android.gms.common.api.Api.ApiOptions.NoOptions", "org.xms.g.common.api.Api$ApiOptions$NoOptions");
        map.put("com.huawei.hms.api.Api.ApiOptions.NoOptions", "org.xms.g.common.api.Api$ApiOptions$NoOptions");
        map.put("com.google.android.gms.wallet.ShippingAddressRequirements.Builder", "org.xms.g.wallet.ShippingAddressRequirements$Builder");
        map.put("com.google.android.gms.analytics.Tracker", "org.xms.g.analytics.Tracker");
        map.put("com.google.firebase.ml.vision.face.FirebaseVisionFaceDetector", "org.xms.f.ml.vision.face.FirebaseVisionFaceDetector");
        map.put("com.huawei.hms.mlsdk.face.MLFaceAnalyzer", "org.xms.f.ml.vision.face.FirebaseVisionFaceDetector");
        map.put("com.google.android.gms.location.GeofencingRequest.Builder", "org.xms.g.location.GeofencingRequest$Builder");
        map.put("com.huawei.hms.location.GeofenceRequest.Builder", "org.xms.g.location.GeofencingRequest$Builder");
        map.put("com.google.android.gms.nearby.connection.ConnectionsStatusCodes", "org.xms.g.nearby.connection.ConnectionsStatusCodes");
        map.put("com.huawei.hms.nearby.StatusCode", "org.xms.g.nearby.connection.ConnectionsStatusCodes");
        map.put("com.google.android.gms.maps.model.Cap", "org.xms.g.maps.model.Cap");
        map.put("com.huawei.hms.maps.model.Cap", "org.xms.g.maps.model.Cap");
        map.put("com.google.android.gms.nearby.messages.SubscribeOptions", "org.xms.g.nearby.messages.SubscribeOptions");
        map.put("com.huawei.hms.nearby.message.GetOption", "org.xms.g.nearby.messages.SubscribeOptions");
        map.put("com.google.android.gms.auth.api.credentials.HintRequest.Builder", "org.xms.g.auth.api.credentials.HintRequest$Builder");
        map.put("com.google.android.gms.analytics.Logger.LogLevel", "org.xms.g.analytics.Logger$LogLevel");
        map.put("com.google.android.gms.ads.AdLoader", "org.xms.g.ads.AdLoader");
        map.put("com.huawei.hms.ads.nativead.NativeAdLoader", "org.xms.g.ads.AdLoader");
        map.put("com.google.android.gms.ads.appopen.AppOpenAd", "org.xms.g.ads.appopen.AppOpenAd$XImpl");
        map.put("com.google.android.gms.common.Scopes", "org.xms.g.common.Scopes");
        map.put("com.google.android.gms.nearby.messages.Messages", "org.xms.g.nearby.messages.Messages$XImpl");
        map.put("com.huawei.hms.nearby.message.Messages", "org.xms.g.nearby.messages.Messages$XImpl");
        map.put("com.google.android.gms.common.api.BooleanResult", "org.xms.g.common.api.BooleanResult");
        map.put("com.huawei.hms.common.api.BooleanResult", "org.xms.g.common.api.BooleanResult");
        map.put("com.google.android.gms.maps.OnMapReadyCallback", "org.xms.g.maps.OnMapReadyCallback$XImpl");
        map.put("com.huawei.hms.maps.OnMapReadyCallback", "org.xms.g.maps.OnMapReadyCallback$XImpl");
        map.put("com.google.android.gms.awareness.snapshot.TimeIntervalsResult", "org.xms.g.awareness.snapshot.TimeIntervalsResult$XImpl");
        map.put("com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener", "org.xms.g.common.api.ExtensionApiClient$OnConnectionFailedListener$XImpl");
        map.put("com.huawei.hms.api.HuaweiApiClient.OnConnectionFailedListener", "org.xms.g.common.api.ExtensionApiClient$OnConnectionFailedListener$XImpl");
        map.put("com.google.android.gms.ads.initialization.OnInitializationCompleteListener", "org.xms.g.ads.initialization.OnInitializationCompleteListener$XImpl");
        map.put("com.google.android.gms.awareness.snapshot.HeadphoneStateResponse", "org.xms.g.awareness.snapshot.HeadphoneStateResponse");
        map.put("com.huawei.hms.kit.awareness.capture.HeadsetStatusResponse", "org.xms.g.awareness.snapshot.HeadphoneStateResponse");
        map.put("com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener", "org.xms.g.games.multiplayer.realtime.RealTimeMessageReceivedListener$XImpl");
        map.put("com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener", "org.xms.g.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener$XImpl");
        map.put("com.google.firebase.ml.vision.document.FirebaseVisionDocumentText.RecognizedBreak", "org.xms.f.ml.vision.document.FirebaseVisionDocumentText$RecognizedBreak");
        map.put("com.huawei.hms.mlsdk.document.MLDocument.Interval", "org.xms.f.ml.vision.document.FirebaseVisionDocumentText$RecognizedBreak");
        map.put("com.google.android.gms.common.ConnectionResult", "org.xms.g.common.ConnectionResult");
        map.put("com.huawei.hms.api.ConnectionResult", "org.xms.g.common.ConnectionResult");
        map.put("com.google.android.gms.ads.search.DynamicHeightSearchAdRequest", "org.xms.g.ads.search.DynamicHeightSearchAdRequest");
        map.put("com.google.firebase.ml.naturallanguage.languageid.IdentifiedLanguage", "org.xms.f.ml.naturallanguage.languageid.IdentifiedLanguage");
        map.put("com.google.android.gms.awareness.fence.FenceQueryResponse", "org.xms.g.awareness.fence.FenceQueryResponse");
        map.put("com.huawei.hms.kit.awareness.barrier.BarrierQueryResponse", "org.xms.g.awareness.fence.FenceQueryResponse");
        map.put("com.google.android.gms.identity.intents.AddressConstants.Themes", "org.xms.g.identity.intents.AddressConstants$Themes$XImpl");
        map.put("com.google.android.gms.ads.initialization.AdapterStatus", "org.xms.g.ads.initialization.AdapterStatus$XImpl");
        map.put("com.google.firebase.ml.vision.label.FirebaseVisionCloudImageLabelerOptions", "org.xms.f.ml.vision.label.FirebaseVisionCloudImageLabelerOptions");
        map.put("com.huawei.hms.mlsdk.classification.MLRemoteClassificationAnalyzerSetting", "org.xms.f.ml.vision.label.FirebaseVisionCloudImageLabelerOptions");
        map.put("com.google.android.gms.wallet.PaymentDataRequest.Builder", "org.xms.g.wallet.PaymentDataRequest$Builder");
        map.put("com.google.android.gms.fitness.data.Value", "org.xms.g.fitness.data.Value");
        map.put("com.huawei.hms.hihealth.data.Value", "org.xms.g.fitness.data.Value");
        map.put("com.google.android.gms.ads.rewarded.ServerSideVerificationOptions.Builder", "org.xms.g.ads.rewarded.ServerSideVerificationOptions$Builder");
        map.put("com.huawei.hms.ads.reward.RewardVerifyConfig.Builder", "org.xms.g.ads.rewarded.ServerSideVerificationOptions$Builder");
        map.put("com.google.android.gms.vision.CameraSource.Builder", "org.xms.g.vision.CameraSource$Builder");
        map.put("com.huawei.hms.mlsdk.common.LensEngine.Creator", "org.xms.g.vision.CameraSource$Builder");
        map.put("com.google.firebase.ml.vision.text.FirebaseVisionText.Element", "org.xms.f.ml.vision.text.FirebaseVisionText$Element");
        map.put("com.huawei.hms.mlsdk.text.MLText.Word", "org.xms.f.ml.vision.text.FirebaseVisionText$Element");
        map.put("com.google.android.gms.location.LocationSettingsResult", "org.xms.g.location.LocationSettingsResult");
        map.put("com.huawei.hms.location.LocationSettingsResult", "org.xms.g.location.LocationSettingsResult");
        map.put("com.google.android.gms.wallet.CardRequirements.Builder", "org.xms.g.wallet.CardRequirements$Builder");
        map.put("com.google.android.gms.games.video.VideoConfiguration.Builder", "org.xms.g.games.video.VideoConfiguration$Builder");
        map.put("com.google.android.gms.ads.formats.NativeAdView", "org.xms.g.ads.formats.NativeAdView");
        map.put("com.huawei.hms.ads.nativead.NativeView", "org.xms.g.ads.formats.NativeAdView");
        map.put("com.google.android.gms.games.PlayerLevel", "org.xms.g.games.PlayerLevel");
        map.put("com.google.android.gms.ads.mediation.MediationBannerListener", "org.xms.g.ads.mediation.MediationBannerListener$XImpl");
        map.put("com.google.android.gms.maps.GoogleMap.OnCameraChangeListener", "org.xms.g.maps.ExtensionMap$OnCameraChangeListener$XImpl");
        map.put("com.google.android.gms.analytics.Logger", "org.xms.g.analytics.Logger$XImpl");
        map.put("com.google.android.gms.games.stats.PlayerStats", "org.xms.g.games.stats.PlayerStats$XImpl");
        map.put("com.huawei.hms.jos.games.playerstats.GamePlayerStatistics", "org.xms.g.games.stats.PlayerStats$XImpl");
        map.put("com.google.android.gms.maps.model.IndoorLevel", "org.xms.g.maps.model.IndoorLevel");
        map.put("com.huawei.hms.maps.model.IndoorLevel", "org.xms.g.maps.model.IndoorLevel");
        map.put("com.google.android.gms.ads.mediation.MediationNativeAdCallback", "org.xms.g.ads.mediation.MediationNativeAdCallback$XImpl");
        map.put("com.google.android.gms.fitness.request.DataDeleteRequest", "org.xms.g.fitness.request.DataDeleteRequest");
        map.put("com.huawei.hms.hihealth.options.DeleteOptions", "org.xms.g.fitness.request.DataDeleteRequest");
        map.put("com.google.android.gms.analytics.GoogleAnalytics", "org.xms.g.analytics.ExtensionAnalytics");
        map.put("com.google.android.gms.common.images.ImageManager.OnImageLoadedListener", "org.xms.g.common.images.ImageManager$OnImageLoadedListener$XImpl");
        map.put("com.google.firebase.FirebaseApp", "org.xms.f.FirebaseApp");
        map.put("com.google.android.gms.auth.api.credentials.CredentialPickerConfig.Builder", "org.xms.g.auth.api.credentials.CredentialPickerConfig$Builder");
        map.put("com.google.firebase.ml.naturallanguage.translate.FirebaseTranslatorOptions.Builder", "org.xms.f.ml.naturallanguage.translate.FirebaseTranslatorOptions$Builder");
        map.put("com.google.android.gms.measurement.AppMeasurementContentProvider", "org.xms.g.measurement.AppMeasurementContentProvider");
        map.put("com.google.android.gms.ads.formats.NativeAdViewHolder", "org.xms.g.ads.formats.NativeAdViewHolder");
        map.put("com.huawei.hms.ads.nativead.NativeAdMonitor", "org.xms.g.ads.formats.NativeAdViewHolder");
        map.put("com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult", "org.xms.g.games.achievement.Achievements$UpdateAchievementResult$XImpl");
        map.put("com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode.WiFi", "org.xms.f.ml.vision.barcode.FirebaseVisionBarcode$WiFi");
        map.put("com.huawei.hms.ml.scan.HmsScan.WiFiConnectionInfo", "org.xms.f.ml.vision.barcode.FirebaseVisionBarcode$WiFi");
        map.put("com.google.android.gms.ads.mediation.MediationInterstitialAdCallback", "org.xms.g.ads.mediation.MediationInterstitialAdCallback$XImpl");
        map.put("com.google.firebase.ml.vision.label.FirebaseVisionOnDeviceImageLabelerOptions", "org.xms.f.ml.vision.label.FirebaseVisionOnDeviceImageLabelerOptions");
        map.put("com.huawei.hms.mlsdk.classification.MLLocalClassificationAnalyzerSetting", "org.xms.f.ml.vision.label.FirebaseVisionOnDeviceImageLabelerOptions");
        map.put("com.google.android.gms.nearby.messages.audio.AudioBytes", "org.xms.g.nearby.messages.audio.AudioBytes");
        map.put("com.google.android.gms.maps.model.StreetViewPanoramaOrientation.Builder", "org.xms.g.maps.model.StreetViewPanoramaOrientation$Builder");
        map.put("com.google.android.gms.maps.model.StreetViewPanoramaOrientation", "org.xms.g.maps.model.StreetViewPanoramaOrientation");
        map.put("com.google.android.gms.wallet.PaymentData", "org.xms.g.wallet.PaymentData");
        map.put("com.google.android.gms.wallet.WalletConstants", "org.xms.g.wallet.WalletConstants");
        map.put("com.huawei.hms.wallet.constant.WalletPassConstant", "org.xms.g.wallet.WalletConstants");
        map.put("com.google.android.gms.wallet.wobs.LabelValue", "org.xms.g.wallet.wobs.LabelValue");
        map.put("com.google.android.gms.identity.intents.AddressConstants.Extras", "org.xms.g.identity.intents.AddressConstants$Extras$XImpl");
        map.put("com.huawei.hms.identity.AddressConstants.Extras", "org.xms.g.identity.intents.AddressConstants$Extras$XImpl");
        map.put("com.google.android.gms.vision.Detector.Processor", "org.xms.g.vision.Detector$Processor$XImpl");
        map.put("com.huawei.hms.mlsdk.common.MLAnalyzer.MLTransactor", "org.xms.g.vision.Detector$Processor$XImpl");
        map.put("com.google.firebase.ml.vision.text.RecognizedLanguage", "org.xms.f.ml.vision.text.RecognizedLanguage");
        map.put("com.huawei.hms.mlsdk.text.TextLanguage", "org.xms.f.ml.vision.text.RecognizedLanguage");
        map.put("com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult", "org.xms.g.games.multiplayer.turnbased.TurnBasedMultiplayer$InitiateMatchResult$XImpl");
        map.put("com.google.android.gms.location.SettingsClient", "org.xms.g.location.SettingsClient");
        map.put("com.huawei.hms.location.SettingsClient", "org.xms.g.location.SettingsClient");
        map.put("com.google.android.gms.games.stats.Stats.LoadPlayerStatsResult", "org.xms.g.games.stats.Stats$LoadPlayerStatsResult$XImpl");
        map.put("com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode.ContactInfo", "org.xms.f.ml.vision.barcode.FirebaseVisionBarcode$ContactInfo");
        map.put("com.huawei.hms.ml.scan.HmsScan.ContactDetail", "org.xms.f.ml.vision.barcode.FirebaseVisionBarcode$ContactInfo");
        map.put("com.google.android.gms.maps.GoogleMap.OnMyLocationChangeListener", "org.xms.g.maps.ExtensionMap$OnMyLocationChangeListener$XImpl");
        map.put("com.google.firebase.ml.naturallanguage.translate.FirebaseTranslateLanguage", "org.xms.f.ml.naturallanguage.translate.FirebaseTranslateLanguage");
        map.put("com.google.android.gms.games.LeaderboardsClient", "org.xms.g.games.LeaderboardsClient");
        map.put("com.huawei.hms.jos.games.RankingsClient", "org.xms.g.games.LeaderboardsClient");
        map.put("com.google.firebase.ml.vision.face.FirebaseVisionFaceDetectorOptions", "org.xms.f.ml.vision.face.FirebaseVisionFaceDetectorOptions");
        map.put("com.huawei.hms.mlsdk.face.MLFaceAnalyzerSetting", "org.xms.f.ml.vision.face.FirebaseVisionFaceDetectorOptions");
        map.put("com.google.android.gms.maps.model.StreetViewPanoramaLink", "org.xms.g.maps.model.StreetViewPanoramaLink");
        map.put("com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse", "org.xms.g.games.multiplayer.turnbased.LoadMatchesResponse");
        map.put("com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult", "org.xms.g.games.leaderboard.Leaderboards$LoadPlayerScoreResult$XImpl");
        map.put("com.google.firebase.ml.custom.FirebaseModelOutputs", "org.xms.f.ml.custom.FirebaseModelOutputs");
        map.put("com.google.android.gms.fitness.service.SensorEventDispatcher", "org.xms.g.fitness.service.SensorEventDispatcher$XImpl");
        map.put("com.google.android.gms.maps.model.PolylineOptions", "org.xms.g.maps.model.PolylineOptions");
        map.put("com.huawei.hms.maps.model.PolylineOptions", "org.xms.g.maps.model.PolylineOptions");
        map.put("com.google.android.gms.maps.GoogleMap", "org.xms.g.maps.ExtensionMap");
        map.put("com.huawei.hms.maps.HuaweiMap", "org.xms.g.maps.ExtensionMap");
        map.put("com.google.android.gms.common.data.DataBuffer", "org.xms.g.common.data.DataBuffer$XImpl");
        map.put("com.huawei.hms.common.data.DataBuffer", "org.xms.g.common.data.DataBuffer$XImpl");
        map.put("com.google.firebase.analytics.FirebaseAnalytics.Param", "org.xms.f.analytics.FirebaseAnalytics$Param");
        map.put("com.huawei.hms.analytics.type.HAParamType", "org.xms.f.analytics.FirebaseAnalytics$Param");
        map.put("com.google.android.gms.panorama.PanoramaApi", "org.xms.g.panorama.PanoramaApi$XImpl");
        map.put("com.google.android.gms.analytics.HitBuilders.ItemBuilder", "org.xms.g.analytics.HitBuilders$ItemBuilder");
        map.put("com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes", "org.xms.g.auth.api.signin.ExtensionSignInStatusCodes");
        map.put("com.huawei.hms.support.hwid.result.HuaweiIdAuthResultCode", "org.xms.g.auth.api.signin.ExtensionSignInStatusCodes");
        map.put("com.google.android.gms.games.multiplayer.Participatable", "org.xms.g.games.multiplayer.Participatable$XImpl");
        map.put("com.google.firebase.ml.custom.FirebaseModelDataType", "org.xms.f.ml.custom.FirebaseModelDataType");
        map.put("com.google.android.gms.fitness.data.DataSet.Builder", "org.xms.g.fitness.data.DataSet$Builder");
        map.put("com.huawei.hms.hihealth.data.SampleSet.Builder", "org.xms.g.fitness.data.DataSet$Builder");
        map.put("com.google.firebase.ml.vision.text.FirebaseVisionCloudTextRecognizerOptions.Builder", "org.xms.f.ml.vision.text.FirebaseVisionCloudTextRecognizerOptions$Builder");
        map.put("com.huawei.hms.mlsdk.text.MLRemoteTextSetting.Factory", "org.xms.f.ml.vision.text.FirebaseVisionCloudTextRecognizerOptions$Builder");
        map.put("com.google.firebase.analytics.FirebaseAnalytics.UserProperty", "org.xms.f.analytics.FirebaseAnalytics$UserProperty");
        map.put("com.huawei.hms.analytics.type.HAParamType", "org.xms.f.analytics.FirebaseAnalytics$UserProperty");
        map.put("com.google.android.gms.fitness.request.SessionReadRequest", "org.xms.g.fitness.request.SessionReadRequest");
        map.put("com.huawei.hms.hihealth.options.ActivityRecordReadOptions", "org.xms.g.fitness.request.SessionReadRequest");
        map.put("com.google.android.gms.location.SettingsApi", "org.xms.g.location.SettingsApi$XImpl");
        map.put("com.google.android.gms.nearby.connection.AdvertisingOptions", "org.xms.g.nearby.connection.AdvertisingOptions");
        map.put("com.huawei.hms.nearby.discovery.BroadcastOption", "org.xms.g.nearby.connection.AdvertisingOptions");
        map.put("com.google.android.gms.vision.barcode.Barcode.UrlBookmark", "org.xms.g.vision.barcode.Barcode$UrlBookmark");
        map.put("com.huawei.hms.ml.scan.HmsScan.LinkUrl", "org.xms.g.vision.barcode.Barcode$UrlBookmark");
        map.put("com.google.android.gms.auth.api.accounttransfer.AccountTransferException", "org.xms.g.auth.api.accounttransfer.AccountTransferException");
        map.put("com.google.android.gms.ads.MobileAds", "org.xms.g.ads.MobileAds");
        map.put("com.google.android.gms.games.video.Videos.CaptureOverlayStateListener", "org.xms.g.games.video.Videos$CaptureOverlayStateListener$XImpl");
        map.put("com.google.android.gms.nearby.connection.ConnectionResolution", "org.xms.g.nearby.connection.ConnectionResolution");
        map.put("com.huawei.hms.nearby.discovery.ConnectResult", "org.xms.g.nearby.connection.ConnectionResolution");
        map.put("com.google.android.gms.auth.UserRecoverableAuthException", "org.xms.g.auth.UserRecoverableAuthException");
        map.put("com.google.android.gms.ads.formats.NativeAd.Image", "org.xms.g.ads.formats.NativeAd$Image$XImpl");
        map.put("com.huawei.hms.ads.Image", "org.xms.g.ads.formats.NativeAd$Image$XImpl");
        map.put("com.google.android.gms.maps.GoogleMapOptions", "org.xms.g.maps.ExtensionMapOptions");
        map.put("com.huawei.hms.maps.HuaweiMapOptions", "org.xms.g.maps.ExtensionMapOptions");
        map.put("com.google.android.gms.actions.ItemListIntents", "org.xms.g.actions.ItemListIntents");
        map.put("com.google.android.gms.maps.model.CameraPosition", "org.xms.g.maps.model.CameraPosition");
        map.put("com.huawei.hms.maps.model.CameraPosition", "org.xms.g.maps.model.CameraPosition");
        map.put("com.google.android.gms.ads.mediation.MediationBannerAdConfiguration", "org.xms.g.ads.mediation.MediationBannerAdConfiguration");
        map.put("com.google.android.gms.ads.mediation.rtb.SignalCallbacks", "org.xms.g.ads.mediation.rtb.SignalCallbacks$XImpl");
        map.put("com.google.android.gms.games.video.Videos.CaptureAvailableResult", "org.xms.g.games.video.Videos$CaptureAvailableResult$XImpl");
        map.put("com.google.android.gms.ads.formats.UnifiedNativeAdView", "org.xms.g.ads.formats.UnifiedNativeAdView");
        map.put("com.huawei.hms.ads.nativead.NativeView", "org.xms.g.ads.formats.UnifiedNativeAdView");
        map.put("com.google.android.gms.common.api.ResolvingResultCallbacks", "org.xms.g.common.api.ResolvingResultCallbacks$XImpl");
        map.put("com.huawei.hms.support.api.client.ResolvingResultCallbacks", "org.xms.g.common.api.ResolvingResultCallbacks$XImpl");
        map.put("com.google.android.gms.ads.mediation.rtb.RtbSignalData", "org.xms.g.ads.mediation.rtb.RtbSignalData");
        map.put("com.google.android.gms.awareness.fence.FenceState", "org.xms.g.awareness.fence.FenceState$XImpl");
        map.put("com.huawei.hms.kit.awareness.barrier.BarrierStatus", "org.xms.g.awareness.fence.FenceState$XImpl");
        map.put("com.google.android.gms.common.images.Size", "org.xms.g.common.images.Size");
        map.put("com.huawei.hms.common.size.Size", "org.xms.g.common.images.Size");
        map.put("com.google.android.gms.common.api.Api.ApiOptions.HasOptions", "org.xms.g.common.api.Api$ApiOptions$HasOptions$XImpl");
        map.put("com.huawei.hms.api.Api.ApiOptions.HasOptions", "org.xms.g.common.api.Api$ApiOptions$HasOptions$XImpl");
        map.put("com.google.android.gms.fitness.data.HealthFields", "org.xms.g.fitness.data.HealthFields");
        map.put("com.huawei.hms.hihealth.data.HealthFields", "org.xms.g.fitness.data.HealthFields");
        map.put("com.google.android.gms.games.leaderboard.ScoreSubmissionData.Result", "org.xms.g.games.leaderboard.ScoreSubmissionData$Result");
        map.put("com.huawei.hms.jos.games.ranking.ScoreSubmissionInfo.Result", "org.xms.g.games.leaderboard.ScoreSubmissionData$Result");
        map.put("com.google.android.gms.ads.formats.UnifiedNativeAdAssetNames", "org.xms.g.ads.formats.UnifiedNativeAdAssetNames");
        map.put("com.google.android.gms.auth.api.credentials.CredentialRequest.Builder", "org.xms.g.auth.api.credentials.CredentialRequest$Builder");
        map.put("com.google.android.gms.fitness.request.StartBleScanRequest.Builder", "org.xms.g.fitness.request.StartBleScanRequest$Builder");
        map.put("com.huawei.hms.hihealth.options.StartBleScanOptions.Builder", "org.xms.g.fitness.request.StartBleScanRequest$Builder");
        map.put("com.google.android.gms.maps.StreetViewPanoramaFragment", "org.xms.g.maps.StreetViewPanoramaFragment");
        map.put("com.google.android.gms.ads.mediation.Adapter", "org.xms.g.ads.mediation.Adapter$XImpl");
        map.put("com.google.android.gms.awareness.snapshot.WeatherResponse", "org.xms.g.awareness.snapshot.WeatherResponse");
        map.put("com.google.android.gms.fitness.data.Goal.MetricObjective", "org.xms.g.fitness.data.Goal$MetricObjective");
        map.put("com.google.android.gms.maps.CameraUpdateFactory", "org.xms.g.maps.CameraUpdateFactory");
        map.put("com.huawei.hms.maps.CameraUpdateFactory", "org.xms.g.maps.CameraUpdateFactory");
        map.put("com.google.android.gms.games.multiplayer.Invitations", "org.xms.g.games.multiplayer.Invitations$XImpl");
        map.put("com.google.android.gms.games.SnapshotsClient.SnapshotContentUnavailableApiException", "org.xms.g.games.SnapshotsClient$SnapshotContentUnavailableApiException");
        map.put("com.google.android.gms.wallet.TransactionInfo.Builder", "org.xms.g.wallet.TransactionInfo$Builder");
        map.put("com.google.android.gms.maps.model.Tile", "org.xms.g.maps.model.Tile");
        map.put("com.huawei.hms.maps.model.Tile", "org.xms.g.maps.model.Tile");
        map.put("com.google.firebase.ml.vision.cloud.FirebaseVisionCloudDetectorOptions.Builder", "org.xms.f.ml.vision.cloud.FirebaseVisionCloudDetectorOptions$Builder");
        map.put("com.huawei.hms.mlsdk.landmark.MLRemoteLandmarkAnalyzerSetting.Factory", "org.xms.f.ml.vision.cloud.FirebaseVisionCloudDetectorOptions$Builder");
        map.put("com.google.android.gms.maps.model.Gap", "org.xms.g.maps.model.Gap");
        map.put("com.huawei.hms.maps.model.Gap", "org.xms.g.maps.model.Gap");
        map.put("com.google.android.gms.games.GamesClient", "org.xms.g.games.GamesClient");
        map.put("com.huawei.hms.jos.games.GamesClient", "org.xms.g.games.GamesClient");
        map.put("com.google.android.gms.ads.rewarded.RewardedAd", "org.xms.g.ads.rewarded.RewardedAd");
        map.put("com.huawei.hms.ads.reward.RewardAd", "org.xms.g.ads.rewarded.RewardedAd");
        map.put("com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer", "org.xms.f.ml.vision.text.FirebaseVisionTextRecognizer");
        map.put("com.huawei.hms.mlsdk.text.MLTextAnalyzer", "org.xms.f.ml.vision.text.FirebaseVisionTextRecognizer");
        map.put("com.google.android.gms.location.FusedLocationProviderClient", "org.xms.g.location.FusedLocationProviderClient");
        map.put("com.huawei.hms.location.FusedLocationProviderClient", "org.xms.g.location.FusedLocationProviderClient");
        map.put("com.google.android.gms.ads.formats.MediaView", "org.xms.g.ads.formats.MediaView");
        map.put("com.huawei.hms.ads.nativead.MediaView", "org.xms.g.ads.formats.MediaView");
        map.put("com.google.firebase.ml.vision.label.FirebaseVisionOnDeviceImageLabelerOptions.Builder", "org.xms.f.ml.vision.label.FirebaseVisionOnDeviceImageLabelerOptions$Builder");
        map.put("com.huawei.hms.mlsdk.classification.MLLocalClassificationAnalyzerSetting.Factory", "org.xms.f.ml.vision.label.FirebaseVisionOnDeviceImageLabelerOptions$Builder");
        map.put("com.google.android.gms.nearby.messages.MessageListener", "org.xms.g.nearby.messages.MessageListener");
        map.put("com.huawei.hms.nearby.message.MessageHandler", "org.xms.g.nearby.messages.MessageListener");
        map.put("com.google.android.gms.ads.rewarded.RewardedAdCallback", "org.xms.g.ads.rewarded.RewardedAdCallback$XImpl");
        map.put("com.google.android.gms.fitness.result.DataReadResult", "org.xms.g.fitness.result.DataReadResult");
        map.put("com.huawei.hms.hihealth.result.ReadDetailResult", "org.xms.g.fitness.result.DataReadResult");
        map.put("com.google.android.gms.wallet.LoyaltyWalletObject.Builder", "org.xms.g.wallet.LoyaltyWalletObject$Builder");
        map.put("com.huawei.hms.wallet.pass.PassObject.Builder", "org.xms.g.wallet.LoyaltyWalletObject$Builder");
        map.put("com.google.android.gms.ads.initialization.AdapterStatus.State", "org.xms.g.ads.initialization.AdapterStatus$State");
        map.put("com.google.android.gms.analytics.HitBuilders.SocialBuilder", "org.xms.g.analytics.HitBuilders$SocialBuilder");
        map.put("com.android.installreferrer.api.InstallReferrerClient", "org.xms.installreferrer.api.InstallReferrerClient$XImpl");
        map.put("com.huawei.hms.ads.installreferrer.api.InstallReferrerClient", "org.xms.installreferrer.api.InstallReferrerClient$XImpl");
        map.put("com.google.firebase.ml.vision.face.FirebaseVisionFace", "org.xms.f.ml.vision.face.FirebaseVisionFace");
        map.put("com.huawei.hms.mlsdk.face.MLFace", "org.xms.f.ml.vision.face.FirebaseVisionFace");
        map.put("com.google.android.gms.wallet.wobs.LoyaltyPoints.Builder", "org.xms.g.wallet.wobs.LoyaltyPoints$Builder");
        map.put("com.google.android.gms.games.Notifications", "org.xms.g.games.Notifications$XImpl");
        map.put("com.google.android.gms.awareness.FenceClient", "org.xms.g.awareness.FenceClient");
        map.put("com.huawei.hms.kit.awareness.BarrierClient", "org.xms.g.awareness.FenceClient");
        map.put("com.google.android.gms.games.PageDirection", "org.xms.g.games.PageDirection");
        map.put("com.google.android.gms.ads.mediation.MediationBannerAdapter", "org.xms.g.ads.mediation.MediationBannerAdapter$XImpl");
        map.put("com.google.firebase.ml.common.modeldownload.FirebaseRemoteModel", "org.xms.f.ml.common.modeldownload.FirebaseRemoteModel");
        map.put("com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult", "org.xms.g.games.multiplayer.turnbased.TurnBasedMultiplayer$UpdateMatchResult$XImpl");
        map.put("com.google.android.gms.common.api.GoogleApiClient.Builder", "org.xms.g.common.api.ExtensionApiClient$Builder");
        map.put("com.huawei.hms.api.HuaweiApiClient.Builder", "org.xms.g.common.api.ExtensionApiClient$Builder");
        map.put("com.google.android.gms.fitness.BleApi", "org.xms.g.fitness.BleApi$XImpl");
        map.put("com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback", "org.xms.g.maps.OnStreetViewPanoramaReadyCallback$XImpl");
        map.put("com.google.android.gms.fitness.data.WorkoutExercises", "org.xms.g.fitness.data.WorkoutExercises");
        map.put("com.google.android.gms.games.InvitationsClient", "org.xms.g.games.InvitationsClient");
        map.put("com.google.android.gms.vision.barcode.Barcode.GeoPoint", "org.xms.g.vision.barcode.Barcode$GeoPoint");
        map.put("com.huawei.hms.ml.scan.HmsScan.LocationCoordinate", "org.xms.g.vision.barcode.Barcode$GeoPoint");
        map.put("com.google.android.gms.ads.mediation.NativeMediationAdRequest", "org.xms.g.ads.mediation.NativeMediationAdRequest$XImpl");
        map.put("com.google.android.gms.fitness.result.SessionReadResult", "org.xms.g.fitness.result.SessionReadResult");
        map.put("com.huawei.hms.hihealth.result.ActivityRecordResult", "org.xms.g.fitness.result.SessionReadResult");
        map.put("com.google.firebase.ml.vision.document.FirebaseVisionDocumentText", "org.xms.f.ml.vision.document.FirebaseVisionDocumentText");
        map.put("com.huawei.hms.mlsdk.document.MLDocument", "org.xms.f.ml.vision.document.FirebaseVisionDocumentText");
        map.put("com.google.android.gms.awareness.snapshot.LocationResponse", "org.xms.g.awareness.snapshot.LocationResponse");
        map.put("com.huawei.hms.kit.awareness.capture.LocationResponse", "org.xms.g.awareness.snapshot.LocationResponse");
        map.put("com.google.android.gms.location.LocationResult", "org.xms.g.location.LocationResult");
        map.put("com.huawei.hms.location.LocationResult", "org.xms.g.location.LocationResult");
        map.put("com.google.android.gms.games.RealTimeMultiplayerClient.ReliableMessageSentCallback", "org.xms.g.games.RealTimeMultiplayerClient$ReliableMessageSentCallback$XImpl");
        map.put("com.google.android.gms.games.multiplayer.InvitationCallback", "org.xms.g.games.multiplayer.InvitationCallback$XImpl");
        map.put("com.google.android.gms.auth.api.credentials.IdentityProviders", "org.xms.g.auth.api.credentials.IdentityProviders");
        map.put("com.google.android.gms.safetynet.HarmfulAppsData", "org.xms.g.safetynet.HarmfulAppsData");
        map.put("com.huawei.hms.support.api.entity.safetydetect.MaliciousAppsData", "org.xms.g.safetynet.HarmfulAppsData");
        map.put("com.google.android.gms.tasks.TaskExecutors", "org.xms.g.tasks.TaskExecutors");
        map.put("com.google.android.gms.maps.GoogleMap.OnMapLoadedCallback", "org.xms.g.maps.ExtensionMap$OnMapLoadedCallback$XImpl");
        map.put("com.huawei.hms.maps.HuaweiMap.OnMapLoadedCallback", "org.xms.g.maps.ExtensionMap$OnMapLoadedCallback$XImpl");
        map.put("com.google.firebase.messaging.RemoteMessage.Builder", "org.xms.f.messaging.RemoteMessage$Builder");
        map.put("com.huawei.hms.push.RemoteMessage.Builder", "org.xms.f.messaging.RemoteMessage$Builder");
        map.put("com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode.PersonName", "org.xms.f.ml.vision.barcode.FirebaseVisionBarcode$PersonName");
        map.put("com.huawei.hms.ml.scan.HmsScan.PeopleName", "org.xms.f.ml.vision.barcode.FirebaseVisionBarcode$PersonName");
        map.put("com.google.android.gms.maps.GoogleMap.OnMyLocationClickListener", "org.xms.g.maps.ExtensionMap$OnMyLocationClickListener$XImpl");
        map.put("com.huawei.hms.maps.HuaweiMap.OnMyLocationClickListener", "org.xms.g.maps.ExtensionMap$OnMyLocationClickListener$XImpl");
        map.put("com.google.android.gms.common.api.HasApiKey", "org.xms.g.common.api.HasApiKey$XImpl");
        map.put("com.google.android.gms.maps.MapsInitializer", "org.xms.g.maps.MapsInitializer");
        map.put("com.huawei.hms.maps.MapsInitializer", "org.xms.g.maps.MapsInitializer");
        map.put("com.google.android.gms.fitness.request.OnDataPointListener", "org.xms.g.fitness.request.OnDataPointListener$XImpl");
        map.put("com.huawei.hms.hihealth.options.OnSamplePointListener", "org.xms.g.fitness.request.OnDataPointListener$XImpl");
        G2H.put("com.google.android.gms.nearby.messages.BleSignal", "com.huawei.hms.nearby.discovery.BleSignal");
        G2H.put("com.google.android.gms.maps.model.MapStyleOptions", "com.huawei.hms.maps.model.MapStyleOptions");
        G2H.put("com.google.firebase.ml.vision.cloud.landmark.FirebaseVisionCloudLandmark", "com.huawei.hms.mlsdk.landmark.MLRemoteLandmark");
        G2H.put("com.google.android.gms.ads.VideoOptions.Builder", "com.huawei.hms.ads.VideoConfiguration.Builder");
        G2H.put("com.google.android.gms.nearby.messages.MessagesClient", "com.huawei.hms.nearby.message.MessageEngine");
        G2H.put("com.google.android.gms.ads.AdSize", "com.huawei.hms.ads.BannerAdSize");
        G2H.put("com.google.android.gms.games.Games", "com.huawei.hms.jos.games.Games");
        G2H.put("com.google.android.gms.location.GeofencingClient", "com.huawei.hms.location.GeofenceService");
        G2H.put("com.google.android.gms.vision.barcode.Barcode.PersonName", "com.huawei.hms.ml.scan.HmsScan.PeopleName");
        G2H.put("com.google.android.gms.auth.api.signin.GoogleSignInResult", "com.huawei.hms.support.hwid.result.HuaweiIdAuthResult");
        G2H.put("com.google.android.gms.common.data.AbstractDataBuffer", "com.huawei.hms.common.data.AbstractDataBuffer");
        G2H.put("com.google.android.gms.nearby.messages.StatusCallback", "com.huawei.hms.nearby.message.StatusCallback");
        G2H.put("com.google.android.gms.fitness.data.DataSource", "com.huawei.hms.hihealth.data.DataCollector");
        G2H.put("com.google.android.gms.common.data.FreezableUtils", "com.huawei.hms.common.data.FreezableUtils");
        G2H.put("com.google.android.gms.ads.rewarded.RewardItem", "com.huawei.hms.ads.reward.Reward");
        G2H.put("com.google.android.gms.maps.model.Dot", "com.huawei.hms.maps.model.Dot");
        G2H.put("com.google.android.gms.vision.face.LargestFaceFocusingProcessor.Builder", "com.huawei.hms.mlsdk.face.MLMaxSizeFaceTransactor.Creator");
        G2H.put("com.google.android.gms.ads.reward.RewardedVideoAdListener", "com.huawei.hms.ads.reward.RewardAdListener");
        G2H.put("com.google.android.gms.fitness.BleClient", "com.huawei.hms.hihealth.BleController");
        G2H.put("com.android.installreferrer.api.ReferrerDetails", "com.huawei.hms.ads.installreferrer.api.ReferrerDetails");
        G2H.put("com.google.android.gms.games.Game", "com.huawei.hms.jos.games.gamesummary.GameSummary");
        G2H.put("com.google.android.gms.vision.Frame.Builder", "com.huawei.hms.mlsdk.common.MLFrame.Creator");
        G2H.put("com.google.firebase.ml.vision.common.FirebaseVisionImage", "com.huawei.hms.mlsdk.common.MLFrame");
        G2H.put("com.google.android.gms.awareness.SnapshotClient", "com.huawei.hms.kit.awareness.CaptureClient");
        G2H.put("com.google.android.gms.nearby.connection.PayloadCallback", "com.huawei.hms.nearby.transfer.DataCallback");
        G2H.put("com.google.android.gms.games.GamesMetadataClient", "com.huawei.hms.jos.games.GameSummaryClient");
        G2H.put("com.google.android.gms.fitness.data.Subscription", "com.huawei.hms.hihealth.data.Record");
        G2H.put("com.google.android.gms.ads.formats.NativeAdOptions.Builder", "com.huawei.hms.ads.nativead.NativeAdConfiguration.Builder");
        G2H.put("com.google.firebase.ml.vision.text.FirebaseVisionText.TextBlock", "com.huawei.hms.mlsdk.text.MLText.Block");
        G2H.put("com.google.android.gms.awareness.fence.FenceUpdateRequest", "com.huawei.hms.kit.awareness.barrier.BarrierUpdateRequest");
        G2H.put("com.google.android.gms.vision.text.TextRecognizer", "com.huawei.hms.mlsdk.text.MLTextAnalyzer");
        G2H.put("com.google.android.gms.maps.GoogleMap.OnIndoorStateChangeListener", "com.huawei.hms.maps.HuaweiMap.OnIndoorStateChangeListener");
        G2H.put("com.google.android.gms.fitness.SensorsClient", "com.huawei.hms.hihealth.SensorsController");
        G2H.put("com.google.android.gms.maps.model.TileProvider", "com.huawei.hms.maps.model.TileProvider");
        G2H.put("com.google.android.gms.maps.LocationSource.OnLocationChangedListener", "com.huawei.hms.maps.LocationSource.OnLocationChangedListener");
        G2H.put("com.google.android.gms.maps.model.ButtCap", "com.huawei.hms.maps.model.ButtCap");
        G2H.put("com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode.CalendarDateTime", "com.huawei.hms.ml.scan.HmsScan.EventTime");
        G2H.put("com.google.android.gms.vision.Tracker", "com.huawei.hms.mlsdk.common.MLResultTrailer");
        G2H.put("com.google.android.gms.nearby.messages.Distance", "com.huawei.hms.nearby.discovery.Distance");
        G2H.put("com.google.android.gms.games.snapshot.SnapshotMetadataChange.Builder", "com.huawei.hms.jos.games.archive.ArchiveSummaryUpdate.Builder");
        G2H.put("com.google.android.gms.fitness.result.SessionReadResponse", "com.huawei.hms.hihealth.result.ActivityRecordReply");
        G2H.put("com.google.android.gms.identity.intents.AddressConstants", "com.huawei.hms.identity.AddressConstants");
        G2H.put("com.google.android.gms.tasks.OnFailureListener", "com.huawei.hmf.tasks.OnFailureListener");
        G2H.put("com.google.android.gms.fitness.request.DataDeleteRequest.Builder", "com.huawei.hms.hihealth.options.DeleteOptions.Builder");
        G2H.put("com.google.android.gms.safetynet.SafetyNetStatusCodes", "com.huawei.hms.support.api.safetydetect.SafetyDetectStatusCodes");
        G2H.put("com.google.android.gms.nearby.messages.PublishOptions", "com.huawei.hms.nearby.message.PutOption");
        G2H.put("com.google.android.gms.maps.model.BitmapDescriptor", "com.huawei.hms.maps.model.BitmapDescriptor");
        G2H.put("com.google.android.gms.maps.LocationSource", "com.huawei.hms.maps.LocationSource");
        G2H.put("com.google.android.gms.safetynet.SafetyNetClient", "com.huawei.hms.support.api.safetydetect.SafetyDetectClient");
        G2H.put("com.google.android.gms.maps.model.Dash", "com.huawei.hms.maps.model.Dash");
        G2H.put("com.google.android.gms.maps.GoogleMap.OnMapLongClickListener", "com.huawei.hms.maps.HuaweiMap.OnMapLongClickListener");
        G2H.put("com.google.android.gms.games.achievement.AchievementEntity", "com.huawei.hms.jos.games.achievement.Achievement");
        G2H.put("com.google.android.gms.location.LocationAvailability", "com.huawei.hms.location.LocationAvailability");
        G2H.put("com.google.android.gms.maps.GoogleMap.OnMapClickListener", "com.huawei.hms.maps.HuaweiMap.OnMapClickListener");
        G2H.put("com.google.android.gms.games.Player", "com.huawei.hms.jos.games.player.Player");
        G2H.put("com.google.firebase.analytics.FirebaseAnalytics.Event", "com.huawei.hms.analytics.type.HAEventType");
        G2H.put("com.google.android.gms.games.achievement.Achievement", "com.huawei.hms.jos.games.achievement.Achievement");
        G2H.put("com.google.android.gms.nearby.connection.PayloadTransferUpdate.Status", "com.huawei.hms.nearby.transfer.TransferStateUpdate.Status");
        G2H.put("com.google.android.gms.games.snapshot.SnapshotMetadataChange", "com.huawei.hms.jos.games.archive.ArchiveSummaryUpdate");
        G2H.put("com.google.firebase.ml.vision.text.FirebaseVisionText.Line", "com.huawei.hms.mlsdk.text.MLText.TextLine");
        G2H.put("com.google.android.gms.vision.Detector", "com.huawei.hms.mlsdk.common.MLAnalyzer");
        G2H.put("com.google.android.gms.awareness.state.BeaconState.BeaconInfo", "com.huawei.hms.kit.awareness.status.BeaconStatus.BeaconData");
        G2H.put("com.google.android.gms.vision.barcode.Barcode", "com.huawei.hms.ml.scan.HmsScan");
        G2H.put("com.google.android.gms.fitness.HistoryApi.ViewIntentBuilder", "com.huawei.hms.hihealth.DataManager.GetIntentInfos");
        G2H.put("com.google.android.gms.common.api.Api.ApiOptions", "com.huawei.hms.api.Api.ApiOptions");
        G2H.put("com.google.android.gms.fitness.request.StartBleScanRequest", "com.huawei.hms.hihealth.options.StartBleScanOptions");
        G2H.put("com.google.android.gms.safetynet.SafetyNet", "com.huawei.hms.support.api.safetydetect.SafetyDetect");
        G2H.put("com.google.android.gms.games.snapshot.SnapshotMetadata", "com.huawei.hms.jos.games.archive.ArchiveSummary");
        G2H.put("com.android.installreferrer.commons.InstallReferrerCommons", "com.huawei.hms.ads.installreferrer.commons.InstallReferrerCommons");
        G2H.put("com.google.android.gms.common.api.Api.ApiOptions.Optional", "com.huawei.hms.api.Api.ApiOptions.Optional");
        G2H.put("com.google.android.gms.panorama.PanoramaApi.PanoramaResult", "com.huawei.hms.panorama.PanoramaInterface.ImageInfoResult");
        G2H.put("com.google.firebase.ml.vision.barcode.FirebaseVisionBarcodeDetectorOptions.Builder", "com.huawei.hms.ml.scan.HmsScanAnalyzerOptions.Creator");
        G2H.put("com.google.android.gms.fitness.result.DataSourcesResult", "com.huawei.hms.hihealth.result.DataCollectorsResult");
        G2H.put("com.google.android.gms.vision.Frame", "com.huawei.hms.mlsdk.common.MLFrame");
        G2H.put("com.google.android.gms.vision.face.FaceDetector.Builder", "com.huawei.hms.mlsdk.face.MLFaceAnalyzer.Factory");
        G2H.put("com.google.android.gms.fitness.request.BleScanCallback", "com.huawei.hms.hihealth.options.BleScanCallback");
        G2H.put("com.google.android.gms.common.api.Api.ApiOptions.HasAccountOptions", "com.huawei.hms.support.api.hwid.HuaweiAccountOptions.HasAccountOptions");
        G2H.put("com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder", "com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper");
        G2H.put("com.google.android.gms.nearby.messages.MessageFilter", "com.huawei.hms.nearby.message.MessagePicker");
        G2H.put("com.google.android.gms.location.LocationSettingsStatusCodes", "com.huawei.hms.location.LocationSettingsStatusCodes");
        G2H.put("com.google.android.gms.fitness.result.BleDevicesResult", "com.huawei.hms.hihealth.result.BleDeviceInfosResult");
        G2H.put("com.google.android.gms.maps.model.TileOverlayOptions", "com.huawei.hms.maps.model.TileOverlayOptions");
        G2H.put("com.google.android.gms.common.api.ResultCallbacks", "com.huawei.hms.support.api.client.ResultCallbacks");
        G2H.put("com.google.android.gms.awareness.snapshot.TimeIntervalsResponse", "com.huawei.hms.kit.awareness.capture.TimeCategoriesResponse");
        G2H.put("com.google.android.gms.common.GoogleApiAvailability", "com.huawei.hms.api.HuaweiApiAvailability");
        G2H.put("com.google.android.gms.common.api.Result", "com.huawei.hms.support.api.client.Result");
        G2H.put("com.google.android.gms.ads.formats.UnifiedNativeAd.OnUnifiedNativeAdLoadedListener", "com.huawei.hms.ads.nativead.NativeAd.NativeAdLoadedListener");
        G2H.put("com.google.android.gms.tasks.CancellationToken", "com.huawei.hmf.tasks.CancellationToken");
        G2H.put("com.google.android.gms.fitness.data.DataSource.Builder", "com.huawei.hms.hihealth.data.DataCollector.Builder");
        G2H.put("com.google.android.gms.location.ActivityTransitionResult", "com.huawei.hms.location.ActivityConversionResponse");
        G2H.put("com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener", "com.huawei.hms.ads.reward.OnMetadataChangedListener");
        G2H.put("com.google.android.gms.vision.text.Line", "com.huawei.hms.mlsdk.text.MLText.TextLine");
        G2H.put("com.google.android.gms.nearby.connection.EndpointDiscoveryCallback", "com.huawei.hms.nearby.discovery.ScanEndpointCallback");
        G2H.put("com.google.android.gms.nearby.messages.MessageFilter.Builder", "com.huawei.hms.nearby.message.MessagePicker.Builder");
        G2H.put("com.google.android.gms.location.LocationSettingsRequest", "com.huawei.hms.location.LocationSettingsRequest");
        G2H.put("com.google.android.gms.ads.MuteThisAdListener", "com.huawei.hms.ads.nativead.DislikeAdListener");
        G2H.put("com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode.Phone", "com.huawei.hms.ml.scan.HmsScan.TelPhoneNumber");
        G2H.put("com.google.android.gms.maps.GoogleMap.OnMarkerClickListener", "com.huawei.hms.maps.HuaweiMap.OnMarkerClickListener");
        G2H.put("com.google.firebase.ml.vision.objects.FirebaseVisionObjectDetectorOptions", "com.huawei.hms.mlsdk.objects.MLObjectAnalyzerSetting");
        G2H.put("com.google.android.gms.games.AchievementsClient", "com.huawei.hms.jos.games.AchievementsClient");
        G2H.put("com.google.android.gms.fitness.ConfigClient", "com.huawei.hms.hihealth.SettingController");
        G2H.put("com.google.android.gms.wallet.GiftCardWalletObject.Builder", "com.huawei.hms.wallet.pass.PassObject.Builder");
        G2H.put("com.google.android.gms.vision.barcode.Barcode.DriverLicense", "com.huawei.hms.ml.scan.HmsScan.DriverInfo");
        G2H.put("com.google.android.gms.vision.FocusingProcessor", "com.huawei.hms.mlsdk.common.MLProminentTransactor");
        G2H.put("com.google.android.gms.nearby.messages.Strategy", "com.huawei.hms.nearby.message.Policy");
        G2H.put("com.google.android.gms.vision.face.LargestFaceFocusingProcessor", "com.huawei.hms.mlsdk.face.MLMaxSizeFaceTransactor");
        G2H.put("com.google.android.gms.wallet.OfferWalletObject", "com.huawei.hms.wallet.pass.PassObject");
        G2H.put("com.google.android.gms.location.ActivityTransition.Builder", "com.huawei.hms.location.ActivityConversionInfo.Builder");
        G2H.put("com.google.android.gms.vision.barcode.Barcode.Email", "com.huawei.hms.ml.scan.HmsScan.EmailContent");
        G2H.put("com.google.android.gms.common.api.TransformedResult", "com.huawei.hms.support.api.client.ConvertedResult");
        G2H.put("com.google.android.gms.tasks.Continuation", "com.huawei.hmf.tasks.Continuation");
        G2H.put("com.google.android.gms.maps.model.CustomCap", "com.huawei.hms.maps.model.CustomCap");
        G2H.put("com.google.android.gms.awareness.fence.FenceStateMap", "com.huawei.hms.kit.awareness.barrier.BarrierStatusMap");
        G2H.put("com.google.android.gms.fitness.request.SessionInsertRequest", "com.huawei.hms.hihealth.options.ActivityRecordInsertOptions");
        G2H.put("com.google.android.gms.nearby.messages.MessagesOptions.Builder", "com.huawei.hms.nearby.message.MessageOption.Builder");
        G2H.put("com.google.android.gms.location.LocationServices", "com.huawei.hms.location.LocationServices");
        G2H.put("com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks", "com.huawei.hms.api.HuaweiApiClient.ConnectionCallbacks");
        G2H.put("com.google.android.gms.maps.CameraUpdate", "com.huawei.hms.maps.CameraUpdate");
        G2H.put("com.google.android.gms.wallet.WalletObjectsClient", "com.huawei.hms.wallet.WalletPassClient");
        G2H.put("com.google.android.gms.maps.model.RuntimeRemoteException", "com.huawei.hms.maps.model.RuntimeRemoteException");
        G2H.put("com.google.android.gms.auth.GoogleAuthUtil", "com.huawei.hms.support.hwid.tools.HuaweiIdAuthTool");
        G2H.put("com.google.android.gms.maps.model.JointType", "com.huawei.hms.maps.model.JointType");
        G2H.put("com.google.android.gms.ads.formats.AdChoicesView", "com.huawei.hms.ads.ChoicesView");
        G2H.put("com.google.android.gms.ads.formats.NativeContentAdView", "com.huawei.hms.ads.nativead.NativeView");
        G2H.put("com.google.android.gms.vision.text.Element", "com.huawei.hms.mlsdk.text.MLText.Word");
        G2H.put("com.google.firebase.ml.vision.text.FirebaseVisionText", "com.huawei.hms.mlsdk.text.MLText");
        G2H.put("com.google.android.gms.awareness.fence.FenceQueryRequest", "com.huawei.hms.kit.awareness.barrier.BarrierQueryRequest");
        G2H.put("com.google.android.gms.maps.model.Marker", "com.huawei.hms.maps.model.Marker");
        G2H.put("com.google.android.gms.security.ProviderInstaller.ProviderInstallListener", "com.huawei.hms.security.SecComponentInstallWizard.SecComponentInstallWizardListener");
        G2H.put("com.google.android.gms.maps.model.Polyline", "com.huawei.hms.maps.model.Polyline");
        G2H.put("com.google.android.gms.location.ActivityRecognitionResult", "com.huawei.hms.location.ActivityIdentificationResponse");
        G2H.put("com.google.android.gms.maps.model.Circle", "com.huawei.hms.maps.model.Circle");
        G2H.put("com.google.firebase.ml.vision.document.FirebaseVisionDocumentText.Symbol", "com.huawei.hms.mlsdk.document.MLDocument.Character");
        G2H.put("com.google.android.gms.fitness.data.BleDevice", "com.huawei.hms.hihealth.data.BleDeviceInfo");
        G2H.put("com.google.android.gms.location.DetectedActivity", "com.huawei.hms.location.ActivityIdentificationData");
        G2H.put("com.google.android.gms.common.UserRecoverableException", "com.huawei.hms.api.UserRecoverableException");
        G2H.put("com.google.android.gms.nearby.messages.Message", "com.huawei.hms.nearby.message.Message");
        G2H.put("com.google.firebase.ml.vision.common.FirebaseVisionImageMetadata.Builder", "com.huawei.hms.mlsdk.common.MLFrame.Property.Creator");
        G2H.put("com.google.android.gms.fitness.data.Field", "com.huawei.hms.hihealth.data.Field");
        G2H.put("com.google.firebase.ml.vision.document.FirebaseVisionDocumentText.Paragraph", "com.huawei.hms.mlsdk.document.MLDocument.Section");
        G2H.put("com.google.android.gms.tasks.OnSuccessListener", "com.huawei.hmf.tasks.OnSuccessListener");
        G2H.put("com.google.android.gms.common.api.Api", "com.huawei.hms.api.Api");
        G2H.put("com.google.android.gms.vision.MultiDetector.Builder", "com.huawei.hms.mlsdk.common.MLCompositeAnalyzer.Creator");
        G2H.put("com.google.firebase.ml.vision.objects.FirebaseVisionObjectDetectorOptions.Builder", "com.huawei.hms.mlsdk.objects.MLObjectAnalyzerSetting.Factory");
        G2H.put("com.google.android.gms.location.LocationSettingsRequest.Builder", "com.huawei.hms.location.LocationSettingsRequest.Builder");
        G2H.put("com.google.android.gms.maps.MapView", "com.huawei.hms.maps.MapView");
        G2H.put("com.google.android.gms.games.SnapshotsClient", "com.huawei.hms.jos.games.ArchivesClient");
        G2H.put("com.google.android.gms.fitness.RecordingClient", "com.huawei.hms.hihealth.AutoRecorderController");
        G2H.put("com.google.android.gms.location.LocationSettingsResponse", "com.huawei.hms.location.LocationSettingsResponse");
        G2H.put("com.google.android.gms.fitness.SessionsClient", "com.huawei.hms.hihealth.ActivityRecordsController");
        G2H.put("com.google.android.gms.vision.barcode.Barcode.Phone", "com.huawei.hms.ml.scan.HmsScan.TelPhoneNumber");
        G2H.put("com.google.android.gms.maps.GoogleMap.OnCircleClickListener", "com.huawei.hms.maps.HuaweiMap.OnCircleClickListener");
        G2H.put("com.google.android.gms.nearby.messages.PublishCallback", "com.huawei.hms.nearby.message.PutCallback");
        G2H.put("com.google.android.gms.auth.api.phone.SmsRetriever", "com.huawei.hms.support.sms.common.ReadSmsConstant");
        G2H.put("com.google.android.gms.maps.GoogleMap.OnInfoWindowLongClickListener", "com.huawei.hms.maps.HuaweiMap.OnInfoWindowLongClickListener");
        G2H.put("com.google.android.gms.ads.RequestConfiguration.Builder", "com.huawei.hms.ads.RequestOptions.Builder");
        G2H.put("com.google.android.gms.location.Geofence.Builder", "com.huawei.hms.location.Geofence.Builder");
        G2H.put("com.google.android.gms.maps.model.VisibleRegion", "com.huawei.hms.maps.model.VisibleRegion");
        G2H.put("com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode.DriverLicense", "com.huawei.hms.ml.scan.HmsScan.DriverInfo");
        G2H.put("com.google.android.gms.common.api.Api.ApiOptions.NotRequiredOptions", "com.huawei.hms.api.Api.ApiOptions.NotRequiredOptions");
        G2H.put("com.google.android.gms.wallet.LoyaltyWalletObject", "com.huawei.hms.wallet.pass.PassObject");
        G2H.put("com.google.android.gms.auth.api.Auth", "com.huawei.hms.support.hwid.HuaweiIdAuthAPIManager");
        G2H.put("com.google.android.gms.ads.identifier.AdvertisingIdClient", "com.huawei.hms.ads.identifier.AdvertisingIdClient");
        G2H.put("com.google.android.gms.measurement.AppMeasurementInstallReferrerReceiver", "com.huawei.hms.analytics.HiAnalyticsInstallReceiver");
        G2H.put("com.google.android.gms.nearby.connection.Payload.Stream", "com.huawei.hms.nearby.transfer.Data.Stream");
        G2H.put("com.google.android.gms.maps.GoogleMap.OnCameraMoveCanceledListener", "com.huawei.hms.maps.HuaweiMap.OnCameraMoveCanceledListener");
        G2H.put("com.google.android.gms.fitness.data.DataSet", "com.huawei.hms.hihealth.data.SampleSet");
        G2H.put("com.google.android.gms.ads.reward.AdMetadataListener", "com.huawei.hms.ads.reward.OnMetadataChangedListener");
        G2H.put("com.google.android.gms.common.api.Releasable", "com.huawei.hms.common.api.Releasable");
        G2H.put("com.google.android.gms.vision.CameraSource", "com.huawei.hms.mlsdk.common.LensEngine");
        G2H.put("com.google.android.gms.vision.text.TextRecognizer.Builder", "com.huawei.hms.mlsdk.text.MLTextAnalyzer.Factory");
        G2H.put("com.google.android.gms.fitness.result.DataTypeResult", "com.huawei.hms.hihealth.result.DataTypeResult");
        G2H.put("com.google.android.gms.games.snapshot.SnapshotContents", "com.huawei.hms.jos.games.archive.ArchiveDetails");
        G2H.put("com.google.android.gms.location.GeofenceStatusCodes", "com.huawei.hms.location.GeofenceErrorCodes");
        G2H.put("com.google.android.gms.fitness.data.Device", "com.huawei.hms.hihealth.data.DeviceInfo");
        G2H.put("com.google.android.gms.maps.model.CameraPosition.Builder", "com.huawei.hms.maps.model.CameraPosition.Builder");
        G2H.put("com.google.android.gms.auth.api.signin.GoogleSignInOptions", "com.huawei.hms.support.hwid.request.HuaweiIdAuthParams");
        G2H.put("com.google.android.gms.measurement.AppMeasurementReceiver", "com.huawei.hms.analytics.HiAnalyticsReceiver");
        G2H.put("com.google.android.gms.maps.model.BitmapDescriptorFactory", "com.huawei.hms.maps.model.BitmapDescriptorFactory");
        G2H.put("com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions", "com.huawei.hms.support.api.hwid.HuaweiAccountOptions.HasAuthHuaweiIdOptions");
        G2H.put("com.google.android.gms.vision.barcode.Barcode.CalendarEvent", "com.huawei.hms.ml.scan.HmsScan.EventInfo");
        G2H.put("com.google.android.gms.common.api.ResultCallback", "com.huawei.hms.support.api.client.ResultCallback");
        G2H.put("com.google.android.gms.location.ActivityRecognition", "com.huawei.hms.location.ActivityIdentification");
        G2H.put("com.google.android.gms.maps.model.UrlTileProvider", "com.huawei.hms.maps.model.UrlTileProvider");
        G2H.put("com.google.android.gms.common.api.PendingResults", "com.huawei.hms.support.api.client.PendingResultsCreator");
        G2H.put("com.google.android.gms.games.Games.GamesOptions", "com.huawei.hms.jos.games.GameOptions");
        G2H.put("com.google.android.gms.awareness.fence.TimeFence", "com.huawei.hms.kit.awareness.barrier.TimeBarrier");
        G2H.put("com.google.android.gms.safetynet.SafetyNetApi.SafeBrowsingResponse", "com.huawei.hms.support.api.entity.safetydetect.UrlCheckResponse");
        G2H.put("com.google.android.gms.wallet.OfferWalletObject.Builder", "com.huawei.hms.wallet.pass.PassObject.Builder");
        G2H.put("com.google.firebase.iid.InstanceIdResult", "com.huawei.hms.aaid.entity.AAIDResult");
        G2H.put("com.android.installreferrer.api.InstallReferrerClient.Builder", "com.huawei.hms.ads.installreferrer.api.InstallReferrerClient.Builder");
        G2H.put("com.google.android.gms.games.PlayerEntity", "com.huawei.hms.jos.games.player.Player");
        G2H.put("com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener", "com.huawei.hms.maps.HuaweiMap.OnMyLocationButtonClickListener");
        G2H.put("com.google.firebase.ml.vision.text.FirebaseVisionCloudTextRecognizerOptions", "com.huawei.hms.mlsdk.text.MLRemoteTextSetting");
        G2H.put("com.google.android.gms.nearby.connection.ConnectionInfo", "com.huawei.hms.nearby.discovery.ConnectInfo");
        G2H.put("com.google.android.gms.nearby.connection.Payload.File", "com.huawei.hms.nearby.transfer.Data.File");
        G2H.put("com.google.android.gms.auth.api.signin.GoogleSignInAccount", "com.huawei.hms.support.hwid.result.AuthHuaweiId");
        G2H.put("com.google.android.gms.ads.formats.UnifiedNativeAd", "com.huawei.hms.ads.nativead.NativeAd");
        G2H.put("com.google.android.gms.common.api.Status", "com.huawei.hms.support.api.client.Status");
        G2H.put("com.google.android.gms.awareness.fence.AwarenessFence", "com.huawei.hms.kit.awareness.barrier.AwarenessBarrier");
        G2H.put("com.google.android.gms.fitness.request.SensorRequest", "com.huawei.hms.hihealth.options.SensorOptions");
        G2H.put("com.google.android.gms.maps.GoogleMap.InfoWindowAdapter", "com.huawei.hms.maps.HuaweiMap.InfoWindowAdapter");
        G2H.put("com.google.android.gms.common.api.AvailabilityException", "com.huawei.hms.common.api.AvailabilityException");
        G2H.put("com.google.android.gms.auth.GoogleAuthException", "com.huawei.hms.support.hwid.common.HuaweiIdAuthException");
        G2H.put("com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode.UrlBookmark", "com.huawei.hms.ml.scan.HmsScan.LinkUrl");
        G2H.put("com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode.Address", "com.huawei.hms.ml.scan.HmsScan.AddressInfo");
        G2H.put("com.google.android.gms.auth.api.signin.GoogleSignIn", "com.huawei.hms.support.hwid.HuaweiIdAuthManager");
        G2H.put("com.google.firebase.ml.vision.cloud.landmark.FirebaseVisionCloudLandmarkDetector", "com.huawei.hms.mlsdk.landmark.MLRemoteLandmarkAnalyzer");
        G2H.put("com.google.android.gms.fitness.result.SessionStopResult", "com.huawei.hms.hihealth.result.ActivityRecordStopResult");
        G2H.put("com.google.android.gms.wallet.Wallet", "com.huawei.hms.wallet.Wallet");
        G2H.put("com.google.firebase.ml.vision.common.FirebaseVisionLatLng", "com.huawei.hms.mlsdk.common.MLCoordinate");
        G2H.put("com.google.android.gms.vision.face.Face", "com.huawei.hms.mlsdk.face.MLFace");
        G2H.put("com.google.android.gms.games.snapshot.SnapshotMetadataEntity", "com.huawei.hms.jos.games.archive.ArchiveSummary");
        G2H.put("com.google.android.gms.common.api.Response", "com.huawei.hms.common.api.Response");
        G2H.put("com.google.android.gms.fitness.request.DataTypeCreateRequest", "com.huawei.hms.hihealth.options.DataTypeAddOptions");
        G2H.put("com.google.android.gms.vision.Detector.Detections", "com.huawei.hms.mlsdk.common.MLAnalyzer.Result");
        G2H.put("com.google.android.gms.fitness.request.DataUpdateRequest", "com.huawei.hms.hihealth.options.UpdateOptions");
        G2H.put("com.google.android.gms.fitness.result.DataReadResponse", "com.huawei.hms.hihealth.result.ReadReply");
        G2H.put("com.google.android.gms.wallet.CreateWalletObjectsRequest", "com.huawei.hms.wallet.CreateWalletPassRequest");
        G2H.put("com.google.android.gms.maps.model.MarkerOptions", "com.huawei.hms.maps.model.MarkerOptions");
        G2H.put("com.google.android.gms.awareness.fence.HeadphoneFence", "com.huawei.hms.kit.awareness.barrier.HeadsetBarrier");
        G2H.put("com.google.android.gms.fitness.Fitness", "com.huawei.hms.hihealth.HuaweiHiHealth");
        G2H.put("com.google.android.gms.fitness.request.DataUpdateListenerRegistrationRequest", "com.huawei.hms.hihealth.options.ModifyDataMonitorOptions");
        G2H.put("com.google.android.gms.common.api.OptionalPendingResult", "com.huawei.hms.common.api.OptionalPendingResult");
        G2H.put("com.google.firebase.ml.vision.barcode.FirebaseVisionBarcodeDetectorOptions", "com.huawei.hms.ml.scan.HmsScanAnalyzerOptions");
        G2H.put("com.google.android.gms.awareness.state.BeaconState.TypeFilter", "com.huawei.hms.kit.awareness.status.BeaconStatus.Filter");
        G2H.put("com.google.android.gms.tasks.SuccessContinuation", "com.huawei.hmf.tasks.SuccessContinuation");
        G2H.put("com.google.android.gms.vision.barcode.Barcode.WiFi", "com.huawei.hms.ml.scan.HmsScan.WiFiConnectionInfo");
        G2H.put("com.google.android.gms.fitness.data.Session.Builder", "com.huawei.hms.hihealth.data.ActivityRecord.Builder");
        G2H.put("com.google.firebase.ml.vision.cloud.FirebaseVisionCloudDetectorOptions", "com.huawei.hms.mlsdk.landmark.MLRemoteLandmarkAnalyzerSetting");
        G2H.put("com.google.android.gms.nearby.messages.EddystoneUid", "com.huawei.hms.nearby.message.BeaconId");
        G2H.put("com.google.firebase.ml.vision.document.FirebaseVisionDocumentTextRecognizer", "com.huawei.hms.mlsdk.document.MLDocumentAnalyzer");
        G2H.put("com.google.android.gms.fitness.data.DataUpdateNotification", "com.huawei.hms.hihealth.data.DataModifyInfo");
        G2H.put("com.google.android.gms.wallet.AutoResolveHelper", "com.huawei.hms.wallet.ResolveTaskHelper");
        G2H.put("com.google.android.gms.games.leaderboard.LeaderboardVariant", "com.huawei.hms.jos.games.ranking.RankingVariant");
        G2H.put("com.google.android.gms.tasks.CancellationTokenSource", "com.huawei.hmf.tasks.CancellationTokenSource");
        G2H.put("com.google.android.gms.tasks.Tasks", "com.huawei.hmf.tasks.Tasks");
        G2H.put("com.google.android.gms.awareness.fence.FenceUpdateRequest.Builder", "com.huawei.hms.kit.awareness.barrier.BarrierUpdateRequest.Builder");
        G2H.put("com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode.GeoPoint", "com.huawei.hms.ml.scan.HmsScan.LocationCoordinate");
        G2H.put("com.google.android.gms.fitness.request.DataUpdateListenerRegistrationRequest.Builder", "com.huawei.hms.hihealth.options.ModifyDataMonitorOptions.Builder");
        G2H.put("com.google.android.gms.ads.formats.NativeAppInstallAdView", "com.huawei.hms.ads.nativead.NativeView");
        G2H.put("com.google.android.gms.games.snapshot.Snapshot", "com.huawei.hms.jos.games.archive.Archive");
        G2H.put("com.google.android.gms.games.GamesStatusCodes", "com.huawei.hms.jos.games.GamesStatusCodes");
        G2H.put("com.google.android.gms.nearby.connection.PayloadTransferUpdate", "com.huawei.hms.nearby.transfer.TransferStateUpdate");
        G2H.put("com.google.android.gms.ads.rewarded.RewardedAdLoadCallback", "com.huawei.hms.ads.reward.RewardAdLoadListener");
        G2H.put("com.google.android.gms.maps.model.IndoorBuilding", "com.huawei.hms.maps.model.IndoorBuilding");
        G2H.put("com.google.android.gms.games.SnapshotsClient.DataOrConflict", "com.huawei.hms.jos.games.archive.OperationResult");
        G2H.put("com.google.android.gms.common.GooglePlayServicesUtil", "com.huawei.hms.api.HuaweiMobileServicesUtil");
        G2H.put("com.google.android.gms.maps.GoogleMap.OnInfoWindowCloseListener", "com.huawei.hms.maps.HuaweiMap.OnInfoWindowCloseListener");
        G2H.put("com.google.android.gms.common.api.PendingResult", "com.huawei.hms.support.api.client.PendingResult");
        G2H.put("com.google.android.gms.common.ErrorDialogFragment", "com.huawei.hms.common.ErrorDialogFragment");
        G2H.put("com.google.android.gms.vision.MultiProcessor", "com.huawei.hms.mlsdk.common.MLCompositeTransactor");
        G2H.put("com.google.android.gms.fitness.request.DataReadRequest.Builder", "com.huawei.hms.hihealth.options.ReadOptions.Builder");
        G2H.put("com.google.android.gms.location.GeofencingEvent", "com.huawei.hms.location.GeofenceData");
        G2H.put("com.google.firebase.ml.vision.face.FirebaseVisionFaceLandmark", "com.huawei.hms.mlsdk.face.MLFaceKeyPoint");
        G2H.put("com.google.android.gms.fitness.request.DataSourcesRequest", "com.huawei.hms.hihealth.options.DataCollectorsOptions");
        G2H.put("com.google.android.gms.common.data.Freezable", "com.huawei.hms.common.data.Freezable");
        G2H.put("com.google.android.gms.vision.face.Landmark", "com.huawei.hms.mlsdk.face.MLFaceKeyPoint");
        G2H.put("com.google.android.gms.maps.UiSettings", "com.huawei.hms.maps.UiSettings");
        G2H.put("com.google.android.gms.nearby.messages.SubscribeCallback", "com.huawei.hms.nearby.message.GetCallback");
        G2H.put("com.google.firebase.ml.vision.barcode.FirebaseVisionBarcodeDetector", "com.huawei.hms.ml.scan.HmsScanAnalyzer");
        G2H.put("com.google.android.gms.nearby.connection.Payload", "com.huawei.hms.nearby.transfer.Data");
        G2H.put("com.google.android.gms.vision.barcode.BarcodeDetector.Builder", "com.huawei.hms.ml.scan.HmsScanAnalyzer.Creator");
        G2H.put("com.google.android.gms.ads.AdLoader.Builder", "com.huawei.hms.ads.nativead.NativeAdLoader.Builder");
        G2H.put("com.google.android.gms.awareness.snapshot.BeaconStateResponse", "com.huawei.hms.kit.awareness.capture.BeaconStatusResponse");
        G2H.put("com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode.Email", "com.huawei.hms.ml.scan.HmsScan.EmailContent");
        G2H.put("com.google.android.gms.awareness.AwarenessStatusCodes", "com.huawei.hms.kit.awareness.AwarenessStatusCodes");
        G2H.put("com.google.android.gms.common.api.Scope", "com.huawei.hms.support.api.entity.auth.Scope");
        G2H.put("com.google.android.gms.safetynet.SafetyNetApi.VerifyAppsUserResponse", "com.huawei.hms.support.api.entity.safetydetect.VerifyAppsCheckEnabledResp");
        G2H.put("com.google.android.gms.maps.GoogleMap.OnMarkerDragListener", "com.huawei.hms.maps.HuaweiMap.OnMarkerDragListener");
        G2H.put("com.google.android.gms.games.SnapshotsClient.SnapshotConflict", "com.huawei.hms.jos.games.archive.OperationResult.Difference");
        G2H.put("com.google.android.gms.nearby.messages.Distance.Accuracy", "com.huawei.hms.nearby.discovery.Distance.Precision");
        G2H.put("com.google.android.gms.maps.GoogleMap.CancelableCallback", "com.huawei.hms.maps.HuaweiMap.CancelableCallback");
        G2H.put("com.google.android.gms.fitness.result.DailyTotalResult", "com.huawei.hms.hihealth.result.DailyStatisticsResult");
        G2H.put("com.google.android.gms.maps.GoogleMap.OnPolylineClickListener", "com.huawei.hms.maps.HuaweiMap.OnPolylineClickListener");
        G2H.put("com.google.android.gms.location.Geofence", "com.huawei.hms.location.Geofence");
        G2H.put("com.google.android.gms.common.api.ApiException", "com.huawei.hms.common.ApiException");
        G2H.put("com.google.android.gms.games.leaderboard.Leaderboard", "com.huawei.hms.jos.games.ranking.Ranking");
        G2H.put("com.google.android.gms.games.PlayersClient", "com.huawei.hms.jos.games.PlayersClient");
        G2H.put("com.google.android.gms.ads.MuteThisAdReason", "com.huawei.hms.ads.nativead.DislikeAdReason");
        G2H.put("com.google.android.gms.security.ProviderInstaller", "com.huawei.hms.security.SecComponentInstallWizard");
        G2H.put("com.google.android.gms.games.leaderboard.ScoreSubmissionData", "com.huawei.hms.jos.games.ranking.ScoreSubmissionInfo");
        G2H.put("com.google.android.gms.awareness.state.HeadphoneState", "com.huawei.hms.kit.awareness.status.HeadsetStatus");
        G2H.put("com.google.android.gms.nearby.connection.DiscoveryOptions", "com.huawei.hms.nearby.discovery.ScanOption");
        G2H.put("com.google.android.gms.nearby.Nearby", "com.huawei.hms.nearby.Nearby");
        G2H.put("com.google.android.gms.vision.MultiProcessor.Builder", "com.huawei.hms.mlsdk.common.MLCompositeTransactor.Creator");
        G2H.put("com.google.android.gms.maps.model.SquareCap", "com.huawei.hms.maps.model.SquareCap");
        G2H.put("com.google.android.gms.games.LeaderboardsClient.LeaderboardScores", "com.huawei.hms.jos.games.RankingsClient.RankingScores");
        G2H.put("com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode", "com.huawei.hms.ml.scan.HmsScan");
        G2H.put("com.google.android.gms.location.ActivityTransitionEvent", "com.huawei.hms.location.ActivityConversionData");
        G2H.put("com.google.android.gms.nearby.connection.ConnectionLifecycleCallback", "com.huawei.hms.nearby.discovery.ConnectCallback");
        G2H.put("com.google.android.gms.common.SupportErrorDialogFragment", "com.huawei.hms.common.ErrDlgFragmentForSupport");
        G2H.put("com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode.CalendarEvent", "com.huawei.hms.ml.scan.HmsScan.EventInfo");
        G2H.put("com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks", "com.huawei.hms.ads.VideoOperator.VideoLifecycleListener");
        G2H.put("com.google.android.gms.safetynet.SafeBrowsingThreat", "com.huawei.hms.support.api.entity.safetydetect.UrlCheckThreat");
        G2H.put("com.google.android.gms.safetynet.SafetyNetApi.HarmfulAppsResponse", "com.huawei.hms.support.api.entity.safetydetect.MaliciousAppsListResp");
        G2H.put("com.google.android.gms.awareness.fence.DetectedActivityFence", "com.huawei.hms.kit.awareness.barrier.BehaviorBarrier");
        G2H.put("com.google.android.gms.tasks.OnCompleteListener", "com.huawei.hmf.tasks.OnCompleteListener");
        G2H.put("com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode.Sms", "com.huawei.hms.ml.scan.HmsScan.SmsContent");
        G2H.put("com.google.android.gms.nearby.connection.Payload.Type", "com.huawei.hms.nearby.transfer.Data.Type");
        G2H.put("com.google.android.gms.awareness.fence.LocationFence", "com.huawei.hms.kit.awareness.barrier.LocationBarrier");
        G2H.put("com.google.android.gms.fitness.data.Bucket", "com.huawei.hms.hihealth.data.Group");
        G2H.put("com.google.android.gms.nearby.messages.NearbyPermissions", "com.huawei.hms.nearby.message.Permission");
        G2H.put("com.google.android.gms.location.ActivityRecognitionClient", "com.huawei.hms.location.ActivityIdentificationService");
        G2H.put("com.google.android.gms.games.leaderboard.LeaderboardScore", "com.huawei.hms.jos.games.ranking.RankingScore");
        G2H.put("com.google.android.gms.nearby.messages.SubscribeOptions.Builder", "com.huawei.hms.nearby.message.GetOption.Builder");
        G2H.put("com.google.firebase.ml.vision.common.FirebaseVisionPoint", "com.huawei.hms.mlsdk.common.MLPosition");
        G2H.put("com.google.android.gms.maps.GoogleMap.OnPoiClickListener", "com.huawei.hms.maps.HuaweiMap.OnPoiClickListener");
        G2H.put("com.google.android.gms.games.EventsClient", "com.huawei.hms.jos.games.EventsClient");
        G2H.put("com.google.android.gms.maps.GoogleMap.OnCameraMoveListener", "com.huawei.hms.maps.HuaweiMap.OnCameraMoveListener");
        G2H.put("com.google.android.gms.nearby.connection.DiscoveryOptions.Builder", "com.huawei.hms.nearby.discovery.ScanOption.Builder");
        G2H.put("com.google.android.gms.fitness.request.DataReadRequest", "com.huawei.hms.hihealth.options.ReadOptions");
        G2H.put("com.google.android.gms.maps.model.LatLngBounds.Builder", "com.huawei.hms.maps.model.LatLngBounds.Builder");
        G2H.put("com.google.android.gms.common.api.CommonStatusCodes", "com.huawei.hms.common.api.CommonStatusCodes");
        G2H.put("com.google.android.gms.location.LocationRequest", "com.huawei.hms.location.LocationRequest");
        G2H.put("com.google.android.gms.ads.InterstitialAd", "com.huawei.hms.ads.InterstitialAd");
        G2H.put("com.google.android.gms.ads.rewarded.ServerSideVerificationOptions", "com.huawei.hms.ads.reward.RewardVerifyConfig");
        G2H.put("com.google.android.gms.ads.NativeExpressAdView", "com.huawei.hms.ads.template.view.NativeTemplateView");
        G2H.put("com.google.android.gms.fitness.data.DataType", "com.huawei.hms.hihealth.data.DataType");
        G2H.put("com.google.firebase.ml.vision.FirebaseVision", "com.huawei.hms.mlsdk.MLAnalyzerFactory");
        G2H.put("com.google.android.gms.tasks.OnCanceledListener", "com.huawei.hmf.tasks.OnCanceledListener");
        G2H.put("com.google.android.gms.vision.text.Text", "com.huawei.hms.mlsdk.text.MLText.Text");
        G2H.put("com.google.android.gms.nearby.messages.PublishOptions.Builder", "com.huawei.hms.nearby.message.PutOption.Builder");
        G2H.put("com.google.android.gms.maps.model.PolygonOptions", "com.huawei.hms.maps.model.PolygonOptions");
        G2H.put("com.google.android.gms.vision.barcode.Barcode.Sms", "com.huawei.hms.ml.scan.HmsScan.SmsContent");
        G2H.put("com.google.firebase.ml.vision.objects.FirebaseVisionObject", "com.huawei.hms.mlsdk.objects.MLObject");
        G2H.put("com.google.android.gms.common.api.ResultTransform", "com.huawei.hms.support.api.client.ResultConvert");
        G2H.put("com.google.firebase.ml.vision.document.FirebaseVisionCloudDocumentRecognizerOptions", "com.huawei.hms.mlsdk.document.MLDocumentSetting");
        G2H.put("com.google.android.gms.fitness.data.Session", "com.huawei.hms.hihealth.data.ActivityRecord");
        G2H.put("com.google.android.gms.location.ActivityTransitionRequest", "com.huawei.hms.location.ActivityConversionRequest");
        G2H.put("com.google.android.gms.nearby.messages.MessagesOptions", "com.huawei.hms.nearby.message.MessageOption");
        G2H.put("com.google.android.gms.tasks.Task", "com.huawei.hmf.tasks.Task");
        G2H.put("com.google.android.gms.maps.Projection", "com.huawei.hms.maps.Projection");
        G2H.put("com.google.android.gms.vision.barcode.Barcode.CalendarDateTime", "com.huawei.hms.ml.scan.HmsScan.EventTime");
        G2H.put("com.google.android.gms.vision.barcode.BarcodeDetector", "com.huawei.hms.ml.scan.HmsScanAnalyzer");
        G2H.put("com.google.android.gms.safetynet.SafetyNetApi.AttestationResponse", "com.huawei.hms.support.api.entity.safetydetect.SysIntegrityResp");
        G2H.put("com.google.android.gms.maps.GoogleMap.OnCameraMoveStartedListener", "com.huawei.hms.maps.HuaweiMap.OnCameraMoveStartedListener");
        G2H.put("com.google.android.gms.ads.reward.RewardItem", "com.huawei.hms.ads.reward.Reward");
        G2H.put("com.google.android.gms.maps.model.LatLng", "com.huawei.hms.maps.model.LatLng");
        G2H.put("com.google.android.gms.games.snapshot.SnapshotEntity", "com.huawei.hms.jos.games.archive.ArchiveImpl");
        G2H.put("com.google.android.gms.maps.GoogleMap.OnPolygonClickListener", "com.huawei.hms.maps.HuaweiMap.OnPolygonClickListener");
        G2H.put("com.google.android.gms.location.ActivityTransition", "com.huawei.hms.location.ActivityConversionInfo");
        G2H.put("com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener", "com.huawei.hms.maps.HuaweiMap.OnInfoWindowClickListener");
        G2H.put("com.google.android.gms.ads.MediaAspectRatio", "com.huawei.hms.ads.nativead.NativeAdConfiguration.MediaAspect");
        G2H.put("com.google.android.gms.common.data.DataBufferUtils", "com.huawei.hms.common.data.DataBufferUtils");
        G2H.put("com.google.android.gms.wallet.AutoResolvableVoidResult", "com.huawei.hms.wallet.AutoResolvableForegroundIntentResult");
        G2H.put("com.google.android.gms.common.api.GoogleApiClient", "com.huawei.hms.api.HuaweiApiClient");
        G2H.put("com.google.android.gms.maps.model.TileOverlay", "com.huawei.hms.maps.model.TileOverlay");
        G2H.put("com.google.firebase.ml.vision.common.FirebaseVisionImageMetadata", "com.huawei.hms.mlsdk.common.MLFrame.Property");
        G2H.put("com.google.firebase.analytics.FirebaseAnalytics", "com.huawei.hms.analytics.HiAnalyticsInstance");
        G2H.put("com.google.firebase.ml.vision.objects.FirebaseVisionObjectDetector", "com.huawei.hms.mlsdk.objects.MLObjectAnalyzer");
        G2H.put("com.google.android.gms.fitness.request.DataUpdateRequest.Builder", "com.huawei.hms.hihealth.options.UpdateOptions.Builder");
        G2H.put("com.google.android.gms.maps.GoogleMap.OnCameraIdleListener", "com.huawei.hms.maps.HuaweiMap.OnCameraIdleListener");
        G2H.put("com.google.android.gms.ads.AdListener", "com.huawei.hms.ads.AdListener");
        G2H.put("com.google.android.gms.vision.barcode.Barcode.ContactInfo", "com.huawei.hms.ml.scan.HmsScan.ContactDetail");
        G2H.put("com.android.installreferrer.api.InstallReferrerStateListener", "com.huawei.hms.ads.installreferrer.api.InstallReferrerStateListener");
        G2H.put("com.google.android.gms.nearby.connection.DiscoveredEndpointInfo", "com.huawei.hms.nearby.discovery.ScanEndpointInfo");
        G2H.put("com.google.android.gms.auth.api.signin.GoogleSignInClient", "com.huawei.hms.support.hwid.service.HuaweiIdAuthService");
        G2H.put("com.google.android.gms.vision.text.TextBlock", "com.huawei.hms.mlsdk.text.MLText.Block");
        G2H.put("com.google.android.gms.auth.api.signin.GoogleSignInApi", "com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService");
        G2H.put("com.google.android.gms.fitness.FitnessOptions.Builder", "com.huawei.hms.hihealth.HiHealthOptions.Builder");
        G2H.put("com.google.android.gms.ads.VideoOptions", "com.huawei.hms.ads.VideoConfiguration");
        G2H.put("com.google.android.gms.vision.face.Contour", "com.huawei.hms.mlsdk.face.MLFaceShape");
        G2H.put("com.google.android.gms.fitness.request.SessionReadRequest.Builder", "com.huawei.hms.hihealth.options.ActivityRecordReadOptions.Builder");
        G2H.put("com.google.android.gms.tasks.TaskCompletionSource", "com.huawei.hmf.tasks.TaskCompletionSource");
        G2H.put("com.google.android.gms.nearby.messages.NearbyMessagesStatusCodes", "com.huawei.hms.nearby.StatusCode");
        G2H.put("com.google.android.gms.ads.AdView", "com.huawei.hms.ads.banner.BannerView");
        G2H.put("com.google.android.gms.vision.Frame.Metadata", "com.huawei.hms.mlsdk.common.MLFrame.Property");
        G2H.put("com.google.firebase.ml.vision.face.FirebaseVisionFaceDetectorOptions.Builder", "com.huawei.hms.mlsdk.face.MLFaceAnalyzerSetting.Factory");
        G2H.put("com.google.android.gms.maps.model.PointOfInterest", "com.huawei.hms.maps.model.PointOfInterest");
        G2H.put("com.google.android.gms.nearby.connection.AdvertisingOptions.Builder", "com.huawei.hms.nearby.discovery.BroadcastOption.Builder");
        G2H.put("com.google.android.gms.nearby.connection.Strategy", "com.huawei.hms.nearby.discovery.Policy");
        G2H.put("com.google.android.gms.common.data.DataBufferObserver", "com.huawei.hms.common.data.DataBufferObserver");
        G2H.put("com.google.firebase.messaging.RemoteMessage.Notification", "com.huawei.hms.push.RemoteMessage.Notification");
        G2H.put("com.google.android.gms.ads.identifier.AdvertisingIdClient.Info", "com.huawei.hms.ads.identifier.AdvertisingIdClient.Info");
        G2H.put("com.google.android.gms.ads.formats.UnifiedNativeAd.MediaContent", "com.huawei.hms.ads.nativead.MediaContent");
        G2H.put("com.google.android.gms.common.images.WebImage", "com.huawei.hms.common.webserverpic.WebServerPic");
        G2H.put("com.google.android.gms.fitness.FitnessActivities", "com.huawei.hms.hihealth.HiHealthActivities");
        G2H.put("com.google.android.gms.vision.MultiProcessor.Factory", "com.huawei.hms.mlsdk.common.MLCompositeTransactor.TrailerFactory");
        G2H.put("com.google.android.gms.location.LocationCallback", "com.huawei.hms.location.LocationCallback");
        G2H.put("com.google.android.gms.nearby.messages.IBeaconId", "com.huawei.hms.nearby.message.BeaconId");
        G2H.put("com.google.android.gms.wallet.GiftCardWalletObject", "com.huawei.hms.wallet.pass.PassObject");
        G2H.put("com.google.android.gms.common.GooglePlayServicesNotAvailableException", "com.huawei.hms.api.HuaweiServicesNotAvailableException");
        G2H.put("com.google.android.gms.maps.model.RoundCap", "com.huawei.hms.maps.model.RoundCap");
        G2H.put("com.google.android.gms.awareness.state.TimeIntervals", "com.huawei.hms.kit.awareness.status.TimeCategories");
        G2H.put("com.google.android.gms.vision.barcode.Barcode.Address", "com.huawei.hms.ml.scan.HmsScan.AddressInfo");
        G2H.put("com.google.android.gms.common.GooglePlayServicesRepairableException", "com.huawei.hms.api.HuaweiServicesRepairableException");
        G2H.put("com.google.android.gms.common.api.ResolvableApiException", "com.huawei.hms.common.ResolvableApiException");
        G2H.put("com.google.android.gms.maps.model.PatternItem", "com.huawei.hms.maps.model.PatternItem");
        G2H.put("com.google.android.gms.fitness.data.DataPoint", "com.huawei.hms.hihealth.data.SamplePoint");
        G2H.put("com.google.android.gms.maps.GoogleMap.SnapshotReadyCallback", "com.huawei.hms.maps.HuaweiMap.SnapshotReadyCallback");
        G2H.put("com.google.android.gms.fitness.request.DataSourcesRequest.Builder", "com.huawei.hms.hihealth.options.DataCollectorsOptions.Builder");
        G2H.put("com.google.android.gms.maps.model.LatLngBounds", "com.huawei.hms.maps.model.LatLngBounds");
        G2H.put("com.google.android.gms.fitness.data.DataPoint.Builder", "com.huawei.hms.hihealth.data.SamplePoint.Builder");
        G2H.put("com.google.android.gms.location.GeofencingRequest", "com.huawei.hms.location.GeofenceRequest");
        G2H.put("com.google.android.gms.ads.AdRequest.Builder", "com.huawei.hms.ads.AdParam.Builder");
        G2H.put("com.google.android.gms.fitness.request.DataTypeCreateRequest.Builder", "com.huawei.hms.hihealth.options.DataTypeAddOptions.Builder");
        G2H.put("com.google.android.gms.fitness.request.SessionInsertRequest.Builder", "com.huawei.hms.hihealth.options.ActivityRecordInsertOptions.Builder");
        G2H.put("com.google.firebase.ml.vision.label.FirebaseVisionImageLabeler", "com.huawei.hms.mlsdk.classification.MLImageClassificationAnalyzer");
        G2H.put("com.google.android.gms.vision.MultiDetector", "com.huawei.hms.mlsdk.common.MLCompositeAnalyzer");
        G2H.put("com.google.firebase.ml.vision.label.FirebaseVisionImageLabel", "com.huawei.hms.mlsdk.classification.MLImageClassification");
        G2H.put("com.google.firebase.ml.vision.document.FirebaseVisionDocumentText.Word", "com.huawei.hms.mlsdk.document.MLDocument.Word");
        G2H.put("com.google.firebase.messaging.RemoteMessage", "com.huawei.hms.push.RemoteMessage");
        G2H.put("com.google.android.gms.awareness.Awareness", "com.huawei.hms.kit.awareness.Awareness");
        G2H.put("com.google.android.gms.maps.model.Polygon", "com.huawei.hms.maps.model.Polygon");
        G2H.put("com.google.android.gms.location.LocationSettingsStates", "com.huawei.hms.location.LocationSettingsStates");
        G2H.put("com.google.firebase.ml.vision.label.FirebaseVisionCloudImageLabelerOptions.Builder", "com.huawei.hms.mlsdk.classification.MLRemoteClassificationAnalyzerSetting.Factory");
        G2H.put("com.google.android.gms.nearby.messages.Strategy.Builder", "com.huawei.hms.nearby.message.Policy.Builder");
        G2H.put("com.google.android.gms.awareness.state.BeaconState", "com.huawei.hms.kit.awareness.status.BeaconStatus");
        G2H.put("com.google.android.gms.ads.VideoController", "com.huawei.hms.ads.VideoOperator");
        G2H.put("com.google.android.gms.maps.model.CircleOptions", "com.huawei.hms.maps.model.CircleOptions");
        G2H.put("com.google.android.gms.wallet.AutoResolvableResult", "com.huawei.hms.wallet.IResolvableTaskResult");
        G2H.put("com.google.android.gms.games.GamesClientStatusCodes", "com.huawei.hms.jos.games.GamesStatusCodes");
        G2H.put("com.google.android.gms.fitness.data.HealthDataTypes", "com.huawei.hms.hihealth.data.HealthDataTypes");
        G2H.put("com.google.android.gms.common.api.UnsupportedApiCallException", "com.huawei.hms.common.api.UnsupportedApiCallException");
        G2H.put("com.google.firebase.ml.vision.document.FirebaseVisionCloudDocumentRecognizerOptions.Builder", "com.huawei.hms.mlsdk.document.MLDocumentSetting.Factory");
        G2H.put("com.google.android.gms.actions.SearchIntents", "com.huawei.hms.actions.SearchIntents");
        G2H.put("com.google.firebase.ml.vision.face.FirebaseVisionFaceContour", "com.huawei.hms.mlsdk.face.MLFaceShape");
        G2H.put("com.google.android.gms.vision.CameraSource.PictureCallback", "com.huawei.hms.mlsdk.common.LensEngine.PhotographListener");
        G2H.put("com.google.firebase.messaging.FirebaseMessaging", "com.huawei.hms.push.HmsMessaging");
        G2H.put("com.google.firebase.iid.FirebaseInstanceId", "com.huawei.hms.aaid.HmsInstanceId");
        G2H.put("com.google.firebase.ml.vision.document.FirebaseVisionDocumentText.Block", "com.huawei.hms.mlsdk.document.MLDocument.Block");
        G2H.put("com.google.firebase.messaging.SendException", "com.huawei.hms.push.SendException");
        G2H.put("com.google.android.gms.awareness.fence.BeaconFence", "com.huawei.hms.kit.awareness.barrier.BeaconBarrier");
        G2H.put("com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension", "com.huawei.hms.support.hwid.request.HuaweiIdAuthExtendedParams");
        G2H.put("com.google.firebase.ml.common.FirebaseMLException", "com.huawei.hms.mlsdk.common.MLException");
        G2H.put("com.google.android.gms.vision.CameraSource.ShutterCallback", "com.huawei.hms.mlsdk.common.LensEngine.ShutterListener");
        G2H.put("com.google.android.gms.fitness.SessionsApi.ViewIntentBuilder", "com.huawei.hms.hihealth.ActivityRecordsManager.GetIntentInfos");
        G2H.put("com.google.android.gms.fitness.FitnessStatusCodes", "com.huawei.hms.hihealth.HiHealthStatusCodes");
        G2H.put("com.google.android.gms.safetynet.SafetyNetApi.RecaptchaTokenResponse", "com.huawei.hms.support.api.entity.safetydetect.UserDetectResponse");
        G2H.put("com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo", "com.huawei.hms.ads.nativead.NativeAd.ChoicesInfo");
        G2H.put("com.google.android.gms.games.event.EventEntity", "com.huawei.hms.jos.games.event.Event");
        G2H.put("com.google.android.gms.fitness.request.SensorRequest.Builder", "com.huawei.hms.hihealth.options.SensorOptions.Builder");
        G2H.put("com.google.android.gms.fitness.result.ListSubscriptionsResult", "com.huawei.hms.hihealth.result.ListRecordsResult");
        G2H.put("com.google.android.gms.games.event.Event", "com.huawei.hms.jos.games.event.Event");
        G2H.put("com.google.android.gms.identity.intents.model.UserAddress", "com.huawei.hms.identity.entity.UserAddress");
        G2H.put("com.google.android.gms.ads.doubleclick.PublisherInterstitialAd", "com.huawei.hms.ads.InterstitialAd");
        G2H.put("com.google.android.gms.fitness.HistoryClient", "com.huawei.hms.hihealth.DataController");
        G2H.put("com.google.android.gms.fitness.FitnessOptions", "com.huawei.hms.hihealth.HiHealthOptions");
        G2H.put("com.google.android.gms.auth.CookieUtil", "com.huawei.hms.support.hwid.tools.NetworkTool");
        G2H.put("com.google.android.gms.common.api.Api.ApiOptions.NoOptions", "com.huawei.hms.api.Api.ApiOptions.NoOptions");
        G2H.put("com.google.firebase.ml.vision.face.FirebaseVisionFaceDetector", "com.huawei.hms.mlsdk.face.MLFaceAnalyzer");
        G2H.put("com.google.android.gms.location.GeofencingRequest.Builder", "com.huawei.hms.location.GeofenceRequest.Builder");
        G2H.put("com.google.android.gms.nearby.connection.ConnectionsStatusCodes", "com.huawei.hms.nearby.StatusCode");
        G2H.put("com.google.android.gms.maps.model.Cap", "com.huawei.hms.maps.model.Cap");
        G2H.put("com.google.android.gms.nearby.messages.SubscribeOptions", "com.huawei.hms.nearby.message.GetOption");
        G2H.put("com.google.android.gms.ads.AdLoader", "com.huawei.hms.ads.nativead.NativeAdLoader");
        G2H.put("com.google.android.gms.nearby.messages.Messages", "com.huawei.hms.nearby.message.Messages");
        G2H.put("com.google.android.gms.common.api.BooleanResult", "com.huawei.hms.common.api.BooleanResult");
        G2H.put("com.google.android.gms.maps.OnMapReadyCallback", "com.huawei.hms.maps.OnMapReadyCallback");
        G2H.put("com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener", "com.huawei.hms.api.HuaweiApiClient.OnConnectionFailedListener");
        G2H.put("com.google.android.gms.awareness.snapshot.HeadphoneStateResponse", "com.huawei.hms.kit.awareness.capture.HeadsetStatusResponse");
        G2H.put("com.google.firebase.ml.vision.document.FirebaseVisionDocumentText.RecognizedBreak", "com.huawei.hms.mlsdk.document.MLDocument.Interval");
        G2H.put("com.google.android.gms.common.ConnectionResult", "com.huawei.hms.api.ConnectionResult");
        G2H.put("com.google.android.gms.awareness.fence.FenceQueryResponse", "com.huawei.hms.kit.awareness.barrier.BarrierQueryResponse");
        G2H.put("com.google.firebase.ml.vision.label.FirebaseVisionCloudImageLabelerOptions", "com.huawei.hms.mlsdk.classification.MLRemoteClassificationAnalyzerSetting");
        G2H.put("com.google.android.gms.fitness.data.Value", "com.huawei.hms.hihealth.data.Value");
        G2H.put("com.google.android.gms.ads.rewarded.ServerSideVerificationOptions.Builder", "com.huawei.hms.ads.reward.RewardVerifyConfig.Builder");
        G2H.put("com.google.android.gms.vision.CameraSource.Builder", "com.huawei.hms.mlsdk.common.LensEngine.Creator");
        G2H.put("com.google.firebase.ml.vision.text.FirebaseVisionText.Element", "com.huawei.hms.mlsdk.text.MLText.Word");
        G2H.put("com.google.android.gms.location.LocationSettingsResult", "com.huawei.hms.location.LocationSettingsResult");
        G2H.put("com.google.android.gms.ads.formats.NativeAdView", "com.huawei.hms.ads.nativead.NativeView");
        G2H.put("com.google.android.gms.games.stats.PlayerStats", "com.huawei.hms.jos.games.playerstats.GamePlayerStatistics");
        G2H.put("com.google.android.gms.maps.model.IndoorLevel", "com.huawei.hms.maps.model.IndoorLevel");
        G2H.put("com.google.android.gms.fitness.request.DataDeleteRequest", "com.huawei.hms.hihealth.options.DeleteOptions");
        G2H.put("com.google.android.gms.ads.formats.NativeAdViewHolder", "com.huawei.hms.ads.nativead.NativeAdMonitor");
        G2H.put("com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode.WiFi", "com.huawei.hms.ml.scan.HmsScan.WiFiConnectionInfo");
        G2H.put("com.google.firebase.ml.vision.label.FirebaseVisionOnDeviceImageLabelerOptions", "com.huawei.hms.mlsdk.classification.MLLocalClassificationAnalyzerSetting");
        G2H.put("com.google.android.gms.wallet.WalletConstants", "com.huawei.hms.wallet.constant.WalletPassConstant");
        G2H.put("com.google.android.gms.identity.intents.AddressConstants.Extras", "com.huawei.hms.identity.AddressConstants.Extras");
        G2H.put("com.google.android.gms.vision.Detector.Processor", "com.huawei.hms.mlsdk.common.MLAnalyzer.MLTransactor");
        G2H.put("com.google.firebase.ml.vision.text.RecognizedLanguage", "com.huawei.hms.mlsdk.text.TextLanguage");
        G2H.put("com.google.android.gms.location.SettingsClient", "com.huawei.hms.location.SettingsClient");
        G2H.put("com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode.ContactInfo", "com.huawei.hms.ml.scan.HmsScan.ContactDetail");
        G2H.put("com.google.android.gms.games.LeaderboardsClient", "com.huawei.hms.jos.games.RankingsClient");
        G2H.put("com.google.firebase.ml.vision.face.FirebaseVisionFaceDetectorOptions", "com.huawei.hms.mlsdk.face.MLFaceAnalyzerSetting");
        G2H.put("com.google.android.gms.maps.model.PolylineOptions", "com.huawei.hms.maps.model.PolylineOptions");
        G2H.put("com.google.android.gms.maps.GoogleMap", "com.huawei.hms.maps.HuaweiMap");
        G2H.put("com.google.android.gms.common.data.DataBuffer", "com.huawei.hms.common.data.DataBuffer");
        G2H.put("com.google.firebase.analytics.FirebaseAnalytics.Param", "com.huawei.hms.analytics.type.HAParamType");
        G2H.put("com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes", "com.huawei.hms.support.hwid.result.HuaweiIdAuthResultCode");
        G2H.put("com.google.android.gms.fitness.data.DataSet.Builder", "com.huawei.hms.hihealth.data.SampleSet.Builder");
        G2H.put("com.google.firebase.ml.vision.text.FirebaseVisionCloudTextRecognizerOptions.Builder", "com.huawei.hms.mlsdk.text.MLRemoteTextSetting.Factory");
        G2H.put("com.google.firebase.analytics.FirebaseAnalytics.UserProperty", "com.huawei.hms.analytics.type.HAParamType");
        G2H.put("com.google.android.gms.fitness.request.SessionReadRequest", "com.huawei.hms.hihealth.options.ActivityRecordReadOptions");
        G2H.put("com.google.android.gms.nearby.connection.AdvertisingOptions", "com.huawei.hms.nearby.discovery.BroadcastOption");
        G2H.put("com.google.android.gms.vision.barcode.Barcode.UrlBookmark", "com.huawei.hms.ml.scan.HmsScan.LinkUrl");
        G2H.put("com.google.android.gms.nearby.connection.ConnectionResolution", "com.huawei.hms.nearby.discovery.ConnectResult");
        G2H.put("com.google.android.gms.ads.formats.NativeAd.Image", "com.huawei.hms.ads.Image");
        G2H.put("com.google.android.gms.maps.GoogleMapOptions", "com.huawei.hms.maps.HuaweiMapOptions");
        G2H.put("com.google.android.gms.maps.model.CameraPosition", "com.huawei.hms.maps.model.CameraPosition");
        G2H.put("com.google.android.gms.ads.formats.UnifiedNativeAdView", "com.huawei.hms.ads.nativead.NativeView");
        G2H.put("com.google.android.gms.common.api.ResolvingResultCallbacks", "com.huawei.hms.support.api.client.ResolvingResultCallbacks");
        G2H.put("com.google.android.gms.awareness.fence.FenceState", "com.huawei.hms.kit.awareness.barrier.BarrierStatus");
        G2H.put("com.google.android.gms.common.images.Size", "com.huawei.hms.common.size.Size");
        G2H.put("com.google.android.gms.common.api.Api.ApiOptions.HasOptions", "com.huawei.hms.api.Api.ApiOptions.HasOptions");
        G2H.put("com.google.android.gms.fitness.data.HealthFields", "com.huawei.hms.hihealth.data.HealthFields");
        G2H.put("com.google.android.gms.games.leaderboard.ScoreSubmissionData.Result", "com.huawei.hms.jos.games.ranking.ScoreSubmissionInfo.Result");
        G2H.put("com.google.android.gms.fitness.request.StartBleScanRequest.Builder", "com.huawei.hms.hihealth.options.StartBleScanOptions.Builder");
        G2H.put("com.google.android.gms.maps.CameraUpdateFactory", "com.huawei.hms.maps.CameraUpdateFactory");
        G2H.put("com.google.android.gms.maps.model.Tile", "com.huawei.hms.maps.model.Tile");
        G2H.put("com.google.firebase.ml.vision.cloud.FirebaseVisionCloudDetectorOptions.Builder", "com.huawei.hms.mlsdk.landmark.MLRemoteLandmarkAnalyzerSetting.Factory");
        G2H.put("com.google.android.gms.maps.model.Gap", "com.huawei.hms.maps.model.Gap");
        G2H.put("com.google.android.gms.games.GamesClient", "com.huawei.hms.jos.games.GamesClient");
        G2H.put("com.google.android.gms.ads.rewarded.RewardedAd", "com.huawei.hms.ads.reward.RewardAd");
        G2H.put("com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer", "com.huawei.hms.mlsdk.text.MLTextAnalyzer");
        G2H.put("com.google.android.gms.location.FusedLocationProviderClient", "com.huawei.hms.location.FusedLocationProviderClient");
        G2H.put("com.google.android.gms.ads.formats.MediaView", "com.huawei.hms.ads.nativead.MediaView");
        G2H.put("com.google.firebase.ml.vision.label.FirebaseVisionOnDeviceImageLabelerOptions.Builder", "com.huawei.hms.mlsdk.classification.MLLocalClassificationAnalyzerSetting.Factory");
        G2H.put("com.google.android.gms.nearby.messages.MessageListener", "com.huawei.hms.nearby.message.MessageHandler");
        G2H.put("com.google.android.gms.fitness.result.DataReadResult", "com.huawei.hms.hihealth.result.ReadDetailResult");
        G2H.put("com.google.android.gms.wallet.LoyaltyWalletObject.Builder", "com.huawei.hms.wallet.pass.PassObject.Builder");
        G2H.put("com.android.installreferrer.api.InstallReferrerClient", "com.huawei.hms.ads.installreferrer.api.InstallReferrerClient");
        G2H.put("com.google.firebase.ml.vision.face.FirebaseVisionFace", "com.huawei.hms.mlsdk.face.MLFace");
        G2H.put("com.google.android.gms.awareness.FenceClient", "com.huawei.hms.kit.awareness.BarrierClient");
        G2H.put("com.google.android.gms.common.api.GoogleApiClient.Builder", "com.huawei.hms.api.HuaweiApiClient.Builder");
        G2H.put("com.google.android.gms.vision.barcode.Barcode.GeoPoint", "com.huawei.hms.ml.scan.HmsScan.LocationCoordinate");
        G2H.put("com.google.android.gms.fitness.result.SessionReadResult", "com.huawei.hms.hihealth.result.ActivityRecordResult");
        G2H.put("com.google.firebase.ml.vision.document.FirebaseVisionDocumentText", "com.huawei.hms.mlsdk.document.MLDocument");
        G2H.put("com.google.android.gms.awareness.snapshot.LocationResponse", "com.huawei.hms.kit.awareness.capture.LocationResponse");
        G2H.put("com.google.android.gms.location.LocationResult", "com.huawei.hms.location.LocationResult");
        G2H.put("com.google.android.gms.safetynet.HarmfulAppsData", "com.huawei.hms.support.api.entity.safetydetect.MaliciousAppsData");
        G2H.put("com.google.android.gms.maps.GoogleMap.OnMapLoadedCallback", "com.huawei.hms.maps.HuaweiMap.OnMapLoadedCallback");
        G2H.put("com.google.firebase.messaging.RemoteMessage.Builder", "com.huawei.hms.push.RemoteMessage.Builder");
        G2H.put("com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode.PersonName", "com.huawei.hms.ml.scan.HmsScan.PeopleName");
        G2H.put("com.google.android.gms.maps.GoogleMap.OnMyLocationClickListener", "com.huawei.hms.maps.HuaweiMap.OnMyLocationClickListener");
        G2H.put("com.google.android.gms.maps.MapsInitializer", "com.huawei.hms.maps.MapsInitializer");
        G2H.put("com.google.android.gms.fitness.request.OnDataPointListener", "com.huawei.hms.hihealth.options.OnSamplePointListener");
        H2G.put("com.huawei.hms.nearby.discovery.BleSignal", "com.google.android.gms.nearby.messages.BleSignal");
        H2G.put("com.huawei.hms.maps.model.MapStyleOptions", "com.google.android.gms.maps.model.MapStyleOptions");
        H2G.put("com.huawei.hms.mlsdk.landmark.MLRemoteLandmark", "com.google.firebase.ml.vision.cloud.landmark.FirebaseVisionCloudLandmark");
        H2G.put("com.huawei.hms.ads.VideoConfiguration.Builder", "com.google.android.gms.ads.VideoOptions.Builder");
        H2G.put("com.huawei.hms.nearby.message.MessageEngine", "com.google.android.gms.nearby.messages.MessagesClient");
        H2G.put("com.huawei.hms.ads.BannerAdSize", "com.google.android.gms.ads.AdSize");
        H2G.put("com.huawei.hms.jos.games.Games", "com.google.android.gms.games.Games");
        H2G.put("com.huawei.hms.location.GeofenceService", "com.google.android.gms.location.GeofencingClient");
        H2G.put("com.huawei.hms.ml.scan.HmsScan.PeopleName", "com.google.android.gms.vision.barcode.Barcode.PersonName");
        H2G.put("com.huawei.hms.support.hwid.result.HuaweiIdAuthResult", "com.google.android.gms.auth.api.signin.GoogleSignInResult");
        H2G.put("com.huawei.hms.common.data.AbstractDataBuffer", "com.google.android.gms.common.data.AbstractDataBuffer");
        H2G.put("com.huawei.hms.nearby.message.StatusCallback", "com.google.android.gms.nearby.messages.StatusCallback");
        H2G.put("com.huawei.hms.hihealth.data.DataCollector", "com.google.android.gms.fitness.data.DataSource");
        H2G.put("com.huawei.hms.common.data.FreezableUtils", "com.google.android.gms.common.data.FreezableUtils");
        H2G.put("com.huawei.hms.ads.reward.Reward", "com.google.android.gms.ads.rewarded.RewardItem");
        H2G.put("com.huawei.hms.maps.model.Dot", "com.google.android.gms.maps.model.Dot");
        H2G.put("com.huawei.hms.mlsdk.face.MLMaxSizeFaceTransactor.Creator", "com.google.android.gms.vision.face.LargestFaceFocusingProcessor.Builder");
        H2G.put("com.huawei.hms.ads.reward.RewardAdListener", "com.google.android.gms.ads.reward.RewardedVideoAdListener");
        H2G.put("com.huawei.hms.hihealth.BleController", "com.google.android.gms.fitness.BleClient");
        H2G.put("com.huawei.hms.ads.installreferrer.api.ReferrerDetails", "com.android.installreferrer.api.ReferrerDetails");
        H2G.put("com.huawei.hms.jos.games.gamesummary.GameSummary", "com.google.android.gms.games.Game");
        H2G.put("com.huawei.hms.mlsdk.common.MLFrame.Creator", "com.google.android.gms.vision.Frame.Builder");
        H2G.put("com.huawei.hms.mlsdk.common.MLFrame", "com.google.firebase.ml.vision.common.FirebaseVisionImage");
        H2G.put("com.huawei.hms.kit.awareness.CaptureClient", "com.google.android.gms.awareness.SnapshotClient");
        H2G.put("com.huawei.hms.nearby.transfer.DataCallback", "com.google.android.gms.nearby.connection.PayloadCallback");
        H2G.put("com.huawei.hms.jos.games.GameSummaryClient", "com.google.android.gms.games.GamesMetadataClient");
        H2G.put("com.huawei.hms.hihealth.data.Record", "com.google.android.gms.fitness.data.Subscription");
        H2G.put("com.huawei.hms.ads.nativead.NativeAdConfiguration.Builder", "com.google.android.gms.ads.formats.NativeAdOptions.Builder");
        H2G.put("com.huawei.hms.mlsdk.text.MLText.Block", "com.google.firebase.ml.vision.text.FirebaseVisionText.TextBlock");
        H2G.put("com.huawei.hms.kit.awareness.barrier.BarrierUpdateRequest", "com.google.android.gms.awareness.fence.FenceUpdateRequest");
        H2G.put("com.huawei.hms.mlsdk.text.MLTextAnalyzer", "com.google.android.gms.vision.text.TextRecognizer");
        H2G.put("com.huawei.hms.maps.HuaweiMap.OnIndoorStateChangeListener", "com.google.android.gms.maps.GoogleMap.OnIndoorStateChangeListener");
        H2G.put("com.huawei.hms.hihealth.SensorsController", "com.google.android.gms.fitness.SensorsClient");
        H2G.put("com.huawei.hms.maps.model.TileProvider", "com.google.android.gms.maps.model.TileProvider");
        H2G.put("com.huawei.hms.maps.LocationSource.OnLocationChangedListener", "com.google.android.gms.maps.LocationSource.OnLocationChangedListener");
        H2G.put("com.huawei.hms.maps.model.ButtCap", "com.google.android.gms.maps.model.ButtCap");
        H2G.put("com.huawei.hms.ml.scan.HmsScan.EventTime", "com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode.CalendarDateTime");
        H2G.put("com.huawei.hms.mlsdk.common.MLResultTrailer", "com.google.android.gms.vision.Tracker");
        H2G.put("com.huawei.hms.nearby.discovery.Distance", "com.google.android.gms.nearby.messages.Distance");
        H2G.put("com.huawei.hms.jos.games.archive.ArchiveSummaryUpdate.Builder", "com.google.android.gms.games.snapshot.SnapshotMetadataChange.Builder");
        H2G.put("com.huawei.hms.hihealth.result.ActivityRecordReply", "com.google.android.gms.fitness.result.SessionReadResponse");
        H2G.put("com.huawei.hms.identity.AddressConstants", "com.google.android.gms.identity.intents.AddressConstants");
        H2G.put("com.huawei.hmf.tasks.OnFailureListener", "com.google.android.gms.tasks.OnFailureListener");
        H2G.put("com.huawei.hms.hihealth.options.DeleteOptions.Builder", "com.google.android.gms.fitness.request.DataDeleteRequest.Builder");
        H2G.put("com.huawei.hms.support.api.safetydetect.SafetyDetectStatusCodes", "com.google.android.gms.safetynet.SafetyNetStatusCodes");
        H2G.put("com.huawei.hms.nearby.message.PutOption", "com.google.android.gms.nearby.messages.PublishOptions");
        H2G.put("com.huawei.hms.maps.model.BitmapDescriptor", "com.google.android.gms.maps.model.BitmapDescriptor");
        H2G.put("com.huawei.hms.maps.LocationSource", "com.google.android.gms.maps.LocationSource");
        H2G.put("com.huawei.hms.support.api.safetydetect.SafetyDetectClient", "com.google.android.gms.safetynet.SafetyNetClient");
        H2G.put("com.huawei.hms.maps.model.Dash", "com.google.android.gms.maps.model.Dash");
        H2G.put("com.huawei.hms.maps.HuaweiMap.OnMapLongClickListener", "com.google.android.gms.maps.GoogleMap.OnMapLongClickListener");
        H2G.put("com.huawei.hms.jos.games.achievement.Achievement", "com.google.android.gms.games.achievement.AchievementEntity");
        H2G.put("com.huawei.hms.location.LocationAvailability", "com.google.android.gms.location.LocationAvailability");
        H2G.put("com.huawei.hms.maps.HuaweiMap.OnMapClickListener", "com.google.android.gms.maps.GoogleMap.OnMapClickListener");
        H2G.put("com.huawei.hms.jos.games.player.Player", "com.google.android.gms.games.Player");
        H2G.put("com.huawei.hms.analytics.type.HAEventType", "com.google.firebase.analytics.FirebaseAnalytics.Event");
        H2G.put("com.huawei.hms.jos.games.achievement.Achievement", "com.google.android.gms.games.achievement.Achievement");
        H2G.put("com.huawei.hms.nearby.transfer.TransferStateUpdate.Status", "com.google.android.gms.nearby.connection.PayloadTransferUpdate.Status");
        H2G.put("com.huawei.hms.jos.games.archive.ArchiveSummaryUpdate", "com.google.android.gms.games.snapshot.SnapshotMetadataChange");
        H2G.put("com.huawei.hms.mlsdk.text.MLText.TextLine", "com.google.firebase.ml.vision.text.FirebaseVisionText.Line");
        H2G.put("com.huawei.hms.mlsdk.common.MLAnalyzer", "com.google.android.gms.vision.Detector");
        H2G.put("com.huawei.hms.kit.awareness.status.BeaconStatus.BeaconData", "com.google.android.gms.awareness.state.BeaconState.BeaconInfo");
        H2G.put("com.huawei.hms.ml.scan.HmsScan", "com.google.android.gms.vision.barcode.Barcode");
        H2G.put("com.huawei.hms.hihealth.DataManager.GetIntentInfos", "com.google.android.gms.fitness.HistoryApi.ViewIntentBuilder");
        H2G.put("com.huawei.hms.api.Api.ApiOptions", "com.google.android.gms.common.api.Api.ApiOptions");
        H2G.put("com.huawei.hms.hihealth.options.StartBleScanOptions", "com.google.android.gms.fitness.request.StartBleScanRequest");
        H2G.put("com.huawei.hms.support.api.safetydetect.SafetyDetect", "com.google.android.gms.safetynet.SafetyNet");
        H2G.put("com.huawei.hms.jos.games.archive.ArchiveSummary", "com.google.android.gms.games.snapshot.SnapshotMetadata");
        H2G.put("com.huawei.hms.ads.installreferrer.commons.InstallReferrerCommons", "com.android.installreferrer.commons.InstallReferrerCommons");
        H2G.put("com.huawei.hms.api.Api.ApiOptions.Optional", "com.google.android.gms.common.api.Api.ApiOptions.Optional");
        H2G.put("com.huawei.hms.panorama.PanoramaInterface.ImageInfoResult", "com.google.android.gms.panorama.PanoramaApi.PanoramaResult");
        H2G.put("com.huawei.hms.ml.scan.HmsScanAnalyzerOptions.Creator", "com.google.firebase.ml.vision.barcode.FirebaseVisionBarcodeDetectorOptions.Builder");
        H2G.put("com.huawei.hms.hihealth.result.DataCollectorsResult", "com.google.android.gms.fitness.result.DataSourcesResult");
        H2G.put("com.huawei.hms.mlsdk.common.MLFrame", "com.google.android.gms.vision.Frame");
        H2G.put("com.huawei.hms.mlsdk.face.MLFaceAnalyzer.Factory", "com.google.android.gms.vision.face.FaceDetector.Builder");
        H2G.put("com.huawei.hms.hihealth.options.BleScanCallback", "com.google.android.gms.fitness.request.BleScanCallback");
        H2G.put("com.huawei.hms.support.api.hwid.HuaweiAccountOptions.HasAccountOptions", "com.google.android.gms.common.api.Api.ApiOptions.HasAccountOptions");
        H2G.put("com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper", "com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder");
        H2G.put("com.huawei.hms.nearby.message.MessagePicker", "com.google.android.gms.nearby.messages.MessageFilter");
        H2G.put("com.huawei.hms.location.LocationSettingsStatusCodes", "com.google.android.gms.location.LocationSettingsStatusCodes");
        H2G.put("com.huawei.hms.hihealth.result.BleDeviceInfosResult", "com.google.android.gms.fitness.result.BleDevicesResult");
        H2G.put("com.huawei.hms.maps.model.TileOverlayOptions", "com.google.android.gms.maps.model.TileOverlayOptions");
        H2G.put("com.huawei.hms.support.api.client.ResultCallbacks", "com.google.android.gms.common.api.ResultCallbacks");
        H2G.put("com.huawei.hms.kit.awareness.capture.TimeCategoriesResponse", "com.google.android.gms.awareness.snapshot.TimeIntervalsResponse");
        H2G.put("com.huawei.hms.api.HuaweiApiAvailability", "com.google.android.gms.common.GoogleApiAvailability");
        H2G.put("com.huawei.hms.support.api.client.Result", "com.google.android.gms.common.api.Result");
        H2G.put("com.huawei.hms.ads.nativead.NativeAd.NativeAdLoadedListener", "com.google.android.gms.ads.formats.UnifiedNativeAd.OnUnifiedNativeAdLoadedListener");
        H2G.put("com.huawei.hmf.tasks.CancellationToken", "com.google.android.gms.tasks.CancellationToken");
        H2G.put("com.huawei.hms.hihealth.data.DataCollector.Builder", "com.google.android.gms.fitness.data.DataSource.Builder");
        H2G.put("com.huawei.hms.location.ActivityConversionResponse", "com.google.android.gms.location.ActivityTransitionResult");
        H2G.put("com.huawei.hms.ads.reward.OnMetadataChangedListener", "com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener");
        H2G.put("com.huawei.hms.mlsdk.text.MLText.TextLine", "com.google.android.gms.vision.text.Line");
        H2G.put("com.huawei.hms.nearby.discovery.ScanEndpointCallback", "com.google.android.gms.nearby.connection.EndpointDiscoveryCallback");
        H2G.put("com.huawei.hms.nearby.message.MessagePicker.Builder", "com.google.android.gms.nearby.messages.MessageFilter.Builder");
        H2G.put("com.huawei.hms.location.LocationSettingsRequest", "com.google.android.gms.location.LocationSettingsRequest");
        H2G.put("com.huawei.hms.ads.nativead.DislikeAdListener", "com.google.android.gms.ads.MuteThisAdListener");
        H2G.put("com.huawei.hms.ml.scan.HmsScan.TelPhoneNumber", "com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode.Phone");
        H2G.put("com.huawei.hms.maps.HuaweiMap.OnMarkerClickListener", "com.google.android.gms.maps.GoogleMap.OnMarkerClickListener");
        H2G.put("com.huawei.hms.mlsdk.objects.MLObjectAnalyzerSetting", "com.google.firebase.ml.vision.objects.FirebaseVisionObjectDetectorOptions");
        H2G.put("com.huawei.hms.jos.games.AchievementsClient", "com.google.android.gms.games.AchievementsClient");
        H2G.put("com.huawei.hms.hihealth.SettingController", "com.google.android.gms.fitness.ConfigClient");
        H2G.put("com.huawei.hms.wallet.pass.PassObject.Builder", "com.google.android.gms.wallet.GiftCardWalletObject.Builder");
        H2G.put("com.huawei.hms.ml.scan.HmsScan.DriverInfo", "com.google.android.gms.vision.barcode.Barcode.DriverLicense");
        H2G.put("com.huawei.hms.mlsdk.common.MLProminentTransactor", "com.google.android.gms.vision.FocusingProcessor");
        H2G.put("com.huawei.hms.nearby.message.Policy", "com.google.android.gms.nearby.messages.Strategy");
        H2G.put("com.huawei.hms.mlsdk.face.MLMaxSizeFaceTransactor", "com.google.android.gms.vision.face.LargestFaceFocusingProcessor");
        H2G.put("com.huawei.hms.wallet.pass.PassObject", "com.google.android.gms.wallet.OfferWalletObject");
        H2G.put("com.huawei.hms.location.ActivityConversionInfo.Builder", "com.google.android.gms.location.ActivityTransition.Builder");
        H2G.put("com.huawei.hms.ml.scan.HmsScan.EmailContent", "com.google.android.gms.vision.barcode.Barcode.Email");
        H2G.put("com.huawei.hms.support.api.client.ConvertedResult", "com.google.android.gms.common.api.TransformedResult");
        H2G.put("com.huawei.hmf.tasks.Continuation", "com.google.android.gms.tasks.Continuation");
        H2G.put("com.huawei.hms.maps.model.CustomCap", "com.google.android.gms.maps.model.CustomCap");
        H2G.put("com.huawei.hms.kit.awareness.barrier.BarrierStatusMap", "com.google.android.gms.awareness.fence.FenceStateMap");
        H2G.put("com.huawei.hms.hihealth.options.ActivityRecordInsertOptions", "com.google.android.gms.fitness.request.SessionInsertRequest");
        H2G.put("com.huawei.hms.nearby.message.MessageOption.Builder", "com.google.android.gms.nearby.messages.MessagesOptions.Builder");
        H2G.put("com.huawei.hms.location.LocationServices", "com.google.android.gms.location.LocationServices");
        H2G.put("com.huawei.hms.api.HuaweiApiClient.ConnectionCallbacks", "com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks");
        H2G.put("com.huawei.hms.maps.CameraUpdate", "com.google.android.gms.maps.CameraUpdate");
        H2G.put("com.huawei.hms.wallet.WalletPassClient", "com.google.android.gms.wallet.WalletObjectsClient");
        H2G.put("com.huawei.hms.maps.model.RuntimeRemoteException", "com.google.android.gms.maps.model.RuntimeRemoteException");
        H2G.put("com.huawei.hms.support.hwid.tools.HuaweiIdAuthTool", "com.google.android.gms.auth.GoogleAuthUtil");
        H2G.put("com.huawei.hms.maps.model.JointType", "com.google.android.gms.maps.model.JointType");
        H2G.put("com.huawei.hms.ads.ChoicesView", "com.google.android.gms.ads.formats.AdChoicesView");
        H2G.put("com.huawei.hms.ads.nativead.NativeView", "com.google.android.gms.ads.formats.NativeContentAdView");
        H2G.put("com.huawei.hms.mlsdk.text.MLText.Word", "com.google.android.gms.vision.text.Element");
        H2G.put("com.huawei.hms.mlsdk.text.MLText", "com.google.firebase.ml.vision.text.FirebaseVisionText");
        H2G.put("com.huawei.hms.kit.awareness.barrier.BarrierQueryRequest", "com.google.android.gms.awareness.fence.FenceQueryRequest");
        H2G.put("com.huawei.hms.maps.model.Marker", "com.google.android.gms.maps.model.Marker");
        H2G.put("com.huawei.hms.security.SecComponentInstallWizard.SecComponentInstallWizardListener", "com.google.android.gms.security.ProviderInstaller.ProviderInstallListener");
        H2G.put("com.huawei.hms.maps.model.Polyline", "com.google.android.gms.maps.model.Polyline");
        H2G.put("com.huawei.hms.location.ActivityIdentificationResponse", "com.google.android.gms.location.ActivityRecognitionResult");
        H2G.put("com.huawei.hms.maps.model.Circle", "com.google.android.gms.maps.model.Circle");
        H2G.put("com.huawei.hms.mlsdk.document.MLDocument.Character", "com.google.firebase.ml.vision.document.FirebaseVisionDocumentText.Symbol");
        H2G.put("com.huawei.hms.hihealth.data.BleDeviceInfo", "com.google.android.gms.fitness.data.BleDevice");
        H2G.put("com.huawei.hms.location.ActivityIdentificationData", "com.google.android.gms.location.DetectedActivity");
        H2G.put("com.huawei.hms.api.UserRecoverableException", "com.google.android.gms.common.UserRecoverableException");
        H2G.put("com.huawei.hms.nearby.message.Message", "com.google.android.gms.nearby.messages.Message");
        H2G.put("com.huawei.hms.mlsdk.common.MLFrame.Property.Creator", "com.google.firebase.ml.vision.common.FirebaseVisionImageMetadata.Builder");
        H2G.put("com.huawei.hms.hihealth.data.Field", "com.google.android.gms.fitness.data.Field");
        H2G.put("com.huawei.hms.mlsdk.document.MLDocument.Section", "com.google.firebase.ml.vision.document.FirebaseVisionDocumentText.Paragraph");
        H2G.put("com.huawei.hmf.tasks.OnSuccessListener", "com.google.android.gms.tasks.OnSuccessListener");
        H2G.put("com.huawei.hms.api.Api", "com.google.android.gms.common.api.Api");
        H2G.put("com.huawei.hms.mlsdk.common.MLCompositeAnalyzer.Creator", "com.google.android.gms.vision.MultiDetector.Builder");
        H2G.put("com.huawei.hms.mlsdk.objects.MLObjectAnalyzerSetting.Factory", "com.google.firebase.ml.vision.objects.FirebaseVisionObjectDetectorOptions.Builder");
        H2G.put("com.huawei.hms.location.LocationSettingsRequest.Builder", "com.google.android.gms.location.LocationSettingsRequest.Builder");
        H2G.put("com.huawei.hms.maps.MapView", "com.google.android.gms.maps.MapView");
        H2G.put("com.huawei.hms.jos.games.ArchivesClient", "com.google.android.gms.games.SnapshotsClient");
        H2G.put("com.huawei.hms.hihealth.AutoRecorderController", "com.google.android.gms.fitness.RecordingClient");
        H2G.put("com.huawei.hms.location.LocationSettingsResponse", "com.google.android.gms.location.LocationSettingsResponse");
        H2G.put("com.huawei.hms.hihealth.ActivityRecordsController", "com.google.android.gms.fitness.SessionsClient");
        H2G.put("com.huawei.hms.ml.scan.HmsScan.TelPhoneNumber", "com.google.android.gms.vision.barcode.Barcode.Phone");
        H2G.put("com.huawei.hms.maps.HuaweiMap.OnCircleClickListener", "com.google.android.gms.maps.GoogleMap.OnCircleClickListener");
        H2G.put("com.huawei.hms.nearby.message.PutCallback", "com.google.android.gms.nearby.messages.PublishCallback");
        H2G.put("com.huawei.hms.support.sms.common.ReadSmsConstant", "com.google.android.gms.auth.api.phone.SmsRetriever");
        H2G.put("com.huawei.hms.maps.HuaweiMap.OnInfoWindowLongClickListener", "com.google.android.gms.maps.GoogleMap.OnInfoWindowLongClickListener");
        H2G.put("com.huawei.hms.ads.RequestOptions.Builder", "com.google.android.gms.ads.RequestConfiguration.Builder");
        H2G.put("com.huawei.hms.location.Geofence.Builder", "com.google.android.gms.location.Geofence.Builder");
        H2G.put("com.huawei.hms.maps.model.VisibleRegion", "com.google.android.gms.maps.model.VisibleRegion");
        H2G.put("com.huawei.hms.ml.scan.HmsScan.DriverInfo", "com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode.DriverLicense");
        H2G.put("com.huawei.hms.api.Api.ApiOptions.NotRequiredOptions", "com.google.android.gms.common.api.Api.ApiOptions.NotRequiredOptions");
        H2G.put("com.huawei.hms.wallet.pass.PassObject", "com.google.android.gms.wallet.LoyaltyWalletObject");
        H2G.put("com.huawei.hms.support.hwid.HuaweiIdAuthAPIManager", "com.google.android.gms.auth.api.Auth");
        H2G.put("com.huawei.hms.ads.identifier.AdvertisingIdClient", "com.google.android.gms.ads.identifier.AdvertisingIdClient");
        H2G.put("com.huawei.hms.analytics.HiAnalyticsInstallReceiver", "com.google.android.gms.measurement.AppMeasurementInstallReferrerReceiver");
        H2G.put("com.huawei.hms.nearby.transfer.Data.Stream", "com.google.android.gms.nearby.connection.Payload.Stream");
        H2G.put("com.huawei.hms.maps.HuaweiMap.OnCameraMoveCanceledListener", "com.google.android.gms.maps.GoogleMap.OnCameraMoveCanceledListener");
        H2G.put("com.huawei.hms.hihealth.data.SampleSet", "com.google.android.gms.fitness.data.DataSet");
        H2G.put("com.huawei.hms.ads.reward.OnMetadataChangedListener", "com.google.android.gms.ads.reward.AdMetadataListener");
        H2G.put("com.huawei.hms.common.api.Releasable", "com.google.android.gms.common.api.Releasable");
        H2G.put("com.huawei.hms.mlsdk.common.LensEngine", "com.google.android.gms.vision.CameraSource");
        H2G.put("com.huawei.hms.mlsdk.text.MLTextAnalyzer.Factory", "com.google.android.gms.vision.text.TextRecognizer.Builder");
        H2G.put("com.huawei.hms.hihealth.result.DataTypeResult", "com.google.android.gms.fitness.result.DataTypeResult");
        H2G.put("com.huawei.hms.jos.games.archive.ArchiveDetails", "com.google.android.gms.games.snapshot.SnapshotContents");
        H2G.put("com.huawei.hms.location.GeofenceErrorCodes", "com.google.android.gms.location.GeofenceStatusCodes");
        H2G.put("com.huawei.hms.hihealth.data.DeviceInfo", "com.google.android.gms.fitness.data.Device");
        H2G.put("com.huawei.hms.maps.model.CameraPosition.Builder", "com.google.android.gms.maps.model.CameraPosition.Builder");
        H2G.put("com.huawei.hms.support.hwid.request.HuaweiIdAuthParams", "com.google.android.gms.auth.api.signin.GoogleSignInOptions");
        H2G.put("com.huawei.hms.analytics.HiAnalyticsReceiver", "com.google.android.gms.measurement.AppMeasurementReceiver");
        H2G.put("com.huawei.hms.maps.model.BitmapDescriptorFactory", "com.google.android.gms.maps.model.BitmapDescriptorFactory");
        H2G.put("com.huawei.hms.support.api.hwid.HuaweiAccountOptions.HasAuthHuaweiIdOptions", "com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions");
        H2G.put("com.huawei.hms.ml.scan.HmsScan.EventInfo", "com.google.android.gms.vision.barcode.Barcode.CalendarEvent");
        H2G.put("com.huawei.hms.support.api.client.ResultCallback", "com.google.android.gms.common.api.ResultCallback");
        H2G.put("com.huawei.hms.location.ActivityIdentification", "com.google.android.gms.location.ActivityRecognition");
        H2G.put("com.huawei.hms.maps.model.UrlTileProvider", "com.google.android.gms.maps.model.UrlTileProvider");
        H2G.put("com.huawei.hms.support.api.client.PendingResultsCreator", "com.google.android.gms.common.api.PendingResults");
        H2G.put("com.huawei.hms.jos.games.GameOptions", "com.google.android.gms.games.Games.GamesOptions");
        H2G.put("com.huawei.hms.kit.awareness.barrier.TimeBarrier", "com.google.android.gms.awareness.fence.TimeFence");
        H2G.put("com.huawei.hms.support.api.entity.safetydetect.UrlCheckResponse", "com.google.android.gms.safetynet.SafetyNetApi.SafeBrowsingResponse");
        H2G.put("com.huawei.hms.wallet.pass.PassObject.Builder", "com.google.android.gms.wallet.OfferWalletObject.Builder");
        H2G.put("com.huawei.hms.aaid.entity.AAIDResult", "com.google.firebase.iid.InstanceIdResult");
        H2G.put("com.huawei.hms.ads.installreferrer.api.InstallReferrerClient.Builder", "com.android.installreferrer.api.InstallReferrerClient.Builder");
        H2G.put("com.huawei.hms.jos.games.player.Player", "com.google.android.gms.games.PlayerEntity");
        H2G.put("com.huawei.hms.maps.HuaweiMap.OnMyLocationButtonClickListener", "com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener");
        H2G.put("com.huawei.hms.mlsdk.text.MLRemoteTextSetting", "com.google.firebase.ml.vision.text.FirebaseVisionCloudTextRecognizerOptions");
        H2G.put("com.huawei.hms.nearby.discovery.ConnectInfo", "com.google.android.gms.nearby.connection.ConnectionInfo");
        H2G.put("com.huawei.hms.nearby.transfer.Data.File", "com.google.android.gms.nearby.connection.Payload.File");
        H2G.put("com.huawei.hms.support.hwid.result.AuthHuaweiId", "com.google.android.gms.auth.api.signin.GoogleSignInAccount");
        H2G.put("com.huawei.hms.ads.nativead.NativeAd", "com.google.android.gms.ads.formats.UnifiedNativeAd");
        H2G.put("com.huawei.hms.support.api.client.Status", "com.google.android.gms.common.api.Status");
        H2G.put("com.huawei.hms.kit.awareness.barrier.AwarenessBarrier", "com.google.android.gms.awareness.fence.AwarenessFence");
        H2G.put("com.huawei.hms.hihealth.options.SensorOptions", "com.google.android.gms.fitness.request.SensorRequest");
        H2G.put("com.huawei.hms.maps.HuaweiMap.InfoWindowAdapter", "com.google.android.gms.maps.GoogleMap.InfoWindowAdapter");
        H2G.put("com.huawei.hms.common.api.AvailabilityException", "com.google.android.gms.common.api.AvailabilityException");
        H2G.put("com.huawei.hms.support.hwid.common.HuaweiIdAuthException", "com.google.android.gms.auth.GoogleAuthException");
        H2G.put("com.huawei.hms.ml.scan.HmsScan.LinkUrl", "com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode.UrlBookmark");
        H2G.put("com.huawei.hms.ml.scan.HmsScan.AddressInfo", "com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode.Address");
        H2G.put("com.huawei.hms.support.hwid.HuaweiIdAuthManager", "com.google.android.gms.auth.api.signin.GoogleSignIn");
        H2G.put("com.huawei.hms.mlsdk.landmark.MLRemoteLandmarkAnalyzer", "com.google.firebase.ml.vision.cloud.landmark.FirebaseVisionCloudLandmarkDetector");
        H2G.put("com.huawei.hms.hihealth.result.ActivityRecordStopResult", "com.google.android.gms.fitness.result.SessionStopResult");
        H2G.put("com.huawei.hms.wallet.Wallet", "com.google.android.gms.wallet.Wallet");
        H2G.put("com.huawei.hms.mlsdk.common.MLCoordinate", "com.google.firebase.ml.vision.common.FirebaseVisionLatLng");
        H2G.put("com.huawei.hms.mlsdk.face.MLFace", "com.google.android.gms.vision.face.Face");
        H2G.put("com.huawei.hms.jos.games.archive.ArchiveSummary", "com.google.android.gms.games.snapshot.SnapshotMetadataEntity");
        H2G.put("com.huawei.hms.common.api.Response", "com.google.android.gms.common.api.Response");
        H2G.put("com.huawei.hms.hihealth.options.DataTypeAddOptions", "com.google.android.gms.fitness.request.DataTypeCreateRequest");
        H2G.put("com.huawei.hms.mlsdk.common.MLAnalyzer.Result", "com.google.android.gms.vision.Detector.Detections");
        H2G.put("com.huawei.hms.hihealth.options.UpdateOptions", "com.google.android.gms.fitness.request.DataUpdateRequest");
        H2G.put("com.huawei.hms.hihealth.result.ReadReply", "com.google.android.gms.fitness.result.DataReadResponse");
        H2G.put("com.huawei.hms.wallet.CreateWalletPassRequest", "com.google.android.gms.wallet.CreateWalletObjectsRequest");
        H2G.put("com.huawei.hms.maps.model.MarkerOptions", "com.google.android.gms.maps.model.MarkerOptions");
        H2G.put("com.huawei.hms.kit.awareness.barrier.HeadsetBarrier", "com.google.android.gms.awareness.fence.HeadphoneFence");
        H2G.put("com.huawei.hms.hihealth.HuaweiHiHealth", "com.google.android.gms.fitness.Fitness");
        H2G.put("com.huawei.hms.hihealth.options.ModifyDataMonitorOptions", "com.google.android.gms.fitness.request.DataUpdateListenerRegistrationRequest");
        H2G.put("com.huawei.hms.common.api.OptionalPendingResult", "com.google.android.gms.common.api.OptionalPendingResult");
        H2G.put("com.huawei.hms.ml.scan.HmsScanAnalyzerOptions", "com.google.firebase.ml.vision.barcode.FirebaseVisionBarcodeDetectorOptions");
        H2G.put("com.huawei.hms.kit.awareness.status.BeaconStatus.Filter", "com.google.android.gms.awareness.state.BeaconState.TypeFilter");
        H2G.put("com.huawei.hmf.tasks.SuccessContinuation", "com.google.android.gms.tasks.SuccessContinuation");
        H2G.put("com.huawei.hms.ml.scan.HmsScan.WiFiConnectionInfo", "com.google.android.gms.vision.barcode.Barcode.WiFi");
        H2G.put("com.huawei.hms.hihealth.data.ActivityRecord.Builder", "com.google.android.gms.fitness.data.Session.Builder");
        H2G.put("com.huawei.hms.mlsdk.landmark.MLRemoteLandmarkAnalyzerSetting", "com.google.firebase.ml.vision.cloud.FirebaseVisionCloudDetectorOptions");
        H2G.put("com.huawei.hms.nearby.message.BeaconId", "com.google.android.gms.nearby.messages.EddystoneUid");
        H2G.put("com.huawei.hms.mlsdk.document.MLDocumentAnalyzer", "com.google.firebase.ml.vision.document.FirebaseVisionDocumentTextRecognizer");
        H2G.put("com.huawei.hms.hihealth.data.DataModifyInfo", "com.google.android.gms.fitness.data.DataUpdateNotification");
        H2G.put("com.huawei.hms.wallet.ResolveTaskHelper", "com.google.android.gms.wallet.AutoResolveHelper");
        H2G.put("com.huawei.hms.jos.games.ranking.RankingVariant", "com.google.android.gms.games.leaderboard.LeaderboardVariant");
        H2G.put("com.huawei.hmf.tasks.CancellationTokenSource", "com.google.android.gms.tasks.CancellationTokenSource");
        H2G.put("com.huawei.hmf.tasks.Tasks", "com.google.android.gms.tasks.Tasks");
        H2G.put("com.huawei.hms.kit.awareness.barrier.BarrierUpdateRequest.Builder", "com.google.android.gms.awareness.fence.FenceUpdateRequest.Builder");
        H2G.put("com.huawei.hms.ml.scan.HmsScan.LocationCoordinate", "com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode.GeoPoint");
        H2G.put("com.huawei.hms.hihealth.options.ModifyDataMonitorOptions.Builder", "com.google.android.gms.fitness.request.DataUpdateListenerRegistrationRequest.Builder");
        H2G.put("com.huawei.hms.ads.nativead.NativeView", "com.google.android.gms.ads.formats.NativeAppInstallAdView");
        H2G.put("com.huawei.hms.jos.games.archive.Archive", "com.google.android.gms.games.snapshot.Snapshot");
        H2G.put("com.huawei.hms.jos.games.GamesStatusCodes", "com.google.android.gms.games.GamesStatusCodes");
        H2G.put("com.huawei.hms.nearby.transfer.TransferStateUpdate", "com.google.android.gms.nearby.connection.PayloadTransferUpdate");
        H2G.put("com.huawei.hms.ads.reward.RewardAdLoadListener", "com.google.android.gms.ads.rewarded.RewardedAdLoadCallback");
        H2G.put("com.huawei.hms.maps.model.IndoorBuilding", "com.google.android.gms.maps.model.IndoorBuilding");
        H2G.put("com.huawei.hms.jos.games.archive.OperationResult", "com.google.android.gms.games.SnapshotsClient.DataOrConflict");
        H2G.put("com.huawei.hms.api.HuaweiMobileServicesUtil", "com.google.android.gms.common.GooglePlayServicesUtil");
        H2G.put("com.huawei.hms.maps.HuaweiMap.OnInfoWindowCloseListener", "com.google.android.gms.maps.GoogleMap.OnInfoWindowCloseListener");
        H2G.put("com.huawei.hms.support.api.client.PendingResult", "com.google.android.gms.common.api.PendingResult");
        H2G.put("com.huawei.hms.common.ErrorDialogFragment", "com.google.android.gms.common.ErrorDialogFragment");
        H2G.put("com.huawei.hms.mlsdk.common.MLCompositeTransactor", "com.google.android.gms.vision.MultiProcessor");
        H2G.put("com.huawei.hms.hihealth.options.ReadOptions.Builder", "com.google.android.gms.fitness.request.DataReadRequest.Builder");
        H2G.put("com.huawei.hms.location.GeofenceData", "com.google.android.gms.location.GeofencingEvent");
        H2G.put("com.huawei.hms.mlsdk.face.MLFaceKeyPoint", "com.google.firebase.ml.vision.face.FirebaseVisionFaceLandmark");
        H2G.put("com.huawei.hms.hihealth.options.DataCollectorsOptions", "com.google.android.gms.fitness.request.DataSourcesRequest");
        H2G.put("com.huawei.hms.common.data.Freezable", "com.google.android.gms.common.data.Freezable");
        H2G.put("com.huawei.hms.mlsdk.face.MLFaceKeyPoint", "com.google.android.gms.vision.face.Landmark");
        H2G.put("com.huawei.hms.maps.UiSettings", "com.google.android.gms.maps.UiSettings");
        H2G.put("com.huawei.hms.nearby.message.GetCallback", "com.google.android.gms.nearby.messages.SubscribeCallback");
        H2G.put("com.huawei.hms.ml.scan.HmsScanAnalyzer", "com.google.firebase.ml.vision.barcode.FirebaseVisionBarcodeDetector");
        H2G.put("com.huawei.hms.nearby.transfer.Data", "com.google.android.gms.nearby.connection.Payload");
        H2G.put("com.huawei.hms.ml.scan.HmsScanAnalyzer.Creator", "com.google.android.gms.vision.barcode.BarcodeDetector.Builder");
        H2G.put("com.huawei.hms.ads.nativead.NativeAdLoader.Builder", "com.google.android.gms.ads.AdLoader.Builder");
        H2G.put("com.huawei.hms.kit.awareness.capture.BeaconStatusResponse", "com.google.android.gms.awareness.snapshot.BeaconStateResponse");
        H2G.put("com.huawei.hms.ml.scan.HmsScan.EmailContent", "com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode.Email");
        H2G.put("com.huawei.hms.kit.awareness.AwarenessStatusCodes", "com.google.android.gms.awareness.AwarenessStatusCodes");
        H2G.put("com.huawei.hms.support.api.entity.auth.Scope", "com.google.android.gms.common.api.Scope");
        H2G.put("com.huawei.hms.support.api.entity.safetydetect.VerifyAppsCheckEnabledResp", "com.google.android.gms.safetynet.SafetyNetApi.VerifyAppsUserResponse");
        H2G.put("com.huawei.hms.maps.HuaweiMap.OnMarkerDragListener", "com.google.android.gms.maps.GoogleMap.OnMarkerDragListener");
        H2G.put("com.huawei.hms.jos.games.archive.OperationResult.Difference", "com.google.android.gms.games.SnapshotsClient.SnapshotConflict");
        H2G.put("com.huawei.hms.nearby.discovery.Distance.Precision", "com.google.android.gms.nearby.messages.Distance.Accuracy");
        H2G.put("com.huawei.hms.maps.HuaweiMap.CancelableCallback", "com.google.android.gms.maps.GoogleMap.CancelableCallback");
        H2G.put("com.huawei.hms.hihealth.result.DailyStatisticsResult", "com.google.android.gms.fitness.result.DailyTotalResult");
        H2G.put("com.huawei.hms.maps.HuaweiMap.OnPolylineClickListener", "com.google.android.gms.maps.GoogleMap.OnPolylineClickListener");
        H2G.put("com.huawei.hms.location.Geofence", "com.google.android.gms.location.Geofence");
        H2G.put("com.huawei.hms.common.ApiException", "com.google.android.gms.common.api.ApiException");
        H2G.put("com.huawei.hms.jos.games.ranking.Ranking", "com.google.android.gms.games.leaderboard.Leaderboard");
        H2G.put("com.huawei.hms.jos.games.PlayersClient", "com.google.android.gms.games.PlayersClient");
        H2G.put("com.huawei.hms.ads.nativead.DislikeAdReason", "com.google.android.gms.ads.MuteThisAdReason");
        H2G.put("com.huawei.hms.security.SecComponentInstallWizard", "com.google.android.gms.security.ProviderInstaller");
        H2G.put("com.huawei.hms.jos.games.ranking.ScoreSubmissionInfo", "com.google.android.gms.games.leaderboard.ScoreSubmissionData");
        H2G.put("com.huawei.hms.kit.awareness.status.HeadsetStatus", "com.google.android.gms.awareness.state.HeadphoneState");
        H2G.put("com.huawei.hms.nearby.discovery.ScanOption", "com.google.android.gms.nearby.connection.DiscoveryOptions");
        H2G.put("com.huawei.hms.nearby.Nearby", "com.google.android.gms.nearby.Nearby");
        H2G.put("com.huawei.hms.mlsdk.common.MLCompositeTransactor.Creator", "com.google.android.gms.vision.MultiProcessor.Builder");
        H2G.put("com.huawei.hms.maps.model.SquareCap", "com.google.android.gms.maps.model.SquareCap");
        H2G.put("com.huawei.hms.jos.games.RankingsClient.RankingScores", "com.google.android.gms.games.LeaderboardsClient.LeaderboardScores");
        H2G.put("com.huawei.hms.ml.scan.HmsScan", "com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode");
        H2G.put("com.huawei.hms.location.ActivityConversionData", "com.google.android.gms.location.ActivityTransitionEvent");
        H2G.put("com.huawei.hms.nearby.discovery.ConnectCallback", "com.google.android.gms.nearby.connection.ConnectionLifecycleCallback");
        H2G.put("com.huawei.hms.common.ErrDlgFragmentForSupport", "com.google.android.gms.common.SupportErrorDialogFragment");
        H2G.put("com.huawei.hms.ml.scan.HmsScan.EventInfo", "com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode.CalendarEvent");
        H2G.put("com.huawei.hms.ads.VideoOperator.VideoLifecycleListener", "com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks");
        H2G.put("com.huawei.hms.support.api.entity.safetydetect.UrlCheckThreat", "com.google.android.gms.safetynet.SafeBrowsingThreat");
        H2G.put("com.huawei.hms.support.api.entity.safetydetect.MaliciousAppsListResp", "com.google.android.gms.safetynet.SafetyNetApi.HarmfulAppsResponse");
        H2G.put("com.huawei.hms.kit.awareness.barrier.BehaviorBarrier", "com.google.android.gms.awareness.fence.DetectedActivityFence");
        H2G.put("com.huawei.hmf.tasks.OnCompleteListener", "com.google.android.gms.tasks.OnCompleteListener");
        H2G.put("com.huawei.hms.ml.scan.HmsScan.SmsContent", "com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode.Sms");
        H2G.put("com.huawei.hms.nearby.transfer.Data.Type", "com.google.android.gms.nearby.connection.Payload.Type");
        H2G.put("com.huawei.hms.kit.awareness.barrier.LocationBarrier", "com.google.android.gms.awareness.fence.LocationFence");
        H2G.put("com.huawei.hms.hihealth.data.Group", "com.google.android.gms.fitness.data.Bucket");
        H2G.put("com.huawei.hms.nearby.message.Permission", "com.google.android.gms.nearby.messages.NearbyPermissions");
        H2G.put("com.huawei.hms.location.ActivityIdentificationService", "com.google.android.gms.location.ActivityRecognitionClient");
        H2G.put("com.huawei.hms.jos.games.ranking.RankingScore", "com.google.android.gms.games.leaderboard.LeaderboardScore");
        H2G.put("com.huawei.hms.nearby.message.GetOption.Builder", "com.google.android.gms.nearby.messages.SubscribeOptions.Builder");
        H2G.put("com.huawei.hms.mlsdk.common.MLPosition", "com.google.firebase.ml.vision.common.FirebaseVisionPoint");
        H2G.put("com.huawei.hms.maps.HuaweiMap.OnPoiClickListener", "com.google.android.gms.maps.GoogleMap.OnPoiClickListener");
        H2G.put("com.huawei.hms.jos.games.EventsClient", "com.google.android.gms.games.EventsClient");
        H2G.put("com.huawei.hms.maps.HuaweiMap.OnCameraMoveListener", "com.google.android.gms.maps.GoogleMap.OnCameraMoveListener");
        H2G.put("com.huawei.hms.nearby.discovery.ScanOption.Builder", "com.google.android.gms.nearby.connection.DiscoveryOptions.Builder");
        H2G.put("com.huawei.hms.hihealth.options.ReadOptions", "com.google.android.gms.fitness.request.DataReadRequest");
        H2G.put("com.huawei.hms.maps.model.LatLngBounds.Builder", "com.google.android.gms.maps.model.LatLngBounds.Builder");
        H2G.put("com.huawei.hms.common.api.CommonStatusCodes", "com.google.android.gms.common.api.CommonStatusCodes");
        H2G.put("com.huawei.hms.location.LocationRequest", "com.google.android.gms.location.LocationRequest");
        H2G.put("com.huawei.hms.ads.InterstitialAd", "com.google.android.gms.ads.InterstitialAd");
        H2G.put("com.huawei.hms.ads.reward.RewardVerifyConfig", "com.google.android.gms.ads.rewarded.ServerSideVerificationOptions");
        H2G.put("com.huawei.hms.ads.template.view.NativeTemplateView", "com.google.android.gms.ads.NativeExpressAdView");
        H2G.put("com.huawei.hms.hihealth.data.DataType", "com.google.android.gms.fitness.data.DataType");
        H2G.put("com.huawei.hms.mlsdk.MLAnalyzerFactory", "com.google.firebase.ml.vision.FirebaseVision");
        H2G.put("com.huawei.hmf.tasks.OnCanceledListener", "com.google.android.gms.tasks.OnCanceledListener");
        H2G.put("com.huawei.hms.mlsdk.text.MLText.Text", "com.google.android.gms.vision.text.Text");
        H2G.put("com.huawei.hms.nearby.message.PutOption.Builder", "com.google.android.gms.nearby.messages.PublishOptions.Builder");
        H2G.put("com.huawei.hms.maps.model.PolygonOptions", "com.google.android.gms.maps.model.PolygonOptions");
        H2G.put("com.huawei.hms.ml.scan.HmsScan.SmsContent", "com.google.android.gms.vision.barcode.Barcode.Sms");
        H2G.put("com.huawei.hms.mlsdk.objects.MLObject", "com.google.firebase.ml.vision.objects.FirebaseVisionObject");
        H2G.put("com.huawei.hms.support.api.client.ResultConvert", "com.google.android.gms.common.api.ResultTransform");
        H2G.put("com.huawei.hms.mlsdk.document.MLDocumentSetting", "com.google.firebase.ml.vision.document.FirebaseVisionCloudDocumentRecognizerOptions");
        H2G.put("com.huawei.hms.hihealth.data.ActivityRecord", "com.google.android.gms.fitness.data.Session");
        H2G.put("com.huawei.hms.location.ActivityConversionRequest", "com.google.android.gms.location.ActivityTransitionRequest");
        H2G.put("com.huawei.hms.nearby.message.MessageOption", "com.google.android.gms.nearby.messages.MessagesOptions");
        H2G.put("com.huawei.hmf.tasks.Task", "com.google.android.gms.tasks.Task");
        H2G.put("com.huawei.hms.maps.Projection", "com.google.android.gms.maps.Projection");
        H2G.put("com.huawei.hms.ml.scan.HmsScan.EventTime", "com.google.android.gms.vision.barcode.Barcode.CalendarDateTime");
        H2G.put("com.huawei.hms.ml.scan.HmsScanAnalyzer", "com.google.android.gms.vision.barcode.BarcodeDetector");
        H2G.put("com.huawei.hms.support.api.entity.safetydetect.SysIntegrityResp", "com.google.android.gms.safetynet.SafetyNetApi.AttestationResponse");
        H2G.put("com.huawei.hms.maps.HuaweiMap.OnCameraMoveStartedListener", "com.google.android.gms.maps.GoogleMap.OnCameraMoveStartedListener");
        H2G.put("com.huawei.hms.ads.reward.Reward", "com.google.android.gms.ads.reward.RewardItem");
        H2G.put("com.huawei.hms.maps.model.LatLng", "com.google.android.gms.maps.model.LatLng");
        H2G.put("com.huawei.hms.jos.games.archive.ArchiveImpl", "com.google.android.gms.games.snapshot.SnapshotEntity");
        H2G.put("com.huawei.hms.maps.HuaweiMap.OnPolygonClickListener", "com.google.android.gms.maps.GoogleMap.OnPolygonClickListener");
        H2G.put("com.huawei.hms.location.ActivityConversionInfo", "com.google.android.gms.location.ActivityTransition");
        H2G.put("com.huawei.hms.maps.HuaweiMap.OnInfoWindowClickListener", "com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener");
        H2G.put("com.huawei.hms.ads.nativead.NativeAdConfiguration.MediaAspect", "com.google.android.gms.ads.MediaAspectRatio");
        H2G.put("com.huawei.hms.common.data.DataBufferUtils", "com.google.android.gms.common.data.DataBufferUtils");
        H2G.put("com.huawei.hms.wallet.AutoResolvableForegroundIntentResult", "com.google.android.gms.wallet.AutoResolvableVoidResult");
        H2G.put("com.huawei.hms.api.HuaweiApiClient", "com.google.android.gms.common.api.GoogleApiClient");
        H2G.put("com.huawei.hms.maps.model.TileOverlay", "com.google.android.gms.maps.model.TileOverlay");
        H2G.put("com.huawei.hms.mlsdk.common.MLFrame.Property", "com.google.firebase.ml.vision.common.FirebaseVisionImageMetadata");
        H2G.put("com.huawei.hms.analytics.HiAnalyticsInstance", "com.google.firebase.analytics.FirebaseAnalytics");
        H2G.put("com.huawei.hms.mlsdk.objects.MLObjectAnalyzer", "com.google.firebase.ml.vision.objects.FirebaseVisionObjectDetector");
        H2G.put("com.huawei.hms.hihealth.options.UpdateOptions.Builder", "com.google.android.gms.fitness.request.DataUpdateRequest.Builder");
        H2G.put("com.huawei.hms.maps.HuaweiMap.OnCameraIdleListener", "com.google.android.gms.maps.GoogleMap.OnCameraIdleListener");
        H2G.put("com.huawei.hms.ads.AdListener", "com.google.android.gms.ads.AdListener");
        H2G.put("com.huawei.hms.ml.scan.HmsScan.ContactDetail", "com.google.android.gms.vision.barcode.Barcode.ContactInfo");
        H2G.put("com.huawei.hms.ads.installreferrer.api.InstallReferrerStateListener", "com.android.installreferrer.api.InstallReferrerStateListener");
        H2G.put("com.huawei.hms.nearby.discovery.ScanEndpointInfo", "com.google.android.gms.nearby.connection.DiscoveredEndpointInfo");
        H2G.put("com.huawei.hms.support.hwid.service.HuaweiIdAuthService", "com.google.android.gms.auth.api.signin.GoogleSignInClient");
        H2G.put("com.huawei.hms.mlsdk.text.MLText.Block", "com.google.android.gms.vision.text.TextBlock");
        H2G.put("com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService", "com.google.android.gms.auth.api.signin.GoogleSignInApi");
        H2G.put("com.huawei.hms.hihealth.HiHealthOptions.Builder", "com.google.android.gms.fitness.FitnessOptions.Builder");
        H2G.put("com.huawei.hms.ads.VideoConfiguration", "com.google.android.gms.ads.VideoOptions");
        H2G.put("com.huawei.hms.mlsdk.face.MLFaceShape", "com.google.android.gms.vision.face.Contour");
        H2G.put("com.huawei.hms.hihealth.options.ActivityRecordReadOptions.Builder", "com.google.android.gms.fitness.request.SessionReadRequest.Builder");
        H2G.put("com.huawei.hmf.tasks.TaskCompletionSource", "com.google.android.gms.tasks.TaskCompletionSource");
        H2G.put("com.huawei.hms.nearby.StatusCode", "com.google.android.gms.nearby.messages.NearbyMessagesStatusCodes");
        H2G.put("com.huawei.hms.ads.banner.BannerView", "com.google.android.gms.ads.AdView");
        H2G.put("com.huawei.hms.mlsdk.common.MLFrame.Property", "com.google.android.gms.vision.Frame.Metadata");
        H2G.put("com.huawei.hms.mlsdk.face.MLFaceAnalyzerSetting.Factory", "com.google.firebase.ml.vision.face.FirebaseVisionFaceDetectorOptions.Builder");
        H2G.put("com.huawei.hms.maps.model.PointOfInterest", "com.google.android.gms.maps.model.PointOfInterest");
        H2G.put("com.huawei.hms.nearby.discovery.BroadcastOption.Builder", "com.google.android.gms.nearby.connection.AdvertisingOptions.Builder");
        H2G.put("com.huawei.hms.nearby.discovery.Policy", "com.google.android.gms.nearby.connection.Strategy");
        H2G.put("com.huawei.hms.common.data.DataBufferObserver", "com.google.android.gms.common.data.DataBufferObserver");
        H2G.put("com.huawei.hms.push.RemoteMessage.Notification", "com.google.firebase.messaging.RemoteMessage.Notification");
        H2G.put("com.huawei.hms.ads.identifier.AdvertisingIdClient.Info", "com.google.android.gms.ads.identifier.AdvertisingIdClient.Info");
        H2G.put("com.huawei.hms.ads.nativead.MediaContent", "com.google.android.gms.ads.formats.UnifiedNativeAd.MediaContent");
        H2G.put("com.huawei.hms.common.webserverpic.WebServerPic", "com.google.android.gms.common.images.WebImage");
        H2G.put("com.huawei.hms.hihealth.HiHealthActivities", "com.google.android.gms.fitness.FitnessActivities");
        H2G.put("com.huawei.hms.mlsdk.common.MLCompositeTransactor.TrailerFactory", "com.google.android.gms.vision.MultiProcessor.Factory");
        H2G.put("com.huawei.hms.location.LocationCallback", "com.google.android.gms.location.LocationCallback");
        H2G.put("com.huawei.hms.nearby.message.BeaconId", "com.google.android.gms.nearby.messages.IBeaconId");
        H2G.put("com.huawei.hms.wallet.pass.PassObject", "com.google.android.gms.wallet.GiftCardWalletObject");
        H2G.put("com.huawei.hms.api.HuaweiServicesNotAvailableException", "com.google.android.gms.common.GooglePlayServicesNotAvailableException");
        H2G.put("com.huawei.hms.maps.model.RoundCap", "com.google.android.gms.maps.model.RoundCap");
        H2G.put("com.huawei.hms.kit.awareness.status.TimeCategories", "com.google.android.gms.awareness.state.TimeIntervals");
        H2G.put("com.huawei.hms.ml.scan.HmsScan.AddressInfo", "com.google.android.gms.vision.barcode.Barcode.Address");
        H2G.put("com.huawei.hms.api.HuaweiServicesRepairableException", "com.google.android.gms.common.GooglePlayServicesRepairableException");
        H2G.put("com.huawei.hms.common.ResolvableApiException", "com.google.android.gms.common.api.ResolvableApiException");
        H2G.put("com.huawei.hms.maps.model.PatternItem", "com.google.android.gms.maps.model.PatternItem");
        H2G.put("com.huawei.hms.hihealth.data.SamplePoint", "com.google.android.gms.fitness.data.DataPoint");
        H2G.put("com.huawei.hms.maps.HuaweiMap.SnapshotReadyCallback", "com.google.android.gms.maps.GoogleMap.SnapshotReadyCallback");
        H2G.put("com.huawei.hms.hihealth.options.DataCollectorsOptions.Builder", "com.google.android.gms.fitness.request.DataSourcesRequest.Builder");
        H2G.put("com.huawei.hms.maps.model.LatLngBounds", "com.google.android.gms.maps.model.LatLngBounds");
        H2G.put("com.huawei.hms.hihealth.data.SamplePoint.Builder", "com.google.android.gms.fitness.data.DataPoint.Builder");
        H2G.put("com.huawei.hms.location.GeofenceRequest", "com.google.android.gms.location.GeofencingRequest");
        H2G.put("com.huawei.hms.ads.AdParam.Builder", "com.google.android.gms.ads.AdRequest.Builder");
        H2G.put("com.huawei.hms.hihealth.options.DataTypeAddOptions.Builder", "com.google.android.gms.fitness.request.DataTypeCreateRequest.Builder");
        H2G.put("com.huawei.hms.hihealth.options.ActivityRecordInsertOptions.Builder", "com.google.android.gms.fitness.request.SessionInsertRequest.Builder");
        H2G.put("com.huawei.hms.mlsdk.classification.MLImageClassificationAnalyzer", "com.google.firebase.ml.vision.label.FirebaseVisionImageLabeler");
        H2G.put("com.huawei.hms.mlsdk.common.MLCompositeAnalyzer", "com.google.android.gms.vision.MultiDetector");
        H2G.put("com.huawei.hms.mlsdk.classification.MLImageClassification", "com.google.firebase.ml.vision.label.FirebaseVisionImageLabel");
        H2G.put("com.huawei.hms.mlsdk.document.MLDocument.Word", "com.google.firebase.ml.vision.document.FirebaseVisionDocumentText.Word");
        H2G.put("com.huawei.hms.push.RemoteMessage", "com.google.firebase.messaging.RemoteMessage");
        H2G.put("com.huawei.hms.kit.awareness.Awareness", "com.google.android.gms.awareness.Awareness");
        H2G.put("com.huawei.hms.maps.model.Polygon", "com.google.android.gms.maps.model.Polygon");
        H2G.put("com.huawei.hms.location.LocationSettingsStates", "com.google.android.gms.location.LocationSettingsStates");
        H2G.put("com.huawei.hms.mlsdk.classification.MLRemoteClassificationAnalyzerSetting.Factory", "com.google.firebase.ml.vision.label.FirebaseVisionCloudImageLabelerOptions.Builder");
        H2G.put("com.huawei.hms.nearby.message.Policy.Builder", "com.google.android.gms.nearby.messages.Strategy.Builder");
        H2G.put("com.huawei.hms.kit.awareness.status.BeaconStatus", "com.google.android.gms.awareness.state.BeaconState");
        H2G.put("com.huawei.hms.ads.VideoOperator", "com.google.android.gms.ads.VideoController");
        H2G.put("com.huawei.hms.maps.model.CircleOptions", "com.google.android.gms.maps.model.CircleOptions");
        H2G.put("com.huawei.hms.wallet.IResolvableTaskResult", "com.google.android.gms.wallet.AutoResolvableResult");
        H2G.put("com.huawei.hms.jos.games.GamesStatusCodes", "com.google.android.gms.games.GamesClientStatusCodes");
        H2G.put("com.huawei.hms.hihealth.data.HealthDataTypes", "com.google.android.gms.fitness.data.HealthDataTypes");
        H2G.put("com.huawei.hms.common.api.UnsupportedApiCallException", "com.google.android.gms.common.api.UnsupportedApiCallException");
        H2G.put("com.huawei.hms.mlsdk.document.MLDocumentSetting.Factory", "com.google.firebase.ml.vision.document.FirebaseVisionCloudDocumentRecognizerOptions.Builder");
        H2G.put("com.huawei.hms.actions.SearchIntents", "com.google.android.gms.actions.SearchIntents");
        H2G.put("com.huawei.hms.mlsdk.face.MLFaceShape", "com.google.firebase.ml.vision.face.FirebaseVisionFaceContour");
        H2G.put("com.huawei.hms.mlsdk.common.LensEngine.PhotographListener", "com.google.android.gms.vision.CameraSource.PictureCallback");
        H2G.put("com.huawei.hms.push.HmsMessaging", "com.google.firebase.messaging.FirebaseMessaging");
        H2G.put("com.huawei.hms.aaid.HmsInstanceId", "com.google.firebase.iid.FirebaseInstanceId");
        H2G.put("com.huawei.hms.mlsdk.document.MLDocument.Block", "com.google.firebase.ml.vision.document.FirebaseVisionDocumentText.Block");
        H2G.put("com.huawei.hms.push.SendException", "com.google.firebase.messaging.SendException");
        H2G.put("com.huawei.hms.kit.awareness.barrier.BeaconBarrier", "com.google.android.gms.awareness.fence.BeaconFence");
        H2G.put("com.huawei.hms.support.hwid.request.HuaweiIdAuthExtendedParams", "com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension");
        H2G.put("com.huawei.hms.mlsdk.common.MLException", "com.google.firebase.ml.common.FirebaseMLException");
        H2G.put("com.huawei.hms.mlsdk.common.LensEngine.ShutterListener", "com.google.android.gms.vision.CameraSource.ShutterCallback");
        H2G.put("com.huawei.hms.hihealth.ActivityRecordsManager.GetIntentInfos", "com.google.android.gms.fitness.SessionsApi.ViewIntentBuilder");
        H2G.put("com.huawei.hms.hihealth.HiHealthStatusCodes", "com.google.android.gms.fitness.FitnessStatusCodes");
        H2G.put("com.huawei.hms.support.api.entity.safetydetect.UserDetectResponse", "com.google.android.gms.safetynet.SafetyNetApi.RecaptchaTokenResponse");
        H2G.put("com.huawei.hms.ads.nativead.NativeAd.ChoicesInfo", "com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo");
        H2G.put("com.huawei.hms.jos.games.event.Event", "com.google.android.gms.games.event.EventEntity");
        H2G.put("com.huawei.hms.hihealth.options.SensorOptions.Builder", "com.google.android.gms.fitness.request.SensorRequest.Builder");
        H2G.put("com.huawei.hms.hihealth.result.ListRecordsResult", "com.google.android.gms.fitness.result.ListSubscriptionsResult");
        H2G.put("com.huawei.hms.jos.games.event.Event", "com.google.android.gms.games.event.Event");
        H2G.put("com.huawei.hms.identity.entity.UserAddress", "com.google.android.gms.identity.intents.model.UserAddress");
        H2G.put("com.huawei.hms.ads.InterstitialAd", "com.google.android.gms.ads.doubleclick.PublisherInterstitialAd");
        H2G.put("com.huawei.hms.hihealth.DataController", "com.google.android.gms.fitness.HistoryClient");
        H2G.put("com.huawei.hms.hihealth.HiHealthOptions", "com.google.android.gms.fitness.FitnessOptions");
        H2G.put("com.huawei.hms.support.hwid.tools.NetworkTool", "com.google.android.gms.auth.CookieUtil");
        H2G.put("com.huawei.hms.api.Api.ApiOptions.NoOptions", "com.google.android.gms.common.api.Api.ApiOptions.NoOptions");
        H2G.put("com.huawei.hms.mlsdk.face.MLFaceAnalyzer", "com.google.firebase.ml.vision.face.FirebaseVisionFaceDetector");
        H2G.put("com.huawei.hms.location.GeofenceRequest.Builder", "com.google.android.gms.location.GeofencingRequest.Builder");
        H2G.put("com.huawei.hms.nearby.StatusCode", "com.google.android.gms.nearby.connection.ConnectionsStatusCodes");
        H2G.put("com.huawei.hms.maps.model.Cap", "com.google.android.gms.maps.model.Cap");
        H2G.put("com.huawei.hms.nearby.message.GetOption", "com.google.android.gms.nearby.messages.SubscribeOptions");
        H2G.put("com.huawei.hms.ads.nativead.NativeAdLoader", "com.google.android.gms.ads.AdLoader");
        H2G.put("com.huawei.hms.nearby.message.Messages", "com.google.android.gms.nearby.messages.Messages");
        H2G.put("com.huawei.hms.common.api.BooleanResult", "com.google.android.gms.common.api.BooleanResult");
        H2G.put("com.huawei.hms.maps.OnMapReadyCallback", "com.google.android.gms.maps.OnMapReadyCallback");
        H2G.put("com.huawei.hms.api.HuaweiApiClient.OnConnectionFailedListener", "com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener");
        H2G.put("com.huawei.hms.kit.awareness.capture.HeadsetStatusResponse", "com.google.android.gms.awareness.snapshot.HeadphoneStateResponse");
        H2G.put("com.huawei.hms.mlsdk.document.MLDocument.Interval", "com.google.firebase.ml.vision.document.FirebaseVisionDocumentText.RecognizedBreak");
        H2G.put("com.huawei.hms.api.ConnectionResult", "com.google.android.gms.common.ConnectionResult");
        H2G.put("com.huawei.hms.kit.awareness.barrier.BarrierQueryResponse", "com.google.android.gms.awareness.fence.FenceQueryResponse");
        H2G.put("com.huawei.hms.mlsdk.classification.MLRemoteClassificationAnalyzerSetting", "com.google.firebase.ml.vision.label.FirebaseVisionCloudImageLabelerOptions");
        H2G.put("com.huawei.hms.hihealth.data.Value", "com.google.android.gms.fitness.data.Value");
        H2G.put("com.huawei.hms.ads.reward.RewardVerifyConfig.Builder", "com.google.android.gms.ads.rewarded.ServerSideVerificationOptions.Builder");
        H2G.put("com.huawei.hms.mlsdk.common.LensEngine.Creator", "com.google.android.gms.vision.CameraSource.Builder");
        H2G.put("com.huawei.hms.mlsdk.text.MLText.Word", "com.google.firebase.ml.vision.text.FirebaseVisionText.Element");
        H2G.put("com.huawei.hms.location.LocationSettingsResult", "com.google.android.gms.location.LocationSettingsResult");
        H2G.put("com.huawei.hms.ads.nativead.NativeView", "com.google.android.gms.ads.formats.NativeAdView");
        H2G.put("com.huawei.hms.jos.games.playerstats.GamePlayerStatistics", "com.google.android.gms.games.stats.PlayerStats");
        H2G.put("com.huawei.hms.maps.model.IndoorLevel", "com.google.android.gms.maps.model.IndoorLevel");
        H2G.put("com.huawei.hms.hihealth.options.DeleteOptions", "com.google.android.gms.fitness.request.DataDeleteRequest");
        H2G.put("com.huawei.hms.ads.nativead.NativeAdMonitor", "com.google.android.gms.ads.formats.NativeAdViewHolder");
        H2G.put("com.huawei.hms.ml.scan.HmsScan.WiFiConnectionInfo", "com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode.WiFi");
        H2G.put("com.huawei.hms.mlsdk.classification.MLLocalClassificationAnalyzerSetting", "com.google.firebase.ml.vision.label.FirebaseVisionOnDeviceImageLabelerOptions");
        H2G.put("com.huawei.hms.wallet.constant.WalletPassConstant", "com.google.android.gms.wallet.WalletConstants");
        H2G.put("com.huawei.hms.identity.AddressConstants.Extras", "com.google.android.gms.identity.intents.AddressConstants.Extras");
        H2G.put("com.huawei.hms.mlsdk.common.MLAnalyzer.MLTransactor", "com.google.android.gms.vision.Detector.Processor");
        H2G.put("com.huawei.hms.mlsdk.text.TextLanguage", "com.google.firebase.ml.vision.text.RecognizedLanguage");
        H2G.put("com.huawei.hms.location.SettingsClient", "com.google.android.gms.location.SettingsClient");
        H2G.put("com.huawei.hms.ml.scan.HmsScan.ContactDetail", "com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode.ContactInfo");
        H2G.put("com.huawei.hms.jos.games.RankingsClient", "com.google.android.gms.games.LeaderboardsClient");
        H2G.put("com.huawei.hms.mlsdk.face.MLFaceAnalyzerSetting", "com.google.firebase.ml.vision.face.FirebaseVisionFaceDetectorOptions");
        H2G.put("com.huawei.hms.maps.model.PolylineOptions", "com.google.android.gms.maps.model.PolylineOptions");
        H2G.put("com.huawei.hms.maps.HuaweiMap", "com.google.android.gms.maps.GoogleMap");
        H2G.put("com.huawei.hms.common.data.DataBuffer", "com.google.android.gms.common.data.DataBuffer");
        H2G.put("com.huawei.hms.analytics.type.HAParamType", "com.google.firebase.analytics.FirebaseAnalytics.Param");
        H2G.put("com.huawei.hms.support.hwid.result.HuaweiIdAuthResultCode", "com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes");
        H2G.put("com.huawei.hms.hihealth.data.SampleSet.Builder", "com.google.android.gms.fitness.data.DataSet.Builder");
        H2G.put("com.huawei.hms.mlsdk.text.MLRemoteTextSetting.Factory", "com.google.firebase.ml.vision.text.FirebaseVisionCloudTextRecognizerOptions.Builder");
        H2G.put("com.huawei.hms.analytics.type.HAParamType", "com.google.firebase.analytics.FirebaseAnalytics.UserProperty");
        H2G.put("com.huawei.hms.hihealth.options.ActivityRecordReadOptions", "com.google.android.gms.fitness.request.SessionReadRequest");
        H2G.put("com.huawei.hms.nearby.discovery.BroadcastOption", "com.google.android.gms.nearby.connection.AdvertisingOptions");
        H2G.put("com.huawei.hms.ml.scan.HmsScan.LinkUrl", "com.google.android.gms.vision.barcode.Barcode.UrlBookmark");
        H2G.put("com.huawei.hms.nearby.discovery.ConnectResult", "com.google.android.gms.nearby.connection.ConnectionResolution");
        H2G.put("com.huawei.hms.ads.Image", "com.google.android.gms.ads.formats.NativeAd.Image");
        H2G.put("com.huawei.hms.maps.HuaweiMapOptions", "com.google.android.gms.maps.GoogleMapOptions");
        H2G.put("com.huawei.hms.maps.model.CameraPosition", "com.google.android.gms.maps.model.CameraPosition");
        H2G.put("com.huawei.hms.ads.nativead.NativeView", "com.google.android.gms.ads.formats.UnifiedNativeAdView");
        H2G.put("com.huawei.hms.support.api.client.ResolvingResultCallbacks", "com.google.android.gms.common.api.ResolvingResultCallbacks");
        H2G.put("com.huawei.hms.kit.awareness.barrier.BarrierStatus", "com.google.android.gms.awareness.fence.FenceState");
        H2G.put("com.huawei.hms.common.size.Size", "com.google.android.gms.common.images.Size");
        H2G.put("com.huawei.hms.api.Api.ApiOptions.HasOptions", "com.google.android.gms.common.api.Api.ApiOptions.HasOptions");
        H2G.put("com.huawei.hms.hihealth.data.HealthFields", "com.google.android.gms.fitness.data.HealthFields");
        H2G.put("com.huawei.hms.jos.games.ranking.ScoreSubmissionInfo.Result", "com.google.android.gms.games.leaderboard.ScoreSubmissionData.Result");
        H2G.put("com.huawei.hms.hihealth.options.StartBleScanOptions.Builder", "com.google.android.gms.fitness.request.StartBleScanRequest.Builder");
        H2G.put("com.huawei.hms.maps.CameraUpdateFactory", "com.google.android.gms.maps.CameraUpdateFactory");
        H2G.put("com.huawei.hms.maps.model.Tile", "com.google.android.gms.maps.model.Tile");
        H2G.put("com.huawei.hms.mlsdk.landmark.MLRemoteLandmarkAnalyzerSetting.Factory", "com.google.firebase.ml.vision.cloud.FirebaseVisionCloudDetectorOptions.Builder");
        H2G.put("com.huawei.hms.maps.model.Gap", "com.google.android.gms.maps.model.Gap");
        H2G.put("com.huawei.hms.jos.games.GamesClient", "com.google.android.gms.games.GamesClient");
        H2G.put("com.huawei.hms.ads.reward.RewardAd", "com.google.android.gms.ads.rewarded.RewardedAd");
        H2G.put("com.huawei.hms.mlsdk.text.MLTextAnalyzer", "com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer");
        H2G.put("com.huawei.hms.location.FusedLocationProviderClient", "com.google.android.gms.location.FusedLocationProviderClient");
        H2G.put("com.huawei.hms.ads.nativead.MediaView", "com.google.android.gms.ads.formats.MediaView");
        H2G.put("com.huawei.hms.mlsdk.classification.MLLocalClassificationAnalyzerSetting.Factory", "com.google.firebase.ml.vision.label.FirebaseVisionOnDeviceImageLabelerOptions.Builder");
        H2G.put("com.huawei.hms.nearby.message.MessageHandler", "com.google.android.gms.nearby.messages.MessageListener");
        H2G.put("com.huawei.hms.hihealth.result.ReadDetailResult", "com.google.android.gms.fitness.result.DataReadResult");
        H2G.put("com.huawei.hms.wallet.pass.PassObject.Builder", "com.google.android.gms.wallet.LoyaltyWalletObject.Builder");
        H2G.put("com.huawei.hms.ads.installreferrer.api.InstallReferrerClient", "com.android.installreferrer.api.InstallReferrerClient");
        H2G.put("com.huawei.hms.mlsdk.face.MLFace", "com.google.firebase.ml.vision.face.FirebaseVisionFace");
        H2G.put("com.huawei.hms.kit.awareness.BarrierClient", "com.google.android.gms.awareness.FenceClient");
        H2G.put("com.huawei.hms.api.HuaweiApiClient.Builder", "com.google.android.gms.common.api.GoogleApiClient.Builder");
        H2G.put("com.huawei.hms.ml.scan.HmsScan.LocationCoordinate", "com.google.android.gms.vision.barcode.Barcode.GeoPoint");
        H2G.put("com.huawei.hms.hihealth.result.ActivityRecordResult", "com.google.android.gms.fitness.result.SessionReadResult");
        H2G.put("com.huawei.hms.mlsdk.document.MLDocument", "com.google.firebase.ml.vision.document.FirebaseVisionDocumentText");
        H2G.put("com.huawei.hms.kit.awareness.capture.LocationResponse", "com.google.android.gms.awareness.snapshot.LocationResponse");
        H2G.put("com.huawei.hms.location.LocationResult", "com.google.android.gms.location.LocationResult");
        H2G.put("com.huawei.hms.support.api.entity.safetydetect.MaliciousAppsData", "com.google.android.gms.safetynet.HarmfulAppsData");
        H2G.put("com.huawei.hms.maps.HuaweiMap.OnMapLoadedCallback", "com.google.android.gms.maps.GoogleMap.OnMapLoadedCallback");
        H2G.put("com.huawei.hms.push.RemoteMessage.Builder", "com.google.firebase.messaging.RemoteMessage.Builder");
        H2G.put("com.huawei.hms.ml.scan.HmsScan.PeopleName", "com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode.PersonName");
        H2G.put("com.huawei.hms.maps.HuaweiMap.OnMyLocationClickListener", "com.google.android.gms.maps.GoogleMap.OnMyLocationClickListener");
        H2G.put("com.huawei.hms.maps.MapsInitializer", "com.google.android.gms.maps.MapsInitializer");
        H2G.put("com.huawei.hms.hihealth.options.OnSamplePointListener", "com.google.android.gms.fitness.request.OnDataPointListener");
    }
}
