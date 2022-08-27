package com.example.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment


class SecondFragment : Fragment(R.layout.fragment_second) {

    private var textId: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var editText = view.findViewById<EditText>(R.id.contact)
        parentFragmentManager.setFragmentResultListener("dataFrom1", this
        ) { requestKey, result ->
            val data = result.getString("df1")
            textId = result.getInt("textId")
            editText.setText(data)
        }

        val saveButton = view.findViewById<Button>(R.id.save_button)
        saveButton.setOnClickListener {
            editText = view.findViewById(R.id.contact)
            val bundle = Bundle()
            bundle.putString("df2",editText.text.toString())
            bundle.putInt("df2Id",textId)
            parentFragmentManager.setFragmentResult("dataFrom2", bundle)

            parentFragmentManager.popBackStack()

            /*val firstFragment = FirstFragment()
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.first_fragment, firstFragment, "secondFragment")
                .commit()*/
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }
}