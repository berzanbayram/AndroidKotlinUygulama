package com.example.berzanbayram

import android.os.Bundle
import android.view.Gravity
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
 * Use the [f_toast.newInstance] factory method to
 * create an instance of this fragment.
 */
class f_toast : Fragment() {
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
        // Inflate the layout for this fragment
        val view: View = inflater!!.inflate(R.layout.fragment_f_toast, container, false)

        var radio = view.findViewById<RadioButton>(R.id.radio)
        var radio1 = view.findViewById<RadioButton>(R.id.radio1)
        var radio2 = view.findViewById<RadioButton>(R.id.radio2)
        var radio3 = view.findViewById<RadioButton>(R.id.radio3)

        var butonCreate = view.findViewById<Button>(R.id.butonCreate)
        var name = view.findViewById<EditText>(R.id.name)

        butonCreate.setOnClickListener {
            val toast = layoutInflater.inflate(R.layout.toast, null)
            val TostOzel = Toast(view.context)
            TostOzel.view = toast
            var toaslogo = toast.findViewById<ImageView>(R.id.toaslogo)
            var toastmetin = toast.findViewById<TextView>(R.id.toastmetin)


            if(radio.isChecked){
                toaslogo.setImageResource(R.drawable.logo);
            }
            if(radio1.isChecked){
                toaslogo.setImageResource(R.drawable.l0go);
            }
            if(radio2.isChecked){
                toaslogo.setImageResource(R.drawable.log0);
            }
            if(radio3.isChecked){
                toaslogo.setImageResource(R.drawable.logobb);
            }
            toastmetin.text = "${name.text} tarafından oluşturulmuş Toast mesajı"
            TostOzel.duration = Toast.LENGTH_SHORT
            TostOzel.setGravity(Gravity.CENTER_HORIZONTAL or Gravity.CENTER_VERTICAL, 0, 0)
            TostOzel.show()

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
         * @return A new instance of fragment f_toast.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            f_toast().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}