package com.smart.customer_view_03_19;

import android.app.Activity;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import com.smart.customer_view_03_19.bean.AnimationList;
import com.smart.customer_view_03_19.bean.Book;
import com.tickaroo.tikxml.TikXml;
import java.io.File;
import java.io.IOException;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TikXml parser = new TikXml.Builder().build();
        try {
            Source source = Okio.source(getResources().openRawResource(R.raw.test));
            BufferedSource bufferedSource = Okio.buffer(source);
            Book a = parser.read(bufferedSource, Book.class);
            a.getId();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
