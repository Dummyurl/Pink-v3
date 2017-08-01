package com.anglll.pink.ui.main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.anglll.pink.R;
import com.anglll.pink.RxBus;
import com.anglll.pink.base.BaseActivity;
import com.anglll.pink.base.BaseModel;
import com.anglll.pink.data.model.WeatherInfo;
import com.anglll.pink.data.retrofit.RetrofitAPI;
import com.anglll.pink.event.WeatherEvent;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends BaseActivity {
    @BindView(R.id.textView)
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
