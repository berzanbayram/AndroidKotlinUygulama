package com.example.berzanbayram

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [f_colors.newInstance] factory method to
 * create an instance of this fragment.
 */
class f_colors : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater!!.inflate(R.layout.fragment_f_colors, container, false)

        val yazi = view.findViewById<TextView>(R.id.name)
        val fragment = view.findViewById<FrameLayout>(R.id.sayfa)

        var menu  = view.findViewById<Spinner>(R.id.yazi_color)
        var menu1 = view.findViewById<Spinner>(R.id.back_color)
        var menu2 = view.findViewById<Spinner>(R.id.f_renk)

        var colors = arrayOf(
            "Renk Seçiniz",
            "Beyaz",
            "EFLATUN",
            "Ruj Kırmızısı",
            "Zinnwaldite",
            "Altunî"
        )
        val adapter = ArrayAdapter(view.context, android.R.layout.simple_dropdown_item_1line, colors)


        menu.adapter = adapter
        menu1.adapter = adapter
        menu2.adapter = adapter

        menu.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (position) {
                    1 -> yazi.setTextColor(Color.parseColor("#FFFFFF"));
                    2 -> yazi.setTextColor(Color.parseColor("#e0218a"));
                    3 -> yazi.setTextColor(Color.parseColor("#842317"));
                    4 -> yazi.setTextColor(Color.parseColor("#EBC2AF"));
                    5 -> yazi.setTextColor(Color.parseColor("#FFD700"));
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        menu1.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (position) {
                    1 -> yazi.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    2 -> yazi.setBackgroundColor(Color.parseColor("#e0218a"));
                    3 -> yazi.setBackgroundColor(Color.parseColor("#842317"));
                    4 -> yazi.setBackgroundColor(Color.parseColor("#EBC2AF"));
                    5 -> yazi.setBackgroundColor(Color.parseColor("#FFD700"));
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        menu2.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (position) {
                    1 -> fragment.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    2 -> fragment.setBackgroundColor(Color.parseColor("#e0218a"));
                    3 -> fragment.setBackgroundColor(Color.parseColor("#842317"));
                    4 -> fragment.setBackgroundColor(Color.parseColor("#EBC2AF"));
                    5 -> fragment.setBackgroundColor(Color.parseColor("#FFD700"));
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment f_colors.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            f_colors().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}