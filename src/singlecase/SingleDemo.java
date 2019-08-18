package singlecase;

public class SingleDemo {

    /**
     * 饿汉式
     * 特点：在类加载的时候就会创建对象；
     * 好处：类，只会加载一次，所以这种写法可以保证对象的唯一性；
     * 弊端：因为类加载的时候就会创建对象，所以有的时候还不需要使用对象，就会创建对象，造成内存的浪费；
     */
    /*private SingleDemo(){

    }

    private static SingleDemo sd = new SingleDemo();

    public static SingleDemo getInstance(){
        return sd;
    }*/

    /**
     * 懒汉式
     * 特点：懒汉式再类加载的时候不创建对象，只有第一次调用获取函数时才创建对象；
     * 好处：就可以避免出现内存浪费的问题；
     * 弊端：再多线程环境下不能保证对象的唯一性；
     */
    private SingleDemo(){

    }

    private static SingleDemo sd = null;

    public static SingleDemo getInstance(){
        if (sd == null){
            sd = new SingleDemo();
        }
        return sd;
    }

}
