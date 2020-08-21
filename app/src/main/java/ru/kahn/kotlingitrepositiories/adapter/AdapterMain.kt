package ru.kahn.kotlingitrepositiories.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_repo_main.view.*
import ru.kahn.kotlingitrepositiories.other.CircularTransform
import ru.kahn.kotlingitrepositiories.interfaces.MainContract
import ru.kahn.kotlingitrepositiories.model.ModelAutorRepo
import ru.kahn.kotlingitrepositiories.R

class AdapterMain(var arrayListRepo: MutableList<ModelAutorRepo>, var click: MainContract.ClickListenerItem) : RecyclerView.Adapter<AdapterMain.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.item_repo_main, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return arrayListRepo.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model: ModelAutorRepo = arrayListRepo[position]

        Picasso.with(holder.itemView.context)
            .load(model.avatar)
            .transform(CircularTransform(50))
            .fit()
            .into(holder.itemView.iv_photo)
        holder.itemView.tv_author_name.setText(model.author)
        holder.itemView.tv_repo_name.setText(model.name)
        holder.itemView.tv_description.setText(model.description)
        holder.itemView.setOnClickListener {
            click.onClick(model.url)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}