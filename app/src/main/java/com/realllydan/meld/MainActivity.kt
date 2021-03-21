package com.realllydan.meld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cached
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MeldTheme {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(color = MaterialTheme.colors.primary)
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,

                ) {
//                    Image (
//                        painter = painterResource(id = R.drawable.meld_logo),
//                        "Meld App logo",
//                        modifier = Modifier
//                            .height(50.dp)
//                            .width(50.dp)
//                    )

                    Card (
                        shape = CardShape,
                        backgroundColor = MaterialTheme.colors.primaryVariant
                    ) {
                        Text(
                            text = "correct horse battery staple quasi stream scant",
                            color = MaterialTheme.colors.onSurface,
                            fontSize = 36.sp,
                            modifier = Modifier.padding(16.dp)
                        )
                    }

                    Spacer( modifier = Modifier.padding(top = 16.dp) )

                    FloatingActionButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .align(Alignment.End)
                            .size(58.dp)
                    ) {
                        Icon(
                            Icons.Filled.Cached,
                            "Generate New Passphrase",
                            tint = Color.White,
                            modifier = Modifier.size(38.dp)
                        )
                    }
                }

            }
        }
    }
}