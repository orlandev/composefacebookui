package com.ondev.composefacebookui

import kotlin.random.Random

object FakePostRepository {
    fun getPosts(maxOfUser: Int): List<Post> {
        val posts = mutableListOf<Post>()

        for (i in 1..maxOfUser) {
            val post = Post(Random.nextInt(maxOfUser - 1),
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                "${Random.nextInt(1, 100)} min",
                Random.nextInt(1, 100),
                Random.nextInt(0, 100))
            posts.add(post)
        }

        return posts
    }
}