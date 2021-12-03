package com.hmj.shinhanbank.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hmj.shinhanbank.R
import com.hmj.shinhanbank.network.dto.Response.HoldAccount

class RecyclerViewMainAdapter: RecyclerView.Adapter<RecyclerViewMainAdapter.ViewHolder>() {

    private val data = mutableListOf<HoldAccount>()
    private lateinit var mListener: OnItemClickListener

    interface OnItemClickListener {
        fun onClick(id: Int)
    }

    fun setOnItemClickListener(listener: (Int) -> Unit) {
        mListener = object : OnItemClickListener {
            override fun onClick(id: Int) {
                listener(id)
            }
        }
    }

    fun setData(data: List<HoldAccount>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }



    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val accountName = view.findViewById<TextView>(R.id.item_account_name)

        fun bind(data: HoldAccount) {
            accountName.text = data.account
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_account, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size
}