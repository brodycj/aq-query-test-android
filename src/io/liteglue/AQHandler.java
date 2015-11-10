//
//  AQHandler.java
//
//  Author: Christopher J. Brody
//
//  License: UNLICENSE (public domain)
//

package io.liteglue;

public interface AQHandler {
    public void handleMessage(String name, String parameters, String cbHandler, String cbId);
}
