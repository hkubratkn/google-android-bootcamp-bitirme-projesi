package com.kapirti.bitirmeprojesi_googlebootcamp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.kapirti.bitirmeprojesi_googlebootcamp.Adapter.RecyclerRowAdapter
import com.kapirti.bitirmeprojesi_googlebootcamp.Database.SaveData
import com.kapirti.bitirmeprojesi_googlebootcamp.Database.VeriTabani
import com.kapirti.bitirmeprojesi_googlebootcamp.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding:FragmentMainBinding
    lateinit var sharedPreferences: SharedPreferences
    private lateinit var viewModel : BesinListesiViewModel
    private val recyclerBesinAdapter = BesinRecyclerAdapter(arrayListOf())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentMainBinding.inflate(LayoutInflater.from(requireContext()), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences=this.requireContext().getSharedPreferences("com.kapirti.bitirmeprojesi_googlebootcamp",Context.MODE_PRIVATE)
        val name=sharedPreferences.getString("UsersName","")
        val hitap=sharedPreferences.getString("Hitap","isminiz")
        if (name!=null){
            binding.textViewisimDegisimi.text="${name} ${hitap}"
        }

        binding.linearLayoutTopMain.setOnClickListener { view->
            val action= MainFragmentDirections.actionMainFragmentToİsimDegistirFragment()
            Navigation.findNavController(view).navigate(action)
        }
        binding.buttonHarcaEkle.setOnClickListener { view->
            val action= MainFragmentDirections.actionMainFragmentToHarcamaEkleFragment()
            Navigation.findNavController(view).navigate(action)
        }

        val notes:List<SaveData>
        val db:VeriTabani= Room.databaseBuilder(requireContext(),VeriTabani::class.java,"notes")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        notes=db.veritabaniErisimNesnesi().getAllData()
        binding.recyclerView.layoutManager=LinearLayoutManager(requireContext())
        binding.recyclerView.adapter=RecyclerRowAdapter(notes,requireContext())

        binding.buttonHarcaEkle.setOnClickListener {view->
            val action=MainFragmentDirections.actionMainFragmentToHarcamaEkleFragment()
            Navigation.findNavController(view).navigate(action)
        }
    }


}