package com.udacity.shoestore.utils

import android.text.TextUtils
import androidx.databinding.InverseMethod

/**
 * Convert to Double.
 *
 * Solution provided here:
 *
 * Taken from: https://knowledge.udacity.com/questions/835693 Diraj Answer
 * https://stackoverflow.com/questions/38998222/android-two-way-binding-with-integer-type-causes-databinding-does-not-exist/60754728#60754728
 */
class DataBindingConverter {
    companion object {

        @InverseMethod("convertStringToDouble")
        @JvmStatic
        fun convertDoubleToString(value: String): Double {
            if (TextUtils.isEmpty(value)) {
                return 0.0
            }

            return value.toDouble()
        }

        @JvmStatic
        fun convertStringToDouble(value: Double?): String {
            return value?.toString() ?: ""
        }
    }
}