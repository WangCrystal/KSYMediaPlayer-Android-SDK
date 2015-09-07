package com.ksy.media.demo;

import java.io.File;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import com.ksy.media.player.util.Constants;
import com.ksy.media.widget.MediaPlayerView;

public class VideoPlayerActivity extends Activity implements
		MediaPlayerView.PlayerViewCallback {

	MediaPlayerView playerView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// 设置全屏
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_player);
		playerView = (MediaPlayerView) findViewById(R.id.player_view);
		final View dialogView = LayoutInflater.from(this).inflate(
				R.layout.dialog_input, null);
		final EditText editInput = (EditText) dialogView
				.findViewById(R.id.input);
		startPlayer("");
		
		/*new AlertDialog.Builder(this).setTitle("User Input")
				.setView(dialogView)
				.setPositiveButton("Confirm", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						String inputString = editInput.getText().toString();
						if (!TextUtils.isEmpty(inputString)) {
							startPlayer(inputString);
						} else {
							Toast.makeText(VideoPlayerActivity.this,
									"Paht or URL can not be null",
									Toast.LENGTH_LONG).show();
						}

					}
				}).setNegativeButton("Cancel", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				}).show();*/

	}

	@Override
	protected void onResume() {

		super.onResume();
		playerView.onResume();
	}

	@Override
	protected void onPause() {

		super.onPause();
		playerView.onPause();
	}

	@Override
	protected void onDestroy() {

		Log.d(Constants.LOG_TAG, "VideoPlayerActivity ....onDestroy()......");
		super.onDestroy();

		playerView.onDestroy();
	}

	private void startPlayer(String url) {

		Log.d(Constants.LOG_TAG, "input url = " + url);

		playerView.setPlayerViewCallback(this);
//		 String path = "rtmp://192.168.135.185:1935/myLive/guoyankai";
		 String path = "http://devimages.apple.com/iphone/samples/bipbop/gear1/prog_index.m3u8"; // vod		
//		 String path = "http://maichang.kssws.ks-cdn.com/upload20150716161913.mp4";
//		String path = "http://ceshi.kssws.ks-cdn.com/bb.mp4";

//		File file = new File(Environment.getExternalStorageDirectory(),
//				"Love.mp4");
//		String path = file.getAbsolutePath();
		
		// Love.mp4 
		// avitest.avi
		// flvtest.flv
		// mkvtest.mkv
		// rmvbtest.rmvb
		// tstest.ts
		// wmvtest.wmv

		playerView.play(path);
		// Log.d("eflake", file.getAbsolutePath());
		// playerView.play("http://maichang.kssws.ks-cdn.com/upload20150716161913.mp4");
	}

	@Override
	public void hideViews() {

	}

	@Override
	public void restoreViews() {

	}

	@Override
	public void onPrepared() {

	}

	@Override
	public void onQualityChanged() {

	}

	@Override
	public void onFinish(int playMode) {

		Log.i(Constants.LOG_TAG, "activity on finish ===========");
		// this.onBackPressed();
		this.finish();
	}

	@Override
	public void onError(int errorCode, String errorMsg) {

		// TODO Auto-generated method stub

	}

	/**
	 * 返回键退出
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {

//			playerView.onDestroy();
			finish();
			Log.i(Constants.LOG_TAG, "onKeyDown ===========");
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
	
}


