package kpk.dev.presentation.contentlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*
import kpk.dev.model.poko.Item
import kpk.dev.presentation.R

class ContentListAdapter(val listener: (Int) -> Unit) :
    RecyclerView.Adapter<ContentListAdapter.ContentListViewHolder>() {

    private var data: MutableList<Item> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentListViewHolder =
        ContentListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false))

    override fun onBindViewHolder(holder: ContentListViewHolder, position: Int) {
        holder.bind(data[position], listener)
    }

    override fun getItemCount(): Int = data.size

    fun updateData(newData: List<Item>?) {
        if (data.size > 0) {
            data.clear()
        }
        if (newData != null) {
            data.addAll(newData)
        }

        notifyDataSetChanged()
    }

    inner class ContentListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Item, listener: (Int) -> Unit) = with(itemView) {
            val titleSegments = item.title.split(" ")
            val title = StringBuilder()
            for (segment in titleSegments) {
                title.append(segment[0])
            }
            this.tv_article_deco.text = title.toString()
            this.tv_title.text = item.title
            this.tv_subtitle.text = item.subtitle
            this.tv_date.text = item.date
            this.setOnClickListener { listener(item.id) }
        }
    }
}