package com.itera.pam.p3.latihan

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun ProfileHeader(
    name: String,
    bio: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {

        Box(
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .background(Color(0xFF673AB7)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Foto profil",
                modifier = Modifier.size(70.dp)
            )
        }

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Text(
            text = name
        )

        Spacer(
            modifier = Modifier.height(4.dp)
        )

        Text(
            text = bio
        )
    }
}


@Composable
fun InfoItem(
    label: String,
    value: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = label
            )

            Text(
                text = value
            )
        }
    }
}


@Composable
fun ProfileCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = "Informasi Pribadi"
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            InfoItem(
                label = "Email",
                value = "hania.124140114@student.itera.ac.id"
            )

            InfoItem(
                label = "Phone",
                value = "082279901659"
            )

            InfoItem(
                label = "Location",
                value = "Bandar Lampung"
            )
        }
    }
}


@Composable
fun MyProfileApp() {

    var showInfo by remember {
        mutableStateOf(true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        ProfileHeader(
            name = "Hania Syakira",
            bio = "Teknik Informatika"
        )

        AnimatedVisibility(
            visible = showInfo
        ) {
            ProfileCard()
        }

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Button(
            onClick = {
                showInfo = !showInfo
            }
        ) {
            Text(
                text = if (showInfo) {
                    "Sembunyikan Info"
                } else {
                    "Tampilkan Info"
                }
            )
        }
    }
}