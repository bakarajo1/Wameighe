package com.example.myapplication

import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.SingleLayBinding
import com.example.myapplication.ui.main.Content
import com.squareup.picasso.Picasso


class TodoAdapter: RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(val binding: SingleLayBinding):RecyclerView.ViewHolder(binding.root)

    private val diffCallback= object :DiffUtil.ItemCallback<Content>() {
        override fun areItemsTheSame(oldItem: Content, newItem: Content): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Content, newItem: Content): Boolean {
            return oldItem == newItem
        }

    }

        private val differ= AsyncListDiffer(this,diffCallback)


        var todos: List<Content>
            get() = differ.currentList
            set(value) {differ.submitList(value)}











    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(SingleLayBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.binding.apply {
            val todo = todos[position]
           // var tempImage:ImageView=imageView
            textView.text="dsdsd"

            //imageView.setImageResource()
            textView.text=todo.descriptionKA
            textView2.text=todo.titleKA
            textView4.text=todo.cover
            textView5.text=todo.publishDate

           // imageView.setImageResource(R.drawable.ic_android__2_)
           // imageView.chaawode(todo.cover.toString())
            Picasso.get().load(todo.cover.toString()).into(imageView);

        }


//            descriptionKA
//            titleKA
//            cover
//            publish_date


        }


    override fun getItemCount(): Int {
        return todos.size
    }


}

private fun ImageView.chaawode(string:String) {

    Picasso.get().load(string).into(this);


   // this.setImageResource("$string")

}





