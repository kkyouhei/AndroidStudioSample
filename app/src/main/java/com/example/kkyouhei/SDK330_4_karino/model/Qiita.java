package com.example.kkyouhei.SDK330_4_karino.model;

import com.example.kkyouhei.SDK330_4_karino.model.Model;

/**
 * Created by kanokyouhei on 2015/04/14.
 */
public class Qiita extends AppModel {
    String publictimeline = "https://qiita.com/api/v2/items";

    public Qiita(Model asyncCallback) {
        super(asyncCallback);
    }

    public void getPublicTimeline(){
        this.execute(this.publictimeline);
    }
}
