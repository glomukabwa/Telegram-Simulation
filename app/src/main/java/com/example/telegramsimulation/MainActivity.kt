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
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
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
                    allMessages(SampleData.conversationSample)
                }
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelegramTopBar(){
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "Telegram",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        },
        navigationIcon = {
            Icon(
                painter = painterResource(R.drawable.ic_menu),
                contentDescription = "Menu",
                tint = Color.White,
                modifier = Modifier.padding(start = 10.dp)
                    .width(20.dp)
            )
        },
        actions = {
            Icon(
                painter = painterResource(R.drawable.ic_search),
                contentDescription = "Search",
                tint = Color.White,
                modifier = Modifier.padding(end = 10.dp)
                    .width(20.dp)
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    )
}

data class MessageContent(val author: String, val text: String, val date: String, val image: Int)

@Composable
fun OneMessage(msg: MessageContent){
    Row(modifier = Modifier
        .padding(all = 10.dp)
        .fillMaxWidth()){
        Image(
            painter = painterResource(msg.image),
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
                    fontSize = 14.sp,
                    modifier = Modifier
                        .width(55.dp),
                    /*I'm giving this a fixed maximum width and I'll make it align to the left below so that
                    I can know the exact left padding to put on the message counter so that messages cannot
                    occupy any width past the date.*/
                    textAlign = TextAlign.End
                    )
            }

            Spacer(modifier = Modifier.height(5.dp))

            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween){
                Text(text = msg.text,
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                        .weight(1f),
                    /*weight ensures that the message only takes the available space. Initially, when this
                    * wasn't there, the text would occupy even the space for the MessageCount function
                    * With this, you are telling it to occupy only the space available to it.
                    * If I wanted the text and MessageCount to  occupy 50% of the space each, I would have
                    * given this text weight of 1f and the counter weight of 1f. So 1f plus 1f to get a
                    * total of 2f then each gets 1 of 2. If I wanted text to get 75% and counter 15%, I would
                    * have given text 3f and counter 1f*/
                    color = MaterialTheme.colorScheme.primary,
                    maxLines = 1,/*This means that it should only display one line of the text*/
                    fontSize = 18.sp
                )

                Box(modifier = Modifier.padding(start = 30.dp)){/*The remaining space if we subtract the width of the date and the width of the MessageCount box*/
                    MessageCount(1)
                }
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
            .background(Color(0xFF4CAF50),CircleShape)
            ,
        contentAlignment = Alignment.Center
    ){
        Text(text = count.toString(),
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun TelegramFABs(){/*FABs stand for floating action buttond*/
    Column (
        modifier = Modifier
            .fillMaxSize()/*This is necessary cz we need to align them at the bottom right of the page so we need to make them occupy the whole page*/
            .padding(16.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End,
    ){
        Box(
            modifier = Modifier.width(70.dp),
            contentAlignment = Alignment.Center
        ){
            FloatingActionButton(
                onClick = {},
                containerColor = Color(250,249,246),
                modifier = Modifier
                    .clip(CircleShape)
                    .size(45.dp)
                    .border(1.5.dp, Color.Gray, CircleShape)
            ){
                Icon(
                    painter = painterResource(R.drawable.ic_pencil),
                    contentDescription = "Pencil",
                    tint = Color.Gray,
                    modifier = Modifier.size(20.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        FloatingActionButton(
            onClick = {},
            containerColor = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .clip(CircleShape)
                .size(70.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_camera),
                contentDescription = "Camera",
                tint = Color.White,
                modifier = Modifier.size(30.dp)
            )
        }
    }
}

@Preview
@Composable
fun previewOneMessage(){
    TelegramSimulationTheme {
        Surface(modifier = Modifier.fillMaxSize()){
            OneMessage(MessageContent("Gloria", "Hey Girlll", "Sep 01", R.drawable.black_image))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun allMessages(messages: List<MessageContent>) {

    Scaffold(
        /* In Jetpack Compose, a Scaffold is a high-level layout structure that gives you a ready-made screen
        layout following Material Design guidelines.
        Think of it like a page template that already knows where to place:
        Top app bar
        Bottom app bar
        Floating Action Button (FAB)
        Drawer / Navigation Drawer
        Snackbar host
        Main content area (scrollable, etc.)
        So instead of manually positioning everything (like I was doing now with Column + LazyColumn +
        TelegramFABs()), Scaffold puts everything in the correct Material positions automatically.*/
        topBar = { TelegramTopBar() },
        floatingActionButton = { TelegramFABs() }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            items(messages) { message ->
                OneMessage(message)
            }
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

/*TO_DO:
* Research on top bar and comment on it
* Include change of color when clicking
* Include shadow under pencil icon*/
