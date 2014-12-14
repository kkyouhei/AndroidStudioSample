package com.example.kkyouhei.sampleapplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by kkyouhei on 2014/12/14.
 */
public class News extends ArrayList<Map<String, String>> {
    private ArrayList<Map<String, String>> news = new ArrayList<Map<String, String>>();

    public News(){
        String[] title = new String[]{
                "タイトル1",
                "タイトル2",
                "タイトル3",
                "タイトル4",
                "タイトル5",
                "タイトル6",
                "タイトル7",
                "タイトル8",
                "タイトル9",

        };
        String[] content = new String[]{
                "コンテンツ1",
                "コンテンツ2",
                "コンテンツ3",
                "コンテンツ4",
                "コンテンツ5",
                "コンテンツ6",
                "コンテンツ7",
                "コンテンツ8",
                "コンテンツ9",

        };

        for(int i=0; i<title.length; i++){
            Map<String, String> map = new HashMap<String, String>();
            map.put("main", title[i]);
            map.put("sub", content[i]);
            news.add(map);
        }
    }

    public ArrayList getNews(){
        return news;
    }
}
