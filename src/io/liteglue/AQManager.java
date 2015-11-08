//
//  AQManager.java
//
//  Author: Christopher J. Brody
//
//  License: UNLICENSE (public domain)
//

package io.liteglue;

import java.util.concurrent.ConcurrentHashMap;

public class AQManager {
    ConcurrentHashMap<String, AQHandler> map = new ConcurrentHashMap<String, AQHandler>();

    public void setHandler(String name, AQHandler handler) {
        map.put(name, handler);
    }

    public AQHandler getHandler(String name) {
        return map.get(name);
    }
}
