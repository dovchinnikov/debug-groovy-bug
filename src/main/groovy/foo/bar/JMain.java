package foo.bar;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class JMain {

    public static void main(String[] args) throws Exception {
        tryStuff(JC.class);
        tryStuff(SGC.class);
        tryStuff(GC.class);
    }

    private static void tryStuff(Class<?> clazz) throws Exception {
        Method method = clazz.getDeclaredMethod("getStuff");
        Constructor<?> constructor = clazz.getConstructor();
        Object o = constructor.newInstance();
        method.invoke(o);
    }
}
