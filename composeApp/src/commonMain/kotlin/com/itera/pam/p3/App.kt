package com.itera.pam.p3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.itera.pam.p3.latihan.Handson1Screen
import com.itera.pam.p3.latihan.Handson2Screen
import com.itera.pam.p3.latihan.Handson3Screen
import com.itera.pam.p3.latihan.MyProfileApp

private enum class Screen(val label: String) {
    Menu("Menu"),
    Latihan1("Latihan 1 - ProfileCard"),
    Latihan2("Latihan 2 - Login Form"),
    Latihan3("Latihan 3 - Product List"),
    MyProfile("My Profile App")
}

@Composable
fun App() {
    MaterialTheme {

        var screen by remember {
            mutableStateOf(Screen.Menu)
        }

        Surface(
            modifier = Modifier.fillMaxSize()
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {

                // Tombol kembali ke menu
                if (screen != Screen.Menu) {
                    Button(
                        onClick = {
                            screen = Screen.Menu
                        }
                    ) {
                        Text("< Kembali ke Menu")
                    }
                }

                when (screen) {

                    // =========================
                    // MENU UTAMA
                    // =========================
                    Screen.Menu -> {

                        Text(
                            text = "Hands-on Pertemuan 3"
                        )

                        Text(
                            text = "Compose Multiplatform Basics"
                        )

                        Screen.entries
                            .filter { it != Screen.Menu }
                            .forEach { s ->

                                Button(
                                    onClick = {
                                        screen = s
                                    }
                                ) {
                                    Text(s.label)
                                }
                            }
                    }

                    // =========================
                    // HANDSON 1
                    // =========================
                    Screen.Latihan1 -> {
                        Handson1Screen()
                    }

                    // =========================
                    // HANDSON 2
                    // =========================
                    Screen.Latihan2 -> {
                        Handson2Screen()
                    }

                    // =========================
                    // HANDSON 3
                    // =========================
                    Screen.Latihan3 -> {
                        Handson3Screen()
                    }

                    // =========================
                    // MY PROFILE APP
                    // =========================
                    Screen.MyProfile -> {
                        MyProfileApp()
                    }
                }
            }
        }
    }
}