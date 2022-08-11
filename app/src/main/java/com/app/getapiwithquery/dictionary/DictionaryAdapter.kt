package com.app.getapiwithquery.dictionary

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.getapiwithquery.databinding.RowDictionaryItemBinding
import com.app.getapiwithquery.dictionary.data.DictionaryResponseItem

class DictionaryAdapter : RecyclerView.Adapter<DictionaryAdapter.DictionaryViewHolder>() {

    private val listDictionary = ArrayList<DictionaryResponseItem>()

    inner class DictionaryViewHolder(val itemDictionaryBinding: RowDictionaryItemBinding) :
        RecyclerView.ViewHolder(itemDictionaryBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DictionaryViewHolder(
        RowDictionaryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: DictionaryViewHolder, position: Int) {
        holder.itemDictionaryBinding.apply {
            tvDefinition.text =
                listDictionary[0].meanings?.get(0)?.definitions?.get(position)?.definition
        }
    }

    override fun getItemCount() = listDictionary[0].meanings?.get(0)?.definitions!!.size

    fun setDictionary(dict: ArrayList<DictionaryResponseItem>) {
        this.listDictionary.clear()
        this.listDictionary.addAll(dict)
    }
}