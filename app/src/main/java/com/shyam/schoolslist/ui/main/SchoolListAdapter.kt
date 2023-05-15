package com.shyam.schoolslist.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shyam.schoolslist.R
import com.shyam.schoolslist.domain.model.Record

class SchoolListAdapter() : RecyclerView.Adapter<SchoolListAdapter.ViewHolder>() {
private lateinit var schoolList: List<Record>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_school_list, parent, false)
        return ViewHolder(view)
    }

    fun addData(list: List<Record>) {
        schoolList = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val itemModel = schoolList[position]
        holder.schoolNumber.text = itemModel.School_Id.toString()
        holder.schoolName.text = itemModel.Org_Name
        holder.schoolPhone.text = itemModel.Telephone
        holder.schoolEmail.text = itemModel.Email
    }

    override fun getItemCount(): Int {
       return schoolList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val schoolNumber: TextView = itemView.findViewById(R.id.itemNumber)
        val schoolName: TextView = itemView.findViewById(R.id.itemName)
        val schoolPhone: TextView = itemView.findViewById(R.id.itemPhoneNumber)
        val schoolEmail: TextView = itemView.findViewById(R.id.itemEmail)
    }
}