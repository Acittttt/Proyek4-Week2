package com.proyek.jtk.ui.screen.add

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import com.proyek.jtk.R
import com.proyek.jtk.model.Reward
import com.proyek.jtk.ui.theme.JTKTheme

@Composable
fun AddItemScreen(
    navigateBack: () -> Unit,
    navigateToHome: () -> Unit,
    addReward: (Reward) -> Unit // Fungsi untuk menambah reward
) {
    val context = LocalContext.current
    var itemName by remember { mutableStateOf("") }
    var itemPoint by remember { mutableStateOf("") }
    var itemDescription by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    // ActivityResultContract untuk memilih gambar dari galeri
    val pickImage = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        imageUri = uri // Menyimpan URI gambar yang dipilih
    }

    // Fungsi untuk memilih gambar
    val selectImage = {
        pickImage.launch("image/*") // Meluncurkan pemilih gambar
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Tambah Reward",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Input Nama Item
            OutlinedTextField(
                value = itemName,
                onValueChange = { itemName = it },
                label = { Text("Nama Item") },
                modifier = Modifier.fillMaxWidth()
            )

            // Input Point
            OutlinedTextField(
                value = itemPoint,
                onValueChange = { itemPoint = it },
                label = { Text("Point") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            // Input Deskripsi
            OutlinedTextField(
                value = itemDescription,
                onValueChange = { itemDescription = it },
                label = { Text("Deskripsi") },
                modifier = Modifier.fillMaxWidth(),
                maxLines = 3
            )

            // Tombol Pilih Gambar
            Button(
                onClick = { selectImage() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Pilih Gambar")
            }

            // Tombol Simpan
            Button(
                onClick = {
                    if (itemName.isNotBlank() && itemPoint.isNotBlank() && itemDescription.isNotBlank()) {
                        val newReward = Reward(
                            id = System.currentTimeMillis(), // ID bisa disesuaikan
                            image = imageUri, // Gambar yang dipilih pengguna
                            title = itemName,
                            requiredPoint = itemPoint.toInt(),
                            description = itemDescription // Menyimpan deskripsi yang dimasukkan
                        )
                        addReward(newReward) // Memanggil fungsi addReward untuk menyimpan data
                        Toast.makeText(context, "Reward berhasil ditambahkan!", Toast.LENGTH_SHORT).show()
                        navigateToHome() // Navigasi kembali ke halaman Home
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                Text("Simpan")
            }
        }
    }
}