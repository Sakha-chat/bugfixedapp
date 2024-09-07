package com.morpankh.sakha

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FirebaseMessaging.getInstance().subscribeToTopic("all_devices")
        FirebaseMessaging.getInstance().token
            .addOnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.w(TAG, "Fetching FCM registration token failed", task.exception)
                    return@addOnCompleteListener
                }

                // Get new FCM registration token
                val token = task.result

                // Log the FCM token
                val msg = "Your FCM token is: $token"
                Log.d(TAG, msg)
            }

//        FirebaseMessaging.getInstance().token
//            .addOnCompleteListener (
//                OnCompleteListener{
//                    task: Task<String> ->
//                    if (!task.isSuccessful) {
//                        Log.w(TAG, "Fetching FCM registration token failed", task.exception)
//                        return@OnCompleteListener
//                    }
//
//                    // Get new FCM registration token
//                    val token = task.result
//
//                    // Log the FCM token
//                    val msg = "Your FCM token is: $token"
//                    Log.d(TAG, msg)
//                })

        //? is used to avoid null values
        supportActionBar?.hide()
        Handler().postDelayed({
            val intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
            finish()
        }, 1500)
    }
}