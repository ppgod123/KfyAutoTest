package com.fatester.common;

import com.fatester.BaseClass.ApplicationConfig;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;

public class YmlUtil {


    public static void main(String[] args) throws IOException {
//       File file= new File("D:\\KfyAutoTest\\src\\test\\java\\login.yaml");
//       ObjectMapper objectMapper= new ObjectMapper(new YAMLFactory());
//        ApplicationConfig applicationConfig = objectMapper.readValue(file,ApplicationConfig.class);
//        System.out.println("配置文件信息："+applicationConfig.toString());
          //Read_Yaml();
    }
    public ApplicationConfig Read_Yaml(){
        ApplicationConfig config = null;
        try {
            //创建输入流
            InputStream inputStream = YmlUtil.class.getClassLoader().getResourceAsStream("login.yaml");
            //创建yaml对象
            Yaml yaml= new Yaml();
            //读取数据
            //Object config = yaml.load(inputStream);
            config = yaml.loadAs(inputStream, ApplicationConfig.class);
            System.out.println(config);
        }catch (Exception e){
            e.printStackTrace();
        }

        //遍历取值查看
//        DatabaseConfig database = config.getDatabase();
//        System.out.println(database.getDbname());
        return config;
    }
}
