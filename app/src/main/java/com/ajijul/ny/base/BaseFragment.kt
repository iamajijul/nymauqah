package com.ajijul.ny.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import dagger.android.support.DaggerFragment

open class BaseFragment : DaggerFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}