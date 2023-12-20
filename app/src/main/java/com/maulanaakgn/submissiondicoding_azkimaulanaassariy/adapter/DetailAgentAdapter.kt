package com.maulanaakgn.submissiondicoding_azkimaulanaassariy.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.maulanaakgn.submissiondicoding_azkimaulanaassariy.R
import com.maulanaakgn.submissiondicoding_azkimaulanaassariy.model.DetailAgent

class DetailAgentAdapter(private val detailAgent: ArrayList<DetailAgent>) : RecyclerView.Adapter<DetailAgentAdapter.DetailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_detail_agent, parent, false)
        return DetailViewHolder(view)
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        holder.bind(detailAgent[position])
    }

    override fun getItemCount(): Int = detailAgent.size

    class DetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        private val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        private val tvRole: TextView = itemView.findViewById(R.id.tv_item_role)
        private val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
        private val tvSkill_q: ImageView = itemView.findViewById(R.id.img_item_util1)
        private val tvSkill_e: ImageView = itemView.findViewById(R.id.img_item_util2)
        private val tvSkill_c: ImageView = itemView.findViewById(R.id.img_item_util3)
        private val tvSkill_x: ImageView = itemView.findViewById(R.id.img_item_util4)
        private val tvSkillNameQ: TextView = itemView.findViewById(R.id.tv_item_name_q)
        private val tvSkillNameE: TextView = itemView.findViewById(R.id.tv_item_name_e)
        private val tvSkillNameC: TextView = itemView.findViewById(R.id.tv_item_name_c)
        private val tvSkillNameX: TextView = itemView.findViewById(R.id.tv_item_name_x)
        private val tvSkillDescQ: TextView = itemView.findViewById(R.id.tv_item_desc_q)
        private val tvSkillDescE: TextView = itemView.findViewById(R.id.tv_item_desc_e)
        private val tvSkillDescC: TextView = itemView.findViewById(R.id.tv_item_desc_c)
        private val tvSkillDescX: TextView = itemView.findViewById(R.id.tv_item_desc_x)

        fun bind(detailAgent: DetailAgent) {
            imgPhoto.setImageResource(detailAgent.photo)
            tvName.text = detailAgent.name
            tvRole.text = detailAgent.role
            tvDescription.text = detailAgent.description
            tvSkill_q.setImageResource(detailAgent.skill_q)
            tvSkill_e.setImageResource(detailAgent.skill_e)
            tvSkill_c.setImageResource(detailAgent.skill_c)
            tvSkill_x.setImageResource(detailAgent.skill_x)
            tvSkillNameQ.text = detailAgent.skillnameq
            tvSkillNameE.text = detailAgent.skillnamee
            tvSkillNameC.text = detailAgent.skillnamec
            tvSkillNameX.text = detailAgent.skillnamex
            tvSkillDescQ.text = detailAgent.skilldescq
            tvSkillDescE.text = detailAgent.skilldesce
            tvSkillDescC.text = detailAgent.skilldescc
            tvSkillDescX.text = detailAgent.skilldescx
        }
    }
}
