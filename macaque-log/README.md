>日志就像车辆保险，没人愿意为保险付钱，但是一旦出了问题谁都又想有保险可用

## 日志的作用和目的

### 日志文件

日志文件是用于记录系统操作事件的文件集合，可以分为事件日志和消息日志。具有处理历史数据、诊断问题的追踪以及理解系统的活动等重要作用。

在计算机中，日志文件是一个记录了发生在运行中的操作系统或者其他软件中的事件的文件，或者记录了在网络聊天软件的用户之间发送的消息。日志记录是指保存日志的行为。最简单的做法的将日志写入单个存放日志的文件。

### 为什么要打印日志

为什么要打印日志，或者什么时候打印日志这取决于打印的目的。不同的打印目的决定了日志输出的格式，输出的位置以及输出的频率

1. 调试开发：目的是开发调试程序时使用，只应该出现在开发周期内，而不应该在线上系统输出
2. 用户行为日志：记录用户操作行为，多用于大数据分析，如监控、风控、推荐等等
3. 程序运行日志：记录程序运行时情况，特别是非预期的行为，异常情况，主要是开发维护使用
4. 机器日志：主要是记录网络请求、系统CPU、内存、IO使用等情况，供运维或者监控使用

### 日志中应该包含什么

利用4W1H进行分析

* When：打印日志的时间戳，此时的时间应该是日志记录的事情发生的时间，具体的时间可以帮助我们分析时间发生的时间点
* Where：日志在哪里被记录，具体哪个模块，记录到哪个文件，哪个函数，哪一行代码
* What：日志的主体是什么，简明扼要描述日志记录的事情
* Who：事件生产者的唯一标识，以订单为例就是订单id，当然也可以是某个动作的声明
* How：日志的重要程度分级，一般以ERROR > WARNNING > INFO > DEBUG > TRACE来划分重要程度

## Java日志的前世今生

#### 

### 为什么要用日志框架

软件系统发展到现在已经非常复杂了，特别是在服务器端软件，涉及到的知识以及内容问题太多。在某些方面使用别人成熟的框架，就相当于让别人帮你完成一些基础工作，你只需要集中精力完成系统的业务逻辑设计。而且框架一般是成熟、稳健的，他可以帮助你处理很多细节的问题，比如日志的异步处理、动态控制等等问题。还有框架一般都是经过很多人使用，所以结构性、扩展性都非常好。

### 现有的日志框架

按照日志门面和日志实现划分的话现有的Java日志框架有以下几种

* 日志门面：JCL、Slf4j
* 日志实现：JUL、Logback、Log4j、Log4j2

![图片](https://uploader.shimo.im/f/ZspOPBh9n3obsJ8B.png!thumbnail?fileGuid=CPCv8kQddXqJPJ69)

#### 为什么要有日志门面

当我们的系统变得更加复杂的时候，我们的日志就容易发生混乱。随着系统开发的进行，可能会更新不同的日志框架，造成当前系统中存在不同的日志依赖，让我们难以统一的管理和控制。就算我们强制要求了我们公司内开发的项目使用了相同的日志框架，但是系统中会引用其他类似Spring或者Mybatis等等的第三方框架，它们依赖于我们规定不同的日志框架，而且他们自身的日志系统就有着不一致性，依然会出现日志体系的混乱。

所以借鉴JDBC的思想，为日志系统也提供一套门面，那么我们就可以面向这些接口规范来开发，避免直接依赖具体的日志框架。这样我们的系统在日志中就存在了日志的门面和日志的实现。

#### 日志门面的日志实现的关系

![图片](https://uploader.shimo.im/f/B7CBUnGicwOIfJj9.png!thumbnail?fileGuid=CPCv8kQddXqJPJ69)


#### 

### Log4j

Apache Log4j 是一种基于 Java 的日志记录工具，它是 Apache 软件基金会的一个项目。在 jdk1.3 之前，还没有现成的日志框架，Java 工程师只能使用原始的 System.out.println(), System.err.println() 或者 e.printStackTrace()。通过把 debug 日志写到 StdOut 流，错误日志写到 ErrOut 流，以此记录应用程序的运行状态。这种原始的日志记录方式缺陷明显，不仅无法实现定制化，而且日志的输出粒度不够细。鉴于此，1999 年，大牛 Ceki Gülcü 创建了 Log4j 项目，并几乎成为了 Java 日志框架的实际标准。

### JUL

Log4j 作为 Apache 基金会的一员，Apache 希望将 Log4j 引入 jdk，不过被 sun 公司拒绝了。随后，sun 模仿 Log4j，在 jdk1.4 中引入了 JUL（java.util.logging）。

### JCL

为了解耦日志接口与实现，2002 年 Apache 推出了 JCL(Jakarta Commons Logging)，也就是 Commons Logging。Commons Logging 定义了一套日志接口，具体实现则由 Log4j 或 JUL 来完成。Commons Logging 基于动态绑定来实现日志的记录，在使用时只需要用它定义的接口编码即可，程序运行时会使用 ClassLoader 寻找和载入底层的日志库，因此可以自由选择由 log4j 或 JUL 来实现日志功能。

### SlF4j和Logback

大牛 Ceki Gülcü 与 Apache 基金会关于 Commons-Logging 制定的标准存在分歧，后来，Ceki Gülcü 离开 Apache 并先后创建了 Slf4j 和 Logback 两个项目。Slf4j 是一个日志门面，只提供接口，可以支持 Logback、JUL、Log4j 等日志实现，Logback 提供具体的实现，它相较于 log4j 有更快的执行速度和更完善的功能。

### Log4j2

为了维护在 Java 日志江湖的地位，防止 JCL、Log4j 被 Slf4j、Logback 组合取代 ，2014 年 Apache 推出了 Log4j 2。Log4j 2 与 Log4j 不兼容，经过大量深度优化，其性能显著提升。

## 各个日志框架原理简介及介绍

### Log4j

Log4j是Apache下的一款开源的日志框架，通过在项目中使用Log4j，我们可以控制日志信息输出到控制台、文件、甚至是数据库中。我们可以控制每一条日志的输出格式，通过定义日志的输出级别，可以更加灵活方便的控制日志的输出过程。

Log4j的官方网站：[http://logging.apache.org/log4j/1.2/](http://logging.apache.org/log4j/1.2/?fileGuid=CPCv8kQddXqJPJ69)

如果要在项目中使用Log4j的话需要引入相应的Jar包

```plain
<dependency>
    <groupId>log4j</groupId>
    <artifactId>log4j</artifactId>
    <version>1.2.17</version>
</dependency>
```

Log4j主要是由Loggers、Appenders、和Layout组成

#### Loggers

Loggers主要负责处理日志记录，Loggers的命名有继承的机制，例如名称为com.test.log的logger会继承名称为com.test的logger。

Log4j中有一个特殊的logger叫作“root”，他是所有logger的根，也就是意味着其他所有的logger都会直接或者间接的继承自root。

#### Appenders

Appender用来指定日志输出到哪个地方，可以同时指定多个日志的输出目的地。Log4j的输出目的地有以下集中。

| 输出端类型               | 作用                                                         |
| :----------------------- | :----------------------------------------------------------- |
| ConsoleAppender          | 将日志输出到控制台                                           |
| FileAppender             | 将日志输出到文件                                             |
| DailyRollingFileAppender | 将日志输出到一个日志文件，并且每天输出到一个新的文件         |
| RollingFileAppender      | 将日志信息输出到日志文件，并且按照指定文件的尺寸，当文件大小达到指定尺寸时，会自动将文件改名，同时生成一个新的文件 |
| JDBCAppender             | 把日志信息保存到数据库中                                     |



#### Layouts

Layouts用于控制日志输出内容的格式，让我们可以使用各种需要的格式输出日志。Log4j常用的Layouts：

| 格式化器类型  | 作用                         |
| :------------ | :--------------------------- |
| HTMLLayout    | 格式化日志输出为HTML表格形式 |
| SimpleLayout  | 简单的日志输出格式化         |
| PatternLayout | 可以根据自定义格式输出日志   |



```plain
* log4j 采用类似 C 语言的 printf 函数的打印格式格式化日志信息，具体的占位符及其含义如下：
        %m 输出代码中指定的日志信息
        %p 输出优先级，及 DEBUG、INFO 等
        %n 换行符（Windows平台的换行符为 "\n"，Unix 平台为 "\n"）
        %r 输出自应用启动到输出该 log 信息耗费的毫秒数
        %c 输出打印语句所属的类的全名
        %t 输出产生该日志的线程全名
        %d 输出服务器当前时间，默认为 ISO8601，也可以指定格式，如：%d{yyyy年MM月dd日
        HH:mm:ss}
        %l 输出日志时间发生的位置，包括类名、线程、及在代码中的行数。如：
        Test.main(Test.java:10)
        %F 输出日志消息产生时所在的文件名称
        %L 输出代码中的行号
        %% 输出一个 "%" 字符
* 可以在 % 与字符之间加上修饰符来控制最小宽度、最大宽度和文本的对其方式。如：
        %5c 输出category名称，最小宽度是5，category<5，默认的情况下右对齐
        %-5c 输出category名称，最小宽度是5，category<5，"-"号指定左对齐,会有空格
        %.5c 输出category名称，最大宽度是5，category>5，就会将左边多出的字符截掉，<5不会有空格
        %20.30c category名称<20补空格，并且右对齐，>30字符，就从左边交远销出的字符截掉
```

### JUL

JUL全称是Java util Logging，是Java原生的日志框架,使用时不需要另外引用第三方类库,相对其他日志框架使用方便，学习简单，能够在小型应用中灵活使用。

JUL的架构

![图片](https://uploader.shimo.im/f/SXOfljeD8sp3B8Tu.png!thumbnail?fileGuid=CPCv8kQddXqJPJ69)


* Logger：被称为记录器，应用程序通过获取Logger对象，调用其API来发布日志信息。Logger通常是应用程序访问日志系统的入口程序
* Handler（**和Log4j的Appenders类似**）：每个Logger都会被关联一组Handlers，Logger会将日志交给关联的Handlers处理。此Handler是一个抽象，其具体的实现决定了日志记录的位置可以是控制台、文件、数据库等等
* Layouts：也被称为Formatters，它负责对日志进行格式化的处理，Layouts决定了数据在一条日志记录中的最终形式
* Filters：过滤器，根据需要定制哪些信息会被记录

总结一下就是用户使用Logger来进行日志的记录，Logger持有若干个Handler，日志的输出操作是由Handler来完成的，在Handler输出之前会通过自定义的Filter过滤规则过滤掉不需要输出的信息，最终由Handler决定使用什么样的Layout将日志格式化处理并决定输出到什么地方去。

接下来就写一个简单的入门案例看一下JUL是如何进行日志处理的

>JUL日志处理无需引用任何日志框架，是Java自带的功能

```plain
// 1.获取日志记录器对象
Logger logger = Logger.getLogger("com.macaque.JulLogTest");
// 关闭系统默认配置
logger.setUseParentHandlers(false);
// 自定义配置日志级别
// 创建ConsolHhandler 控制台输出
ConsoleHandler consoleHandler = new ConsoleHandler();
// 创建简单格式转换对象
SimpleFormatter simpleFormatter = new SimpleFormatter();
// 进行关联
consoleHandler.setFormatter(simpleFormatter);
logger.addHandler(consoleHandler);
// 配置日志具体级别
logger.setLevel(Level.ALL);
consoleHandler.setLevel(Level.ALL);
logger.severe("severe");
logger.warning("waring");
logger.info("info");
logger.config("config");
logger.fine("fine");
logger.finer("finer");
logger.finest("finest");
```

### JCL

全称为Jakarta Commons Logging，是由Apache提供的一个通用的日志API。

它的目标是“为所有的Java日志实现”提供一个统一的接口，它自身也提供一个日志实现，但是功能非常弱（SimpleLog）。所以一般不单独使用JCL。他允许开发人员使用不同的日志实现工具：Log4j、JDK自带的日志（JUL）

JCL有两个基本的抽象类：Log和LogFactory

![图片](https://uploader.shimo.im/f/4DG6JK3W4WlvbId8.png!thumbnail?fileGuid=CPCv8kQddXqJPJ69)

#### 如何使用

如果要在项目中使用JCL则要引入相应的jar包

```plain
<dependency>
    <groupId>commons-logging</groupId>
    <artifactId>commons-logging</artifactId>
    <version>1.2</version>
</dependency>
```

这只是引入了相应的日志门面，具体的日志实现还需要自己引入。

#### 原理介绍

在使用JCL打印日志的时候是通过调用其LogFactory动态加载Log的实现类

```plain
Log log = LogFactory.getLog(xxxx.class);
```

![图片](https://uploader.shimo.im/f/6fHMwOoLtweMVtbt.png!thumbnail?fileGuid=CPCv8kQddXqJPJ69)

然后在初始化的时候通过遍历数组进行查找有没有符合的实现类，遍历的数组初始化是

```plain
/**
 * The names of classes that will be tried (in order) as logging
 * adapters. Each class is expected to implement the Log interface,
 * and to throw NoClassDefFound or ExceptionInInitializerError when
 * loaded if the underlying logging library is not available. Any
 * other error indicates that the underlying logging library is available
 * but broken/unusable for some reason.
 */
private static final String[] classesToDiscover = {
        "org.apache.commons.logging.impl.Log4JLogger",
        "org.apache.commons.logging.impl.Jdk14Logger",
        "org.apache.commons.logging.impl.Jdk13LumberjackLogger",
        "org.apache.commons.logging.impl.SimpleLog"
};
```

遍历这个数组的逻辑

```plain
for(int i=0; i<classesToDiscover.length && result == null; ++i) {
    result = createLogFromClass(classesToDiscover[i], logCategory, true);
}
```

### SlF4j

简单日志门面（Simple Logging Facade For Java）SlF4j主要是为了给Java日志访问提供一套标准、规范的API框架，其主要意义在于提供接口，具体的实现可以交由其他日志框架。对于一般的Java项目而言，日志框架会选择Slf4j-api作为门面，配上具体的实现框架，中间使用桥接器进行桥接。

官方网站：[http://www.slf4j.org/](http://www.slf4j.org/?fileGuid=CPCv8kQddXqJPJ69)

Slf4j是目前市面上最流行的日志门面，其主要提供两大功能：

* 日志框架的绑定
* 日志框架的桥接

#### 日志的绑定

Slf4j支持各种日志框架，而Slf4j只是作为一个日志门面的存在，定义一个日志的打印规范，那么就会有两种情况，针对这两种情况引入包的类别略有不同。

1. 遵守Slf4j定义的规范：如果是遵守了Slf4j定义的日志规范的话，那么只需要引入两个包，一个是Slf4j的依赖，以及遵守了其规范的日志jar包实现即可
2. 没遵守Slf4j定义的规范：如果未遵守Slf4j定义的日志规范，那么需要引入三个包，一个是Slf4j的依赖，一个是适配器的包，一个是未遵守Slf4j定义的日志规范的包.

这是官网上给出的一张图，描述的就是其绑定的过程。

![图片](https://uploader.shimo.im/f/idqba54LXSLBltKi.png!thumbnail?fileGuid=CPCv8kQddXqJPJ69)



#### 日志绑定底层原理简介

在上面介绍的JCL的底层绑定原理我们了解到JCL是通过轮询的机制进行启动时检测绑定的日志实现，但是在Slf4j中不一样，我们可以从LoggerFactory.getLogger方法中进行入手查看，最终定位到LoggerFactory的findPossibleStaticLoggerBinderPathSet方法，具体如下。

```plain
private static String STATIC_LOGGER_BINDER_PATH = "org/slf4j/impl/StaticLoggerBinder.class";
static Set<URL> findPossibleStaticLoggerBinderPathSet() {
    Set<URL> staticLoggerBinderPathSet = new LinkedHashSet<URL>();
    try {
        ClassLoader loggerFactoryClassLoader = LoggerFactory.class.getClassLoader();
        Enumeration<URL> paths;
        if (loggerFactoryClassLoader == null) {
            paths = ClassLoader.getSystemResources(STATIC_LOGGER_BINDER_PATH);
        } else {
        // 这一处是重点,通过类加载器找到所有org/slf4j/impl/StaticLoggerBinder.class的类
            paths = loggerFactoryClassLoader.getResources(STATIC_LOGGER_BINDER_PATH);
        }
        while (paths.hasMoreElements()) {
            URL path = paths.nextElement();
            staticLoggerBinderPathSet.add(path);
        }
    } catch (IOException ioe) {
        Util.report("Error getting resources from path", ioe);
    }
    return staticLoggerBinderPathSet;
}
```

所以其加载过程简单如下

1. Slf4j通过LoggerFactory加载日志的具体实现
2. LoggerFactory在初始化的过程中，会通过performInitialization()方法绑定具体的日志实现
3. 在绑定具体实现的时候，通过类加载器，加载org/slf4j/impl/StaticLoggerBinder.class类
4. 所以，只要是一个日志实现框架，在org.slf4j.impl包中提供一个自己的StaticLoggerBinder类，在其中提供具体日志实现的LoggerFactory就可以被Slf4j进行加载管理了

#### 日志框架的桥接

在一些老项目中有可能一开始使用的不是Slf4j框架，如果在这时想要进行日志的升级，那么Slf4j也提供了这样的功能，提供了相应的桥接器进行对原有日志框架的替换，下图是官网所表示的如何进行的日志桥接。其实简单来说就是将原有的日志**重定向**到Slf4j然后交由Slf4j进行管理。

![图片](https://uploader.shimo.im/f/5iAQnDQkwVahteLb.png!thumbnail?fileGuid=CPCv8kQddXqJPJ69)

有可能看图不好理解桥接的意思，我们直接使用例子来演示一下Slf4j是如何替换原有的日志框架的。

首先我们建立一个项目首先使用Log4j进行打印日志，引入Log4j的jar包

```plain
<dependency>
    <groupId>log4j</groupId>
    <artifactId>log4j</artifactId>
    <version>1.2.17</version>
</dependency>
```

然后简单加入Log4j的配置进行打印日志

```plain
@Test
public void testLog4jToSlf4j(){
    Logger logger = Logger.getLogger(TestSlf4jBridge.class);
    logger.info("testLog4jToSlf4j");
}
```

控制台的输出如下，因为没有做日志格式的处理，所以只是简单输出了字符串。

![图片](https://uploader.shimo.im/f/uiUR2dy9EEUaXicl.png!thumbnail?fileGuid=CPCv8kQddXqJPJ69)

接下来我们要在不改动一点代码的情况，只是加入和移除一些依赖包就可以完成日志框架的升级，我们这里假设要升级为Logback，按照以下步骤进行即可。

1. 移除原有的日志框架（这里就是Log4j的日志框架）
2. 移除了原有日志框架，代码肯定报错了，所以再添加Log4j的日志桥接器
3. 加入Slf4j-api的依赖
4. 再加入Logback的日志实现依赖

完成这四步以后，日志框架就完成了升级，接下来我们看一下效果，这里在Logback的日志输出中加入了格式的处理。能看到日志已经是由Logback打印出来了。

![图片](https://uploader.shimo.im/f/Q6v9NG4grAFq8be4.png!thumbnail?fileGuid=CPCv8kQddXqJPJ69)


### Logback

Logback是由Log4j的创始人设计的另一款开源日志组件，性能比Log4j性能要好，官方网站：[https://logback.qos.ch/index.html](https://logback.qos.ch/index.html?fileGuid=CPCv8kQddXqJPJ69)

Logback主要分为三个模块

* logback-core：其他两个模块的基础模块
* logback-classic：它是Log4j的一个改良版本，同时它完整实现了Slf4j的API
* logback-access：访问模块与Servlet容器集成，通过Http来访问日志的功能

后续的日志都是通过Slf4j日志门面搭建日志系统，所以在代码是没有什么区别的，主要是通过改变配置文件和pom依赖。

#### pom依赖

```plain
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-api</artifactId>
    <version>1.7.26</version>
</dependency>
<dependency>
    <groupId>ch.qos.logback</groupId>
    <artifactId>logback-classic</artifactId>
    <version>1.2.3</version>
</dependency>
```

#### 基本配置

logback会依次读取以下类型配置文件：

* logback.groovy
* logabck-test.xml
* logback.xml

```plain
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
<!--
日志输出格式：
%-5level
%d{yyyy-MM-dd HH:mm:ss.SSS}日期
%c类的完整名称
%M为method
%L为行号
%thread线程名称
%m或者%msg为信息
%n换行
-->
<!--格式化输出：%d表示日期，%thread表示线程名，%-5level：级别从左显示5个字符宽度
%msg：日志消息，%n是换行符-->
<property name="pattern" value="%d{yyyy-MM-dd HH:mm:ss.SSS} %c [%thread]
%-5level %msg%n"/>
<!--
Appender: 设置日志信息的去向,常用的有以下几个
ch.qos.logback.core.ConsoleAppender (控制台)
3. FileAppender配置
ch.qos.logback.core.rolling.RollingFileAppender (文件大小到达指定尺
寸的时候产生一个新文件)
ch.qos.logback.core.FileAppender (文件)
-->
<appender name="console" class="ch.qos.logback.core.ConsoleAppender">
<!--输出流对象 默认 System.out 改为 System.err-->
<target>System.err</target>
<!--日志格式配置-->
<encoder
class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
<pattern>${pattern}</pattern>
</encoder>
</appender>
<!--
用来设置某一个包或者具体的某一个类的日志打印级别、以及指定<appender>。
<loger>仅有一个name属性，一个可选的level和一个可选的addtivity属性
name:
用来指定受此logger约束的某一个包或者具体的某一个类。
level:
用来设置打印级别，大小写无关：TRACE, DEBUG, INFO, WARN, ERROR, ALL 和
OFF，
如果未设置此属性，那么当前logger将会继承上级的级别。
additivity:
是否向上级loger传递打印信息。默认是true。
<logger>可以包含零个或多个<appender-ref>元素，标识这个appender将会添加到这个
logger
-->
<!--
也是<logger>元素，但是它是根logger。默认debug
level:用来设置打印级别，大小写无关：TRACE, DEBUG, INFO, WARN, ERROR, ALL
和 OFF，
<root>可以包含零个或多个<appender-ref>元素，标识这个appender将会添加到这个
logger。
-->
<root level="ALL">
<appender-ref ref="console"/>
</root>
</configuration>
```

#### FileAppender配置

```plain
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
<!-- 自定义属性 可以通过${name}进行引用-->
<property name="pattern" value="[%-5level] %d{yyyy-MM-dd HH:mm:ss} %c %M
%L [%thread] %m %n"/>
      <!--
        日志输出格式：
        %d{pattern}日期
        %m或者%msg为信息
        %M为method
        %L为行号
        %c类的完整名称
        %thread线程名称
        %n换行
        %-5level
      -->
<!-- 日志文件存放目录 -->
<property name="log_dir" value="d:/logs"></property>
<!--控制台输出appender对象-->
<appender name="console" class="ch.qos.logback.core.ConsoleAppender">
<!--输出流对象 默认 System.out 改为 System.err-->
<target>System.err</target>
<!--日志格式配置-->
<encoder
class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
<pattern>${pattern}</pattern>
</encoder>
</appender>
<!--日志文件输出appender对象-->
<appender name="file" class="ch.qos.logback.core.FileAppender">
<!--日志格式配置-->
<encoder
class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
<pattern>${pattern}</pattern>
</encoder>
<!--日志输出路径-->
<file>${log_dir}/logback.log</file>
</appender>
<!-- 生成html格式appender对象 -->
<appender name="htmlFile" class="ch.qos.logback.core.FileAppender">
<!--日志格式配置-->
<encoder class="ch.qos.logback.core.encoder.LayoutWrappingEncoder">
<layout class="ch.qos.logback.classic.html.HTMLLayout">
<pattern>%level%d{yyyy-MM-dd
HH:mm:ss}%c%M%L%thread%m</pattern>
</layout>
</encoder>
<!--日志输出路径-->
<file>${log_dir}/logback.html</file>
</appender>
<!--RootLogger对象-->
<root level="all">
<appender-ref ref="console"/>
<appender-ref ref="file"/>
<appender-ref ref="htmlFile"/>
</root>
</configuration>
```


#### RollingFileAppender配置

```plain
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
<!-- 自定义属性 可以通过${name}进行引用-->
<property name="pattern" value="[%-5level] %d{yyyy-MM-dd HH:mm:ss} %c %M
%L [%thread] %m %n"/>
      <!--
        日志输出格式：
        %d{pattern}日期
        %m或者%msg为信息
        %M为method
        %L为行号
        %c类的完整名称
        %thread线程名称
        %n换行
        %-5level
      -->
<!-- 日志文件存放目录 -->
<property name="log_dir" value="d:/logs"></property>
<!--控制台输出appender对象-->
<appender name="console" class="ch.qos.logback.core.ConsoleAppender">
  <!--输出流对象 默认 System.out 改为 System.err-->
  <target>System.err</target>
  <!--日志格式配置-->
  <encoder
  class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
  <pattern>${pattern}</pattern>
  </encoder>
</appender>
<!-- 日志文件拆分和归档的appender对象-->
<appender name="rollFile"
class="ch.qos.logback.core.rolling.RollingFileAppender">
  <!--日志格式配置-->
  <encoder
  class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
  <pattern>${pattern}</pattern>
  </encoder>
  <!--日志输出路径-->
  <file>${log_dir}/roll_logback.log</file>
  <!--指定日志文件拆分和压缩规则-->
  <rollingPolicy
    class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
    <!--通过指定压缩文件名称，来确定分割文件方式-->
    <fileNamePattern>${log_dir}/rolling.%d{yyyy-MMdd}.
    log%i.gz</fileNamePattern>
    <!--文件拆分大小-->
    <maxFileSize>1MB</maxFileSize>
  </rollingPolicy>
</appender>
<!--RootLogger对象-->
<root level="all">
  <appender-ref ref="console"/>
  <appender-ref ref="rollFile"/>
</root>
</configuration>
```

#### Filter和异步日志配置

```plain
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
<!-- 自定义属性 可以通过${name}进行引用-->
<property name="pattern" value="[%-5level] %d{yyyy-MM-dd HH:mm:ss} %c %M
%L [%thread] %m %n"/>
<!--
日志输出格式：
%d{pattern}日期
%m或者%msg为信息
%M为method
%L为行号
%c类的完整名称
%thread线程名称
%n换行
%-5level
-->
<!-- 日志文件存放目录 -->
<property name="log_dir" value="d:/logs/"></property>
<!--控制台输出appender对象-->
<appender name="console" class="ch.qos.logback.core.ConsoleAppender">
<!--输出流对象 默认 System.out 改为 System.err-->
<target>System.err</target>
<!--日志格式配置-->
<encoder
class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
<pattern>${pattern}</pattern>
</encoder>
</appender>
<!-- 日志文件拆分和归档的appender对象-->
<appender name="rollFile"
class="ch.qos.logback.core.rolling.RollingFileAppender">
<!--日志格式配置-->
<encoder
class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
<pattern>${pattern}</pattern>
</encoder>
<!--日志输出路径-->
<file>${log_dir}roll_logback.log</file>
<!--指定日志文件拆分和压缩规则-->
<rollingPolicy
class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
<!--通过指定压缩文件名称，来确定分割文件方式-->
<fileNamePattern>${log_dir}rolling.%d{yyyy-MMdd}.
log%i.gz</fileNamePattern>
<!--文件拆分大小-->
<maxFileSize>1MB</maxFileSize>
</rollingPolicy>
<!--filter配置-->
<filter class="ch.qos.logback.classic.filter.LevelFilter">
<!--设置拦截日志级别-->
<level>error</level>
<onMatch>ACCEPT</onMatch>
<onMismatch>DENY</onMismatch>
</filter>
</appender>
<!--异步日志-->
<appender name="async" class="ch.qos.logback.classic.AsyncAppender">
<appender-ref ref="rollFile"/>
</appender>
<!--RootLogger对象-->
<root level="all">
<appender-ref ref="console"/>
<appender-ref ref="async"/>
</root>
<!--自定义logger additivity表示是否从 rootLogger继承配置-->
<logger name="com.macaque" level="debug" additivity="false">
<appender-ref ref="console"/>
</logger>
</configuration>
```

#### Log4j转向Logback

官方提供了Log4j.properties转换成logback.xml文件配置的工具：[http://logback.qos.ch/translator/](http://logback.qos.ch/translator/?fileGuid=CPCv8kQddXqJPJ69)

### Log4j2

Apache Log4j2是对Log4j的升级版，参考了logback的一些优秀设计，并且修复了一些问题带来了一些重大的提升，主要有：

* 异常处理：在logback中Appender中的异常不会被应用感知到，但是在log4j2中提供了一些异常的处理机制
* 性能提升，log4j2相较于log4j和logback都具有很明显的性能提升，后面会有官方的测试数据
* 自动重载配置，参考了logback的配置，当然会提供自动刷新参数配置，最实用的就是在我们生产环境中动态的修改日志的级别而不需要重启应用
* 无垃圾机制，log4j在大部分情况下，都可以使用其设计的一套无垃圾机制，避免频繁的日志收集导致的jvm gc

官方网站：[https://logging.apache.org/log4j/2.x/](https://logging.apache.org/log4j/2.x/?fileGuid=CPCv8kQddXqJPJ69)

#### 如何使用Log4j2

目前市面上最主流的日志门面是Slf4j，虽然本身Log4j2也是日志门面，因为它的日志实现功能非常强大，性能优越。所以大家一般还是将Log4j2看作是日志额实现，Slf4j+Log4j2应该是未来的大势所趋。

添加依赖（配合Slf4j进行使用）


```plain
<!--使用slf4j作为日志的门面,使用log4j2来记录日志 -->
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-api</artifactId>
    <version>1.7.25</version>
</dependency>
<!--为slf4j绑定日志实现 log4j2的适配器 -->
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-slf4j-impl</artifactId>
    <version>2.10.0</version>
</dependency>
<!-- Log4j2 门面API-->
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-api</artifactId>
    <version>2.11.1</version>
</dependency>
<!-- Log4j2 日志实现 -->
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>2.11.1</version>
</dependency>
```

#### Log4j2的配置

Log4j2的配合Logback的配置特别一样

```plain
<?xml version="1.0" encoding="UTF-8"?>
<!--
    status="warn" 日志框架本身的输出日志级别
    monitorInterval="5" 自动加载配置文件的间隔时间，不低于 5 秒
-->
<Configuration status="debug" monitorInterval="5">
    <!--
        集中配置属性进行管理
        使用时通过:${name}
    -->
    <properties>
        <property name="LOG_HOME">/logs</property>
    </properties>
    <!--日志处理-->
    <Appenders>
        <!--控制台输出 appender-->
        <Console name="Console" target="SYSTEM_ERR">
            <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] [%-5level] %c{36}:%L --- %m%n" />
        </Console>
        <!--日志文件输出 appender-->
        <File name="file" fileName="${LOG_HOME}/myfile.log">
            <PatternLayout pattern="[%d{yyyy-MM-dd HH:mm:ss.SSS}] [%-5level] %l %c{36} - %m%n" />
        </File>
        <!--<Async name="Async">-->
            <!--<AppenderRef ref="file"/>-->
        <!--</Async>-->
        <!--使用随机读写刘的日志文件输出 appender，性能提高-->
        <RandomAccessFile name="accessFile" fileName="${LOG_HOME}/myAcclog.log">
            <PatternLayout pattern="[%d{yyyy-MM-dd HH:mm:ss.SSS}] [%-5level] %l %c{36} - %m%n" />
        </RandomAccessFile>
        <!--按照一定规则拆分的日志文件的 appender-->
        <RollingFile name="rollingFile" fileName="${LOG_HOME}/myrollog.log"
                     filePattern="/logs/$${date:yyyy-MM-dd}/myrollog-%d{yyyy-MM-dd-HH-mm}-%i.log">
            <!--日志级别过滤器-->
            <ThresholdFilter level="debug" onMatch="ACCEPT" onMismatch="DENY" />
            <!--日志消息格式-->
            <PatternLayout pattern="[%d{yyyy-MM-dd HH:mm:ss.SSS}] [%-5level] %l %c{36} - %msg%n" />
            <Policies>
                <!--在系统启动时，出发拆分规则，生产一个新的日志文件-->
                <OnStartupTriggeringPolicy />
                <!--按照文件大小拆分，10MB -->
                <SizeBasedTriggeringPolicy size="10 MB" />
                <!--按照时间节点拆分，规则根据filePattern定义的-->
                <TimeBasedTriggeringPolicy />
            </Policies>
            <!--在同一个目录下，文件的个数限定为 30 个，超过进行覆盖-->
            <DefaultRolloverStrategy max="30" />
        </RollingFile>
    </Appenders>
    <!--logger 定义-->
    <Loggers>
        <!--自定义异步 logger 对象
            includeLocation="false" 关闭日志记录的行号信息
            additivity="false" 不在继承 rootlogger 对象
        -->
        <AsyncLogger name="com.macaque" level="trace" includeLocation="false" additivity="false">
            <AppenderRef ref="Console"/>
        </AsyncLogger>
        <!--使用 rootLogger 配置 日志级别 level="trace"-->
        <Root level="trace">
            <!--指定日志使用的处理器-->
            <AppenderRef ref="Console" />
            <!--使用异步 appender-->
            <AppenderRef ref="Async" />
        </Root>
    </Loggers>
</Configuration>
```

#### 异步日志

Log4j2最大的特点就是异步日志，其性能的提升也是从异步日志中受益的。Log4j2提供了两种异步日志的实现，一种是AsyncAppender，一个是通过AsyncLogger，分别对应前面我们说的Apperder组件和Logger组件。

如果要使用异步日志还需要额外引入一个Jar包

```plain
<dependency>
    <groupId>com.lmax</groupId>
    <artifactId>disruptor</artifactId>
    <version>3.4.2</version>
</dependency>
```

官网目前不建议使用AsyncAppender的模式，所以这里就不介绍了，着重介绍一下关于AsyncLogger的日志。其中AsyncLogger有两种选择：全局异步和混合异步。

* 全局异步就是所有的日志都是异步的记录，在配置文件上不需要任何改动，只需要加一个全局的system配置即可：-Dlog4j2.contextSelector=org.apache.logging.log4j.core.async.AsyncLoggerContextSelector
* 混合异步就是，你可以在应用中同时使用同步日志和异步日志，这使得日志的配置方式更加灵活

```plain
<?xml version="1.0" encoding="UTF-8"?>
<Configuration status="WARN">
    <properties>
        <property name="LOG_HOME">D:/logs</property>
    </properties>
    <Appenders>
        <File name="file" fileName="${LOG_HOME}/myfile.log">
            <PatternLayout>
                <Pattern>%d %p %c{1.} [%t] %m%n</Pattern>
            </PatternLayout>
        </File>
        <Async name="Async">
            <AppenderRef ref="file"/>
        </Async>
    </Appenders>
    <Loggers>
        <AsyncLogger name="com.macaque" level="trace"
                     includeLocation="false" additivity="false">
            <AppenderRef ref="file"/>
        </AsyncLogger>
        <Root level="info" includeLocation="true">
            <AppenderRef ref="file"/>
        </Root>
    </Loggers>
</Configuration>
```

如上的配置：com.macaque日志是异步的，root日志是同步的

使用异步日志需要注意两个问题

* 如果使用异步日志，AsyncApperder、AsyncLogger和全局日志，不要同时出现。行呢个会和AsyncApperder一致，降至最低。
* 设置includeLocation=false，打印位置信息会急剧降低异步日志的性能，比同步日志还要慢

#### Log4j2的性能

Log4j2最厉害的地方在于异步输出日志时的性能表现，Log4j2再多线程的环境下吞吐量与Log4j和Logback比较官网提供的图。可以看到使用全局异步模式性能时最好的，其次是使用混合异步模式。

![图片](https://uploader.shimo.im/f/8NceYUYdVUWJMLJF.png!thumbnail?fileGuid=CPCv8kQddXqJPJ69)

### 


## 打印日志的最佳实践

>坚持把简单的事情做好就是不简单，坚持把平凡的事情做好就是不平凡。所谓成功，就是在平凡中做出不平凡的坚持！

好的日志记录方式可以提供我们足够多定位问题的依据。日志记录大家都会认为很简单，但是如何通过日志可以高效定位问题并不是简单的事情。

#### 

### 怎么记日志更方便我们查问题

1. 对外部的调用封装

程序中对外部系统与模块的依赖调用前后都记下日志，方便接口调试。出问题时也可以很快理清是哪块的问题。

```plain
boolean debugEnabled = logger.isDebugEnabled();
if (debugEnabled){
    logger.debug("Calling external system : {}",requestParam);
}
try{
    result = callRemoteSystem(requestParam);
    if (debugEnabled){
        logger.debug("Called successfully result is :{}",result);
    }
}catch (BusinessException e){
    logger.warn("Failed at calling xxx system request:{}",requestParam,e);
}catch (Exception e){
    logger.error("Failed at calling xxx system Exception request:{}",requestParam,e);
}
```

2. 状态变化

程序中重要的状态信息变化应该记录下来，方便查问题时还原现场，推断程序运行过程。

3. 系统入口与出口

这个粒度可以是重要的方法或者模块级别的，记录它的输入和输出，方便定位。

4. 业务异常

任何业务异常都应该记下来并且将异常栈给输出出来。

5. 很少出现的else情况

很少出现的else情况可能吞掉你的请求，或是赋予难以理解的最终结果

### 应该避免怎样的日志方式

1. 混淆信息的Log

日志应该是清晰准确的，比如当看到下面日志的时候，你知道是因为连接池取不到连接导致的问题吗？

```plain
  Connection connection = ConnectionFactory.getConnection();  
  if (connection == null) {  
      LOG.warn("System initialized unsuccessfully");  
  }  
```

2. 不分级别的记录日志

无论是异常情况还是入参请求使用打印日志的级别都是info级别，没有区分级别。这样有两个不好的地方。

* 无法将打印日志在物理进行区分至不同文件
* 大量输出无效日志，不利于系统性能提升，也不利于快速定位错误点

3. 遗漏关键信息

这里有可能包括两种情况

* 正常情况下未打印关键信息，比如下单流程的订单ID
* 异常情况下未打印异常栈

4. 动态拼接字符串

使用String字符串的拼接会使用StringBuilder的append()方式，有一定的性能损耗。使用占位符仅仅是替换动作，可以有效提升性能。

5. 重复打印日志

避免重复打印日志，浪费磁盘空间，务必在日志配置文件中设置additivety=false

6. 不加开关的日志输出

```plain
logger.debug("Called successfully result is :{}", JSONObject.toJSONString(result));
```

打印的是debug日志，如果这时候将日志级别改为info，虽然说不会输出debug 的日志，但是参数会进行字符串拼接运算，也就是JSON序列化的方法会被调用。是会浪费方法调用的性能。

7. 所有日志输入到一个文件中

不同级别的日志信息应该输出到不同的日志文件中。将信息进行区分，不仅能够有效的定位问题，也能够将现场保留的更久。

### 源代码

关于日志中的所有涉及到的源代码都在：[https://github.com/modouxiansheng/Macaque/tree/master/macaque-log](https://github.com/modouxiansheng/Macaque/tree/master/macaque-log?fileGuid=CPCv8kQddXqJPJ69)中，大家可以自己下载下来修改配置文件自己理解一下。

## 参考文章

* [Springboot整合log4j2日志全解](https://www.cnblogs.com/keeya/p/10101547.html?fileGuid=CPCv8kQddXqJPJ69)
* [为什么阿里巴巴禁止工程师直接使用日志系统(Log4j、Logback)中的 API](https://mp.weixin.qq.com/s/vCixKVXys5nTTcQQnzrs3w?fileGuid=CPCv8kQddXqJPJ69)
* [动态调整日志级别](https://codertang.com/2020/05/08/logger-level-modifier/?fileGuid=CPCv8kQddXqJPJ69)
* [程序那些事：日志记录的作用和方法](https://www.infoq.cn/article/why-and-how-log?fileGuid=CPCv8kQddXqJPJ69)
* [进阶之路：Java 日志框架全画传（上）](https://developer.aliyun.com/article/771530?fileGuid=CPCv8kQddXqJPJ69)
* [你还在用Logback？Log4j2的异步性能已经无敌了，还不快试试](https://juejin.cn/post/6945753017878577165?fileGuid=CPCv8kQddXqJPJ69)