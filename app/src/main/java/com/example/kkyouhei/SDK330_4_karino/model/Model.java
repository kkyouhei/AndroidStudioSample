package com.example.kkyouhei.SDK330_4_karino.model;

/**
 * Created by kanokyouhei on 2015/04/14.
 */
public interface Model{
    void onPreExecute();
    void onPostExecute(String result);
    void onProgressUpdate(int progress);
    void onCancelled();
}