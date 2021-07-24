package com.codepath.apps.restclienttemplate.models;

import com.codepath.apps.restclienttemplate.TimeFormatter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Tweet {

    public String body;
    public String createdAT;
    public User user;
    public String getFormattedTimeStamp;

    public static Tweet fromJson(JSONObject jsonObject) throws JSONException {
        Tweet tweet = new Tweet();
        tweet.body = jsonObject.getString("text");
        tweet.createdAT = jsonObject.getString("created_at");
        tweet.user = User.fromJson(jsonObject.getJSONObject("user"));
        tweet.getFormattedTimeStamp = getTimeDifference(tweet.createdAT);
        return tweet;
    }

    private static String getTimeDifference(String createdAT) {
        return TimeFormatter.getTimeDifference(createdAT);
    }

    public static List<Tweet> fromJsonArray(JSONArray jsonArray) throws JSONException {
        List<Tweet> tweets = new ArrayList<>();
        for(int i = 0; i < jsonArray.length(); i++){
           tweets.add(fromJson(jsonArray.getJSONObject(i)));
        }

        return tweets;
    }
}