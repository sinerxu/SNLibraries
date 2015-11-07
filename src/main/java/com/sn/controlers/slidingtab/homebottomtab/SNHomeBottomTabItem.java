package com.sn.controlers.slidingtab.homebottomtab;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;


import com.sn.controlers.slidingtab.SNSlidingTabItem;
import com.sn.lib.R;
import com.sn.util.SNUtility;

/**
 * @style style="?attr/theme_home_bottomtabitem_style"    需要添加的的样式
 * @attr android:text           标题
 * @attr android:src            图片
 * @attr android:textColor      标题颜色
 * @attr selected_src           选中后的图片
 * @attr selected_textColor     选中后的标题颜色
 */
public class SNHomeBottomTabItem extends SNSlidingTabItem {
    String text;
    Drawable src;
    int textColor;
    Drawable selectedSrc;




    public int getSelectedColor() {
        return selectedColor;
    }

    public void setSelectedColor(int selectedColor) {
        this.selectedColor = selectedColor;
    }

    public Drawable getSelectedSrc() {
        return selectedSrc;
    }

    public void setSelectedSrc(Drawable selectedSrc) {
        this.selectedSrc = selectedSrc;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        if (textColor != selectedColor)
            this.textColor = textColor;

        $this.id(R.id.text).textColor(textColor);
    }

    public Drawable getSrc() {
        return src;
    }

    public void setSrc(Drawable src) {
        if (src != selectedSrc)
            this.src = src;
        $this.id(R.id.image).image(src);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        $this.id(R.id.text).text(text);
    }

    int selectedColor;

    public SNHomeBottomTabItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        $this = $.layoutInflateResId(R.layout.controler_home_bottomtabitem, (ViewGroup) $this.toView());
        TypedArray array = $.loadStyle(attrs, R.styleable.SNHomeBottomTabItem);
        text = array.getString(R.styleable.SNHomeBottomTabItem_android_text);
        src = array.getDrawable(R.styleable.SNHomeBottomTabItem_android_src);
        textColor = array.getColor(R.styleable.SNHomeBottomTabItem_android_textColor, 0xFF000000);
        selectedSrc = array.getDrawable(R.styleable.SNHomeBottomTabItem_selected_src);
        selectedColor = array.getColor(R.styleable.SNHomeBottomTabItem_selected_color, 0xFF555555);

        array.recycle();
//        if (SNUtility.isNullOrEmpty(fragmentName))
//            new IllegalStateException("The fragment name is require.");
        if (!$.util.strIsNullOrEmpty(text))
            setText(text);
        if (src != null)
            setSrc(src);
        setTextColor(textColor);
    }
}
