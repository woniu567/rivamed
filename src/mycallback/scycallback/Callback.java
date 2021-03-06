package mycallback.scycallback;

/*

接口与抽象类
  为什么有了抽象类，设计人员还要不予余力的引入接口概念呢？

  首先考虑的是抽象类的局限性。子类只能继承与一个父类，而实现类可以引入多个接口，在实际项目中当要改动一些方法的body,
    无需删除本来的代码，从新写一个实现类，更换接口引用的对象即可。

  其次是接口的松耦合是我们可以编写可复性高的代码。比如Server层本来引用使用Dao层mysql数据库的实现类，现在遇到mysql解决
    不了的业务，需要orcale实现，难道你要为了这一个或几个的功能，把所有的引用mysql的全删掉重写？只要再写一个dao层的实现类
    去引用这个接口，遇到需要orcale方法使用哪个接口变量就好了，别人写的代码也无需去删改。抽象类可以再写一个子类，
    但子类却不受父类过多约束，随意添加方法，对于项目的协同工作不利。抽象类做不到==对修改封闭，对扩展开放==的原则。

  再者接口更加安全，严密，接口是实现软件松耦合的重要手段，它描叙了系统对外的所有服务，而不涉及任何具体的实现细节。
    这样就比较安全、严密一些。对于开发，那么就需要一个能理清所有业务的架构师来定义一些主要的接口，这些接口不仅告诉
    开发人员你需要实现那些业务，而且也将命名规范限制住了（防止一些开发人员随便命名导致别的程序员无法看明白）。

接口回调
  我对接口回调的理解就是：回调方类A的一个方法a通过调用类B的一个方法b去调用类A的另一个方法c。绕晕了吧，
    其实就是一个类去请求另一个类后得到回复再去调用本类的另一个方法，至于同步回调就是方法b中的逻辑执行完再去执行方法c，
    而异步回调就是b和c一起再执行。有人问：为什么不直接通过a去调用b呢？答案很简单，生活中有些事总不能自己解决，
    学生有问题总不能自问自答吧。下面是一个乘客与司机的同步回调案例：

 */

//同步回调的例子
public interface Callback {      //回调方类A的接口

    boolean Consider(int money); //考虑是否付钱，就是方法c
    void PayFor(int money);      //付钱，就是方法c
}


/**
 * 接口的特性
 *   1)接口不能new一个对象,他不是类
 *   2)接口的方法没有body,既不能有{}；
 *   3)实现类使用关键字implements实现对应接口。实现类必须实现接口的所有方法。
 *   4)接口的所有修饰字只能为public，接口不能有实例但是去可以声明接口变量，只不过变量必须指向实现类。
 *   5)接口不能有实例域但是可以定义常量。
 *   6)接口可以有多个实现类，实现类也可以引用多个接口，但抽象类的子类只能继承一个父类。
 *
 */