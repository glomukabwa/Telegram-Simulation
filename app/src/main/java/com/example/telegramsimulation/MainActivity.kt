package com.example.telegramsimulation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.telegramsimulation.ui.theme.TelegramSimulationTheme
import java.sql.Date

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

data class MessageContent(val author: String, val text: String, val date: String)

@Composable
fun OneMessage(msg: MessageContent){
    Row(modifier = Modifier
        .padding(all = 10.dp)
        .fillMaxWidth()){
        Image(
            painter = painterResource(R.drawable.black_image),
            contentDescription = "Profile icon",
            modifier = Modifier
                .size(55.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(15.dp))

        Column {
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween /*This works the way the CSS one works and without the fillMaxWidth() above, you won't see the effect*/
            ){
                Text(
                    text = msg.author,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp
                )
                Text(
                    text = msg.date,
                    color = Color.DarkGray,
                    fontSize = 14.sp
                    )
            }

            Spacer(modifier = Modifier.height(5.dp))

            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween){
                Text(text = msg.text,
                    modifier = Modifier.padding(bottom = 10.dp),
                    color = MaterialTheme.colorScheme.primary,
                    maxLines = 1,/*This means that it should only display one line of the text*/
                    fontSize = 18.sp
                )

                MessageCount(1)
            }

            Divider(color = Color.Gray, thickness = 0.5.dp)
            //A divider is just a thin line
            /*Color.Gray is built into Jetpack Compose (and Kotlin/Android) as part of the standard Color class.
            You don’t have to define it in your theme unless you want a custom shade.
            Color in Compose has a bunch of predefined colors, including:
            Color.Black
            Color.White
            Color.Red
            Color.Green
            Color.Blue
            Color.Gray
            Color.LightGray
            Color.DarkGray
            Color.Cyan
            Color.Magenta
            Color.Yellow
            Color.Transparent
            */
        }
    }
}

@Composable
fun MessageCount(count : Int){
    Box(
        modifier = Modifier
            .size(25.dp)
            .background(Color(0xFF4CAF50),CircleShape),
        contentAlignment = Alignment.Center


    ){
        Text(text = count.toString(),
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Preview
@Composable
fun previewOneMessage(){
    TelegramSimulationTheme {
        Surface(modifier = Modifier.fillMaxSize()){
            OneMessage(MessageContent("Gloria", "Hey Girlll", "Sep 01"))
        }
    }
}

@Composable
fun allMessages(messages: List<MessageContent>){
    LazyColumn {
        items(messages){message ->
            OneMessage(message)
        }
    }
}

@Preview
@Composable
fun previewMessages(){
    TelegramSimulationTheme {
        Surface{
            allMessages(SampleData.conversationSample)
        }
    }
}