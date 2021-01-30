仿写mybatis框架源码及解析
#Configuration配置类，配置以下属性
#Environment配置类 final修饰不可继承扩展
可注入3个选项环境id，事务工厂，数据源 id,transactionFactory,dataSource


#PropertyTokenizer 使用了迭代子模式
方法解析
通过继承Iterable 实现迭代 返回自己本身
继承Iterator 实现向下获取 
hasNext 判断子代有没有
next 把子代放进去继续迭代
对一个长串的类属性进行分解 如person[0].birthdate.year，将依次取得person[0], birthdate, year

#使用设计的模式
工厂模式: 先定义一个ObjectFactory,声明处理所有创建对象的方法
然后交给默认工厂去实现 DefaultObjectFactory,并且实现Serializable接口加快数据传输和兼容性


