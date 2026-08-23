package smyerb.autoparts.smyerbautoroute.data.model

import androidx.annotation.StringRes
import smyerb.autoparts.smyerbautoroute.R

enum class ProductCategory(
    @field:StringRes val titleRes: Int,
) {
    BRAKES(R.string.vzbxv_category_brakes),
    ENGINE(R.string.vzbxv_category_engine),
    ELECTRICAL(R.string.vzbxv_category_electrical),
    CARE(R.string.vzbxv_category_care),
    ACCESSORIES(R.string.vzbxv_category_accessories),
}
