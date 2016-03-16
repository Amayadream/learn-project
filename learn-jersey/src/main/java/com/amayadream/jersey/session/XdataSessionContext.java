package com.amayadream.jersey.session;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @author :  Amayadream
 * @date :  2016.03.16 21:46
 */
public class XdataSessionContext {
    private static XdataSessionContext instance;
    private HashMap mymap;

    private XdataSessionContext() {
        mymap = new HashMap();
    }

    public static XdataSessionContext getInstance() {
        if (instance == null) {
            instance = new XdataSessionContext();
        }
        return instance;
    }

    public synchronized void AddSession(HttpSession session) {
        if (session != null) {
            mymap.put(session.getId(), session);
        }
    }

    public synchronized void DelSession(HttpSession session) {
        if (session != null) {
            mymap.remove(session.getId());
        }
    }

    public synchronized HttpSession getSession(String session_id) {
        if (session_id == null) return null;
        return (HttpSession) mymap.get(session_id);
    }
}
