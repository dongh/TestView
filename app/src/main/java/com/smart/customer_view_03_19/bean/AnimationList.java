package com.smart.customer_view_03_19.bean;

import com.tickaroo.tikxml.annotation.Attribute;
import com.tickaroo.tikxml.annotation.Element;
import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;
import java.util.List;

/**
 * Created by modonghong on 2017-01-18.
 */

@Xml(writeNamespaces={"android=\"http://schemas.android.com/apk/res/android\""})
public class AnimationList {
  @Attribute(name="android:oneshot") boolean oneshot;
  //@PropertyElement
  //List<Item> items;

  public boolean isOneshot() {
    return oneshot;
  }

  public void setOneshot(boolean oneshot) {
    this.oneshot = oneshot;
  }
  //
  //public List<Item> getItems() {
  //  return items;
  //}
  //
  //public void setItems(List<Item> items) {
  //  this.items = items;
  //}
}
