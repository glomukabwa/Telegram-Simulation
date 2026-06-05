package com.example.telegramsimulation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

data class contactInfo(val fname: String, val pNumber: String, val profile: Int)

@Composable
fun oneContact(contact: contactInfo){
    Row {
        Image(
            painter = painterResource(contact.profile),
            contentDescription = "Profile picture"
        )

        Column {
            Text(text = contact.fname)
            Text(text = "last seen...")
        }
    }
}

@Preview
@Composable
fun previewOneContact(){
    oneContact(contactInfo("Gloria", "0717292108", R.drawable.profile_icon))
}