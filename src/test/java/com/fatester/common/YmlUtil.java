package com.fatester.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fatester.BaseClass.AllPort;
import com.fatester.BaseClass.ApplicationConfig;
import com.fatester.BaseClass.DatabaseConfig;
import com.fatester.BaseClass.OpConfig;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class YmlUtil {


    public static void main(String[] args) throws IOException {
//       File file= new File("D:\\KfyAutoTest\\src\\test\\java\\login.yaml");
//       ObjectMapper objectMapper= new ObjectMapper(new YAMLFactory());
//        ApplicationConfig applicationConfig = objectMapper.readValue(file,ApplicationConfig.class);
//        System.out.println("配置文件信息："+applicationConfig.toString());
        YmlUtil ymlUtil = new YmlUtil();
        System.out.println(ymlUtil.Read_Yaml());
        //ymlUtil.Write_Yaml();
    }
    public Map<String, Object> Read_Yaml1() {
        ApplicationConfig config = null;
        Map<String, Object> obj = null;
        try {
            //创建输入流
            InputStream inputStream = YmlUtil.class.getClassLoader().getResourceAsStream("login.yaml");
            //创建yaml对象
            Yaml yaml = new Yaml();
            //读取数据
            //config = yaml.loadAs(inputStream, ApplicationConfig.class);
            //System.out.println(config);
            obj = yaml.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
    public AllPort Read_Yaml() {
        AllPort config = null;
        try {
            //创建输入流
            InputStream inputStream = YmlUtil.class.getClassLoader().getResourceAsStream("login.yaml");
            //创建yaml对象
            Yaml yaml = new Yaml();
            //读取数据
            config = yaml.loadAs(inputStream, AllPort.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return config;
    }
    public void Write_Yaml(){
        try {
            ApplicationConfig applicationConfig= new ApplicationConfig();
            applicationConfig.setAuthor("冯爱军");
            DatabaseConfig databaseConfig= new DatabaseConfig();
            databaseConfig.setDriver("com.mysql.jdbc.Driver");
            databaseConfig.setDbname("db_mdcfacade");
            databaseConfig.setIp("172.31.94.66");
            databaseConfig.setPort(3306);
            databaseConfig.setUsername("dev4mdcfacaden");
            databaseConfig.setPassword("M4GEQdx9ymI");
            ObjectMapper objectMapper= new ObjectMapper(new YAMLFactory());
            objectMapper.writeValue(new File("src/test/resources/DataSource.yaml"),databaseConfig);
            System.out.println("文件创建写入成功");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
