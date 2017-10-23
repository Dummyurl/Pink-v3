package com.anglll.pink.socket;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by yuan on 2017/10/23 0023.
 */

public class UIA extends Activity implements SocketCore.SocketListener {

    private SocketCore socketCore;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        socketCore = SocketCore.getInstance();
        socketCore.addListener(this);
        socketCore.scanIP();
    }

    @Override
    protected void onDestroy() {
        socketCore.removeListener(this);
        super.onDestroy();
    }

    @Override
    public void ScanResult(String res) {

    }
}
