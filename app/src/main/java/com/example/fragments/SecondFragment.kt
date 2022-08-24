package com.example.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment(R.layout.fragment_second) {

    /*private var result = "result"

  override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       // Use the Kotlin extension in the fragment-ktx artifact
       setFragmentResultListener("requestKey") { requestKey, bundle ->
           // We use a String here, but any type that can be put in a Bundle is supported
           result = bundle.getString("bundleKey")!!
           // Do something with the result
       }
   }*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle: Bundle = this.requireArguments()
        val data = bundle.getString("key")
        view.findViewById<TextView>(R.id.contact).text = data
        //view.findViewById<TextView>(R.id.contact).text = result
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }
}