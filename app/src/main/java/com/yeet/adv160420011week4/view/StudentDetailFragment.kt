package com.yeet.adv160420011week4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import com.yeet.adv160420011week4.R
import com.yeet.adv160420011week4.model.Student
import com.yeet.adv160420011week4.viewmodel.DetailViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [StudentDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StudentDetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel
    private var student: Student = Student("", "", "", "", "")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_detail, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch()

        observeViewModel()
    }

    fun observeViewModel() {
        val txtID: TextInputEditText = requireView().findViewById(R.id.txtID_studentdetail)
        val txtName: TextInputEditText = requireView().findViewById(R.id.txtName_studentdetail)
        val txtDob: TextInputEditText = requireView().findViewById(R.id.txtDob)
        val txtPhone: TextInputEditText = requireView().findViewById(R.id.txtPhone)

        viewModel.studentLD.observe(viewLifecycleOwner, Observer {
            txtID.setText(it.id)
            txtName.setText(it.name)
            txtDob.setText(it.dob)
            txtPhone.setText(it.phone)
        })
    }
}