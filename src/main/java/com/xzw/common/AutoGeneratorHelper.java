package com.xzw.common;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ResourceBundle;

public class AutoGeneratorHelper {



    /**
     * <p>
     * 测试 run 执行
     * </p>
     * <p>
     * 更多使用查看 http://mp.baomidou.com
     * </p>
     */
    public static void main(String[] args) {

//用来获取Mybatis-Plus.properties文件的配置信息
        ResourceBundle rb =  ResourceBundle.getBundle("db");
        AutoGenerator mpg = new AutoGenerator();
// 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(rb.getString("OutputDir"));
        gc.setFileOverride(true);
        gc.setActiveRecord(true);// 开启 activeRecord 模式
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor(rb.getString("author"));
        mpg.setGlobalConfig(gc);


// 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert());
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername(rb.getString("userName"));
        dsc.setPassword(rb.getString("passWord"));
        dsc.setUrl(rb.getString("url"));
        mpg.setDataSource(dsc);


// 策略配置
        StrategyConfig strategy = new StrategyConfig();
//strategy.setTablePrefix(new String[] { "bmd_", "mp_" });// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setInclude(new String[] { rb.getString("tableName")}); // 需要生成的表
// 字段名生成策略
// strategy.setFieldNaming(NamingStrategy.underline_to_camel);
//strategy.setSuperServiceImplClass("com.baomidou.springwind.service.support.BaseServiceImpl");
        mpg.setStrategy(strategy);


   // 包配置
        PackageConfig pc = new PackageConfig();
//        pc.setModuleName("log");
        pc.setParent(rb.getString("parent"));// 自定义包路径
        pc.setController("controller"+rb.getString("className"));// 这里是控制器包名，默认 web
        pc.setEntity("entity"+rb.getString("className"));
        pc.setMapper("mapper"+rb.getString("className"));
        pc.setXml("mapper"+rb.getString("className"));
        pc.setService("service"+rb.getString("className"));
        pc.setServiceImpl("service"+rb.getString("className")+".impl");
        mpg.setPackageInfo(pc);
   // 执行生成
        mpg.execute();
    }


}
