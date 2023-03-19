package com.example.codelit

import android.app.ProgressDialog
import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.codelit.databinding.ActivityIntroBinding
import com.example.codelit.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button3.setOnClickListener{
            loginuser()
        }
        binding.button4.setOnClickListener{
            startActivity(Intent(this,SignupActivity::class.java ))
        }


    }

    private fun loginuser() {
        val email=binding.editTextloginemail.text.toString()
        val password=binding.editTextloginPassword.text.toString()

        when{
            TextUtils.isEmpty(email) -> Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show()
            TextUtils.isEmpty(password) -> Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show()
            else->{
                val progressDialog= ProgressDialog(this@LoginActivity)
                progressDialog.setTitle("Log in")
                progressDialog.setMessage("Please wait, this may take a while...")
                progressDialog.setCanceledOnTouchOutside(false)
                progressDialog.show()

                val mAuth: FirebaseAuth= FirebaseAuth.getInstance()
                //creating the user with email password
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {task->
                    if(task.isSuccessful()){
                       progressDialog.dismiss()
                        val intent= Intent(this, MainActivity::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(intent)
                        finish()
                    }else{
                        val message= task.exception.toString()
                        Toast.makeText(this, "Error: $message",Toast.LENGTH_SHORT).show()
                        progressDialog.dismiss()
                    }
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()

        if(FirebaseAuth.getInstance().currentUser!=null){
            val intent= Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }
    }
}