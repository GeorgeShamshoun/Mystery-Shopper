package com.example.mysteryshopper.RecyclerView

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mysteryshopper.Model.AttachedFile
import com.example.mysteryshopper.Model.OnPreviewClick
import com.example.mysteryshopper.R

class AttachedFileRecyclerViewAdapter : RecyclerView.Adapter<AttachedFileRecyclerViewAdapter.AttachedFileViewHolder>(){

    private var attachedFileList: List<AttachedFile> = ArrayList()
    var onPreviewClick: OnPreviewClick? = null
    @SuppressLint("NotifyDataSetChanged")
    fun setLise(attachedFileListSet: List<AttachedFile>) {
        this.attachedFileList = attachedFileListSet
        notifyDataSetChanged()
    }
    inner class AttachedFileViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        fun bind(attachedFile: AttachedFile) {
            val txtItemUpload: TextView = itemView.findViewById(R.id.txt_item_upload)
            val imgItemUpload:ImageView = itemView.findViewById(R.id.img_item_upload)
            val btnPreviewUpload : Button=itemView.findViewById(R.id.btn_preview_upload)

            txtItemUpload.text=attachedFile.AttachedName
            when (attachedFile.AttachedType) {
                "Jpeg" -> { imgItemUpload.setImageResource(R.drawable.attach_jpge) }
                "Move" -> { imgItemUpload.setImageResource(R.drawable.attach_mov) }
                "Mp3" -> { imgItemUpload.setImageResource(R.drawable.attach_mp3) }
            }
            btnPreviewUpload.setOnClickListener {
                onPreviewClick?.PreviewClick(attachedFile.AttachedType)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttachedFileViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_upload, parent, false)
        return  AttachedFileViewHolder(view)
    }

    override fun onBindViewHolder(holder: AttachedFileViewHolder, position: Int) {
        val attachedFile: AttachedFile = attachedFileList.get(position)
        holder.bind(attachedFile) }

    override fun getItemCount(): Int { return attachedFileList.size }


}