package com.example.telegramsimulation

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.telegramsimulation.ui.theme.TelegramSimulationTheme

data class contactInfo(val fname: String, val pNumber: String, val profile: Int)

@Composable
fun oneContact(contact: contactInfo){
    Row (
        modifier = Modifier.padding(10.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ){
        Image(
            painter = painterResource(contact.profile),
            contentDescription = "Profile picture",
            modifier = Modifier
                .size(55.dp)
                .clip(CircleShape)

        )

        Column {
            Text(text = contact.fname)
            Text(text = "last seen...")
        }
    }
}


@Composable
fun contactSurface(){
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        oneContact(contactInfo("Gloria", "0717292108", R.drawable.black_image))
    }
}

@Preview
@Composable
fun previewContactsSurface(){
    TelegramSimulationTheme {
        contactSurface()
    }
}