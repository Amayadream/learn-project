package com.amayadream.comet4j.controller;

import org.comet4j.core.event.ConnectEvent;
import org.comet4j.core.listener.ConnectListener;

/**
 * @author :  Amayadream
 * @date :  2016.06.30 15:34
 */
public class SampleListener extends ConnectListener {

    @Override
    public boolean handleEvent(ConnectEvent connectEvent) {
        return false;
    }
}
