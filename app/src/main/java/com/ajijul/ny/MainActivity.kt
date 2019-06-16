package com.ajijul.ny

import android.content.DialogInterface
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.ajijul.ny.base.BaseActivity
import com.ajijul.ny.news_feed.view.NewsFeedListFragmentView

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentTransaction(NewsFeedListFragmentView(),"NewsFeed")
    }

    fun fragmentTransaction(fragment: Fragment, tag: String) {
        val ft = supportFragmentManager.beginTransaction()
        ft.setCustomAnimations(R.anim.slide_from_right, R.anim.slide_to_right)
        ft.add(R.id.nyMainActivity_flContainer, fragment)
        ft.addToBackStack(tag)
        ft.commit()
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent): Boolean {
        var back = false
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            back = true

            backStack()
        }
        return back

    }
    fun backStack() = try {
        val count = supportFragmentManager.backStackEntryCount
        if (count == 1) {
            askAndCloseApp()
        } else
            super.onBackPressed()
    } catch (e: IllegalArgumentException) {

        e.printStackTrace()

    }

    private fun askAndCloseApp() {

        // setup the alert builder
        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.Alert))
        builder.setMessage(getString(R.string.areYouSure))

        // add the buttons
        builder.setPositiveButton(getString(R.string.ok), object : DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                finishAndRemoveTask()
            }


        })
        builder.setNegativeButton(getString(R.string.cancel), null)

        // create and show the alert dialog
        val dialog = builder.create()
        dialog.show()
    }

}
