package com.proyek.jtk.ui.components

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.proyek.jtk.R
import com.proyek.jtk.ui.theme.JTKTheme
import com.proyek.jtk.ui.theme.Shapes

@Composable
fun RewardItem(
    imageUri: Uri?, // Menggunakan URI untuk gambar
    title: String,
    requiredPoint: Int,
    description: String, // Menambahkan deskripsi
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        // Menggunakan rememberImagePainter untuk memuat gambar dari URI
        imageUri?.let {
            Image(
                painter = rememberImagePainter(it),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(170.dp)
                    .clip(Shapes.medium)
            )
        } ?: run {
            // Jika imageUri null, gunakan gambar default
            Image(
                painter = painterResource(R.drawable.reward_13), // Gambar default
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(170.dp)
                    .clip(Shapes.medium)
            )
        }

        Text(
            text = title,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.ExtraBold
            )
        )
        Text(
            text = "Points: $requiredPoint", // Menambahkan format untuk points
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.secondary
        )
        Text(
            text = description, // Menampilkan deskripsi
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
@Preview(showBackground = true)
fun RewardItemPreview() {
    JTKTheme {
        RewardItem(
            imageUri = Uri.parse("https://www.example.com/image.jpg"), // Contoh image URI
            title = "Sepeda Anak",
            requiredPoint = 4000,
            description = "Ini adalah sepeda untuk anak-anak, sangat menyenangkan untuk bermain!"
        )
    }
}