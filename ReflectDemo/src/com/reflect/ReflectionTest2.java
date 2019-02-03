package com.reflect;

import java.lang.reflect.Field;

public class ReflectionTest2 {

    public void testGetParentField() throws Exception{
        Class c1 = Class.forName("com.reflect.Son");
        //获取父类私有属性值
        System.out.println(getFieldValue(c1.newInstance(),"privateField"));
    }

    public static Field getDeclaredField(Object obj, String fieldName) {
        Field field = null;
        Class c = obj.getClass();
        for(; c != Object.class ; c = c.getSuperclass()){
            try {
                field = c.getDeclaredField(fieldName);
                field.setAccessible(true);
                return field;
            }catch (Exception e){
                //这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。
                //如果这里的异常打印或者往外抛，则就不会执行c = c.getSuperclass(),最后就不会进入到父类中了
            }
        }
        return null;
    }
    public static Object getFieldValue(Object object,String fieldName) throws Exception{
        Field field = getDeclaredField(object,fieldName);

        return field.get(object);
    }

    public Field getParentField(Object obj, String fieldName){
        Class c = obj.getClass();
        for(; c!=Object.class; c=c.getSuperclass()){
            try {
                Field field = c.getDeclaredField(fieldName);
                field.setAccessible(true);
                return field;
            } catch (NoSuchFieldException e) {

            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        ReflectionTest2 reflectionTest2 = new ReflectionTest2();
        reflectionTest2.testGetParentField();
        System.out.println(reflectionTest2.getParentField(new Son(),"privateField"));

    }
}