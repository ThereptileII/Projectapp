package com.renovateglass.app.widgets

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews
import com.renovateglass.app.R

class ProgressWidgetProvider : AppWidgetProvider() {
    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        appWidgetIds.forEach { appWidgetId ->
            val views = RemoteViews(context.packageName, R.layout.widget_progress).apply {
                setTextViewText(R.id.widget_progress_project, "Kitchen Remodel")
                setTextViewText(R.id.widget_progress_value, "68%")
            }
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }
}
