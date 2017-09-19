package com.anglll.pink.player;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.NotificationCompat;
import android.widget.RemoteViews;

import com.anglll.pink.R;
import com.anglll.pink.data.model.Song;
import com.anglll.pink.data.model.SongList;
import com.anglll.pink.ui.main.MainActivity;

/**
 * Created by yuan on 2017/9/16 0016.
 */

public class PlaybackService extends Service implements IPlayback.Callback, IPlayback, AudioManager.OnAudioFocusChangeListener {
    private static final int NOTIFICATION_ID = 10;
    private Player player;
    private boolean hasFocus;
    private NoisyReceiver noisyReceiver;
    private boolean registed;
    private AudioManager audioManager;
    private IntentFilter noisyFilter;
    private PlayerBinder builder = new PlayerBinder();
    private RemoteViews mContentViewSmall;
    private RemoteViews mContentViewBig;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return builder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        player = Player.getInstance();
        player.addCallback(this);
        noisyReceiver = new NoisyReceiver();
        noisyFilter = new IntentFilter();
        noisyFilter.addAction(AudioManager.ACTION_AUDIO_BECOMING_NOISY);
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
    }

    @Override
    public boolean play() {
        requestAudioFocus();
        return player.play();
    }

    @Override
    public boolean play(SongList songList) {
        requestAudioFocus();
        return player.play(songList);
    }

    @Override
    public boolean play(int index) {
        requestAudioFocus();
        return player.play(index);
    }

    @Override
    public boolean playLast() {
        requestAudioFocus();
        return player.playLast();
    }

    @Override
    public boolean playNext() {
        requestAudioFocus();
        return player.playNext();
    }

    @Override
    public boolean pause() {
        releaseAudioFocus();
        return player.pause();
    }

    @Override
    public boolean isPlaying() {
        return player.isPlaying();
    }

    @Override
    public int getProgress() {
        return player.getProgress();
    }

    @Override
    public Song getPlayingSong() {
        return player.getPlayingSong();
    }

    @Override
    public boolean seekTo(int progress) {
        return player.seekTo(progress);
    }

    @Override
    public PlayMode getPlayMode() {
        return player.getPlayMode();
    }

    @Override
    public void setPlayMode(PlayMode playMode) {
        player.setPlayMode(playMode);
    }

    @Override
    public void releasePlayer() {
        releaseAudioFocus();
        player.releasePlayer();
    }

    @Override
    public void addCallback(Callback callback) {
        player.addCallback(callback);
    }

    @Override
    public void removeCallback(Callback callback) {
        player.removeCallback(callback);
    }

    @Override
    public void onSwitchLast(@Nullable Song last) {
        showNotification();
    }

    @Override
    public void onSwitchNext(@Nullable Song next) {
        showNotification();
    }

    @Override
    public void onPlayComplete() {
        showNotification();
    }

    @Override
    public void onPlayStatusChanged(boolean isPlaying) {
        showNotification();
        if (isPlaying && !registed) {
            registerReceiver(noisyReceiver, noisyFilter);
        }
        if (!isPlaying && registed) {
            unregisterReceiver(noisyReceiver);
        }
    }

    @Override
    public void onProgressChanged(int progress, int total) {

    }

    @Override
    public void onAudioFocusChange(int focusChange) {
        switch (focusChange) {
            case AudioManager.AUDIOFOCUS_GAIN://获取焦点并长期占有
                hasFocus = true;
                player.setVolume(1.0f, 1.0f);
                play();
                break;
            case AudioManager.AUDIOFOCUS_LOSS://长久失去焦点
                hasFocus = false;
                releasePlayer();
                break;
            case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT://暂时失去焦点
                hasFocus = false;
                pause();
                break;
            case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK://暂时获取焦点
                player.setVolume(.5f, .5f);
                break;
        }
    }

    private void requestAudioFocus() {
        if (!hasFocus)
            audioManager.requestAudioFocus(this, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);
    }

    private void releaseAudioFocus() {
        if (hasFocus)
            audioManager.abandonAudioFocus(this);
    }

    private void showNotification() {
        PendingIntent contentIntent
                = PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), 0);
        Notification notification = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setWhen(System.currentTimeMillis())
                .setContentIntent(contentIntent)
                .setCustomContentView(getSmallContentView())
                .setCustomBigContentView(getBigContentView())
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setOngoing(true)
                .build();
        startForeground(NOTIFICATION_ID, notification);
    }

    private RemoteViews getSmallContentView() {
        if (mContentViewSmall == null) {
            mContentViewSmall = new RemoteViews(getPackageName(), R.layout.remote_song_small);
            setUpRemoteView(mContentViewSmall, false);
        }
        updateRemoteViews(mContentViewSmall);
        return mContentViewSmall;
    }

    private RemoteViews getBigContentView() {
        if (mContentViewBig == null) {
            mContentViewBig = new RemoteViews(getPackageName(), R.layout.remote_song_big);
            setUpRemoteView(mContentViewSmall, true);
        }
        updateRemoteViews(mContentViewBig);
        return mContentViewBig;
    }


    private void setUpRemoteView(RemoteViews remoteView, boolean big) {

    }

    private void updateRemoteViews(RemoteViews remoteView) {

    }

    @Override
    public void onDestroy() {
        stopForeground(true);
        releasePlayer();
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String action = intent.getAction();
        return super.onStartCommand(intent, flags, startId);
    }

    public class PlayerBinder extends Binder {
        public PlaybackService getService() {
            return PlaybackService.this;
        }
    }

    class NoisyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (AudioManager.ACTION_AUDIO_BECOMING_NOISY.equals(intent.getAction()))
                pause();
        }
    }
}
