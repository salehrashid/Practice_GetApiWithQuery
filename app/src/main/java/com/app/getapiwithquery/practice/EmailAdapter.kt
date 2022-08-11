package com.app.getapiwithquery.practice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.getapiwithquery.databinding.RowEmailItemBinding
import com.app.getapiwithquery.practice.network.ApiFakeItem

class EmailAdapter : RecyclerView.Adapter<EmailAdapter.UserViewHolder>() {

    private val listEmail = ArrayList<ApiFakeItem>()

    inner class UserViewHolder(val itemEmailBinding: RowEmailItemBinding) :
        RecyclerView.ViewHolder(itemEmailBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserViewHolder(
        RowEmailItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.itemEmailBinding.apply {
            with(listEmail[position]) {
                tvEmail.text = email
            }
        }
    }

    override fun getItemCount() = listEmail.size

    fun setEmail(email: ArrayList<ApiFakeItem>) {
        this.listEmail.clear()
        this.listEmail.addAll(email)
    }
}