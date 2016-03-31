package com.mongodb;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Joginder on 2016-03-30.
 */
public class HelloWorldFreemarkerStyle {
    public static void main(String [] arg) {
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldFreemarkerStyle.class, "/");
        try {
            Template template = configuration.getTemplate("hello.ftl");
            StringWriter stringWriter = new StringWriter();
            Map<String,Object> helloMap = new HashMap<String, Object>();
            helloMap.put("name", "Reyansh");
            template.process(helloMap,stringWriter);
            System.out.println(stringWriter);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
