package com.example.ut4_teoria

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ut4_teoria.ui.theme.UT4_teoriaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UT4_teoriaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        Modifier.padding(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        MyCard()
                        MyBadges()
                        MyDropDownMenu()
                        Spacer(Modifier.size(20.dp))
                        MyExposedDropDownMenu()
                        //Greeting("Android")
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UT4_teoriaTheme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun MyCard() {
    Column() {
        Card(
            modifier = Modifier
                .size(width = 240.dp, height = 200.dp)
                .padding(16.dp),
            shape = MaterialTheme.shapes.medium,
            elevation = CardDefaults.cardElevation(defaultElevation = 16.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Texto 1")
                Text(text = "Texto 2")
                Text(text = "Texto 3")
            }
        }
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = MaterialTheme.shapes.medium,
            shadowElevation = 10.dp,
            tonalElevation = 2.dp,
            color = Color.Magenta
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Surface 1")
                Text(text = "Surface 2")
                Text(text = "Surface 3")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun MyBadges() {
    Column() {
        Badge() {
            Text("10")
        }
        Spacer(Modifier.size(20.dp))
        BadgedBox(badge = { Badge { Text(text = "1") } }, modifier = Modifier.padding(10.dp)) {
            Icon(imageVector = Icons.Default.Star, contentDescription = "")

        }
    }
}

/*
@Preview
@Composable
fun MyDropDownMenu() {
    var selectedText by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val series =
        listOf("Naruto", "The witcher", "The expanse", "The walking dead", "Stranger Things")

    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(value = selectedText, onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth()
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            series.forEach { serie ->
                DropdownMenuItem(onClick =
                { expanded = false
                    selectedText = serie
                }) {
                    Text(text = serie)
                }
            }
        }

    }
}
*/
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun MyDropDownMenu() {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            //.fillMaxSize()
            .wrapContentSize(Alignment.TopStart)
    ) {
        Row() {
            TextField(
                value = "Nombre",
                onValueChange = { expanded = true },
                modifier = Modifier
                    .clickable { expanded = true }
            )
            IconButton(onClick = { expanded = true }) {
                Icon(Icons.Default.MoreVert, contentDescription = "Localized description")
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    DropdownMenuItem(
                        text = { Text("Edit") },
                        onClick = { /* Handle edit! */ },
                        leadingIcon = {
                            Icon(
                                Icons.Outlined.Edit,
                                contentDescription = null
                            )
                        })
                    DropdownMenuItem(
                        text = { Text("Settings") },
                        onClick = { /* Handle settings! */ },
                        leadingIcon = {
                            Icon(
                                Icons.Outlined.Settings,
                                contentDescription = null
                            )
                        })
                    //HorizontalDivider()
                    DropdownMenuItem(
                        text = { Text("Send Feedback") },
                        onClick = { /* Handle send feedback! */ },
                        leadingIcon = {
                            Icon(
                                Icons.Outlined.Email,
                                contentDescription = null
                            )
                        },
                        trailingIcon = { Text("F11", textAlign = TextAlign.Center) })
                }
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun MyExposedDropDownMenu() {
    val options =
        listOf("Naruto", "The witcher", "The expanse", "The walking dead", "Stranger Things")
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf("") }
// We want to react on tap/press on TextField to show menu
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
    ) {
        TextField(
            // The `menuAnchor` modifier must be passed to the text field for correctness.
            modifier = Modifier.menuAnchor(),
            readOnly = true,
            value = selectedOptionText,
            onValueChange = {},
            label = { Text("Serie") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            colors = ExposedDropdownMenuDefaults.textFieldColors(),
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    text = { Text(selectionOption) },
                    onClick = {
                        selectedOptionText = selectionOption
                        expanded = false
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                )
            }
        }
    }
}