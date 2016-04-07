package com.amayadream.log4j2.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * @author :  Amayadream
 * @date :  2016.04.07 21:21
 */
public class LoggerTest {

    @Test
    public void test(){
        Logger logger = LogManager.getLogger(getClass());
        logger.info("log4j info");
    }
}
