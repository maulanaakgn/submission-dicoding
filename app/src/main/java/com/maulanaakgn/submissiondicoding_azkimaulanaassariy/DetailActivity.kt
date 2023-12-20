package com.maulanaakgn.submissiondicoding_azkimaulanaassariy

import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.maulanaakgn.submissiondicoding_azkimaulanaassariy.adapter.DetailAgentAdapter
import com.maulanaakgn.submissiondicoding_azkimaulanaassariy.model.DetailAgent

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ITEM_POSITION = "extra_item_position"
    }

    private lateinit var rvDetails: RecyclerView
    private val list = ArrayList<DetailAgent>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val actionBar: ActionBar? = supportActionBar

        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false)
        }

        rvDetails = findViewById(R.id.rv_details)

        val position = intent.getIntExtra(EXTRA_ITEM_POSITION, 0)

        if (position >= 0 && position < getListSize()) {
            val detailAgent = getDetailAgent(position)
            list.add(detailAgent)
            showRecyclerList()
        } else {
            finish()
        }
    }

    private fun getListSize(): Int {
        return resources.getStringArray(R.array.data_name).size
    }

    private fun getDetailAgent(position: Int): DetailAgent {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataRole = resources.getStringArray(R.array.data_role)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataSkillQ = resources.obtainTypedArray(R.array.data_skill_q)
        val dataSkillE = resources.obtainTypedArray(R.array.data_skill_e)
        val dataSkillC = resources.obtainTypedArray(R.array.data_skill_c)
        val dataSkillX = resources.obtainTypedArray(R.array.data_skill_x)
        val dataSkillNameQ = resources.getStringArray(R.array.data_skill_name_q)
        val dataSkillNameE = resources.getStringArray(R.array.data_skill_name_e)
        val dataSkillNameC = resources.getStringArray(R.array.data_skill_name_c)
        val dataSkillNameX = resources.getStringArray(R.array.data_skill_name_x)
        val dataSkillDescQ = resources.getStringArray(R.array.data_skill_desc_q)
        val dataSkillDescE = resources.getStringArray(R.array.data_skill_desc_e)
        val dataSkillDescC = resources.getStringArray(R.array.data_skill_desc_c)
        val dataSkillDescX = resources.getStringArray(R.array.data_skill_desc_x)

        return DetailAgent(
            dataName[position],
            dataRole[position],
            dataDescription[position],
            dataPhoto.getResourceId(position, 0),
            dataSkillQ.getResourceId(position, 0),
            dataSkillE.getResourceId(position, 0),
            dataSkillC.getResourceId(position, 0),
            dataSkillX.getResourceId(position, 0),
            dataSkillNameQ[position],
            dataSkillNameE[position],
            dataSkillNameC[position],
            dataSkillNameX[position],
            dataSkillDescQ[position],
            dataSkillDescE[position],
            dataSkillDescC[position],
            dataSkillDescX[position]
        )
    }

    private fun showRecyclerList() {
        rvDetails.layoutManager = LinearLayoutManager(this)
        val listAgentAdapter = DetailAgentAdapter(list)
        rvDetails.adapter = listAgentAdapter
    }

    private fun captureScreen(view: View): Bitmap {
        val screenshot = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(screenshot)
        view.draw(canvas)
        return screenshot
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
