package com.maulanaakgn.submissiondicoding_azkimaulanaassariy

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.maulanaakgn.submissiondicoding_azkimaulanaassariy.adapter.ListAgentAdapter
import com.maulanaakgn.submissiondicoding_azkimaulanaassariy.model.Agent

class MainActivity : AppCompatActivity() {
    private lateinit var rvAgents: RecyclerView
    private val list = ArrayList<Agent>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvAgents = findViewById(R.id.rv_agents)
        rvAgents.setHasFixedSize(true)

        list.addAll(getListAgents())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                val aboutIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(aboutIntent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun getListAgents(): ArrayList<Agent> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)

        val listAgent = ArrayList<Agent>()
        for (i in dataName.indices) {
            val agent = Agent(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listAgent.add(agent)
        }
        return listAgent
    }

    private fun showRecyclerList() {
        rvAgents.layoutManager = LinearLayoutManager(this)
        val listAgentAdapter = ListAgentAdapter(list)

        listAgentAdapter.setOnItemClickCallback(object : ListAgentAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Agent) {
                val detailIntent = Intent(this@MainActivity, DetailActivity::class.java).apply {
                    putExtra(DetailActivity.EXTRA_ITEM_POSITION, list.indexOf(data))
                }
                startActivity(detailIntent)
            }
        })

        rvAgents.adapter = listAgentAdapter
    }

    private fun showSelectedAgent(agent: Agent) {
        Toast.makeText(this, "Kamu memilih " + agent.name, Toast.LENGTH_SHORT).show()
    }
}