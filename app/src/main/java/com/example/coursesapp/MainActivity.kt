package com.example.coursesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coursesapp.data.CoursesDataSource
import com.example.coursesapp.model.Topic
import com.example.coursesapp.ui.theme.CoursesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursesAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CoursesApp()
                }
            }
        }
    }
}

@Composable
fun CoursesApp(){
}

@Composable
fun TopicsCard(topic: Topic, modifier: Modifier = Modifier){
    Card(modifier = modifier) {
        Row{
            Image(
                painter = painterResource(topic.imageResourceId),
                contentDescription = stringResource(topic.title),
                modifier = Modifier
                    .height(68.dp)
                    .width(68.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.padding(
                    start = 16.dp,
                    top = 16.dp,
                    end = 16.dp,
                )
            ) {
                Text(
                    text = stringResource(topic.title),
                    style = MaterialTheme.typography.bodyMedium
                )
                Row(modifier = Modifier.padding(top = 8.dp),
                    verticalAlignment = Alignment.CenterVertically) {

                    Image(
                        painter = painterResource(R.drawable.dots),
                        contentDescription = "Grain Icon",
                        modifier = Modifier.size(16.dp),
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = topic.number.toString(),
                        style = MaterialTheme.typography.labelMedium
                    )

                }

            }
        }
    }


}

@Preview()
@Composable
fun TopicsCardPreview(){
    TopicsCard(Topic(R.string.architecture,20,R.drawable.architecture))
}