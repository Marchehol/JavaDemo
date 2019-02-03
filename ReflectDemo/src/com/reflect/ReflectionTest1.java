package com.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest1 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        /*
            得到 Class 的三种方式
         */

        //1、通过对象调用 getClass() 方法来获取,通常应用在：比如你传过来一个 Object
        //  类型的对象，而我不知道你具体是什么类，用这种方法
        Person p1 = new Person();
        Class c1 = p1.getClass();

        //2、直接通过 类名.class 的方式得到,该方法最为安全可靠，程序性能更高
        //  这说明任何一个类都有一个隐含的静态成员变量 class
        Class c2 = Person.class;

        //3、通过 Class 对象的 forName() 静态方法来获取，用的最多，
        //   但可能抛出 ClassNotFoundException 异常
        Class c3 = Class.forName("com.reflect.Person");

        //注意：一个类在 JVM 中只会有一个 Class 实例,即我们对上面获取的 c1,c2,c3进行 equals 比较，发现都是true

        /*
            查阅 API 可以看到 Class 有很多方法：
        　　getName()：获得类的完整名字。
        　　getFields()：获得类的public类型的属性。
        　　getDeclaredFields()：获得类的所有属性。包括private 声明的和继承类
        　　getMethods()：获得类的public类型的方法。
        　　getDeclaredMethods()：获得类的所有方法。包括private 声明的和继承类
        　　getMethod(String name, Class[] parameterTypes)：获得类的特定方法，name参数指定方法的名字，parameterTypes 参数指定方法的参数类型。
        　　getConstructors()：获得类的public类型的构造方法。
        　　getConstructor(Class[] parameterTypes)：获得类的特定构造方法，parameterTypes 参数指定构造方法的参数类型。
        　　newInstance()：通过类的不带参数的构造方法创建这个类的一个对象。
         */

        //获得类完整的名字
        String className = c2.getName();
        System.out.println("完整类名：" + className);//输出com.reflex.Person

        //获得类的public类型的属性。
        System.out.println("public类型属性：");
        Field[] fields = c2.getFields();
        for(Field field : fields){
            System.out.println(field.getName());//age
        }

        //获得类的所有属性。包括私有的
        System.out.println("所有属性：");
        Field [] allFields = c2.getDeclaredFields();
        for(Field field : allFields){
            System.out.println(field.getName());//name    age
        }

        //获得类的public类型的方法。这里包括 Object 类的一些方法
        System.out.println("public类型方法：");
        Method[] methods = c2.getMethods();
        for(Method method : methods){
            System.out.println(method.getName());//work waid equls toString hashCode等
        }

        //获得类的所有方法。
        System.out.println("所有方法：");
        Method [] allMethods = c2.getDeclaredMethods();
        for(Method method : allMethods){
            System.out.println(method.getName());//work say
        }

        //获得指定的属性
        System.out.println("指定的public属性：");
        Field f1 = c2.getField("age");
        System.out.println(f1);

        //获得指定的私有属性
        System.out.println("指定的private属性：");
        Field f2 = c2.getDeclaredField("name");
        //启用和禁用访问安全检查的开关，值为 true，则表示反射的对象在使用时应该取消 java 语言的访问检查；反之不取消
        f2.setAccessible(true);
        System.out.println(f2);

        //创建这个类的一个对象
        Object p2 =  c2.newInstance();
        //将 p2 对象的  f2 属性赋值为 Bob，f2 属性即为 私有属性 name
        f2.set(p2,"Bob");
        //使用反射机制可以打破封装性，导致了java对象的属性不安全。
        System.out.println("为属性赋值：");
        System.out.println(f2.get(p2)); //Bob

        //获取构造方法
        System.out.println("构造方法：");
        Constructor[] constructors = c2.getConstructors();
        for(Constructor constructor : constructors){
            System.out.println(constructor.toString());//public com.reflex.ReflectionTest1()
        }
    }
}