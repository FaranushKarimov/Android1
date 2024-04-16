package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar


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
            val newPassword = newPasswordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()

            if (newPassword.isEmpty() || confirmPassword.isEmpty()) {
                // Один из полей пуст, выводим сообщение об ошибке
                // Можно использовать Snackbar или Toast для отображения сообщения
                // Например:
                Snackbar.make(it, "Пожалуйста, заполните все поля", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (newPassword != confirmPassword) {
                // Пароли не совпадают, выводим сообщение об ошибке
                // Например:
                Snackbar.make(it, "Пароли не совпадают", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Если код дошел до этой точки, значит пароли совпадают
            // и можно продолжить выполнение нужных действий, например, переход на другую активность
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}