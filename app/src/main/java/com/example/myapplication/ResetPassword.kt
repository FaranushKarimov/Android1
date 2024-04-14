package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class ResetPassword : AppCompatActivity() {
    private lateinit var newPasswordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText
    private lateinit var confirmButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_reset_password)
        // Находим элементы интерфейса по их идентификаторам с использованием безопасного вызова
        newPasswordEditText = findViewById<EditText>(R.id.newPasswordEditText)
        confirmPasswordEditText = findViewById<EditText>(R.id.confirmPasswordEditText)
        confirmButton = findViewById<Button>(R.id.confirmButton)

        // Обработка нажатия на кнопку confirmButton
        confirmButton.setOnClickListener {
            // Здесь можно добавить логику обработки события нажатия на кнопку
            // Создаем интент для перехода на новую активность
            val intent = Intent(this, MainActivity::class.java)


            // Запускаем новую активность
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}