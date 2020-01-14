package com.ajijul.ny.news_feed.adapter.viewHolder

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ajijul.ny.AppUtils.Companion.convertDate
import com.ajijul.ny.BR
import com.ajijul.ny.databinding.NewsFeedListRowBinding
import com.ajijul.ny.news_feed.model.Result
import com.ajijul.ny.news_feed.viewModel.NewsFeedsViewModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.news_feed_list_row.view.*

class NewsFeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var content: LinearLayout? = itemView.content
    //    var newsFeedRow_imvImage: ImageView? = itemView.newsFeedRow_imvImage
//    var newsFeedRow_tvSource: TextView? = itemView.newsFeedRow_tvSource
//    var newsFeedRow_tvNewinShort: TextView? = itemView.newsFeedRow_tvNewinShort
//    var newsFeedRow_tvNewsWrittenBy: TextView? = itemView.newsFeedRow_tvNewsWrittenBy
//    var newsFeedRow_tvDate: TextView? = itemView.newsFeedRow_tvDate
    var mContext: Context? = null
    var dataModel: Result? = null
    var viewModel: NewsFeedsViewModel? = null
     var binding: NewsFeedListRowBinding?=null

    init {
        mContext = itemView.context
    }

    @SuppressLint("SetTextI18n", "CheckResult")
    fun setData(
        model: NewsFeedsViewModel,
        result: Result?,
        position: Int
    ) {
        this.dataModel = result
        this.viewModel = model
//        Glide.with(mContext!!).load(result?.media?.get(0)?.mediaMetadata?.get(2)?.url)
//            .into(newsFeedRow_imvImage!!)
//        newsFeedRow_tvSource?.text = result?.source
//        newsFeedRow_tvNewinShort?.text = result?.title
//        newsFeedRow_tvNewsWrittenBy?.text = result?.byline
//        newsFeedRow_tvDate?.text = convertDate("yyyy-MM-dd","dd MMM, yyyy",result?.publishedDate)
        //itemView.setOnClickListener { v -> listener?.onItemClick(result!!) }

    }

    fun bind() {
        if (binding == null) {
            binding = DataBindingUtil.bind(itemView)
        }
        binding?.setVariable(BR.viewModel, viewModel)
        binding?.setVariable(BR.position, position)
        binding?.setVariable(BR.dataModel, dataModel)
        binding?.executePendingBindings()

    }

    fun unbind() {

        if (binding != null)
            binding?.unbind()
    }


}