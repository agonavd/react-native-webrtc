package com.oney.WebRTCModule;

import android.util.Log;

import com.iristick.smartglass.core.Headset;
import com.iristick.smartglass.support.app.IristickApp;

import org.webrtc.VideoCapturer;

public class IristickCaptureController extends AbstractVideoCaptureController {

    private static final String TAG = "IristickCaptureController";

    public IristickCaptureController(int width, int height, int fps) {
        super(width, height, fps);
    }

    @Override
    protected VideoCapturer createVideoCapturer() {
        Headset headset = IristickApp.getHeadset();
        Log.i(TAG, "Creating VideoCapturer with headset " + headset);
        if (headset != null) {
            return new IristickCapturer(headset, null, 0);
        } else {
            throw new RuntimeException("TODO: started without headset connected");
        }
    }
}
