> CSDN学院课程地址
> * RxJava2从入门到精通-初级篇:https://edu.csdn.net/course/detail/10036
> * RxJava2从入门到精通-中级篇:https://edu.csdn.net/course/detail/10037
> * RxJava2从入门到精通-进阶篇:https://edu.csdn.net/course/detail/10038
> * RxJava2从入门到精通-源码分析篇:https://edu.csdn.net/course/detail/10138

## 导言

RxJava在工作中和面试中已经成为各个项目开发的必选框架，掌握这门框架的使用是尤其重要的。文章将从0开始进行入门教学，参考工作中开发实战需求，对基础概念和实战例子进行讲解。即使您没有学过RxJava也能通过这篇文章快速入门，并快速掌握RxJava在实战中的应用。项目中的代码都会通过Github的形式对外公布。欢迎加入读者聊天群：497863347

## 适合人群

本篇文章适合所有初中级工程师，文章会从RxJava的每个知识点进行讲解，并在每个知识点中都带有文字说明和代码例子说明。通过这次系统化的学习，您将可以完整的学习到RxJava家族的所有特性和常用的操作符，掌握操作符的使用，掌握RxJava与Rx其他第三方库的使用。此次文章的写作目的可以用三句简单的话进行概括

```
面试加分利器 = 加大录取机会
加快工作效率 = 早点下班回家
系统化的学习 = 能力全面提升
```

## RxJava的特性

说到RxJava，相信诸多Android开发者都不会陌生。作为一个知名的响应式编程库，从2016年开始逐渐变得火热，从小众到被众多Android开发者们广泛引入与流传，其在GitHub的仓库已经有33.9k的star。期间也有很多大牛专门为Android写了RxJava的适配库，如：RxAndroid、RxBinding、RxLifecycle等等

* 特性一，异步。RxJava是基于异步操作的框架，常用的应用场景有网络访问、数据解析等
* 特性二，链式操作。RxJava提供了当前最主流的链式编程，其方式类似于构建者模式
* 特性三，线程切换。RxJava提供了线程切换的功能，可以任意的在UI线程和工作线程中切换
* 特性四，丰富的操作符。RxJava提供了丰富的操作符，简化了我们对方法或数据的操作
* 特性五，背压策略。RxJava针对网络访问的高并发性，提供了背压的策略进行处理

## 文章目录

RxJava2从入门到精通-初级篇

目的：掌握RxJava2，认知基础概念以及基础用法

```
1. 基础概念
    1.1 RxJava简述
    1.2 RxAndroid简述
    1.3 设计模式中的观察者模式
    1.4 RxJava中的观察者模式
    1.5 小结
2. RxJava基本使用
    2.1 事件发射
    2.2 链式调用
    2.3 选择调用
    2.4 线程切换
    2.5 线程调度器
    2.6 事件调度器
    2.7 "冷"与"热"
    2.8 小结
3. RxJava操作符
    3.1 Creating Observables (创建操作符)
    3.2 Transforming Observables (转换操作符)
    3.3 Filtering Observables (过滤操作符)
    3.4 Combining Observables (组合操作符)
    3.5 Error Handling Operators(错误处理操作符)
    3.6 Observable Utility Operators(辅助性操作符)
    3.7 Conditional and Boolean Operators(条件和布尔操作符)
    3.8 Mathematical and Aggregate Operators(数学运算及聚合操作符)
    3.9 Connectable Observable(连接操作符)
```

RxJava2从入门到精通-中级篇

目的：熟悉RxJava2，实际联系理论，提高实战性

```
4. RxJava基本响应类型
    4.1 Observable
    4.2 Flowable
    4.3 Single
    4.4 Completable
    4.5 Maybe
    4.6 小结
5. RxJava背压策略(BackpressureStrategy)
    5.1 背压是什么
    5.2 MISSING
    5.3 ERROR
    5.4 BUFFER
    5.5 DROP
    5.6 LATEST
    5.7 小结
6. RxJava基础实战
    6.1 模拟发送验证码
    6.2 模拟用户点击防抖动
    6.3 模拟会员信息的合并
```

RxJava2从入门到精通-进阶篇

目的：熟悉RxJava2，在实战过程中与第三方框架进行混合使用

```
7. RxJava高级用法（一）
    7.1 自定义Operator
    7.2 自定义Transformer
    7.3 自定义Plugin
8. RxJava高级用法（二）
    8.1 Subject的介绍
    8.2 PublishSubject
    8.3 BehaviorSubject
    8.4 ReplaySubject
    8.5 AsyncSubject
    8.6 转发数据
    8.7 小结
9. RxJava混合实战
    9.1 RxJava与Retrofit
    9.2 RxJava与RxBinding
    9.3 RxJava与RxLifecycle
    9.4 RxJava与Mvp
    9.5 小结
```

RxJava2从入门到精通-源码分析篇

目的：精通RxJava2，在运用过程中能通过源码去定位问题和查找问题

```
10. RxJava源码分析
    10.1 RxJava的事件发射原理
    10.2 RxJava的事件释放原理
    10.3 RxJava的背压原理
    10.4 RxJava的常规操作符原理
    10.5 RxJava的线程切换原理
    10.6 RxJava的自定义Operator原理
    10.7 RxJava的自定义Transformer原理
    10.8 RxJava的自定义Plugin原理
    10.9 美团WhiteBoard
```

## 文章传送门

* [0章 RxJava2课程目录介绍](https://blog.csdn.net/qq_30379689/article/details/83389064)
* [1章 基础概念](https://blog.csdn.net/qq_30379689/article/details/84257466)
* [2章 RxJava基本使用](https://blog.csdn.net/qq_30379689/article/details/84257659)
* [3章 RxJava操作符](https://blog.csdn.net/qq_30379689/article/details/84875234)
* [4章 RxJava基本响应类型](https://blog.csdn.net/qq_30379689/article/details/84875244)
* [5章 RxJava背压策略](https://blog.csdn.net/qq_30379689/article/details/84875258)
* [6章 RxJava基础实战](https://blog.csdn.net/qq_30379689/article/details/85019426)
* [7章 RxJava高级用法（一）](https://blog.csdn.net/qq_30379689/article/details/85019432)
* [8章 RxJava高级用法（二）](https://blog.csdn.net/qq_30379689/article/details/85019439)
* [9章 RxJava混合实战](https://blog.csdn.net/qq_30379689/article/details/85294047)
* [10章 RxJava源码分析](https://blog.csdn.net/qq_30379689/article/details/86584493)