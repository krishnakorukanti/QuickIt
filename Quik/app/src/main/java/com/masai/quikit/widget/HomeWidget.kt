package com.masai.quikit.widget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import com.masai.quikit.R
import com.masai.quikit.adapter.DetailsAdapter
import com.masai.quikit.room.Details
import com.masai.quikit.ui.home.HomeViewModel

/**
 * Implementation of App Widget functionality.
 */
class HomeWidget : AppWidgetProvider(), ViewModelStoreOwner {
    private lateinit var homeViewModel: HomeViewModel
    private var detailsList = emptyList<Details>()
    private lateinit var detailsAdapter: DetailsAdapter
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
//        homeViewModel =
            //ViewModelProvider(context).get(HomeViewModel::class.java)
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    override fun getViewModelStore(): ViewModelStore {
        TODO("Not yet implemented")
    }


}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    val widgetText = context.getString(R.string.appwidget_text)
    // Construct the RemoteViews object
    val views = RemoteViews(context.packageName, R.layout.home_widget)
    //views.setTextViewText(R.id.appwidget_text, widgetText)

    // Instruct the widget manager to update the widget
    appWidgetManager.updateAppWidget(appWidgetId, views)
}