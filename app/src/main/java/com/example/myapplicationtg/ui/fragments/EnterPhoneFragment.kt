package com.example.myapplicationtg.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplicationtg.R
import com.example.myapplicationtg.databinding.FragmentEnterPhoneBinding

class EnterPhoneFragment : Fragment(R.layout.fragment_enter_phone) {
    private var _binding: FragmentEnterPhoneBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEnterPhoneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.registerBtnNext.setOnClickListener {
            sendCode()
        }

    }

    private fun sendCode() {
        if (binding.registerInputPhoneNumber.text.toString().isEmpty()) {
            Toast.makeText(activity, "Enter number phone", Toast.LENGTH_LONG).show()
        } else {
            fragmentManager?.beginTransaction()
                ?.addToBackStack(null)
                ?.replace(R.id.registerDataContainer, EnterCodeFragment())
                ?.commit()
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}