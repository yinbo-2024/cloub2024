package com.atguigu.cloub;


import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    //多个表,分割
    static String tableNames = "t_storage,undo_log";

    //代码生成的项目 名称
    static String proPath = "/generator_mybatis";

    //代码生成的路径
    static String dataPath =  "/src/main/java";

    //项目生成包名
    static String packageName = "com.atguigu.cloub";

    //代码生成作者
    static String author = "yin bo";

    //数据库连接
    static String dbUrl = "jdbc:mysql://localhost:3306/seta_storage?useSSL=false&useUnicode=true&characterEncoding=UTF-8";
    //数据库驱动
    static String dbDrive = "com.mysql.jdbc.Driver";
    //数据库用户名
    static String dbUser = "root";
    //数据库密码
    static String dbPwd = "root";


    /**
     * RUN THIS
     */
    public static void main(String[] args) {

        //获取控制台的数据
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();

        String path = System.getProperty("user.dir");

        String projectPath = path+proPath ;//+ proPath;
        gc.setOutputDir(projectPath + dataPath);      //生成文件的输出目录
        log.info("文件生成路径：{}", projectPath + dataPath);
        gc.setAuthor(author);                                  //作者
        gc.setFileOverride(true);                              //是否覆蓋已有文件 默认值：false
        gc.setOpen(false);                                    //是否打开输出目录 默认值:true

        gc.setBaseColumnList(true);                              //开启 baseColumnList 默认false
        gc.setBaseResultMap(true);                               //开启 BaseResultMap 默认false
        gc.setMapperName("%sMapper");                            //mapper 命名方式 默认值：null 例如：%sDao 生成 UserDao
        gc.setXmlName("%sMapper");                                //Mapper xml 命名方式   默认值：null 例如：%sDao 生成 UserDao.xml
        gc.setServiceName("%sService");                            //service 命名方式   默认值：null 例如：%sBusiness 生成 UserBusiness
        gc.setServiceImplName("%sServiceImpl");                    //service impl 命名方式  默认值：null 例如：%sBusinessImpl 生成 UserBusinessImpl
        gc.setControllerName("%sController");    //controller 命名方式    默认值：null 例如：%sAction 生成 UserAction


        mpg.setGlobalConfig(gc);
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(dbUrl);
        dsc.setDriverName(dbDrive);
        dsc.setUsername(dbUser);
        dsc.setPassword(dbPwd);
        mpg.setDataSource(dsc);
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(packageName);
        pc.setModuleName(null);
        pc.setMapper("mapper");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setController("controller");

        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        mpg.setPackageInfo(pc);
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + "/src/main/resources/mapper/" +
                        tableInfo.getEntityName() + "Mapper" +
                        StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));
        // 策略配置	数据库表配置，通过该配置，可指定需要生成哪些表或者排除哪些表
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);    //表名生成策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
        strategy.setEntityLombokModel(true);        //【实体】是否为lombok模型（默认 false
        strategy.setRestControllerStyle(true);        //生成 @RestController 控制器
        String tables = tableNames;
        String[] num = tables.split(",");
        log.info("生产表数量：{}, 表：{}", num.length, tables);
        strategy.setInclude(num);                       // 需要生成的表可以多张表
        //strategy.setExclude(new String[]{"test"});      // 排除生成的表
        //strategy.setTablePrefix("bus_");
        //strategy.setTablePrefix("sys_");
        strategy.setControllerMappingHyphenStyle(true);        //驼峰转连字符
        strategy.setTablePrefix(pc.getModuleName() + "_");    //是否生成实体时，生成字段注解
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}
