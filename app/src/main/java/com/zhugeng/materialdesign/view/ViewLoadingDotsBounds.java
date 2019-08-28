package com.zhugeng.materialdesign.view;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.zhugeng.materialdesign.R;

import static android.animation.ValueAnimator.REVERSE;
import static android.graphics.drawable.GradientDrawable.OVAL;

public class ViewLoadingDotsBounds extends LinearLayout {

    boolean a;
    private Context b;
    private ImageView[] c;
    private GradientDrawable d;
    private ObjectAnimator[] e;

    public ViewLoadingDotsBounds(Context context) {
        super(context);
        this.d = new GradientDrawable();
        this.a = false;
    }

    public ViewLoadingDotsBounds(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.d = new GradientDrawable();
        this.a = false;
        this.b = context;
        setOrientation(0);
        setGravity(17);
        setLayoutParams(new LayoutParams(-1, -1));
        a();
    }

    public ViewLoadingDotsBounds(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.d = new GradientDrawable();
        this.a = false;
    }


    private void a() {
        Drawable background = getBackground();
        int color = background instanceof ColorDrawable ? ((ColorDrawable) background).getColor() : -7829368;
        int i = 0;
        setBackgroundColor(0);
        removeAllViews();
        this.c = new ImageView[3];
        this.d.setShape(1);
        this.d.setColor(color);
        this.d.setSize(80, 80);
        LinearLayout.LayoutParams layoutParams = new LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        LinearLayout[] linearLayoutArr = new LinearLayout[3];
        while (i < 3) {
            linearLayoutArr[i] = new LinearLayout(this.b);
            linearLayoutArr[i].setGravity(17);
            linearLayoutArr[i].setLayoutParams(layoutParams);
            this.c[i] = new ImageView(this.b);
            this.c[i].setBackgroundDrawable(this.d);
            linearLayoutArr[i].addView(this.c[i]);
            addView(linearLayoutArr[i]);
            i++;
        }
    }

    private void b() {
        this.e = new ObjectAnimator[3];
        for (int i = 0; i < 3; i++) {
            this.c[i].setTranslationY((float) (getHeight() / 6));
            ImageView imageView = this.c[i];
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(ImageView.TRANSLATION_Y, new float[]{(float) ((-getHeight()) / 6)});
            ImageView imageView2 = this.c[i];
            PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat(ImageView.TRANSLATION_X, new float[]{0.0f});
            this.e[i] = ObjectAnimator.ofPropertyValuesHolder(this.c[i], new PropertyValuesHolder[]{ofFloat2, ofFloat});
            this.e[i].setRepeatCount(-1);
            this.e[i].setRepeatMode(2);
            this.e[i].setDuration(500);
            this.e[i].setStartDelay((long) (i * 166));
            this.e[i].start();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        for (int i = 0; i < 3; i++) {
            if (this.e[i].isRunning()) {
                this.e[i].removeAllListeners();
                this.e[i].end();
                this.e[i].cancel();
            }
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.a) {
            this.a = true;
            ViewGroup.LayoutParams layoutParams = new LayoutParams(getWidth() / 5, getWidth() / 5);
            for (i = 0; i < 3; i++) {
                this.c[i].setLayoutParams(layoutParams);
            }
            b();
        }
    }

}
