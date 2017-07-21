package com.yuan.lock;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.yuan.lock.base.BaseActivity;
import com.yuan.lock.data.model.WeatherInfo;
import com.yuan.lock.data.retrofit.RetrofitAPI;
import com.yuan.lock.event.WeatherEvent;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.observers.SubscriberCompletableObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.Subject;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        RetrofitAPI.getInstance().getRemoteService()
                .getWeatherInfo("101010100")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<WeatherInfo>() {
                    @Override
                    public void accept(@NonNull WeatherInfo weatherInfo) throws Exception {
                        RxBus.get().post(new WeatherEvent(weatherInfo));
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        Toast.makeText(MainActivity.this,"异常", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    protected Disposable subscribeEvents() {
        return RxBus.get()
                .toObservable(WeatherEvent.class)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<WeatherEvent>() {
                    @Override
                    public void accept(@NonNull WeatherEvent event) throws Exception {
                        StringBuilder sb = new StringBuilder();
                        WeatherInfo weatherInfo = event.getWeatherInfo();
                        if (weatherInfo == null) {
                            sb.append("weather info is null!");
                        } else {
                            sb.append(weatherInfo.getC().getC1() + "_");
                            sb.append(weatherInfo.getC().getC2() + "_");
                            sb.append(weatherInfo.getC().getC3() + "_");
                            sb.append(weatherInfo.getC().getC4() + "_");
                            sb.append(weatherInfo.getC().getC5() + "_");
                            sb.append(weatherInfo.getC().getC6() + "_");
                            sb.append(weatherInfo.getC().getC7() + "_");
                            sb.append(weatherInfo.getC().getC8() + "_");
                            sb.append(weatherInfo.getC().getC9() + "_");
                            sb.append(weatherInfo.getC().getC10() + "_");
                            sb.append(weatherInfo.getC().getC11() + "_");
                        }
                        Toast.makeText(MainActivity.this, sb.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
