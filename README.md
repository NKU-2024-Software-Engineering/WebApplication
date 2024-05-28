# 软件工程期末作业

## 概述

+ 后端：spring boot、mybatis-plus、java
+ 前端：nodejs、vue脚手架、element-ui
+ 数据库：mysql

## v.1.0 项目创建

## v.1.1 数据库连接

对应文件修改`src/main/resources/application.yml`
需要本地化修改

## v.1.2 代码生成器

在`wms.common`中新建了`CodeGenerator`用于生成与数据库相关的代码。
使用过程：右键启动该程序，然后在终端输入需要生成的对应的表名
> 注意：已经将覆盖文件关闭，如果已经存在对应文件不会生成第二遍，避免将后续修改覆盖

生成后，需要在对应的Mapper文件中添加`@Mapper`注解。
新添加的方法应写在对应的`Controller`中。

## v.1.3 实现增删改查

在`Controller`中写函数实现了增删改查，使用`Postman`进行`http`的发送可以实现数据库中数据的增删改查。

## v.2.0 增加前端页面

使用了`element plus`的`container`组件实现了基本的页面显示。

## v.2.1 实现页面布局的拆分

将`Index.vue`中的侧栏、顶栏、内容拆分为`Aside.vue`、`Header.vue`和`Main.vue`三个控件。方便后续进行专门的修改。
