package com.ajijul.ny.news_feed.repository

import junit.framework.Assert.assertEquals
import org.junit.Test
import java.io.InputStreamReader

class TestMockResponseFileReader(path: String)  {
    @Test
    fun `read simple file`(){
        val reader = MockResponseFileReader("test.json")
        assertEquals(reader.content, "success")
    }
}