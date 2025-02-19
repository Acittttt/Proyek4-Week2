package com.proyek.jtk.ui.components

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
fun CartItem(
    rewardId: Long,
    image: Uri?, // Mengubah image menjadi Uri? (bukan Int lagi)
    title: String,
    totalPoint: Int,
    count: Int,
    onProductCountChanged: (id: Long, count: Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        // Menggunakan rememberImagePainter untuk memuat gambar dari Uri
        image?.let {
            Image(
                painter = rememberImagePainter(it), // Menggunakan rememberImagePainter untuk URI
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(90.dp)
                    .clip(Shapes.small)
            )
        } ?: run {
            // Jika image adalah null, gunakan gambar default
            Image(
                painter = rememberImagePainter(R.drawable.reward_13), // Gambar default jika Uri null
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(90.dp)
                    .clip(Shapes.small)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .weight(1.0f)
        ) {
            Text(
                text = title,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.ExtraBold
                )
            )
            Text(
                text = "Points: $totalPoint", // Menampilkan poin
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall,
            )
        }
        ProductCounter(
            orderId = rewardId,
            orderCount = count,
            onProductIncreased = { onProductCountChanged(rewardId, count + 1) },
            onProductDecreased = { onProductCountChanged(rewardId, count - 1) },
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun CartItemPreview() {
    // Menyediakan preview dengan contoh Uri dan data
    CartItem(
        rewardId = 4,
        image = Uri.parse("android.resource://com.proyek.jtk/drawable/reward_13"), // Contoh URI
        title = "Sepeda JTK",
        totalPoint = 4000,
        count = 0,
        onProductCountChanged = { rewardId, count -> }
    )
}