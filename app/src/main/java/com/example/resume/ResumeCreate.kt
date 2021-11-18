package com.example.resume

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ResumeCreate : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resume_create)
        this.supportActionBar?.hide()
        window.statusBarColor = Color.WHITE

        var view_cv_btn = findViewById<Button>(R.id.view_cv_btn)
        var btn_personal_detail = findViewById<Button>(R.id.btn_personal_detail)
        var btn_educational_detail = findViewById<Button>(R.id.btn_educational_detail)
        var btn_experience_detail = findViewById<Button>(R.id.btn_experience_detail)
        var btn_skill_detail = findViewById<Button>(R.id.btn_skill_detail)
        var btn_objective_detail = findViewById<Button>(R.id.btn_objective_detail)
        var btn_project_detail = findViewById<Button>(R.id.btn_project_detail)

        view_cv_btn.setOnClickListener {
            startActivity(Intent(this,ResumeDetail::class.java))
        }

        btn_personal_detail.setOnClickListener {
            startActivity(Intent(this,ResumePersonalDetail::class.java))
        }

        btn_educational_detail.setOnClickListener {
            startActivity(Intent(this,ResumeEducationDetail::class.java))
        }

        btn_experience_detail.setOnClickListener {
            startActivity(Intent(this,ResumeExperienceDetail::class.java))
        }

        btn_skill_detail.setOnClickListener {
            startActivity(Intent(this,ResumeSkillDetail::class.java))
        }

        btn_objective_detail.setOnClickListener {
            startActivity(Intent(this,ResumeObjectiveDetail::class.java))
        }

        btn_project_detail.setOnClickListener {
            startActivity(Intent(this,ResumeProjectsDetail::class.java))
        }
    }
}