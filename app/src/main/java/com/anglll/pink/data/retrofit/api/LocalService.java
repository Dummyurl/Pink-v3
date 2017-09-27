package com.anglll.pink.data.retrofit.api;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;

import com.anglll.pink.data.db.SongListDao;
import com.anglll.pink.data.model.Event;
import com.anglll.pink.data.model.SongList;
import com.anglll.pink.data.model.Todo;
import com.anglll.pink.data.source.db.DaoMasterHelper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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

    public Flowable<Todo> getTodo(final ContentResolver cr) {
        return Flowable.create(new FlowableOnSubscribe<Todo>() {
            @Override
            public void subscribe(@NonNull FlowableEmitter<Todo> e) throws Exception {
                Uri calenderEventUri = Uri.parse("content://com.android.calendar/events");

                String options = CalendarContract.Events.DTSTART + ">=? and "
                        + CalendarContract.Events.DTSTART
                        + "<=?";

                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);

                Cursor cursor = cr.query(calenderEventUri,
                        new String[]{
                                CalendarContract.Events.CALENDAR_ID,
                                CalendarContract.Events.TITLE,
                                CalendarContract.Events.DTSTART,
                                CalendarContract.Events.DTEND,
                                CalendarContract.Events.RRULE,
                                CalendarContract.Events.EVENT_TIMEZONE
                        },
                        options,
                        new String[]{
                                String.valueOf(calendar.getTimeInMillis()),
                                String.valueOf(calendar.getTimeInMillis() + 86399999)
                        }, null);
                Todo todo = new Todo();
                List<Event> eventList = new ArrayList<Event>();
                while (cursor != null && cursor.moveToNext()) {
                    Event event = new Event();
                    event.setCalendar_id(cursor.getString(cursor.getColumnIndex(CalendarContract.Events.CALENDAR_ID)));
                    event.setTitle(cursor.getString(cursor.getColumnIndex(CalendarContract.Events.TITLE)));
                    event.setDtstart(cursor.getString(cursor.getColumnIndex(CalendarContract.Events.DTSTART)));
                    event.setDtend(cursor.getString(cursor.getColumnIndex(CalendarContract.Events.DTEND)));
                    event.setRrule(cursor.getString(cursor.getColumnIndex(CalendarContract.Events.RRULE)));
                    event.setEvent_timezone(cursor.getString(cursor.getColumnIndex(CalendarContract.Events.EVENT_TIMEZONE)));
                    eventList.add(event);
                }
                todo.setEvents(eventList);
                if (cursor != null) {
                    cursor.close();
                }
                e.onNext(todo);
            }
        }, BackpressureStrategy.ERROR);
    }
}
