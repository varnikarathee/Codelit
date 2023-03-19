package com.example.codelit

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.codelit.databinding.ActivityIntroBinding
import com.example.codelit.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //Register BTN
        binding.button4.setOnClickListener{
            createAccount()
        }

        binding.button5.setOnClickListener{
            startActivity(Intent(this,LoginActivity::class.java))
        }
    }



    private fun createAccount() {
        val fullname= binding.editTextFullName.text.toString()
        val username= binding.editTextUserName.text.toString()
        val email=binding.editTextTextPersonName.text.toString()
        val password=binding.editTextPassword.text.toString()

        when{
            //first four cases for emty edittext left by user
            TextUtils.isEmpty(fullname)-> Toast.makeText(this,"Please enter your full name",Toast.LENGTH_SHORT ).show()
            TextUtils.isEmpty(username)-> Toast.makeText(this, "Please enter your username",Toast.LENGTH_SHORT).show()
            TextUtils.isEmpty(email)-> Toast.makeText(this, "Please enter your email",Toast.LENGTH_SHORT).show()
            TextUtils.isEmpty(password)-> Toast.makeText(this, "Please enter your password",Toast.LENGTH_SHORT).show()

            else->{
                val progressDialog= ProgressDialog(this@SignupActivity)
                progressDialog.setTitle("Register")
                progressDialog.setMessage("Please wait, this may take a while...")
                progressDialog.setCanceledOnTouchOutside(false)
                progressDialog.show()

                //now first declare auth variable for firebase
                val mAuth: FirebaseAuth= FirebaseAuth.getInstance()
                //creating the user with email password
                mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if(task.isSuccessful){ // if user created succesfully
                          //save user info method now
                            saveuserinfo(fullname,username,email, progressDialog)
                        }
                        else{
                            //error while creating id
                            val message= task.exception.toString()
                            Toast.makeText(this, "Error: $message",Toast.LENGTH_SHORT).show()
                            progressDialog.dismiss()
                        }
                    }
            }
        }


    }

    private fun saveuserinfo(fullname: String, username: String, email: String, progressDialog : ProgressDialog) {

        //save the current user id so create current user variable
        val currentUserId = FirebaseAuth.getInstance().currentUser!!.uid
        //Create the reference to firebase database i.e create node
        val userRef: DatabaseReference= FirebaseDatabase.getInstance().reference.child("Users")
        // create a hashmap
        val userMap= HashMap<String, Any>()
        userMap["uid"]=currentUserId
        userMap["fullname"]=fullname.toLowerCase()
        userMap["username"]=username.toLowerCase()
        userMap["email"]=email
        userMap["bio"]= "hey! I am new here"
        //copying the token from firebase storage of default picture: copies the url
        userMap["image"]="https://firebasestorage.googleapis.com/v0/b/codelit-f7722.appspot.com/o/Default%20Images%2Fdefaultprofile.png?alt=media&token=5507b012-b6c2-41c4-a395-b2c546f7a857"

        userRef.child(currentUserId).setValue(userMap)
            .addOnCompleteListener { task->
                if(task.isSuccessful) {
                   progressDialog.dismiss()
                    Toast.makeText(this, "Account created successfully",Toast.LENGTH_LONG).show()
                   val intent= Intent(this, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                    finish()

                }
                else{
                    val message = task.exception!!.toString()
                    Toast.makeText(this, "Error: @message", Toast.LENGTH_LONG)
                    FirebaseAuth.getInstance().signOut()
                    progressDialog.dismiss()
                }
            }


    }
}