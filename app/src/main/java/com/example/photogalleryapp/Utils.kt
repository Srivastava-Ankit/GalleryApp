package com.example.photogalleryapp

import android.app.ProgressDialog
import android.content.Context


class Utils {

    companion object{
        private var progress: ProgressDialog? = null
        private var context:Context? = null

        fun setContext(ctx: Context){
            context = ctx
        }
        fun showLoadingDialog() {
            if (progress == null) {
                progress = ProgressDialog(context)
                progress!!.setTitle("Loading")
                progress!!.setMessage("Wait while loading...")
            }
            progress!!.show()
        }

        fun dismissLoadingDialog() {
            if (progress != null && progress!!.isShowing) {
                progress!!.dismiss()
            }
        }
    }
}


