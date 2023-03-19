package com.example.codelit.Fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.codelit.Adapter.UserAdapter
import com.example.codelit.Modal.User
import com.example.codelit.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.fragment_search.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
//class SearchFragment : Fragment() {
//
//    private var param1: String? = null
//    private var param2: String? = null
//
//    //create variables
//    private  var recyclerView:RecyclerView?=null
//    private var userAdapter: userAdapter?=null
//    private var mUser: MutableList<User>?=null
//    private lateinit var searchbox: EditText
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        val view=  inflater.inflate(R.layout.fragment_search, container, false)
//
//
//        // instantiate recyclerview
//        recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_home)
//        recyclerView?.setHasFixedSize(true)
//        recyclerView?.layoutManager=LinearLayoutManager(context)
//
//        //instantiate adapter and set to recycler view
//        mUser=ArrayList()
//        userAdapter= context?.let{userAdapter(it,mUser as ArrayList<User>,true)}
//        recyclerView?.adapter=userAdapter
//
//
//        // for implementing the live search , where as text changes we can see the changes in list
//        searchbox = view.findViewById(R.id.search_edittext)
//        searchbox.addTextChangedListener(object :TextWatcher
//        {
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//
//            }
//
//
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//              //only using this function
//                if(searchbox.text.toString()=="")
//                {
//
//                }
//                else
//                {
//                    recyclerView?.visibility=View.VISIBLE
//                    retreiveuser()
//                    searchUser(p0.toString().toLowerCase())
//                }
//            }
//
//            override fun afterTextChanged(p0: Editable?) {
//
//            }
//
//        })
//
//
//
//      return view
//    }
//
//    private fun searchUser(input: String) {
//        val  query= FirebaseDatabase.getInstance().getReference()
//            .child("Users")
//            .orderByChild("fullname")
//            .startAt(input)
//            .endAt(input+"\uf8ff")
//
//
//        query.addValueEventListener(object: ValueEventListener
//        {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                mUser?.clear()
//
//                for (snapShot in dataSnapshot.children)
//                {
//                    val user = snapShot.getValue((User::class.java))
//                    val fullName = snapShot.child("fullname").getValue().toString()
//                    val userName = snapShot.child("username").getValue().toString()
//                    val email = snapShot.child("email").getValue().toString()
//                    val bio = snapShot.child("bio").getValue().toString()
//                    val image = snapShot.child("image").getValue().toString()
//                    val uid = snapShot.child("uid").getValue().toString()
//
//                    User(userName, fullName, bio, image, uid)
//                    if(user!=null)
//                    {
//                        mUser?.add(User(userName, fullName, bio, image, uid))
//                    }
//
//
//
//                }
//
//                userAdapter?.notifyDataSetChanged()
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                TODO("Not yet implemented")
//            }
//
//        })
//    }
//
//    private fun retreiveuser() {
//       val  userRef= FirebaseDatabase.getInstance().getReference().child("Users")
//        userRef.addValueEventListener(object: ValueEventListener
//        {
//            override fun onDataChange(datasnapshot: DataSnapshot) {
//                if(searchbox.text.toString()=="")
//                {
//                    mUser?.clear()
//
//                    for (snapshot in datasnapshot.children)
//                    {
//                        val user = snapshot.getValue((User::class.java))
//                        if(user!=null)
//                        {
//                            mUser?.add(user)
//                        }
//
//                    }
//
//                    userAdapter?.notifyDataSetChanged()
//                }
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                TODO("Not yet implemented")
//            }
//
//        })
//    }
//
//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment SearchFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            SearchFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
//}

//class SearchFragment : Fragment()
//{
//    private var recyclerView: RecyclerView? = null
//    private var userAdapter: userAdapter? = null
//    private var mUser: MutableList<User>? = null
//
//
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        val view = inflater.inflate(R.layout.fragment_search, container, false)
//
//
//        recyclerView = view.findViewById(R.id.recycler_view_home)
//        recyclerView?.setHasFixedSize(true)
//        recyclerView?.layoutManager = LinearLayoutManager(context)
//
//
//        mUser = ArrayList()
//        userAdapter = context?.let { userAdapter(it, mUser as ArrayList<User>, true) }
//
//
//        view.search_edit_text.addTextChangedListener(object: TextWatcher
//        {
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int)
//            {
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int)
//            {
//                if (view.search_edit_text.text.toString() == "")
//                {
//
//                }
//                else
//                {
//                    recyclerView?.visibility = View.VISIBLE
//
//                    retrieveUsers()
//                    searchUser(s.toString().toLowerCase())
//                }
//            }
//
//            override fun afterTextChanged(s: Editable?)
//            {
//            }
//        })
//
//        recyclerView?.adapter = userAdapter
//        return view
//    }
//
//
//
//    private fun searchUser(input: String)
//    {
//        val query = FirebaseDatabase.getInstance().getReference()
//            .child("Users")
//            .orderByChild("fullname")
//            .startAt(input)
//            .endAt(input + "\uf8ff")
//
//        query.addValueEventListener(object : ValueEventListener
//        {
//            override fun onDataChange(dataSnapshot: DataSnapshot)
//            {
//                mUser?.clear()
//
//                for (snapShot in dataSnapshot.children)
//                {
//                    val user = snapShot.getValue(User::class.java)
//                    val fullName = snapShot.child("fullname").getValue().toString()
//                    val userName = snapShot.child("username").getValue().toString()
//                    val email = snapShot.child("email").getValue().toString()
//                    val bio = snapShot.child("bio").getValue().toString()
//                    val image = snapShot.child("image").getValue().toString()
//                    val uid = snapShot.child("uid").getValue().toString()
//
//                    if (user != null)
//                    {
//                        mUser?.add( User(userName, fullName, bio, image, uid))
//                    }
//                }
//
//                userAdapter?.notifyDataSetChanged()
//            }
//
//            override fun onCancelled(p0: DatabaseError)
//            {
//            }
//        })
//    }
//
//
//    private fun retrieveUsers()
//    {
//
//        val usersRef = FirebaseDatabase.getInstance().getReference().child("Users")
//        usersRef.addValueEventListener(object : ValueEventListener
//        {
//            override fun onDataChange(dataSnapshot: DataSnapshot)
//            {
//                if (view?.search_edit_text?.text.toString() == "")
//                {
//                    mUser?.clear()
//
//                    for (snapShot in dataSnapshot.children)
//                    {
//                        val user = snapShot.getValue(User::class.java)
//                        val fullName = snapShot.child("fullname").getValue().toString()
//                        val userName = snapShot.child("username").getValue().toString()
//                        val email = snapShot.child("email").getValue().toString()
//                        val bio = snapShot.child("bio").getValue().toString()
//                        val image = snapShot.child("image").getValue().toString()
//                        val uid = snapShot.child("uid").getValue().toString()
//
//                        if (user != null)
//                        {
//                            mUser?.add(User(userName, fullName, bio, image, uid))
//                        }
//                    }
//
//                    userAdapter?.notifyDataSetChanged()
//                }
//            }
//
//            override fun onCancelled(p0: DatabaseError)
//            {
//            }
//        })
//    }
//
//
//}


class SearchFragment : Fragment()
{
    private var recyclerView: RecyclerView? = null
    private var userAdapter: UserAdapter? = null
    private var mUser: MutableList<User>? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_search, container, false)


        recyclerView = view.findViewById(R.id.recycler_view_home)
        recyclerView?.setHasFixedSize(true)
        recyclerView?.layoutManager = LinearLayoutManager(context)


        mUser = ArrayList()
        userAdapter = context?.let { UserAdapter(it, mUser as ArrayList<User>, true) }
        recyclerView?.adapter = userAdapter

        view.search_edit_text.addTextChangedListener(object: TextWatcher
        {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int)
            {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int)
            {
                if (view.search_edit_text.text.toString() == "")
                {

                }
                else
                {
                    recyclerView?.visibility = View.VISIBLE

                    retrieveUsers()
                    searchUser(s.toString().toLowerCase())
                }
            }

            override fun afterTextChanged(s: Editable?)
            {
            }
        })


        return view
    }



    private fun searchUser(input: String)
    {
        val query = FirebaseDatabase.getInstance().getReference()
            .child("Users")
            .orderByChild("fullname")
            .startAt(input)
            .endAt(input + "\uf8ff")

        query.addValueEventListener(object : ValueEventListener
        {
            override fun onDataChange(dataSnapshot: DataSnapshot)
            {
                mUser?.clear()

                for (snapshot in dataSnapshot.children)
                {
                    val user = snapshot.getValue(User::class.java)
                    if (user != null)
                    {
                        mUser?.add(user)
                    }
                }

                userAdapter?.notifyDataSetChanged()
            }

            override fun onCancelled(p0: DatabaseError)
            {
            }
        })
    }


    private fun retrieveUsers()
    {
        val usersRef = FirebaseDatabase.getInstance().getReference().child("Users")
        usersRef.addValueEventListener(object : ValueEventListener
        {
            override fun onDataChange(dataSnapshot: DataSnapshot)
            {
                if (view?.search_edit_text?.text.toString() == "")
                {
                    mUser?.clear()

                    for (snapshot in dataSnapshot.children)
                    {
                        val user = snapshot.getValue(User::class.java)
                        if (user != null)
                        {
                            mUser?.add(user)
                        }
                    }

                    userAdapter?.notifyDataSetChanged()
                }
            }

            override fun onCancelled(p0: DatabaseError)
            {
            }
        })
    }


}
