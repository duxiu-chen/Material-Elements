package com.zhugeng.materialdesign.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.zhugeng.materialdesign.R;

public class ViewLoadingDotsFade extends LinearLayout {

    boolean a;
    private Context b;
    private ImageView[] c;
    private GradientDrawable d;
    private ObjectAnimator[] e;

    public ViewLoadingDotsFade(Context context) {
        super(context);
        this.d = new GradientDrawable();
        this.a = false;
    }

    public ViewLoadingDotsFade(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new GradientDrawable();
        this.a = false;
        this.b = context;
        setOrientation(0);
        setGravity(17);
        setLayoutParams(new LayoutParams(-1, -1));
        a();
    }

    public ViewLoadingDotsFade(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new GradientDrawable();
        this.a = false;
    }

    private void a() {
        Drawable background = getBackground();
        int color = background instanceof ColorDrawable ? ((ColorDrawable) background).getColor() : R.color.dan_lv;
        int i = 0;
        setBackgroundColor(0);
        removeAllViews();
        this.c = new ImageView[3];
        this.d.setShape(1);
        this.d.setColor(color);
        this.d.setSize(200, 200);
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

    private void a(boolean z) {
        this.e = new ObjectAnimator[3];
        for (int i = 0; i < 3; i++) {
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("alpha", new float[]{0.2f});
            PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("alpha", new float[]{1.0f});
            if (!z) {
                ofFloat = ofFloat2;
            }
            this.e[i] = ObjectAnimator.ofPropertyValuesHolder(this.c[i], new PropertyValuesHolder[]{ofFloat});
            this.e[i].setRepeatCount(0);
            this.e[i].setRepeatMode(2);
            this.e[i].setDuration(400);
            this.e[i].setStartDelay((long) (i * 400));
            this.e[i].start();
        }
        this.e[2].addListener(new AnonymousClass1(this, z));
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
            LinearLayout.LayoutParams layoutParams = new LayoutParams(getWidth() / 5, getWidth() / 5);
            for (i2 = 0; i2 < 3; i2++) {
                this.c[i2].setLayoutParams(layoutParams);
            }
            a(true);
        }
    }

    /* renamed from: com.material.components.widget.ViewLoadingDotsFade.1 */
    class AnonymousClass1 extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;
        final /* synthetic */ ViewLoadingDotsFade b;

        AnonymousClass1(ViewLoadingDotsFade viewLoadingDotsFade, boolean z) {
            this.b = viewLoadingDotsFade;
            this.a = z;
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            this.b.a(this.a ^ true);
        }
    }


}
