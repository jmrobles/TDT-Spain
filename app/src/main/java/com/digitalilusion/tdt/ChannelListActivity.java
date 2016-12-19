package com.digitalilusion.tdt;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ChannelListActivity extends ListActivity {
    private static final String TAG = ChannelListActivity.class.getCanonicalName();

    private String[] channelURLs = new String[] {
            "http://rtve-live.hds.adaptive.level3.net/hls-live/rtvegl7-la1lv3aomgl7/_definst_/live.m3u8",
            "http://rtve-live.hds.adaptive.level3.net/hls-live/rtvegl0-la2lv3aomgl0/_definst_/live.m3u8",
            "http://a3live-lh.akamaihd.net/i/antena3_1@35248/master.m3u8",
            "http://a3live-lh.akamaihd.net/i/nxhls/geoneox_1@35261/index_1_av-p.m3u8?sd=10&rebase=on",
            "http://a3live-lh.akamaihd.net/i/geonova_1@379404/index_2_av-b.m3u8",
            "http://a3live-lh.akamaihd.net/i/geomega_1@328914/index_1_av-p.m3u8?sd=10&rebase=on",
            "http://a3live-lh.akamaihd.net/i/a3shds/geoa3series_1@122775/master.m3u8",
            "http://mediasethls-lh.akamaihd.net/i/mitele/cuatro_g@393135/index_350_av-p.m3u8",
            "http://mediasethls-lh.akamaihd.net/i/mitele/telecinco_ng@393132/index_500_av-p.m3u8",
            "http://a3live-lh.akamaihd.net/i/lasexta_1@35272/master.m3u8",
            "http://rtve-live.hds.adaptive.level3.net/hls-live/rtvegl1-tdplv3aomgl1/_definst_/live.m3u8",
            "http://mediasethls-lh.akamaihd.net/i/mitele/bemad_g@320708/index_500_av-p.m3u8?sd=10",
            "http://195.10.10.201/paramount/live-med/stream.m3u8",
            "http://88.148.69.129:9090/play/a01m"
    };
    private String[] channelLabels = new String[] {
            "TVE 1",
            "TVE 2",
            "Antena 3",
            "Neox",
            "Nova",
            "Mega",
            "A3 Series",
            "Cuatro",
            "Telecinco",
            "laSexta",
            "Teledeporte",
            "BeMad",
            "Paramount",
            "Divinity"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_channels);





        //ListView list = (ListView) findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, channelLabels);

        setListAdapter(adapter);


        /*
        videoView = (VideoView) findViewById(R.id.videoView);
        String str = "http://a3live-lh.akamaihd.net/i/antena3_1@35248/master.m3u8";
        MediaController mc = new MediaController(this);
        videoView.setMediaController(mc);
        Uri uri = Uri.parse(str);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        //videoView.start();
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });
        */

    }
    @Override
    protected  void onListItemClick(ListView list, View v, int position,long id) {
        super.onListItemClick(list, v, position, id);
        Log.d(TAG, "Click on: " + position);
        startPlayerActivity(channelLabels[position], channelURLs[position]);
    }

    private void startPlayerActivity(String channelLabel, String channelURL) {
        Intent i = new Intent(this, PlayerActivity.class);
        Bundle extras = new Bundle();
        extras.putString(Constants.LABEL, channelLabel);
        extras.putString(Constants.URL, channelURL);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.putExtras(extras);
        startActivity(i);
    }
}
