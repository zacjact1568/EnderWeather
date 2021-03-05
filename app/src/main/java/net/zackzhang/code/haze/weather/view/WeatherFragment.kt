package net.zackzhang.code.haze.weather.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import net.zackzhang.code.haze.common.Constants
import net.zackzhang.code.haze.common.view.CardAdapter
import net.zackzhang.code.haze.databinding.FragmentWeather1Binding
import net.zackzhang.code.haze.weather.view.card.HeadCard
import net.zackzhang.code.haze.weather.viewmodel.WeatherViewModel

class WeatherFragment : Fragment() {

    private lateinit var binding: FragmentWeather1Binding

    private val adapter = CardAdapter { type, parent ->
        when (type) {
            Constants.CARD_TYPE_WEATHER_HEAD -> HeadCard(parent)
            // Other cards
            else -> null
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWeather1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val viewModel by viewModels<WeatherViewModel>()
        binding.vCardList.let {
            (it.layoutManager as? GridLayoutManager)?.run {
                spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                    override fun getSpanSize(position: Int) = adapter.getSpanSize(position) ?: spanCount
                }
            }
            it.adapter = adapter
        }
        viewModel.weatherLiveData.observe(viewLifecycleOwner) {
            if (view is SwipeRefreshLayout) {
                view.isRefreshing = false
            }
            adapter.setCardData(it)
        }
        if (view is SwipeRefreshLayout) {
            view.setOnRefreshListener {
                viewModel.getNow("101010100")
            }
        }
    }
}