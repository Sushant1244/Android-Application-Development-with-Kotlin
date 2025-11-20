package com.example.kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlin.ui.theme.KotlinTheme

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinTheme {
                Surface(color = Color.Black, modifier = Modifier.fillMaxSize()) {
                    InstagramProfileScreen()
                }
            }
        }
    }
}

@Composable
fun InstagramProfileScreen() {
    Column(modifier = Modifier.fillMaxSize().background(Color.Black)) {
        // Top Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically



        ) {
            Text(
                text = "sushantshah143",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
            Icon(
                painter = painterResource(id = R.drawable.baseline_more_horiz_24), // Placeholder for settings
                contentDescription = "Settings",
                tint = Color.White,
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        // Profile Section
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile_pic),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(90.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ProfileStat(number = "4", label = "posts")
                ProfileStat(number = "215K", label = "followers")
                ProfileStat(number = "10", label = "following")
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Bio Section
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text("Sūshāñt Shāh", color = Color.White, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text("🙏\"HAR\"❤️\n🙏\"HAR\"❤️\n🙏\"MAHADEV\"❤️‍", color = Color.White)
            Spacer(modifier = Modifier.height(4.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("sushantshah143", color = Color.White, fontSize = 14.sp)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Action Buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ProfileButton(modifier = Modifier.weight(1f), text = "Edit Profile")
            ProfileButton(modifier = Modifier.weight(1f), text = "View archive")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Story Highlights
        val stories = listOf(
            "Mehh ❤️" to R.drawable.ic_launcher_background, // Placeholder
            "Highlights" to R.drawable.ic_launcher_background, // Placeholder
            "Highlights" to R.drawable.profile_pic,
            "Story" to R.drawable.ic_launcher_background, // Placeholder for story_highlight.jpg
            "Travel" to R.drawable.ic_launcher_background // Placeholder for travel_highlight.jpg
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(stories) { (name, imageRes) ->
                StoryHighlightItem(imageRes = imageRes, text = name)
            }
            item {
                NewStoryItem()
            }
        }
    }
}

@Composable
fun ProfileStat(number: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = number, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Text(text = label, color = Color.White, fontSize = 14.sp)
    }
}

@Composable
fun ProfileButton(modifier: Modifier = Modifier, text: String) {
    Button(
        onClick = { },
        modifier = modifier.height(35.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF333333)),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(text = text, color = Color.White, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
fun StoryHighlightItem(imageRes: Int, text: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = text,
            modifier = Modifier
                .size(70.dp)
                .clip(CircleShape)
                .border(1.dp, Color.DarkGray, CircleShape),
            contentScale = ContentScale.Crop,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = text, color = Color.White, fontSize = 12.sp)
    }
}

@Composable
fun NewStoryItem() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(70.dp)
                .clip(CircleShape)
                .border(1.dp, Color.DarkGray, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add new story",
                tint = Color.White,
                modifier = Modifier.size(30.dp)
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "New", color = Color.White, fontSize = 12.sp)
    }
}


@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun PreviewProfile() {
    KotlinTheme {
        InstagramProfileScreen()
    }
}
