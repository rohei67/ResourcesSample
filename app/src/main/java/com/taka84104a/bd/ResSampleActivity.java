package com.taka84104a.bd;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;

public class ResSampleActivity extends Activity {

	private MediaPlayer mp;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		mp = MediaPlayer.create(this, R.raw.sample);
	}

	public void buttonClick(View v) {
		if (mp.isPlaying()) {
			mp.pause();
			mp.seekTo(0);
		}
		mp.start();
		// バイブレーターを使う場合はマニフェストのパーミッション記述を忘れずに！
		Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
		vibrator.vibrate(15);
	}

	@Override
	protected void onPause() {
		super.onPause();
		if (mp.isPlaying()) {
			mp.pause();
			mp.seekTo(0);
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mp.release();
	}
}