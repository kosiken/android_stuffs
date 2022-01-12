package com.kosy.multipleactivities

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kosy.multipleactivities.databinding.FragmentSignInBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SignInFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignInFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private lateinit var  binding: FragmentSignInBinding
    private val email = "allisonkosy@gmail.com"
    private val password = "0000"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSignInBinding.inflate(inflater)
        val me = this

        binding.signInButton.setOnClickListener { v ->
            Log.v("kosy", "Clicked" )
            binding.signInButton.visibility = View.GONE
            binding.loadingView.visibility = View.VISIBLE
            val timer = object: CountDownTimer(5000, 1000) {
                override fun onTick(millisUntilFinished: Long) {

                }

                override fun onFinish() {
                    me.signIn()
                }
            }
            timer.start()
        }



        return binding.root
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SignInFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SignInFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }

    }

    fun signIn() {
        Log.v("kosy", "Clicked" )
        if(binding.textInputEditEmail.text.toString() == email && binding.textInputEditPassword.text.toString() == password) {
            val intent  = Intent(context, SettingsActivity::class.java)
            startActivity(intent)
        }
        binding.signInButton.visibility = View.VISIBLE
        binding.loadingView.visibility = View.GONE

    }
}