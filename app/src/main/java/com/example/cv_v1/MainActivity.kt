package com.example.cv_v1

import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cv_v1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun isValidEmail(target: CharSequence?): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }

    fun next_btn_clicked(view: android.view.View) {

        if (check())
        {
            if(binding.androidBar.progress > 80)
            {
                Toast.makeText(applicationContext, "You have execellent skills in Android",Toast.LENGTH_LONG).show()

            }
            if(binding.iosBar.progress > 80)
            {
                Toast.makeText(applicationContext, "You have execellent skills in IOS",Toast.LENGTH_LONG).show()

            }
            if(binding.flutterBar.progress > 80)
            {
                Toast.makeText(applicationContext, "You have execellent skills in Flutter",Toast.LENGTH_LONG).show()

            }
            if( binding.androidBar.progress <= 30 && binding.iosBar.progress <= 30 && binding.flutterBar.progress <= 30)
            {
                Toast.makeText(applicationContext, "You need to work on your skills",Toast.LENGTH_LONG).show()

            }
            else Toast.makeText(applicationContext, "You have decent skills ",Toast.LENGTH_LONG).show()

        }





    }


    private fun check(): Boolean
    {
        if(binding.fullName.text.isNullOrEmpty())
        {
            Toast.makeText(applicationContext, "Enter your full name",Toast.LENGTH_LONG).show()
            return false
        }
        if(binding.age.text.isNullOrEmpty())
        {
            Toast.makeText(applicationContext, "Enter your Age",Toast.LENGTH_LONG).show()
            return false

        }
        if(binding.Email.text.isNullOrEmpty() )
        {
            Toast.makeText(applicationContext, "Enter your E-mail",Toast.LENGTH_LONG).show()
            return false

        }


        if (!isValidEmail(binding.Email.text))
        {
            Toast.makeText(getApplicationContext(),"invalid email address",Toast.LENGTH_SHORT).show()
            return false

        }
        else return true

    }

    fun reset(view: android.view.View) {
        binding.fullName.text.clear()
        binding.age.text.clear()
        binding.Email.text.clear()

        binding.androidBar.progress = 0
        binding.flutterBar.progress = 0
        binding.iosBar.progress = 0
        binding.btnFemme.isChecked = false
        binding.btnHomme.isChecked= true

    }
}

