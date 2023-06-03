package com.example.hoteldlazwierzat

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class CalendarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_calendar, container, false)

        val btnBooking: Button = view.findViewById(R.id.btn_booking)
        btnBooking.setOnClickListener {
            val intent = Intent(activity, BookingActivity::class.java)
            startActivity(intent)
        }

        return view
    }

}