package com.example.easyguide.screens

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.easyguide.R
import com.example.easyguide.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {
    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        binding.txtSplashTitle.text = getText(R.string.splashTitle)
        context?.let {
            Glide.with(it).asGif().load(R.drawable.book_outline).into(binding.imgSplash)
        }
        Handler(Looper.getMainLooper()).postDelayed(
            {
                val navOptions: NavOptions.Builder = NavOptions.Builder()
                navOptions.setEnterAnim(androidx.navigation.ui.R.anim.nav_default_enter_anim)

                findNavController().navigate(
                    R.id.action_splashFragment_to_loginFragment,
                    null,
                    navOptions.build()
                )
            },
            3500
        )
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}