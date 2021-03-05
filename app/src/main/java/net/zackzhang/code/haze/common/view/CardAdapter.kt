package net.zackzhang.code.haze.common.view

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import net.zackzhang.code.haze.common.view.card.BaseCard
import net.zackzhang.code.haze.common.view.card.EmptyCard
import net.zackzhang.code.haze.weather.viewmodel.data.BaseCardData

class CardAdapter(private val creator: (type: Int, parent: ViewGroup) -> BaseCard?)
    : RecyclerView.Adapter<BaseCard>() {

    private val cardDataList = mutableListOf<BaseCardData>()

    private val spanSizeMap = hashMapOf<Int, Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        (creator(viewType, parent) ?: EmptyCard(parent)).apply {
            spanSizeMap[viewType] = spanSize
        }

    override fun onBindViewHolder(holder: BaseCard, position: Int) {
        holder.updateViews(cardDataList[position])
    }

    override fun getItemCount() = cardDataList.size

    override fun getItemViewType(position: Int) = cardDataList[position].type

    fun setCardData(cardData: List<BaseCardData>) {
        cardDataList.clear()
        cardDataList.addAll(cardData)
        notifyDataSetChanged()
    }

    fun getSpanSize(position: Int) = spanSizeMap[getItemViewType(position)]
}