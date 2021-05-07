package com.kapirti.bitirmeprojesi_googlebootcamp.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.kapirti.bitirmeprojesi_googlebootcamp.databinding.FragmentOnBoardingTwoBinding

class OnBoardingTwoFragment : Fragment() {
    private lateinit var binding:FragmentOnBoardingTwoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentOnBoardingTwoBinding.inflate(LayoutInflater.from(requireContext()), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonTwoGec.setOnClickListener { view->
            val action=
                    OnBoardingTwoFragmentDirections.actionOnBoardingTwoFragmentToOnBoasrdingThreeFragment()
            Navigation.findNavController(view).navigate(action)
        }
    }
}