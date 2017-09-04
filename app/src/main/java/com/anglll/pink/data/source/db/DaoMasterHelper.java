package com.anglll.pink.data.source.db;

import com.anglll.pink.Injection;
import com.anglll.pink.data.db.DaoMaster;
import com.anglll.pink.data.db.DaoSession;
import com.anglll.pink.utils.Config;

/**
 * Created by yuan on 2017/7/20 0020.
 */

public class DaoMasterHelper {
    private static DaoSession daoSession;

    public static DaoSession getDaoSession() {
        if (daoSession == null) {
            DaoMaster.DevOpenHelper devOpenHelper =
                    new DaoMaster.DevOpenHelper(Injection.provideContext(), Config.DB_NAME);
            DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
            daoSession = daoMaster.newSession();
        }
        return daoSession;
    }
}
