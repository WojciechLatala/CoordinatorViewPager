package com.example.coordinatortabsexample

import android.os.Bundle
import android.view.*
import com.google.android.material.appbar.CollapsingToolbarLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

/**
 * Minimal activity created from standard, new AndroidStudio project "ScrollingActivity".
 * To reproduce scrolling issue:
 * 1. Run the app.
 * 2. Content scrolls while scrolling on AppBar.
 * 3. Swipe ViewPager2 to get to the next page.
 * 4. Scrolling when touching AppBar is not working anymore.
 * 5. Scrolling on ViewPager2 enables scrolling on AppBar again.
 */
class ScrollingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
        setSupportActionBar(findViewById(R.id.toolbar))
        findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = title

        val viewPager2 = findViewById<ViewPager2>(R.id.view_pager2)
        viewPager2.adapter = SimpleFragmentStateAdapter(this)
    }
}

class SimpleFragmentStateAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 2
    override fun createFragment(position: Int): Fragment = ScrollingFragment()
}

class ScrollingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.content_scrolling, container, false)
}
