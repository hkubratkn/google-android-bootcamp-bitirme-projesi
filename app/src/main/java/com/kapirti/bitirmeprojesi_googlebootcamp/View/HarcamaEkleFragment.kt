package com.kapirti.bitirmeprojesi_googlebootcamp.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.room.Room
import com.kapirti.bitirmeprojesi_googlebootcamp.Database.SaveData
import com.kapirti.bitirmeprojesi_googlebootcamp.Database.VeriTabani
import com.kapirti.bitirmeprojesi_googlebootcamp.R
import kotlinx.android.synthetic.main.fragment_harcama_ekle.*

class HarcamaEkleFragment : Fragment() {
    var paraTuru:Int = 0
    var resmi:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_harcama_ekle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db: VeriTabani = Room.databaseBuilder(requireContext(), VeriTabani::class.java, "notes")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()

        radioGroupKategori.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId== R.id.radioButtonFatura){
                resmi=1
            }
            if (checkedId== R.id.radioButtonKira){
                resmi=2
            }
            if (checkedId== R.id.radioButtonDiger){
                resmi=3
            }
        }
        radioGroupCins.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId== R.id.radioButtonTl){
                paraTuru=6
            }
            if (checkedId== R.id.radioButtonDolar){
                paraTuru=7
            }
            if (checkedId== R.id.radioButtonSterlin){
                paraTuru=9
            }
            if (checkedId== R.id.radioButtonEuro){
                paraTuru=8
            }
        }
        buttonHarcamaEkle.setOnClickListener {view->
            val note: SaveData = SaveData(editTextYazisi.text.toString(),editTextNumber.text.toString(),paraTuru,resmi)
            db.veritabaniErisimNesnesi().insertAll(note)
            val action= HarcamaEkleFragmentDirections.actionHarcamaEkleFragmentToMainFragment()
            Navigation.findNavController(view).navigate(action)
        }
    }
}