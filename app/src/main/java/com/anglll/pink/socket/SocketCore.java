package com.anglll.pink.socket;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuan on 2017/10/23 0023.
 */

public class SocketCore {
    private static SocketCore socketCore;
    private static Socket socket;
    List<SocketListener> listeners = new ArrayList<>();

    /**
     * 单例获取
     */
    public static SocketCore getInstance() {
        synchronized (Socket.class) {
            if (socketCore == null) {
                socket = new Socket();
                socketCore = new SocketCore();
            }
            return socketCore;
        }
    }

    //私有化构造函数，防止其他方式创建
    private SocketCore() {

    }


    public void scanIP() {

        //做相应操作
        for (SocketListener listener : listeners) {
            listener.ScanResult("");
        }

    }

    /**
     * 由于不是一个界面使用，所以使用添加listener的方式进行，而不是set Listener
     */
    public void addListener(SocketListener listener) {
        listeners.add(listener);
    }

    /**
     * 记得解绑listener，不然 oom
     */
    public void removeListener(SocketListener listener) {
        listeners.remove(listener);
    }

    /**
     * 定义各种操作相应，和mvp中的view很像
     */
    interface SocketListener {
        void ScanResult(String res);
    }


}
