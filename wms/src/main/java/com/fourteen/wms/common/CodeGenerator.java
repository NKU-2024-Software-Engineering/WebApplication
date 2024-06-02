package com.fourteen.wms.common;

import java.sql.Types;
import java.util.Collections;
import java.util.Scanner;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * @author akaziki
 * @className CodeGenerator
 * @description 自动代码生成
 * @date 2024/05/27 13:53
 */

public class CodeGenerator {

    public static void Generator(String tableName) {
        FastAutoGenerator.create(
            "jdbc:mysql://localhost:3306/wms?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8",
            "root", "root").globalConfig(builder -> {
                builder.author("akaziki") // 设置作者
                    .enableSwagger() // 开启 swagger 模式
                    .outputDir(System.getProperty("user.dir") + "/src/main/java"); // 指定输出目录
            }).dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                if (typeCode == Types.SMALLINT) {
                    // 自定义类型转换
                    return DbColumnType.INTEGER;
                }
                return typeRegistry.getColumnType(metaInfo);
            })).packageConfig(builder -> {
                builder.parent("com.fourteen.wms") // 设置父包名
                    // .moduleName("common") // 设置父包模块名
                    .entity("entity")// 设置实体类包
                    .controller("controller") // 控制层包名
                    .mapper("mapper")// mapper层包名
                    .service("service")// service层包名
                    .serviceImpl("service.impl")// service实现类包名
                    .pathInfo(Collections.singletonMap(OutputFile.xml,
                        System.getProperty("user.dir") + "/wms/src/main/resources/mapper"));
            } // 设置mapperXml生成路径
        ).strategyConfig(builder -> {
            builder.addInclude(tableName) // 设置需要生成的表名
                // .addTablePrefix("t_", "c_") // 设置过滤表前缀
                // entity配置
                .entityBuilder()//
                .enableLombok()//
                .enableChainModel()//
                .naming(NamingStrategy.underline_to_camel)// 数据表映射实体命名策略：默认下划线转驼峰underline_to_camel
                .columnNaming(NamingStrategy.underline_to_camel)// 表字段映射实体属性命名规则：默认null，不指定按照naming执行
                .idType(IdType.AUTO)// 添加全局主键类型
//                 .enableFileOverride()// 允许文件覆盖
                // mapper配置
                .mapperBuilder()//
                .superClass(BaseMapper.class) // 继承BaseMapper
                // .enableMapperAnnotation()// 开启mapper注解
                .enableBaseResultMap()// 启用xml文件中的BaseResultMap 生成
                .enableBaseColumnList()// 启用xml文件中的BaseColumnList
                .formatMapperFileName("%sMapper")// 格式化Dao类名称
                .formatXmlFileName("%sMapper")// 格式化xml文件名称
//                 .enableFileOverride()// 允许文件覆盖
                // service 配置
                .serviceBuilder()//
                .formatServiceFileName("%sService")// 格式化 service 接口文件名称
                .formatServiceImplFileName("%sServiceImpl")// 格式化 service 接口文件名称
//                 .enableFileOverride()// 允许文件覆盖
                // controller配置
                .controllerBuilder()//
                // .enableFileOverride()// 允许文件覆盖
                .formatFileName("%sController") // 格式化Controller名称
                .enableRestStyle();
        }).templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
            .execute();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入表名：");
        // 从控制台读取用户输入的信息
        String name = scanner.nextLine();

        Generator(name);

        // 关闭 Scanner 对象
        scanner.close();
    }
}
