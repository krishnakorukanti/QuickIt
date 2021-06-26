package com.masai.quikit.widget

import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import android.widget.RemoteViewsService

class WidegtService : RemoteViewsService() {
    override fun onGetViewFactory(intent: Intent?): RemoteViewsFactory {
        TODO("Not yet implemented")
    }

    abstract class WidegtItemFactory : RemoteViewsFactory{
        abstract val context : Context
        var appWidgetId : Int = 0


        override fun onCreate() {
            TODO("Not yet implemented")
        }

        override fun onDataSetChanged() {
            TODO("Not yet implemented")
        }

        override fun onDestroy() {
            TODO("Not yet implemented")
        }

        override fun getCount(): Int {
            TODO("Not yet implemented")
        }

        override fun getViewAt(position: Int): RemoteViews {
            TODO("Not yet implemented")
        }

        override fun getLoadingView(): RemoteViews {
            TODO("Not yet implemented")
        }

        override fun getViewTypeCount(): Int {
            TODO("Not yet implemented")
        }

        override fun getItemId(position: Int): Long {
            TODO("Not yet implemented")
        }

        override fun hasStableIds(): Boolean {
            TODO("Not yet implemented")
        }

    }
}