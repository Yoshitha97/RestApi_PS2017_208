package com.example.restapi_ps_2017_208.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.restapi_ps_2017_208.R
import com.example.restapi_ps_2017_208.api.Comment

class Adapter2(private val mList: List<Comment>) : RecyclerView.Adapter<Adapter2.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design2, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemc = mList[position]


        // sets the text to the textview from our itemHolder class
        holder.textView3.text = itemc.id.toString()
        holder.textView1.text = itemc.name
        holder.textView4.text = itemc.email
        holder.textView2.text = itemc.body



    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textView1: TextView = itemView.findViewById(R.id.textViewa)
        val textView2: TextView = itemView.findViewById(R.id.textViewb)
        val textView3: TextView = itemView.findViewById(R.id.textViewc)
        val textView4: TextView = itemView.findViewById(R.id.textViewd)
    }
}
