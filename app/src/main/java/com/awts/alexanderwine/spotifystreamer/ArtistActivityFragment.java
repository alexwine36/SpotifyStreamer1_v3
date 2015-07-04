package com.awts.alexanderwine.spotifystreamer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import kaaes.spotify.webapi.android.SpotifyApi;
import kaaes.spotify.webapi.android.SpotifyService;
import kaaes.spotify.webapi.android.models.Artist;
import kaaes.spotify.webapi.android.models.ArtistsPager;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


/**
 * A placeholder fragment containing a simple view.
 */
public class ArtistActivityFragment extends Fragment {


    private void performSearch(String query) {
        SpotifyApi api = new SpotifyApi();

        SpotifyService spotify = api.getService();

        spotify.searchArtists(query, new Callback<ArtistsPager>() {
            @Override
            public void success(ArtistsPager artistsPager, Response response) {
                List<Artist> listOfArtists = artistsPager.artists.items;

//                artists = (String[]) listOfArtists.toArray(new String[0]);
//                int counter = 0;
                for (Artist element : listOfArtists) {
//                    if (counter < 10) {
//                        artistArray[counter] = element.name;
//                    }
                    String name = element.name;
                    Log.d("Name", name);
//                    counter++;
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("Artist failure", error.toString());
            }
        });
    }


    public ArtistActivityFragment() {
    }

    public void setSearch(String search){
        performSearch(search);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_artist, container, false);
    }
}
