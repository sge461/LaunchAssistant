package de.alexanderruck.launchassistant

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

const val TAG = "laTAG"
const val GOOGLE_ASSISTANT = "com.google.android.apps.googleassistant"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        launchAssistant()
        finish()
    }

    private fun launchAssistant() {
        try {
            val launchIntent = packageManager.getLaunchIntentForPackage(GOOGLE_ASSISTANT)
            if (launchIntent != null) {
                startActivity(launchIntent)
            }
        } catch (e: Exception) {
            Log.e(TAG, "MainActivity > launchAssistant() > ${e.message}")
        }
    }
}