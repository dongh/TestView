package com.smart.customer_view_03_19.customerview;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;

import com.smart.customer_view_03_19.R;

public class MyFirstCustomerView extends View implements OnClickListener{
	private Context mContext;
	/** 
     * 文本 
     */  
    private String mText;  
    /** 
     * 文本的颜色 
     */  
    private int mTextColor;  
    /** 
     * 文本的大小 
     */  
    private int mTextSize;  
  
    /** 
     * 绘制时控制文本绘制的范围 
     */  
    private Rect mBound;  
    private Paint mPaint; 
	public MyFirstCustomerView(Context context) {
		this(context,null);
	}
	
	//默认情况下，系统调用的是这个构造函数
	public MyFirstCustomerView(Context context, AttributeSet attrs) {
		this(context,attrs,0);
	}

	public MyFirstCustomerView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		Log.i("Tag", "MyFirstCustomerView():");
		this.mContext = context;
//		//第一种 :此时不需要在 Xml 布局文件中声明自定义控件的属性（此时会从资源文件中读取奇怪的文字）
//		TypedArray _TypedArray = mContext.getTheme().obtainStyledAttributes (R.styleable.MyFirstCustomerView); 
		//第二种:此时不需要在 Xml 布局文件中声明自定义控件的属性
//		TypedArray _TypedArray = mContext.getTheme().obtainStyledAttributes (R.style.MyFirstCustomerViewStyle_1,R.styleable.MyFirstCustomerView); 
		//第三种：
		TypedArray _TypedArray = mContext.getResources().obtainAttributes(attrs,R.styleable.MyFirstCustomerView);
		//第四种：
//		TypedArray _TypedArray = mContext.getTheme().obtainStyledAttributes(null,  R.styleable.MyFirstCustomerView, 0, R.style.MyFirstCustomerViewStyle_3);
		try {
			mText = _TypedArray.getString(R.styleable.MyFirstCustomerView_text);
			mTextColor = _TypedArray.getColor(R.styleable.MyFirstCustomerView_textColor, Color.BLACK); 
			mTextSize = _TypedArray.getDimensionPixelSize(R.styleable.MyFirstCustomerView_textSize, 
					(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics())); 
		} finally {
			_TypedArray.recycle();
		}
		//用第一种方式处理时，会从资源文件里面读到奇怪的文字，所以在这里强转下
//		if(!TextUtils.isEmpty(mText)){
//			mText = "第一种";
//		}
		/** 
         * 获得绘制文本的宽和高 
         */  
        mPaint = new Paint();  
        mPaint.setTextSize(mTextSize);
        mPaint.setTextAlign(Paint.Align.CENTER);
        mBound = new Rect(); 
        Log.i("Tag", "TextLength:" + mText.length());
        mPaint.getTextBounds(mText, 0, mText.length(), mBound); 
        //为控件添加监听事件
        this.setOnClickListener(this);
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		Log.i("Tag", "onMeasure():");
		int _WidthMode = MeasureSpec.getMode(widthMeasureSpec);
		int _WidthSpec = MeasureSpec.getSize(widthMeasureSpec);
		int _HeightMode = MeasureSpec.getMode(heightMeasureSpec);
		int _HeightSpec = MeasureSpec.getSize(heightMeasureSpec);
		int _Width;
		int _Height;
		//宽度
		if(_WidthMode == MeasureSpec.EXACTLY){
			_Width = _WidthSpec;
		}else{
			mPaint.setTextSize(mTextSize);  
			mPaint.getTextBounds(mText, 0, mText.length(), mBound);  
	        float _TextWidth = mBound.width();  
	        _Width = (int) (getPaddingLeft() + _TextWidth + getPaddingRight());  
		}
		//高度
		if(_HeightMode == MeasureSpec.EXACTLY){
			_Height = _HeightSpec;
		}else{
			mPaint.setTextSize(mTextSize);  
			mPaint.getTextBounds(mText, 0, mText.length(), mBound);  
	        float _TextHeight = mBound.height();  
	        _Height = (int) (getPaddingTop() + _TextHeight + getPaddingBottom());  
		}
		
		setMeasuredDimension(_Width, _Height);  
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		Log.i("Tag", "onDraw():");
		mPaint.setColor(Color.YELLOW);  
		Log.i("Tag", "getMeasuredWidth():" + getMeasuredWidth() + "   " + getMeasuredHeight());
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint); 
        
        mPaint.setColor(mTextColor);
        Log.i("Tag", "getWidth():" + getWidth() + "   " + getHeight());
        Log.i("Tag", "mBound.width():" + mBound.width() + "   " + mBound.height());
        canvas.drawText(mText, getWidth() / 2, getHeight() / 2 + mBound.height() / 2, mPaint);  
	}

	@Override
	public void onClick(View v) {
		mText = randomText(); 
		//内容长度改变之后，重新测量
//		requestLayout();
//		invalidate();
        postInvalidate();
	}
	
	private String randomText()  
    {  
        Random random = new Random();  
        Set<Integer> set = new HashSet<Integer>();  
        while (set.size() < 4)  
        {  
            int randomInt = random.nextInt(10);  
            set.add(randomInt);  
        }  
        StringBuffer sb = new StringBuffer();  
        for (Integer i : set)  
        {  
            sb.append("" + i);  
        }  
  
        return sb.toString();  
    } 
}
