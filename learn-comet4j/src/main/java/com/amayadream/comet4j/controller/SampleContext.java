package com.amayadream.comet4j.controller;

import org.comet4j.core.CometContext;

/**
 * 初始化comet4j
 * @author :  Amayadream
 * @date :  2016.06.29 10:19
 */
public class SampleContext {

    public SampleContext() {
        CometContext.getInstance().registChannel("map");
    }

}
