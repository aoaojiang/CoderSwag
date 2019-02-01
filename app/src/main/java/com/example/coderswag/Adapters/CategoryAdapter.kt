/**
 * <p>Create Time: 2019年02月01日 10:34  </p>
 * <p>@author JIANG Pei     </p>
 **/
package com.example.coderswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.coderswag.Model.Category
import com.example.coderswag.R
import kotlinx.android.synthetic.main.activity_main.*

class CategoryAdapter(context: Context, categories: List<Category>) : BaseAdapter() {

    val context = context
    val categories = categories

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val categoryView: View
        val holder: ViewHolder

        if (convertView == null) {
            categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null)

            holder = ViewHolder()
            holder.categoryImage = categoryView.findViewById(R.id.categoryimage)
            holder.categoryName = categoryView.findViewById(R.id.categoryName)

            categoryView.tag = holder
//
//            val categoryImage: ImageView = categoryView.findViewById(R.id.categoryimage)
//            val categoryName: TextView = categoryView.findViewById(R.id.categoryName)
        } else {
            holder = convertView.tag as ViewHolder
            categoryView = convertView
        }


        val category = categories[position]
        holder.categoryName?.text = category.title

        val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
        holder.categoryImage?.setImageResource(resourceId)
        println(resourceId)

        return categoryView
    }

    override fun getItem(position: Int): Any {
        return categories[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return categories.count()
    }

    private class ViewHolder {
        var categoryImage: ImageView? = null
        var categoryName: TextView? = null
    }
}