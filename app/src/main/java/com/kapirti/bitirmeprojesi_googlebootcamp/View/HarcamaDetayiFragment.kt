package com.kapirti.bitirmeprojesi_googlebootcamp.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kapirti.bitirmeprojesi_googlebootcamp.R
import kotlinx.android.synthetic.main.fragment_harcama_detayi.*

class HarcamaDetayiFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_harcama_detayi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val id= HarcamaDetayiFragmentArgs.fromBundle(it).id
            textView11.text=id.toString()
        }

    }
}