package com.realllydan.meld.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cached
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.realllydan.meld.CardShape
import com.realllydan.meld.MeldTheme
import com.realllydan.meld.data.PassPhrase

private const val TAG = "MainActivity"

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

                    var passphrase: String by remember { mutableStateOf(
                        PassPhrase().getPassphrase(this@MainActivity).toString()
                    )}

                    Card (
                        shape = CardShape,
                        backgroundColor = MaterialTheme.colors.primaryVariant
                    ) {
                        Text(
                            text = passphrase,
                            color = MaterialTheme.colors.onSurface,
                            fontSize = 36.sp,
                            modifier = Modifier.padding(16.dp)
                        )
                    }

                    Spacer( modifier = Modifier.padding(top = 16.dp) )

                    FloatingActionButton(
                        onClick = {
                            passphrase = PassPhrase().getPassphrase(this@MainActivity).toString()
                        },
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