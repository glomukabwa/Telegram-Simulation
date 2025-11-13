package com.example.telegramsimulation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.telegramsimulation.ui.theme.TelegramSimulationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TelegramSimulationTheme {
                Surface {

                }
            }
        }
    }
}

data class MessageContent(val author: String, val text: String)

@Composable
fun OneMessage(msg: MessageContent){
    Row(modifier = Modifier.padding(all = 10.dp)){
        Image(
            painter = painterResource(R.drawable.black_image),
            contentDescription = "Profile icon",
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(15.dp))

        Column {
            Text(text = msg.author)
            Text(text = msg.text)
        }
    }
}

@Preview
@Composable
fun previewOneMessage(){
    TelegramSimulationTheme {
        Surface(modifier = Modifier.fillMaxSize()){
            OneMessage(MessageContent("Gloria", "Hey Girllllll"))
        }
    }
}