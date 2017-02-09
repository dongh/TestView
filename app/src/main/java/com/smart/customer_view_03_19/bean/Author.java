package com.smart.customer_view_03_19.bean;

import com.tickaroo.tikxml.annotation.Attribute;
import com.tickaroo.tikxml.annotation.Element;
import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

/**
 * Created by modonghong on 2017-01-18.
 */
@Xml public class Author {

  @PropertyElement String firstname;

  @PropertyElement String lastname;
}


