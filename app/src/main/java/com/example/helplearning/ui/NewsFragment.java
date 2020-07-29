package com.example.helplearning.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.helplearning.ActivityNews;
import com.example.helplearning.Adapter.AdapterNews;
import com.example.helplearning.MainActivity;
import com.example.helplearning.Model.Item;
import com.example.helplearning.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class NewsFragment extends Fragment {
    ArrayList<Item> items;
    AdapterNews adapterNews;
    ListView lvListNews;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        lvListNews = view.findViewById(R.id.lvListNews);
        items = new ArrayList<>();
        initRss("https://vietnamnet.vn/rss/giao-duc.rss");

        return view;
    }

    private void initRss(final String s) {
        @SuppressLint("StaticFieldLeak") AsyncTask asyncTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                Log.e("d", s);
                try {
                    URL url = new URL(s);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    XmlPullParserFactory xmlPullParserFactory = XmlPullParserFactory.newInstance();
                    xmlPullParserFactory.setNamespaceAware(false);

                    XmlPullParser xmlPullParser = xmlPullParserFactory.newPullParser();
                    xmlPullParser.setInput(inputStream, "utf-8");
                    int eventType = xmlPullParser.getEventType();
                    Item item = null;
                    String text = "";
                    while (eventType != xmlPullParser.END_DOCUMENT) {
                        String tag = xmlPullParser.getName();
                        switch (eventType) {
                            case XmlPullParser.START_TAG:
                                if (tag.equalsIgnoreCase("item")) {
                                    item = new Item();
                                }
                                break;
                            case XmlPullParser.TEXT:
                                text = xmlPullParser.getText();
                                break;
                            case XmlPullParser.END_TAG:
                                if (item != null) {
                                    if (tag.equalsIgnoreCase("title")) {
                                        item.setTitle(text);
                                    } else if (tag.equalsIgnoreCase("description")) {
                                        item.setDescription(text);
                                    } else if (tag.equalsIgnoreCase("link")) {
                                        item.setLink(text);
                                    } else if (tag.equalsIgnoreCase("content:encoded")) {
                                        item.setContent(text);
                                    } else if (tag.equalsIgnoreCase("pubDate")) {
                                        item.setDate(text);
                                    } else if (tag.equalsIgnoreCase("item")) {
                                        items.add(item);
                                    }
                                }
                                break;

                        }
                        eventType = xmlPullParser.next();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Object o) {
                super.onPostExecute(o);
                adapterNews = new AdapterNews(items);
                lvListNews.setAdapter(adapterNews);
                lvListNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(getContext(), ActivityNews.class);
                        intent.putExtra("link", items.get(i).getLink());
                        startActivity(intent);
                    }
                });
            }
        };
        asyncTask.execute();
    }
}