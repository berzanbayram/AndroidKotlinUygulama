package com.example.berzanbayram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [f_action.newInstance] factory method to
 * create an instance of this fragment.
 */
class f_action : Fragment() {
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
        val view: View = inflater!!.inflate(R.layout.fragment_f_action, container, false)

        val actionYazi=view.findViewById<TextView>(R.id.actionYazi)
        val actionButon=view.findViewById<Button>(R.id.actionButon)
        val actionResim=view.findViewById<ImageView>(R.id.actionResim)
        val actionEdit=view.findViewById<EditText>(R.id.actionEdit)


        var dinle = View.OnTouchListener(function = {view, motionEvent ->

            if (motionEvent.action == MotionEvent.ACTION_MOVE) {
                view.y = motionEvent.rawY - view.height/2
                view.x = motionEvent.rawX - view.width/2
            }
            if(motionEvent.action == MotionEvent.ACTION_UP){
                Toast.makeText(view.context,"TextView Yeni Konum", Toast.LENGTH_SHORT).show()
            }
            true

        })
        actionYazi.setOnTouchListener(dinle)
        var dinle2 = View.OnTouchListener(function = {view, motionEvent ->

            if (motionEvent.action == MotionEvent.ACTION_MOVE) {
                view.y = motionEvent.rawY - view.height/2
                view.x = motionEvent.rawX - view.width/2
            }
            if(motionEvent.action == MotionEvent.ACTION_UP){
                Toast.makeText(view.context,"Button Yeni Konum", Toast.LENGTH_SHORT).show()
            }
            true

        })
        actionButon.setOnTouchListener(dinle2)
        var dinle3 = View.OnTouchListener(function = {view, motionEvent ->

            if (motionEvent.action == MotionEvent.ACTION_MOVE) {
                view.y = motionEvent.rawY - view.height/2
                view.x = motionEvent.rawX - view.width/2
            }
            if(motionEvent.action == MotionEvent.ACTION_UP){
                Toast.makeText(view.context,"Logo Yeni Konum", Toast.LENGTH_SHORT).show()
            }
            true

        })
        actionResim.setOnTouchListener(dinle3)
        var dinle4 = View.OnTouchListener(function = {view, motionEvent ->

            if (motionEvent.action == MotionEvent.ACTION_MOVE) {
                view.y = motionEvent.rawY - view.height/2
                view.x = motionEvent.rawX - view.width/2
            }
            if(motionEvent.action == MotionEvent.ACTION_UP){
                Toast.makeText(view.context,"EditText Yeni Konum", Toast.LENGTH_SHORT).show()
            }
            true

        })
        actionEdit.setOnTouchListener(dinle4)

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment f_action.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            f_action().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}