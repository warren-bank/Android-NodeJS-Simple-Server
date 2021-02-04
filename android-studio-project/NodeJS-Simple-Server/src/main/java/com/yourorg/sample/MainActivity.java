package com.yourorg.sample;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.system.Os;

public class MainActivity extends Activity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
        System.loadLibrary("node");
    }

    //We just want one instance of node running in the background.
    public static boolean _startedNodeAlready=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            if (Build.VERSION.SDK_INT >= 21) {
                Os.setenv("NODE_TLS_REJECT_UNAUTHORIZED", "0", true);
            }
            else {
                setenv("NODE_TLS_REJECT_UNAUTHORIZED", "0", 1);
            }
        }
        catch(Exception e) {}

        if( !_startedNodeAlready ) {
            _startedNodeAlready=true;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    startNodeWithArguments(new String[]{"node", "-e", ""
                      + "var http = require('http');"
                      + "var CRLF = '\\r\\n';"
                      + "var http_server = http.createServer((request, response) => {"
                      + "  response.end("
                      + "    'versions = ' + JSON.stringify(process.versions, null, 2) + CRLF + CRLF +"
                      + "    'env vars = ' + JSON.stringify(process.env,      null, 2)"
                      + "  );"
                      + "});"
                      + "http_server.listen(3000);"
                    });
                }
            }).start();
        }
    }

    /**
     * Native methods that are implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native Integer startNodeWithArguments(String[] arguments);
    public native Integer setenv(String name, String value, Integer overwrite);
}
