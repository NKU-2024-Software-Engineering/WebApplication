# 软件工程期末作业

## 概述

+ 后端：spring boot、mybatis-plus、java
+ 前端：nodejs、vue脚手架、element-ui
+ 数据库：mysql

## v.1.0 项目创建

## v.1.1 数据库连接

## v.1.2 代码生成器

在wms.common中新建了CodeGenerator用于生成与数据库相关的代码。
使用过程：右键启动该程序，然后在终端输入需要生成的对应的表名
> 注意：已经将覆盖文件关闭，如果已经存在对应文件不会生成第二遍，避免将后续修改覆盖

生成后，需要在对应的Mapper文件中添加`@Mapper`注解。
新添加的方法应写在对应的Controller中。