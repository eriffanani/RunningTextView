package com.erif.library;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class RunningTextView extends AppCompatTextView {

    private Scroller scroller;
    private long duration = 10000L;
    private int pausedX = 0;
    private boolean paused = true;
    private boolean autoplay = false;

    public RunningTextView(Context context) {
        this(context, null);
        init(context, null, 0);
    }

    public RunningTextView(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.textViewStyle);
        init(context, attrs, 0);
    }

    public RunningTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        Resources.Theme theme = context.getTheme();
        if (theme != null) {
            TypedArray typedArray = theme.obtainStyledAttributes(
                    attrs, R.styleable.RunningTextView, defStyleAttr, 0
            );
            try {
                duration = typedArray.getInteger(R.styleable.RunningTextView_scrollDuration, 10000);
                autoplay = typedArray.getBoolean(R.styleable.RunningTextView_scrollAutoPlay, false);
            } finally {
                typedArray.recycle();
            }
        }
        setSingleLine();
        setMaxLines(1);
        setEllipsize(null);
        setVisibility(INVISIBLE);
        post(() -> {
            String mText = getText().toString();
            if (autoplay &&  mText != null) {
                start();
            }
        });
    }

    /**
     * begin to scroll the text from the original position
     */
    public void start() {
        // begin from the very right side
        pausedX = -1 * getWidth();
        // assume it's paused
        paused = true;
        resume();
    }

    /**
     * resume the scroll from the pausing point
     */
    public void resume() {
        if (!paused)
            return;
        // Do not know why it would not scroll sometimes
        // if setHorizontallyScrolling is called in constructor.
        setHorizontallyScrolling(true);

        // use LinearInterpolator for steady scrolling
        scroller = new Scroller(getContext(), new LinearInterpolator());
        setScroller(scroller);

        int scrollingLen = calculateScrollingLen();
        int distance = scrollingLen - (getWidth() + pausedX);
        double getDuration = duration * distance * 1.00000 / scrollingLen;
        int duration = (int) getDuration;

        setVisibility(VISIBLE);
        scroller.startScroll(pausedX, 0, distance, 0, duration);
        invalidate();
        paused = false;
    }

    /**
     * calculate the scrolling length of the text in pixel
     *
     * @return the scrolling length in pixels
     */
    private int calculateScrollingLen() {
        TextPaint tp = getPaint();
        Rect rect = new Rect();
        String strTxt = getText().toString();
        tp.getTextBounds(strTxt, 0, strTxt.length(), rect);
        int scrollingLen = rect.width() + getWidth();
        rect = null;
        return scrollingLen;
    }

    /**
     * pause scrolling the text
     */
    public void pause() {
        if (null == scroller)
            return;

        if (paused)
            return;

        paused = true;

        // abortAnimation sets the current X to be the final X,
        // and sets isFinished to be true
        // so current position shall be saved
        pausedX = scroller.getCurrX();

        scroller.abortAnimation();
    }

    /**
     * override the computeScroll to restart scrolling when finished so as that
     * the text is scrolled forever
     */
    @Override
    public void computeScroll() {
        super.computeScroll();

        if (null == scroller) return;

        if (scroller.isFinished() && (!paused)) {
            start();
        }
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long millis) { this.duration = millis; }

    public void setDuration(double seconds) {
        double mSeconds = seconds * 1000L;
        this.duration = (long) mSeconds;
    }

    public void setDuration(int minutes) {
        double mMinutes = minutes * 60000L;
        this.duration = (long) mMinutes;
    }

    public boolean isPaused() {
        return paused;
    }
}
