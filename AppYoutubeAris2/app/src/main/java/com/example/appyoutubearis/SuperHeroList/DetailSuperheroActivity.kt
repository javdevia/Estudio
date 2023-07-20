package com.example.appyoutubearis.SuperHeroList

import android.os.Bundle
import android.util.TypedValue
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.appyoutubearis.databinding.ActivityDetailSuperheroBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.roundToInt

class DetailSuperheroActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ID = "extra_id"
    }

    private lateinit var binding: ActivityDetailSuperheroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSuperheroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id = intent.getStringExtra(EXTRA_ID).orEmpty()
        getSuperheroInfo(id)
    }

    private fun getSuperheroInfo(id: String) {

        CoroutineScope(Dispatchers.IO).launch {
            val superHeroDetail = getRetrofit().create(ApiService::class.java).getSuperheroeId(id)

            if (superHeroDetail.body() != null) {
                runOnUiThread { createUI(superHeroDetail.body()!!) }
            }
        }
    }

    private fun createUI(superhero: SuperheroDetailResponse) {
        Picasso.get().load(superhero.image.url).into(binding.ivSuperheroDetailImage)
        binding.tvSuperheroName.text = superhero.name
        prepareStats(superhero.powerstats)
        binding.tvSuperheroRealName.text=superhero.biography.fullName
        binding.tvSuperheroPublisher.text=superhero.biography.publisher
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun prepareStats(powerStats: PowerStatsResponse) {
        updateHeighs(binding.viewIntelligence, powerStats.intelligence)
        updateHeighs(binding.viewStrength, powerStats.strength)
        updateHeighs(binding.viewSpeed, powerStats.speed)
        updateHeighs(binding.viewDurability, powerStats.durability)
        updateHeighs(binding.viewPower, powerStats.power)
        updateHeighs(binding.viewCombat, powerStats.combat)
    }

    private fun updateHeighs(view: View, stat: String) {
        val params = view.layoutParams
        params.height = pxToDp(stat.toFloat())
        view.layoutParams = params
    }

    private fun pxToDp(px: Float) =
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, resources.displayMetrics)
            .roundToInt()

}
