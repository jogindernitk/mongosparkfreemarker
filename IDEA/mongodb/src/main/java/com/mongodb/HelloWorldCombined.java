package com.mongodb;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.halt;

/**
 * Created by Joginder on 2016-03-30.
 */
public class HelloWorldCombined {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldFreemarkerStyle.class, "/");
        StringWriter stringWriter = new StringWriter();
        get("/hello", (req, res) -> {
            try {
                Template template = configuration.getTemplate("hello.ftl");
                Map<String,Object> helloMap = new HashMap<String, Object>();
                helloMap.put("name", "Reyansh");
                template.process(helloMap,stringWriter);
                System.out.println(stringWriter);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (TemplateException e) {
                halt(500);
                e.printStackTrace();
            }
            return stringWriter;
        });
    }
}
