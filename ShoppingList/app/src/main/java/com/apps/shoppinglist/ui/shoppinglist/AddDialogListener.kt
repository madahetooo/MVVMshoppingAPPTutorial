package com.apps.shoppinglist.ui.shoppinglist

import com.apps.shoppinglist.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}