package com.codepath.apps.restclienttemplate.models;

import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

@Parcel
public class Tweet {

    // attributes
    public String body;
    public long uid; // tweet database ID
    public User user;
    public String relativeTimestamp;
    public String createdAt;
    public String handle;

    public Tweet() {}

    // deserialize JSON
    public static Tweet fromJSON(JSONObject jsonObject) throws JSONException {
        Tweet tweet = new Tweet();

        // extract JSON values
        tweet.body = jsonObject.getString("text");
        tweet.uid = jsonObject.getLong("id");
        tweet.createdAt = jsonObject.getString("created_at");
        tweet.relativeTimestamp = " • " + DateUtility.getRelativeTimeAgo(tweet.createdAt);
        tweet.user = User.fromJSON(jsonObject.getJSONObject("user"));
        tweet.handle = " @" + tweet.user.screenName;

        return tweet;
    }
}
