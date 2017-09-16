package com.anglll.pink.data.retrofit.api;

import com.anglll.pink.data.db.SongListDao;
import com.anglll.pink.data.model.SongList;
import com.anglll.pink.data.source.db.DaoMasterHelper;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.annotations.NonNull;

/**
 * Created by yuan on 2017/7/20 0020.
 */

public class LocalService {
    public Flowable<SongList> getSongList(final long id) {
        return Flowable.create(new FlowableOnSubscribe<SongList>() {
            @Override
            public void subscribe(@NonNull FlowableEmitter<SongList> e) throws Exception {
                SongList songList = DaoMasterHelper.getDaoSession()
                        .getSongListDao()
                        .queryBuilder()
                        .where(SongListDao.Properties.Id.eq(id))
                        .unique();
                if (songList != null) {
                    e.onNext(songList);
                } else {
                    e.onComplete();
                }
            }
        }, BackpressureStrategy.ERROR);
    }
}
