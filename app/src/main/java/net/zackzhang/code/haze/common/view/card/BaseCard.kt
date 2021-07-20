package net.zackzhang.code.haze.common.view.card

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import net.zackzhang.code.haze.weather.viewmodel.data.BaseCardData

abstract class BaseCard(parent: ViewGroup, resId: Int, val spanSize: Int) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(resId, parent, false)) {

    protected val context = parent.context!!

    abstract fun updateViews(cardData: BaseCardData)
}