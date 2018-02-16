package smzinho.br.smzinho.fragments;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import smzinho.br.smzinho.R;
import smzinho.br.smzinho.adapter.VideoPostAdapter;
import smzinho.br.smzinho.models.YoutubeDataModel;
;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlayListFragment extends Fragment {

    private static final String GOOGLE_YOUTUBE_API_KEY = "SUA/YOUR API KEY";
    private static final String PLAYLIST_ID = "PLJYxr6AkJOtrApN4G0CQ2yrNL4rfcMmsw";
    private static final String CHANNLE_GET_URL = "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId="+PLAYLIST_ID+"&maxResults=20&key="+GOOGLE_YOUTUBE_API_KEY+"";
    private RecyclerView mList_videos = null;
    private VideoPostAdapter adapter = null;
    private ArrayList<YoutubeDataModel> mListData = new ArrayList<>();

    public PlayListFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_play_list, container, false);
        mList_videos = (RecyclerView) view.findViewById(R.id.mList_videos);
        initList(mListData);
        new RequestYoutubeAPI().execute();
        return view;
    }


    private void initList(ArrayList<YoutubeDataModel> mListData) {
        mList_videos.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new VideoPostAdapter(getActivity(), mListData);
        mList_videos.setAdapter(adapter);

    }


    private class RequestYoutubeAPI extends AsyncTask<Void, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... params) {
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(CHANNLE_GET_URL);
            Log.e("URL", CHANNLE_GET_URL);
            try {
                HttpResponse response = httpClient.execute(httpGet);
                HttpEntity httpEntity = response.getEntity();
                String json = EntityUtils.toString(httpEntity);
                return json;
            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(String response) {
            super.onPostExecute(response);
            if (response != null) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Log.e("response", jsonObject.toString());
                    mListData = parseVideoListFromResponse(jsonObject);
                    initList(mListData);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private ArrayList<YoutubeDataModel> parseVideoListFromResponse(JSONObject jsonObject) {
        ArrayList<YoutubeDataModel> mList = new ArrayList<>();
        if (jsonObject.has("items")) {
            try {
                JSONArray jsonArray = jsonObject.getJSONArray("items");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject json = jsonArray.getJSONObject(i);

                                if (json.has("id")) {
                                    if (json.getString("kind").equals("youtube#playlistItem")) {
                                        JSONObject jsonSnippet = json.getJSONObject("snippet");

                                        String title = jsonSnippet.getString("title");
                                        String id= jsonSnippet.getJSONObject("resourceId").getString("videoId");
                                        String description = jsonSnippet.getString("description");
                                        String publishedAt = jsonSnippet.getString("publishedAt");
                                        String thumbnail = jsonSnippet.getJSONObject("thumbnails").getJSONObject("high").getString("url");

                                        YoutubeDataModel youtube = new YoutubeDataModel();
                                        youtube.setTitle(title);
                                        youtube.setDescription(description);
                                        youtube.setPublishedAt(publishedAt);
                                        youtube.setThumbnail(thumbnail);
                                        youtube.setId(id+"&list="+PLAYLIST_ID+"");

                                        mList.add(youtube);

                                    }
                                }


                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return mList;
    }

}
