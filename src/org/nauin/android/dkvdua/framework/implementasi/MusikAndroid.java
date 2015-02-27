/*
 * MusikAndroid.java
 * 
 * Copyright (C) 2011 Mario Zechner http://badlogicgames.com/forum/viewforum.php?f=21
 * Copyright (C) 2011 Robert Green http://www.rbgrn.net/contact
 * Copyright (C) 2014 Adnanto A.R. a.k.a NauiN <adnantoa@gmail.com>
 *
 */

package org.nauin.android.dkvdua.framework.implementasi;

import java.io.IOException;

import org.nauin.android.dkvdua.framework.Musik;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;

/**
 * 
 * @author nauin
 *
 */
public class MusikAndroid implements Musik, OnCompletionListener,
		OnSeekCompleteListener, OnPreparedListener, OnVideoSizeChangedListener {
	MediaPlayer mediaPlayer;
	boolean isSiap = false;

	public MusikAndroid(AssetFileDescriptor afd) {
		mediaPlayer = new MediaPlayer();
		try {
			mediaPlayer.setDataSource(afd.getFileDescriptor(),
					afd.getStartOffset(), afd.getLength());
			mediaPlayer.prepare();
			isSiap = true;
			mediaPlayer.setOnCompletionListener(this);
			mediaPlayer.setOnSeekCompleteListener(this);
			mediaPlayer.setOnPreparedListener(this);
			mediaPlayer.setOnVideoSizeChangedListener(this);
		} catch (Exception e) {
			throw new RuntimeException("Tidak dapat memuat musik");
		}
	}

	@Override
	public void onCompletion(MediaPlayer mp) {
		synchronized (this) {
			isSiap = false;
		}
	}

	public void tutup() {
		if (this.mediaPlayer.isPlaying()) {
			this.mediaPlayer.stop();
		}

		this.mediaPlayer.release();
	}

	public boolean isUlang() {
		return mediaPlayer.isLooping();
	}

	public boolean isPutar() {
		return this.mediaPlayer.isPlaying();
	}

	public boolean isBerhenti() {
		return !isSiap;
	}

	public void selaan() {
		if (this.mediaPlayer.isPlaying())
			mediaPlayer.pause();
	}

	public void putar() {
		if (this.mediaPlayer.isPlaying())
			return;
		try {
			synchronized (this) {
				if (!isSiap)
					mediaPlayer.prepare();
				mediaPlayer.start();
			}
		} catch (IllegalStateException ise) {
			ise.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public void setUlang(boolean isUlang) {
		mediaPlayer.setLooping(isUlang);
	}

	public void setVolume(float volume) {
		mediaPlayer.setVolume(volume, volume);
	}

	public void berhenti() {
		if (this.mediaPlayer.isPlaying() == true) {
			this.mediaPlayer.stop();
			synchronized (this) {
				isSiap = false;
			}
		}
	}

	@Override
	public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPrepared(MediaPlayer mp) {
		// TODO Auto-generated method stub
		synchronized (this) {
			isSiap = true;
		}

	}

	@Override
	public void onSeekComplete(MediaPlayer mp) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mulaiMencoba() {
		// TODO Auto-generated method stub
		mediaPlayer.seekTo(0);
	}

}
