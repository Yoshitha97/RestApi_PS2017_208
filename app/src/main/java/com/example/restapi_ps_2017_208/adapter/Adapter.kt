package com.example.restapi_ps_2017_208.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.restapi_ps_2017_208.R
import com.example.restapi_ps_2017_208.api.Post
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

class Adapter(private val mList: List<Post>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    private val clickSubject = PublishSubject.create<String>()
    val clickEvent : Observable<String> = clickSubject
    inner class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textView1: TextView = itemView.findViewById(R.id.textView1)
        val textView2: TextView = itemView.findViewById(R.id.textView2)
        init {
            itemView.setOnClickListener {
                clickSubject.onNext(textView1.text as String)
            }
        }
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val items = mList[position]

//        // sets the image to the imageview from our itemHolder class
//        holder.imageView.setImageResource(ItemsViewModel.image)
//
//        // sets the text to the textview from our itemHolder class
        holder.textView1.text = items.id.toString()
        holder.textView2.text = items.title


    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text

}
