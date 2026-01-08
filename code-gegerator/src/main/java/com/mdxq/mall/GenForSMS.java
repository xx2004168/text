package com.mdxq.mall;

import com.mybatisflex.codegen.config.GlobalConfig;
import com.mybatisflex.codegen.dialect.JdbcTypeMapping;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.math.BigDecimal;

/**
 * @author XuXin
 */
public class GenForSMS {

    /**
     * MySQL主机地址
     */
    private static final String MYSQL_HOST = "127.0.0.1:3306";
    /**
     * 数据库名
     */
    private static final String DB_NAME = "md_mall_sale";//后续的模块
    /**
     * 数据库账号
     */
    private static final String MYSQL_USERNAME = "root";
    /**
     * 数据库密码
     */
    private static final String MYSQL_PASSWORD = "root";//密码要改
    /**
     * 作者
     */
    private static final String AUTHOR = "XuXin";//注释中的作者名称要变
    /**
     * 子模块名: 指定生成到哪个子项目中
     */
    private static final String MODULE_NAME = "shop-sale";//后续模块要改
    /**
     * 根包
     */
    private static final String BASE_PACKAGE = "com.mdxq.mall.sale";//后续模块要改
    /**
     * 数据库表名前缀
     */
    private static final String[] TABLE_PREFIX = {"sms_"};//后续模块要改

    public static void main(String[] args) {
        // 将 BigDecimal 类型转为 Double 类型    
        JdbcTypeMapping.registerMapping(BigDecimal.class, Double.class);
        new com.mybatisflex.codegen.Generator(getDataSource(), getGlobalConfig()).generate();
    }

    /**
     * 获取MyBatisFlex生成器配置对象
     *
     * @return MyBatisFlex生成器配置对象
     */
    public static GlobalConfig getGlobalConfig() {
        GlobalConfig globalConfig = new GlobalConfig();

        // 注释配置: 作者    
        globalConfig.getJavadocConfig().setAuthor(AUTHOR);
        // 包配置: src目录，mapper配置文件目录，根包    
        globalConfig.getPackageConfig()
                .setSourceDir(MODULE_NAME + "/src/main/java")
                .setMapperXmlPath(MODULE_NAME + "/src/main/resources/mapper")
                .setBasePackage(BASE_PACKAGE);
        // 策略配置: 表前缀，数据库名，忽略哪些表    
        // 可调用 setGenerateTable() 来指定生成哪些表: 未配置时，默认生成指定数据库下的所有表  
        // 可调用 setUnGenerateTable() 来指定排除哪些表: 未配置时，不排除任何表
        globalConfig.setGenerateTable(
                
        );
        globalConfig.getStrategyConfig()
                .setTablePrefix(TABLE_PREFIX)
                .setGenerateSchema(DB_NAME);
        // 生成实体类，辅助类，Mapper接口，Mapper配置，Service接口，Service实现类和Controller控制器  
        globalConfig.enableEntity().setWithLombok(true);
        globalConfig.enableTableDef();
        globalConfig.enableMapper();
        globalConfig.enableMapperXml();
        globalConfig.enableService();
        globalConfig.enableServiceImpl();
//                .setSuperClass(CacheableServiceImpl.class)
//                .setCacheExample(true);
        globalConfig.enableController();
        globalConfig.setControllerRequestMappingPrefix("/api/v1");
        // 返回MyBatisFlex生成器配置对象  
        return globalConfig;
    }

    /***
     * 获取Hikari数据源对象  
     *
     * @return Hikari数据源对象
     */
    public static DataSource getDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setUsername(MYSQL_USERNAME);
        dataSource.setPassword(MYSQL_PASSWORD);
        dataSource.setJdbcUrl("jdbc:mysql://" + MYSQL_HOST + "/" + DB_NAME
                + "?serverTimezone=Asia/Shanghai"
                + "&useUnicode=true&characterEncoding=utf-8");
        return dataSource;
    }
}