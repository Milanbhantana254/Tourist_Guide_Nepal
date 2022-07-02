package com.example.tour_guide_nepal.fragments

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Activity.RESULT_OK
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import coil.transform.CircleCropTransformation
import com.bumptech.glide.Glide
import com.example.tour_guide_nepal.LoginActivity
import com.example.tour_guide_nepal.MainActivity
import com.example.tour_guide_nepal.R

import kotlinx.android.synthetic.main.activity_gorkha_weather.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.coroutines.NonDisposableHandle.parent
import org.jetbrains.anko.toast
import java.io.ByteArrayOutputStream

@Suppress("UNREACHABLE_CODE", "DEPRECATION")
class ProfileFragment : Fragment() {
    private val DEFAULT_IMAGE_URL = "https://picsum.photos/200"
    private val REQUEST_IMAGE_CAPTURE = 100
    private val currentUser = FirebaseAuth.getInstance().currentUser

    private lateinit var db: FirebaseFirestore
    private lateinit var imageUri: Uri
    private lateinit var backhome: LinearLayout
    private lateinit var imageView: ImageView
    private lateinit var camera: ImageView

    private lateinit var etfullname: TextView
    private lateinit var eefullname: TextView
    private lateinit var eeemail: TextView
    private lateinit var etemail: TextView
    private lateinit var etphone: TextView
    private lateinit var btnsave: Button
    private lateinit var choosephoto : ImageButton





    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        val view = inflater.inflate(R.layout.fragment_profile, container, false)


        etfullname = view.findViewById(R.id.ffullname)
        eefullname = view.findViewById(R.id.ettvfullname)
        eeemail = view.findViewById(R.id.ettvemail)
        etemail = view.findViewById(R.id.eemail)
        etphone = view.findViewById(R.id.pphone)
        backhome = view.findViewById(R.id.backhome)
        camera = view.findViewById(R.id.camera)
        btnsave = view.findViewById(R.id.btnsave)
        choosephoto = view.findViewById(R.id.choosephoto)


        val sharedPref = requireActivity().getPreferences(Context.MODE_PRIVATE)
        val isLogin = sharedPref.getString("Email", "1")

        if (isLogin == "1") {
            var email = requireActivity().intent.getStringExtra("email")
            if (email != null) {
                setText(email)
                with(sharedPref.edit())
                {
                    putString("Email", email)
                    apply()
                }
            } else {
                var intent = Intent(activity, LoginActivity::class.java)
                startActivity(intent)

            }
        } else {
            setText(isLogin)
        }

        backhome.setOnClickListener {
            startActivity(Intent(activity, MainActivity::class.java))
        }

        choosephoto.setOnClickListener {

            intentcamera()
        }
        btnsave.setOnClickListener {

            val photo = when {
                ::imageUri.isInitialized -> imageUri
                currentUser?.photoUrl == null -> Uri.parse(DEFAULT_IMAGE_URL)
                else -> currentUser.photoUrl
            }

            val name = ettvfullname.text.toString().trim()

            if (name.isEmpty()) {
                ettvfullname.error = "name required"
                ettvfullname.requestFocus()
                return@setOnClickListener
            }

            val updates = UserProfileChangeRequest.Builder()
                .setDisplayName(name)
                .setPhotoUri(photo)
                .build()

            progressbar.visibility = View.VISIBLE

            currentUser?.updateProfile(updates)
                ?.addOnCompleteListener { task ->
                    progressbar.visibility = View.INVISIBLE
                    if (task.isSuccessful) {
                        context?.toast("Profile Updated")
                    } else {
                        context?.toast(task.exception?.message!!)
                    }
                }

        }
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        currentUser?.let { user ->
            Glide.with(this)
                .load(user.photoUrl)
                .into(camera)
        }
    }
    private fun intentcamera() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { pictureIntent ->
            pictureIntent.resolveActivity(activity?.packageManager!!)?.also {
                startActivityForResult(pictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            uploadImageAndSaveUri(imageBitmap)
        }
    }

    private fun uploadImageAndSaveUri(bitmap: Bitmap) {
        val baos = ByteArrayOutputStream()
        val storageRef = FirebaseStorage.getInstance()
            .reference
            .child("pics/${FirebaseAuth.getInstance().currentUser?.uid}")
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val image = baos.toByteArray()

        val upload = storageRef.putBytes(image)

        progressbar_pic.visibility = View.VISIBLE
        upload.addOnCompleteListener { uploadTask ->
            progressbar_pic.visibility = View.INVISIBLE

            if (uploadTask.isSuccessful) {
                storageRef.downloadUrl.addOnCompleteListener { urlTask ->
                    urlTask.result?.let {
                        imageUri = it
                        activity?.toast(imageUri.toString())
                        camera.setImageBitmap(bitmap)
                    }
                }
            } else {
                uploadTask.exception?.let {
                    activity?.toast(it.message!!)
                }
            }
        }

    }

    private fun setText(email: String?) {
        db = FirebaseFirestore.getInstance()
        if (email != null) {
            db.collection("USERS").document(email).get()
                .addOnSuccessListener { tasks ->
                    ffullname.text = tasks.get("Name").toString()
                    ettvfullname.text = tasks.get("Name").toString()
                    ettvemail.text = tasks.get("email").toString()
                    pphone.text = tasks.get("Phone").toString()
                    eemail.text = tasks.get("email").toString()

                }
        }

    }
}








