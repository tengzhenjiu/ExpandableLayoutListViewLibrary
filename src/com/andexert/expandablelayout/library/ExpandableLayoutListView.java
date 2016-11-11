/***********************************************************************************
 * The MIT License (MIT)

 * Copyright (c) 2014 Robin Chutaux

 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:

 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 ***********************************************************************************/
package com.andexert.expandablelayout.library;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import java.lang.reflect.Method;

/**
 * Author :    Chutaux Robin
 * Date :      9/17/2014
 */
public class ExpandableLayoutListView extends ListView
{
    private Integer position = -1;
    public ExpandableLayoutListView(Context context)
    {
        super(context);

    }

    public ExpandableLayoutListView(Context context, AttributeSet attrs)
    {
        super(context, attrs);

    }

    public ExpandableLayoutListView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);

    }

    @Override
    public boolean performItemClick(View view, int position, long id)
    {
        this.position = position;

        ExpandableLayoutItem expandableLayout = (ExpandableLayoutItem) getChildAt(position - getFirstVisiblePosition()).findViewWithTag(ExpandableLayoutItem.class.getName());

        if (expandableLayout.isOpened())
            expandableLayout.hide();
        else
            expandableLayout.show();


        return super.performItemClick(view, position, id);
    }

}
