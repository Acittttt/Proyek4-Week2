package com.proyek.jtk.model

import android.net.Uri
import com.proyek.jtk.R

object FakeRewardDataSource {
    val dummyRewards = listOf(
        Reward(1, Uri.parse("android.resource://com.proyek.jtk/drawable/reward_13"), "Reward 1", 200, "Deskripsi untuk Reward 1"),
        Reward(2, Uri.parse("android.resource://com.proyek.jtk/drawable/reward_13"), "Reward 2", 300, "Deskripsi untuk Reward 2"),
        Reward(3, Uri.parse("android.resource://com.proyek.jtk/drawable/reward_13"), "Reward 3", 400, "Deskripsi untuk Reward 3"),
        Reward(4, Uri.parse("android.resource://com.proyek.jtk/drawable/reward_13"), "Reward 4", 500, "Deskripsi untuk Reward 4"),
        Reward(5, Uri.parse("android.resource://com.proyek.jtk/drawable/reward_13"), "Reward 5", 600, "Deskripsi untuk Reward 5"),
        Reward(6, Uri.parse("android.resource://com.proyek.jtk/drawable/reward_13"), "Reward 6", 700, "Deskripsi untuk Reward 6"),
        Reward(7, Uri.parse("android.resource://com.proyek.jtk/drawable/reward_13"), "Reward 7", 800, "Deskripsi untuk Reward 7"),
        Reward(8, Uri.parse("android.resource://com.proyek.jtk/drawable/reward_13"), "Reward 8", 900, "Deskripsi untuk Reward 8"),
        Reward(9, Uri.parse("android.resource://com.proyek.jtk/drawable/reward_13"), "Reward 9", 1000, "Deskripsi untuk Reward 9"),
    )
}