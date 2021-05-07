package com.kapirti.bitirmeprojesi_googlebootcamp.View

import android.content.Context
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.kapirti.bitirmeprojesi_googlebootcamp.R

class SplashFragment : Fragment() {
    var count=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var sharedPreferences=this.requireContext().getSharedPreferences("com.kapirti.bitirmeprojesi_googlebootcamp",
            Context.MODE_PRIVATE)
        if (count==0) {
            count = sharedPreferences.getInt("number", 0)
            count++
            sharedPreferences.edit().putInt("number",count).apply()
        }else{
            val action= SplashFragmentDirections.actionSplashFragmentToMainFragment()
            findNavController().navigate(action)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler().postDelayed({
            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToOnBoardingFragment())
        },3000)
    }

}