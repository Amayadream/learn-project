package com.amayadream.generator.utils;

import freemarker.template.*;

import java.io.*;
import java.util.Locale;
import java.util.Map;

/**
 * @author :  Amayadream
 * @date :  2016.04.13 22:39
 */
public class FreeMarkerUtils {

    private static Configuration config = null;

    private FreeMarkerUtils(){
    }

    public static Configuration getInstance(String path){
        if (config == null) {
            config = new Configuration();
            config.setClassForTemplateLoading(FreeMarkerUtils.class, path);
            config.setEncoding(Locale.getDefault(), "UTF-8");
            config.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
        }
        return config;
    }

    /**
     *
     * @param config    freemarker配置
     * @param ftl       模板文件名称
     * @param root      参数
     * @param targetFile    要生成的文件
     * @return
     */
    public static boolean createFile(Configuration config, String ftl, Map<String, Object> root, String targetFile) {
        try {
            Template template = config.getTemplate(ftl);
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(targetFile), "UTF-8"));
            template.process(root, out);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (TemplateException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }



}
