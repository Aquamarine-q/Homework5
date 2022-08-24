package com.example.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment(R.layout.fragment_first) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
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

        contact1.setOnClickListener {
            sendData(contact1)
            // result = contact.text.toString()
            // Use the Kotlin extension in the fragment-ktx artifact
            //setFragmentResult("requestKey", bundleOf("bundleKey" to result))
        }

        contact2.setOnClickListener{
            sendData(contact2)
        }

        contact3.setOnClickListener{
            sendData(contact3)
        }

        contact4.setOnClickListener{
            sendData(contact4)
        }

        contact5.setOnClickListener{
            sendData(contact5)
        }

        /*contact.setOnClickListener {
            val secondFragment = SecondFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(((view as ViewGroup).parent as View).id, secondFragment, "secondFragment")
                .addToBackStack(null)
                .commit()
        }*/
    }

    private fun sendData(view: TextView){
        val bundle = Bundle()
        bundle.putString("key", view.text.toString())
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