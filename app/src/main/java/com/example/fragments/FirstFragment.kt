package com.example.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class FirstFragment : Fragment(R.layout.fragment_first) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val contact1: TextView = view.findViewById(R.id.contact1)
        val contact2: TextView = view.findViewById(R.id.contact2)
        val contact3: TextView = view.findViewById(R.id.contact3)
        val contact4: TextView = view.findViewById(R.id.contact4)
        val contact5: TextView = view.findViewById(R.id.contact5)

        parentFragmentManager.setFragmentResultListener(
            "dataFrom2", this
        ) { requestKey, result ->
            val data = result.getString("df2")
            val dataId = result.getInt("df2Id")
            when (dataId) {
                contact1.id -> contact1.text = data
                contact2.id -> contact2.text = data
                contact3.id -> contact3.text = data
                contact4.id -> contact4.text = data
                contact5.id -> contact5.text = data
            }
        }

        contact1.setOnClickListener { sendData(contact1) }
        contact2.setOnClickListener { sendData(contact2) }
        contact3.setOnClickListener { sendData(contact3) }
        contact4.setOnClickListener { sendData(contact4) }
        contact5.setOnClickListener { sendData(contact5) }
    }

    private fun sendData(view: TextView) {
        val bundle = Bundle()
        bundle.putString("df1", view.text.toString())
        bundle.putInt("textId", view.id)
        parentFragmentManager.setFragmentResult("dataFrom1", bundle)

        val secondFragment = SecondFragment()
        secondFragment.arguments = bundle
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.first_fragment, secondFragment, "secondFragment")
            .addToBackStack(null)
            .commit()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }
}