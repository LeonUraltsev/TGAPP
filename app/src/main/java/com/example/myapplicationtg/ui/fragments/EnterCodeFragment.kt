package com.example.myapplicationtg.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.myapplicationtg.R
import com.example.myapplicationtg.databinding.FragmentEnterCodeBinding

class EnterCodeFragment : Fragment(R.layout.fragment_enter_code) {

    private var _binding : FragmentEnterCodeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEnterCodeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.registerInputCode.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                TODO("Not yet implemented")
            }

            override fun afterTextChanged(s: Editable?) {
                val string = binding.registerInputCode.text.toString()
                if(string.length == 6){
                    verificationCode()
                }
            }

        })
    }

    private fun verificationCode() {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}