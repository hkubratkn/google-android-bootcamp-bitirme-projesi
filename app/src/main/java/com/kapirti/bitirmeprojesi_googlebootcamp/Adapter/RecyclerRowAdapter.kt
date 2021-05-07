package com.kapirti.bitirmeprojesi_googlebootcamp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.kapirti.bitirmeprojesi_googlebootcamp.Database.SaveData
import com.kapirti.bitirmeprojesi_googlebootcamp.MainFragmentDirections
import com.kapirti.bitirmeprojesi_googlebootcamp.R
import kotlinx.android.synthetic.main.recycler_row.view.*

class RecyclerRowAdapter (private val notes : List<SaveData>, val context: Context) : RecyclerView.Adapter<RecyclerRowAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_row, p0, false))
    }

    override fun getItemCount(): Int=notes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.yazisi?.setText(notes[position].yazisi)
        holder.fiyat?.setText((notes[position]).fiyati)
        if (notes.get(position).resmi==2){
            holder.resImageView.setImageResource(R.drawable.ic_baseline_home_24)
        }
        if (notes.get(position).resmi==1){
            holder.resImageView.setImageResource(R.drawable.ic_baseline_library_books_24)
        }
        if (notes.get(position).resmi==3){
            holder.resImageView.setImageResource(R.drawable.ic_baseline_add_chart_24)
        }

        if (notes.get(position).paraTuru==7){
            holder.pataBirimi?.text="$"
        }
        if (notes.get(position).paraTuru==6){
            holder.pataBirimi?.text="₺"
        }
        if (notes.get(position).paraTuru==8){
            holder.pataBirimi?.text="€"
        }
        if (notes.get(position).paraTuru==9){
            holder.pataBirimi?.text="£"
        }

        val id=notes.get(position).dataId
        holder.itemView.setOnClickListener {view->
            val action=MainFragmentDirections.actionMainFragmentToHarcamaDetayiFragment(id)
            Navigation.findNavController(view).navigate(action)
        }
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val yazisi = view.recycler_row_yazisi
        val resImageView=view.recycler_row_image
        val fiyat=view.recycler_row_fiyati
        val pataBirimi=view.recycler_row_parabirimi
    }

}