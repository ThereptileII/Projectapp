package com.renovateglass.app.widgets

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews
import com.renovateglass.app.R

class TasksWidgetProvider : AppWidgetProvider() {
    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        appWidgetIds.forEach { appWidgetId ->
            val views = RemoteViews(context.packageName, R.layout.widget_tasks).apply {
                setTextViewText(R.id.widget_task_one, "• Install penny tiles")
                setTextViewText(R.id.widget_task_two, "• Mount floating vanity")
                setTextViewText(R.id.widget_task_three, "• Sign plumbing permit")
            }
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }
}
