package ru.kram.galaxion.ui.utils

import android.util.Log

object LogG {
	private const val TAG = "Galaxion"

	fun d(tag: String, message: String) {
		Log.d(TAG, "$tag - $message")
	}

	fun e(tag: String, message: String) {
		Log.e(TAG, "$tag - $message")
	}

	fun i(tag: String, message: String) {
		Log.i(TAG, "$tag - $message")
	}

	fun w(tag: String, message: String) {
		Log.w(TAG, "$tag - $message")
	}

	fun v(tag: String, message: String) {
		Log.v(TAG, "$tag - $message")
	}

	fun wtf(tag: String, message: String) {
		Log.wtf(TAG, "$tag - $message")
	}
}