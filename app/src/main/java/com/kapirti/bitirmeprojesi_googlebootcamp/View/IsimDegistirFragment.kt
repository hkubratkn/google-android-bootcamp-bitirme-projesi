package com.kapirti.bitirmeprojesi_googlebootcamp.View

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.kapirti.bitirmeprojesi_googlebootcamp.R
import com.kapirti.bitirmeprojesi_googlebootcamp.databinding.FragmentIsimDegistirBinding

class IsimDegistirFragment : Fragment() {
    private lateinit var binding:FragmentIsimDegistirBinding
    private lateinit var frondName:String
    lateinit var sharedPreferences:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentIsimDegistirBinding.inflate(LayoutInflater.from(requireContext()), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        sharedPreferences=this.requireContext().getSharedPreferences("com.kapirti.bitirmeprojesi_googlebootcamp",
            Context.MODE_PRIVATE)

        binding.radioGroupCinsiyet.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId== R.id.radioButtonKadin){
                sharedPreferences.edit().putString("Hitap","Hanım").apply()
            }
            if (checkedId== R.id.radioButtonErkek){
                sharedPreferences.edit().putString("Hitap","Bey").apply()
            }
            if (checkedId== R.id.radioButtonCinsiyetYok){
                sharedPreferences.edit().putString("Hitap","").apply()
            }
        }
        binding.buttonKaydet.setOnClickListener { view->
            val name=binding.editTextisimDegisitir.text.toString()
            if (name==null){
                Toast.makeText(activity,"İsim yazınız lütfen!",Toast.LENGTH_LONG).show()
            }else{
                sharedPreferences.edit().putString("UsersName",name).apply()
                val action=
                        IsimDegistirFragmentDirections.actionİsimDegistirFragmentToMainFragment()
                Navigation.findNavController(view).navigate(action)
            }
        }

    }
}