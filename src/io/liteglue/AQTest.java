package io.liteglue;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebResourceResponse;

public class AQTest extends Activity
{
    AQManager manager = new AQManager();

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final WebView webView = (WebView)findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);

        manager.setHandler("as", new AQHandler() {
            @Override
            public void handleMessage(String name, String parameters) {
                webView.loadUrl("javascript:aqcallback('got message: " + name + " parameters: " + parameters + "')");
            }
        });

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public WebResourceResponse shouldInterceptRequest(WebView v, String url) {
                if (url.startsWith("file:///aq")) {
                    String [] topComponents = url.split("#");
                    if (topComponents.length < 2) {
                        webView.loadUrl("javascript:aqcallback('SORRY MISSING #')");
                        return null;
                    }

                    String handleString = topComponents[1];

                    String [] handleComponents = handleString.split("\\?");

                    if (handleComponents.length < 2) {
                        webView.loadUrl("javascript:aqcallback('SORRY MISSING ?')");
                        return null;
                    }

                    String parameters = handleComponents[1];

                    String [] routeComponents = handleComponents[0].split(":");
                    if (routeComponents.length < 2) {
                        webView.loadUrl("javascript:aqcallback('SORRY MISSING :')");
                        return null;
                    }

                    String routeParameters = routeComponents[1];

                    int routeParametersSep = routeParameters.indexOf('$');
                    if (routeParametersSep < 0) {
                        webView.loadUrl("javascript:aqcallback('SORRY MISSING $')");
                        return null;
                    }

                    String me = routeParameters.substring(0, routeParametersSep);

                    // XXX SECURITY TODO: use code parameter to check a security code, like they do in the Cordova framework
                    //String code = routeParameters.substring(routeParametersSep + 1, routeParameters.length());
                    // ...

                    //webView.loadUrl("javascript:aqcallback('got components: " + routeComponents[0] + " " + me + " " + parameters + "')");

                    manager.getHandler(routeComponents[0]).handleMessage(me, parameters);
                }
                // XXX TODO return new WebResourceResponse with null (no) data
                return null;
            }
        });

        webView.loadUrl("file:///android_asset/www/index.html");
    }
}
