
1.1 java中使用static修饰静态方法
例如：
public static String getCurrentVersion(){
    return BuildConfig.VERSION_NAME;
}

1.2 Kotlin中使用object修饰静态类，被修饰的类，可以使用类名.方法名的形式调用
object Util{
    fun getCurrentVersion():String {
        return BuildConfig.VERSION_NAME
    }
}
调用：var version_name1 = Util.getCurrentVersion()

1.3 Kotlin语言中使用“companion object”修饰静态方法，可以使用类名.方法名的形式调用
class Util2 {
    companion object {
        fun getCurrentVersion():String {
            return BuildConfig.VERSION_NAME
        }
    }
}
调用：var version_name2 = Util2.getCurrentVersion()

2.1 类初始化 关键字init
 Kotlin中的类定义同事也是构造函数，所以kotlin增加了一个新的关键字：init用来处理类的初始化问题，
init模块中的内容可以直接使用构造函数的参数

2.2 ?以及!!符号使用说明：
    ?   表示当前对象可以为空
    !!  表示当前对象不为空的情况下执行
    ?:  表示当前对象为空是返回:后面的内容
    例如 val mySize = roomList?.size?:0