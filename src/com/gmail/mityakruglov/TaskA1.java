package com.gmail.mityakruglov;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Test {
    int a();
    int b();
}


class TaskA1 {
    @Test(a = 5, b = 2)
    public static void myTest(){
        TaskA1 ob = new TaskA1();
        try{
            Class<?> c = ob.getClass();
            Method m = c.getMethod("myTest");
            Test test = m.getAnnotation(Test.class);
            System.out.println("a = "+test.a());
            System.out.println("b = "+test.b());

        }catch (NoSuchMethodException e){
            System.out.println(e);
        }
    }


    public static void main(String[] args) {
        myTest();
    }
}
