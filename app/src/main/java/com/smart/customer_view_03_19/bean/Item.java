package com.smart.customer_view_03_19.bean;

import com.tickaroo.tikxml.annotation.Attribute;
import com.tickaroo.tikxml.annotation.Xml;

/**
 * Created by modonghong on 2017-01-18.
 */
@Xml
public class Item {
  @Attribute(name="android:drawable") String drawable;
  @Attribute(name="android:duration") int duration;

  public String getDrawable() {
    return drawable;
  }

  public void setDrawable(String drawable) {
    this.drawable = drawable;
  }

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }
}
